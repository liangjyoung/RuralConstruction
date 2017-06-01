package com.rural.prmtmeas.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.CityBasicInfo;
import com.rural.bean.CitysCont;
import com.rural.bean.CountryBasicInfo;
import com.rural.bean.CountryCont;
import com.rural.bean.EvalCont;
import com.rural.bean.EvalContSubSco;
import com.rural.bean.ProBasicInfo;
import com.rural.bean.Sex;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.TownCont;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilCont;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.contact.action.ContactAction;
import com.rural.dao.CityBasicInfoDAO;
import com.rural.dao.CitysContDAO;
import com.rural.dao.CountryBasicInfoDAO;
import com.rural.dao.CountryContDAO;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.ProBasicInfoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.TownContDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilContDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.prmtmeas.action.PrmtMeasAction;
import com.rural.tool.Criterion;

public class PrmtMeasService implements IPrmtMeasService {

	private CityBasicInfoDAO cityBasicInfoDAO = new CityBasicInfoDAO();
	private CountryBasicInfoDAO countryBasicInfoDAO = new CountryBasicInfoDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	
	private ProBasicInfoDAO proBasicInfoDAO = new ProBasicInfoDAO();

	private EvalContSubScoDAO evalContSubScoDAO = new EvalContSubScoDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	
	private EvalContDAO  evalContDAO  = new EvalContDAO();
	 
	
	
	public EvalContDAO getEvalContDAO() {
		return evalContDAO;
	}
	public void setEvalContDAO(EvalContDAO evalContDAO) {
		this.evalContDAO = evalContDAO;
	}
	public VilEvalScoDAO getVilEvalScoDAO() {
		return vilEvalScoDAO;
	}
	public void setVilEvalScoDAO(VilEvalScoDAO vilEvalScoDAO) {
		this.vilEvalScoDAO = vilEvalScoDAO;
	}
	public VilDataCollRecDAO getVilDataCollRecDAO() {
		return vilDataCollRecDAO;
	}
	public void setVilDataCollRecDAO(VilDataCollRecDAO vilDataCollRecDAO) {
		this.vilDataCollRecDAO = vilDataCollRecDAO;
	}
	public EvalContSubScoDAO getEvalContSubScoDAO() {
		return evalContSubScoDAO;
	}
	public void setEvalContSubScoDAO(EvalContSubScoDAO evalContSubScoDAO) {
		this.evalContSubScoDAO = evalContSubScoDAO;
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

	public ProBasicInfoDAO getProBasicInfoDAO() {
		return proBasicInfoDAO;
	}
	public void setProBasicInfoDAO(ProBasicInfoDAO proBasicInfoDAO) {
		this.proBasicInfoDAO = proBasicInfoDAO;
	}
	
	
	@SuppressWarnings("unchecked")
	public int getProID(String proNum){
		int a =0 ;
		List<ProBasicInfo> li = new ArrayList<ProBasicInfo>();
		li = this.proBasicInfoDAO.findByProNum(proNum);
		for (ProBasicInfo proBasicInfo : li) {
			a = proBasicInfo.getProBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	public int getCityID(String cityNum){
		int a =0 ;
		List<CityBasicInfo> li = new ArrayList<CityBasicInfo>();
		li = this.cityBasicInfoDAO.findByProperty1("cityNum", cityNum);
		for (CityBasicInfo cityBasicInfo : li) {
			a = cityBasicInfo.getCityBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	
	public int getCountryID(String countryNum){
		int a =0 ;
		List<CountryBasicInfo> li = new ArrayList<CountryBasicInfo>();
		li = this.countryBasicInfoDAO.findByProperty1("countryNum", countryNum);
		for (CountryBasicInfo countryBasicInfo : li) {
			a = countryBasicInfo.getCountryBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	
	public int getTownID(String townNum){
		int a =0 ;
		List<TownBasicInfo> li = new ArrayList<TownBasicInfo>();
		li = this.townBasicInfoDAO.findByProperty1("townNum", townNum);
		for (TownBasicInfo townBasicInfo : li) {
			a = townBasicInfo.getTownBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
		
	}
	
	public List<CityBasicInfo> getCities(String  proNum) {
		// TODO Auto-generated method stub
		
		List<CityBasicInfo> list = new ArrayList<CityBasicInfo>();
		
		list = this.cityBasicInfoDAO.findByProperty("proBasicInfo.proBasicInfoId",this.getProID(proNum));
		return list;
	}
	public  CityBasicInfo getCity(String cityNum)
	{
		CityBasicInfo cityBasicInfo = new CityBasicInfo();
		cityBasicInfo = this.cityBasicInfoDAO.findById(this.getCityID(cityNum));
		return cityBasicInfo;
		
	}

	@SuppressWarnings("unchecked")
	public List<CountryBasicInfo> getCountries(int cityBasicInfoID) {
		// TODO Auto-generated method stub
		List<CountryBasicInfo> list = new ArrayList<CountryBasicInfo>();
		list = this.countryBasicInfoDAO.findByProperty("cityBasicInfo.cityBasicInfoId", cityBasicInfoID);
		return list;
	}
	public CountryBasicInfo getCountry(String countryNum)
	{
		CountryBasicInfo countryBasicInfo = new CountryBasicInfo();
		countryBasicInfo = this.countryBasicInfoDAO.findById(this.getCountryID(countryNum));
		return countryBasicInfo;
	} 
	
	
@SuppressWarnings("unchecked")
	
	public List<TownBasicInfo> getTowns(int countryBasicInfoID) {
		// TODO Auto-generated method stub
		List<TownBasicInfo> list = new ArrayList<TownBasicInfo>();
		list = this.townBasicInfoDAO.findByProperty("countryBasicInfo.countryBasicInfoId", countryBasicInfoID);
		return list;
	}

	

	
	
/*	
	
	
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		
		List<EvalContSubSco> list2 = new ArrayList<EvalContSubSco>();
		int vilId = this.getVilID(PrmtMeasAction.JQS);
		int vilDataCollRecId = this.getVilDataCollRecID(vilId);
		int vilEvalScoId = this.getVilEvalScoID(vilDataCollRecId);
		list2 = this.evalContSubScoDAO.findByConditionAndPager(vilEvalScoId,sql, values, from,length);
		int fullMarks = 0;
		int zeroMarks= 0;
		int marks = 0;
		fullMarks = this.getFullMarksCount(list2);
		zeroMarks = this.getZeroMarksCount(list2);
		marks = this.getMarksCount(list2);
		
			HashMap<String, Object> map = new HashMap<String, Object>();
			//map.put("collTime", );
			map.put("fullMarks", fullMarks);
			
			map.put("zeroMarks", zeroMarks);
			
			map.put("marks", marks);
			
			
			result.add(map);
		
		
		return  result;
	}
	*/


Comparator c = new Comparator<VilDataCollRec>() {  
    public int compare(VilDataCollRec v1, VilDataCollRec v2) {  
        // TODO Auto-generated method stub  
    	 int flag = v1.getCollTim().compareTo(v2.getCollTim());  
    	 return flag;  
    }  
};   


public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
		int from, int length) {
	// TODO Auto-generated method stub
	String sql = null;
	List<Object> values = null;
	if (criteria != null) {
		sql = Criterion.convertToSql(criteria);
		values = Criterion.getCriteriaValues(criteria);
	}
	List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
	
	List<EvalContSubSco> list2 = new ArrayList<EvalContSubSco>();
	int vilId = this.getVilID(PrmtMeasAction.JQS);
	
	List<VilDataCollRec> vi = new  ArrayList<VilDataCollRec>();
	vi = vilDataCollRecDAO.findByProperty1("vilBasicInfo.vilBasicInfoId", vilId);
	
	Collections.sort(vi,c);   
	
	int vilEvalScoId = 0;
	int fullMarks = 0;
	int zeroMarks= 0;
	int marks = 0;
	for(VilDataCollRec v:vi){
		
		 vilEvalScoId = this.getVilEvalScoID( v.getVilDataCollRecId());
		 list2 = this.evalContSubScoDAO.findByConditionAndPager(vilEvalScoId,sql, values, from,length);
			
			fullMarks = this.getFullMarksCount(list2);
			zeroMarks = this.getZeroMarksCount(list2);
			marks = this.getMarksCount(list2);
			
				HashMap<String, Object> map = new HashMap<String, Object>();
				//map.put("collTime", );
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				//map.put("CollTim", sdf.format(a.getCollTim()));

				map.put("collTime",sdf.format(v.getCollTim())+"年度" );
				map.put("fullMarks", fullMarks);
				
				map.put("zeroMarks", zeroMarks);
				
				map.put("marks", marks);
				
				
				result.add(map);
		
	          }
	
	
	
	
	return  result;
	
	
}
	
	public List<VilBasicInfo> getVils(int vilBasicInfoID) {
		// TODO Auto-generated method stub
		List<VilBasicInfo> list = new ArrayList<VilBasicInfo>();
		list = this.vilBasicInfoDAO.findByProperty("townBasicInfo.townBasicInfoId", vilBasicInfoID);
		return list;
	}
	public TownBasicInfo getTown(String townNum) {
		// TODO Auto-generated method stub
		TownBasicInfo townBasicInfo = new TownBasicInfo();
		townBasicInfo = this.townBasicInfoDAO.findById(this.getTownID(townNum));
		return townBasicInfo;
	}
	public int getVilID(String vilNum) {
		int a =0 ;
		List<VilBasicInfo> li = new ArrayList<VilBasicInfo>();
		li = this.vilBasicInfoDAO.findByProperty1("vilNum", vilNum);
		for (VilBasicInfo vilBasicInfo : li) {
			a = vilBasicInfo.getVilBasicInfoId();
		}
		System.out.println("--------->"+a);
		return a;
	}
	
	public int getVilDataCollRecID(int vilId){
		
		int a = 0;
		List<VilDataCollRec> vi = new  ArrayList<VilDataCollRec>();
		vi = vilDataCollRecDAO.findByProperty1("vilBasicInfo.vilBasicInfoId", vilId);
		for(VilDataCollRec v:vi){
			a = v.getVilDataCollRecId();
			
		}
		return a;
	}
	
public String getVilDataCollRecIDs(int vilId){
		
		String a = "";
		List<VilDataCollRec> vi = new  ArrayList<VilDataCollRec>();
		vi = vilDataCollRecDAO.findByProperty1("vilBasicInfo.vilBasicInfoId", vilId);
		for(VilDataCollRec v:vi){
			a = a+v.getVilDataCollRecId();
			
		}
		return a;
	}
	
	
	public int getVilEvalScoID(int vilDataCollRecId){
		
		int  a = 0;
		List<VilEvalSco> v = new ArrayList<VilEvalSco>();
		v = vilEvalScoDAO.findByProperty1("vilDataCollRec.vilDataCollRecId", vilDataCollRecId);
		for(VilEvalSco i:v){
			a = i.getVilEvalScoId();
			
		}
		return a;
	}
	
	public int getFullMarksCount(List<EvalContSubSco>  evalContSubSco){
		int a = 0;
		
		EvalCont evalCont = new EvalCont();
		for(EvalContSubSco e:evalContSubSco){
			evalCont = 	evalContDAO.findById(e.getEvalCont().getEvalContId());
			if(Integer.parseInt(evalCont.getEvalContScore())==Integer.parseInt(e.getAutoEvalSco())){
				a++;
			}
			
		}
		return a;
	}
	

	public int getZeroMarksCount(List<EvalContSubSco>  evalContSubSco){
		int b = 0;
		
		//EvalCont evalCont = new EvalCont();
		for(EvalContSubSco e:evalContSubSco){
			//evalCont = 	evalContDAO.findById(e.getEvalCont().getEvalContId());
			if(Integer.parseInt(e.getAutoEvalSco())==0){
				b++;
			}
			
		}
		return b;
	}
	
	public int getMarksCount(List<EvalContSubSco>  evalContSubSco){
		int c = 0;
		
		EvalCont evalCont = new EvalCont();
		for(EvalContSubSco e:evalContSubSco){
			evalCont = 	evalContDAO.findById(e.getEvalCont().getEvalContId());
			if((Integer.parseInt(evalCont.getEvalContScore())!=Integer.parseInt(e.getAutoEvalSco()))&&(Integer.parseInt(e.getAutoEvalSco())!=0)){
				c++;
			}
			
		}
		return c;
	}
	
	
	//查询已达标的[评价内容
	
	public void getFullEvalCont(String vilNum ,Date collTim){
		
		
	}
	
	

	public List<HashMap<String, Object>> queryByPage(Object object, int from,
			int length) {
		// TODO Auto-generated method stub
		return null;
	}
	public int queryResultsCount(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return 0;
	}
}
	
