package com.oa.model;

/**
 * @hibernate.class table="T_Workflow"
 */
public class Workflow {
	/**
	 * @hibernate.id generator-class="native"
	 */
	private int id;
	
	/**
	 * @hibernate.property
	 */
	private String name;
	
	/**
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] processDef;
	
	/**
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] processImage;
	
	/** 
	 * @hibernate.one-to-one property-ref="workflow"
	 */
	private FlowForm flowForm;
	
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
	public byte[] getProcessDef() {
		return processDef;
	}
	public void setProcessDef(byte[] processDef) {
		this.processDef = processDef;
	}
	public byte[] getProcessImage() {
		return processImage;
	}
	public void setProcessImage(byte[] processImage) {
		this.processImage = processImage;
	}
	public FlowForm getFlowForm() {
		return flowForm;
	}
	public void setFlowForm(FlowForm flowForm) {
		this.flowForm = flowForm;
	}
}
