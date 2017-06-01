package com.rural.averanalysis.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.averanalysis.service.IAllAverAnalysisService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;


public class AllAverAnalysisAction extends JqGridBaseAction{
	
	private HashMap<String, Object> dataMap = new HashMap<String, Object>();
	private List<HashMap<String, Object>> averList = new ArrayList<HashMap<String, Object>>();
	private IAllAverAnalysisService iAllAverAnalysisService ;
	private String JQID;
	public static String JQS;
	
	
    public String allAverAnalysis()
	
	{
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		averList = iAllAverAnalysisService.allAverAnalysis(JQID);
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

	public IAllAverAnalysisService getiAllAverAnalysisService() {
		return iAllAverAnalysisService;
	}

	public void setiAllAverAnalysisService(
			IAllAverAnalysisService iAllAverAnalysisService) {
		this.iAllAverAnalysisService = iAllAverAnalysisService;
	}

	public String getJQID() {
		return JQID;
	}

	public void setJQID(String jQID) {
		JQID = jQID;
	}

	public static String getJQS() {
		return JQS;
	}

	public static void setJQS(String jQS) {
		JQS = jQS;
	}
	
	
	

}
