package com.rural.scolevstatistics.service;

import java.util.ArrayList;
import java.util.List;

import com.rural.bean.CountryBasicInfo;
import com.rural.bean.ScoLev;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.ScoLevDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;

public class ScoLevStatisticsService implements IScoLevStatisticsService {
	VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
	VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();//采集记录
	VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();//村庄得分
	//ScoLevDAO scoLevDAO = new ScoLevDAO();//得分等级
	
	public Integer[] ScoLStatistic(String collTime, String sysUserBeloDiviCode) {//参数，采集时间、行政区划编码
		// TODO Auto-generated method stub
		Integer[] count = {0,0,0,0,0,0,0};
		
		
		//根据行政区划找到村
		List<VilBasicInfo> vilBasicInfo= findVil(sysUserBeloDiviCode);
		statisticScore(vilBasicInfo,count,collTime);
		return count;
	}
	
	//统计各个等级的村庄数目
	private void statisticScore(List<VilBasicInfo> vilBasicInfo,Integer[] count,String collTime) {
		String ScoLevCode;
		for (VilBasicInfo vilBasicInfo2 : vilBasicInfo) {
			Integer vilBasicInfoId= vilBasicInfo2.getVilBasicInfoId();
			List<VilDataCollRec> vilDataCollRec = vilDataCollRecDAO.findVilDataCollRec(vilBasicInfoId,Integer.parseInt(collTime));
			for (VilDataCollRec vilDataCollRec2 : vilDataCollRec) {
				Integer vilDataCollRecId = vilDataCollRec2.getVilDataCollRecId();
				List<VilEvalSco> vilEvalSco = vilEvalScoDAO.findByProperty("vilDataCollRec.vilDataCollRecId", vilDataCollRecId);//村庄得分
				for (VilEvalSco vilEvalSco2 : vilEvalSco) {
					ScoLev scoLev = vilEvalSco2.getScoLev();//分数等级
					if(scoLev!=null){
						String scoLevCode =scoLev.getScoLevCode();//分数等级的编码
						if(scoLevCode!=null){
							if(scoLevCode.equals("07")){
								count[0]++;
							}else if(scoLevCode.equals("06")){
								count[1]++;
							}else if(scoLevCode.equals("05")){
								count[2]++;
							}else if(scoLevCode.equals("04")){
								count[3]++;
							}else if(scoLevCode.equals("03")){
								count[4]++;
							}else if(scoLevCode.equals("02")){
								count[5]++;
							}else if(scoLevCode.equals("01")){
								count[6]++;
							}
						}
						
					}
					
				}
			}
		}
	}
	//根据行政区划找到村
	private List<VilBasicInfo> findVil(String sysUserBeloDiviCode) {
		int zeroNum=0;
		String code="";
		List<VilBasicInfo> vilBasicInfo = new ArrayList<VilBasicInfo>();
		List<List<VilBasicInfo>> vilBasicInfo1 = new ArrayList<List<VilBasicInfo>>();
		List<TownBasicInfo> townBasicInfo = new ArrayList<TownBasicInfo>();
		List<CountryBasicInfo> countryBasicInfo = new ArrayList<CountryBasicInfo>();
		code=sysUserBeloDiviCode.replace(".","");
		for(int i=code.length();i>0;i--){
			if(code.charAt(i-1)!='0') break;
			zeroNum++;
		}
		if(zeroNum<3)//村级
		{		
		}else if(zeroNum<5){//镇级
		 vilBasicInfo = vilBasicInfoDAO.findByProperty("townBasicInfo.townNum", sysUserBeloDiviCode);
				
		}else if(zeroNum<7){//县级
			townBasicInfo = townBasicInfoDAO.findByProperty1("countryBasicInfo.countryNum", sysUserBeloDiviCode);
			for (TownBasicInfo townBasicInfo2 : townBasicInfo) {
				
				vilBasicInfo1.add(vilBasicInfoDAO.findByProperty("townBasicInfo.townNum", townBasicInfo2.getTownNum()))  ;
			}
			for (List<VilBasicInfo> vl : vilBasicInfo1) {
				for (VilBasicInfo vilBasicInfo2 : vl) {
					vilBasicInfo.add(vilBasicInfo2);
				}
			}
			
		}else if(zeroNum<10){//市级
			countryBasicInfo = countryBasicInfoDAO.findByProperty1("cityBasicInfo.cityNum", sysUserBeloDiviCode);
			for (CountryBasicInfo countryBasicInfo2 : countryBasicInfo) {
				townBasicInfo = townBasicInfoDAO.findByProperty1("countryBasicInfo.countryNum", countryBasicInfo2.getCountryNum());
				for (TownBasicInfo townBasicInfo2 : townBasicInfo) {
					
					vilBasicInfo1.add(vilBasicInfoDAO.findByProperty("townBasicInfo.townNum", townBasicInfo2.getTownNum()))  ;
				}
				
			}
			for (List<VilBasicInfo> vl : vilBasicInfo1) {
				for (VilBasicInfo vilBasicInfo2 : vl) {
					vilBasicInfo.add(vilBasicInfo2);
				}
			}
			
		}
		return vilBasicInfo;
	}
	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}
	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}
	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}
	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}
	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}
	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
	}
	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}
	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
	}
	public VilDataCollRecDAO getVilDataCollRecDAO() {
		return vilDataCollRecDAO;
	}
	public void setVilDataCollRecDAO(VilDataCollRecDAO vilDataCollRecDAO) {
		this.vilDataCollRecDAO = vilDataCollRecDAO;
	}
	public VilEvalScoDAO getVilEvalScoDAO() {
		return vilEvalScoDAO;
	}
	public void setVilEvalScoDAO(VilEvalScoDAO vilEvalScoDAO) {
		this.vilEvalScoDAO = vilEvalScoDAO;
	}

	
	
	

}
