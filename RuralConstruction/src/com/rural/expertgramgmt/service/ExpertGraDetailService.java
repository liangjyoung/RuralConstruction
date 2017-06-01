package com.rural.expertgramgmt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalExpertDist;
import com.rural.bean.ExpertGra;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.EvalExpertDistDAO;
import com.rural.dao.ExpertGraDAO;
import com.rural.expertgramgmt.action.ExpertGraDetailAction;
import com.rural.tool.Criterion;

public class ExpertGraDetailService implements IExpertGraDetailService {
	private EvalContSubScoDAO evalContSubScoDAO = new EvalContSubScoDAO();
	private EvalExpertDistDAO evalExpertDistDAO = new EvalExpertDistDAO();
	private ExpertGraDAO expertGraDAO = new ExpertGraDAO();

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from, int length) {
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		Integer vilEvalScoId = evalContSubScoDAO.findById(ExpertGraDetailAction.getSid()).getVilEvalSco().getVilEvalScoId();
		List<EvalExpertDist> evalExpertDists = evalExpertDistDAO.findByProperty("vilEvalSco.vilEvalScoId", vilEvalScoId);
		String sql = "EvalContID = " + ExpertGraDetailAction.getCid();
		sql += " and EvalExpertDistID in (";
		for(EvalExpertDist evalExpertDist : evalExpertDists){
			sql += (evalExpertDist.getEvalExpertDistId() + ",");
		}
		sql += "'')";
		List<ExpertGra> expertGras = expertGraDAO.findBySql(sql);
		for(ExpertGra expertGra : expertGras){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ExpertGraId", expertGra.getExpertGraId());
			map.put("ExpertName", expertGra.getEvalExpertDist().getExpert().getExpertName());
			map.put("Sco", expertGra.getSco());
			map.put("GraRea", expertGra.getGraRea());
			result.add(map);
		}
		return result;
		
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		Integer vilEvalScoId = evalContSubScoDAO.findById(ExpertGraDetailAction.getSid()).getVilEvalSco().getVilEvalScoId();
		List<EvalExpertDist> evalExpertDists = evalExpertDistDAO.findByProperty("vilEvalSco.vilEvalScoId", vilEvalScoId);
		String sql = "EvalContID = " + ExpertGraDetailAction.getCid();
		sql += " and EvalExpertDistID in (";
		for(EvalExpertDist evalExpertDist : evalExpertDists){
			sql += (evalExpertDist.getEvalExpertDistId() + ",");
		}
		sql += "'')";
		return expertGraDAO.findBySql(sql).size();
	}

	public EvalContSubScoDAO getEvalContSubScoDAO() {
		return evalContSubScoDAO;
	}

	public void setEvalContSubScoDAO(EvalContSubScoDAO evalContSubScoDAO) {
		this.evalContSubScoDAO = evalContSubScoDAO;
	}

	public EvalExpertDistDAO getEvalExpertDistDAO() {
		return evalExpertDistDAO;
	}

	public void setEvalExpertDistDAO(EvalExpertDistDAO evalExpertDistDAO) {
		this.evalExpertDistDAO = evalExpertDistDAO;
	}

	public ExpertGraDAO getExpertGraDAO() {
		return expertGraDAO;
	}

	public void setExpertGraDAO(ExpertGraDAO expertGraDAO) {
		this.expertGraDAO = expertGraDAO;
	}
	

}
