package com.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.oa.manager.OrgManager;
import com.oa.model.Organization;
import com.oa.web.PagerModel;
import com.oa.web.forms.OrgActionForm;

/**
 * 机构Action
 * @author Administrator
 *
 */
public class OrgAction extends BaseAction{
	
	private OrgManager orgManager;

	/**
	 * 打开机构管理主界面
	 */
	public ActionForward orgList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OrgActionForm oaf = (OrgActionForm)form;
		
		int parentId = oaf.getParentId();
		
		PagerModel pm = orgManager.searchOrgs(parentId);
		
		request.setAttribute("pm", pm);
		
		int ppid=0;
		if(oaf.getParentId()!=0) {
			Organization org = orgManager.findOrg(oaf.getParentId());
			Organization parent = org.getParent();
			if(parent!=null) {
				ppid =parent.getId();
			}
		}
		request.setAttribute("ppid",ppid);
		
		if(oaf.isSelect()){
			return mapping.findForward("select_org");
		}
		
		return mapping.findForward("org_list");
	}
	
	
	
	/**
	 * 打开机构管理录入界面
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
	 * 添加机构信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OrgActionForm oaf = (OrgActionForm)form;
		int parentId = oaf.getParentId();
		Organization org = new Organization();
		
		BeanUtils.copyProperties(org, oaf);
		orgManager.addOrg(org, parentId);
		request.setAttribute("skipUrl",oaf.getSkipUrl());
		return mapping.findForward("pub_add_success");
	}
	
	/**
	 * 删除机构信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OrgActionForm oaf = (OrgActionForm)form;
		int id = oaf.getId();
		
		orgManager.deleteOrg(id);
		request.setAttribute("skipUrl",oaf.getSkipUrl());
		return mapping.findForward("pub_del_success");
	}
	
	public OrgManager getOrgManager() {
		return orgManager;
	}

	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}
}
