package com.oa.manager;

import com.oa.model.Role;
import com.oa.web.PagerModel;

public interface RoleManager {
	/**
	 * 添加角色
	 * @param role
	 */
	public void addRole(Role role);
	/**
	 * 删除角色
	 * @param roleId
	 */
	public void delRole(int roleId);
	/**
	 * 更新角色
	 * @param role
	 */
	public void updateRole(Role role);
	/**
	 * 查找角色
	 * @param roleId
	 * @return
	 */
	public Role findRole(int roleId);
	/**
	 * 分页查询角色的信息
	 * @return
	 */
	public PagerModel searchRoles();
}
