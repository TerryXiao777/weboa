package com.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class AclActionForm extends ActionForm{
	private static final long serialVersionUID = -728979212941157467L;

	private String principalType;
	
	private int principalId;

	public String getPrincipalType() {
		return principalType;
	}

	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}

	public int getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}
}
