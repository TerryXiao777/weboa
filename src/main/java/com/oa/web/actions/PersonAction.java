package com.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.oa.manager.PersonManager;
import com.oa.model.Person;
import com.oa.web.forms.PersonActionForm;

/**
 * 人员Action
 * @author Administrator
 *
 */
public class PersonAction extends DispatchAction{
	private PersonManager personManager;
	
	public ActionForward personList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setAttribute("pm",personManager.searchPersons());
		return mapping.findForward("person_list");
	}
	
	/**
	 * 打开人员管理录入界面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exceptio
	 */
	public ActionForward addInput(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("add_input");
	}
	
	/**
	 * 添加人员信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PersonActionForm paf = (PersonActionForm)form;
		Person person = new Person();
		BeanUtils.copyProperties(person, paf);
		personManager.addPerson(person, paf.getOrgId());
		request.setAttribute("skipUrl",paf.getSkipUrl());
		return mapping.findForward("pub_add_success");
	}
	
	public ActionForward updateInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		PersonActionForm paf = (PersonActionForm)form;
		
		Person person = personManager.findPerson(paf.getId());
		request.setAttribute("person", person);
		
		return mapping.findForward("update_input");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonActionForm paf = (PersonActionForm)form;
		Person person = new Person();
		BeanUtils.copyProperties(person, paf);
		personManager.updatePerson(person, paf.getOrgId());
		
		return mapping.findForward("pub_update_success");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PersonActionForm paf = (PersonActionForm)form;
		personManager.deletePerson(paf.getId());
		
		request.setAttribute("skipUrl",paf.getSkipUrl());
		return mapping.findForward("pub_del_success");
	}

	public PersonManager getPersonManager() {
		return personManager;
	}

	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
}
