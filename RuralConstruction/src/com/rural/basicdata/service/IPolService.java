package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IPolService {
	
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void addPol(String polCode, String polName);
	public abstract void updatePol(Integer id,String polCode, String polName);
	public abstract String delPol(Integer id);
	public abstract boolean checkPolCode(String polCode, String id);
}
