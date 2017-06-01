package com.rural.basicdata.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.basicdata.service.ISexService;
import com.rural.bean.Sex;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class SexAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private ISexService iSexService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String id;
	private String sexCode;
	private String sexName;
	private boolean flag = false;
	
	
//	private String oldCode;
//	
//	public String getOldCode() {
//		return oldCode;
//	}
//	public void setOldCode(String oldCode) {
//		this.oldCode = oldCode;
//	}
	public ISexService getiSexService() {
		return iSexService;
	}
	public void setiSexService(ISexService iSexService) {
		this.iSexService = iSexService;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSexCode() {
		return sexCode;
	}
	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}
	public String getSexName() {
		return sexName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
	
	public String manageSex(){
		if(!search){
			if ("add".equals(oper)) {//����
				addSex();
			} else if ("search".equals(oper)) {//����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//ɾ��
				delSex();
			}else if("edit".equals(oper)){//�޸�
				updateSex();
			}
		}else{//��ѯ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	
	public String updateSex() {
		// TODO Auto-generated method stub
		iSexService.updateSex(Integer.parseInt(id), sexCode,sexName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

//	public String delSex() {
//		// TODO Auto-generated method stub
//		
//		iSexService.delSex(Integer.parseInt(id));
//		
//		this.dataMap.put("success", true);
//		return SUCCESS;
//	}
	
	public String delSex() {
	// TODO Auto-generated method stub
		//for(String sex: id.split(",")){
			//Sex s = iSexService.getSexById(Integer.parseInt(sex));
			//if(s != null){
		
				//iSexService.delSex(Integer.parseInt(id));
				//this.dataMap.put("success", true);
			//}else{
				//this.dataMap.put("success", false);
			//}
		//}
		//String sext = "";
		String message="";
		for(String sex: id.split(",")){
			
			//message= message+ iSexService.delSex(sex);
			message= message+ iSexService.delSex(Integer.parseInt(sex));
		}
		dataMap.put("success", message);
	    return SUCCESS;
}
	public String addSex() {
		// TODO Auto-generated method stub
		iSexService.addsex(sexCode, sexName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	//判断性别编码是否重复
	public String checkSexCode(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(id.equals("undefined"))id=null;//若id未定义则给其赋值为null
				boolean flag = iSexService.checkSexCode(sexCode,id);
				if(flag){
					dataMap.put("success", true);
				}else{
					dataMap.put("success", false);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iSexService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iSexService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iSexService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iSexService.queryByPage(criteria, from, length);
		return results;
	}
	
	
}
