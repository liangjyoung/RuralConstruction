package com.rural.expertgramgmt.service;

import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IExpertGraMgmtService {

	Integer getVilIdByVilNum(String vilNum);

	List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,	int from, int length);

	int queryResultsCount(List<Criterion> criteria);

}
