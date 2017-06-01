package com.rural.evalsystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalCont;
import com.rural.bean.EvalContInvesObj;
import com.rural.bean.EvalSyst;
import com.rural.bean.InvesObj;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.InvesObjDAO;
import com.rural.evalsystem.action.EvalMethObjAction;
import com.rural.tool.Criterion;

public class EvalMethObjService implements IEvalMethObjService{

	private EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
	private InvesObjDAO invesObjDAO = new InvesObjDAO();
	private EvalContDAO evalContDAO = new EvalContDAO();
	
	public EvalContDAO getEvalContDAO() {
		return evalContDAO;
	}

	public void setEvalContDAO(EvalContDAO evalContDAO) {
		this.evalContDAO = evalContDAO;
	}

	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}

	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<InvesObj> list2 = new ArrayList<InvesObj>();
		
		list2 = this.invesObjDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (InvesObj b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
		//	map.put("oldCode", b.getInvesObjId());
			map.put("invesObjID", b.getInvesObjId());
			
			if(b.getInvesObjAttri()== null){
				map.put("invesObjAttriId", null);
			}else{
				map.put("invesObjAttriId", b.getInvesObjAttri().getInvesObjAttriId());
				map.put("invesObjAttri.invesObjAttriName", b.getInvesObjAttri().getInvesObjAttriName());
			}
			
			if(b.getInvesObjName()==null){
				map.put("invesObjName", null);	
			}else{
				map.put("invesObjName", b.getInvesObjName());	
			}
			
			if(b.getInvesObjCode()==null){
				map.put("invesObjCode", null);	
			}else{
				map.put("invesObjCode", b.getInvesObjCode());	
			}
			
			if( b.getInvesPro().getInvesProNum()== null){
				map.put("invesProNum", null);
			}else{
				map.put("invesProNum", b.getInvesPro().getInvesProNum());
			}
		
			if (b.getDataCollDataDic()==null) {
				map.put("dataCollDataDicId", null);	
			} else {
				map.put("dataCollDataDicId", b.getDataCollDataDic().getDataCollDataDicId());	
				map.put("dataCollDataDic.dataDicName", b.getDataCollDataDic().getDataDicName());
			}
			
			
			//map.put("dataCollDataDicId", b.getDataCollDataDic().getDataDicName());		
			
			if( b.getInvesObjComp()==null){
				map.put("invesObjComp",null);
			}else{
				map.put("invesObjComp", b.getInvesObjComp());	
			}
			
			if(b.getInvesObjLengt()==null){
				map.put("invesObjLengt",null);	
			}else{
				map.put("invesObjLengt", b.getInvesObjLengt());	
			}
			
			if(b.getInvesObjNote()==null){
				map.put("invesObjNote", null);	
			}else{
				map.put("invesObjNote", b.getInvesObjNote());	
			}
			
			result.add(map);
		}
		return result;
	
		
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		int rows;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		rows = this.invesObjDAO.getObjCounts(sql, values);
			
		return rows;
	}

	public void setInvesObjDAO(InvesObjDAO invesObjDAO) {
		this.invesObjDAO = invesObjDAO;
	}

	public InvesObjDAO getInvesObjDAO() {
		return invesObjDAO;
	}

	public String addInvesObj(String EvalMethID, String InvesObjid) {
		// TODO Auto-generated method stub
		String message = "";
		List<?> list = this.evalContInvesObjDAO.findCondition(EvalMethID, InvesObjid);
		if (list.size()>0) {
			message = "已分配";
		} else {
			EvalContInvesObj contInvesObj = new EvalContInvesObj();
			
			EvalCont evalCont = new EvalCont();
			evalCont = evalContDAO.findById(Integer.parseInt(EvalMethID));
			contInvesObj.setEvalCont(evalCont);
			
			InvesObj invesObj = new InvesObj();
			invesObj = invesObjDAO.findById(Integer.parseInt(InvesObjid));
			contInvesObj.setInvesObj(invesObj);
			
			evalContInvesObjDAO.save(contInvesObj);
			message = "分配成功";
			
		}
		return message;
	}
	
}
