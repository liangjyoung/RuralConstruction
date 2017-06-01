package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalSystInd;
import com.rural.bean.Expert;
import com.rural.bean.ExpertMajorCatg;
import com.rural.dao.EvalSystIndDAO;
import com.rural.dao.ExpertDAO;
import com.rural.dao.ExpertMajorCatgDAO;
import com.rural.tool.Criterion;

public class ExpertMajorCatgService implements IExpertMajorCatgService{

	private ExpertMajorCatgDAO expertMajorCatgdao = new ExpertMajorCatgDAO();

	private ExpertDAO expertdao = new ExpertDAO();
	
	private EvalSystIndDAO evalSystInddao = new EvalSystIndDAO();
	
	public ExpertMajorCatgDAO getExpertMajorCatgdao() {
		return expertMajorCatgdao;
	}

	public void setExpertMajorCatgdao(ExpertMajorCatgDAO expertMajorCatgdao) {
		this.expertMajorCatgdao = expertMajorCatgdao;
	}
	

	public ExpertDAO getExpertdao() {
		return expertdao;
	}

	public void setExpertdao(ExpertDAO expertdao) {
		this.expertdao = expertdao;
	}
	

	public EvalSystIndDAO getEvalSystInddao() {
		return evalSystInddao;
	}

	public void setEvalSystInddao(EvalSystIndDAO evalSystInddao) {
		this.evalSystInddao = evalSystInddao;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<ExpertMajorCatg> list = new ArrayList<ExpertMajorCatg>();
		list = this.expertMajorCatgdao.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(ExpertMajorCatg s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ExpertMajorNum", s.getExpertMajorNum());
			map.put("ExpertMajorCatg", s.getExpertMajorCatg());
			
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
		List<ExpertMajorCatg> list2 = new ArrayList<ExpertMajorCatg>();
		list2 = this.expertMajorCatgdao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (ExpertMajorCatg xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", xt.getExpertMajorCatgId());//��һ��=������id
			if(xt.getExpertMajorNum()==null){
				map.put("ExpertMajorNum", null);
			}else{
				map.put("ExpertMajorNum", xt.getExpertMajorNum());
			}
			if(xt.getExpertMajorCatg()==null){
				map.put("ExpertMajorCatg", null);
			}else{
				map.put("ExpertMajorCatg", xt.getExpertMajorCatg());
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
		int rows = this.expertMajorCatgdao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public void addExpertMajorCatg(String expertMajorNum, String expertMajorCatg) {
		// TODO Auto-generated method stub
		ExpertMajorCatg expertMajorCatg1 = new ExpertMajorCatg();
		expertMajorCatg1.setExpertMajorNum(expertMajorNum);
		expertMajorCatg1.setExpertMajorCatg(expertMajorCatg);
		expertMajorCatgdao.save(expertMajorCatg1);
	}

	public void updateExpertMajorCatg(Integer id, String expertMajorNum, String expertMajorCatg) {
		// TODO Auto-generated method stub
		ExpertMajorCatg expertMajorCatg1 = new ExpertMajorCatg();
		expertMajorCatg1 = expertMajorCatgdao.findById(id);
		ExpertMajorCatg newexpertMajorCatg = expertMajorCatg1;
		//expertMajorCatgdao.delete(expertMajorCatg1);
		newexpertMajorCatg.setExpertMajorNum(expertMajorNum);
		newexpertMajorCatg.setExpertMajorCatg(expertMajorCatg);
		expertMajorCatgdao.attachDirty(expertMajorCatg1);
	}

	public String delExpertMajorCatg(Integer id) {
		// TODO Auto-generated method stub
		
		
//		ExpertMajorCatg expertMajorCatg = new ExpertMajorCatg();
//		expertMajorCatg = expertMajorCatgdao.findById(id);
//		expertMajorCatgdao.delete(expertMajorCatg);
		
		
		String message = "";
		ExpertMajorCatg expertMajorCatg1 = new ExpertMajorCatg();
		expertMajorCatg1 = expertMajorCatgdao.findById(id);
		
		List<Expert> e = expertdao.findByProperty1("expertMajorCatg.expertMajorCatgId", id);
		List<EvalSystInd> ev = evalSystInddao.findByProperty("expertMajorCatg.expertMajorCatgId", id);
		if(e.size()>0){
			message = "专家已引用专业类别编号为"+expertMajorCatg1.getExpertMajorNum()+"的对象，无法删除！\n";
		}else if(ev.size()>0){
			message = "评价体系指标已引用专业类别编号为"+expertMajorCatg1.getExpertMajorNum()+"的对象，无法删除！\n";
			
		}else{
			ExpertMajorCatg expertMajorCatg = new ExpertMajorCatg();
			expertMajorCatg = expertMajorCatgdao.findById(id);
			expertMajorCatgdao.delete(expertMajorCatg);
			message = "专业类别编号为"+expertMajorCatg.getExpertMajorNum()+"的对象，删除成功！\n";
			
		}
		return message;
	}
	
	//检查专业类别编码是否重复
	public boolean checkExpertMajorNum(String expertMajorNum,String id) {
		// TODO Auto-generated method stub
		if(id==null){
			if(expertMajorCatgdao.findByExpertMajorNum(expertMajorNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(expertMajorCatgdao.findById(Integer.parseInt(id)).getExpertMajorNum().equals(expertMajorNum)){
				return false;
			}else{
				if(expertMajorCatgdao.findByExpertMajorNum(expertMajorNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
}
