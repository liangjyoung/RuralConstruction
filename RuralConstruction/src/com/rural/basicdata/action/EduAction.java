package com.rural.basicdata.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.basicdata.service.IEduService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class EduAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private IEduService iEduService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String id;
	private String eduCode;
	private String eduName;
	public IEduService getiEduService() {
		return iEduService;
	}
	public void setiEduService(IEduService iEduService) {
		this.iEduService = iEduService;
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
	public String getEduCode() {
		return eduCode;
	}
	public void setEduCode(String eduCode) {
		this.eduCode = eduCode;
	}
	public String getEduName() {
		return eduName;
	}
	public void setEduName(String eduName) {
		this.eduName = eduName;
	}
	
	public String manageEdu(){
		if(!search){
			if ("add".equals(oper)) {//����
				addEdu();
			} else if ("search".equals(oper)) {//����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//ɾ��
				delEdu();
			}else if("edit".equals(oper)){//�޸�
				updateEdu();
			}
		}else{//��ѯ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	public String updateEdu() {
		// TODO Auto-generated method stub
		iEduService.updateEdu(Integer.parseInt(id), eduCode,eduName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delEdu() {
		// TODO Auto-generated method stub
		String message="";
		for(String edu: id.split(",")){
			
			message= message+ iEduService.delEdu(Integer.parseInt(edu));
		}
		dataMap.put("success", message);
	    return SUCCESS;
	}

	public String addEdu() {
		// TODO Auto-generated method stub
		iEduService.addEdu(eduCode, eduName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	//判断性别编码是否重复
	public String checkEduCode(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(id.equals("undefined"))id=null;//若id未定义则给其赋值为null
				boolean flag = iEduService.checkEduCode(eduCode,id);
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

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iEduService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iEduService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iEduService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iEduService.queryByPage(criteria, from, length);
		return results;
	}
	
}
