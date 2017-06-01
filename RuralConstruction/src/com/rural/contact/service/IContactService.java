package com.rural.contact.service;

import java.util.HashMap;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.tool.Criterion;

public interface IContactService {
	
	public int getProID(String proNum);
	
	public int getCityID(String cityNum);

	List<CityBasicInfo> getCities(String proNum);
	
	public abstract CityBasicInfo getCity(String cityNum);

	List<CountryBasicInfo> getCountries(int cityBasicInfoID);
	
	public CountryBasicInfo getCountry(String countryNum);
	
	public int getCountryID(String countryNum);

	List<TownBasicInfo> getTowns(int countryBasicInfoID);
	
	public int getTownID(String townNum);
	
	public TownBasicInfo getTown(String townNum);
	
	List<VilBasicInfo> getVils(int VilBasicInfoID);
	
	public int getVilID(String vilNum);

	public abstract int queryResultsCount(Object object);

	public abstract List<HashMap<String, Object>> queryByPage(Object object, int from, int length);

	public abstract int queryResultsCount(List<Criterion> criteria);

	public abstract List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length);


	public abstract void addVilContact(int basicInfoID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote);
	public abstract void updateVilContact(int contactID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote);
	public abstract void delVilContact(int contactID);
	
	
	public abstract void addTownContact(int basicInfoID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote);
	public abstract void updateTownContact(int contactID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote);
	public abstract void delTownContact(int contactID);
	
	public abstract void addCountryContact(int basicInfoID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote);
	public abstract void updateCountryContact(int contactID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote);
	public abstract void delCountryContact(int contactID);
	
	public abstract void addCitysContact(int basicInfoID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote);
	public abstract void updateCitysContact(int contactID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote);
	public abstract void delCitysContact(int contactID);
	
	public abstract boolean checkCityContNum(String contactNum,String contactID);
	public abstract boolean checkCountryContNum(String contactNum,String contactID);
	public abstract boolean checkTownContNum(String contactNum,String contactID);
	public abstract boolean checkVilContNum(String contactNum,String contactID);
}
