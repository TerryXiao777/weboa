package com.oa.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.oa.constant.Permission;
import com.oa.manager.AclManager;
import com.oa.model.ACL;

public class AclManagerImpl extends AbstractManager implements AclManager{

	@Override
	public void addOrUpdatePermission(String principalType, int principalId, int moduleId, int permission,
			boolean yes) {
		//查找ACL对象
		ACL acl = findACL(principalType, principalId, moduleId);
		
		//能够找到ACL对象，更新permission
		if(acl != null){
			acl.setPermission(permission, yes);
			getHibernateTemplate().update(acl);
			return;
		}
		
		//找不到ACL对象，则创建ACL对象，并更新permission
		acl = new ACL();
		acl.setPrincipalType(principalType);
		acl.setPrincipalId(principalId);
		acl.setModuleId(moduleId);
		acl.setPermission(permission, yes);
		getHibernateTemplate().save(acl);
		
	}

	@Override
	public void deletePermission(String principalType, int principalId, int moduleId) {
		getHibernateTemplate().delete(findACL(principalType, principalId, moduleId));
		
	}

	@Override
	public void addOrUpdateUserExtends(int userId, int moduleId, boolean yes) {
		ACL acl = findACL(ACL.TYPE_USER,userId,moduleId);
		if(acl != null){
			acl.setExtends(yes);
			getHibernateTemplate().update(acl);
			return;
		}
		acl = new ACL();
		acl.setPrincipalType(ACL.TYPE_USER);
		acl.setPrincipalId(userId);
		acl.setModuleId(moduleId);
		acl.setExtends(yes);
		getHibernateTemplate().save(acl);
		
	}

	@Override
	public boolean hasPermission(int userId, int moduleId, int permission) {
		//根据用户标识和模块标识查找授权记录
		ACL acl = findACL(ACL.TYPE_USER,userId,moduleId);
		
		//有授权记录
		if(acl != null){
			int yesOrNo = acl.getPermission(permission);
			
			//如果是确定的授权
			if(yesOrNo != ACL.ACL_NEUTRAL){
				
				//立刻返回，无需继续查找
				return yesOrNo == ACL.ACL_YES ? true : false;
			}
		}
		
		//继续查找用户拥有的角色的授权
		
		//查找分配给用户的角色，按优先级从高到低排序
		String hql = "select r.id from UsersRoles ur join ur.role r join ur.user u " +
				"where u.id = ? order by ur.orderNo";
		List roleIds = getHibernateTemplate().find(hql,userId);
		
		//依次根据角色标识和模块标识查找授权记录
		for (Iterator iterator = roleIds.iterator(); iterator.hasNext();) {
			Integer rid = (Integer) iterator.next();
			acl = findACL(ACL.TYPE_ROLE, rid, moduleId);
			if(acl != null){
				return acl.getPermission(permission) == ACL.ACL_YES ? true : false;
			}
		}
		
		return false;
	}

	@Override
	public boolean hasPermissionByResourceSn(int userId, String resourceSn, int permission) {
		String hql = "select m.id from Module m where m.sn = ? ";
		
		return hasPermission(
				userId,
				(Integer)getSession().createQuery(hql).setParameter(0, resourceSn).uniqueResult(),
				permission);
	}

	@Override
	public List searchModules(int userId) {
		//查找用户拥有的角色，并按优先级从低到高排序
		String hql = "select r.id from UsersRoles ur join ur.role r join ur.user u " +
			"where u.id = ? order by ur.orderNo desc";
		List roleIds = getHibernateTemplate().find(hql,userId);
		
		Map temp = new HashMap();
		
		//依次查找角色的授权（ACL对象）
		for (Iterator iterator = roleIds.iterator(); iterator.hasNext();) {
			Integer rid = (Integer) iterator.next();
			List acls = findRoleAcls(rid);
			for (Iterator iterator2 = acls.iterator(); iterator2.hasNext();) {
				ACL acl = (ACL) iterator2.next();
				temp.put(acl.getModuleId(), acl);
			}
		}
		
		//针对用户查找有效的用户授权
		List acls = findUserAcls(userId);
		for (Iterator iterator = acls.iterator(); iterator.hasNext();) {
			ACL acl = (ACL) iterator.next();
			temp.put(acl.getModuleId(), acl);
		}
		
		//去除掉那些没有读取权限的授权记录
		Set entries = temp.entrySet();
		for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			ACL acl = (ACL)entry.getValue();
			if(acl.getPermission(Permission.READ) != ACL.ACL_YES){
				iterator.remove();
			}
		}
		
		if(temp.isEmpty()){
			return new ArrayList();
		}
		
		String searchModules = "select m from Module m where m.id in (:ids)";
		
		return getSession()
			.createQuery(searchModules)
			.setParameterList("ids", temp.keySet())
			.list();
	}

	@Override
	public List searchAclRecord(String principalType, int principalId) {
		String sql = "select moduleId,aclState&1,aclState&2,aclState&4,aclState&8,aclTriState " +
				"from t_acl where principalType = '"+principalType+"' and principalId = "+principalId;
		return getSession().createSQLQuery(sql).list();
	}
	
	/**
	 * 查找授权记录，如果找不到，返回空值
	 * @param principalType
	 * @param principalId
	 * @param moduleId
	 * @return
	 */
	private ACL findACL(String principalType,int principalId,int moduleId){
		return (ACL)getSession().createQuery(
				"select acl from ACL acl where acl.principalType = ? " +
				"and acl.principalId=? and acl.moduleId = ?")
				.setParameter(0, principalType)
				.setParameter(1, principalId)
				.setParameter(2, moduleId)
				.uniqueResult();
	}
	
	private List findRoleAcls(int roleId){
		return getHibernateTemplate().find(
				"select acl from ACL acl where acl.principalType = ? " +
				"and acl.principalId = ?",
				new Object[]{ACL.TYPE_ROLE,roleId}
		);
	}
	
	private List findUserAcls(int userId){
		return getHibernateTemplate().find(
				"select acl from ACL acl where acl.principalType = ? " +
				"and acl.principalId = ? and acl.aclTriState = ? ",
				new Object[]{ACL.TYPE_USER,userId,ACL.ACL_TRI_STATE_UNEXTENDS}
		);		
	}

}
