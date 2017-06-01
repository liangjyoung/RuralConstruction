package com.rural.expertgramgmt.service;

import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IExpertGraDetailService {

	int queryResultsCount(List<Criterion> criteria);

	List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length);

}
