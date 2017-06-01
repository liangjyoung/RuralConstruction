package com.rural.expertolgra.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.bean.EvalExpertDist;
import com.rural.tool.Criterion;

public interface IExpertOLGraService {

	int getExpertId(int userId);
	List<EvalExpertDist> getDistsUnevaluated(int expertId, boolean b);
	int queryResultsCount(List<Criterion> criteria);
	List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from, int length);
	void saveScore(Integer expertDistID, Map<Integer, List<String>> scoreMap);
	void modifyIsSubmit(Integer expertDistID);
	Integer getMajorId(Integer expertDistID);
	Integer getVilEvalScoId(Integer expertDistID);
	List<EvalExpertDist> getExpertsTotal(Integer majorId, Integer vilEvalScoId);
	void calcEvalContSubSco(List<Integer> contIds, List<Integer> distIds, Integer vilEvalScoId);
	void calcVilEvalSco(Integer vilEvalScoId);
}
