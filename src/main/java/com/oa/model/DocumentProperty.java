package com.oa.model;

import java.beans.PropertyDescriptor;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

public class DocumentProperty {
	/**
	 * @hibernate.property
	 */
	private String java_lang_String;
	
	/**
	 * @hibernate.property
	 */
	private Date java_util_Date;
	
	/**
	 * @hibernate.property
	 */
	private Integer java_lang_Integer;
	
	/**
	 * @hibernate.property
	 */
	private Long java_lang_Long;
	
	/**
	 * @hibernate.property type="binary" length="99999999"
	 */
	private byte[] java_io_File;
	
	//可支持的类型名称
	private static String[] supportedTypeNames;
	
	static {
		PropertyDescriptor[] ps = PropertyUtils.getPropertyDescriptors(DocumentProperty.class);
		supportedTypeNames = new String[ps.length];
		for(int i=0; i< ps.length; i++){
			PropertyDescriptor pd = ps[i];
			supportedTypeNames[i] = pd.getName();
		}
	}
	
	/**
	 * 是否支持此类型
	 * @param type
	 * @return
	 */
	public static boolean support(String type){
		for(int i=0; i<supportedTypeNames.length; i++){
			if(type.equals(supportedTypeNames[i])){
				return true;
			}
		}
		return false;
	}
	
	public String getJava_lang_String() {
		return java_lang_String;
	}

	public void setJava_lang_String(String java_lang_String) {
		this.java_lang_String = java_lang_String;
	}

	public Date getJava_util_Date() {
		return java_util_Date;
	}

	public void setJava_util_Date(Date java_util_Date) {
		this.java_util_Date = java_util_Date;
	}

	public Integer getJava_lang_Integer() {
		return java_lang_Integer;
	}

	public void setJava_lang_Integer(Integer java_lang_Integer) {
		this.java_lang_Integer = java_lang_Integer;
	}

	public Long getJava_lang_Long() {
		return java_lang_Long;
	}

	public void setJava_lang_Long(Long java_lang_Long) {
		this.java_lang_Long = java_lang_Long;
	}

	public byte[] getJava_io_File() {
		return java_io_File;
	}

	public void setJava_io_File(byte[] java_io_File) {
		this.java_io_File = java_io_File;
	}
}
