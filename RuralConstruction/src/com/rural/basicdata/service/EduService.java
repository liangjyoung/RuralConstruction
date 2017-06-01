package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.Edu;
import com.rural.bean.Invgat;
import com.rural.bean.Sex;
import com.rural.dao.EduDAO;
import com.rural.dao.ExpertDAO;
import com.rural.dao.InvgatDAO;
import com.rural.tool.Criterion;

public class EduService implements IEduService{

	private EduDAO edudao = new EduDAO();
	private InvgatDAO invgatdao = new InvgatDAO();
	private ExpertDAO expertdao = new ExpertDAO();
	public EduDAO getEdudao() {
		return edudao;
	}

	public void setEdudao(EduDAO edudao) {
		this.edudao = edudao;
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
		List<Edu> list = new ArrayList<Edu>();
		list = this.edudao.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(Edu s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("eduCode", s.getEduCode());
			map.put("eduName", s.getEduName());
			
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
		List<Edu> list2 = new ArrayList<Edu>();
		list2 = this.edudao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (Edu xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", xt.getEduId());//��һ��=������id
			if(xt.getEduCode()==null){
				map.put("eduCode", null);
			}else{
				map.put("eduCode", xt.getEduCode());
			}
			if( xt.getEduName()==null){
				map.put("eduName", null);
			}else{
				map.put("eduName", xt.getEduName());
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
		int rows = this.edudao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public void addEdu(String eduCode, String eduName) {
		// TODO Auto-generated method stub
		Edu edu = new Edu();
		edu.setEduCode(eduCode);
		edu.setEduName(eduName);
		edudao.save(edu);
	}

	public void updateEdu(Integer id,String eduCode, String eduName) {
		// TODO Auto-generated method stub
		Edu edu = new Edu();
		edu = edudao.findById(id);
		Edu newedu = edu;
		//edudao.delete(edu);
		newedu.setEduId(id);
		newedu.setEduCode(eduCode);
		newedu.setEduName(eduName);
		edudao.attachDirty(newedu);
	}

//	public void delEdu(Integer id) {
//		// TODO Auto-generated method stub
//		Edu edu = new Edu();
//		edu = edudao.findById(id);
//		edudao.delete(edu);
//	}
	public String delEdu(Integer id) {
	// TODO Auto-generated method stub
		String message = "";
		Edu edu1= new Edu();
		edu1 = edudao.findById(id);
		
		List<Invgat> s = invgatdao.findByProperty1("edu.eduId", id);
		List ss = expertdao.findByProperty1("edu.eduId", id);
		if (s.size()>0) {
			message = "调查员已引用学历编号为"+edu1.getEduCode()+"的对象，无法删除！\n";
		} else if(ss.size()>0){
			message = "专家已引用学历编号为"+edu1.getEduCode()+"的对象，无法删除！\n";
		}else{
			Edu edu = new Edu();
			edu = edudao.findById(id);
			edudao.delete(edu);
			message = "学历编号为"+edu.getEduCode()+"的对象，删除成功！\n";
		}
			
		return message;
		
}
	
	
	
	
	//检查学历编码是否重复
	public boolean checkEduCode(String eduCode,String id) {
		// TODO Auto-generated method stub
		if(id==null){
			if(edudao.findByEduCode(eduCode).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(edudao.findById(Integer.parseInt(id)).getEduCode().equals(eduCode)){
				return false;
			}else{
				if(edudao.findByEduCode(eduCode).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
}
