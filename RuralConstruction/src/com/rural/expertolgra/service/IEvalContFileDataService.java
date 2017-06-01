package com.rural.expertolgra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rural.bean.EvalContInvesObj;

public interface IEvalContFileDataService {

	void listfile(Map<String, ArrayList<String>> fileNameMap, Integer vilDataCollRecID,
			List<EvalContInvesObj> methObjs);

	List<EvalContInvesObj> getMethObjsByContId(Integer evalContId);

	Integer getRecIdByDistId(Integer expertDistId);

}
