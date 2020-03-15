package com.oa.web.forms;

import org.apache.struts.action.ActionForm;


public class OrgActionForm extends ActionForm{
	
	private static final long serialVersionUID = -2191698343527720789L;

	private int id;
	
	private String name;
	
	private String sn;
	
	private String description;
	
	private int parentId;
	
	private String skipUrl;
	
	/**
	 * 一个搜索机构列表的标识位
	 * 如果取值为false,则返回机构管理的主界面
	 * 如果取值为true，则返回机构的选择界面
	 */
	private boolean select;
	
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

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getSkipUrl() {
		return skipUrl;
	}

	public void setSkipUrl(String skipUrl) {
		this.skipUrl = skipUrl;
	}
	
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
}
