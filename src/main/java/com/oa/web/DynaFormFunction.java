package com.oa.web;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.oa.manager.FormManager;
import com.oa.model.FlowForm;
import com.oa.util.FreemarkerUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class DynaFormFunction {
	private static FormManager formManager;
	private static Configuration cfg = FreemarkerUtil.getConfiguration();
	
	public static String form(int workflowId){
		try {
			FlowForm form = formManager.findForm(workflowId);
			if(form == null){
				return null;
			}
			
			Template template = cfg.getTemplate(form.getTemplate());
			
			//最终输出的位置
			Writer out = new StringWriter();
			
			Map rootMap = new HashMap();
			rootMap.put("form", form);
			
			template.process(rootMap, out);
			
			return out.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setFormManager(FormManager formManager) {
		DynaFormFunction.formManager = formManager;
	}
}
