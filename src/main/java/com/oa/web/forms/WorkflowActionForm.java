package com.oa.web.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class WorkflowActionForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 219043604124411221L;
	private int id;
	private String name;
	private FormFile processDef;
	private FormFile processImage;
	
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
	public FormFile getProcessDef() {
		return processDef;
	}
	public void setProcessDef(FormFile processDef) {
		this.processDef = processDef;
	}
	public FormFile getProcessImage() {
		return processImage;
	}
	public void setProcessImage(FormFile processImage) {
		this.processImage = processImage;
	}
}
