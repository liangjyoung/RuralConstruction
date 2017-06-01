package com.rural.datacolldatadic.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.rural.bean.DataCollDataDic;
import com.opensymphony.xwork2.ActionSupport;
import com.rural.datacolldatadic.service.SelDataCollDataDicService;


public class SelDataCollDataDicAction extends ActionSupport {
private static final long serialVersionUID = 1L;
	
	private SelDataCollDataDicService selDataCollDataDicService;

	
	
	public SelDataCollDataDicService getSelDataCollDataDicService() {
		return selDataCollDataDicService;
	}



	public void setSelDataCollDataDicService(
			SelDataCollDataDicService selDataCollDataDicService) {
		this.selDataCollDataDicService = selDataCollDataDicService;
	}



	@SuppressWarnings("unchecked")	
	public void findAll() throws IOException{
		List<DataCollDataDic> dataCollDataDiclList=(List<DataCollDataDic>)selDataCollDataDicService.findAll();
		StringBuilder sb = new StringBuilder();
		
		sb.append("<select>");
		sb.append("<option value='0'>");
		sb.append("");
		sb.append("</option>");
		
		for (DataCollDataDic dataCollDataDic : dataCollDataDiclList) {
			sb.append("<option value='");
			sb.append(dataCollDataDic.getDataCollDataDicId()).append("'>").append(dataCollDataDic.getDataDicName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
	

}
