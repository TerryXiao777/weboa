package com.oa.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.oa.exception.SystemException;

/**
 * 
 * @author Administrator
 * @hibernate.class table="T_Document"
 */
public class Document {
	public static final String STATUS_NEW = "新建";
	public static final String STATUS_FINISH = "完成";
	
	private static Log logger = LogFactory.getLog(Document.class);
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * @hibernate.property
	 */
	private String title;
	
	/**
	 * @hibernate.property
	 * 		type="binary"
	 * 		length="99999999"
	 */
	private byte[] content;
	
	/**
	 * @hibernate.property
	 */
	private String description;
	
	/**
	 * @hibernate.property
	 */
	private Date createTime;
	
	/**
	 * @hibernate.property
	 */
	private String status;
	
	/**
	 * @hibernate.property
	 */
	private long processInstanceId;
	
	/**
	 * @hibernate.many-to-one
	 */
	private Workflow workflow;
	
	/**
	 * @hibernate.many-to-one
	 */
	private User creator;
	
	/**
	 * @hibernate.map table="T_DocumentProperties"
	 * @hibernate.key column="documentId"
	 * @hibernate.map-key type="string" column="propertyName"
	 * @hibernate.composite-element class="com.bjsxt.oa.model.DocumentProperty"
	 */
	private Map properties;
	
	//从界面上接收过来的各种属性值，即尚未转换之前的值
	public void setPropertiesMap(Map props){
		if(workflow.getFlowForm() == null){  
			return;
		}
		Set fields = workflow.getFlowForm().getFields();
		FormField formField = null;
		for (Iterator iterator = fields.iterator(); iterator.hasNext();) {
			FormField field = (FormField) iterator.next();
			setProperty(field.getFieldName(),props.get(field.getFieldName()));
		}
	}
	
	//设置对应的属性
	public void setProperty(String name,Object value){

		try {
			//FieldType的type属性必需与DocumentProperty类中的属性名称一致！
			String type = getPropertyType(name);
			DocumentProperty dp = new DocumentProperty();
			if(!DocumentProperty.support(type)){
				throw new SystemException("不支持的数据类型！");
			}
			
			//触发相应的Converter被调用
			BeanUtils.copyProperty(dp, type, value);
			
			if(properties == null){
				properties = new HashMap();
			}
			properties.put(name, dp);
			
		} 
		catch (Exception e) {
			throw new SystemException("设置属性的时候出现异常！",e);
		}
	}
	
	//获取对应的属性
	public Object getProperty(String name){
		//根据对应的fieldType，从DocumentProperty转换为相应的类型，并返回
		try {
			if(properties == null){
				return null;
			}
			DocumentProperty dp = (DocumentProperty)properties.get(name);
			String type = getPropertyType(name);
			
			return PropertyUtils.getProperty(dp, type);
			
		} 
		catch (Exception e) {
			throw new SystemException("获取公文属性["+name+"]的时候发生异常！",e);
		}
		
	}
	
	//获得对应属性的类型名称
	private String getPropertyType(String name){
		//需根据对应fieldType，转换为相应的类型(DocumentProperty)，并存储
		try {
			Set fields = workflow.getFlowForm().getFields();
			FormField formField = null;
			for (Iterator iterator = fields.iterator(); iterator.hasNext();) {
				FormField field = (FormField) iterator.next();
				if(field.getFieldName().equals(name)){
					formField = field;
					break;
				}
			}
			
			//获得对应属性的类型名称
			return formField.getFieldType().getType();
			
		} 
		catch (Exception ignore) {
			logger.warn("获取对应属性["+name+"]的类型名称时出现异常！",ignore);
		}
		
		throw new SystemException("无法获得对应属性的类型名称");
	}
	
	public Workflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public Map getProperties() {
		return properties;
	}
	public void setProperties(Map properties) {
		this.properties = properties;
	}
}
