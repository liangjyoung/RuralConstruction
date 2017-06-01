package com.rural.villagecompartment.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.bean.DataCollDataDic;
import com.rural.bean.VilBasicInfo;
import com.rural.datacolldatadic.service.SelDataCollDataDicService;
import com.rural.villagecompartment.service.SelvilService;


public class SelvilAction extends ActionSupport {
private static final long serialVersionUID = 1L;
	
	private SelvilService selvilService;

	
	
	


	public SelvilService getSelvilService() {
		return selvilService;
	}






	public void setSelvilService(SelvilService selvilService) {
		this.selvilService = selvilService;
	}






	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<VilBasicInfo> vilBasicInfolList=(List<VilBasicInfo>)selvilService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (VilBasicInfo vilBasicInfo : vilBasicInfolList) {
			sb.append("<option value='");
			sb.append(vilBasicInfo.getVilBasicInfoId()).append("'>").append(vilBasicInfo.getVilName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
	

}
