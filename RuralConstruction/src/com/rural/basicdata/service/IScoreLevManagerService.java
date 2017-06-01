package com.rural.basicdata.service;

import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IScoreLevManagerService {
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length) ;
	
}
