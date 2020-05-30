package com.oa.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.oa.manager.DocumentManager;
import com.oa.manager.JbpmFacade;
import com.oa.model.ApproveInfo;
import com.oa.model.Document;
import com.oa.model.User;
import com.oa.model.Workflow;
import com.oa.web.PagerModel;

public class DocumentManagerImpl extends AbstractManager implements DocumentManager{

	private JbpmFacade jbpmFacade;
	
	public JbpmFacade getJbpmFacade() {
		return jbpmFacade;
	}

	public void setJbpmFacade(JbpmFacade jbpmFacade) {
		this.jbpmFacade = jbpmFacade;
	}

	@Override
	public void addDocument(Document document, int workflowId, int userId, Map props) {
		//保存公文信息
		document.setWorkflow((Workflow)getHibernateTemplate().load(Workflow.class, workflowId));
		document.setCreator((User)getHibernateTemplate().load(User.class, userId));
		document.setStatus(Document.STATUS_NEW);
		document.setCreateTime(new Date());
		
		//设置其它属性
		document.setPropertiesMap(props);
		
		getHibernateTemplate().save(document);
		
		//添加流程实例
		long processInstanceId = jbpmFacade.addProcessInstance(document.getWorkflow().getName(), document);
		
		//绑定流程实例的标识到公文对象
		document.setProcessInstanceId(processInstanceId);
		getHibernateTemplate().update(document);
		
	}

	@Override
	public void updateDocument(Document document, int workflowId, int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Document findDocument(int documentId) {
		return (Document)getHibernateTemplate().load(Document.class, documentId);
	}

	@Override
	public PagerModel searchMyDocuments(int userId) {
		return searchPaginated("select d from Document d where d.creator.id = ?", userId);
	}

	@Override
	public void deleteDocument(int documentId) {
		Document document = (Document)getHibernateTemplate().load(Document.class, documentId);
		
		//删除公文信息
		getHibernateTemplate().delete(document);
		
		//删除流程实例
		jbpmFacade.deleteProcessInstance(document.getProcessInstanceId());
		
	}

	@Override
	public void addApproveInfo(ApproveInfo approveInfo, int documentId, int approverId, boolean back) {
		Document doc = (Document)getHibernateTemplate().load(Document.class, documentId);
		User user = (User)getHibernateTemplate().load(User.class, approverId);
		approveInfo.setDocument(doc);
		approveInfo.setApprover(user);
		getHibernateTemplate().save(approveInfo);
		
		//如果是驳回，则返回上一个节点
		if(back){
			Object[] os = jbpmFacade.backStep(doc.getProcessInstanceId(), user.getUsername());
			doc.setStatus((String)os[0]);
			doc.setProcessInstanceId((Long)os[1]);
			getHibernateTemplate().update(doc);
		}		
		
	}

	@Override
	public PagerModel searchApprovedDocuments(int userId) {
		return searchPaginated("select distinct ai.document from ApproveInfo ai where ai.approver.id = ?",userId);
	}

	@Override
	public List searchApproveInfos(int documentId) {
		return getHibernateTemplate().find("from ApproveInfo ai where ai.document.id = ?", documentId);
	}

	@Override
	public List searchApprovingDocuments(int userId) {
		User user = (User)getHibernateTemplate().load(User.class, userId);
		
		//搜索已流转到用户那里的公文标识列表
		List docIds = jbpmFacade.searchMyTaskList(user.getUsername());
		
		if(docIds == null || docIds.isEmpty()){
			return null;
		}
		
		//根据公文标识查找所有的公文对象
		return getSession()
			.createQuery("select d from Document d where d.id in (:ids)")
			.setParameterList("ids", docIds)
			.list();
	}

	@Override
	public List searchNextSteps(int documentId, int userId) {
		Document doc = findDocument(documentId);
		User user = (User)getHibernateTemplate().load(User.class, userId);
		String username = user.getUsername();
		
		return jbpmFacade.searchNextTransitions(doc.getProcessInstanceId(), username);
	}

	@Override
	public void submitToWorkflow(int userId, int documentId, String transistionName) {
		User user = (User)getHibernateTemplate().load(User.class, userId);
		String username = user.getUsername();
		
		Document document = (Document)getHibernateTemplate().load(Document.class, documentId);
		long processInstanceId = document.getProcessInstanceId();
		
		String status = jbpmFacade.nextStep(processInstanceId,username,  transistionName);
		
		document.setStatus(status);
		getHibernateTemplate().update(document);
	}
	
}
