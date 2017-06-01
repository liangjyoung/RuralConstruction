package com.rural.expertevalmanager.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.expertevalmanager.service.IExpertDistService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class ExpertDistAction extends JqGridBaseAction{

	
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private IExpertDistService expertDistService;
	private String JQID;
	private static String JQIDS;
	
	public String getJQID() {
		return JQID;
	}

	public void setJQID(String jQID) {
		JQID = jQID;
	}

	public static String getJQIDS() {
		return JQIDS;
	}

	public static void setJQIDS(String jQIDS) {
		JQIDS = jQIDS;
	}

	public String manageExpertdis() {
		ExpertDistAction.setJQIDS(JQID);
		if(!search){
			if ("add".equals(oper)) {//
				//addEvalExpert();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
				//delEvalExpert();
			}else if("edit".equals(oper)){//
				//updateEvalExpert();
				//CheckLoginName();
				//editLoginname();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}


public String aa(){
	dataMap.put("ss", "ss");
	return SUCCESS;
}

	/**
	 * 打包服务器数据
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.expertDistService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.expertDistService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.expertDistService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.expertDistService.queryByPage(criteria, from, length);

	}




	public void setExpertDistService(IExpertDistService expertDistService) {
		this.expertDistService = expertDistService;
	}




	public IExpertDistService getExpertDistService() {
		return expertDistService;
	}

}
