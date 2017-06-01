package com.rural.basicdata.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.basicdata.service.INationService;
import com.rural.bean.Nation;
import com.rural.bean.Sex;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class NationAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private INationService iNationService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String nationCode;
	private String nationName;
	private String id;
	public INationService getiNationService() {
		return iNationService;
	}
	public void setiNationService(INationService iNationService) {
		this.iNationService = iNationService;
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
	public String getNationCode() {
		return nationCode;
	}
	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String manageNation(){
		if(!search){
			if ("add".equals(oper)) {//����
				addNation();
			} else if ("search".equals(oper)) {//����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//ɾ��
				delNation();
			}else if("edit".equals(oper)){//�޸�
				updateNation();
			}
		}else{//��ѯ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	

	//判断民族编码是否重复
	public String checkNationCode(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(id.equals("undefined"))id=null;//若id未定义则给其赋值为null
				boolean flag = iNationService.checkNationCode(nationCode,id);
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
	/**
	 * ����������Ӧ���
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	public String addNation() {
		// TODO Auto-generated method stub
		iNationService.addNation(nationCode, nationName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	public String delNation() {
		// TODO Auto-generated method stub
//		for(String nation: id.split(",")){
//			Nation s = iNationService.getNationById(Integer.parseInt(nation));
//			if(s == null){
//				iNationService.delNation(Integer.parseInt(nation));
//				this.dataMap.put("success", true);
//			}else{
//				this.dataMap.put("success", true);
//			}
//		}
//		return SUCCESS;
		String message="";
		for(String nation: id.split(",")){
			
			message= message+ iNationService.delNation(Integer.parseInt(nation));
		}
		
		
		
		
		dataMap.put("success", message);
	    return SUCCESS;
		
	}
	public String updateNation() {
		// TODO Auto-generated method stub
		iNationService.updateNation(Integer.parseInt(id),nationCode,nationName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iNationService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iNationService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iNationService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return this.iNationService.queryByPage(criteria, from, length);
	}
	
}
