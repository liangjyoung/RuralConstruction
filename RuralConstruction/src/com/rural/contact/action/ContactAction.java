package com.rural.contact.action;

import java.util.ArrayList;
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
import com.rural.contact.service.IContactService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class ContactAction extends JqGridBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String JQID;
	public static String JQS;
	//private int isFirstItem = 0;
	//private static int root = 6;
	private static String root ="3700.00.00.000";
	private static String root1="3712.00.00.000";
	private static String root2="3712.06.00.000";
	private static String root3="3712.06.01.000";
	private IContactService iContactService;
	private String  contactID;
	private String contactNum;
	private String contactName;
	private String contactComp;
	private String contactPost;
	private String contactNote;
	private String contactWorkTel;
	private String contactMobTel;
	

	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	

	public String getContactWorkTel() {
		return contactWorkTel;
	}

	public void setContactWorkTel(String contactWorkTel) {
		this.contactWorkTel = contactWorkTel;
	}

	public String getContactMobTel() {
		return contactMobTel;
	}

	public void setContactMobTel(String contactMobTel) {
		this.contactMobTel = contactMobTel;
	}

	public String getContactComp() {
		return contactComp;
	}

	public void setContactComp(String contactComp) {
		this.contactComp = contactComp;
	}

	public String getContactPost() {
		return contactPost;
	}

	public void setContactPost(String contactPost) {
		this.contactPost = contactPost;
	}

	public String getContactNote() {
		return contactNote;
	}

	public void setContactNote(String contactNote) {
		this.contactNote = contactNote;
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

	
	
	
	


	public IContactService getiContactService() {
		return iContactService;
	}

	public void setiContactService(IContactService iContactService) {
		this.iContactService = iContactService;
	}
	
	//判断市联系人编码是否重复
	public String checkCityContNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(contactID.equals("undefined"))contactID=null;//若id未定义则给其赋值为null
			
			//String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
			//int a = iContactService.getCityID(sysUserBeloDiviCode);
			//int b= iContactService.getCountryID(sysUserBeloDiviCode);
			
				boolean flag = iContactService.checkCityContNum(contactNum,contactID);
				
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
	
	//判断县(区)联系人编码是否重复
	public String checkCountryContNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(contactID.equals("undefined"))contactID=null;//若id未定义则给其赋值为null
			
			//String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
			//int a = iContactService.getCityID(sysUserBeloDiviCode);
			//int b= iContactService.getCountryID(sysUserBeloDiviCode);
			
				boolean flag1= iContactService.checkCountryContNum(contactNum, contactID);
				
				if(flag1){
					dataMap.put("success", true);
				}else{
					dataMap.put("success", false);
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//判断镇联系人编码是否重复
	public String checkTownContNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(contactID.equals("undefined"))contactID=null;//若id未定义则给其赋值为null
			
			//String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
			//int a = iContactService.getCityID(sysUserBeloDiviCode);
			//int b= iContactService.getCountryID(sysUserBeloDiviCode);
			
				
				boolean flag2= iContactService.checkTownContNum(contactNum, contactID);
				if(flag2){
					dataMap.put("success", true);
				}else{
					dataMap.put("success", false);
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String checkVilContNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(contactID.equals("undefined"))contactID=null;//若id未定义则给其赋值为null
			
			//String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
			//int a = iContactService.getCityID(sysUserBeloDiviCode);
			//int b= iContactService.getCountryID(sysUserBeloDiviCode);
			
				
				boolean flag2= iContactService.checkVilContNum(contactNum, contactID);
				if(flag2){
					dataMap.put("success", true);
				}else{
					dataMap.put("success", false);
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
/*
	public String queryAllCompartmentAsTree()
	
	{
		String sysUserBeloDiviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		int a = iContactService.getCityID(sysUserBeloDiviCode);
		int b= iContactService.getCountryID(sysUserBeloDiviCode);
		//int c =iContactService.getTownID(sysUserBeloDiviCode);
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		if(sysUserBeloDiviCode == null || sysUserBeloDiviCode.length() <= 0){
			items = getChildNodes(items, sysUserBeloDiviCode);
		}
		if(a!=0){
		items = getChildNodesCity(items, sysUserBeloDiviCode);
		}
		if(b!=0){
			items = getChildNodesCountry(items, sysUserBeloDiviCode);
			
		}
	
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		dataMap.put("ss",items );
		return SUCCESS;
	}
	*/
	
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
	
/*
	public String queryAllCompartmentAsTree()
	{
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		items = treeChildNodesCity(items, this.root1);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		dataMap.put("ss",items );
		return SUCCESS;
	}
	*/

	/*
	public String queryAllCompartmentAsTree()
	{
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		items = getChildNodesCountry(items, this.root2);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		dataMap.put("ss",items );
		return SUCCESS;
	}
	*/
	@JSON(serialize=false)
private Map treeChildNodes(Map<String, Item> items, String parentId)
{
	//根据省编码得到该省的所有市
	List<CityBasicInfo> cities = iContactService.getCities(parentId);
	if(cities.size() > 0){
		for(CityBasicInfo city : cities){
			Item item_0 = new Item();
			item_0.setName(city.getCityName());
			item_0.setType(ItemType.NODE_FOLDER);
			Map<String, Item> countriesAsChild = new LinkedHashMap<String, Item>();
			
			//得到该市的所有县，并作为市的子节点
			List<CountryBasicInfo> countries = iContactService.getCountries(city.getCityBasicInfoId());
			for(CountryBasicInfo country : countries){
				Item item_1 = new Item();
				item_1.setName(country.getCountryName());
				item_1.setType(ItemType.NODE_FOLDER);
				Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
			
				//得到该县的所有镇，并作为县的子节点
				List<TownBasicInfo> towns = iContactService.getTowns(country.getCountryBasicInfoId());
				for(TownBasicInfo town : towns){
					Item item_2 = new Item();
					item_2.setName(town.getTownName());
					item_2.setType(ItemType.NODE_FOLDER);
					
					Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
					
					//得到该镇的所有村，并作为镇的子节点
					List<VilBasicInfo> vils = iContactService.getVils(town.getTownBasicInfoId());
					for(VilBasicInfo vil : vils){
						Item item_3 = new Item();
						item_3.setName(vil.getVilName());
						item_3.setType(ItemType.NODE_ITEM);
						AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
						vilAdditionalParameters.setId(vil.getVilNum());
//						if(this.isFirstItem == 0){
//							vilAdditionalParameters.setItemSelected(true);
//							this.isFirstItem++;
//						}
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
	city = iContactService.getCity(parentId);
			Item item_0 = new Item();
			item_0.setName(city.getCityName());
			item_0.setType(ItemType.NODE_FOLDER);
			Map<String, Item> countriesAsChild = new LinkedHashMap<String, Item>();
			
			//得到该市的所有县，并作为市的子节点
			List<CountryBasicInfo> countries = iContactService.getCountries(city.getCityBasicInfoId());
			for(CountryBasicInfo country : countries){
				Item item_1 = new Item();
				item_1.setName(country.getCountryName());
				item_1.setType(ItemType.NODE_FOLDER);
				Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
			
				//得到该县的所有镇，并作为县的子节点
				List<TownBasicInfo> towns = iContactService.getTowns(country.getCountryBasicInfoId());
				for(TownBasicInfo town : towns){
					Item item_2 = new Item();
					item_2.setName(town.getTownName());
					item_2.setType(ItemType.NODE_FOLDER);
					
					Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
					
					List<VilBasicInfo> vils = iContactService.getVils(town.getTownBasicInfoId());
					for(VilBasicInfo vil : vils){
						Item item_3 = new Item();
						item_3.setName(vil.getVilName());
						item_3.setType(ItemType.NODE_ITEM);
						AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
						vilAdditionalParameters.setId(vil.getVilNum());
//						if(this.isFirstItem == 0){
//							vilAdditionalParameters.setItemSelected(true);
//							this.isFirstItem++;
//						}
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
	country = iContactService.getCountry(parentId);
			Item item_0 = new Item();
			item_0.setName(country.getCountryName());
			item_0.setType(ItemType.NODE_FOLDER);
			Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
			
				//得到该县的所有镇，并作为县的子节点
				List<TownBasicInfo> towns = iContactService.getTowns(country.getCountryBasicInfoId());
				for(TownBasicInfo town : towns){
					Item item_1 = new Item();
					item_1.setName(town.getTownName());
					item_1.setType(ItemType.NODE_FOLDER);
					
                   Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
					
					List<VilBasicInfo> vils = iContactService.getVils(town.getTownBasicInfoId());
					for(VilBasicInfo vil : vils){
						Item item_2 = new Item();
						item_2.setName(vil.getVilName());
						item_2.setType(ItemType.NODE_ITEM);
						AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
						vilAdditionalParameters.setId(vil.getVilNum());
//						if(this.isFirstItem == 0){
//							vilAdditionalParameters.setItemSelected(true);
//							this.isFirstItem++;
//						}
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
	town = iContactService.getTown(parentId);
			Item item_0 = new Item();
			item_0.setName(town.getTownName());
			item_0.setType(ItemType.NODE_FOLDER);
			Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();	
			List<VilBasicInfo> vils = iContactService.getVils(town.getTownBasicInfoId());
			for(VilBasicInfo vil : vils){
						Item item_1 = new Item();
						item_1.setName(vil.getVilName());
						item_1.setType(ItemType.NODE_ITEM);
						AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
						vilAdditionalParameters.setId(vil.getVilNum());
//						if(this.isFirstItem == 0){
//							vilAdditionalParameters.setItemSelected(true);
//							this.isFirstItem++;
//						}
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


	public String manageContact(){
		ContactAction.setJQS(JQID);
		
		if(!search){
			if("add".equals(oper)){
				addContact();
				
			}else if ("search".equals(oper)) {
				refreshGridModel();
				responseData();
			}else if ("del".equals(oper)) {
				delContact();
				
			}else if ("edit".equals(oper)) {
				updateContact();
				
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
	
	public String updateContact() {
		// TODO Auto-generated method stub
		
		String BasicInfoNum = ContactAction.getJQS();
		//int basicInfoID = 0;
		//int a = iContactService.getCityID(BasicInfoNum);
		//int b= iContactService.getCountryID(BasicInfoNum);
		//int c =iContactService.getTownID(BasicInfoNum);
		
		BasicInfoNum= BasicInfoNum.replace(".", "");
		int zeroNum=0;
		for(int i=BasicInfoNum.length();i>0;i--){
			if(BasicInfoNum.charAt(i-1)!='0') break;
			zeroNum++;
		}
		if(zeroNum>=7&&zeroNum<10){
			
			iContactService.updateCitysContact(Integer.parseInt(contactID),contactNum.trim(), contactName, contactWorkTel.trim(), contactMobTel.trim(),contactComp,contactPost,contactNote);
		}
		if(zeroNum>=5&&zeroNum<7){
		
			iContactService.updateCountryContact(Integer.parseInt(contactID),contactNum.trim(), contactName,contactWorkTel.trim(),contactMobTel.trim(),contactComp,contactPost,contactNote);
			
		}
		if(zeroNum>=3&&zeroNum<5){
			
			iContactService.updateTownContact(Integer.parseInt(contactID),contactNum.trim(), contactName, contactWorkTel.trim(),contactMobTel.trim(),contactComp,contactPost,contactNote);
			
		}
      if(zeroNum<3){
			
			iContactService.updateVilContact(Integer.parseInt(contactID),contactNum.trim(), contactName, contactWorkTel.trim(),contactMobTel.trim(),contactComp,contactPost,contactNote);
			
		}
		//iContactService.updateContact(Integer.parseInt(contactID),contactNum, contactName, contactTel,contactComp,contactPost,contactNote);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delContact() {
		// TODO Auto-generated method stub
		
		String BasicInfoNum = ContactAction.getJQS();
		BasicInfoNum= BasicInfoNum.replace(".", "");
		//int basicInfoID = 0;
		//int a = iContactService.getCityID(BasicInfoNum);
		//int b= iContactService.getCountryID(BasicInfoNum);
		//int c =iContactService.getTownID(BasicInfoNum);
		int zeroNum=0;
		for(int i=BasicInfoNum.length();i>0;i--){
			if(BasicInfoNum.charAt(i-1)!='0') break;
			zeroNum++;
		}
		if(zeroNum>=7&&zeroNum<10){
			for(String con : contactID.split(",")){
			
			iContactService.delCitysContact(Integer.parseInt(con));
			}
		}
		if(zeroNum>=5&&zeroNum<7){
			
			for(String con : contactID.split(",")){
				
				iContactService.delCountryContact(Integer.parseInt(con));
				}
		}
		if(zeroNum>=3&&zeroNum<5){
			
			for(String con : contactID.split(",")){
				
				iContactService.delTownContact(Integer.parseInt(con));
			}
			
		}
		
          if(zeroNum<3){
			
			for(String con : contactID.split(",")){
				
				iContactService.delVilContact(Integer.parseInt(con));
			}
			
		}
		
		//iContactService.delContact(Integer.parseInt(contactID));
		
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String addContact() {
		// TODO Auto-generated method stub
		String BasicInfoNum = ContactAction.getJQS();
		String BasicInfoNum1;
		BasicInfoNum1= BasicInfoNum.replace(".", "");
		int basicInfoID = 0;
		//int a = iContactService.getCityID(BasicInfoNum);
		//int b= iContactService.getCountryID(BasicInfoNum);
		//int c =iContactService.getTownID(BasicInfoNum);
		int zeroNum=0;
		for(int i=BasicInfoNum1.length();i>0;i--){
			if(BasicInfoNum1.charAt(i-1)!='0') break;
			zeroNum++;
		}
		if(zeroNum>=7&&zeroNum<10){
			 basicInfoID = iContactService.getCityID(BasicInfoNum);
			 iContactService.addCitysContact(basicInfoID,contactNum.trim(),contactName,contactWorkTel.trim(),contactMobTel.trim(),contactComp,contactPost,contactNote);
		}
		if(zeroNum>=5&&zeroNum<7){
			basicInfoID= iContactService.getCountryID(BasicInfoNum);
			iContactService.addCountryContact(basicInfoID,contactNum.trim(),contactName,contactWorkTel.trim(),contactMobTel.trim(),contactComp,contactPost,contactNote);
			
		}
		if(zeroNum>=3&&zeroNum<5){
			basicInfoID= iContactService.getTownID(BasicInfoNum);
			iContactService.addTownContact(basicInfoID,contactNum.trim(),contactName,contactWorkTel.trim(),contactMobTel.trim(),contactComp,contactPost,contactNote);
			
		}
		if(zeroNum<3){
			basicInfoID= iContactService.getVilID(BasicInfoNum);
			iContactService.addVilContact(basicInfoID,contactNum.trim(),contactName,contactWorkTel.trim(),contactMobTel.trim(),contactComp,contactPost,contactNote);
			
		}
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iContactService.queryResultsCount(null);
	}
	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iContactService.queryResultsCount(criteria);
	}
	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iContactService.queryByPage(null, from, length);
	}
	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return this.iContactService.queryByPage(criteria, from, length);
	}

}

