package com.rural.townscoreorder.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilEvalSco;
import com.rural.townscoreorder.service.ITotalScoreOrderService;

public class TotalScoreOrderAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ITotalScoreOrderService iTotalScoreOrderService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private Integer yr;
	private static Integer year;
	private Integer userId;
	private Integer roleId;
	private String diviCode;
	
	public String totalScoreOrder(){
		setYear(yr);
//		userId= Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("userid"));
//		diviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
//		Integer townId = iTotalScoreOrderService.getTownIdByTownNum(diviCode);
		List<VilBasicInfo> vils = iTotalScoreOrderService.getVilsByTownId(16);
		List<VilEvalSco> vilEvalScos = iTotalScoreOrderService.getScoresInOrder(vils, yr);
		int[] seriesData = new int[vilEvalScos.size()];
		String[] xAxisData = new String[vilEvalScos.size()];
		for(int i = 0; i < vilEvalScos.size(); ++i){
			System.out.println(vilEvalScos.get(i).getVilEvalTotGra());
			System.out.println(vilEvalScos.get(i).getVilDataCollRec().getVilBasicInfo().getVilName());
			seriesData[i] = Integer.parseInt(vilEvalScos.get(i).getVilEvalTotGra());
			xAxisData[i] = vilEvalScos.get(i).getVilDataCollRec().getVilBasicInfo().getVilName();
		}
		dataMap.put("seriesData", seriesData);
		dataMap.put("xAxisData", xAxisData);
//		if(yr == 2017){
//			int[] series = {750,800,850,900,600};
//			String[] xAxis = {"A村","B村","C村","D村","E村"};
//			dataMap.put("seriesData", series);
//			dataMap.put("xAxisData", xAxis);
//		}
		return SUCCESS;
	}
	
	public String getYears(){
		userId= Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("userid"));
		diviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		roleId = Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("changeroleid"));
//		System.out.println("getYears()");
//		if(roleId == 1){
//			
//		}else if(roleId == 2 || roleId == 3){
//			
//		}else if(roleId == 4){
//			
//		}else if(roleId == 5){//镇级用户
//			Integer townId = iTotalScoreOrderService.getTownIdByTownNum(diviCode);
			List<VilBasicInfo> vils = iTotalScoreOrderService.getVilsByTownId(21);
			List<Integer> years = iTotalScoreOrderService.getYears(vils);
//		List<Integer> years = new ArrayList<Integer>();
//			years.add(2017);
//			years.add(2016);
			dataMap.put("years", years);
//		}
		return SUCCESS;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public Integer getYr() {
		return yr;
	}

	public void setYr(Integer yr) {
		this.yr = yr;
	}

	public static Integer getYear() {
		return year;
	}

	public static void setYear(Integer year) {
		TotalScoreOrderAction.year = year;
	}

	public ITotalScoreOrderService getiTotalScoreOrderService() {
		return iTotalScoreOrderService;
	}

	public void setiTotalScoreOrderService(
			ITotalScoreOrderService iTotalScoreOrderService) {
		this.iTotalScoreOrderService = iTotalScoreOrderService;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getDiviCode() {
		return diviCode;
	}

	public void setDiviCode(String diviCode) {
		this.diviCode = diviCode;
	}
	
	
}
