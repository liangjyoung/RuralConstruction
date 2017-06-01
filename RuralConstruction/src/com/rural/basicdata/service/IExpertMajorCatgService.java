package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IExpertMajorCatgService {

	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract void addExpertMajorCatg(String expertMajorNum, String expertMajorCatg);
	public abstract void updateExpertMajorCatg(Integer id, String expertMajorNum, String expertMajorCatg);
	public abstract String delExpertMajorCatg(Integer id);
	public abstract boolean checkExpertMajorNum(String expertMajorNum, String id);
}
