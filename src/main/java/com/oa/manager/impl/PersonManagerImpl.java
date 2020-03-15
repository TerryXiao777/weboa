package com.oa.manager.impl;

import com.oa.manager.PersonManager;
import com.oa.model.Organization;
import com.oa.model.Person;
import com.oa.web.PagerModel;

/**
 * 人员信息接口实现
 * @author Administrator
 *
 */
public class PersonManagerImpl extends AbstractManager implements PersonManager{

	@Override
	public PagerModel searchPersons() {
		return searchPaginated("from Person");
	}

	@Override
	public PagerModel searchPersons(int orgId) {
		return searchPaginated("select p from Person p where p.org.id = "+orgId);
	}

	@Override
	public Person findPerson(int personId) {
		return (Person)getHibernateTemplate().load(Person.class, personId);
	}

	@Override
	public void addPerson(Person person, int orgId) {
		if(orgId != 0){
			person.setOrg((Organization)this.getHibernateTemplate().load(Organization.class, orgId));
		}
		getHibernateTemplate().save(person);
		
	}

	@Override
	public void updatePerson(Person person, int orgId) {
		if(orgId != 0){
			person.setOrg((Organization)this.getHibernateTemplate().load(Organization.class, orgId));
		}
		getHibernateTemplate().update(person);
		
	}

	@Override
	public void deletePerson(int personId) {
		getHibernateTemplate().delete(findPerson(personId));
	}

}
