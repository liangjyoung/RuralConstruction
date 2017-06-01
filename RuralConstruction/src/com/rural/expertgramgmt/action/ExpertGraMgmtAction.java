package com.rural.expertgramgmt.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.expertgramgmt.service.IExpertGraMgmtService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class ExpertGraMgmtAction extends JqGridBaseAction {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String vilNum;
	private static Integer vilId;
	private String oper;
	private IExpertGraMgmtService iExpertGraMgmtService;

	public String manageEvalContSco(){
		vilId = iExpertGraMgmtService.getVilIdByVilNum(vilNum);
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
		return iExpertGraMgmtService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return iExpertGraMgmtService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return iExpertGraMgmtService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return iExpertGraMgmtService.queryByPage(criteria, from, length);
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getVilNum() {
		return vilNum;
	}

	public void setVilNum(String vilNum) {
		this.vilNum = vilNum;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public IExpertGraMgmtService getiExpertGraMgmtService() {
		return iExpertGraMgmtService;
	}

	public void setiExpertGraMgmtService(IExpertGraMgmtService iExpertGraMgmtService) {
		this.iExpertGraMgmtService = iExpertGraMgmtService;
	}

	public static Integer getVilId() {
		return vilId;
	}

	public static void setVilId(Integer vilId) {
		ExpertGraMgmtAction.vilId = vilId;
	}
	

}
