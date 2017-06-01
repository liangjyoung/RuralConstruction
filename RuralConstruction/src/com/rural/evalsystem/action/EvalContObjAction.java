package com.rural.evalsystem.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.EvalContInvesObj;
import com.rural.bean.InvesObj;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.InvesObjDAO;
import com.rural.evalsystem.service.IEvalContObjService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class EvalContObjAction extends JqGridBaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private IEvalContObjService iEvalContObjService;
	private String EvalObjID;
	private static String EvalObjIDs;
	private String EvalContInvesObjID;
	private String EvalContInvesObjValue;
	private boolean EvalContInvesObjMus;
	private String EvalContInvesObjNote;

	
	public String getEvalContInvesObjValue() {
		return EvalContInvesObjValue;
	}

	public void setEvalContInvesObjValue(String evalContInvesObjValue) {
		EvalContInvesObjValue = evalContInvesObjValue;
	}

	public boolean isEvalContInvesObjMus() {
		return EvalContInvesObjMus;
	}

	public void setEvalContInvesObjMus(boolean evalContInvesObjMus) {
		EvalContInvesObjMus = evalContInvesObjMus;
	}

	public String getEvalContInvesObjNote() {
		return EvalContInvesObjNote;
	}

	public void setEvalContInvesObjNote(String evalContInvesObjNote) {
		EvalContInvesObjNote = evalContInvesObjNote;
	}

	public static String getEvalObjIDs() {
		return EvalObjIDs;
	}

	public static void setEvalObjIDs(String evalObjIDs) {
		EvalObjIDs = evalObjIDs;
	}

	public String manageEvalContObj(){
		EvalContObjAction.setEvalObjIDs(EvalObjID);
		if(!search){
			if ("add".equals(oper)) {//增加
				//addCountryBasicInfo();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				delInvalObj();
			}else if("edit".equals(oper)){//修改
				editEvalContInvalObj();
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
	
	public String delInvalObj(){
		String message = "";
		for (String  evlobjid : EvalContInvesObjID.split(",")) {
			message = iEvalContObjService.delInvalObj(evlobjid.trim());
		}
		dataMap.put("success", message);
		return SUCCESS;
	}
	
	public String editEvalContInvalObj(){
		iEvalContObjService.editEvalContInvalObj(EvalContInvesObjID.trim(),EvalContInvesObjValue.trim(),EvalContInvesObjMus,EvalContInvesObjNote.trim());
		dataMap.put("success", true);
		return SUCCESS;
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
		return this.iEvalContObjService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iEvalContObjService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iEvalContObjService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iEvalContObjService.queryByPage(criteria, from, length);
		return results;
	}

	public void setiEvalContObjService(IEvalContObjService iEvalContObjService) {
		this.iEvalContObjService = iEvalContObjService;
	}

	public IEvalContObjService getiEvalContObjService() {
		return iEvalContObjService;
	}

	public void setEvalObjID(String evalObjID) {
		EvalObjID = evalObjID;
	}

	public String getEvalObjID() {
		return EvalObjID;
	}

	public void setEvalContInvesObjID(String evalContInvesObjID) {
		EvalContInvesObjID = evalContInvesObjID;
	}

	public String getEvalContInvesObjID() {
		return EvalContInvesObjID;
	}

}
