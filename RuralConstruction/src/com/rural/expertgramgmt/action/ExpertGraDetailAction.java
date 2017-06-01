package com.rural.expertgramgmt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.expertgramgmt.service.IExpertGraDetailService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class ExpertGraDetailAction extends JqGridBaseAction {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private Integer evalScoId;
	private Integer evalContId;
	private static Integer sid;
	private static Integer cid;
	private IExpertGraDetailService iExpertGraDetailService;
	
	public String getSco(){
		ExpertGraDetailAction.setSid(evalScoId);
		ExpertGraDetailAction.setCid(evalContId);
		if(!search){
			if ("add".equals(oper)) {//
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
			}else if("edit".equals(oper)){//
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
	
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return iExpertGraDetailService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return iExpertGraDetailService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return iExpertGraDetailService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return iExpertGraDetailService.queryByPage(criteria, from, length);
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

	public Integer getEvalScoId() {
		return evalScoId;
	}

	public void setEvalScoId(Integer evalScoId) {
		this.evalScoId = evalScoId;
	}

	public Integer getEvalContId() {
		return evalContId;
	}

	public void setEvalContId(Integer evalContId) {
		this.evalContId = evalContId;
	}

	public IExpertGraDetailService getiExpertGraDetailService() {
		return iExpertGraDetailService;
	}

	public void setiExpertGraDetailService(
			IExpertGraDetailService iExpertGraDetailService) {
		this.iExpertGraDetailService = iExpertGraDetailService;
	}

	public static Integer getSid() {
		return sid;
	}

	public static void setSid(Integer sid) {
		ExpertGraDetailAction.sid = sid;
	}

	public static Integer getCid() {
		return cid;
	}

	public static void setCid(Integer cid) {
		ExpertGraDetailAction.cid = cid;
	}

}
