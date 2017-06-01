package com.rural.admiDivisions.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.admiDivisions.service.ITownBasicInfoService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class TownBasicInfoAction extends JqGridBaseAction{
	
	private static final long serialVersionUID = 1L;
	private ITownBasicInfoService iTownBasicInfoService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private int JQID;
	public static int JQS;
	private String townBasicInfoID;
	private String oper;
	private String townNum;
	private String townName;
	private String townLongi;
	private String townLati;
	private String townMeas;
	private String townPop;
	private String townHholds;
	//private byte[] townIntro;
	private String townIntro;
	
	
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
		TownBasicInfoAction.ids = ids;
	}
	public static int getRowNums() {
		return rowNums;
	}
	public static void setRowNums(int rowNums) {
		TownBasicInfoAction.rowNums = rowNums;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public ITownBasicInfoService getiTownBasicInfoService() {
		return iTownBasicInfoService;
	}
	public void setiTownBasicInfoService(ITownBasicInfoService iTownBasicInfoService) {
		this.iTownBasicInfoService = iTownBasicInfoService;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
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
	public String getTownBasicInfoID() {
		return townBasicInfoID;
	}
	public void setTownBasicInfoID(String townBasicInfoID) {
		this.townBasicInfoID = townBasicInfoID;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getTownNum() {
		return townNum;
	}
	public void setTownNum(String townNum) {
		this.townNum = townNum;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	public String getTownLongi() {
		return townLongi;
	}
	public void setTownLongi(String townLongi) {
		this.townLongi = townLongi;
	}
	public String getTownLati() {
		return townLati;
	}
	public void setTownLati(String townLati) {
		this.townLati = townLati;
	}
	public String getTownMeas() {
		return townMeas;
	}
	public void setTownMeas(String townMeas) {
		this.townMeas = townMeas;
	}
	public String getTownPop() {
		return townPop;
	}
	public void setTownPop(String townPop) {
		this.townPop = townPop;
	}
	public String getTownHholds() {
		return townHholds;
	}
	public void setTownHholds(String townHholds) {
		this.townHholds = townHholds;
	}
	
	
	
	public String getTownIntro() {
		return townIntro;
	}
	public void setTownIntro(String townIntro) {
		this.townIntro = townIntro;
	}
	//判断编码是否重复
	public String checkTownNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(townBasicInfoID.equals("undefined"))townBasicInfoID=null;//若id未定义则给其赋值为null
				boolean flag = iTownBasicInfoService.checkTownNum(townNum,townBasicInfoID);
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
	public String manageTownBasicInfo(){
		TownBasicInfoAction.setJQS(JQID);
		if(!search){
			if ("add".equals(oper)) {//增加
				addTownBasicInfo();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				delTownBasicInfo();
			}else if("edit".equals(oper)){//修改
				updateTownBasicInfo();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public String updateTownBasicInfo() {
		// TODO Auto-generated method stub
		String message = "";
		byte[] intro ;
		try{
			intro = townIntro.getBytes("utf-8");
			message=	iTownBasicInfoService.updateTownBasicInfo(Integer.parseInt(townBasicInfoID),townNum.trim(),townName.trim(),townLongi.trim(),townLati.trim(),townMeas.trim(),townPop.trim(),townHholds.trim(),intro);
			this.dataMap.put("success", true);
		}catch(UnsupportedEncodingException e){
			message = "添加失败";
			e.printStackTrace();
		}
		//iTownBasicInfoService.updateTownBasicInfo(Integer.parseInt(townBasicInfoID),townNum,townName,townLongi,townLati,townMeas,townPop,townHholds,townIntro);
		this.dataMap.put("success", message);
		
		return SUCCESS;
	}

	public String delTownBasicInfo() {
		// TODO Auto-generated method stub
		String message= "";
		for(String a:townBasicInfoID.split(",")){
		
			message = message+ iTownBasicInfoService.delTownBasicInfo(Integer.parseInt(a));
		}
		
		this.dataMap.put("success", message);
		return SUCCESS;
	}

	public String addTownBasicInfo() {
		// TODO Auto-generated method stub
		
		String message = "";
		
		int  countryBasicInfoID = TownBasicInfoAction.getJQS();
		
		byte[] intro ;
		try{
			intro = townIntro.getBytes("utf-8");
			message = iTownBasicInfoService.addTownBasicInfo(townNum,townName,countryBasicInfoID,townLongi,townLati,townMeas,townPop,townHholds,intro);
			
		}catch(UnsupportedEncodingException e){
			message = "添加失败";
			e.printStackTrace();
		}
		//iTownBasicInfoService.addTownBasicInfo(townNum,townName,countryBasicInfoID,townLongi,townLati,townMeas,townPop,townHholds,townIntro);
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
	
	
	public String exportToExcelTown(){
		TownBasicInfoAction.setRowNums(rowNum);
		TownBasicInfoAction.setIds(rowids);
		if(rowNum>1){
        is = iTownBasicInfoService.exportToExcel();
		}
		if(rowNum==1){
			 is = iTownBasicInfoService.exportToExcelNow();
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
		return this.iTownBasicInfoService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iTownBasicInfoService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iTownBasicInfoService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iTownBasicInfoService.queryByPage(criteria, from, length);
		return results;
	}

}
