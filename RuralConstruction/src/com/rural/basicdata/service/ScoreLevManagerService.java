package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.ScoLev;
import com.rural.dao.ScoLevDAO;
import com.rural.tool.Criterion;

public class ScoreLevManagerService implements IScoreLevManagerService{

	private ScoLevDAO scoDAO = new ScoLevDAO();
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<ScoLev> list2 = new ArrayList<ScoLev>();
		list2 = this.scoDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (ScoLev xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("scoLevId", xt.getScoLevId());
			map.put("scoLevCode", xt.getScoLevCode());
			
			map.put("scoUp", xt.getScoUp());
			map.put("scoDown", xt.getScoDown());
			result.add(map);
		}
		
		return  result;
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.scoDAO.getCounts(sql, values);
		return rows;
	}

	public void setScoDAO(ScoLevDAO scoDAO) {
		this.scoDAO = scoDAO;
	}

	public ScoLevDAO getScoDAO() {
		return scoDAO;
	}

}
