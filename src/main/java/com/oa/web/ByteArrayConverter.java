package com.oa.web;

import org.apache.commons.beanutils.Converter;
import org.apache.struts.upload.FormFile;

public class ByteArrayConverter implements Converter{

	@Override
	public Object convert(Class type, Object value) {
		try {
			if(value instanceof FormFile){
				FormFile ff = (FormFile)value;
				return ff.getFileData();
			}
		} 
		catch (Exception e) {
		}
		
		return null;
	}
	
}
