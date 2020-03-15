package com.oa.model;

/**
 * 
 * @author Administrator
 * @hibernate.class table="T_UsersRoles"
 */
public class UsersRoles {
	
	/**
	 * @hibernate.id generator-class="native"
	 */
	private int id;
	
	/**
	 * @hibernate.many-to-one
	 * 对应的角色
	 */
	private Role role;
	
	/**
	 * @hibernate.many-to-one
	 * 对应的用户
	 */
	private User user;
	
	/**
	 * @hibernate.property
	 * 角色在这个用户中的优先级
	 */
	private int orderNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
}
