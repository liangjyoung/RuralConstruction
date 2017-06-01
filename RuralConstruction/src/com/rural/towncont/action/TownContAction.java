package com.rural.towncont.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.rural.towncont.service.ITownContService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class TownContAction extends JqGridBaseAction{
	private static final long serialVersionUID = 1L;
	private ITownContService iTownContService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String townContID;
	private String townContNum;
	private String townContName;
	private String townContWorkTel;
	private String townContMobTel;
	private String townComp;
	private String townPost;
	private String townNote;
	//private int townBasicInfoID = 4;
	private String townNum ="371202106000";
	
	
	public String getTownContNum() {
		return townContNum;
	}
	public void setTownContNum(String townContNum) {
		this.townContNum = townContNum;
	}
	
	public String getTownNum() {
		return townNum;
	}
	public void setTownNum(String townNum) {
		this.townNum = townNum;
	}
	public ITownContService getiTownContService() {
		return iTownContService;
	}
	public void setiTownContService(ITownContService iTownContService) {
		this.iTownContService = iTownContService;
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
	
	public String getTownContID() {
		return townContID;
	}
	public void setTownContID(String townContID) {
		this.townContID = townContID;
	}
	public String getTownContName() {
		return townContName;
	}
	public void setTownContName(String townContName) {
		this.townContName = townContName;
	}
	
	public String getTownContWorkTel() {
		return townContWorkTel;
	}
	public void setTownContWorkTel(String townContWorkTel) {
		this.townContWorkTel = townContWorkTel;
	}
	public String getTownContMobTel() {
		return townContMobTel;
	}
	public void setTownContMobTel(String townContMobTel) {
		this.townContMobTel = townContMobTel;
	}
	public String getTownComp() {
		return townComp;
	}
	public void setTownComp(String townComp) {
		this.townComp = townComp;
	}
	public String getTownPost() {
		return townPost;
	}
	public void setTownPost(String townPost) {
		this.townPost = townPost;
	}
	public String getTownNote() {
		return townNote;
	}
	public void setTownNote(String townNote) {
		this.townNote = townNote;
	}
	
	//判断编码是否重复
	public String checkTownContNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(townContID.equals("undefined"))townContID=null;//若id未定义则给其赋值为null
				boolean flag = iTownContService.checkTownContNum(townContNum,townContID);
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
	
	public String manageTownCont(){
		if(!search){
			if ("add".equals(oper)) {//增加
				 addTownCont();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				 delTownCont() ;
			}else if("edit".equals(oper)){//修改
				
				 updateTownCont() ;
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	public String updateTownCont() {
		// TODO Auto-generated method stub
		iTownContService.updateTownCont(Integer.parseInt(townContID), townContNum,townContName, townContWorkTel,townContMobTel, townComp, townPost, townNote);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delTownCont() {
		// TODO Auto-generated method stub
		for(String a : townContID.split(",")){
		
	    iTownContService.delTownCont(Integer.parseInt(a));
	    }
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String addTownCont() {
		// TODO Auto-generated method stub
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		int townBasicInfoID = iTownContService.getTownID(sysUserBeloDiviCode);
		iTownContService.addTownCont(townBasicInfoID, townContNum,townContName, townContWorkTel,townContMobTel, townComp, townPost, townNote);
		this.dataMap.put("success", true);
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
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		// TODO Auto-generated method stub
		int townBasicInfoID = iTownContService.getTownID(sysUserBeloDiviCode);
		return this.iTownContService.queryResultsCount(townBasicInfoID,null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iTownContService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		int townBasicInfoID = iTownContService.getTownID(sysUserBeloDiviCode);
		// TODO Auto-generated method stub
		return this.iTownContService.queryByPage(townBasicInfoID, null, from, length);

	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iTownContService.queryByPage(criteria, from, length);
		return results;
	}

}
