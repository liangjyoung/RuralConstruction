package com.rural.expertolgra.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.expertolgra.service.IEvalContObjAttriService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class EvalContObjAttriAction extends JqGridBaseAction {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IEvalContObjAttriService iEvalContObjAttriService;
	private String oper;
	private Integer contID;
	private Integer distID;
	private static Integer evalContID;
	private static Integer expertDistID;
	
	public String getObjAttri(){
		//获得评价方法ID和评价专家分配ID
		EvalContObjAttriAction.setEvalContID(contID);
		EvalContObjAttriAction.setExpertDistID(distID);
		//System.out.println(contID);
		if(!search){
			if ("add".equals(oper)){
			}else if ("search".equals(oper)){
				refreshGridModel();
				responseData();
			}else if ("del".equals(oper)){
			}else if("edit".equals(oper)){
			}
		}else{
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", results.size());
		dataMap.put("data", results);
		System.out.println(results);
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iEvalContObjAttriService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iEvalContObjAttriService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iEvalContObjAttriService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return this.iEvalContObjAttriService.queryByPage(criteria, from, length);
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public IEvalContObjAttriService getiEvalContObjAttriService() {
		return iEvalContObjAttriService;
	}

	public void setiEvalContObjAttriService(
			IEvalContObjAttriService iEvalContObjAttriService) {
		this.iEvalContObjAttriService = iEvalContObjAttriService;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public Integer getContID() {
		return contID;
	}

	public void setContID(Integer contID) {
		this.contID = contID;
	}

	public Integer getDistID() {
		return distID;
	}

	public void setDistID(Integer distID) {
		this.distID = distID;
	}

	public static Integer getEvalContID() {
		return evalContID;
	}

	public static void setEvalContID(Integer evalContID) {
		EvalContObjAttriAction.evalContID = evalContID;
	}

	public static Integer getExpertDistID() {
		return expertDistID;
	}

	public static void setExpertDistID(Integer expertDistID) {
		EvalContObjAttriAction.expertDistID = expertDistID;
	}
	

}
