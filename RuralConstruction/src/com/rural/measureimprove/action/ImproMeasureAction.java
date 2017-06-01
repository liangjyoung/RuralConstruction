package com.rural.measureimprove.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.measureimprove.service.IImproMeasureService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class ImproMeasureAction extends JqGridBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private IImproMeasureService iImproMeasureService;
	private String EvalScoID;
	private static String EvalScoIDs;
	private String PrmtMeasID;
	private String PrmtMeas;
	private String PrmtMeasComp;
	private String PrmtMeasValue;
	private String ExpectPrmtSco;
	private String PrmtMeasNote;
	
	
	public String manageimproMeas(){
		ImproMeasureAction.setEvalScoIDs(EvalScoID);
		if(!search){
			if ("add".equals(oper)) {//增加
				addImproMeas();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				//delCountryBasicInfo();
				//delEvalCont();
				delImproMeas();
			}else if("edit".equals(oper)){//修改
				//editEvalCont();
				editImproMeas();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		
		return SUCCESS;
	}
	
	public String aa(){
		
		dataMap.put("ss", "sss");
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
	
	
	public String addImproMeas(){
		String message = "";
		message = iImproMeasureService.addImproMeas(PrmtMeasID.trim(),PrmtMeas.trim(),PrmtMeasComp.trim(),PrmtMeasValue.trim(),ExpectPrmtSco.trim(),PrmtMeasNote.trim());
		dataMap.put("success", message);
		return SUCCESS;
	}
	
	public String delImproMeas(){
		String messages = "";
		for (String  a : PrmtMeasID.split(",")) {
			messages = iImproMeasureService.delImproMeas(a.trim());
		}
		dataMap.put("success", messages);
		return SUCCESS;
	}
	
	public String editImproMeas(){
		String message = "";
		message = iImproMeasureService.editImproMeas(PrmtMeasID.trim(),PrmtMeas.trim(),PrmtMeasComp.trim(),PrmtMeasValue.trim(),ExpectPrmtSco.trim(),PrmtMeasNote.trim());
		dataMap.put("success", message);
		return SUCCESS;
	}
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iImproMeasureService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iImproMeasureService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iImproMeasureService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iImproMeasureService.queryByPage(criteria, from, length);
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

	public IImproMeasureService getiImproMeasureService() {
		return iImproMeasureService;
	}

	public void setiImproMeasureService(IImproMeasureService iImproMeasureService) {
		this.iImproMeasureService = iImproMeasureService;
	}


	public String getEvalScoID() {
		return EvalScoID;
	}


	public void setEvalScoID(String evalScoID) {
		EvalScoID = evalScoID;
	}


	public static String getEvalScoIDs() {
		return EvalScoIDs;
	}


	public static void setEvalScoIDs(String evalScoIDs) {
		EvalScoIDs = evalScoIDs;
	}

	public String getPrmtMeasID() {
		return PrmtMeasID;
	}

	public void setPrmtMeasID(String prmtMeasID) {
		PrmtMeasID = prmtMeasID;
	}

	public String getPrmtMeas() {
		return PrmtMeas;
	}

	public void setPrmtMeas(String prmtMeas) {
		PrmtMeas = prmtMeas;
	}

	public String getPrmtMeasComp() {
		return PrmtMeasComp;
	}

	public void setPrmtMeasComp(String prmtMeasComp) {
		PrmtMeasComp = prmtMeasComp;
	}

	public String getPrmtMeasValue() {
		return PrmtMeasValue;
	}

	public void setPrmtMeasValue(String prmtMeasValue) {
		PrmtMeasValue = prmtMeasValue;
	}

	public String getExpectPrmtSco() {
		return ExpectPrmtSco;
	}

	public void setExpectPrmtSco(String expectPrmtSco) {
		ExpectPrmtSco = expectPrmtSco;
	}

	public String getPrmtMeasNote() {
		return PrmtMeasNote;
	}

	public void setPrmtMeasNote(String prmtMeasNote) {
		PrmtMeasNote = prmtMeasNote;
	}

}
