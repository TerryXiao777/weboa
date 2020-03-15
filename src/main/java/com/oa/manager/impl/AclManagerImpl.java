package com.oa.manager.impl;

import java.util.List;

import com.oa.manager.AclManager;

public class AclManagerImpl extends AbstractManager implements AclManager{

	@Override
	public void addOrUpdatePermission(String principalType, int principalId, int moduleId, int permission,
			boolean yes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delPermission(String principalType, int principalId, int moduleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOrUpdateUserExtends(int userId, int moduleId, boolean yes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasPermission(int userId, int moduleId, int permission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPermissionByResourceSn(int userId, String reourceSn, int permission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List searchModules(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List searchAclRecord(String principalType, int principalId) {
		// TODO Auto-generated method stub
		return null;
	}

}
