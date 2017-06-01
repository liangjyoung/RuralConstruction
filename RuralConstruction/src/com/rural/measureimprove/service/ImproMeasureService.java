package com.rural.measureimprove.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalContSubSco;
import com.rural.bean.PrmtMeas;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.PrmtMeasDAO;
import com.rural.measureimprove.action.ImproMeasureAction;
import com.rural.tool.Criterion;

public class ImproMeasureService implements IImproMeasureService{
	private PrmtMeasDAO prmtMeasDAO = new PrmtMeasDAO();
	private EvalContSubScoDAO evalContSubScoDAO = new EvalContSubScoDAO();
	
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		sql = "evalContSubSco.evalScoId = "+Integer.parseInt(ImproMeasureAction.getEvalScoIDs());
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<PrmtMeas> list2 = new ArrayList<PrmtMeas>();
		list2 = this.prmtMeasDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (PrmtMeas b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
		//	map.put("oldCode", b.getInvesObjId());
			map.put("PrmtMeasID", b.getPrmtMeasId());
			map.put("PrmtMeas", b.getPrmtMeas());
			map.put("PrmtMeasComp", b.getPrmtMeasComp());
			map.put("PrmtMeasValue", b.getPrmtMeasValue());
			
			map.put("ExpectPrmtSco", b.getExpectPrmtSco());
			map.put("PrmtMeasNote", b.getPrmtMeasNote());
			
			result.add(map);
		}
		return result;
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		sql = "evalContSubSco.evalScoId = "+Integer.parseInt(ImproMeasureAction.getEvalScoIDs());
		int rows ;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		rows = this.prmtMeasDAO.getCounts(sql, values);
		return rows;
	}

	public void setPrmtMeasDAO(PrmtMeasDAO prmtMeasDAO) {
		this.prmtMeasDAO = prmtMeasDAO;
	}

	public PrmtMeasDAO getPrmtMeasDAO() {
		return prmtMeasDAO;
	}

	public String addImproMeas(String PrmtMeasID, String PrmtMeas,
			String PrmtMeasComp, String PrmtMeasValue, String ExpectPrmtSco,
			String PrmtMeasNote) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			PrmtMeas prmtMeas = new PrmtMeas();
			EvalContSubSco evalContSubSco = new EvalContSubSco();
			int evalid = Integer.parseInt(ImproMeasureAction.getEvalScoIDs());
			evalContSubSco = evalContSubScoDAO.findById(evalid);
			prmtMeas.setEvalContSubSco(evalContSubSco);
			prmtMeas.setExpectPrmtSco(ExpectPrmtSco);
			prmtMeas.setPrmtMeas(PrmtMeas);
			prmtMeas.setPrmtMeasComp(PrmtMeasComp);
			prmtMeas.setPrmtMeasNote(PrmtMeasNote);
			prmtMeas.setPrmtMeasValue(PrmtMeasValue);
			prmtMeasDAO.save(prmtMeas);
			message = "success";
		} catch (Exception e) {
			// TODO: handle exception
			message="添加失败";
			e.printStackTrace();
		}
		return message;
	}

	public void setEvalContSubScoDAO(EvalContSubScoDAO evalContSubScoDAO) {
		this.evalContSubScoDAO = evalContSubScoDAO;
	}

	public EvalContSubScoDAO getEvalContSubScoDAO() {
		return evalContSubScoDAO;
	}

	public String editImproMeas(String PrmtMeasID, String PrmtMeas,
			String PrmtMeasComp, String PrmtMeasValue, String ExpectPrmtSco,
			String PrmtMeasNote) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			PrmtMeas prmtMeas = new PrmtMeas();
			int prmtID = Integer.parseInt(PrmtMeasID);
			prmtMeas = prmtMeasDAO.findById(prmtID);
			EvalContSubSco evalContSubSco = new EvalContSubSco();
			int evalid = Integer.parseInt(ImproMeasureAction.getEvalScoIDs());
			evalContSubSco = evalContSubScoDAO.findById(evalid);
			prmtMeas.setEvalContSubSco(evalContSubSco);
			prmtMeas.setExpectPrmtSco(ExpectPrmtSco);
			prmtMeas.setPrmtMeas(PrmtMeas);
			prmtMeas.setPrmtMeasComp(PrmtMeasComp);
			prmtMeas.setPrmtMeasNote(PrmtMeasNote);
			prmtMeas.setPrmtMeasValue(PrmtMeasValue);
			prmtMeasDAO.merge(prmtMeas);
			message = "successful";
		} catch (Exception e) {
			// TODO: handle exception
			message="修改失败";
			e.printStackTrace();
		}
		return message;
	}

	public String delImproMeas(String PrmtMeasID) {
		// TODO Auto-generated method stub
		String message = "";
			try {
				int prmtID = Integer.parseInt(PrmtMeasID);
				PrmtMeas prmtMeas = new PrmtMeas();
				prmtMeas = prmtMeasDAO.findById(prmtID);
				prmtMeasDAO.delete(prmtMeas);
				message = "删除成功";
			} catch (Exception e) {
				message="删除失败";
				e.printStackTrace();
			}
		return message;
	}

}
