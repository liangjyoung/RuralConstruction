package com.rural.basicdata.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.basicdata.service.IScoreLevManagerService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class ScoreLevManagerAction extends JqGridBaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private IScoreLevManagerService scoreLevManagerService;
	
	public String manageScoreLevl(){
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
	
	public String aa(){
		dataMap.put("ss", "SB");
		return SUCCESS;
	}
	
	
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.scoreLevManagerService.queryResultsCount(null);
	}
	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.scoreLevManagerService.queryResultsCount(criteria);
		
	}
	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.scoreLevManagerService.queryByPage(null, from, length);

	}
	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.scoreLevManagerService.queryByPage(criteria, from, length);
		return results;
	
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

	public void setScoreLevManagerService(IScoreLevManagerService scoreLevManagerService) {
		this.scoreLevManagerService = scoreLevManagerService;
	}

	public IScoreLevManagerService getScoreLevManagerService() {
		return scoreLevManagerService;
	}
	
	
}
