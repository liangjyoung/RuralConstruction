package com.rural.table.service;

import org.apache.struts2.ServletActionContext;

public class FileConfig {
	private static final String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("");
	private static final String template="\\template";
	private static final String applicationtable="template_applicationtable.xml";
	public static final String template_applicationtable=path+template+"\\"+applicationtable;
}
