package com.rural.admiDivisions.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.admiDivisions.action.TowntreeAction;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.TownCont;
import com.rural.bean.TownFil;
import com.rural.bean.VilBasicInfo;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.TownContDAO;
import com.rural.dao.TownFilDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.tool.Criterion;
public class TowntreeService{
	
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private CountryBasicInfoDAO countryBasicInfoDAO=new CountryBasicInfoDAO();
	

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
	
	
	public List<TownBasicInfo> getChildPrivance(String s) {
		// TODO Auto-generated method stub
		
		Integer d=0;
		List<CountryBasicInfo> list2= this.countryBasicInfoDAO.findCID(s.trim());
		for (CountryBasicInfo countryBasicInfo : list2) {
			d=countryBasicInfo.getCountryBasicInfoId();
		}
		List<TownBasicInfo> list = new ArrayList<TownBasicInfo>();
		list = this.townBasicInfoDAO.findAll1(d);
		return list;
	}

	
	

}
