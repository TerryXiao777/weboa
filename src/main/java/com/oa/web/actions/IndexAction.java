package com.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.oa.model.User;

public class IndexAction extends BaseAction{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) throws Exception {
		//添加权限判断的代码
		User user = currentUser(request);
		if(user == null){
			return mapping.findForward("loginPage");
		}
		
		//继续父类的职责，即将请求分发到不同的方法中！
		//return super.execute(mapping, form, request, response);
		return mapping.findForward("index");
	}
	
}
