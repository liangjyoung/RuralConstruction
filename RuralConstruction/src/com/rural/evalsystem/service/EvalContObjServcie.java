package com.rural.evalsystem.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalCont;
import com.rural.bean.EvalContInvesObj;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.evalsystem.action.EvalContObjAction;
import com.rural.tool.Criterion;

public class EvalContObjServcie implements IEvalContObjService{

	private EvalContDAO evalContDAO = new EvalContDAO();
	private EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
	
	public EvalContDAO getEvalContDAO() {
		return evalContDAO;
	}

	public void setEvalContDAO(EvalContDAO evalContDAO) {
		this.evalContDAO = evalContDAO;
	}

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		sql = " evalCont.evalContId = "+EvalContObjAction.getEvalObjIDs();
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<EvalContInvesObj> list2 = new ArrayList<EvalContInvesObj>();
		list2 = this.evalContInvesObjDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (EvalContInvesObj xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("EvalContInvesObjID", xt.getEvalContInvesObjId());
			if (xt.getInvesObj() == null) {
				map.put("EvalContInvesObjName", null);
				map.put("EvalContInvesObjCode", null);
			} else {
				if(xt.getInvesObj().getInvesObjName() == null){
					map.put("EvalContInvesObjName", null);
				}else {
					map.put("EvalContInvesObjName", xt.getInvesObj().getInvesObjName());
				}
				
				if (xt.getInvesObj().getInvesObjCode() == null) {
					map.put("EvalContInvesObjCode", null);
				} else {
					map.put("EvalContInvesObjCode", xt.getInvesObj().getInvesObjCode());
				}
				
			}
			
			if (xt.getEvalContInvesObjScorValu() == null) {
				map.put("EvalContInvesObjValue", null);
			} else {
				map.put("EvalContInvesObjValue", xt.getEvalContInvesObjScorValu());
			}
				
			if (xt.getIsMus()) {
				map.put("EvalContInvesObjMus", "是");
			} else {
				map.put("EvalContInvesObjMus", "否");
			}
			
			if (xt.getEvalContInvesObjNote() == null) {
				map.put("EvalContInvesObjNote",null);
			} else {
				map.put("EvalContInvesObjNote", xt.getEvalContInvesObjNote());
			}
			result.add(map);
		}
		
		return  result;
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		sql = " evalCont.evalContId = "+EvalContObjAction.getEvalObjIDs();
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.evalContInvesObjDAO.getCounts(sql, values);
		return rows;
	}

	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}

	public String delInvalObj(String EvalObjID) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			int EvalID = Integer.parseInt(EvalObjID);
			EvalContInvesObj evalContInvesObj = new EvalContInvesObj();
			evalContInvesObj = this.evalContInvesObjDAO.findById(EvalID);
			evalContInvesObjDAO.delete(evalContInvesObj);
			message = "删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			message = "未知因素";
			e.printStackTrace();
		}
		
		return message;
	}

	public void editEvalContInvalObj(String EvalContInvesObjID,String EvalContInvesObjValue,
			boolean EvalContInvesObjMus, String EvalContInvesObjNote) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(EvalContInvesObjID.trim());
		EvalContInvesObj evalContInvesObj = new EvalContInvesObj();
		evalContInvesObj = this.evalContInvesObjDAO.findById(a);
		evalContInvesObj.setEvalContInvesObjScorValu(EvalContInvesObjValue);
		evalContInvesObj.setIsMus(EvalContInvesObjMus);
		evalContInvesObj.setEvalContInvesObjNote(EvalContInvesObjNote);
		evalContInvesObjDAO.attachDirty(evalContInvesObj);
		
	}

}
