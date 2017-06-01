package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IEduService {
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void addEdu(String eduCode, String eduName);
	public abstract void updateEdu(Integer id,String eduCode, String eduName);
	public abstract String delEdu(Integer id);
	public abstract boolean checkEduCode(String eduCode, String id);
}
