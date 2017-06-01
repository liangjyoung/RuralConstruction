package com.rural.averanalysis.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.rural.averanalysis.service.ITownAverAnalysisService;
import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.contact.service.IContactService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;


public class TownAverAnalysisAction extends JqGridBaseAction {


	private HashMap<String, Object> dataMap = new HashMap<String, Object>();
	private List<HashMap<String, Object>> averList = new ArrayList<HashMap<String, Object>>();
	private ITownAverAnalysisService iTownAverAnalysisService ;
	
	private String year;
	
	
	
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String townAverAnalysis()
	
	{
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		averList = iTownAverAnalysisService.townAverAnalysis("3712.06.02.000");
		dataMap.put("averList", averList);
		return SUCCESS;
	}
	
	public String townAver(){
		
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		averList = iTownAverAnalysisService.townAver("3712.06.02.000",Integer.parseInt(year));
		dataMap.put("averList", averList);
		return SUCCESS;
		
		
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(HashMap<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public List<HashMap<String, Object>> getAverList() {
		return averList;
	}

	public void setAverList(List<HashMap<String, Object>> averList) {
		this.averList = averList;
	}

	public ITownAverAnalysisService getiTownAverAnalysisService() {
		return iTownAverAnalysisService;
	}

	public void setiTownAverAnalysisService(
			ITownAverAnalysisService iTownAverAnalysisService) {
		this.iTownAverAnalysisService = iTownAverAnalysisService;
	}
	

}
