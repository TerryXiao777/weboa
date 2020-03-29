package com.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class RoleActionForm extends ActionForm{
	
	private static final long serialVersionUID = -4475261998437436664L;

	private int id;
	
	private String name;
	
	private String skipUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getSkipUrl() {
		return skipUrl;
	}

	public void setSkipUrl(String skipUrl) {
		this.skipUrl = skipUrl;
	}

}
