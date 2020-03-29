package com.oa.web.forms;

import java.util.Date;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionForm;

import com.oa.converter.DateConverter;

public class UserActionForm extends ActionForm{
	private static final long serialVersionUID = 4865768286656280050L;
	
	static{
        ConvertUtils.register(new DateConverter(), Date.class);
    }

	private int id;
	/**
	 * 登录账号
	 */
	private String username;
	
	private String password;
	
	private Date createTime;
	
	private Date expireTime;
	
	private int personId;
	
	//此字段用于给用户分配角色时：角色标识
	private int roleId;
	
	//此字段用户给用户分配角色时：优先级
	private int orderNo;
	
	private String skipUrl;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getSkipUrl() {
		return skipUrl;
	}

	public void setSkipUrl(String skipUrl) {
		this.skipUrl = skipUrl;
	}
}
