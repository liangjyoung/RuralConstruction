package com.rural.expertgramgmt.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.expertgramgmt.service.IGetVilService;
import com.rural.tool.AdditionalParameters;
import com.rural.tool.Criterion;
import com.rural.tool.Item;
import com.rural.tool.ItemType;
import com.rural.tool.JqGridBaseAction;

public class GetVilAction extends JqGridBaseAction {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private IGetVilService iGetVilService;
	private Integer userId;
	private Integer roleId;
	private String diviCode;
	private static final int proId = 1;
	
	@SuppressWarnings("unchecked")
	public String manageVils(){
		userId= Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("userid"));
		diviCode= (String) ServletActionContext.getRequest().getSession().getAttribute("sysUserBeloDiviCode");
		roleId = Integer.parseInt((String) ServletActionContext.getRequest().getSession().getAttribute("changeroleid"));

//		System.out.println(userId);
//		System.out.println(diviCode);
//		System.out.println(roleId);
		
		
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		if(roleId == 1){//该用户为系统管理员，可以查看全部村庄
			items = getAllVils();
		}else if (roleId == 2 || roleId == 3) {//该用户为地市管理员或地市用户，可以查看本市村庄
			Integer cityId = iGetVilService.getCityIdByCityNum(diviCode);
			items = getVilsOfOneCity(cityId);
		}else if(roleId == 4){//该用户为县级用户，可以查看本县村庄
			Integer countryId = iGetVilService.getCountryIdByCountryNum(diviCode);
			items = getVilsOfOneCountry(countryId);
		}else if(roleId == 5){//该用户为镇级用户，可以查看本镇村庄
			Integer townId = iGetVilService.getTownIdByTownNum(diviCode);
			items = getVilsOfOneTown(townId);
		}
		dataMap.put("ss", items);
//		System.out.println(dataMap);
		return SUCCESS;
	}
	
	private Map<String, Item> getVilsOfOneTown(Integer townId) {
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		//得到该镇的所有村
		List<VilBasicInfo> vils = iGetVilService.getVilsByTownId(townId);
		if(vils.size() > 0){
			for(VilBasicInfo vil : vils){
				Item item_3 = new Item();
				item_3.setName(vil.getVilName());
				item_3.setType(ItemType.NODE_ITEM);
				AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
				vilAdditionalParameters.setId(vil.getVilNum());
	//			if(this.isFirstItem == 0){
	//				vilAdditionalParameters.setItemSelected(true);
	//				this.isFirstItem++;
	//			}
				item_3.setAdditionalParameters(vilAdditionalParameters);
				items.put(vil.getVilName(), item_3);
			}
		}
		return items;
	}

	private Map<String, Item> getVilsOfOneCountry(Integer countryId) {
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		//得到该县的所有镇
		List<TownBasicInfo> towns = iGetVilService.getTownsByCountryId(countryId);
		if(towns.size() > 0){
			for(TownBasicInfo town : towns){
				Item item_2 = new Item();
				item_2.setName(town.getTownName());
				item_2.setType(ItemType.NODE_FOLDER);
				AdditionalParameters townAdditionalParameters = new AdditionalParameters();
				townAdditionalParameters.setId(town.getTownNum());
				//得到该镇的所有村，并作为镇的子节点
				List<VilBasicInfo> vils = iGetVilService.getVilsByTownId(town.getTownBasicInfoId());
				if(vils.size() > 0){
					Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
					for(VilBasicInfo vil : vils){
						Item item_3 = new Item();
						item_3.setName(vil.getVilName());
						item_3.setType(ItemType.NODE_ITEM);
						AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
						vilAdditionalParameters.setId(vil.getVilNum());
		//				if(this.isFirstItem == 0){
		//					vilAdditionalParameters.setItemSelected(true);
		//					this.isFirstItem++;
		//				}
						item_3.setAdditionalParameters(vilAdditionalParameters);
						vilsAsChild.put(vil.getVilName(), item_3);
					}
					townAdditionalParameters.setChildren(vilsAsChild);
				}
				item_2.setAdditionalParameters(townAdditionalParameters);
				items.put(town.getTownName(), item_2);
			}
		}
		return items;
	}

	private Map<String, Item> getVilsOfOneCity(Integer cityId) {
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		//得到该市的所有县
		List<CountryBasicInfo> countries = iGetVilService.getCountriesByCityId(cityId);
		for(CountryBasicInfo country : countries){
			Item item_1 = new Item();
			item_1.setName(country.getCountryName());
			item_1.setType(ItemType.NODE_FOLDER);
			AdditionalParameters countryAdditionalParameters = new AdditionalParameters();
			countryAdditionalParameters.setId(country.getCountryNum());
			//得到该县的所有镇，并作为县的子节点
			List<TownBasicInfo> towns = iGetVilService.getTownsByCountryId(country.getCountryBasicInfoId());
			if(towns.size() > 0){
				Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
				for(TownBasicInfo town : towns){
					Item item_2 = new Item();
					item_2.setName(town.getTownName());
					item_2.setType(ItemType.NODE_FOLDER);
					AdditionalParameters townAdditionalParameters = new AdditionalParameters();
					townAdditionalParameters.setId(town.getTownNum());
					//得到该镇的所有村，并作为镇的子节点
					List<VilBasicInfo> vils = iGetVilService.getVilsByTownId(town.getTownBasicInfoId());
					if(vils.size() > 0){
						Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
						for(VilBasicInfo vil : vils){
							Item item_3 = new Item();
							item_3.setName(vil.getVilName());
							item_3.setType(ItemType.NODE_ITEM);
							AdditionalParameters vilAdditionalParameters = new AdditionalParameters();
							vilAdditionalParameters.setId(vil.getVilNum());
		//					if(this.isFirstItem == 0){
		//						vilAdditionalParameters.setItemSelected(true);
		//						this.isFirstItem++;
		//					}
							item_3.setAdditionalParameters(vilAdditionalParameters);
							vilsAsChild.put(vil.getVilName(), item_3);
						}
						townAdditionalParameters.setChildren(vilsAsChild);
					}
					item_2.setAdditionalParameters(townAdditionalParameters);
					townsAsChild.put(town.getTownName(), item_2);
				}
				countryAdditionalParameters.setChildren(townsAsChild);
			}
			item_1.setAdditionalParameters(countryAdditionalParameters);
			items.put(country.getCountryName(), item_1);
		}
		return items;
	}

	private Map getAllVils(){
		Map<String, Item> items = new LinkedHashMap<String, Item>();
		//根据省编码得到该省的所有市
		List<CityBasicInfo> cities = iGetVilService.getCitiesByProId(proId);
		if(cities.size() > 0){
			for(CityBasicInfo city : cities){
				Item item_0 = new Item();
				item_0.setName(city.getCityName());
				item_0.setType(ItemType.NODE_FOLDER);
				AdditionalParameters cityAdditionalParameters = new AdditionalParameters();
				cityAdditionalParameters.setId(city.getCityNum());
				
				//得到该市的所有县，并作为市的子节点
				List<CountryBasicInfo> countries = iGetVilService.getCountriesByCityId(city.getCityBasicInfoId());
//				System.out.println("countries.size:"+countries.size());
				if(countries.size() > 0){
					Map<String, Item> countriesAsChild = new LinkedHashMap<String, Item>();
					for(CountryBasicInfo country : countries){
						Item item_1 = new Item();
						item_1.setName(country.getCountryName());
						item_1.setType(ItemType.NODE_FOLDER);
						AdditionalParameters countryAdditionalParameters = new AdditionalParameters();
						countryAdditionalParameters.setId(country.getCountryNum());
						
						
						//得到该县的所有镇，并作为县的子节点
						List<TownBasicInfo> towns = iGetVilService.getTownsByCountryId(country.getCountryBasicInfoId());
//						System.out.println(country.getCountryName()+"--towns.size:"+towns.size());
						if(towns.size() > 0){
							Map<String, Item> townsAsChild = new LinkedHashMap<String, Item>();
							for(TownBasicInfo town : towns){
								Item item_2 = new Item();
								item_2.setName(town.getTownName());
								item_2.setType(ItemType.NODE_FOLDER);
								AdditionalParameters townAdditionalParameters = new AdditionalParameters();
								townAdditionalParameters.setId(town.getTownNum());

								//得到该镇的所有村，并作为镇的子节点
								List<VilBasicInfo> vils = iGetVilService.getVilsByTownId(town.getTownBasicInfoId());
//								System.out.println(town.getTownName()+"--vils.size:"+vils.size());
								if(vils.size() > 0){
									Map<String, Item> vilsAsChild = new LinkedHashMap<String, Item>();
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
									townAdditionalParameters.setChildren(vilsAsChild);
								}
								
								
								item_2.setAdditionalParameters(townAdditionalParameters);
								townsAsChild.put(town.getTownName(), item_2);
							}
							countryAdditionalParameters.setChildren(townsAsChild);
						}
						
						item_1.setAdditionalParameters(countryAdditionalParameters);
						//items.put(country.getCountryName(), item_1);
						countriesAsChild.put(country.getCountryName(), item_1);
					}
					cityAdditionalParameters.setChildren(countriesAsChild);
				}

				item_0.setAdditionalParameters(cityAdditionalParameters);
				items.put(city.getCityName(), item_0);
			}
		}
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

	public IGetVilService getiGetVilService() {
		return iGetVilService;
	}

	public void setiGetVilService(IGetVilService iGetVilService) {
		this.iGetVilService = iGetVilService;
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

	public static int getProid() {
		return proId;
	}
	

}
