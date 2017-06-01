package com.rural.basicdata.service;

import java.util.HashMap;
import java.util.List;

import com.rural.bean.Nation;
import com.rural.bean.Sex;
import com.rural.tool.Criterion;

public interface INationService {
	
	public abstract void addNation(String nationCode, String nationName);

	public abstract String delNation(Integer id);

	public abstract void updateNation(Integer id,String nationCode, String nationName);

	public abstract int queryResultsCount(List<Criterion> criteria);

	public abstract List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,int from, int length);
	
	public abstract boolean checkNationCode(String nationCode, String id);
	
	public Nation getNationById(Integer nationid);
}
