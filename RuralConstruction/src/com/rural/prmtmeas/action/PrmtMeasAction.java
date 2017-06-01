package com.rural.prmtmeas.action;

import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.contact.action.ContactAction;
import com.rural.prmtmeas.service.IPrmtMeasService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class PrmtMeasAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String JQID;
	public static String JQS;
	//private int isFirstItem = 0;
	
//	private static String root ="3700.00.00.000";
//	private static String root1="3712.00.00.000";
//	private static String root2="3712.02.00.001";
//	private static String root3="3712.02.10.600";
	private static String root ="3700.00.00.000";
	private static String root1="3712.00.00.000";
	private static String root2="3712.06.00.000";
	private static String root3="3712.06.01.000";
	
	
	private IPrmtMeasService iPrmtMeasService;
	
	private String evalScoId;
	
	private Date collTime;
	private int fullMarks;
	private int  zeroMarks;
	private int marks;
	
	private Date JQTime;
	private static Date JSTime;
	
	
	
	public Date getJQTime() {
		return JQTime;
	}
	public void setJQTime(Date jQTime) {
		JQTime = jQTime;
	}
	public static Date getJSTime() {
		return JSTime;
	}
	public static void setJSTime(Date jSTime) {
		JSTime = jSTime;
	}
	public Date getCollTime() {
		return collTime;
	}
	public void setCollTime(Date collTime) {
		this.collTime = collTime;
	}
	public int getFullMarks() {
		return fullMarks;
	}
	public void setFullMarks(int fullMarks) {
		this.fullMarks = fullMarks;
	}
	public int getZeroMarks() {
		return zeroMarks;
	}
	public void setZeroMarks(int zeroMarks) {
		this.zeroMarks = zeroMarks;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
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
	
	public IPrmtMeasService getiPrmtMeasService() {
		return iPrmtMeasService;
	}
	public void setiPrmtMeasService(IPrmtMeasService iPrmtMeasService) {
		this.iPrmtMeasService = iPrmtMeasService;
	}
	
	
	
	public String getEvalScoId() {
		return evalScoId;
	}
	public void setEvalScoId(String evalScoId) {
		this.evalScoId = evalScoId;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public static String getRoot() {
		return root;
	}
	public static void setRoot(String root) {
		PrmtMeasAction.root = root;
	}
	public static String getRoot1() {
		return root1;
	}
	public static void setRoot1(String root1) {
		PrmtMeasAction.root1 = root1;
	}
	public static String getRoot2() {
		return root2;
	}
	public static void setRoot2(String root2) {
		PrmtMeasAction.root2 = root2;
	}
	public static String getRoot3() {
		return root3;
	}
	public static void setRoot3(String root3) {
		PrmtMeasAction.root3 = root3;
	}
	
	/*public String queryAllCompartmentAsTree()
	
	{
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		int zeroNum=0;
		if(sysUserBeloDiviCode == null || sysUserBeloDiviCode.length() <= 0){
			items = getChildNodes(items, sysUserBeloDiviCode);
		}else{
		
		for(int i=sysUserBeloDiviCode.length();i>0;i--){
			if(sysUserBeloDiviCode.charAt(i-1)!='0') break;
			zeroNum++;
		}

		
		//int a = iContactService.getCityID(sysUserBeloDiviCode);
		//int b= iContactService.getCountryID(sysUserBeloDiviCode);
		//int c =iContactService.getTownID(sysUserBeloDiviCode);
		
		if(sysUserBeloDiviCode == null || sysUserBeloDiviCode.length() <= 0){
			items = getChildNodes(items, sysUserBeloDiviCode);
		}
		if(zeroNum>=8&&zeroNum<10){
		items = getChildNodesCity(items, sysUserBeloDiviCode);
		}
		if(zeroNum>=6&&zeroNum<8){
			items = getChildNodesCountry(items, sysUserBeloDiviCode);
			
		}
	}
	
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		dataMap.put("ss",items );
		return SUCCESS;
	}*/
	
	
	public String queryAllCompartmentAsTree()
	{
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		items = treeChildNodes(items, this.root);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		dataMap.put("ss",items );
		return SUCCESS;
	}
	/*
public String queryAllCompartmentAsTree()
	
	{
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		int zeroNum=0;
		String code="";
		if(sysUserBeloDiviCode == null || sysUserBeloDiviCode.length() <= 0){
			items = treeChildNodes(items, this.root);
		}else{
			code=sysUserBeloDiviCode.replace(".","");
		
		for(int i=code.length();i>0;i--){
			if(code.charAt(i-1)!='0') break;
			zeroNum++;
		}

		
		//int a = iContactService.getCityID(sysUserBeloDiviCode);
		//int b= iContactService.getCountryID(sysUserBeloDiviCode);
		//int c =iContactService.getTownID(sysUserBeloDiviCode);
		
		
		if(zeroNum>=7&&zeroNum<10){
		items = treeChildNodesCity(items, sysUserBeloDiviCode);
		}
		if(zeroNum>=5&&zeroNum<7){
			items = treeChildNodesCountry(items, sysUserBeloDiviCode);
			
		}
		if(zeroNum>=3&&zeroNum<5){
			items = treeChildNodesTown(items, sysUserBeloDiviCode);
			
		}
	}
	
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		dataMap.put("ss",items );
		return SUCCESS;
	}
	
	
	*/

	@JSON(serialize=false)
	private Map treeChildNodes(Map<String, Item> items, String parentId)
	{
		//根据省编码得到该省的所有市
		List<CityBasicInfo> cities = iPrmtMeasService.getCities(parentId);
		if(cities.size() > 0){
			for(CityBasicInfo city : cities){
				Item item_0 = new Item();
				item_0.setName(city.getCityName());
				item_0.setType(ItemType.NODE_FOLDER);
				Map<String, Item> countriesAsChild = new LinkedHashMap<String, Item>();
				
				//得到该市的所有县，并作为市的子节点
				List<CountryBasicInfo> countries = iPrmtMeasService.getCountries(city.getCityBasicInfoId());
				for(CountryBasicInfo country : countries){
					Item item_1 = new Item();
					item_1.setName(country.getCountryName());
					item_1.setType(ItemType.NODE_FOLDER);
					Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
				
					//得到该县的所有镇，并作为县的子节点
					List<TownBasicInfo> towns = iPrmtMeasService.getTowns(country.getCountryBasicInfoId());
					for(TownBasicInfo town : towns){
						Item item_2 = new Item();
						item_2.setName(town.getTownName());
						item_2.setType(ItemType.NODE_FOLDER);
						
						Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
						
						//得到该镇的所有村，并作为镇的子节点
						List<VilBasicInfo> vils = iPrmtMeasService.getVils(town.getTownBasicInfoId());
						for(VilBasicInfo vil : vils){
							Item item_3 = new Item();
							item_3.setName(vil.getVilName());
							item_3.setType(ItemType.NODE_ITEM);
							AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
							vilAdditionalParameters.setId(vil.getVilNum());
//							if(this.isFirstItem == 0){
//								vilAdditionalParameters.setItemSelected(true);
//								this.isFirstItem++;
//							}
							item_3.setAdditionalParameters(vilAdditionalParameters);
							vilsAsChild.put(vil.getVilName(), item_3);
						}
						
						AdditionalParameters townAdditionalParameters = new AdditionalParameters();
						townAdditionalParameters.setId(town.getTownNum());
						townAdditionalParameters.setChildren(vilsAsChild);
						item_2.setAdditionalParameters(townAdditionalParameters);
						townsAsChild.put(town.getTownName(), item_2);
					}
					
					AdditionalParameters countryAdditionalParameters = new AdditionalParameters();
					countryAdditionalParameters.setId(country.getCountryNum());
					countryAdditionalParameters.setChildren(townsAsChild);
					item_1.setAdditionalParameters(countryAdditionalParameters);
					//items.put(country.getCountryName(), item_1);
					countriesAsChild.put(country.getCountryName(), item_1);
				}
				
				AdditionalParameters cityAdditionalParameters = new AdditionalParameters();
				cityAdditionalParameters.setId(city.getCityNum());
				cityAdditionalParameters.setChildren(countriesAsChild);
				item_0.setAdditionalParameters(cityAdditionalParameters);
				items.put(city.getCityName(), item_0);
			}
		}
		return items;
	}

		@JSON(serialize=false)
	private Map treeChildNodesCity(Map<String, Item> items, String parentId)
	{
		//根据市编码得到该市的名称，并作为父节点
		CityBasicInfo city = new CityBasicInfo();
		city = iPrmtMeasService.getCity(parentId);
				Item item_0 = new Item();
				item_0.setName(city.getCityName());
				item_0.setType(ItemType.NODE_FOLDER);
				Map<String, Item> countriesAsChild = new LinkedHashMap<String, Item>();
				
				//得到该市的所有县，并作为市的子节点
				List<CountryBasicInfo> countries = iPrmtMeasService.getCountries(city.getCityBasicInfoId());
				for(CountryBasicInfo country : countries){
					Item item_1 = new Item();
					item_1.setName(country.getCountryName());
					item_1.setType(ItemType.NODE_FOLDER);
					Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
				
					//得到该县的所有镇，并作为县的子节点
					List<TownBasicInfo> towns = iPrmtMeasService.getTowns(country.getCountryBasicInfoId());
					for(TownBasicInfo town : towns){
						Item item_2 = new Item();
						item_2.setName(town.getTownName());
						item_2.setType(ItemType.NODE_FOLDER);
						
						Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
						
						List<VilBasicInfo> vils = iPrmtMeasService.getVils(town.getTownBasicInfoId());
						for(VilBasicInfo vil : vils){
							Item item_3 = new Item();
							item_3.setName(vil.getVilName());
							item_3.setType(ItemType.NODE_ITEM);
							AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
							vilAdditionalParameters.setId(vil.getVilNum());
//							if(this.isFirstItem == 0){
//								vilAdditionalParameters.setItemSelected(true);
//								this.isFirstItem++;
//							}
							item_3.setAdditionalParameters(vilAdditionalParameters);
							vilsAsChild.put(vil.getVilName(), item_3);
						}
						AdditionalParameters townAdditionalParameters = new AdditionalParameters();
						townAdditionalParameters.setId(town.getTownNum());
						townAdditionalParameters.setChildren(vilsAsChild);
						item_2.setAdditionalParameters(townAdditionalParameters);
						townsAsChild.put(town.getTownName(), item_2);
					}
					
					AdditionalParameters countryAdditionalParameters = new AdditionalParameters();
					countryAdditionalParameters.setId(country.getCountryNum());
					countryAdditionalParameters.setChildren(townsAsChild);
					item_1.setAdditionalParameters(countryAdditionalParameters);
					//items.put(country.getCountryName(), item_1);
					countriesAsChild.put(country.getCountryName(), item_1);
				}
				
				AdditionalParameters cityAdditionalParameters = new AdditionalParameters();
				cityAdditionalParameters.setId(city.getCityNum());
				cityAdditionalParameters.setChildren(countriesAsChild);
				item_0.setAdditionalParameters(cityAdditionalParameters);
				items.put(city.getCityName(), item_0);
			
		
		return items;
	}
		@JSON(serialize=false)
	private Map treeChildNodesCountry(Map<String, Item> items, String parentId)
	{
		//根据县（区）编码得到该县（区）的名称，并作为父节点
		CountryBasicInfo country = new CountryBasicInfo();
		country = iPrmtMeasService.getCountry(parentId);
				Item item_0 = new Item();
				item_0.setName(country.getCountryName());
				item_0.setType(ItemType.NODE_FOLDER);
				Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
				
					//得到该县的所有镇，并作为县的子节点
					List<TownBasicInfo> towns = iPrmtMeasService.getTowns(country.getCountryBasicInfoId());
					for(TownBasicInfo town : towns){
						Item item_1 = new Item();
						item_1.setName(town.getTownName());
						item_1.setType(ItemType.NODE_FOLDER);
						
	                   Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
						
						List<VilBasicInfo> vils = iPrmtMeasService.getVils(town.getTownBasicInfoId());
						for(VilBasicInfo vil : vils){
							Item item_2 = new Item();
							item_2.setName(vil.getVilName());
							item_2.setType(ItemType.NODE_ITEM);
							AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
							vilAdditionalParameters.setId(vil.getVilNum());
//							if(this.isFirstItem == 0){
//								vilAdditionalParameters.setItemSelected(true);
//								this.isFirstItem++;
//							}
							item_2.setAdditionalParameters(vilAdditionalParameters);
							vilsAsChild.put(vil.getVilName(), item_2);
						}
						AdditionalParameters townAdditionalParameters = new AdditionalParameters();
						townAdditionalParameters.setId(town.getTownNum());
						townAdditionalParameters.setChildren(vilsAsChild);
						item_1.setAdditionalParameters(townAdditionalParameters);
						townsAsChild.put(town.getTownName(), item_1);
					}
					
					AdditionalParameters countryAdditionalParameters = new AdditionalParameters();
					countryAdditionalParameters.setId(country.getCountryNum());
					countryAdditionalParameters.setChildren(townsAsChild);
					item_0.setAdditionalParameters(countryAdditionalParameters);
					items.put(country.getCountryName(), item_0);
					
		
		return items;
	}

		@JSON(serialize=false)
	private Map treeChildNodesTown(Map<String, Item> items, String parentId)
	{
		//根据县（区）编码得到该县（区）的名称，并作为父节点
		TownBasicInfo town = new TownBasicInfo();
		town = iPrmtMeasService.getTown(parentId);
				Item item_0 = new Item();
				item_0.setName(town.getTownName());
				item_0.setType(ItemType.NODE_FOLDER);
				Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();	
				List<VilBasicInfo> vils = iPrmtMeasService.getVils(town.getTownBasicInfoId());
				for(VilBasicInfo vil : vils){
							Item item_1 = new Item();
							item_1.setName(vil.getVilName());
							item_1.setType(ItemType.NODE_ITEM);
							AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
							vilAdditionalParameters.setId(vil.getVilNum());
//							if(this.isFirstItem == 0){
//								vilAdditionalParameters.setItemSelected(true);
//								this.isFirstItem++;
//							}
							item_1.setAdditionalParameters(vilAdditionalParameters);
							vilsAsChild.put(vil.getVilName(), item_1);
						}
						AdditionalParameters townAdditionalParameters = new AdditionalParameters();
						townAdditionalParameters.setId(town.getTownNum());
						townAdditionalParameters.setChildren(vilsAsChild);
						item_0.setAdditionalParameters(townAdditionalParameters);
						items.put(town.getTownName(), item_0);
		
		return items;
	}



	public String managePrmtMeas(){
		PrmtMeasAction.setJQS(JQID);
		
		if(!search){
			if("add".equals(oper)){
				//addContact();
				
			}else if ("search".equals(oper)) {
				refreshGridModel();
				responseData();
			}else if ("del".equals(oper)) {
				//delContact();
				
			}else if ("edit".equals(oper)) {
				//updateContact();
				
			}
		}else{
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	/**
	 * 打包服务器数据
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
		return this.iPrmtMeasService.queryResultsCount(null);
	}
	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iPrmtMeasService.queryResultsCount(criteria);
	}
	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iPrmtMeasService.queryByPage(null, from, length);
	}
	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return this.iPrmtMeasService.queryByPage(criteria, from, length);
	}
	
	
	public String manageFullEvalCont(){
		PrmtMeasAction.setJSTime(JQTime);
		
		if(!search){
			if("add".equals(oper)){
				//addContact();
				
			}else if ("search".equals(oper)) {
				refreshGridModel();
				responseData();
			}else if ("del".equals(oper)) {
				//delContact();
				
			}else if ("edit".equals(oper)) {
				//updateContact();
				
			}
		}else{
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
}
