package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.Expert;
import com.rural.bean.Invgat;
import com.rural.bean.Sex;
import com.rural.dao.ExpertDAO;
import com.rural.dao.InvgatDAO;
import com.rural.dao.SexDAO;
import com.rural.tool.Criterion;

public class SexService implements ISexService{

	private SexDAO sexdao = new SexDAO();
	private InvgatDAO invgatdao = new InvgatDAO();
	private ExpertDAO expertdao = new ExpertDAO();
	public SexDAO getSexdao() {
		return sexdao;
	}
	public void setSexdao(SexDAO sexdao) {
		this.sexdao = sexdao;
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
	
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<Sex> list2 = new ArrayList<Sex>();
		list2 = this.sexdao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (Sex xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", xt.getSexId());//��һ��=������id
			if(xt.getSexCode()==null){
				map.put("sexCode", null);
			}else{
				map.put("sexCode", xt.getSexCode());
			}
			if( xt.getSexName()==null){
				map.put("sexName", null);
			}else{
				map.put("sexName", xt.getSexName());
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
		int rows = this.sexdao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public void addsex(String sexCode, String sexName) {
		// TODO Auto-generated method stub
		Sex sex = new Sex();
		sex.setSexCode(sexCode);
		sex.setSexName(sexName);
		sexdao.save(sex);
	}

	
	public void updateSex(Integer id, String sexCode, String sexName) {
		
		
		
		
		// TODO Auto-generated method stub
		//get all Invgat's records and insert them into a list according to the sexID
		//List<Invgat> invgats = invgatdao.findByProperty("sex.sexCode", id);
		//List<Expert> experts = expertdao.findByProperty("sex.sexCode", id);
//		for(Invgat invgat: invgats){
//			invgat.setSex(null);//set NULL to all invgats' sex found before
//		}
//		for(Expert expert: experts){
//			expert.setSex(null);//set NULL to all experts' sex found before
//		}
		//update table_Sex
		Sex sex = new Sex();
		sex = sexdao.findById(id);
		Sex newsex = sex;
		//sexdao.delete(sex);
		newsex.setSexId(id);
		newsex.setSexCode(sexCode);
		newsex.setSexName(sexName);
		sexdao.attachDirty(newsex);
		
		
	}

//	public void delSex(Integer id) {
//		// TODO Auto-generated method stub
//		Sex sex = new Sex();
//		sex = sexdao.findById(id);
//		sexdao.delete(sex);
//	}
	
	public String delSex(Integer id) {
		// TODO Auto-generated method stub
		String message = "";
		//Invgat ingvat = new Invgat();
		Sex sex1= new Sex();
		 //sex1 = sexdao.findById(Integer.parseInt(id));
		 sex1 = sexdao.findById(id);
		 
		
		//int num = invgatdao.findById(id);
		List<Invgat> s = invgatdao.findByProperty1("sex.sexId", id);
		List ss = expertdao.findByProperty1("sex.sexId", id);
		if (s.size()>0) {
			message = "调查员已引用性别编号为"+sex1.getSexCode()+"的对象，无法删除！\n";
		} else if(ss.size()>0){
			message = "专家已引用性别编号为"+sex1.getSexCode()+"的对象，无法删除！\n";
		}else{
			Sex sex = new Sex();
			//sex = sexdao.findById(Integer.parseInt(id));
			sex = sexdao.findById(id);
			
			sexdao.delete(sex);
			message = "性别编号为"+sex.getSexCode()+"的对象，删除成功！\n";
		}
			
		return message;
		
		
		
	}

	//检查性别编码是否重复
	public boolean checkSexCode(String sexCode,String id) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(id==null){
			if(sexdao.findBySexCode(sexCode).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(sexdao.findById(Integer.parseInt(id)).getSexCode().equals(sexCode)){
				return false;
			}else{
				if(sexdao.findBySexCode(sexCode).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
	public Sex getSexById(Integer sexid){
		return sexdao.findById(sexid);
	}
}
