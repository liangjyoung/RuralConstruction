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
import com.rural.evalcontsee.service.IZeroEvalContService;
import com.rural.prmtmeas.action.PrmtMeasAction;
import com.rural.prmtmeas.service.IPrmtMeasService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class ZeroEvalContAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	
	
	//private DateTime JQTime;
	//private static DateTime JSTime;
	
	private String JQTime1;
	private static String JSTime1;
	
	private IZeroEvalContService iZeroEvalContService;
	
	
	
	
	

	
	public IZeroEvalContService getiZeroEvalContService() {
		return iZeroEvalContService;
	}
	public void setiZeroEvalContService(IZeroEvalContService iZeroEvalContService) {
		this.iZeroEvalContService = iZeroEvalContService;
	}
	
	public String getJQTime1() {
		return JQTime1;
	}
	public void setJQTime1(String jQTime1) {
		JQTime1 = jQTime1;
	}
	public static String getJSTime1() {
		return JSTime1;
	}
	public static void setJSTime1(String jSTime1) {
		JSTime1 = jSTime1;
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
	
	public String manageZeroEvalCont(){
		ZeroEvalContAction.setJSTime1(JQTime1);
		
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
		return this.iZeroEvalContService.queryResultsCount(null);
	}
	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iZeroEvalContService.queryResultsCount(criteria);
	}
	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iZeroEvalContService.queryByPage(null, from, length);
	}
	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return this.iZeroEvalContService.queryByPage(criteria, from, length);
	}
	
	
	
	
}
