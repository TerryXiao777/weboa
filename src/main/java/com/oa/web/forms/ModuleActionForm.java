package com.oa.web.forms;

import org.apache.struts.action.ActionForm;

public class ModuleActionForm extends ActionForm{
	
	private static final long serialVersionUID = 5414399889766843131L;

	private int id;
	/**
	 * 模块名称
	 */
	private String name;
	/**
	 * 模块编号
	 */
	private String sn;
	/**
	 * 模块入口地址
	 */
	private String url;
	/**
	 * 模块的排序号
	 */
	private int orderNo;
	
	private int parentId;
	
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

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getSkipUrl() {
		return skipUrl;
	}

	public void setSkipUrl(String skipUrl) {
		this.skipUrl = skipUrl;
	}
}
