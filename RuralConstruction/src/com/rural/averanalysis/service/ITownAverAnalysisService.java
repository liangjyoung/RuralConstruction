package com.rural.averanalysis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface ITownAverAnalysisService {
	
	public abstract ArrayList<HashMap<String, Object>> findAll();
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	
	public List<HashMap<String, Object>> townAverAnalysis(String townNum);
	
	public List<HashMap<String, Object>> townAver(String townNum ,int year);

}
