package com.rural.basicdata.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.basicdata.service.IInvesObjAttriService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class InvesObjAttriAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private IInvesObjAttriService iInvesObjAttriService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String invesObjAttriNum;
	private String invesObjAttriName;
	private String id;
	public IInvesObjAttriService getiInvesObjAttriService() {
		return iInvesObjAttriService;
	}
	public void setiInvesObjAttriService(IInvesObjAttriService iInvesObjAttriService) {
		this.iInvesObjAttriService = iInvesObjAttriService;
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
	public String getInvesObjAttriNum() {
		return invesObjAttriNum;
	}
	public void setInvesObjAttriNum(String invesObjAttriNum) {
		this.invesObjAttriNum = invesObjAttriNum;
	}
	public String getInvesObjAttriName() {
		return invesObjAttriName;
	}
	public void setInvesObjAttriName(String invesObjAttriName) {
		this.invesObjAttriName = invesObjAttriName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String manageInvesObjAttri(){
		if(!search){
			if ("add".equals(oper)) {//����
				addInvesObjAttri();
			} else if ("search".equals(oper)) {//����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//ɾ��
				delInvesObjAttri();
			}else if("edit".equals(oper)){//�޸�
				updateInvesObjAttri();
			}
		}else{//��ѯ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	

	//判断民族编码是否重复
	public String checkInvesObjAttriNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(id.equals("undefined"))id=null;//若id未定义则给其赋值为null
				boolean flag = iInvesObjAttriService.checkInvesObjAttriNum(invesObjAttriNum,id);
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
	
	public String addInvesObjAttri() {
		// TODO Auto-generated method stub
		iInvesObjAttriService.addInvesObjAttri(invesObjAttriNum, invesObjAttriName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	public String delInvesObjAttri() {
		// TODO Auto-generated method stub
		String message="";
		/*for(String invesObjAttriCatg: id.split(",")){
			iInvesObjAttriService.delInvesObjAttri(Integer.parseInt(invesObjAttriCatg));
		}
		this.dataMap.put("success", true);
		return SUCCESS;*/
		for(String invesObjAttriCatg: id.split(",")){
			
			message= message+ iInvesObjAttriService.delInvesObjAttri(Integer.parseInt(invesObjAttriCatg));
		}
		dataMap.put("success", message);
	    return SUCCESS;
	}
	public String updateInvesObjAttri() {
		// TODO Auto-generated method stub
		iInvesObjAttriService.updateInvesObjAttri(Integer.parseInt(id), invesObjAttriNum,invesObjAttriName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iInvesObjAttriService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iInvesObjAttriService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iInvesObjAttriService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return this.iInvesObjAttriService.queryByPage(criteria, from, length);
	}
}
