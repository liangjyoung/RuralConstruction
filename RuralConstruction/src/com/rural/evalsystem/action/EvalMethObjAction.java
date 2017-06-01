package com.rural.evalsystem.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.InvesObj;
import com.rural.dao.InvesObjDAO;
import com.rural.evalsystem.service.IEvalMethObjService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class EvalMethObjAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;

	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private IEvalMethObjService evalMethObjService;
	private String InvesObjids;
	private String EvalMethObjID;
	private String EvalMethID;
	private static String EvalMethObjIDS;
	private InvesObjDAO invesObjDAO = new InvesObjDAO();
	public String aa(){
		dataMap.put("ss", "ss");
		return SUCCESS;
	}
	
	public String manageEvalMethObj(){
		
		if(!search){
			if ("add".equals(oper)) {//增加
				addInvesObj();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				//delCountryBasicInfo();
			}else if("edit".equals(oper)){//修改
				//updateCountryBasicInfo();
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
	
	public String 	addInvesObj() {
		// TODO Auto-generated method stub
		String message = "";
		String disInvesObjids =  "";
		String unInvesObjids = "";
		
		for(String a : InvesObjids.split(",")){
			String meg = "";
			meg = evalMethObjService.addInvesObj(EvalMethID.trim(), a.trim());
			int m = Integer.parseInt(a.trim());
			InvesObj invesObj = new InvesObj();
			invesObj = invesObjDAO.findById(m);
			String code = invesObj.getInvesObjCode();
			
			if(meg.trim().equals("已分配")){
				
				disInvesObjids = disInvesObjids + code + ",";
			}else{
				unInvesObjids = unInvesObjids + code + ",";
			}
			//System.out.println(a+"---->"+EvalMethID);
		}
		
		if (disInvesObjids != ""&& unInvesObjids!= "") {
			disInvesObjids = disInvesObjids.substring(0, disInvesObjids.lastIndexOf(","));
			unInvesObjids = unInvesObjids.substring(0, unInvesObjids.lastIndexOf(","));
			message = "调查对象编号为："+disInvesObjids+"的对象已经分配，无法继续分配;  调查对象编号为："+unInvesObjids+"的对象分配成功。";
			
		} else if(unInvesObjids == ""){
			disInvesObjids = disInvesObjids.substring(0, disInvesObjids.lastIndexOf(","));
			message = "调查对象编号为："+disInvesObjids+"的对象已经分配，无法继续分配";
			
		}else if(disInvesObjids == ""){
			unInvesObjids = unInvesObjids.substring(0, unInvesObjids.lastIndexOf(","));
			message = "调查对象编号为："+unInvesObjids+"的对象分配成功。";
			
		}else {
			message = "不可预知错误";
		}
		
		this.dataMap.put("success", message);
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
		return this.evalMethObjService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.evalMethObjService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.evalMethObjService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.evalMethObjService.queryByPage(criteria, from, length);
		return results;
	}

	public void setEvalMethObjService(IEvalMethObjService evalMethObjService) {
		this.evalMethObjService = evalMethObjService;
	}

	public IEvalMethObjService getEvalMethObjService() {
		return evalMethObjService;
	}

	public static String getEvalMethObjIDS() {
		return EvalMethObjIDS;
	}

	public static void setEvalMethObjIDS(String evalMethObjIDS) {
		EvalMethObjIDS = evalMethObjIDS;
	}

	public String getEvalMethObjID() {
		return EvalMethObjID;
	}

	public void setEvalMethObjID(String evalMethObjID) {
		EvalMethObjID = evalMethObjID;
	}

	public void setInvesObjids(String invesObjids) {
		InvesObjids = invesObjids;
	}

	public String getInvesObjids() {
		return InvesObjids;
	}

	public void setEvalMethID(String evalMethID) {
		EvalMethID = evalMethID;
	}

	public String getEvalMethID() {
		return EvalMethID;
	}

	public void setInvesObjDAO(InvesObjDAO invesObjDAO) {
		this.invesObjDAO = invesObjDAO;
	}

	public InvesObjDAO getInvesObjDAO() {
		return invesObjDAO;
	}

	

}
