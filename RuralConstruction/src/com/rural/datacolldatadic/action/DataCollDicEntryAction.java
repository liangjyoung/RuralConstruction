package com.rural.datacolldatadic.action;


import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.datacolldatadic.service.IDataCollDicEntryService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class DataCollDicEntryAction extends JqGridBaseAction{
	
private static final long serialVersionUID = 1L;

	

	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private IDataCollDicEntryService iDataCollDicEntryService;
	//private int JQID;
	//public static int JQS;
	private String dicEntryCode;
	private String dicEntryName;
	private String dataCollDicEntryId;
	
	public String rowids;
	public static String ids;
	public static int rowNums;
	public int rowNum;
	private String JQID;
    public static String JQS;
	
	
	public String getRowids() {
		return rowids;
	}
	public void setRowids(String rowids) {
		this.rowids = rowids;
	}
	public static String getIds() {
		return ids;
	}
	public static void setIds(String ids) {
		DataCollDicEntryAction.ids = ids;
	}
	public static int getRowNums() {
		return rowNums;
	}
	public static void setRowNums(int rowNums) {
		DataCollDicEntryAction.rowNums = rowNums;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public String getDataCollDicEntryId() {
		return dataCollDicEntryId;
	}
	public void setDataCollDicEntryId(String dataCollDicEntryId) {
		this.dataCollDicEntryId = dataCollDicEntryId;
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
	public IDataCollDicEntryService getiDataCollDicEntryService() {
		return iDataCollDicEntryService;
	}
	public void setiDataCollDicEntryService(
			IDataCollDicEntryService iDataCollDicEntryService) {
		this.iDataCollDicEntryService = iDataCollDicEntryService;
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
	public String getDicEntryCode() {
		return dicEntryCode;
	}
	public void setDicEntryCode(String dicEntryCode) {
		this.dicEntryCode = dicEntryCode;
	}
	
	
	public String getDicEntryName() {
		return dicEntryName;
	}
	public void setDicEntryName(String dicEntryName) {
		this.dicEntryName = dicEntryName;
		
	}
	
	//判断编码是否重复
	public String checkEntryCode(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(dataCollDicEntryId.equals("undefined"))dataCollDicEntryId=null;//若id未定义则给其赋值为null
				boolean flag = iDataCollDicEntryService.checkEntryCode(dicEntryCode,dataCollDicEntryId);
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
	public String manageDataCollDicEntry() {
		DataCollDicEntryAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {//
			
				addDataCollDicEntry();
			} else if ("search".equals(oper)) {//
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//
				delDataCollDicEntry();
			}else if("edit".equals(oper)){//
				updateDataCollDicEntry();
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
	public String updateDataCollDicEntry() {
		// TODO Auto-generated method stub
		iDataCollDicEntryService.updateDataCollDicEntry(Integer.parseInt(dataCollDicEntryId),dicEntryCode, dicEntryName);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delDataCollDicEntry() {
		// TODO Auto-generated method stub
		String message="";
		for(String a:dataCollDicEntryId.split(",")){
		
			message= message + iDataCollDicEntryService.delDataCollDicEntry(Integer.parseInt(a));
		}
	
		this.dataMap.put("success", message);
		return SUCCESS;
	}

	public String addDataCollDicEntry() {
		// TODO Auto-generated method stub
		String message = "";
		String dataCollDataDicId = DataCollDicEntryAction.getJQS();
		message= iDataCollDicEntryService.addDataCollDicEntry(dicEntryCode,dataCollDataDicId,dicEntryName);
		this.dataMap.put("success", message);
		return SUCCESS;
	}

	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	
	
	
	//导出到EXCEL开始
	InputStream is;
	
	public String exportToExcelEntry(){
		
		DataCollDicEntryAction.setIds(rowids);
		DataCollDicEntryAction.setRowNums(rowNum);
		if(rowNum>1){
        is = iDataCollDicEntryService.exportToExcel();
		}
		
		if(rowNum==1){
			 is = iDataCollDicEntryService.exportToExcelNow();
			
		}
		
		return "excel";
	}
	
	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
	//导出到EXCEL结束
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iDataCollDicEntryService.queryResultsCount(null);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return  this.iDataCollDicEntryService.queryByPage(null, from, length);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return  this.iDataCollDicEntryService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return results=this.iDataCollDicEntryService.queryByPage(criteria, from, length);
		
	}
	

}
