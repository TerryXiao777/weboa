package com.oa.web;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.beanutils.ConvertUtils;

import com.oa.constant.Permission;

public class InitServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8796091481177279861L;

	@Override
	public void init() throws ServletException {
		
		//注册日期类型的转换器
		ConvertUtils.register(new UtilDateConverter(), Date.class);

		//注册byte[]数组转换器
		ConvertUtils.register(new ByteArrayConverter(), byte[].class);
		
		ServletContext sc = getServletContext();
		sc.setAttribute("CREATE", Permission.CREATE);
		sc.setAttribute("READ", Permission.READ);
		sc.setAttribute("UPDATE", Permission.UPDATE);
		sc.setAttribute("DELETE", Permission.DELETE);
	}
}
