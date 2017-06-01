package com.rural.ctvrank.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.EvalSystInd;
import com.rural.bean.LevelsIndSco;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilEvalSco;
import com.rural.ctvrank.action.CTVRankAction;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.EvalSystIndDAO;
import com.rural.dao.LevelsIndScoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;

public class CTVRankService implements ICTVRankService {
	private CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	private EvalSystIndDAO evalSystIndDAO = new EvalSystIndDAO();
	private LevelsIndScoDAO levelsIndScoDAO = new LevelsIndScoDAO();
	
	@SuppressWarnings("unchecked")
	public List<CityBasicInfo> getCityByCityNum(String diviCode){
//		return ((CityBasicInfo)cityBasicInfoDAO.findByCityNum("'"+diviCode+"'").get(0)).getCityBasicInfoId();
		return cityBasicInfoDAO.findByCityNum("'"+diviCode+"'");
	}
	@SuppressWarnings("unchecked")
	public List<CountryBasicInfo> getCountryByCountryNum(String diviCode){
//		return ((CountryBasicInfo)countryBasicInfoDAO.findByCountryNum("'"+diviCode+"'").get(0)).getCountryBasicInfoId();
		return countryBasicInfoDAO.findByCountryNum("'"+diviCode+"'");
	}
	@SuppressWarnings("unchecked")
	public List<TownBasicInfo> getTownByTownNum(String diviCode) {
//		return ((TownBasicInfo)townBasicInfoDAO.findByTownNum("'"+diviCode+"'").get(0)).getTownBasicInfoId();
		return townBasicInfoDAO.findByTownNum("'"+diviCode+"'");
	}
	
	public List<CountryBasicInfo> getCountrysByCitys(List<CityBasicInfo> cityBasicInfos){
		List<CountryBasicInfo> countryBasicInfos = new ArrayList<CountryBasicInfo>();
		String sql = "CityBasicInfoID IN (";
		for(CityBasicInfo cityBasicInfo : cityBasicInfos){
			sql += cityBasicInfo.getCityBasicInfoId() + ",";
		}
		sql += "-1)";
		countryBasicInfos = countryBasicInfoDAO.findBySql(sql);
		return countryBasicInfos;
	}
	public List<TownBasicInfo> getTownsByCountrys(List<CountryBasicInfo> countryBasicInfos){
		List<TownBasicInfo> townBasicInfos = new ArrayList<TownBasicInfo>();
		String sql = "CountryBasicInfoID IN (";
		for(CountryBasicInfo countryBasicInfo : countryBasicInfos){
			sql += countryBasicInfo.getCountryBasicInfoId() + ",";
		}
		sql += "-1)";
		townBasicInfos = townBasicInfoDAO.findBySql(sql);
		return townBasicInfos;
	}
	public List<VilBasicInfo> getVilsByTowns(List<TownBasicInfo> townBasicInfos){
		List<VilBasicInfo> vilBasicInfos = new ArrayList<VilBasicInfo>();
		String sql = "TownBasicInfoID IN (";
		for(TownBasicInfo townBasicInfo : townBasicInfos){
			sql += townBasicInfo.getTownBasicInfoId() + ",";
		}
		sql += "-1)";
		vilBasicInfos = vilBasicInfoDAO.findBySql(sql);
		return vilBasicInfos;
	}
	public List<Integer> getYears(Integer roleId, String diviCode) {
		List<Integer> years = new ArrayList<Integer>();
		if(roleId == 1){
			List<CityBasicInfo> cityBasicInfos = getCityByCityNum("3712.00.00.000");
			List<CountryBasicInfo> countryBasicInfos = getCountrysByCitys(cityBasicInfos);
			List<TownBasicInfo> townBasicInfos = getTownsByCountrys(countryBasicInfos);
			List<VilBasicInfo> vilBasicInfos = getVilsByTowns(townBasicInfos);
			years = getYearsOfCollRecs(vilBasicInfos);
		}else if(roleId == 2 || roleId == 3){//地市级用户
			List<CityBasicInfo> cityBasicInfos = getCityByCityNum(diviCode);
			List<CountryBasicInfo> countryBasicInfos = getCountrysByCitys(cityBasicInfos);
			List<TownBasicInfo> townBasicInfos = getTownsByCountrys(countryBasicInfos);
			List<VilBasicInfo> vilBasicInfos = getVilsByTowns(townBasicInfos);
			years = getYearsOfCollRecs(vilBasicInfos);
		}else if(roleId == 4){//县级用户
			List<CountryBasicInfo> countryBasicInfos = getCountryByCountryNum(diviCode);
			List<TownBasicInfo> townBasicInfos = getTownsByCountrys(countryBasicInfos);
			List<VilBasicInfo> vilBasicInfos = getVilsByTowns(townBasicInfos);
			years = getYearsOfCollRecs(vilBasicInfos);
		}else if(roleId == 5){//镇级用户
			List<TownBasicInfo> townBasicInfos = getTownByTownNum(diviCode);
			List<VilBasicInfo> vilBasicInfos = getVilsByTowns(townBasicInfos);
			years = getYearsOfCollRecs(vilBasicInfos);
		}
		return years;
	}
	private List<Integer> getYearsOfCollRecs(List<VilBasicInfo> vilBasicInfos) {
		// TODO Auto-generated method stub
		List<Integer> years = new ArrayList<Integer>();
		String sql = "SELECT DISTINCT YEAR(CollTim) AS Year FROM VilDataCollRec WHERE VilBasicInfoID IN (";
		for(VilBasicInfo vilBasicInfo : vilBasicInfos){
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

	/**
	 * 根据区划编码区分市、县、镇、村
	 * 返回1：市
	 * 返回2：县
	 * 返回3：镇
	 * 返回4：村
	 */
	public Integer DistinguishDivi(String treeDiviCode) {
		int zeroNum=0;
		String code="";
		code = treeDiviCode.replace(".", "");
		for(int i = code.length(); i > 0; i--){
			if(code.charAt(i-1)!='0')
				break;
			zeroNum++;
		}
		if(zeroNum < 3)//村级
		{
			return 4;
		}else if(zeroNum < 5){//镇级
			return 3;
		}else if(zeroNum < 7){//县级
			return 2;
		}else if(zeroNum < 10){//市级
			return 1;
		}
		return 0;
	}
	
	
	public List<Entry<String, Double>> getScoreInDesc(Integer divi, String treeDiviCode,Integer year) {
		Map<String, Integer> totalSco = new HashMap<String, Integer>();
		Map<String, Integer> vilAmount = new HashMap<String, Integer>();
		Map<String, Double> avgScoInDesc = new HashMap<String, Double>();
		if(divi == 1){//市级对县进行排序
			CTVRankAction.setGraphName(CTVRankAction.getGraphName()+"各县（区）");
			List<CityBasicInfo> cityBasicInfos = getCityByCityNum(treeDiviCode);
			List<CountryBasicInfo> countryBasicInfos = getCountrysByCitys(cityBasicInfos);
			List<TownBasicInfo> townBasicInfos = getTownsByCountrys(countryBasicInfos);
			List<VilBasicInfo> vils = getVilsByTowns(townBasicInfos);
			List<VilEvalSco> vilEvalScos = getScoresInOrder(vils, year);
			for(VilEvalSco vilEvalSco : vilEvalScos){
				String country = vilEvalSco.getVilDataCollRec().getVilBasicInfo().getTownBasicInfo().getCountryBasicInfo().getCountryName();
				Integer score = (vilEvalSco.getVilEvalTotGra() != null && !vilEvalSco.getVilEvalTotGra().equals("")) ? Integer.parseInt(vilEvalSco.getVilEvalTotGra()) : 0;
				if(!totalSco.containsKey(country)){//Map中还没有添加该县
					totalSco.put(country, score);
					vilAmount.put(country, 1);
				}else{//Map中已经添加该县的分数，对新添加的分数进行累加
					Integer tmp = totalSco.get(country) + score;
					Integer amount = vilAmount.get(country) + 1;
					totalSco.put(country, tmp);
					vilAmount.put(country, amount);
				}
			}
			
		}else if(divi == 2){//县级对镇排序
			CTVRankAction.setGraphName(CTVRankAction.getGraphName()+"各乡（镇）");
			List<CountryBasicInfo> countryBasicInfos = getCountryByCountryNum(treeDiviCode);
			List<TownBasicInfo> townBasicInfos = getTownsByCountrys(countryBasicInfos);
			List<VilBasicInfo> vils = getVilsByTowns(townBasicInfos);
			List<VilEvalSco> vilEvalScos = getScoresInOrder(vils, year);
			for(VilEvalSco vilEvalSco : vilEvalScos){
				String town = vilEvalSco.getVilDataCollRec().getVilBasicInfo().getTownBasicInfo().getTownName();
				Integer score = (vilEvalSco.getVilEvalTotGra() != null && !vilEvalSco.getVilEvalTotGra().equals("")) ? Integer.parseInt(vilEvalSco.getVilEvalTotGra()) : 0;
				if(!totalSco.containsKey(town)){//Map中还没有添加该镇
					totalSco.put(town, score);
					vilAmount.put(town, 1);
				}else{//Map中已经添加该镇的分数，对新添加的分数进行累加
					Integer tmp = totalSco.get(town) + score;
					Integer amount = vilAmount.get(town) + 1;
					totalSco.put(town, tmp);
					vilAmount.put(town, amount);
				}
			}
			
		}else if(divi == 3){//镇级对村进行排序
			CTVRankAction.setGraphName(CTVRankAction.getGraphName()+"各村庄");
			List<TownBasicInfo> townBasicInfos = getTownByTownNum(treeDiviCode);
			List<VilBasicInfo> vils = getVilsByTowns(townBasicInfos);
			List<VilEvalSco> vilEvalScos = getScoresInOrder(vils, year);
			for(VilEvalSco vilEvalSco : vilEvalScos){
				String vil = vilEvalSco.getVilDataCollRec().getVilBasicInfo().getVilName();
				Integer score = (vilEvalSco.getVilEvalTotGra() != null && !vilEvalSco.getVilEvalTotGra().equals("")) ? Integer.parseInt(vilEvalSco.getVilEvalTotGra()) : 0;
				if(!totalSco.containsKey(vil)){//Map中还没有添加该村
					totalSco.put(vil, score);
					vilAmount.put(vil, 1);
				}else{//Map中已经添加该村的分数，对新添加的分数进行累加
					Integer tmp = totalSco.get(vil) + score;
					Integer amount = vilAmount.get(vil) + 1;
					totalSco.put(vil, tmp);
					vilAmount.put(vil, amount);
				}
			}
			
		}else if(divi == 4){//村级
			//暂无此级用户
		}else if(divi == 0){
			
		}
		//计算平均分
		for(Map.Entry<String, Integer> entry : totalSco.entrySet()){
			avgScoInDesc.put(entry.getKey(), entry.getValue()*1.0 / vilAmount.get(entry.getKey()));
		}
		//avgScoInDesc = sortInDesc(avgScoInDesc);
		List<Map.Entry<String,Double>> list = new ArrayList<Map.Entry<String,Double>>(avgScoInDesc.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
        });
		return list;
	}
	
	public List<Entry<String, Double>> getScoreInDesc(Integer divi, String treeDiviCode, Integer year, String selectedFirstLevelInd) {
		Map<String, Integer> totalSco = new HashMap<String, Integer>();
		Map<String, Integer> vilAmount = new HashMap<String, Integer>();
		Map<String, Double> avgScoInDesc = new HashMap<String, Double>();
		if(divi == 1){//市级对县进行排序
			CTVRankAction.setGraphName(CTVRankAction.getGraphName()+"各县（区）");
			List<CityBasicInfo> cityBasicInfos = getCityByCityNum(treeDiviCode);
			List<CountryBasicInfo> countryBasicInfos = getCountrysByCitys(cityBasicInfos);
			List<TownBasicInfo> townBasicInfos = getTownsByCountrys(countryBasicInfos);
			List<VilBasicInfo> vils = getVilsByTowns(townBasicInfos);
			List<LevelsIndSco> levelsIndScos = getFirstLevelScoresInOrder(vils, year, selectedFirstLevelInd);
			for(LevelsIndSco levelsIndSco : levelsIndScos){
				String country = levelsIndSco.getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getTownBasicInfo().getCountryBasicInfo().getCountryName();
				Integer score = (levelsIndSco.getLevelsIndSco() != null && !levelsIndSco.getLevelsIndSco().equals("")) ? Integer.parseInt(levelsIndSco.getLevelsIndSco()) : 0;
				if(!totalSco.containsKey(country)){//Map中还没有添加该县
					totalSco.put(country, score);
					vilAmount.put(country, 1);
				}else{//Map中已经添加该县的分数，对新添加的分数进行累加
					Integer tmp = totalSco.get(country) + score;
					Integer amount = vilAmount.get(country) + 1;
					totalSco.put(country, tmp);
					vilAmount.put(country, amount);
				}
			}
			
		}else if(divi == 2){//县级对镇排序
			CTVRankAction.setGraphName(CTVRankAction.getGraphName()+"各乡（镇）");
			List<CountryBasicInfo> countryBasicInfos = getCountryByCountryNum(treeDiviCode);
			List<TownBasicInfo> townBasicInfos = getTownsByCountrys(countryBasicInfos);
			List<VilBasicInfo> vils = getVilsByTowns(townBasicInfos);
			List<LevelsIndSco> levelsIndScos = getFirstLevelScoresInOrder(vils, year, selectedFirstLevelInd);
			for(LevelsIndSco levelsIndSco : levelsIndScos){
				String town = levelsIndSco.getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getTownBasicInfo().getTownName();
				Integer score = (levelsIndSco.getLevelsIndSco() != null && !levelsIndSco.getLevelsIndSco().equals("")) ? Integer.parseInt(levelsIndSco.getLevelsIndSco()) : 0;
				if(!totalSco.containsKey(town)){//Map中还没有添加该镇
					totalSco.put(town, score);
					vilAmount.put(town, 1);
				}else{//Map中已经添加该镇的分数，对新添加的分数进行累加
					Integer tmp = totalSco.get(town) + score;
					Integer amount = vilAmount.get(town) + 1;
					totalSco.put(town, tmp);
					vilAmount.put(town, amount);
				}
			}
			
		}else if(divi == 3){//镇级对村进行排序
			CTVRankAction.setGraphName(CTVRankAction.getGraphName()+"各村庄");
			List<TownBasicInfo> townBasicInfos = getTownByTownNum(treeDiviCode);
			List<VilBasicInfo> vils = getVilsByTowns(townBasicInfos);
			List<LevelsIndSco> levelsIndScos = getFirstLevelScoresInOrder(vils, year, selectedFirstLevelInd);
			for(LevelsIndSco levelsIndSco : levelsIndScos){
				String vil = levelsIndSco.getVilEvalSco().getVilDataCollRec().getVilBasicInfo().getVilName();
				Integer score = (levelsIndSco.getLevelsIndSco() != null && !levelsIndSco.getLevelsIndSco().equals("")) ? Integer.parseInt(levelsIndSco.getLevelsIndSco()) : 0;
				if(!totalSco.containsKey(vil)){//Map中还没有添加该村
					totalSco.put(vil, score);
					vilAmount.put(vil, 1);
				}else{//Map中已经添加该村的分数，对新添加的分数进行累加
					Integer tmp = totalSco.get(vil) + score;
					Integer amount = vilAmount.get(vil) + 1;
					totalSco.put(vil, tmp);
					vilAmount.put(vil, amount);
				}
			}
			
		}else if(divi == 4){//村级
			//暂无此级用户
		}else if(divi == 0){
			
		}
		//计算平均分
		for(Map.Entry<String, Integer> entry : totalSco.entrySet()){
			avgScoInDesc.put(entry.getKey(), entry.getValue()*1.0 / vilAmount.get(entry.getKey()));
		}
		//avgScoInDesc = sortInDesc(avgScoInDesc);
		List<Map.Entry<String,Double>> list = new ArrayList<Map.Entry<String,Double>>(avgScoInDesc.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Double>>() {
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
        });
		return list;
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
	
	
	//得到按降序排列的村庄总分
	private List<VilEvalSco> getScoresInOrder(List<VilBasicInfo> vils, Integer year) {
		List<VilEvalSco> vilEvalScos = new ArrayList<VilEvalSco>();
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
		String sql_1 = "VilDataCollRecID IN (";
		for(Integer id: vilDataCollRecs){
			sql_1 += id+",";
		}
		sql_1 += "'') ORDER BY VilEvalTotGra DESC";
		vilEvalScos = vilEvalScoDAO.findBySql(sql_1);
		return vilEvalScos;
	}
	
	
	
	public List<EvalSystInd> getFirstLevelInds() {
		String sql = "UpEvalIndNum is NULL";
		return evalSystIndDAO.findBySql(sql);
	}
	public CityBasicInfoDAO getCityBasicInfoDAO() {
		return cityBasicInfoDAO;
	}
	public void setCityBasicInfoDAO(CityBasicInfoDAO cityBasicInfoDAO) {
		this.cityBasicInfoDAO = cityBasicInfoDAO;
	}
	public CountryBasicInfoDAO getCountryBasicInfoDAO() {
		return countryBasicInfoDAO;
	}
	public void setCountryBasicInfoDAO(CountryBasicInfoDAO countryBasicInfoDAO) {
		this.countryBasicInfoDAO = countryBasicInfoDAO;
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
	public EvalSystIndDAO getEvalSystIndDAO() {
		return evalSystIndDAO;
	}
	public void setEvalSystIndDAO(EvalSystIndDAO evalSystIndDAO) {
		this.evalSystIndDAO = evalSystIndDAO;
	}
	public LevelsIndScoDAO getLevelsIndScoDAO() {
		return levelsIndScoDAO;
	}
	public void setLevelsIndScoDAO(LevelsIndScoDAO levelsIndScoDAO) {
		this.levelsIndScoDAO = levelsIndScoDAO;
	}

	
}
