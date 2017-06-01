package com.rural.evalcontsee.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxl.write.DateTime;

import org.apache.struts2.json.annotations.JSON;
import com.rural.evalcontsee.service.IFullEvalContService;
import com.rural.evalcontsee.service.IImproveEvalContService;
import com.rural.evalcontsee.service.IZeroEvalContService;
import com.rural.prmtmeas.action.PrmtMeasAction;
import com.rural.prmtmeas.service.IPrmtMeasService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class ImproveEvalContAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	
	
	//private DateTime JQTime;
	//private static DateTime JSTime;
	
	private String JQTime2;
	private static String JSTime2;
	
	private IImproveEvalContService iImproveEvalContService;
	
	
	
	
	

	
	
	
	public IImproveEvalContService getiImproveEvalContService() {
		return iImproveEvalContService;
	}
	public void setiImproveEvalContService(
			IImproveEvalContService iImproveEvalContService) {
		this.iImproveEvalContService = iImproveEvalContService;
	}
	
	public String getJQTime2() {
		return JQTime2;
	}
	public void setJQTime2(String jQTime2) {
		JQTime2 = jQTime2;
	}
	public static String getJSTime2() {
		return JSTime2;
	}
	public static void setJSTime2(String jSTime2) {
		JSTime2 = jSTime2;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	public String manageImproveEvalCont(){
		ImproveEvalContAction.setJSTime2(JQTime2);
		
		if(!search){
			if("add".equals(oper)){
				//addContact();
				
			}else if ("search".equals(oper)) {
				refreshGridModel();
				responseData();
			}else if ("del".equals(oper)) {
				//delContact();
				
			}else if ("edit".equals(oper)) {
				//updateContact();
				
			}
		}else{
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
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iImproveEvalContService.queryResultsCount(null);
	}
	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iImproveEvalContService.queryResultsCount(criteria);
	}
	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iImproveEvalContService.queryByPage(null, from, length);
	}
	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return this.iImproveEvalContService.queryByPage(criteria, from, length);
	}
	
	
	
	
}

