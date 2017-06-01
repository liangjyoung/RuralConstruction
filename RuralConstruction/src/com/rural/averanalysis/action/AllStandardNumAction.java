package com.rural.averanalysis.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.rural.averanalysis.service.IAllStandardNumService;
import com.rural.averanalysis.service.ITownStandardNumService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class AllStandardNumAction extends JqGridBaseAction{
	
	private HashMap<String, Object> dataMap = new HashMap<String, Object>();
	private List<HashMap<String, Object>> numList = new ArrayList<HashMap<String, Object>>();
	private IAllStandardNumService iAllStandardNumService;
	private String JQID;
	public static String JQS;
	
   public String allStandardNum()
	
	{
		//String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		numList = iAllStandardNumService.allStandardNum(JQID);
		dataMap.put("numList", numList);
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

	public List<HashMap<String, Object>> getNumList() {
		return numList;
	}

	public void setNumList(List<HashMap<String, Object>> numList) {
		this.numList = numList;
	}

	public IAllStandardNumService getiAllStandardNumService() {
		return iAllStandardNumService;
	}

	public void setiAllStandardNumService(
			IAllStandardNumService iAllStandardNumService) {
		this.iAllStandardNumService = iAllStandardNumService;
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
