package com.rural.measureimprove.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.measureimprove.service.IMeasureImproService;
import com.rural.measureimprove.service.MeasureImproService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class MeasureImproAction extends JqGridBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IMeasureImproService iMeasureImproService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String VilID;
	private static String VilIDs;
	
	
	public String aa(){
		String message ="SB";
		dataMap.put("success", message);
		return SUCCESS;
	}
	
	public String manageMeasureimpro(){

		//EvalMethAction.setEvalFSysIDs(EvaFSID);
		
		//EvalMethAction.setEvalSysIDs(EvaSID);
		MeasureImproAction.setVilIDs(VilID);
		if(!search){
			if ("add".equals(oper)) {//增加
				//addEvalCont();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				//delCountryBasicInfo();
				//delEvalCont();
			}else if("edit".equals(oper)){//修改
				//editEvalCont();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 打包服务器响应数据
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iMeasureImproService.queryResultsCount(null);
		
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iMeasureImproService.queryResultsCount(criteria);
		
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iMeasureImproService.queryByPage(null, from, length);
		
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iMeasureImproService.queryByPage(criteria, from, length);
		return results;
	
	}

	public void setiMeasureImproService(IMeasureImproService iMeasureImproService) {
		this.iMeasureImproService = iMeasureImproService;
	}

	public IMeasureImproService getiMeasureImproService() {
		return iMeasureImproService;
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

	public String getVilID() {
		return VilID;
	}

	public void setVilID(String vilID) {
		VilID = vilID;
	}

	public static String getVilIDs() {
		return VilIDs;
	}

	public static void setVilIDs(String vilIDs) {
		VilIDs = vilIDs;
	}
	
	
}
