package com.rural.admiDivisions.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.rural.bean.TownBasicInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.rural.admiDivisions.service.SelTownBasicInfoService;


public class SelTownBasicInfoAction extends ActionSupport{
private static final long serialVersionUID = 1L;
	
	private SelTownBasicInfoService selTownBasicInfoService;

	public void setSelTownBasicInfoService(SelTownBasicInfoService selTownBasicInfoService) {
		this.selTownBasicInfoService = selTownBasicInfoService;
	}

	public SelTownBasicInfoService getSelTownBasicInfoService() {
		return selTownBasicInfoService;
	}
	
	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<TownBasicInfo> townBasicInfolList=(List<TownBasicInfo>)selTownBasicInfoService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (TownBasicInfo townBasicInfo : townBasicInfolList) {
			sb.append("<option value='");
			sb.append(townBasicInfo.getTownBasicInfoId()).append("'>").append(townBasicInfo.getTownName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}

}
