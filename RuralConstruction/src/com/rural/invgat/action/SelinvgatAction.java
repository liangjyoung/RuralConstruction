package com.rural.invgat.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.bean.DataCollDataDic;
import com.rural.bean.Invgat;
import com.rural.datacolldatadic.service.SelDataCollDataDicService;
import com.rural.invgat.service.SelinvgatService;


public class SelinvgatAction extends ActionSupport {
private static final long serialVersionUID = 1L;
	
	private SelinvgatService selinvgatService;

	
	



	public SelinvgatService getSelinvgatService() {
		return selinvgatService;
	}






	public void setSelinvgatService(SelinvgatService selinvgatService) {
		this.selinvgatService = selinvgatService;
	}






	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<Invgat> invgatList=(List<Invgat>)selinvgatService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (Invgat invgat : invgatList) {
			sb.append("<option value='");
			sb.append(invgat.getInvgatId()).append("'>").append(invgat.getInvgatName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
	

}
