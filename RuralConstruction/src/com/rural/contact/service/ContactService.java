package com.rural.contact.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CitysCont;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.CountryCont;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.TownCont;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilCont;
import com.rural.contact.action.ContactAction;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CitysContDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.CountryContDAO;
import com.rural.dao.ExpertGraDAO;
import com.rural.dao.ProBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.TownContDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilContDAO;
import com.rural.tool.Criterion;

public class ContactService implements IContactService{
	
	private CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private TownContDAO  townContDAO = new TownContDAO();
	private CountryContDAO countryContDAO = new CountryContDAO();
	private CitysContDAO citysContDAO = new CitysContDAO();
	private ProBasicInfoDAO proBasicInfoDAO = new ProBasicInfoDAO();
	private VilContDAO vilContDAO = new VilContDAO();
	
	
	
	public VilContDAO getVilContDAO() {
		return vilContDAO;
	}
	public void setVilContDAO(VilContDAO vilContDAO) {
		this.vilContDAO = vilContDAO;
	}
	public ProBasicInfoDAO getProBasicInfoDAO() {
		return proBasicInfoDAO;
	}
	public void setProBasicInfoDAO(ProBasicInfoDAO proBasicInfoDAO) {
		this.proBasicInfoDAO = proBasicInfoDAO;
	}
	public CountryContDAO getCountryContDAO() {
		return countryContDAO;
	}
	public void setCountryContDAO(CountryContDAO countryContDAO) {
		this.countryContDAO = countryContDAO;
	}
	public CitysContDAO getCitysContDAO() {
		return citysContDAO;
	}
	public void setCitysContDAO(CitysContDAO citysContDAO) {
		this.citysContDAO = citysContDAO;
	}
	public TownContDAO getTownContDAO() {
		return townContDAO;
	}
	public void setTownContDAO(TownContDAO townContDAO) {
		this.townContDAO = townContDAO;
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
	
public  void addVilContact(int BasicInfoID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote){
		
		
		

		VilCont vilCont = new VilCont();
		VilBasicInfo vilBasicInfo = new VilBasicInfo();
		vilBasicInfo = vilBasicInfoDAO.findById(BasicInfoID);
		vilCont.setVilContNum(contactNum);
		vilCont.setVilBasicInfo(vilBasicInfo);
		vilCont.setVilContName(contactName);
		vilCont.setVilContWorkTel(contactWorkTel);
		vilCont.setVilContMobTel(contactMobTel);
		vilCont.setVilContComp(contactComp);
		vilCont.setVilContPost(contactPost);
		vilCont.setVilContNote(contactNote);
		vilContDAO.save(vilCont);
		
	}
	public  void updateVilContact(int contactID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote){
		
		VilCont vilCont = new VilCont();
		vilCont = vilContDAO.findById(contactID);
		vilCont.setVilContNum(contactNum);
		vilCont.setVilContName(contactName);
		vilCont.setVilContWorkTel(contactWorkTel);
		vilCont.setVilContMobTel(contactMobTel);
		vilCont.setVilContComp(contactComp);
		vilCont.setVilContPost(contactPost);
		vilCont.setVilContNote(contactNote);
		vilContDAO.attachDirty(vilCont);
		
	}
	public  void delVilContact(int contactID){
		VilCont vilCont = new VilCont();
		vilCont = vilContDAO.findById(contactID);
		vilContDAO.delete(vilCont);
		
		
	}
	public  void addTownContact(int BasicInfoID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote){
		
		
		

		TownCont townCont = new TownCont();
		TownBasicInfo townBasicInfo = new TownBasicInfo();
		townBasicInfo = townBasicInfoDAO.findById(BasicInfoID);
		townCont.setTownContNum(contactNum);
		townCont.setTownBasicInfo(townBasicInfo);
		townCont.setTownContName(contactName);
		townCont.setTownContWorkTel(contactWorkTel);
		townCont.setTownContMobTel(contactMobTel);
		townCont.setTownContComp(contactComp);
		townCont.setTownContPost(contactPost);
		townCont.setTownContNote(contactNote);
		townContDAO.save(townCont);
		
	}
	public  void updateTownContact(int contactID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote){
		
		TownCont townCont = new TownCont();
		townCont = townContDAO.findById(contactID);
		townCont.setTownContNum(contactNum);
		townCont.setTownContName(contactName);
		townCont.setTownContWorkTel(contactWorkTel);
		townCont.setTownContMobTel(contactMobTel);
		townCont.setTownContComp(contactComp);
		townCont.setTownContPost(contactPost);
		townCont.setTownContNote(contactNote);
		townContDAO.attachDirty(townCont);
		
	}
	public  void delTownContact(int contactID){
		TownCont townCont = new TownCont();
		townCont = townContDAO.findById(contactID);
		townContDAO.delete(townCont);
		
		
	}
	
public  void addCountryContact(int BasicInfoID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote){
		
		
		

		CountryCont countryCont = new CountryCont();
		CountryBasicInfo countryBasicInfo = new CountryBasicInfo();
		countryBasicInfo = countryBasicInfoDAO.findById(BasicInfoID);
		countryCont.setCountryBasicInfo(countryBasicInfo);
		countryCont.setCountryContNum(contactNum);
		countryCont.setCountryContName(contactName);
		countryCont.setCountryContWorkTel(contactWorkTel);
		countryCont.setCountryContMobTel(contactMobTel);
		countryCont.setCountryContComp(contactComp);
		countryCont.setCountryContPost(contactPost);
		countryCont.setCountryContNote(contactNote);
		countryContDAO.save(countryCont);
		
	}
	public  void updateCountryContact(int contactID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote){
		
		CountryCont countryCont = new CountryCont();
		countryCont = countryContDAO.findById(contactID);
		countryCont.setCountryContNum(contactNum);
		countryCont.setCountryContName(contactName);
		countryCont.setCountryContWorkTel(contactWorkTel);
		countryCont.setCountryContMobTel(contactMobTel);
		countryCont.setCountryContComp(contactComp);
		countryCont.setCountryContPost(contactPost);
		countryCont.setCountryContNote(contactNote);
		countryContDAO.attachDirty(countryCont);
		
	}
	public  void delCountryContact(int contactID){
		CountryCont countryCont = new CountryCont();
		countryCont = countryContDAO.findById(contactID);
		countryContDAO.delete(countryCont);
		
		
	}
	
	
public  void addCitysContact(int BasicInfoID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote){
		
		
		

		CitysCont citysCont = new CitysCont();
		CityBasicInfo cityBasicInfo = new CityBasicInfo();
		cityBasicInfo = cityBasicInfoDAO.findById(BasicInfoID);
		citysCont.setCitysContNum(contactNum);
		citysCont.setCityBasicInfo(cityBasicInfo);
		citysCont.setCitysContName(contactName);
		citysCont.setCitysContWorkTel(contactWorkTel);
		citysCont.setCitysContMobTel(contactMobTel);
		citysCont.setCitysContComp(contactComp);
		citysCont.setCitysContPost(contactPost);
		citysCont.setCitysContNote(contactNote);
		citysContDAO.save(citysCont);
		
	}
	public  void updateCitysContact(int contactID,String contactNum,String contactName,String contactWorkTel,String contactMobTel,String contactComp,String contactPost,String contactNote){
		
		CitysCont citysCont = new CitysCont();
		citysCont = citysContDAO.findById(contactID);
		citysCont.setCitysContNum(contactNum);
		citysCont.setCitysContName(contactName);
		citysCont.setCitysContWorkTel(contactWorkTel);
		citysCont.setCitysContMobTel(contactMobTel);
		citysCont.setCitysContComp(contactComp);
		citysCont.setCitysContPost(contactPost);
		citysCont.setCitysContNote(contactNote);
		citysContDAO.attachDirty(citysCont);
		
	}
	public  void delCitysContact(int contactID){
		CitysCont citysCont = new CitysCont();
		citysCont = citysContDAO.findById(contactID);
		citysContDAO.delete(citysCont);
		
		
	}
/*
	public List<CityBasicInfo> getCities(int proBasicInfoID) {
		// TODO Auto-generated method stub
		List<CityBasicInfo> list = new ArrayList<CityBasicInfo>();
		list = this.cityBasicInfoDAO.findByProperty("proBasicInfo.proBasicInfoId", proBasicInfoID);
		return list;
	}
	*/
	@SuppressWarnings("unchecked")
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

	
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.townContDAO.getCounts(this.getTownID(ContactAction.JQS), sql, values);
		return rows;
	}
	/*
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		// List<DepartmentAdmin> list = new ArrayList<DepartmentAdmin>();
		List<CitysCont> list1 = new ArrayList<CitysCont>();
		List<CountryCont> list2 = new ArrayList<CountryCont>();
		List<TownCont> list3 = new ArrayList<TownCont>();
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		//list1 = citysContDAO.findByProperty("cityBasicInfo.cityBasicInfoID", Integer.parseInt(ContactAction.JQS));
		//list2 = countryContDAO.findByProperty("countryBasicInfo.countryBasicInfoID", Integer.parseInt(ContactAction.JQS));
		//list3 = townContDAO.findByProperty("townBasicInfo.townBasicInfoID", Integer.parseInt(ContactAction.JQS));
		list1 = this.citysContDAO.findByConditionAndPager(this.getCityID(ContactAction.JQS), sql, values, from,length);
		list2 = this.countryContDAO.findByConditionAndPager(this.getCountryID(ContactAction.JQS), sql, values, from,length);
		list3 = this.townContDAO.findByConditionAndPager(this.getTownID(ContactAction.JQS), sql, values, from,length);
		if(list1.size()>0){
			//list3 = this.townContDAO.findByConditionAndPager(Integer.parseInt(ContactAction.JQS), sql, values, from,length);
			//List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
			for (CitysCont a : list1) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("contactID", a.getCitysContId());
				map.put("BasicInfoID", a.getCityBasicInfo().getCityBasicInfoId());
				if(a.getCitysContNum()==null){
					map.put("contactNum", null);
				}else{
					map.put("contactNum", a.getCitysContNum());
				}
				if(a.getCitysContName()==null){
					map.put("contactName",null);
				}else{
					map.put("contactName", a.getCitysContName());
				}
				if(a.getCitysContTel()==null){
					map.put("contactTel", null);
				}else{
					map.put("contactTel", a.getCitysContTel());
				}
				if(a.getCitysContComp()==null){
					map.put("contactComp", null);
				}else{
					map.put("contactComp", a.getCitysContComp());
				}
			    if( a.getCitysContPost()==null){
			    	map.put("contactPost", null);
			    }else{
			    	map.put("contactPost", a.getCitysContPost());
			    }
				if(a.getCitysContNote()==null){
					map.put("contactNote", null);
				}else{
					map.put("contactNote", a.getCitysContNote());
				}
				result.add(map);
			   }
			}
		if(list2.size()>0){
			//list3 = this.townContDAO.findByConditionAndPager(Integer.parseInt(ContactAction.JQS), sql, values, from,length);
			//List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
			for (CountryCont b : list2) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("contactID", b.getCountryContId());
				map.put("BasicInfoID", b.getCountryBasicInfo().getCountryBasicInfoId());
				
				if(b.getCountryContNum()==null){
					map.put("contactNum",null);
				}else{
					map.put("contactNum", b.getCountryContNum());
				}
				if(b.getCountryContName()==null){
					map.put("contactName",null);
				}else{
					map.put("contactName", b.getCountryContName());
				}
				if(b.getCountryContTel()==null){
					map.put("contactTel", null);
				}else{
					map.put("contactTel", b.getCountryContTel());
				}
				if(b.getCountryContComp()==null){
					map.put("contactComp", null);
				}else{
					map.put("contactComp", b.getCountryContComp());
				}
				if( b.getCountryContPost()==null){
					map.put("contactPost",null);
				}else{
					map.put("contactPost", b.getCountryContPost());
				}
				if(b.getCountryContNote()==null){
					map.put("contactNote",null);
				}else{
					map.put("contactNote", b.getCountryContNote());
				}
				result.add(map);
			   }

			}
		
		if(list3.size()>0){
		//list3 = this.townContDAO.findByConditionAndPager(Integer.parseInt(ContactAction.JQS), sql, values, from,length);
		//List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (TownCont c : list3) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("contactID", c.getTownContId());
			map.put("BasicInfoID", c.getTownBasicInfo().getTownBasicInfoId());
			if(c.getTownContNum()==null){
				map.put("contactNum", null);
			}else{
				map.put("contactNum", c.getTownContNum());
			}
			if(c.getTownContName()==null){
				map.put("contactName", null);
			}else{
				map.put("contactName", c.getTownContName());
			}
			if(c.getTownContTel()==null){
				map.put("contactTel", null);
			}else{
				map.put("contactTel", c.getTownContTel());
			}
			if( c.getTownContComp()==null){
				map.put("contactComp",null);
			}else{
				map.put("contactComp", c.getTownContComp());
			}
			if( c.getTownContPost()==null){
				map.put("contactPost", null);
			}else{
				map.put("contactPost", c.getTownContPost());
			}
			if(c.getTownContNote()==null){
				map.put("contactNote",null);
			}else{
				map.put("contactNote", c.getTownContNote());
			}
			result.add(map);
		   }
		
		}
		return result;
	}
	*/
	
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		
		//List<CitysCont> list1 = new ArrayList<CitysCont>();
		//List<CountryCont> list2 = new ArrayList<CountryCont>();
		//List<TownCont> list3 = new ArrayList<TownCont>();
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		//list1 = this.citysContDAO.findByConditionAndPager(this.getCityID(ContactAction.JQS), sql, values, from,length);
		//list2 = this.countryContDAO.findByConditionAndPager(this.getCountryID(ContactAction.JQS), sql, values, from,length);
		//list3 = this.townContDAO.findByConditionAndPager(this.getTownID(ContactAction.JQS), sql, values, from,length);
		int zeroNum=0;
		String cc = ContactAction.JQS;
		cc=cc.replace(".", "");
		for(int i=cc.length();i>0;i--){
			if(cc.charAt(i-1)!='0') break;
			zeroNum++;
		}
		
		if(zeroNum>=7&&zeroNum<10){
			//list3 = this.townContDAO.findByConditionAndPager(Integer.parseInt(ContactAction.JQS), sql, values, from,length);
			//List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
			List<CitysCont> list1 = new ArrayList<CitysCont>();
			list1 = this.citysContDAO.findByConditionAndPager(this.getCityID(ContactAction.JQS), sql, values, from,length);
			for (CitysCont a : list1) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("contactID", a.getCitysContId());
				map.put("BasicInfoID", a.getCityBasicInfo().getCityBasicInfoId());
				if(a.getCitysContNum()==null){
					map.put("contactNum", null);
				}else{
					map.put("contactNum", a.getCitysContNum());
				}
				if(a.getCitysContName()==null){
					map.put("contactName",null);
				}else{
					map.put("contactName", a.getCitysContName());
				}
				if(a.getCitysContWorkTel()==null){
					map.put("contactWorkTel", null);
				}else{
					map.put("contactWorkTel", a.getCitysContWorkTel());
				}
				if(a.getCitysContMobTel()==null){
					map.put("contactMobTel", null);
				}else{
					map.put("contactMobTel", a.getCitysContMobTel());
				}
				if(a.getCitysContComp()==null){
					map.put("contactComp", null);
				}else{
					map.put("contactComp", a.getCitysContComp());
				}
			    if( a.getCitysContPost()==null){
			    	map.put("contactPost", null);
			    }else{
			    	map.put("contactPost", a.getCitysContPost());
			    }
				if(a.getCitysContNote()==null){
					map.put("contactNote", null);
				}else{
					map.put("contactNote", a.getCitysContNote());
				}
				result.add(map);
			   }
			}
		if(zeroNum>=5&&zeroNum<7){
			//list3 = this.townContDAO.findByConditionAndPager(Integer.parseInt(ContactAction.JQS), sql, values, from,length);
			//List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
			List<CountryCont> list2 = new ArrayList<CountryCont>();
			list2 = this.countryContDAO.findByConditionAndPager(this.getCountryID(ContactAction.JQS), sql, values, from,length);
			
			for (CountryCont b : list2) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("contactID", b.getCountryContId());
				map.put("BasicInfoID", b.getCountryBasicInfo().getCountryBasicInfoId());
				
				if(b.getCountryContNum()==null){
					map.put("contactNum",null);
				}else{
					map.put("contactNum", b.getCountryContNum());
				}
				if(b.getCountryContName()==null){
					map.put("contactName",null);
				}else{
					map.put("contactName", b.getCountryContName());
				}
				if(b.getCountryContWorkTel()==null){
					map.put("contactWorkTel", null);
				}else{
					map.put("contactWorkTel", b.getCountryContWorkTel());
				}
				if(b.getCountryContMobTel()==null){
					map.put("contactMobTel", null);
				}else{
					map.put("contactMobTel", b.getCountryContMobTel());
				}
				if(b.getCountryContComp()==null){
					map.put("contactComp", null);
				}else{
					map.put("contactComp", b.getCountryContComp());
				}
				if( b.getCountryContPost()==null){
					map.put("contactPost",null);
				}else{
					map.put("contactPost", b.getCountryContPost());
				}
				if(b.getCountryContNote()==null){
					map.put("contactNote",null);
				}else{
					map.put("contactNote", b.getCountryContNote());
				}
				result.add(map);
			   }

			}
		
		if(zeroNum>=3&&zeroNum<5){
		List<TownCont> list3 = new ArrayList<TownCont>();
		list3 = this.townContDAO.findByConditionAndPager(this.getTownID(ContactAction.JQS), sql, values, from,length);
		//List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (TownCont c : list3) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("contactID", c.getTownContId());
			map.put("BasicInfoID", c.getTownBasicInfo().getTownBasicInfoId());
			if(c.getTownContNum()==null){
				map.put("contactNum", null);
			}else{
				map.put("contactNum", c.getTownContNum());
			}
			if(c.getTownContName()==null){
				map.put("contactName", null);
			}else{
				map.put("contactName", c.getTownContName());
			}
			if(c.getTownContWorkTel()==null){
				map.put("contactWorkTel", null);
			}else{
				map.put("contactWorkTel", c.getTownContWorkTel());
			}
			if(c.getTownContMobTel()==null){
				map.put("contactMobTel", null);
			}else{
				map.put("contactMobTel", c.getTownContMobTel());
			}
			if( c.getTownContComp()==null){
				map.put("contactComp",null);
			}else{
				map.put("contactComp", c.getTownContComp());
			}
			if( c.getTownContPost()==null){
				map.put("contactPost", null);
			}else{
				map.put("contactPost", c.getTownContPost());
			}
			if(c.getTownContNote()==null){
				map.put("contactNote",null);
			}else{
				map.put("contactNote", c.getTownContNote());
			}
			result.add(map);
		   }
		
		}
		if(zeroNum<3){
			List<VilCont> list3 = new ArrayList<VilCont>();
			list3 = this.vilContDAO.findByConditionAndPager(this.getVilID(ContactAction.JQS), sql, values, from,length);
			//List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
			for (VilCont c : list3) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("contactID", c.getVilContId());
				map.put("BasicInfoID", c.getVilBasicInfo().getVilBasicInfoId());
				if(c.getVilContNum()==null){
					map.put("contactNum", null);
				}else{
					map.put("contactNum", c.getVilContNum());
				}
				if(c.getVilContName()==null){
					map.put("contactName", null);
				}else{
					map.put("contactName", c.getVilContName());
				}
				if(c.getVilContWorkTel()==null){
					map.put("contactWorkTel", null);
				}else{
					map.put("contactWorkTel", c.getVilContWorkTel());
				}
				if(c.getVilContMobTel()==null){
					map.put("contactMobTel", null);
				}else{
					map.put("contactMobTel", c.getVilContMobTel());
				}
				if( c.getVilContComp()==null){
					map.put("contactComp",null);
				}else{
					map.put("contactComp", c.getVilContComp());
				}
				if( c.getVilContPost()==null){
					map.put("contactPost", null);
				}else{
					map.put("contactPost", c.getVilContPost());
				}
				if(c.getVilContNote()==null){
					map.put("contactNote",null);
				}else{
					map.put("contactNote", c.getVilContNote());
				}
			
				result.add(map);
			   }
		}
	   
		return result;
	}
	

	
	public List<HashMap<String, Object>> queryByPage(Object object, int from,
			int length) {
		// TODO Auto-generated method stub
		return null;
	}


	public int queryResultsCount(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//检查编码是否重复
	public boolean checkCityContNum(String contactNum,String contactID) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(contactID==null){
			
			if(citysContDAO.findByProperty1("citysContNum",contactNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(citysContDAO.findById(Integer.parseInt(contactID)).getCitysContNum().equals(contactNum)){
				return false;
			}else{
				if(citysContDAO.findByProperty1("citysContNum", contactNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	public boolean checkCountryContNum(String contactNum,String contactID) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(contactID==null){
			
			if(countryContDAO.findByProperty1("countryContNum", contactNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(countryContDAO.findById(Integer.parseInt(contactID)).getCountryContNum().equals(contactNum)){
				return false;
			}else{
				if(countryContDAO.findByProperty1("countryContNum", contactNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	

	//检查编码是否重复
	public boolean checkTownContNum(String contactNum,String contactID) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(contactID==null){
			
			if(townContDAO.findByProperty1("townContNum", contactNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(townContDAO.findById(Integer.parseInt(contactID)).getTownContNum().equals(contactNum)){
				return false;
			}else{
				if(townContDAO.findByProperty1("townContNum", contactNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
	//检查编码是否重复
	public boolean checkVilContNum(String contactNum,String contactID) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(contactID==null){
			
			if(vilContDAO.findByProperty1("vilContNum", contactNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(vilContDAO.findById(Integer.parseInt(contactID)).getVilContNum().equals(contactNum)){
				return false;
			}else{
				if(vilContDAO.findByProperty1("vilContNum", contactNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
	

}
