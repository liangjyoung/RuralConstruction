package com.rural.basicdata.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.basicdata.service.IPolService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class PolAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private IPolService iPolService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String polCode;
	private String polName;
	private String id;
	public IPolService getiPolService() {
		return iPolService;
	}
	public void setiPolService(IPolService iPolService) {
		this.iPolService = iPolService;
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
	public String getPolCode() {
		return polCode;
	}
	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}
	public String getPolName() {
		return polName;
	}
	public void setPolName(String polName) {
		this.polName = polName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String managePol(){
		if(!search){
			if ("add".equals(oper)) {//����
				addPol();
			} else if ("search".equals(oper)) {//����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//ɾ��
				delPol();
			}else if("edit".equals(oper)){//�޸�
				updatePol();
			}
		}else{//��ѯ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String updatePol() {
		// TODO Auto-generated method stub
		iPolService.updatePol(Integer.parseInt(id), polCode,polName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delPol() {
		String message="";
		for(String pol: id.split(",")){
			
			message= message+ iPolService.delPol(Integer.parseInt(pol));
		}
		dataMap.put("success", message);
		return SUCCESS;
	}

	public String addPol() {
		// TODO Auto-generated method stub
		iPolService.addPol(polCode, polName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	//判断代码是否重复
	public String checkPolCode(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(id.equals("undefined"))id=null;//若id未定义则给其赋值为null
				boolean flag = iPolService.checkPolCode(polCode,id);
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
		return this.iPolService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iPolService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iPolService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iPolService.queryByPage(criteria, from, length);
		return results;
	}
}
