package com.oa.model;

import java.util.Date;

/**
 * 
 * @author Administrator
 * @hibernate.class table="T_ApproveInfo"
 */
public class ApproveInfo {
	/**
	 * @hibernate.id generator-class="native"
	 */
	private int id;
	
	/**
	 * @hibernate.property
	 */
	private Date approveTime;
	
	/**
	 * @hibernate.many-to-one
	 */
	private User approver;
	
	/**
	 * @hibernate.property
	 */
	private String comment;
	
	/**
	 * @hibernate.many-to-one
	 */
	private Document document;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}
	public User getApprover() {
		return approver;
	}
	public void setApprover(User approver) {
		this.approver = approver;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
}
