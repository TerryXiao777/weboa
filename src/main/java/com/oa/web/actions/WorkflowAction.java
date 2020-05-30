package com.oa.web.actions;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.dom4j.io.SAXReader;

import com.oa.manager.WorkflowManager;
import com.oa.model.Workflow;
import com.oa.web.forms.WorkflowActionForm;

public class WorkflowAction extends BaseAction {
	private WorkflowManager workflowManager;

	public ActionForward workFlowList(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 获取所有流程信息进行显示
		request.setAttribute("workflows", workflowManager.searchAllWorkflows());

		return mapping.findForward("workflow_list");

	}

	// 上传流程定义和流程图片的信息
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		WorkflowActionForm waf = (WorkflowActionForm) form;

		if (waf.getProcessDef() != null && waf.getProcessImage() != null) {
			workflowManager.addOrUpdateWorkflow(waf.getProcessDef().getFileData(), waf.getProcessImage().getFileData());

		}

		return mapping.findForward("add_success");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		WorkflowActionForm waf = (WorkflowActionForm) form;
		workflowManager.deleteWorkflow(waf.getId());
		return mapping.findForward("pub_del_success");
	}

	// 打开查看流程图片的界面
	public ActionForward viewImage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		WorkflowActionForm waf = (WorkflowActionForm) form;
		Workflow workflow = workflowManager.findWorkflow(waf.getId());
		request.setAttribute("workflow", workflow);
		return mapping.findForward("view_image");
	}

	// 获取流程图片信息进行显示
	public ActionForward image(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		WorkflowActionForm waf = (WorkflowActionForm) form;
		Workflow workflow = workflowManager.findWorkflow(waf.getId());

		byte[] processImage = workflow.getProcessImage();

		response.setContentType("image/jpeg");
		response.getOutputStream().write(processImage);

		return null;
	}

	// 查看流程定义界面
	public ActionForward viewDef(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		WorkflowActionForm waf = (WorkflowActionForm) form;
		Workflow workflow = workflowManager.findWorkflow(waf.getId());
		request.setAttribute("workflow", workflow);
		byte[] processDef = workflow.getProcessDef();

		String def = new SAXReader().read(new ByteArrayInputStream(processDef)).asXML();

		request.setAttribute("def", def);

		return mapping.findForward("view_def");
	}

	public WorkflowManager getWorkflowManager() {
		return workflowManager;
	}

	public void setWorkflowManager(WorkflowManager workflowManager) {
		this.workflowManager = workflowManager;
	}
}
