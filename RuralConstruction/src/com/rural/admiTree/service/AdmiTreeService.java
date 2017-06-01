package com.rural.admiTree.service;

import java.util.ArrayList;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CitysContDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.CountryContDAO;
import com.rural.dao.ProBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.TownContDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilContDAO;

public class AdmiTreeService  implements IAdmiTreeService{
	
	private CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	//private TownContDAO  townContDAO = new TownContDAO();
	//private CountryContDAO countryContDAO = new CountryContDAO();
	//private CitysContDAO citysContDAO = new CitysContDAO();
	private ProBasicInfoDAO proBasicInfoDAO = new ProBasicInfoDAO();
	//private VilContDAO vilContDAO = new VilContDAO();
	
	public int getProID(String proNum){
		int a =0 ;
		List<ProBasicInfo> li = new ArrayList<ProBasicInfo>();
		li = this.proBasicInfoDAO.findByProNum(proNum);
		for (ProBasicInfo proBasicInfo : li) {
			a = proBasicInfo.getProBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	public int getCityID(String cityNum){
		int a =0 ;
		List<CityBasicInfo> li = new ArrayList<CityBasicInfo>();
		li = this.cityBasicInfoDAO.findByProperty1("cityNum", cityNum);
		for (CityBasicInfo cityBasicInfo : li) {
			a = cityBasicInfo.getCityBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	
	public int getCountryID(String countryNum){
		int a =0 ;
		List<CountryBasicInfo> li = new ArrayList<CountryBasicInfo>();
		li = this.countryBasicInfoDAO.findByProperty1("countryNum", countryNum);
		for (CountryBasicInfo countryBasicInfo : li) {
			a = countryBasicInfo.getCountryBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	
	public int getTownID(String townNum){
		int a =0 ;
		List<TownBasicInfo> li = new ArrayList<TownBasicInfo>();
		li = this.townBasicInfoDAO.findByProperty1("townNum", townNum);
		for (TownBasicInfo townBasicInfo : li) {
			a = townBasicInfo.getTownBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	
	public int getVilID(String vilNum){
		int a =0 ;
		List<VilBasicInfo> li = new ArrayList<VilBasicInfo>();
		li = this.vilBasicInfoDAO.findByProperty("vilNum", vilNum);
		for (VilBasicInfo vilBasicInfo : li) {
			a = vilBasicInfo.getVilBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	public List<CityBasicInfo> getCities(String  proNum) {
		// TODO Auto-generated method stub
		
		List<CityBasicInfo> list = new ArrayList<CityBasicInfo>();
		
		list = this.cityBasicInfoDAO.findByProperty("proBasicInfo.proBasicInfoId",this.getProID(proNum));
		return list;
	}
	public  CityBasicInfo getCity(String cityNum)
	{
		CityBasicInfo cityBasicInfo = new CityBasicInfo();
		cityBasicInfo = this.cityBasicInfoDAO.findById(this.getCityID(cityNum));
		return cityBasicInfo;
		
	}
	
	public TownBasicInfo getTown(String townNum)
	{
		TownBasicInfo townBasicInfo = new TownBasicInfo();
		townBasicInfo = this.townBasicInfoDAO.findById(this.getTownID(townNum));
		return townBasicInfo;
	} 

	@SuppressWarnings("unchecked")
	public List<CountryBasicInfo> getCountries(int cityBasicInfoID) {
		// TODO Auto-generated method stub
		List<CountryBasicInfo> list = new ArrayList<CountryBasicInfo>();
		list = this.countryBasicInfoDAO.findByProperty("cityBasicInfo.cityBasicInfoId", cityBasicInfoID);
		return list;
	}
	
	public List<VilBasicInfo> getVils(int vilBasicInfoID) {
		// TODO Auto-generated method stub
		List<VilBasicInfo> list = new ArrayList<VilBasicInfo>();
		list = this.vilBasicInfoDAO.findByProperty("townBasicInfo.townBasicInfoId", vilBasicInfoID);
		return list;
	}
	public CountryBasicInfo getCountry(String countryNum)
	{
		CountryBasicInfo countryBasicInfo = new CountryBasicInfo();
		countryBasicInfo = this.countryBasicInfoDAO.findById(this.getCountryID(countryNum));
		return countryBasicInfo;
	} 

	@SuppressWarnings("unchecked")
	
	public List<TownBasicInfo> getTowns(int countryBasicInfoID) {
		// TODO Auto-generated method stub
		List<TownBasicInfo> list = new ArrayList<TownBasicInfo>();
		list = this.townBasicInfoDAO.findByProperty("countryBasicInfo.countryBasicInfoId", countryBasicInfoID);
		return list;
	}
	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}
	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
	}
	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}
	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}
	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}
	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}
	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}
	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}
	
	public ProBasicInfoDAO getProBasicInfoDAO() {
		return proBasicInfoDAO;
	}
	public void setProBasicInfoDAO(ProBasicInfoDAO proBasicInfoDAO) {
		this.proBasicInfoDAO = proBasicInfoDAO;
	}
	
	

}
