package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.Invgat;
import com.rural.bean.Pol;
import com.rural.bean.Sex;
import com.rural.dao.ExpertDAO;
import com.rural.dao.InvgatDAO;
import com.rural.dao.PolDAO;
import com.rural.tool.Criterion;

public class PolService implements IPolService{

	private PolDAO poldao = new PolDAO();
	private InvgatDAO invgatdao = new InvgatDAO();
	private ExpertDAO expertdao = new ExpertDAO();
	
	public PolDAO getPoldao() {
		return poldao;
	}

	public void setPoldao(PolDAO poldao) {
		this.poldao = poldao;
	}

	
	public InvgatDAO getInvgatdao() {
		return invgatdao;
	}

	public void setInvgatdao(InvgatDAO invgatdao) {
		this.invgatdao = invgatdao;
	}

	public ExpertDAO getExpertdao() {
		return expertdao;
	}

	public void setExpertdao(ExpertDAO expertdao) {
		this.expertdao = expertdao;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<Pol> list = new ArrayList<Pol>();
		list = this.poldao.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(Pol s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("polCode", s.getPolCode());
			map.put("polName", s.getPolName());
			
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
		List<Pol> list2 = new ArrayList<Pol>();
		list2 = this.poldao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (Pol xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", xt.getPolId());//��һ��=������id
			if(xt.getPolCode()==null){
				map.put("polCode", null);
			}else{
				map.put("polCode", xt.getPolCode());
			}
			if(xt.getPolName()==null){
				map.put("polName", null);
			}else{
				map.put("polName", xt.getPolName());
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
		int rows = this.poldao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public void addPol(String polCode, String polName) {
		// TODO Auto-generated method stub
		Pol pol = new Pol();
		pol.setPolCode(polCode);
		pol.setPolName(polName);
		poldao.save(pol);
	}

	public void updatePol(Integer id, String polCode, String polName) {
		// TODO Auto-generated method stub
		Pol pol = new Pol();
		pol = poldao.findById(id);
		Pol newpol = pol;
		//poldao.delete(pol);
		newpol.setPolCode(polCode);
		newpol.setPolName(polName);
		poldao.attachDirty(newpol);
	}

	public String delPol(Integer id) {
		// TODO Auto-generated method stub
		String message = "";
		//Invgat ingvat = new Invgat();
		Pol pol1 = new Pol();
		pol1= poldao.findById(id);
		
		List<Invgat> s = invgatdao.findByProperty1("pol.polId", id);
		List ss = expertdao.findByProperty1("pol.polId", id);
		if (s.size()>0) {
			message = "调查员已引用政治面貌编号为"+pol1.getPolCode()+"的对象，无法删除！\n";
		} else if(ss.size()>0){
			message = "专家已引用政治面貌编号为"+pol1.getPolCode()+"的对象，无法删除！\n";
		}else{
			Pol pol = new Pol();
			pol = poldao.findById(id);
			poldao.delete(pol);
			message = "政治面貌编号为"+pol.getPolCode()+"的对象，删除成功！\n";
		}
			
		return message;
	}
	
	//检查代码 是否重复
	public boolean checkPolCode(String polCode,String id) {
		// TODO Auto-generated method stub
		
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(id==null){
			if(poldao.findByPolCode(polCode).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(poldao.findById(Integer.parseInt(id)).getPolCode().equals(polCode)){
				return false;
			}else{
				if(poldao.findByPolCode(polCode).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
}
