package com.rural.invgat.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.invgat.service.IInvgatService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class InvgatAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private IInvgatService iInvgatService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String id;
	private String invgatNum;
	private String eduID;
	private String invgatMajor;
	private Integer sexID;
	private Integer nationID;
	private Integer polID;
	private String invgatName;
	private Date invgatBirth;
	private String invgatComp;
	private String invgatTel;
	private String invgatNote;
	
	public IInvgatService getiInvgatService() {
		return iInvgatService;
	}
	public void setiInvgatService(IInvgatService iInvgatService) {
		this.iInvgatService = iInvgatService;
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
	public String getInvgatNum() {
		return invgatNum;
	}
	public void setInvgatNum(String invgatNum) {
		this.invgatNum = invgatNum;
	}
	
	
	
	public String getEduID() {
		return eduID;
	}
	public void setEduID(String eduID) {
		this.eduID = eduID;
	}
	public Integer getSexID() {
		return sexID;
	}
	public void setSexID(Integer sexID) {
		this.sexID = sexID;
	}
	public Integer getNationID() {
		return nationID;
	}
	public void setNationID(Integer nationID) {
		this.nationID = nationID;
	}
	public Integer getPolID() {
		return polID;
	}
	public void setPolID(Integer polID) {
		this.polID = polID;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInvgatName() {
		return invgatName;
	}
	public void setInvgatName(String invgatName) {
		this.invgatName = invgatName;
	}
	public Date getInvgatBirth() {
		return invgatBirth;
	}
	public void setInvgatBirth(Date invgatBirth) {
		this.invgatBirth = invgatBirth;
	}
	public String getInvgatComp() {
		return invgatComp;
	}
	public void setInvgatComp(String invgatComp) {
		this.invgatComp = invgatComp;
	}
	public String getInvgatTel() {
		return invgatTel;
	}
	public void setInvgatTel(String invgatTel) {
		this.invgatTel = invgatTel;
	}
	public String getInvgatNote() {
		return invgatNote;
	}
	public void setInvgatNote(String invgatNote) {
		this.invgatNote = invgatNote;
	}
	
	
	public String getInvgatMajor() {
		return invgatMajor;
	}
	public void setInvgatMajor(String invgatMajor) {
		this.invgatMajor = invgatMajor;
	}
	
	
	public String manageInvgat(){
		
		if(!search){
			if ("add".equals(oper)) {//增加
				addInvgat();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				delInvgat();
			}else if("edit".equals(oper)){//修改
				updateInvgat();
				
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String updateInvgat() {
		// TODO Auto-generated method stub
		iInvgatService.updateInvgat(Integer.parseInt(id),invgatNum, Integer.parseInt(eduID),invgatMajor,sexID, nationID, polID, invgatName, invgatBirth, invgatComp, invgatTel);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	public String delInvgat() {
		// TODO Auto-generated method stub
		/*for(String invgat: id.split(",")){
			iInvgatService.delInvgat(Integer.parseInt(invgat));
		}
		this.dataMap.put("success", true);
		return SUCCESS;*/
		String message="";
		for(String invgat: id.split(",")){
			
			message= message+ iInvgatService.delInvgat(Integer.parseInt(invgat));
		}
		dataMap.put("success", message);
	    return SUCCESS;
	}

	public String addInvgat() {
		// TODO Auto-generated method stub
		iInvgatService.addInvgat(invgatNum, Integer.parseInt(eduID),invgatMajor,sexID, nationID, polID, invgatName, invgatBirth, invgatComp, invgatTel);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	
	//判断调查员编号是否重复
	public String checkInvgatNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(id.equals("undefined"))id=null;//若id未定义则给其赋值为null
				boolean flag = iInvgatService.checkInvgatNum(invgatNum,id);
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
	 * 打包服务器响应数据
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
		return this.iInvgatService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iInvgatService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iInvgatService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iInvgatService.queryByPage(criteria, from, length);
		return results;
	}
}
