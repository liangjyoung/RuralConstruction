package com.rural.basicdata.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.CitysFil;
import com.rural.bean.CountryFil;
import com.rural.bean.GoveFilClfy;
import com.rural.bean.ProFil;
import com.rural.bean.Sex;
import com.rural.bean.TownFil;
import com.rural.bean.VilFil;
import com.rural.dao.CitysFilDAO;
import com.rural.dao.CountryFilDAO;
import com.rural.dao.GoveFilClfyDAO;
import com.rural.dao.ProFilDAO;
import com.rural.dao.TownFilDAO;
import com.rural.dao.VilFilDAO;
import com.rural.tool.Criterion;

public class GoveFilClfyService implements IGoveFilClfyService{


	private GoveFilClfyDAO goveFilClfydao = new GoveFilClfyDAO();
	private ProFilDAO profilDAO = new ProFilDAO(); 
	private CitysFilDAO citysfilDAO =new CitysFilDAO();
	private CountryFilDAO countryfilDAO = new CountryFilDAO();
	private TownFilDAO townfilDAO = new TownFilDAO();
	private VilFilDAO vilfilDAO = new VilFilDAO();

	

	public GoveFilClfyDAO getGoveFilClfydao() {
		return goveFilClfydao;
	}

	public void setGoveFilClfydao(GoveFilClfyDAO goveFilClfydao) {
		this.goveFilClfydao = goveFilClfydao;
	}
	

	public CountryFilDAO getCountryfilDAO() {
		return countryfilDAO;
	}

	public void setCountryfilDAO(CountryFilDAO countryfilDAO) {
		this.countryfilDAO = countryfilDAO;
	}

	
	public ProFilDAO getProfilDAO() {
		return profilDAO;
	}

	public void setProfilDAO(ProFilDAO profilDAO) {
		this.profilDAO = profilDAO;
	}

	public CitysFilDAO getCitysfilDAO() {
		return citysfilDAO;
	}

	public void setCitysfilDAO(CitysFilDAO citysfilDAO) {
		this.citysfilDAO = citysfilDAO;
	}

	public TownFilDAO getTownfilDAO() {
		return townfilDAO;
	}

	public void setTownfilDAO(TownFilDAO townfilDAO) {
		this.townfilDAO = townfilDAO;
	}

	public VilFilDAO getVilfilDAO() {
		return vilfilDAO;
	}

	public void setVilfilDAO(VilFilDAO vilfilDAO) {
		this.vilfilDAO = vilfilDAO;
	}

	
	
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<GoveFilClfy> list = new ArrayList<GoveFilClfy>();
		list = this.goveFilClfydao.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(GoveFilClfy s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("goveFilClfyNum", s.getGoveFilClfyNum());
			map.put("goveFilClfyName", s.getGoveFilClfyName());
			map.put("goveFilClfyNote", s.getGoveFilClfyNote());
			
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
		List<GoveFilClfy> list2 = new ArrayList<GoveFilClfy>();
		list2 = this.goveFilClfydao.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (GoveFilClfy xt : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", xt.getGoveFilClfyId());//��һ��=������id
			if(xt.getGoveFilClfyNum()==null){
				map.put("goveFilClfyNum", null);
			}else{
				map.put("goveFilClfyNum", xt.getGoveFilClfyNum());
			}
			if(xt.getGoveFilClfyName()==null){
				map.put("goveFilClfyName",null);
			}else{
				map.put("goveFilClfyName", xt.getGoveFilClfyName());
			}
			if(xt.getGoveFilClfyNote()==null){
				map.put("goveFilClfyNote", null);
			}else{
				map.put("goveFilClfyNote", xt.getGoveFilClfyNote());
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
		int rows = this.goveFilClfydao.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
		return rows;
	}

	public void addGoveFilClfy(String goveFilClfyNum, String goveFilClfyName, String goveFilClfyNote) {
		// TODO Auto-generated method stub
		GoveFilClfy goveFilClfy = new GoveFilClfy();
		goveFilClfy.setGoveFilClfyNum(goveFilClfyNum);
		goveFilClfy.setGoveFilClfyName(goveFilClfyName);
		goveFilClfy.setGoveFilClfyNote(goveFilClfyNote);
		goveFilClfydao.save(goveFilClfy);
	}

	//@SuppressWarnings("unchecked")
	public void updateGoveFilClfy(Integer id, String goveFilClfyNum, String goveFilClfyName, String goveFilClfyNote) {
		
		//update table_GoveFilClfy
		GoveFilClfy goveFilClfy = new GoveFilClfy();
		goveFilClfy = goveFilClfydao.findById(id);
		GoveFilClfy newgoveFilClfy = goveFilClfy;
		//goveFilClfydao.delete(goveFilClfy);
		newgoveFilClfy.setGoveFilClfyNum(goveFilClfyNum);
		newgoveFilClfy.setGoveFilClfyName(goveFilClfyName);
		newgoveFilClfy.setGoveFilClfyNote(goveFilClfyNote);
		goveFilClfydao.attachDirty(newgoveFilClfy);
		//update table_Invgat
		
	}

	public String delGoveFilClfy(Integer id) {
		// TODO Auto-generated method stub
//		GoveFilClfy goveFilClfy = new GoveFilClfy();
//		goveFilClfy = goveFilClfydao.findById(id);
//		goveFilClfydao.delete(goveFilClfy);
		
		String message = "";
		GoveFilClfy goveFilClfy1 = new GoveFilClfy();
		goveFilClfy1 = goveFilClfydao.findById(id);
			
		List<ProFil> pro = profilDAO.findByProperty("goveFilClfy", goveFilClfy1);
		List<CitysFil> city = citysfilDAO.findByProperty("goveFilClfy", goveFilClfy1);
		List<CountryFil> s = countryfilDAO.findByProperty("goveFilClfy", goveFilClfy1);
		List<TownFil> town = townfilDAO.findByProperty("goveFilClfy", goveFilClfy1);
		List<VilFil> vil = vilfilDAO.findByProperty("goveFilClfy", goveFilClfy1);
		
		if (pro.size()>0) {
			message = "省文件已引用文件分类编号为"+goveFilClfy1.getGoveFilClfyNum()+"的对象，无法删除！\n";
		
		}else if(city.size()>0){
			message = "市文件已引用性别编号为"+goveFilClfy1.getGoveFilClfyNum()+"的对象，无法删除！\n";
		}
		else if(s.size()>0){
			message = "县文件已引用性别编号为"+goveFilClfy1.getGoveFilClfyNum()+"的对象，无法删除！\n";
		}else if(town.size()>0){
			message = "镇文件已引用性别编号为"+goveFilClfy1.getGoveFilClfyNum()+"的对象，无法删除！\n";
		}else if(vil.size()>0){
			message = "村文件已引用性别编号为"+goveFilClfy1.getGoveFilClfyNum()+"的对象，无法删除！\n";
		}
		else{
			GoveFilClfy goveFilClfy = new GoveFilClfy();
			goveFilClfy = goveFilClfydao.findById(id);
			goveFilClfydao.delete(goveFilClfy);
			message = "文件分类编号为"+goveFilClfy.getGoveFilClfyNum()+"的对象，删除成功！\n";
		}
		return message;
	}
	
	//检查文件分类编码是否重复
	public boolean checkGoveFilClfyNum(String goveFilClfyNum,String id) {
		// TODO Auto-generated method stub
		if(id==null){
			if(goveFilClfydao.findByGoveFilClfyNum(goveFilClfyNum).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(goveFilClfydao.findById(Integer.parseInt(id)).getGoveFilClfyNum().equals(goveFilClfyNum)){
				return false;
			}else{
				if(goveFilClfydao.findByGoveFilClfyNum(goveFilClfyNum).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
}
