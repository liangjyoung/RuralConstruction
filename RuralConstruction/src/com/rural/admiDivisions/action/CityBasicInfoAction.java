package com.rural.admiDivisions.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.rural.admiDivisions.service.ICityBasicInfoService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class CityBasicInfoAction extends JqGridBaseAction{
	
	private static final long serialVersionUID = 1L;
	private ICityBasicInfoService iCityBasicInfoService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String JQID;
	public static String JQS;
    private String cityBasicInfoID;
	private String cityNum;
	private String cityName;
	private String cityLongi;
	private String cityLati;
	private String cityMeas;
	private String cityPop;
	private String cityHholds;
	//private byte[] cityIntro;
	private static String  proNum="3700.00.00.000";
	private String cityIntro;
	
	public String rowids;
	public static String ids;
	public static int rowNums;
	public int rowNum;
	
	
	
	
	public static String getProNum() {
		return proNum;
	}
	public static void setProNum(String proNum) {
		CityBasicInfoAction.proNum = proNum;
	}
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
		CityBasicInfoAction.ids = ids;
	}
	public static int getRowNums() {
		return rowNums;
	}
	public static void setRowNums(int rowNums) {
		CityBasicInfoAction.rowNums = rowNums;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
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
	
	public String getCityBasicInfoID() {
		return cityBasicInfoID;
	}
	public void setCityBasicInfoID(String cityBasicInfoID) {
		this.cityBasicInfoID = cityBasicInfoID;
	}
	public ICityBasicInfoService getiCityBasicInfoService() {
		return iCityBasicInfoService;
	}
	public void setiCityBasicInfoService(ICityBasicInfoService iCityBasicInfoService) {
		this.iCityBasicInfoService = iCityBasicInfoService;
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
	public String getCityNum() {
		return cityNum;
	}
	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityLongi() {
		return cityLongi;
	}
	public void setCityLongi(String cityLongi) {
		this.cityLongi = cityLongi;
	}
	public String getCityLati() {
		return cityLati;
	}
	public void setCityLati(String cityLati) {
		this.cityLati = cityLati;
	}
	public String getCityMeas() {
		return cityMeas;
	}
	public void setCityMeas(String cityMeas) {
		this.cityMeas = cityMeas;
	}
	public String getCityPop() {
		return cityPop;
	}
	public void setCityPop(String cityPop) {
		this.cityPop = cityPop;
	}
	public String getCityHholds() {
		return cityHholds;
	}
	public void setCityHholds(String cityHholds) {
		this.cityHholds = cityHholds;
	}
	
	
	
	public String getCityIntro() {
		return cityIntro;
	}
	public void setCityIntro(String cityIntro) {
		this.cityIntro = cityIntro;
	}
	//判断编码是否重复
	public String checkCityNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(cityBasicInfoID.equals("undefined"))
			{
				cityBasicInfoID=null;
			}//若id未定义则给其赋值为null
			boolean flag = iCityBasicInfoService.checkCityNum(cityNum,cityBasicInfoID);
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
	public String manageCityBasicInfo(){
		if(!search){
			if ("add".equals(oper)) {//增加
				addCityBasicInfo();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				delCityBasicInfo();
			}else if("edit".equals(oper)){//修改
				updateCityBasicInfo();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String updateCityBasicInfo() {
		// TODO Auto-generated method stub
		String message = "";
		byte[] intro ;
		try{
			intro = cityIntro.getBytes("utf-8");
			message=iCityBasicInfoService.updateCityBasicInfo(Integer.parseInt(cityBasicInfoID),cityNum.trim(),cityName.trim(),cityLongi.trim(),cityLati.trim(),cityMeas.trim(),cityPop.trim(),cityHholds.trim(),intro);
		}catch(UnsupportedEncodingException e){
			message = "添加失败";
			e.printStackTrace();
		}
		//iCityBasicInfoService.updateCityBasicInfo(Integer.parseInt(cityBasicInfoID),cityNum,cityName,cityLongi,cityLati,cityMeas,cityPop,cityHholds,cityIntro);
		this.dataMap.put("success", message);
		return SUCCESS;
	}

	public String delCityBasicInfo() {
		// TODO Auto-generated method stub
		String message = "";
		for(String a:cityBasicInfoID.split(",")){
		
			message = message + iCityBasicInfoService.delCityBasicInfo(Integer.parseInt(cityBasicInfoID));
		}
		
		this.dataMap.put("success", message);
		return SUCCESS;
	}

	public String addCityBasicInfo() {
		// TODO Auto-generated method stub
		String message = "";
		int proBasicInfoID = iCityBasicInfoService.getProID(proNum);
		byte[] intro ;
		try{
			intro = cityIntro.getBytes("utf-8");
			message = iCityBasicInfoService.addCityBasicInfo(cityNum.trim(),cityName.trim(),proBasicInfoID,cityLongi.trim(),cityLati.trim(),cityMeas.trim(),cityPop.trim(),cityHholds.trim(),intro);
		}catch(UnsupportedEncodingException e){
			message = "添加失败";
			e.printStackTrace();
			
		}
		//iCityBasicInfoService.addCityBasicInfo(cityNum,cityName,proBasicInfoID,cityLongi,cityLati,cityMeas,cityPop,cityHholds,cityIntro);
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
	
	
	public String exportToExcelCity(){
		CityBasicInfoAction.setRowNums(rowNum);
		CityBasicInfoAction.setIds(rowids);
		if(rowNum>1){
        is = iCityBasicInfoService.exportToExcel();
		}
		if(rowNum==1){
			 is = iCityBasicInfoService.exportToExcelNow();
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
		return this.iCityBasicInfoService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iCityBasicInfoService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iCityBasicInfoService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iCityBasicInfoService.queryByPage(criteria, from, length);
		return results;
	}

}
