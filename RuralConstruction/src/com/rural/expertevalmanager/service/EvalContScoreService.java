package com.rural.expertevalmanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalContSubSco;
import com.rural.bean.EvalExpertDist;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.expertevalmanager.action.EvalContScoreAction;
import com.rural.expertevalmanager.action.ExpertDistAction;
import com.rural.tool.Criterion;

public class EvalContScoreService implements IEvalContScoreService{

	private EvalContSubScoDAO contSubScoDAO = new EvalContSubScoDAO();
	
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		
		sql = " vilEvalSco.vilEvalScoId = "+Integer.parseInt(EvalContScoreAction.getVilEvalConts());
		//sql = " ";
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		
		List<EvalContSubSco> list2 = new ArrayList<EvalContSubSco>();
		list2 = this.contSubScoDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (EvalContSubSco b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("EvalScoID", b.getEvalScoId());
			if (b.getEvalCont() == null) {
				map.put("EvalContName", null);
				map.put("EvalContNum", null);
			} else {
				if (b.getEvalCont().getEvalContDes() ==null) {
					map.put("EvalContName", null);
				} else{
					map.put("EvalContName",b.getEvalCont().getEvalContDes());
				}
				
				if (b.getEvalCont().getEvalContSeqNum()==null) {
					map.put("EvalContNum", null);
				} else {
					map.put("EvalContNum", b.getEvalCont().getEvalContSeqNum());
				}
			}
				
			
			if (b.getExpertEvalContTotGra() == null) {
				map.put("ExpertScore", null);
			} else {
				map.put("ExpertScore", b.getExpertEvalContTotGra());
			}
			
			if (b.getAutoEvalSco() == null) {
				map.put("AutoScore", null);
			} else {
				map.put("AutoScore", b.getAutoEvalSco());
			}	
			
			if (b.getVilEvalContTotGra() == null) {
				map.put("Score", null);
			} else {
				map.put("Score",b.getVilEvalContTotGra());
			}
			
			if (b.getEvalMeth() == null) {
				map.put("Score", null);
			} else {
				map.put("Score",b.getEvalMeth());
			}
			
			result.add(map);
		}

		return result;
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		int ID = Integer.parseInt(EvalContScoreAction.getVilEvalConts());
		sql = " vilEvalSco.vilEvalScoId = "+ID;
		//sql = " ExpertID = 1";
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.contSubScoDAO.getCounts(sql, values);
		return rows;
	}

	public void setContSubScoDAO(EvalContSubScoDAO contSubScoDAO) {
		this.contSubScoDAO = contSubScoDAO;
	}

	public EvalContSubScoDAO getContSubScoDAO() {
		return contSubScoDAO;
	}
	
}
