package com.rural.expertolgra.service;

import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;

public interface IEvalContObjAttriService {

	int queryResultsCount(Object object);

	List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from, int length);

}
