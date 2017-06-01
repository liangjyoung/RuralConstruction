package com.rural.expertevalmanager.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalExpertDist;
import com.rural.bean.Expert;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalExpertDistDAO;
import com.rural.evalsystem.action.EvalMethObjAction;
import com.rural.expertevalmanager.action.ExpertDistAction;
import com.rural.expertevalmanager.action.ExpertEvalAction;
import com.rural.tool.Criterion;

public class ExpertDistService implements IExpertDistService{

	private EvalExpertDistDAO evalExpertDistDAO = new EvalExpertDistDAO();
	public EvalExpertDistDAO getEvalExpertDistDAO() {
		return evalExpertDistDAO;
	}

	public void setEvalExpertDistDAO(EvalExpertDistDAO evalExpertDistDAO) {
		this.evalExpertDistDAO = evalExpertDistDAO;
	}

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		sql = " vilEvalScoId = "+Integer.parseInt(ExpertDistAction.getJQIDS());
		//sql = " ";
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		
		List<EvalExpertDist> list2 = new ArrayList<EvalExpertDist>();
		list2 = this.evalExpertDistDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (EvalExpertDist b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("EvalExpertDistID", b.getEvalExpertDistId());
			if (b.getExpert() == null) {
				map.put("ExpertName", null);
			} else if (b.getExpert().getExpertName() !=null) {
				map.put("ExpertName", b.getExpert().getExpertName());
			} else{
				map.put("ExpertName", null);
			}
			
			if (b.getIsSub()) {
				map.put("IsSub", "是");
			} else {
				map.put("IsSub", "否");
			}
			
			if (b.getEvalExpertDistNote() == null) {
				map.put("EvalExpertDistNote", null);
			} else {
				map.put("EvalExpertDistNote", b.getEvalExpertDistNote());
			}			
			result.add(map);
		}

		return result;
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		int ID = Integer.parseInt(ExpertDistAction.getJQIDS());
		sql = " vilEvalScoId = "+ID;
		//sql = " ExpertID = 1";
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.evalExpertDistDAO.getCounts(sql, values);
		return rows;
	}



}
