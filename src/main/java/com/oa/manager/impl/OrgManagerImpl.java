package com.oa.manager.impl;

import java.util.List;


import com.oa.exception.SystemException;
import com.oa.manager.OrgManager;
import com.oa.model.Organization;
import com.oa.web.PagerModel;

public class OrgManagerImpl extends AbstractManager implements OrgManager{

	@Override
	public void addOrg(Organization organization, int parentId) {
		if(parentId != 0) {
			organization.setParent((Organization)getHibernateTemplate().load(Organization.class, parentId));
		}
		getHibernateTemplate().save(organization);
		
		organization.setSn(organization.getParent() == null? (""+organization.getId()) :(organization.getParent().getSn()+"_"+organization.getId()));
	}

	@Override
	public void deleteOrg(int orgId) {
		Organization org = (Organization)findOrg(orgId);
		//先判断是否存在子机构，如果存在子机构则不可以删除
		if(org.getChildren().size()>0) {
			throw new SystemException("org.suborg.not.null",org.getName(),"机构【"+org.getName()+"】下面存在子机构信息，不允许删除！");
		}
		getHibernateTemplate().delete(org);
	}

	@Override
	public void updateOrg(Organization organization, int parentId) {
		if(parentId != 0) {
			organization.setParent((Organization)getHibernateTemplate().load(Organization.class, parentId));
		}
		getHibernateTemplate().update(organization);
	}

	@Override
	public Organization findOrg(int orgId) {
		return (Organization)getHibernateTemplate().load(Organization.class, orgId);
	}

	@Override
	public List<Organization> findOrgs(int parentId) {
		//如果parentId=0，则查找顶级机构列表
		if(parentId == 0) {
			return getHibernateTemplate().find("from Organization o where o.parent is null");
		}
		return getHibernateTemplate().find("from Organization o where o.parent.id = ?", parentId);
	}

	@Override
	public PagerModel searchOrgs(int parentId) {
		String selectHql = "select o from Organization o where o.parent is null";
		if(parentId != 0){
			selectHql = "select o from Organization o where o.parent.id = "+parentId;
		}
		
		return searchPaginated(selectHql);
	}

}
