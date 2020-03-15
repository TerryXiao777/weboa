package com.oa.manager;

import com.oa.model.Module;
import com.oa.web.PagerModel;

/**
 * 
 * @author Administrator
 *
 */
public interface ModuleManager {
	/**
	 * 添加模块信息，如果父模块的ID为0，则添加顶级模块
	 * @param module 模块信息
	 * @param parentId 父模块ID
	 */
	public void addModule(Module module,int parentId);
	/**
	 * 删除模块
	 * @param moduleId
	 */
	public void deleteModule(int moduleId);
	/**
	 * 更新模块
	 * @param module
	 * @param parentId
	 */
	public void updateModule(Module module,int parentId);
	/**
	 * 查询特定的模块
	 * @param moduleId
	 * @return
	 */
	public Module findModule(int moduleId);
	
	/**
	 * 分页查询模块列表
	 * @param parentId
	 * @return
	 */
	public PagerModel searchModules(int parentId);
}
