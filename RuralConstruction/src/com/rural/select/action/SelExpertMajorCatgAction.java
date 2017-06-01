package com.rural.select.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.ExpertMajorCatg;
import com.rural.select.service.SelExpertMajorCatgService;

public class SelExpertMajorCatgAction {

	private static final long serialVersionUID = 1L;
	
	private SelExpertMajorCatgService selExpertMajorCatgService;

	public void setSelExpertMajorCatgService(SelExpertMajorCatgService selExpertMajorCatgService) {
		this.selExpertMajorCatgService = selExpertMajorCatgService;
	}

	public SelExpertMajorCatgService getSelExpertMajorCatgService() {
		return selExpertMajorCatgService;
	}
	
	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<ExpertMajorCatg> expertMajorCatglList=(List<ExpertMajorCatg>)selExpertMajorCatgService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (ExpertMajorCatg expertMajorCatg : expertMajorCatglList) {
			sb.append("<option value='");
			sb.append(expertMajorCatg.getExpertMajorCatgId()).append("'>").append(expertMajorCatg.getExpertMajorCatg());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
}
