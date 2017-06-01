package com.rural.select.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.Nation;
import com.rural.select.service.SelNationService;

public class SelNationAction {
private static final long serialVersionUID = 1L;
	
	private SelNationService selNationService;

	public void setSelNationService(SelNationService selNationService) {
		this.selNationService = selNationService;
	}

	public SelNationService getSelNationService() {
		return selNationService;
	}
	
	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<Nation> nationlList=(List<Nation>)selNationService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		sb.append("<option value='0'>");
		sb.append("");
		sb.append("</option>");
		for (Nation nation : nationlList) {
			sb.append("<option value='");
			sb.append(nation.getNationId()).append("'>").append(nation.getNationName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
}
