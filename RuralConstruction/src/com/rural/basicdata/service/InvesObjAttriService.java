package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.InvesObj;
import com.rural.bean.InvesObjAttri;
import com.rural.dao.InvesObjAttriDAO;
import com.rural.dao.InvesObjDAO;
import com.rural.tool.Criterion;

public class InvesObjAttriService implements IInvesObjAttriService{

	private InvesObjAttriDAO invesObjAttridao= new InvesObjAttriDAO() ;
	private InvesObjDAO invesObjdao= new InvesObjDAO();
	
	

	public InvesObjAttriDAO getInvesObjAttridao() {
		return invesObjAttridao;
	}


	public void setInvesObjAttridao(InvesObjAttriDAO invesObjAttridao) {
		this.invesObjAttridao = invesObjAttridao;
	}


	public InvesObjDAO getInvesObjdao() {
		return invesObjdao;
	}


	public void setInvesObjdao(InvesObjDAO invesObjdao) {
		this.invesObjdao = invesObjdao;
	}


	public void addInvesObjAttri(String invesObjAttriNum,
			String invesObjAttriName) {
		// TODO Auto-generated method stub
		InvesObjAttri invesObjAttri = new InvesObjAttri();
		invesObjAttri.setInvesObjAttriNum(invesObjAttriNum);
		invesObjAttri.setInvesObjAttriName(invesObjAttriName);
		invesObjAttridao.save(invesObjAttri);
		
	}

	
	public String delInvesObjAttri(Integer id) {
		// TODO Auto-generated method stub
		/*InvesObjAttri invesObjAttri = new InvesObjAttri();
		invesObjAttri= invesObjAttridao.findById(id);
		invesObjAttridao.delete(invesObjAttri);*/
		String message = "";
		InvesObjAttri invesObjAttri1 = new InvesObjAttri();
		invesObjAttri1 = invesObjAttridao.findById(id);
		
		List<InvesObj> i = invesObjdao.findByProperty("invesObjAttri", invesObjAttri1);
		if (i.size()>0) {
			message = " 调查对象已引用属性编号为"+invesObjAttri1.getInvesObjAttriNum()+"的对象，无法删除！\n";
		}else{
			InvesObjAttri invesObjAttri = new InvesObjAttri();
			invesObjAttri = invesObjAttridao.findById(id);
			invesObjAttridao.delete(invesObjAttri);
			message = "属性编号为"+invesObjAttri.getInvesObjAttriNum()+"的对象，删除成功！\n";
			
		}
		return message;
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
		List<InvesObjAttri> list2 = new ArrayList<InvesObjAttri>();
		list2 = this.invesObjAttridao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (InvesObjAttri xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", xt.getInvesObjAttriId());//��һ��=������id
			if( xt.getInvesObjAttriNum()==null){
				map.put("invesObjAttriNum",null);
			}else{
				map.put("invesObjAttriNum", xt.getInvesObjAttriNum());
			}
			if( xt.getInvesObjAttriName()==null){
				map.put("invesObjAttriName",null);
			}else{
				map.put("invesObjAttriName", xt.getInvesObjAttriName());
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
		int rows = this.invesObjAttridao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public void updateInvesObjAttri(Integer id,
			String invesObjAttriNum, String invesObjAttriName) {
		// TODO Auto-generated method stub
		InvesObjAttri invesObjAttri = new InvesObjAttri();
		invesObjAttri = invesObjAttridao.findById(id);
		InvesObjAttri newinvesObjAttri = invesObjAttri;
		//invesObjAttridao.delete(invesObjAttri);
		newinvesObjAttri.setInvesObjAttriNum(invesObjAttriNum);
		newinvesObjAttri.setInvesObjAttriName(invesObjAttriName);
		invesObjAttridao.attachDirty(newinvesObjAttri);
	}


	
	
	public boolean checkInvesObjAttriNum(String invesObjAttriNum,String id) {
		// TODO Auto-generated method stub
		if(id==null){
			if(invesObjAttridao.findByInvesObjAttriNum(invesObjAttriNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(invesObjAttridao.findById(Integer.parseInt(id)).getInvesObjAttriNum().equals(invesObjAttriNum)){
				return false;
			}else{
				if(invesObjAttridao.findByInvesObjAttriNum(invesObjAttriNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}

}
