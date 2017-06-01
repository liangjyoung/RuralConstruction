package com.rural.villagecompartment.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.rural.bean.TownBasicInfo;
import com.rural.datacolldatadic.action.DataCollDataDicAction;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;
import com.rural.villagecompartment.service.IVillageCompartmentService;




public class VillageCompartmentAction extends JqGridBaseAction{
	
	private String oper;//操作标志
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IVillageCompartmentService iVillageCompartmentService ;
	
	private String vilNum;
	private TownBasicInfo townBasicInfo;
	private String TownBasicInfoId;
	private String vilBasicInfoId;
	private String vilName;
	private String vilLongi;
	private String vilLati;
	private String vilMeas;
	private String vilPop;
	private String vilHholds;
	private String vilNatural;
	private String vilIntro;
	
	
	private String JQID;
	
	public static String JQS;
	
	public String rowids;
	public static String ids;
	public static int rowNums;
	public int rowNum;



	public String manageVilBasicInfo() {
		VillageCompartmentAction.setJQS(JQID);
		
	//	ActionContext.getContext().getSession().put("checkcode", "371202106000");				
	//	townNo = (String) ActionContext.getContext().getSession().get("checkcode");
		
		if (!search) {
			if ("add".equals(oper)) {// 增加
				addVillageInfo();
			} else if ("search".equals(oper)) {// 载入页面时查询					
				refreshGridModel();
				responseData();
				
			} else if ("del".equals(oper)) {// 删除
				delVilBasicInfo();
			} else if ("edit".equals(oper)) {// 修改
				updateVillageInfo();
			}
		} else {//查询功能
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	
	//判断村庄编码是否重复
	public String checkVilNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(vilBasicInfoId.equals("undefined"))
				vilBasicInfoId=null;//若id未定义则给其赋值为null
				boolean flag = iVillageCompartmentService.checkVilNum(vilNum,vilBasicInfoId);
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
	
	
	
	
	
	
	

	//导出到EXCEL开始
	InputStream iss;
	
	
	public String exportToExcelVilNow(){
		DataCollDataDicAction.setIds(rowids);
		DataCollDataDicAction.setRowNums(rowNum);
		if(rowNum>1){
        
        iss = iVillageCompartmentService.exportToExcel();
		}
		
		if(rowNum==1){
			iss = iVillageCompartmentService.exportToExcelNow();
			 
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
		VillageCompartmentAction.ids = ids;
	}


	public static int getRowNums() {
		return rowNums;
	}


	public static void setRowNums(int rowNums) {
		VillageCompartmentAction.rowNums = rowNums;
	}


	public int getRowNum() {
		return rowNum;
	}


	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}


	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	
	

	public IVillageCompartmentService getiVillageCompartmentService() {
		return iVillageCompartmentService;
	}




	public void setiVillageCompartmentService(
			IVillageCompartmentService iVillageCompartmentService) {
		this.iVillageCompartmentService = iVillageCompartmentService;
	}




	public String getTownBasicInfoId() {
		return TownBasicInfoId;
	}

	public void setTownBasicInfoId(String townBasicInfoId) {
		TownBasicInfoId = townBasicInfoId;
	}


	public String getVilBasicInfoId() {
		return vilBasicInfoId;
	}

	public void setVilBasicInfoId(String vilBasicInfoId) {
		this.vilBasicInfoId = vilBasicInfoId;
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

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getVilNum() {
		return vilNum;
	}

	public void setVilNum(String vilNum) {
		this.vilNum = vilNum;
	}

	public TownBasicInfo getTownBasicInfo() {
		return townBasicInfo;
	}

	public void setTownBasicInfo(TownBasicInfo townBasicInfo) {
		this.townBasicInfo = townBasicInfo;
	}

	public String getVilName() {
		return vilName;
	}

	public void setVilName(String vilName) {
		this.vilName = vilName;
	}

	public String getVilLongi() {
		return vilLongi;
	}

	public void setVilLongi(String vilLongi) {
		this.vilLongi = vilLongi;
	}

	public String getVilLati() {
		return vilLati;
	}

	public void setVilLati(String vilLati) {
		this.vilLati = vilLati;
	}

	public String getVilMeas() {
		return vilMeas;
	}

	public void setVilMeas(String vilMeas) {
		this.vilMeas = vilMeas;
	}

	public String getVilPop() {
		return vilPop;
	}

	public void setVilPop(String vilPop) {
		this.vilPop = vilPop;
	}

	public String getVilHholds() {
		return vilHholds;
	}

	public void setVilHholds(String vilHholds) {
		this.vilHholds = vilHholds;
	}

	public String getVilNatural() {
		return vilNatural;
	}

	public void setVilNatural(String vilNatural) {
		this.vilNatural = vilNatural;
	}


	
	public String getVilIntro() {
		return vilIntro;
	}




	public void setVilIntro(String vilIntro) {
		this.vilIntro = vilIntro;
	}




	public String delVilBasicInfo() {
		
		// TODO Auto-generated method stub				
		String message="";
		for(String id: vilBasicInfoId.split(",")){
			
			message= message+ iVillageCompartmentService.delVilBasicInfo(Integer.parseInt(id));
		}
		dataMap.put("success", message);
	    return SUCCESS;
	
	}
	//添加村庄信息
	public String addVillageInfo() {
		// TODO Auto-generated method stub
		
		byte[] bys;
		try {
			bys = vilIntro.getBytes("utf-8");
			iVillageCompartmentService.addVillage(vilNum,Integer.parseInt(TownBasicInfoId), vilName, vilLongi,
					vilLati, vilMeas, vilPop, vilHholds, vilNatural,bys );
			this.dataMap.put("success", true);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
		
	}
	
	public String updateVillageInfo() {
		// TODO Auto-generated method stub
		byte[] bys;
		try {
			bys = vilIntro.getBytes("utf-8");
			iVillageCompartmentService.updateVillage(Integer.parseInt(vilBasicInfoId),Integer.parseInt(TownBasicInfoId),vilNum, vilName, vilLongi,
					vilLati, vilMeas, vilPop, vilHholds, vilNatural,bys);
			this.dataMap.put("success", true);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
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
		return this.iVillageCompartmentService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iVillageCompartmentService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iVillageCompartmentService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iVillageCompartmentService.queryByPage(criteria, from, length);
		return results;
	}
	
	


	
}
