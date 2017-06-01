package com.rural.admiTree.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.rural.admiTree.service.IAdmiTreeService;
import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class AdmiTreeAction extends JqGridBaseAction{
	private static String root ="3700.00.00.000";
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IAdmiTreeService iAdmiTreeService;
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

		
		if(zeroNum>=7&&zeroNum<10){
		items = treeChildNodesCity(items, sysUserBeloDiviCode);
		}
		if(zeroNum>=5&&zeroNum<7){
			items = treeChildNodesCountry(items, sysUserBeloDiviCode);
			
		}
	}
	
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		dataMap.put("ss",items );
		return SUCCESS;
	}
	
*/
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
	List<CityBasicInfo> cities = iAdmiTreeService.getCities(parentId);
	if(cities.size() > 0){
		for(CityBasicInfo city : cities){
			Item item_0 = new Item();
			item_0.setName(city.getCityName());
			item_0.setType(ItemType.NODE_FOLDER);
			Map<String, Item> countriesAsChild = new LinkedHashMap<String, Item>();
			
			//得到该市的所有县，并作为市的子节点
			List<CountryBasicInfo> countries = iAdmiTreeService.getCountries(city.getCityBasicInfoId());
			for(CountryBasicInfo country : countries){
				Item item_1 = new Item();
				item_1.setName(country.getCountryName());
				item_1.setType(ItemType.NODE_FOLDER);
				Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
			
				//得到该县的所有镇，并作为县的子节点
				List<TownBasicInfo> towns = iAdmiTreeService.getTowns(country.getCountryBasicInfoId());
				for(TownBasicInfo town : towns){
					Item item_2 = new Item();
					item_2.setName(town.getTownName());
					item_2.setType(ItemType.NODE_ITEM);
					
					//Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
					
					
					
					AdditionalParameters townAdditionalParameters = new AdditionalParameters();
					townAdditionalParameters.setId(town.getTownNum());
					//townAdditionalParameters.setChildren(vilsAsChild);
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
	city = iAdmiTreeService.getCity(parentId);
			Item item_0 = new Item();
			item_0.setName(city.getCityName());
			item_0.setType(ItemType.NODE_FOLDER);
			Map<String, Item> countriesAsChild = new LinkedHashMap<String, Item>();
			
			//得到该市的所有县，并作为市的子节点
			List<CountryBasicInfo> countries = iAdmiTreeService.getCountries(city.getCityBasicInfoId());
			for(CountryBasicInfo country : countries){
				Item item_1 = new Item();
				item_1.setName(country.getCountryName());
				item_1.setType(ItemType.NODE_FOLDER);
				Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
			
				//得到该县的所有镇，并作为县的子节点
				List<TownBasicInfo> towns = iAdmiTreeService.getTowns(country.getCountryBasicInfoId());
				for(TownBasicInfo town : towns){
					Item item_2 = new Item();
					item_2.setName(town.getTownName());
					item_2.setType(ItemType.NODE_ITEM);
					
					//Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
					
					
					AdditionalParameters townAdditionalParameters = new AdditionalParameters();
					townAdditionalParameters.setId(town.getTownNum());
					//townAdditionalParameters.setChildren(vilsAsChild);
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
	country = iAdmiTreeService.getCountry(parentId);
			Item item_0 = new Item();
			item_0.setName(country.getCountryName());
			item_0.setType(ItemType.NODE_FOLDER);
			Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
			
				//得到该县的所有镇，并作为县的子节点
				List<TownBasicInfo> towns = iAdmiTreeService.getTowns(country.getCountryBasicInfoId());
				for(TownBasicInfo town : towns){
					Item item_1 = new Item();
					item_1.setName(town.getTownName());
					item_1.setType(ItemType.NODE_ITEM);
					
                  // Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
					
					
					AdditionalParameters townAdditionalParameters = new AdditionalParameters();
					townAdditionalParameters.setId(town.getTownNum());
					//townAdditionalParameters.setChildren(vilsAsChild);
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

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return null;
	}


	public Map<String, Object> getDataMap() {
		return dataMap;
	}


	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}


	public IAdmiTreeService getiAdmiTreeService() {
		return iAdmiTreeService;
	}


	public void setiAdmiTreeService(IAdmiTreeService iAdmiTreeService) {
		this.iAdmiTreeService = iAdmiTreeService;
	}
	
	

}
