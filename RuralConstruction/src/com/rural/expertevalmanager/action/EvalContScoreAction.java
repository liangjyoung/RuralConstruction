package com.rural.expertevalmanager.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.expertevalmanager.service.IEvalContScoreService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class EvalContScoreAction extends JqGridBaseAction{


	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String VilEvalContID;
	private IEvalContScoreService contScoreService;
	private static String VilEvalConts;
	
	
	public String manageEvalContScore() {
		EvalContScoreAction.setVilEvalConts(VilEvalContID);
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
				//autoEvalScore();
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

	public String getVilEvalContID() {
		return VilEvalContID;
	}

	public void setVilEvalContID(String vilEvalContID) {
		VilEvalContID = vilEvalContID;
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.contScoreService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.contScoreService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.contScoreService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.contScoreService.queryByPage(criteria, from, length);

	}

	public void setContScoreService(IEvalContScoreService contScoreService) {
		this.contScoreService = contScoreService;
	}

	public IEvalContScoreService getContScoreService() {
		return contScoreService;
	}




	public static void setVilEvalConts(String vilEvalConts) {
		VilEvalConts = vilEvalConts;
	}




	public static String getVilEvalConts() {
		return VilEvalConts;
	}

}
