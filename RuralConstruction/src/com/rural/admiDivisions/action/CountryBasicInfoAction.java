package com.rural.admiDivisions.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.admiDivisions.service.ICountryBasicInfoService;
import com.rural.datacolldatadic.action.DataCollDicEntryAction;
import com.rural.datacolldatadic.service.IDataCollDicEntryService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class CountryBasicInfoAction extends JqGridBaseAction{
	
	private static final long serialVersionUID = 1L;
	private ICountryBasicInfoService iCountryBasicInfoService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private int JQID;
	public static int JQS;
	private String countryBasicInfoID;
	private String oper;
	private String countryNum;
	private String countryName;
	private String countryLongi;
	private String countryLati;
	private String countryMeas;
	private String countryPop;
	private String countryHholds;
	//private byte[] countryIntro;
	
	private String countryIntro;
	
	
	public String rowids;
	public static String ids;
	public static int rowNums;
	public int rowNum;
	
	
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
		CountryBasicInfoAction.ids = ids;
	}
	public static int getRowNums() {
		return rowNums;
	}
	public static void setRowNums(int rowNums) {
		CountryBasicInfoAction.rowNums = rowNums;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getJQID() {
		return JQID;
	}
	public void setJQID(int jQID) {
		JQID = jQID;
	}
	public static int getJQS() {
		return JQS;
	}
	public static void setJQS(int jQS) {
		JQS = jQS;
	}
	public String getCountryBasicInfoID() {
		return countryBasicInfoID;
	}
	public void setCountryBasicInfoID(String countryBasicInfoID) {
		this.countryBasicInfoID = countryBasicInfoID;
	}
	public ICountryBasicInfoService getiCountryBasicInfoService() {
		return iCountryBasicInfoService;
	}
	public void setiCountryBasicInfoService(
			ICountryBasicInfoService iCountryBasicInfoService) {
		this.iCountryBasicInfoService = iCountryBasicInfoService;
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
	public String getCountryNum() {
		return countryNum;
	}
	public void setCountryNum(String countryNum) {
		this.countryNum = countryNum;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public String getCountryLongi() {
		return countryLongi;
	}
	public void setCountryLongi(String countryLongi) {
		this.countryLongi = countryLongi;
	}
	public String getCountryLati() {
		return countryLati;
	}
	public void setCountryLati(String countryLati) {
		this.countryLati = countryLati;
	}
	public String getCountryMeas() {
		return countryMeas;
	}
	public void setCountryMeas(String countryMeas) {
		this.countryMeas = countryMeas;
	}
	public String getCountryPop() {
		return countryPop;
	}
	public void setCountryPop(String countryPop) {
		this.countryPop = countryPop;
	}
	public String getCountryHholds() {
		return countryHholds;
	}
	public void setCountryHholds(String countryHholds) {
		this.countryHholds = countryHholds;
	}
	
	
	
	public String getCountryIntro() {
		return countryIntro;
	}
	public void setCountryIntro(String countryIntro) {
		this.countryIntro = countryIntro;
	}
	//判断编码是否重复
	public String checkCountryNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(countryBasicInfoID.equals("undefined"))countryBasicInfoID=null;//若id未定义则给其赋值为null
				boolean flag = iCountryBasicInfoService.checkCountryNum(countryNum,countryBasicInfoID);
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

	public String manageCountryBasicInfo(){
		CountryBasicInfoAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {//增加
				addCountryBasicInfo();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				delCountryBasicInfo();
			}else if("edit".equals(oper)){//修改
				updateCountryBasicInfo();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String updateCountryBasicInfo() {
		// TODO Auto-generated method stub
		String message = "";
		byte[] intro ;
		try{
			intro = countryIntro.getBytes("utf-8");
			message=iCountryBasicInfoService.updateCountryBasicInfo(Integer.parseInt(countryBasicInfoID),countryNum,countryName,countryLongi,countryLati,countryMeas,countryPop,countryHholds,intro);
		
		}catch(UnsupportedEncodingException e){
			message = "添加失败";
			e.printStackTrace();
		}
		
		//iCountryBasicInfoService.updateCountryBasicInfo(Integer.parseInt(countryBasicInfoID),countryNum,countryName,countryLongi,countryLati,countryMeas,countryPop,countryHholds,countryIntro);
		this.dataMap.put("success", message);
		return SUCCESS;
	}

	public String delCountryBasicInfo() {
		// TODO Auto-generated method stub
		
		String message = "";
		for(String a:countryBasicInfoID.split(",")){
			message = message + iCountryBasicInfoService.delCountryBasicInfo(Integer.parseInt(countryBasicInfoID));
		}
		
		this.dataMap.put("success", message);
		return SUCCESS;
	}

	public String addCountryBasicInfo() {
		// TODO Auto-generated method stub
		String message = "";
		
		int cityBasicInfoID = CountryBasicInfoAction.getJQS();
		
		byte[] intro ;
		try{
			intro = countryIntro.getBytes("utf-8");
			message = iCountryBasicInfoService.addCountryBasicInfo(countryNum.trim(),countryName.trim(),cityBasicInfoID,countryLongi.trim(),countryLati.trim(),countryMeas.trim(),countryPop.trim(),countryHholds.trim(),intro);
		
		}catch(UnsupportedEncodingException e){
			message = "添加失败";
			e.printStackTrace();
		}
		///iCountryBasicInfoService.addCountryBasicInfo(countryNum,countryName,cityBasicInfoID,countryLongi,countryLati,countryMeas,countryPop,countryHholds,countryIntro);
		this.dataMap.put("success", message);
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
	
	
	public String exportToExcelCountry(){
		CountryBasicInfoAction.setRowNums(rowNum);
		CountryBasicInfoAction.setIds(rowids);
		if(rowNum>1){
        is = iCountryBasicInfoService.exportToExcel();
		}
		if(rowNum==1){
			 is = iCountryBasicInfoService.exportToExcelNow();
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
		return this.iCountryBasicInfoService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iCountryBasicInfoService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iCountryBasicInfoService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iCountryBasicInfoService.queryByPage(criteria, from, length);
		return results;
	}
}
