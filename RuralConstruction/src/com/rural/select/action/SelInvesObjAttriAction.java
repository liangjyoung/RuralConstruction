package com.rural.select.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.InvesObjAttri;
import com.rural.select.service.SelInvesObjAttriService;

public class SelInvesObjAttriAction {
	
	private static final long serialVersionUID = 1L;
	
	private SelInvesObjAttriService selInvesObjAttriService;

	
	
	public SelInvesObjAttriService getSelInvesObjAttriService() {
		return selInvesObjAttriService;
	}



	public void setSelInvesObjAttriService(
			SelInvesObjAttriService selInvesObjAttriService) {
		this.selInvesObjAttriService = selInvesObjAttriService;
	}



	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<InvesObjAttri> invesObjAttrilList=(List<InvesObjAttri>)selInvesObjAttriService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (InvesObjAttri invesObjAttri : invesObjAttrilList) {
			sb.append("<option value='");
			sb.append(invesObjAttri.getInvesObjAttriId()).append("'>").append(invesObjAttri.getInvesObjAttriName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
}
