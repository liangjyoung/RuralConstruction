package com.rural.datacolldatadic.action;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.datacolldatadic.service.IDataCollDataDicService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;


public class DataCollDataDicAction extends JqGridBaseAction {
	
	private static final long serialVersionUID = 1L;
	private IDataCollDataDicService iDataCollDataDicService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String dataCollDataDicId;
	private String dataDicCode;
	private String dataDicName;
	private boolean isdChoDic;
	private String JQID;
	public static String JQS;
	public String rowids;
	public static String ids;
	public static int rowNums;
	public int rowNum;
	
	
	public static int getRowNums() {
		return rowNums;
	}
	public static void setRowNums(int rowNums) {
		DataCollDataDicAction.rowNums = rowNums;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public static String getIds() {
		return ids;
	}
	public static void setIds(String ids) {
		DataCollDataDicAction.ids = ids;
	}
	public String getRowids() {
		return rowids;
	}
	public void setRowids(String rowids) {
		this.rowids = rowids;
	}
	public IDataCollDataDicService getiDataCollDataDicService() {
		return iDataCollDataDicService;
	}
	public void setiDataCollDataDicService(
			IDataCollDataDicService iDataCollDataDicService) {
		this.iDataCollDataDicService = iDataCollDataDicService;
	}
	
	
	
	
	public String getDataCollDataDicId() {
		return dataCollDataDicId;
	}
	public void setDataCollDataDicId(String dataCollDataDicId) {
		this.dataCollDataDicId = dataCollDataDicId;
	}
	public String getDataDicCode() {
		return dataDicCode;
	}
	public void setDataDicCode(String dataDicCode) {
		this.dataDicCode = dataDicCode;
	}
	public String getDataDicName() {
		return dataDicName;
	}
	public void setDataDicName(String dataDicName) {
		this.dataDicName = dataDicName;
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
	
	public boolean isIsdChoDic() {
		return isdChoDic;
	}
	public void setIsdChoDic(boolean isdChoDic) {
		this.isdChoDic = isdChoDic;
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
	
	
	//判断编码是否重复
	public String checkDicCode(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			
			if(dataCollDataDicId.equals("undefined"))dataCollDataDicId=null;//若id未定义则给其赋值为null
				boolean flag = iDataCollDataDicService.checkDicCode(dataDicCode,dataCollDataDicId);
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
	public String manageDataCollDataDic(){
		//DataCollDataDicAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {//增加
				addDataCollDataDic();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				delDataCollDataDic();
			}else if("edit".equals(oper)){//修改
				updateDataCollDataDic();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String updateDataCollDataDic() {
		// TODO Auto-generated method stub
		iDataCollDataDicService.updateDataCollDataDic(Integer.parseInt(dataCollDataDicId),dataDicCode,dataDicName,isdChoDic);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delDataCollDataDic() {
		// TODO Auto-generated method stub
		String message="";
		for(String a: dataCollDataDicId.split(",")){
	
			message= message +iDataCollDataDicService.delDataCollDataDic(Integer.parseInt(a));
		}

		this.dataMap.put("success", message);
		return SUCCESS;
	}

	public String addDataCollDataDic() {
		// TODO Auto-generated method stub
		iDataCollDataDicService.addDataCollDataDic(dataDicCode,dataDicName,isdChoDic);
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
	


	//导出到EXCEL开始
	InputStream is;
	
	
	public String exportToExcelDic(){
        is = iDataCollDataDicService.exportToExcel();
		return "excel";
	}
	
	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
	//导出到EXCEL结束
	
	
	

	//导出到EXCEL开始
	InputStream iss;
	
	
	public String exportToExcelDicNow(){
		DataCollDataDicAction.setIds(rowids);
		DataCollDataDicAction.setRowNums(rowNum);
		if(rowNum>1){
        
        iss = iDataCollDataDicService.exportToExcel();
		}
		
		if(rowNum==1){
			iss = iDataCollDataDicService.exportToExcelNow();
			 
		}
		
		return "excel";
	}
	
	
	//导出到EXCEL结束
	
	
	public InputStream getIss() {
		return iss;
	}
	public void setIss(InputStream iss) {
		this.iss = iss;
	}
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iDataCollDataDicService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iDataCollDataDicService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iDataCollDataDicService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iDataCollDataDicService.queryByPage(criteria, from, length);
		return results;
	}

}
