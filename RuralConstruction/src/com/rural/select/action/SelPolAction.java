package com.rural.select.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.Pol;
import com.rural.select.service.SelPolService;

public class SelPolAction {

	private static final long serialVersionUID = 1L;
	
	private SelPolService selPolService;

	public void setSelPolService(SelPolService selPolService) {
		this.selPolService = selPolService;
	}

	public SelPolService getSelPolService() {
		return selPolService;
	}
	
	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<Pol> pollList=(List<Pol>)selPolService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		sb.append("<option value='0'>");
		sb.append("");
		sb.append("</option>");
		for (Pol pol : pollList) {
			sb.append("<option value='");
			sb.append(pol.getPolId()).append("'>").append(pol.getPolName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
}
