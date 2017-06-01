package com.rural.townscoreorder.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.bean.EvalSystInd;
import com.rural.bean.LevelsIndSco;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilEvalSco;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.townscoreorder.service.IFirstLevelScoreOrderService;

public class FirstLevelScoreOrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IFirstLevelScoreOrderService iFirstLevelScoreOrderService;
	private Integer year;
	private String indNum;
	private Integer userId;
	private Integer roleId;
	private String diviCode;
	
	public String getFirstLevelInd(){
		//先暂时获得评价体系一级指标，应该根据年份去获得
		List<EvalSystInd> evalSystInds = iFirstLevelScoreOrderService.getFirstLevelInds();
		Map<String, Item> tree = new LinkedHashMap<String, Item>();
		for(EvalSystInd evalSystInd : evalSystInds){
			Item item = new Item();
			AdditionalParameters additionalParameters = new AdditionalParameters();
			String id = evalSystInd.getEvalIndNum();
			additionalParameters.setId(id);
			item.setAdditionalParameters(additionalParameters);
			String name = evalSystInd.getEvalIndName();
			item.setName(name);
			item.setType(ItemType.NODE_ITEM);
			tree.put(name, item);
		}
		dataMap.put("tree", tree);
		return SUCCESS;
	}
	public String firstLevelIndOrder(){
		userId= Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("userid"));
//		diviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
//		Integer townId = iFirstLevelScoreOrderService.getTownIdByTownNum(diviCode);
		List<VilBasicInfo> vils = iFirstLevelScoreOrderService.getVilsByTownId(16);
		List<LevelsIndSco> levelsIndScos = iFirstLevelScoreOrderService.getFirstLevelScoresInOrder(vils, year, indNum);
		int[] seriesData = new int[levelsIndScos.size()];
		String[] xAxisData = new String[levelsIndScos.size()];
		for(int i = 0; i < levelsIndScos.size(); ++i){
			System.out.println(levelsIndScos.get(i).getLevelsIndSco());
			System.out.println(levelsIndScos.get(i).getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getVilName());
			seriesData[i] = Integer.parseInt(levelsIndScos.get(i).getLevelsIndSco());
			xAxisData[i] = levelsIndScos.get(i).getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getVilName();
		}
		dataMap.put("seriesData", seriesData);
		dataMap.put("xAxisData", xAxisData);
		
		return SUCCESS;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public IFirstLevelScoreOrderService getiFirstLevelScoreOrderService() {
		return iFirstLevelScoreOrderService;
	}

	public void setiFirstLevelScoreOrderService(
			IFirstLevelScoreOrderService iFirstLevelScoreOrderService) {
		this.iFirstLevelScoreOrderService = iFirstLevelScoreOrderService;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	public String getIndNum() {
		return indNum;
	}
	public void setIndNum(String indNum) {
		this.indNum = indNum;
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
