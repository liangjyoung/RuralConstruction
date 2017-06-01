package com.rural.govfile.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.GoveFilClfy;
import com.rural.tool.Criterion;

public interface ICountryFilService {
  
	public abstract List<GoveFilClfy> getChildPrivance(  );
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);

	public abstract void addCountryFil(String GoveFilClfyID,Integer CountryBasicInfoID,String CountryFilNum,String CountryFilName,String CountryFilIdef,Date CountryFilMadTim,String CountryFilPubComp,String CountryFilExpl);
	public abstract void updateCountryFil(String GoveFilClfyID,Integer CountryBasicInfoID,String CountryFilID,String CountryFilNum,String CountryFilName,String CountryFilIdef,Date CountryFilMadTim,String CountryFilPubComp,String CountryFilExpl);
	public abstract void delCountryFil(String CountryFilID);
	public abstract boolean checkCountryFilNum(String CountryFilNum,String CountryFilID);
	public boolean addGoveFilClfy(String GoveFilClfyNum, String GoveFilClfyName);
	public boolean checkGoveFilClfyNumCode1(String GoveFilClfyNum);
	public String delGoveFilClfy1(String GoveFilClfyNum);
}
