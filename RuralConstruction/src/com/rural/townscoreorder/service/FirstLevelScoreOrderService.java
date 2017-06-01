package com.rural.townscoreorder.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rural.bean.EvalSystInd;
import com.rural.bean.LevelsIndSco;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalSystIndDAO;
import com.rural.dao.LevelsIndScoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;

public class FirstLevelScoreOrderService implements	IFirstLevelScoreOrderService {

	private EvalSystIndDAO evalSystIndDAO = new EvalSystIndDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	private LevelsIndScoDAO levelsIndScoDAO = new LevelsIndScoDAO();
	
	public List<EvalSystInd> getFirstLevelInds() {
		// TODO Auto-generated method stub
		String sql = "UpEvalIndNum is NULL";
		return evalSystIndDAO.findBySql(sql);
	}
	public Integer getTownIdByTownNum(String diviCode) {
		// TODO Auto-generated method stub
		return ((TownBasicInfo)townBasicInfoDAO.findByTownNum("'"+diviCode+"'").get(0)).getTownBasicInfoId();
	}
	@SuppressWarnings("unchecked")
	public List<VilBasicInfo> getVilsByTownId(Integer townBasicInfoId) {
		// TODO Auto-generated method stub
		return vilBasicInfoDAO.findByProperty("townBasicInfo.townBasicInfoId", townBasicInfoId);
	}
	
	@SuppressWarnings("unchecked")
	public List<LevelsIndSco> getFirstLevelScoresInOrder(List<VilBasicInfo> vils, Integer year, String indNum) {
		//获取该镇相应年份的采集记录ID
		String sql = "SELECT * FROM VilDataCollRec WHERE VilBasicInfoID IN (";
		for(VilBasicInfo vilBasicInfo : vils){
			sql += vilBasicInfo.getVilBasicInfoId()+",";
		}
		sql += "'') AND YEAR(CollTim) = " + year;
		List<Integer> vilDataCollRecs = new ArrayList<Integer>();
		try {
			vilDataCollRecs = vilDataCollRecDAO.findCollRecs(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//根据采集记录ID获得村庄评价得分ID
		String sql_1 = "VilDataCollRecID IN (";
		for(Integer id: vilDataCollRecs){
			sql_1 += id+",";
		}
		sql_1 += "'')";
		List<VilEvalSco> vilEvalScos = new ArrayList<VilEvalSco>();
		vilEvalScos = vilEvalScoDAO.findBySql(sql_1);
		//根据村庄评价得分ID和评价指标编号（一级指标）获取一级指标得分
		List<LevelsIndSco> firstLevelScos = new ArrayList<LevelsIndSco>();
		String sql_2 = "VilEvalScoID IN (";
		for(VilEvalSco vilEvalSco : vilEvalScos){
			sql_2 += vilEvalSco.getVilEvalScoId() + ",";
		}
		sql_2 += "'') AND EvalIndNum = '" + indNum + "' ORDER BY model.levelsIndSco DESC";
		firstLevelScos = levelsIndScoDAO.findBySql(sql_2);
		return firstLevelScos;
	}
	
	public EvalSystIndDAO getEvalSystIndDAO() {
		return evalSystIndDAO;
	}
	public void setEvalSystIndDAO(EvalSystIndDAO evalSystIndDAO) {
		this.evalSystIndDAO = evalSystIndDAO;
	}
	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}
	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
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
	public LevelsIndScoDAO getLevelsIndScoDAO() {
		return levelsIndScoDAO;
	}
	public void setLevelsIndScoDAO(LevelsIndScoDAO levelsIndScoDAO) {
		this.levelsIndScoDAO = levelsIndScoDAO;
	}
	
	

}
