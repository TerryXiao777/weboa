package com.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.oa.manager.UserManager;
import com.oa.model.User;
import com.oa.web.forms.UserActionForm;

/**
 * 登录
 * @author Administrator
 *
 */
public class LoginAction extends DispatchAction{
	private UserManager userManager;
	
	public ActionForward loginPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("loginPage");
	}
	
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserActionForm uaf = (UserActionForm)form;
		String username = uaf.getUsername();
		String password = uaf.getPassword();
		User user= userManager.login(username, password);
		if(user != null){
			request.getSession().setAttribute("login", user);
		}
		return mapping.findForward("index");
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
