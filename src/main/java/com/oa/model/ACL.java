package com.oa.model;

/**
 * 
 * @author Administrator
 * @hibernate.class table="T_ACL"
 */
public class ACL {
	
	public static final String TYPE_ROLE = "Role";
	public static final String TYPE_USER = "User";
	/**
	 * ACL的状态为继承（即无效，判断的时候应该判断其所属角色的授权）
	 */
	public static final int ACL_TRI_STATE_EXTENDS = 0xFFFFFFFF;
	
	/**
	 * ACL的状态为不继承（即有效，判断的时候，直接根据aclState判断授权）
	 */
	public static final int ACL_TRI_STATE_UNEXTENDS = 0;
	
	/**
	 * 授权允许
	 */
	public static final int ACL_YES = 1;
	
	/**
	 * 授权不允许
	 */
	public static final int ACL_NO = 0;
	
	/**
	 * 授权不确定
	 */
	public static final int ACL_NEUTRAL = -1;
	
	
	/**
	 * @hibernate.id generator-class="native"
	 */
	private int id;
	
	/**
	 * @hibernate.property
	 * 主体类型：角色或用户
	 */
	private String principalType;
	
	/**
	 * @hibernate.property
	 * 主体标识：角色标识或用户标识
	 */
	private int principalId;
	
	/**
	 * @hibernate.property
	 */
	private int moduleId;
	
	/**
	 * @hibernate.property
	 * 授权状态
	 */
	private int aclState;
	
	/**
	 * @hibernate.property
	 * 表示是否继承 ，0表示不继承，1表示继承
	 */
	private int aclTriState;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public int getAclState() {
		return aclState;
	}
	public void setAclState(int aclState) {
		this.aclState = aclState;
	}
	public int getAclTriState() {
		return aclTriState;
	}
	public void setAclTriState(int aclTriState) {
		this.aclTriState = aclTriState;
	}
	
	/**
	 * acl实例跟主体和资源关联
	 * 针对此实例进行授权：某种操作是否允许
	 * @param permission 只可以取值0，1，2，3
	 * @param yes true 表示允许，false表示不允许
	 */
	public void setPermission(int permission,boolean yes){
		int temp = 1;
		temp = temp << permission;
		if(yes){
			aclState |= temp;
		}else{
			aclState &= ~temp;
		}
	}
	
	/**
	 * 获取ACL授权
	 * @param permission C/R/U/D权限
	 * @return
	 */
	public int getPermission(int permission){
		if(aclTriState == ACL_TRI_STATE_EXTENDS){
			return ACL_NEUTRAL;
		}
		
		int temp = 1;
		temp = temp << permission;
		temp &= aclState;
		if(temp != 0){
			return ACL_YES;
		}
		return ACL_NO;
	}
	
	/**
	 * 设置ACL的继承状态
	 * @param yes true标识继承，false表示不继承
	 */
	public void setExtends(boolean yes){
		if(yes){
			aclTriState = ACL_TRI_STATE_EXTENDS;
		}
		else{
			aclTriState = ACL_TRI_STATE_UNEXTENDS;
		}
	}
}
