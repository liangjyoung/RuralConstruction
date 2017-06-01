package com.rural.select.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.Sex;
import com.rural.select.service.SelSexService;

public class SelSexAction {

	private static final long serialVersionUID = 1L;
	
	private SelSexService selSexService;

	public void setSelSexService(SelSexService selSexService) {
		this.selSexService = selSexService;
	}

	public SelSexService getSelSexService() {
		return selSexService;
	}
	
	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<Sex> sexlList=(List<Sex>)selSexService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		sb.append("<option value='0'>");
		sb.append("");
		sb.append("</option>");
		
		for (Sex sex : sexlList) {
			sb.append("<option value='");
			sb.append(sex.getSexId()).append("'>").append(sex.getSexName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
}
