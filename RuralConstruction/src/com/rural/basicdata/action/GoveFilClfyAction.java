package com.rural.basicdata.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.basicdata.service.IGoveFilClfyService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class GoveFilClfyAction extends JqGridBaseAction{
	private static final long serialVersionUID = 1L;
	private IGoveFilClfyService iGoveFilClfyService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String goveFilClfyNum;
	private String goveFilClfyName;
	private String goveFilClfyNote;
	private String id;
	public IGoveFilClfyService getiGoveFilClfyService() {
		return iGoveFilClfyService;
	}
	public void setiGoveFilClfyService(IGoveFilClfyService iGoveFilClfyService) {
		this.iGoveFilClfyService = iGoveFilClfyService;
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
	public String getGoveFilClfyNum() {
		return goveFilClfyNum;
	}
	public void setGoveFilClfyNum(String goveFilClfyNum) {
		this.goveFilClfyNum = goveFilClfyNum;
	}
	public String getGoveFilClfyName() {
		return goveFilClfyName;
	}
	public void setGoveFilClfyName(String goveFilClfyName) {
		this.goveFilClfyName = goveFilClfyName;
	}
	public String getGoveFilClfyNote() {
		return goveFilClfyNote;
	}
	public void setGoveFilClfyNote(String goveFilClfyNote) {
		this.goveFilClfyNote = goveFilClfyNote;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String manageGoveFilClfy(){
		
		if(!search){
			if ("add".equals(oper)) {//����
				addGoveFilClfy();
			} else if ("search".equals(oper)) {//����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//ɾ��
				delGoveFilClfy();
			}else if("edit".equals(oper)){//�޸�
				updateGoveFilClfy();
			}
		}else{//��ѯ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	public String updateGoveFilClfy() {
		// TODO Auto-generated method stub
		iGoveFilClfyService.updateGoveFilClfy(Integer.parseInt(id), goveFilClfyNum,goveFilClfyName,goveFilClfyNote);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delGoveFilClfy() {
		// TODO Auto-generated method stub
		String message="";
		for(String goveFilClfy: id.split(",")){
			//iGoveFilClfyService.delGoveFilClfy(Integer.parseInt(goveFilClfy));
			message= message+ iGoveFilClfyService.delGoveFilClfy(Integer.parseInt(goveFilClfy));
		}
		this.dataMap.put("success", message);
		return SUCCESS;
	}

	public String addGoveFilClfy() {
		// TODO Auto-generated method stub
		iGoveFilClfyService.addGoveFilClfy(goveFilClfyNum, goveFilClfyName,goveFilClfyNote);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	//判断政府文件编码是否重复
	public String checkGoveFilClfyNum(){
		
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(id.equals("undefined"))id=null;//若id未定义则给其赋值为null
				boolean flag = iGoveFilClfyService.checkGoveFilClfyNum(goveFilClfyNum,id);
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
		return this.iGoveFilClfyService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iGoveFilClfyService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iGoveFilClfyService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iGoveFilClfyService.queryByPage(criteria, from, length);
		return results;
	}
}

