package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.rural.bean.EvalSyst;
import com.rural.bean.EvalSystState;
import com.rural.dao.EvalSystDAO;
import com.rural.dao.EvalSystStateDAO;
import com.rural.tool.Criterion;

public class EvalSystStateService implements IEvalSystStateService{

	private EvalSystStateDAO evalSystStatedao = new EvalSystStateDAO();
	private EvalSystDAO evalSystdao=new EvalSystDAO();
	public EvalSystStateDAO getEvalSystStatedao() {
		return evalSystStatedao;
	}

	public void setEvalSystStatedao(EvalSystStateDAO evalSystStatedao) {
		this.evalSystStatedao = evalSystStatedao;
	}
	

	public EvalSystDAO getEvalSystdao() {
		return evalSystdao;
	}

	public void setEvalSystdao(EvalSystDAO evalSystdao) {
		this.evalSystdao = evalSystdao;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<EvalSystState> list = new ArrayList<EvalSystState>();
		list = this.evalSystStatedao.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(EvalSystState s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("evalSystStateNum", s.getEvalSystStateNum());
			map.put("evalSystStateDes", s.getEvalSystStateDes());
			
			result.add(map);
		}
		
		return result;
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
		List<EvalSystState> list2 = new ArrayList<EvalSystState>();
		list2 = this.evalSystStatedao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (EvalSystState xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", xt.getEvalSystStateId());//��һ��=������id
			if(xt.getEvalSystStateNum()==null){
				map.put("evalSystStateNum",null);
			}else{
				map.put("evalSystStateNum", xt.getEvalSystStateNum());
			}
			if(xt.getEvalSystStateDes()==null){
				map.put("evalSystStateDes", null);
			}else{
				map.put("evalSystStateDes", xt.getEvalSystStateDes());
			}
			
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
		int rows = this.evalSystStatedao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public void addEvalSystState(String evalSystStateNum, String evalSystStateDes) {
		// TODO Auto-generated method stub
		EvalSystState evalSystState = new EvalSystState();
		evalSystState.setEvalSystStateNum(evalSystStateNum);
		evalSystState.setEvalSystStateDes(evalSystStateDes);
		evalSystStatedao.save(evalSystState);
	}

	public void updateEvalSystState(Integer id,String evalSystStateNum, String evalSystStateDes) {
		// TODO Auto-generated method stub
		EvalSystState evalSystState = new EvalSystState();
		evalSystState = evalSystStatedao.findById(id);
		EvalSystState newevalSystState = evalSystState;
		//evalSystStatedao.delete(evalSystState);
		newevalSystState.setEvalSystStateNum(evalSystStateNum);
		newevalSystState.setEvalSystStateDes(evalSystStateDes);
		evalSystStatedao.attachDirty(newevalSystState);
	}

	public String delEvalSystState(Integer id) {
		// TODO Auto-generated method stub
//		EvalSystState evalSystState = new EvalSystState();
//		evalSystState = evalSystStatedao.findById(id);
//		evalSystStatedao.delete(evalSystState);
		String message = "";
		EvalSystState evalSystState1 = new EvalSystState();
		evalSystState1=evalSystStatedao.findById(id);
		
		List<EvalSyst> s = evalSystdao.findByProperty("evalSystState", evalSystState1);
		if (s.size()>0) {
			message = "评价体系已引用体系编号为"+evalSystState1.getEvalSystStateId()+"的对象，无法删除！\n";
		}else{
			EvalSystState evalSystState = new EvalSystState();
			evalSystState = evalSystStatedao.findById(id);
			evalSystStatedao.delete(evalSystState);
			message = "体系编号为"+evalSystState.getEvalSystStateNum()+"的对象，删除成功！\n";
			
		}
		return message;
	}
	
	//检查评价体系状态编码是否重复
	public boolean checkEvalSystStateNum(String evalSystStateNum,String id) {
		if(id==null){
			if(evalSystStatedao.findByEvalSystStateNum(evalSystStateNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(evalSystStatedao.findById(Integer.parseInt(id)).getEvalSystStateNum().equals(evalSystStateNum)){
				return false;
			}else{
				if(evalSystStatedao.findByEvalSystStateNum(evalSystStateNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
}
