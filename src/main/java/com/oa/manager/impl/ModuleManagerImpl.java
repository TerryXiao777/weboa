package com.oa.manager.impl;

import com.oa.exception.SystemException;
import com.oa.manager.ModuleManager;
import com.oa.model.Module;
import com.oa.web.PagerModel;

public class ModuleManagerImpl extends AbstractManager implements ModuleManager{

	@Override
	public void addModule(Module module, int parentId) {
		if(parentId!=0) {
			module.setParent((Module)getHibernateTemplate().load(Module.class, parentId));
		}
		getHibernateTemplate().save(module);
	}

	@Override
	public void deleteModule(int moduleId) {
		Module module = (Module)findModule(moduleId);
		
		if(module.getChildren().size() > 0){
			throw new SystemException("模块【"+module.getName()+"】存在有子模块，不允许删除！");
		}
		
		getHibernateTemplate().delete(module);
	}

	@Override
	public void updateModule(Module module, int parentId) {
		if(parentId != 0){
			module.setParent(findModule(parentId));
		}
		getHibernateTemplate().update(module);
	}

	@Override
	public Module findModule(int moduleId) {
		return (Module)getHibernateTemplate().load(Module.class,moduleId);
	}

	@Override
	public PagerModel searchModules(int parentId) {
		String hql = "select m from Module m";
		
		if(parentId == 0){
			//返回顶级模块列表
			hql = hql + " where m.parent is null";
		}
		else{
			hql = hql + " where m.parent.id = "+parentId;
		}
		
		return searchPaginated(hql);
	}

}
