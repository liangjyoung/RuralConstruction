package com.rural.expertselect.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;


import com.rural.bean.EvalExpertDist;
import com.rural.bean.VilDataCollRec;
import com.rural.expertselect.service.IExpertSelectService;

import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class ExpertSelectAction  extends JqGridBaseAction{

	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String ExpertID;
	private String EvalExpertDistID;
	private String ExpertNum;
	private String ExpertMajorCatg;
	private String ExpertName;
	private String ExpertMobTel;
	private String oper;
	private String JQID;
	private IExpertSelectService iexpertSelectService;
	public static String JQS;
	public static Integer dfid;
	private String allid;
	private boolean IsSub;
	
	
	
	
	
	public boolean isIsSub() {
		return IsSub;
	}


	public void setIsSub(boolean isSub) {
		IsSub = isSub;
	}


	public String getAllid() {
		return allid;
	}


	public void setAllid(String allid) {
		this.allid = allid;
	}


	public static Integer getDfid() {
		return dfid;
	}


	public static void setDfid(Integer dfid) {
		ExpertSelectAction.dfid = dfid;
	}


	public Map<String, Object> getDataMap() {
		return dataMap;
	}


	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}


	public String getExpertID() {
		return ExpertID;
	}


	public void setExpertID(String expertID) {
		ExpertID = expertID;
	}


	public String getEvalExpertDistID() {
		return EvalExpertDistID;
	}


	public void setEvalExpertDistID(String evalExpertDistID) {
		EvalExpertDistID = evalExpertDistID;
	}


	public String getExpertNum() {
		return ExpertNum;
	}


	public void setExpertNum(String expertNum) {
		ExpertNum = expertNum;
	}


	public String getExpertMajorCatg() {
		return ExpertMajorCatg;
	}


	public void setExpertMajorCatg(String expertMajorCatg) {
		ExpertMajorCatg = expertMajorCatg;
	}


	public String getExpertName() {
		return ExpertName;
	}


	public void setExpertName(String expertName) {
		ExpertName = expertName;
	}


	public String getExpertMobTel() {
		return ExpertMobTel;
	}


	public void setExpertMobTel(String expertMobTel) {
		ExpertMobTel = expertMobTel;
	}


	public String getOper() {
		return oper;
	}


	public void setOper(String oper) {
		this.oper = oper;
	}


	public String getJQID() {
		return JQID;
	}


	public void setJQID(String jQID) {
		JQID = jQID;
	}


	


	public IExpertSelectService getIexpertSelectService() {
		return iexpertSelectService;
	}


	public void setIexpertSelectService(IExpertSelectService iexpertSelectService) {
		this.iexpertSelectService = iexpertSelectService;
	}


	public static String getJQS() {
		return JQS;
	}


	public static void setJQS(String jQS) {
		JQS = jQS;
	}


	
	//表入口
	public String manageExpert() {
		ExpertSelectAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {//
				//addSysRoleUser();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
				delexpertsel();
			}else if("edit".equals(oper)){//
				//updateSysRoleUser();
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
	
	
	public String  distributeExp() {	
		String message="";
		for(String ald: allid.split(",")){
		//System.out.println("_----------->"+allid);		
			message = message + this.iexpertSelectService.modify(dfid,ald);
		}
		dataMap.put("success", message);
		return SUCCESS;
	}


	private String delexpertsel() {
		String message="";
		for(String allld: EvalExpertDistID.split(",")){
		//System.out.println("_----------->"+allid);		
			message = message + this.iexpertSelectService.delexpertsel(allld);
		}
		dataMap.put("success", message);
		return SUCCESS;
		// TODO Auto-generated method stub

	}
	
	
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iexpertSelectService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.iexpertSelectService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.iexpertSelectService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.iexpertSelectService.queryByPage(criteria, from, length);
	}

	
}
