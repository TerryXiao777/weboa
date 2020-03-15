package com.oa.manager;

import com.oa.model.Person;
import com.oa.web.PagerModel;

/**
 * 人员信息接口
 * @author Administrator
 *
 */
public interface PersonManager {
	/**
	 * 搜索所有人员信息
	 * @return
	 */
	PagerModel searchPersons();
	
	/**
	 * 搜索某个机构下的人员列表
	 * @param orgId
	 * @return
	 */
	PagerModel searchPersons(int orgId);
	
	/**
	 * 查找特定人员信息
	 * @param personId
	 * @return
	 */
	Person findPerson(int personId);
	
	/**
	 * 添加人员信息
	 * orgId不允许为0，即一个人员必须属于某个机构
	 * @param person
	 * @param orgId 
	 */
	void addPerson(Person person,int orgId);
	
	/**
	 * 更新人员信息
	 * @param person
	 * @param orgId
	 */
	void updatePerson(Person person,int orgId);
	
	/**
	 * 删除人员信息
	 * @param personId
	 */
	void deletePerson(int personId);
}
