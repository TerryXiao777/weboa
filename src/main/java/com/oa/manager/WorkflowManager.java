package com.oa.manager;

import java.util.List;

import com.oa.model.Workflow;

public interface WorkflowManager {
	public void addOrUpdateWorkflow(byte[] processDef,byte[] processImage);
	public void deleteWorkflow(int workflow);
	public Workflow findWorkflow(int workflow);
	public List searchAllWorkflows();
}
