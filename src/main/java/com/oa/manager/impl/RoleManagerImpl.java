package com.oa.manager.impl;

import com.oa.manager.RoleManager;
import com.oa.model.Role;
import com.oa.web.PagerModel;

public class RoleManagerImpl extends AbstractManager implements RoleManager{

	@Override
	public void addRole(Role role) {
		getHibernateTemplate().save(role);
	}

	@Override
	public void delRole(int roleId) {
		getHibernateTemplate().delete(findRole(roleId));
	}

	@Override
	public void updateRole(Role role) {
		getHibernateTemplate().update(role);
	}

	@Override
	public Role findRole(int roleId) {
		return (Role)getHibernateTemplate().load(Role.class, roleId);
	}

	@Override
	public PagerModel searchRoles() {
		return searchPaginated("from Role");
	}

}
