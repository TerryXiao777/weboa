package com.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.oa.exception.SystemException;
import com.oa.manager.ModuleManager;
import com.oa.manager.RoleManager;
import com.oa.manager.UserManager;
import com.oa.model.ACL;
import com.oa.web.PagerModel;
import com.oa.web.SystemContext;
import com.oa.web.forms.AclActionForm;

public class AclAction extends DispatchAction{
	private ModuleManager moduleManager;
	private RoleManager roleManager;
	private UserManager userManager;
	
	public ActionForward aclOperate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		AclActionForm aaf = (AclActionForm)form;
		if(ACL.TYPE_ROLE.equals(aaf.getPrincipalType())){
			request.setAttribute("role", roleManager.findRole(aaf.getPrincipalId()));
		}
		else if(ACL.TYPE_USER.equals(aaf.getPrincipalType())){
			request.setAttribute("user", userManager.findUser(aaf.getPrincipalId()));
		}
		else{
			throw new SystemException("无效的主体类型！！");
		}
		
		//获得所有模块列表
		SystemContext.setOffset(0);
		SystemContext.setPagesize(Integer.MAX_VALUE);
		PagerModel pm = moduleManager.searchModules(0);
		
		request.setAttribute("modules", pm.getDatas());
		
		return mapping.findForward("acl_operate");
	}
	
	public void setModuleManager(ModuleManager moduleManager) {
		this.moduleManager = moduleManager;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
