package com.rural.colldatatemplet.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.DataCollDataDic;
import com.rural.bean.InvesObjAttri;
import com.rural.bean.InvesObj;
import com.rural.bean.InvesPro;
import com.rural.colldatatemplet.service.IInvesObjService;
import com.rural.evalsystem.action.EvalMethAction;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class InvesObjAction extends JqGridBaseAction{
	
   private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String old;//
	private String oper;



	private IInvesObjService iInvesObjService;
	private String JQID;
	public static String JQS;
	
	private String invesObjID;
	private String dataCollDataDicId;
	private String invesObjAttriId;
	private String invesProNum;
	private String invesObjCode;
	private String invesObjName;
	private String invesObjComp;
	private String invesObjLengt;
	private String mus;

	public String getMus() {
		return mus;
	}

	public void setMus(String mus) {
		this.mus = mus;
	}


	private String invesObjNote;
	
	private static String ObjlSysIDs;//判断选中的节点是叶子节点还是父节点
	private static String ObjlFSysIDs;//判断选中的节点是叶子节点还是父节点

	private String ObjFSID;

	
	
	public IInvesObjService getiInvesObjService() {
		return iInvesObjService;
	}

	public void setiInvesObjService(IInvesObjService iInvesObjService) {
		this.iInvesObjService = iInvesObjService;
	}

	public String getObjFSID() {
		return ObjFSID;
	}

	public void setObjFSID(String objFSID) {
		ObjFSID = objFSID;
	}

	public static String getObjlSysIDs() {
		return ObjlSysIDs;
	}

	public static void setObjlSysIDs(String objlSysIDs) {
		ObjlSysIDs = objlSysIDs;
	}

	public static String getObjlFSysIDs() {
		return ObjlFSysIDs;
	}

	public static void setObjlFSysIDs(String objlFSysIDs) {
		ObjlFSysIDs = objlFSysIDs;
	}


	public String manageInvesObj() {
		InvesObjAction.setJQS(JQID);
		
		
		InvesObjAction.setObjlFSysIDs(ObjFSID);
		
		InvesObjAction.setObjlSysIDs(JQID);
		
		if(!search){
			if ("add".equals(oper)) {//
			  addInvesObjAttri();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
			   delInvesObjAttri();
			}else if("edit".equals(oper)){//
				updateInvesObjAttri();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	//判断编码是否重复
	public String objCodeCheck(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(invesObjID.equals("undefined"))
				invesObjID=null;//若id未定义则给其赋值为null
				boolean flag = iInvesObjService.objCodeCheck(invesObjCode,invesObjID);
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
	
	
	
	
	
	//更新
	public String updateInvesObjAttri() {
		// TODO Auto-generated method stub
		iInvesObjService.updateInvesObj(Integer.parseInt(invesObjID),Integer.parseInt(dataCollDataDicId), Integer.parseInt(invesObjAttriId), invesProNum,  invesObjCode, invesObjName, 
				invesObjComp, invesObjLengt, Boolean.parseBoolean(mus), invesObjNote);
		this.dataMap.put("success", true);
		return SUCCESS;
	}
	//添加
	public String addInvesObjAttri() {
		// TODO Auto-generated method stub
		boolean flag=iInvesObjService.addInvesObj( Integer.parseInt(dataCollDataDicId), Integer.parseInt(invesObjAttriId), JQID,  invesObjCode, invesObjName.trim(), 
				invesObjComp.trim(), invesObjLengt.trim(), Boolean.parseBoolean(mus), invesObjNote.trim());
		if(flag){
		  this.dataMap.put("success", "添加成功");
		}else{
			this.dataMap.put("success","不允许给父节点添加对象");
		}
		return SUCCESS;
	}
	//删除
	public String delInvesObjAttri() {
		// TODO Auto-generated method stub
				
		String message="";
		for(String id: invesObjID.split(",")){
			
			message= message+ iInvesObjService.delInvesObj(Integer.parseInt(id));
		}
		dataMap.put("success", message);
	    return SUCCESS;
	}

	
	


	public String getInvesObjID() {
		return invesObjID;
	}

	public void setInvesObjID(String invesObjID) {
		this.invesObjID = invesObjID;
	}



	public String getDataCollDataDicId() {
		return dataCollDataDicId;
	}

	public void setDataCollDataDicId(String dataCollDataDicId) {
		this.dataCollDataDicId = dataCollDataDicId;
	}

	public String getInvesObjAttriId() {
		return invesObjAttriId;
	}

	public void setInvesObjAttriId(String invesObjAttriId) {
		this.invesObjAttriId = invesObjAttriId;
	}

	public String getInvesProNum() {
		return invesProNum;
	}

	public void setInvesProNum(String invesProNum) {
		this.invesProNum = invesProNum;
	}

	public String getInvesObjCode() {
		return invesObjCode;
	}

	public void setInvesObjCode(String invesObjCode) {
		this.invesObjCode = invesObjCode;
	}

	public String getInvesObjName() {
		return invesObjName;
	}

	public void setInvesObjName(String invesObjName) {
		this.invesObjName = invesObjName;
	}

	public String getInvesObjComp() {
		return invesObjComp;
	}

	public void setInvesObjComp(String invesObjComp) {
		this.invesObjComp = invesObjComp;
	}

	public String getInvesObjLengt() {
		return invesObjLengt;
	}

	public void setInvesObjLengt(String invesObjLengt) {
		this.invesObjLengt = invesObjLengt;
	}



	public String getInvesObjNote() {
		return invesObjNote;
	}

	public void setInvesObjNote(String invesObjNote) {
		this.invesObjNote = invesObjNote;
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iInvesObjService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.iInvesObjService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.iInvesObjService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.iInvesObjService.queryByPage(criteria, from, length);
		
	}
	
	
	
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public IInvesObjService getiInvesObjAttriService() {
		return iInvesObjService;
	}

	public void setiInvesObjAttriService(IInvesObjService iInvesObjAttriService) {
		this.iInvesObjService = iInvesObjAttriService;
	}

	public String getJQID() {
		return JQID;
	}

	public void setJQID(String jQID) {
		JQID = jQID;
	}

	public static String getJQS() {
		return JQS;
	}

	public static void setJQS(String jQS) {
		JQS = jQS;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
