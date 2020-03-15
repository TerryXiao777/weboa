package com.oa.manager;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oa.manager.OrgManager;
import com.oa.model.Organization;

import junit.framework.TestCase;

public class OrgManagerTest extends TestCase{
	private static BeanFactory bean = new ClassPathXmlApplicationContext("applicationContext-*.xml");
	public void testAddOrg() {
		OrgManager orgManager = (OrgManager)bean.getBean("orgManager");
		Organization organization = new Organization();
		organization.setName("测试机构");
		organization.setDescription("测试机构描述");
		orgManager.addOrg(organization, 0);
	}
}
