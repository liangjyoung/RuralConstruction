package com.rural.govfile.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.GoveFilClfy;
import com.rural.tool.Criterion;

public interface ICitysFilService {
 
	public abstract List<GoveFilClfy> getChildPrivance(  );
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);

	public abstract void addCitysFil(String GoveFilClfyID,Integer CityBasicInfoID,String CitysFilNum,String CitysFilName,String CitysFilIdef,Date CitysFilMadTim,String CitysFilPubComp,String CitysFilExpl);
	public abstract void updateCitysFil(String GoveFilClfyID,Integer CityBasicInfoID,String CitysFilID,String CitysFilNum,String CitysFilName,String CitysFilIdef,Date CitysFilMadTim,String CitysFilPubComp,String CitysFilExpl);
	public abstract void delCitysFil(String CitysFilID);
	public abstract boolean checkCitysFilNum(String CitysFilNum,String CitysFilID);
	public boolean addGoveFilClfy(String GoveFilClfyNum, String GoveFilClfyName);
	public boolean checkGoveFilClfyNumCode1(String GoveFilClfyNum);
	public String delGoveFilClfy1(String GoveFilClfyNum);
}

