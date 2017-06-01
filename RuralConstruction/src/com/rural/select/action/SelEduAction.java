package com.rural.select.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.Edu;
import com.rural.select.service.SelEduService;

public class SelEduAction {

	private static final long serialVersionUID = 1L;
	
	private SelEduService selEduService;

	public void setSelEduService(SelEduService selEduService) {
		this.selEduService = selEduService;
	}

	public SelEduService getSelEduService() {
		return selEduService;
	}
	
	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<Edu> edulList=(List<Edu>)selEduService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		sb.append("<option value='0'>");
		sb.append("");
		sb.append("</option>");
		for (Edu edu : edulList) {
			sb.append("<option value='");
			sb.append(edu.getEduId()).append("'>").append(edu.getEduName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
}
