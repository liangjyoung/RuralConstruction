package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IGoveFilClfyService {

	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void addGoveFilClfy(String GoveFilClfyNum, String GoveFilClfyName, String GoveFilClfyNote);
	public abstract void updateGoveFilClfy(Integer id, String GoveFilClfyNum, String GoveFilClfyName, String GoveFilClfyNote);
	public abstract String delGoveFilClfy(Integer id);
	public abstract boolean checkGoveFilClfyNum(String goveFilClfyNum, String id);
}
