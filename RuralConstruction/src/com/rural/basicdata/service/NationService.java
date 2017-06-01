package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.Invgat;
import com.rural.bean.Nation;
import com.rural.bean.Sex;
import com.rural.dao.ExpertDAO;
import com.rural.dao.InvgatDAO;
import com.rural.dao.NationDAO;
import com.rural.tool.Criterion;

public class NationService implements INationService{

	private NationDAO nationdao;
	private InvgatDAO invgatdao = new InvgatDAO();
	private ExpertDAO expertdao = new ExpertDAO();
	
	public NationDAO getNationdao() {
		return nationdao;
	}

	public void setNationdao(NationDAO nationdao) {
		this.nationdao = nationdao;
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

	public void addNation(String nationCode, String nationName) {
		// TODO Auto-generated method stub
		Nation nation = new Nation();
		nation.setNationCode(nationCode);
		nation.setNationName(nationName);
		nationdao.save(nation);
	}

	public String delNation(Integer id) {
		// TODO Auto-generated method stub
		/*Nation nation = new Nation();
		nation = nationdao.findById(id);
		nationdao.delete(nation);*/
		String message = "";
		Nation nation1 = new Nation();
		nation1 = nationdao.findById(id);
		
		List<Invgat> s = invgatdao.findByProperty1("nation.nationId", id);
		List ss = expertdao.findByProperty1("nation.nationId", id);
		if (s.size()>0) {
			message = "调查员已引用民族编号为"+nation1.getNationCode()+"的对象，无法删除！\n";
		} else if(ss.size()>0){
			message = "专家已引用民族编号为"+nation1.getNationCode()+"的对象，无法删除！\n";
		}else{
			Nation nation = new Nation();
			nation = nationdao.findById(id);
			nationdao.delete(nation);
			message = "民族编号为"+nation.getNationCode()+"的对象，删除成功！\n";
		}
			
		return message;
		
	}

	public void updateNation(Integer id,String nationCode, String nationName) {
		// TODO Auto-generated method stub
		Nation nation = new Nation();
		nation = nationdao.findById(id);
		Nation newnation = nation;
		//nationdao.delete(nation);
		newnation.setNationCode(nationCode);
		newnation.setNationName(nationName);
		nationdao.attachDirty(newnation);
	}

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<Nation> list2 = new ArrayList<Nation>();
		list2 = this.nationdao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (Nation xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", xt.getNationId());//��һ��=������id
			if(xt.getNationCode()==null){
				map.put("nationCode", null);
			}else{
				map.put("nationCode", xt.getNationCode());
			}
			if(xt.getNationName()==null){
				map.put("nationName", null);
			}else{
				map.put("nationName", xt.getNationName());
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
		int rows = this.nationdao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}
	
	
	
	//检查民族编码是否重复
	public boolean checkNationCode(String nationCode,String id) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(id==null){
			if(nationdao.findByNationCode(nationCode).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(nationdao.findById(Integer.parseInt(id)).getNationCode().equals(nationCode)){
				return false;
			}else{
				if(nationdao.findByNationCode(nationCode).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
	public Nation getNationById(Integer nationid){
		return nationdao.findById(nationid);
	}
}
