package com.rural.admiDivisions.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.rural.govfile.service.TownFilService;
import com.rural.tool.Criterion;
public class ViltreeService{
	
	
	private VilBasicInfoDAO vilBasicInfoDAO  =  new VilBasicInfoDAO(); 
	private TownBasicInfoDAO townBasicInfoDAO=new TownBasicInfoDAO();
	
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

	
	
	
	public List<VilBasicInfo> getChildPrivance(String s) {
		// TODO Auto-generated method stub
		Integer sd=0;
		List<TownBasicInfo> lists=this.townBasicInfoDAO.findTID(s.trim());
		for (TownBasicInfo townBasicInfo : lists) {
			sd=townBasicInfo.getTownBasicInfoId();
		}
		List<VilBasicInfo> list = new ArrayList<VilBasicInfo>();
		list = this.vilBasicInfoDAO.findAll1(sd);
		return list;
	}

	
	

}
