package com.rural.expertevalmanager.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.expertevalmanager.service.IExpertEvalService;
import com.rural.invgatdwork.service.IDistrictService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class ExpertEvalAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;

	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IExpertEvalService expertEvalService;
	private String oper;
	private String TreeID;
	private static String TreeIDs;
	private String VilRecID;
	private String VilRecIDs;

	//表入口
	public String manageExpert() {
		ExpertEvalAction.setTreeIDs(TreeID);
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
				autoEvalScore();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
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
	
	public String autoEvalScore(){
		String message ="";
		message = expertEvalService.autoEvalScore(VilRecID.trim(),VilRecIDs.trim());
		dataMap.put("success", message);
		return SUCCESS;
	}
	//VilRecID
	
	public static String getTreeIDs() {
		return TreeIDs;
	}
	
	public static void setTreeIDs(String treeIDs) {
		TreeIDs = treeIDs;
	}

	public String getTreeID() {
		return TreeID;
	}

	public void setTreeID(String treeID) {
		TreeID = treeID;
	}

	public String aa(){
		dataMap.put("ss", "ss");
		return SUCCESS;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public IExpertEvalService getExpertEvalService() {
		return expertEvalService;
	}

	public void setExpertEvalService(IExpertEvalService expertEvalService) {
		this.expertEvalService = expertEvalService;
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
		return this.expertEvalService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.expertEvalService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.expertEvalService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.expertEvalService.queryByPage(criteria, from, length);
	}





	public void setVilRecID(String vilRecID) {
		VilRecID = vilRecID;
	}




	public String getVilRecID() {
		return VilRecID;
	}




	public void setVilRecIDs(String vilRecIDs) {
		VilRecIDs = vilRecIDs;
	}




	public String getVilRecIDs() {
		return VilRecIDs;
	}
	
}
