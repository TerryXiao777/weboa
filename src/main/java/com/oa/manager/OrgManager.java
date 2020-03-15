package com.oa.manager;

import java.util.List;

import com.oa.model.Organization;
import com.oa.web.PagerModel;

public interface OrgManager {
	/**
	 * 添加机构信息
	 * @param organization
	 */
	void addOrg(Organization organization,int parentId);
	
	/**
	 * 删除机构信息
	 * @param orgId
	 */
	void deleteOrg(int orgId);
	
	/**
	 * 更新机构信息
	 * @param organization
	 * @param parentId
	 */
	void updateOrg(Organization organization,int parentId);
	
	/**
	 * 查询机构信息<br>
	 * 如果parentId为0,则查询顶级机构列表
	 * @param orgId
	 * @return
	 */
	Organization findOrg(int orgId);
	
	/**
	 * 查询机构列表
	 * @param parentId
	 * @return
	 */
	List<Organization> findOrgs(int parentId);
	
	/**
	 * 根据父机构标识查询其下的子机构列表
	 * 如果parentId为0，则查询顶级机构列表
	 * @param parentId 父机构标识
	 * @return 集合的元素是Organization对象
	 */
	public PagerModel searchOrgs(int parentId);
}
