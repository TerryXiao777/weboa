package com.oa.manager.impl;

import java.util.List;

import com.oa.manager.JbpmFacade;
import com.oa.manager.WorkflowManager;
import com.oa.model.Workflow;

public class WorkflowManagerImpl extends AbstractManager implements WorkflowManager{
	
	private JbpmFacade jbpmFacade;
	
	@Override
	public void addOrUpdateWorkflow(byte[] processDef, byte[] processImage) {
		String workflowName = jbpmFacade.deployProcessDefinition(processDef);
		
		//首先根据流程名称，查询是否已有Workflow对象
		Workflow wf = (Workflow)getSession().createQuery("select w from Workflow w where w.name = ?")
			.setParameter(0, workflowName)
			.uniqueResult();
		if(wf == null){
			wf = new Workflow();
			wf.setName(workflowName);
			wf.setProcessDef(processDef);
			wf.setProcessImage(processImage);
			getHibernateTemplate().save(wf);
		}
		else{
			wf.setProcessDef(processDef);
			wf.setProcessImage(processImage);
			getHibernateTemplate().update(wf);
		}
		
	}

	@Override
	public void deleteWorkflow(int workflowId) {
		Workflow wf = findWorkflow(workflowId);
		jbpmFacade.deleteProcessDefinition(wf.getName());
		getHibernateTemplate().delete(wf);
	}

	@Override
	public Workflow findWorkflow(int workflowId) {
		return (Workflow)getHibernateTemplate().load(Workflow.class, workflowId);
	}

	@Override
	public List searchAllWorkflows() {
		return getHibernateTemplate().find("from Workflow");
	}
	
	public JbpmFacade getJbpmFacade() {
		return jbpmFacade;
	}

	public void setJbpmFacade(JbpmFacade jbpmFacade) {
		this.jbpmFacade = jbpmFacade;
	}
	
}
