package com.rural.townscoreorder.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilEvalSco;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;

public class TotalScoreOrderService implements ITotalScoreOrderService {
	
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	
	public Integer getTownIdByTownNum(String diviCode) {
		// TODO Auto-generated method stub
		return ((TownBasicInfo)townBasicInfoDAO.findByTownNum("'"+diviCode+"'").get(0)).getTownBasicInfoId();
	}
	@SuppressWarnings("unchecked")
	public List<VilBasicInfo> getVilsByTownId(Integer townBasicInfoId) {
		// TODO Auto-generated method stub
		return vilBasicInfoDAO.findByProperty("townBasicInfo.townBasicInfoId", townBasicInfoId);
	}
	
	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}
	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}
	public List<Integer> getYears(List<VilBasicInfo> vils) {
		// TODO Auto-generated method stub
		List<Integer> years = new ArrayList<Integer>();
		String sql = "SELECT DISTINCT YEAR(CollTim) AS Year FROM VilDataCollRec WHERE VilBasicInfoID IN (";
		for(VilBasicInfo vilBasicInfo : vils){
			sql += vilBasicInfo.getVilBasicInfoId()+",";
		}
		sql += "'') ORDER BY Year DESC";
		try {
			years = vilDataCollRecDAO.findYears(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return years;
	}
	
	@SuppressWarnings("unchecked")
	public List<VilEvalSco> getScoresInOrder(List<VilBasicInfo> vils, Integer yr){
		// TODO Auto-generated method stub
		List<VilEvalSco> vilEvalScos = new ArrayList<VilEvalSco>();
		String sql = "SELECT * FROM VilDataCollRec WHERE VilBasicInfoID IN (";
		for(VilBasicInfo vilBasicInfo : vils){
			sql += vilBasicInfo.getVilBasicInfoId()+",";
		}
		sql += "'') AND YEAR(CollTim) = " + yr;
		List<Integer> vilDataCollRecs = new ArrayList<Integer>();
		try {
			vilDataCollRecs = vilDataCollRecDAO.findCollRecs(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql_1 = "VilDataCollRecID IN (";
		for(Integer id: vilDataCollRecs){
			sql_1 += id+",";
		}
		sql_1 += "'') ORDER BY VilEvalTotGra DESC";
		vilEvalScos = vilEvalScoDAO.findBySql(sql_1);
		return vilEvalScos;
	}
	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}
	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}
	public VilDataCollRecDAO getVilDataCollRecDAO() {
		return vilDataCollRecDAO;
	}
	public void setVilDataCollRecDAO(VilDataCollRecDAO vilDataCollRecDAO) {
		this.vilDataCollRecDAO = vilDataCollRecDAO;
	}
	public VilEvalScoDAO getVilEvalScoDAO() {
		return vilEvalScoDAO;
	}
	public void setVilEvalScoDAO(VilEvalScoDAO vilEvalScoDAO) {
		this.vilEvalScoDAO = vilEvalScoDAO;
	}
	

}
