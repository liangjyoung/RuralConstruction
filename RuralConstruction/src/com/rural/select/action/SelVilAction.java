package com.rural.select.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.VilBasicInfo;
import com.rural.select.service.SelVilService;

public class SelVilAction {
	private static final long serialVersionUID = 1L;
	private SelVilService vilfilService;
	
	
	
	public SelVilService getVilfilService() {
		return vilfilService;
	}



	public void setVilfilService(SelVilService vilfilService) {
		this.vilfilService = vilfilService;
	}



	public void findAll() throws IOException{
		List<VilBasicInfo> vilList=(List<VilBasicInfo>)vilfilService.findAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (VilBasicInfo vil : vilList) {
			sb.append("<option value='");
			sb.append(vil.getVilBasicInfoId()).append("'>").append(vil.getVilName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
}




