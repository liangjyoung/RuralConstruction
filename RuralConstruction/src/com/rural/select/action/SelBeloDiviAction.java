package com.rural.select.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.select.service.SelBeloDiviService;

public class SelBeloDiviAction {
	private static final long serialVersionUID = 1L;
	private SelBeloDiviService selBeloDiviService;

	

	public SelBeloDiviService getSelBeloDiviService() {
		return selBeloDiviService;
	}



	public void setSelBeloDiviService(SelBeloDiviService selBeloDiviService) {
		this.selBeloDiviService = selBeloDiviService;
	}



	public void findAll1() throws IOException{
		List<VilBasicInfo> vilList=(List<VilBasicInfo>)selBeloDiviService.findAll1();
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
	
	
	
	public void findAll2() throws IOException{
		List<TownBasicInfo> townList=(List<TownBasicInfo>)selBeloDiviService.findAll2();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (TownBasicInfo town : townList) {
			sb.append("<option value='");
			sb.append(town.getTownBasicInfoId()).append("'>").append(town.getTownName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
	
	public void findAll3() throws IOException{
		List<CountryBasicInfo> countryList=(List<CountryBasicInfo>)selBeloDiviService.findAll3();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (CountryBasicInfo country : countryList) {
			sb.append("<option value='");
			sb.append(country.getCountryBasicInfoId()).append("'>").append(country.getCountryName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
	
	public void findAll4() throws IOException{
		List<CityBasicInfo> cityList=(List<CityBasicInfo>)selBeloDiviService.findAll4();
		StringBuilder sb = new StringBuilder();
		sb.append("<select>");
		for (CityBasicInfo city : cityList) {
			sb.append("<option value='");
			sb.append(city.getCityBasicInfoId()).append("'>").append(city.getCityName());
			sb.append("</option>");
		}
		sb.append("</select>");
		ServletActionContext.getResponse().setContentType(
				"text/html; charset=utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.write(sb.toString());
	}
}




