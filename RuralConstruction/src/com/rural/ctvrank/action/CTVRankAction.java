package com.rural.ctvrank.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.EvalSystInd;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilEvalSco;
import com.rural.ctvrank.service.ICTVRankService;
import com.sun.net.httpserver.Authenticator.Failure;

public class CTVRankAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICTVRankService iCTVRankService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private Integer yr;
	private Integer year;
	private Integer userId;
	private Integer roleId;
	private String diviCode;
	private String treeDiviCode;
	private String selectedItem;
	private String selectedFirstLevelInd;
	private static String graphName;
	
	public String getYears(){
		userId= Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("userid"));
		diviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		roleId = Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("changeroleid"));
		List<Integer> years = iCTVRankService.getYears(roleId, diviCode);
		dataMap.put("years", years);
		return SUCCESS;
	}
	public String getFirstLevelInd(){
		//先暂时获得评价体系一级指标，应该根据年份去获得
		List<EvalSystInd> evalSystInds = iCTVRankService.getFirstLevelInds();
		List<String> firstLevelIndNum = new ArrayList<String>();
		List<String> firstLevelIndName = new ArrayList<String>();
		for(EvalSystInd evalSystInd : evalSystInds){
			firstLevelIndNum.add(evalSystInd.getEvalIndNum());
			firstLevelIndName.add(evalSystInd.getEvalIndName());
		}
		dataMap.put("firstLevelIndNum", firstLevelIndNum);
		dataMap.put("firstLevelIndName", firstLevelIndName);
		return SUCCESS;
	}
	public String CTVRank(){
		String res = SUCCESS;
		graphName = "所辖";
		if(selectedItem.equals("total"))//按总分平均分排序
			res = CTVRankOfTotalScore();
		else if(selectedItem.equals("firstlevel"))//按一级指标平均分排序
			res = CTVRankOfFirstLevelIndScore();
		return res;
	}
	public String CTVRankOfTotalScore(){
		//根据“行政区划树”节点ID确定属于那一级区划（市、县、镇、村）
		Integer divi = iCTVRankService.DistinguishDivi(treeDiviCode);
		List<Entry<String, Double>> scoreInDesc = iCTVRankService.getScoreInDesc(divi, treeDiviCode, year);
		double[] seriesData = new double[scoreInDesc.size()];
		String[] xAxisData = new String[scoreInDesc.size()];
		int i = 0;
		DecimalFormat df=new DecimalFormat(".##");
		for(Map.Entry<String, Double> entry : scoreInDesc){
			seriesData[i] = Double.parseDouble(df.format(entry.getValue()));
			xAxisData[i++] = entry.getKey();
		}
		dataMap.put("seriesData", seriesData);
		dataMap.put("xAxisData", xAxisData);
		dataMap.put("graphName", graphName + "按总平均分排名");
////		if(yr == 2017){
//			int[] series = {750,800,850,900,600};
//			String[] xAxis = {"A村","B村","C村","D村","E村"};
//			dataMap.put("seriesData", series);
//			dataMap.put("xAxisData", xAxis);
//		}
		return SUCCESS;
	}
	
	public String CTVRankOfFirstLevelIndScore(){
		//根据“行政区划树”节点ID确定属于那一级区划（市、县、镇、村）
		Integer divi = iCTVRankService.DistinguishDivi(treeDiviCode);
		List<Entry<String, Double>> scoreInDesc = iCTVRankService.getScoreInDesc(divi, treeDiviCode, year, selectedFirstLevelInd);
		double[] seriesData = new double[scoreInDesc.size()];
		String[] xAxisData = new String[scoreInDesc.size()];
		int i = 0;
		DecimalFormat df=new DecimalFormat(".##");
		for(Map.Entry<String, Double> entry : scoreInDesc){
			seriesData[i] = Double.parseDouble(df.format(entry.getValue()));
			xAxisData[i++] = entry.getKey();
		}
		dataMap.put("seriesData", seriesData);
		dataMap.put("xAxisData", xAxisData);
		dataMap.put("graphName", graphName + "按一级指标平均分排名");
////		if(yr == 2017){
//			int[] series = {750,800,850,900,600};
//			String[] xAxis = {"A村","B村","C村","D村","E村"};
//			dataMap.put("seriesData", series);
//			dataMap.put("xAxisData", xAxis);
//		}
		return SUCCESS;
	}
	
	public ICTVRankService getiCTVRankService() {
		return iCTVRankService;
	}
	public void setiCTVRankService(ICTVRankService iCTVRankService) {
		this.iCTVRankService = iCTVRankService;
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
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
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
	public String getTreeDiviCode() {
		return treeDiviCode;
	}
	public void setTreeDiviCode(String treeDiviCode) {
		this.treeDiviCode = treeDiviCode;
	}
	public String getSelectedItem() {
		return selectedItem;
	}
	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}
	public String getSelectedFirstLevelInd() {
		return selectedFirstLevelInd;
	}
	public void setSelectedFirstLevelInd(String selectedFirstLevelInd) {
		this.selectedFirstLevelInd = selectedFirstLevelInd;
	}
	public static String getGraphName() {
		return graphName;
	}
	public static void setGraphName(String graphName) {
		CTVRankAction.graphName = graphName;
	}
	
	
}
