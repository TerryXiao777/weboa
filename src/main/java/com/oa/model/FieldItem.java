package com.oa.model;

public class FieldItem {
	/**
	 * 文本
	 * @hibernate.property
	 */
	private String label;
	
	/**
	 * 值
	 * @hibernate.property
	 */
	private String value;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
