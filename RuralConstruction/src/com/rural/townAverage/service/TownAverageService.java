package com.rural.townAverage.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalCont;
import com.rural.bean.EvalContSubSco;
import com.rural.bean.EvalSyst;
import com.rural.bean.EvalSystInd;
import com.rural.bean.LevelsIndSco;
import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.EvalSystDAO;
import com.rural.dao.EvalSystIndDAO;
import com.rural.dao.ExamMethDAO;
import com.rural.dao.LevelsIndScoDAO;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.evalsystem.action.EvalMethAction;
import com.rural.tool.Criterion;
import com.rural.townAverage.action.TownAverageAction;

public class TownAverageService implements ITownAverageService {

	private EvalSystDAO evalSystDAO = new EvalSystDAO();
	private EvalSystIndDAO evalSystIndDAO = new EvalSystIndDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	private LevelsIndScoDAO  levelsIndScoDAO = new LevelsIndScoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private EvalContSubScoDAO evalContSubScoDAO = new EvalContSubScoDAO(); 
	private ExamMethDAO examMethDAO = new ExamMethDAO();
	private EvalContDAO evalMethDAO = new EvalContDAO();
	
	
	
	public EvalContSubScoDAO getEvalContSubScoDAO() {
		return evalContSubScoDAO;
	}

	public void setEvalContSubScoDAO(EvalContSubScoDAO evalContSubScoDAO) {
		this.evalContSubScoDAO = evalContSubScoDAO;
	}

	public ExamMethDAO getExamMethDAO() {
		return examMethDAO;
	}

	public void setExamMethDAO(ExamMethDAO examMethDAO) {
		this.examMethDAO = examMethDAO;
	}

	public EvalContDAO getEvalMethDAO() {
		return evalMethDAO;
	}

	public void setEvalMethDAO(EvalContDAO evalMethDAO) {
		this.evalMethDAO = evalMethDAO;
	}

	public EvalSystDAO getEvalSystDAO() {
		return evalSystDAO;
	}

	public void setEvalSystDAO(EvalSystDAO evalSystDAO) {
		this.evalSystDAO = evalSystDAO;
	}

	public EvalSystIndDAO getEvalSystIndDAO() {
		return evalSystIndDAO;
	}

	public void setEvalSystIndDAO(EvalSystIndDAO evalSystIndDAO) {
		this.evalSystIndDAO = evalSystIndDAO;
	}
	

	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}

	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}
	

	public TownBasicInfoDAO getTownBasicInfoDAO() {
		return townBasicInfoDAO;
	}

	public void setTownBasicInfoDAO(TownBasicInfoDAO townBasicInfoDAO) {
		this.townBasicInfoDAO = townBasicInfoDAO;
	}

	public List<EvalSystInd> getChildPermissions(String parentId) {
		// TODO Auto-generated method stub
		List<EvalSystInd> list = new ArrayList<EvalSystInd>();
		if (parentId==null) {
			list = this.evalSystIndDAO.findFather();
		}else{
			list = this.evalSystIndDAO.findChild(parentId);
		}
		return list;
	}

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String Fss = TownAverageAction.getEvalFSysIDs().trim();
		String ss =  TownAverageAction.getEvalSysIDs().trim();
		if(Fss.equals("hh")){
			sql = " EvalIndNum = '"+TownAverageAction.getEvalSysIDs()+"'";
			//getSingleList(sql,criteria,from,length,result);
		}else if(ss.equals("hh")){
			String sEvalMethID = "";
			List<EvalSystInd> fflist = this.evalSystIndDAO.findByProperty("evalSystInd.evalIndNum", EvalMethAction.getEvalFSysIDs().trim());//根据点击的父节点ID查询Up为ID的List
		
			if (fflist.size() > 0) {
				for (EvalSystInd evalSystInd : fflist) {
					sEvalMethID = sEvalMethID +getEvalContNums(evalSystInd.getEvalIndNum());
				}
			} else {
				//直接查找
				sEvalMethID = Fss;
			}
			sEvalMethID= sEvalMethID.substring(0, sEvalMethID.lastIndexOf(","));
		sql = " EvalIndNum in ("+sEvalMethID+")";
		
		}
		
		
		List<Object> values = null;
		int from1 =0;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<EvalCont> list2 = new ArrayList<EvalCont>();
		list2 = this.evalMethDAO.findByConditionAndPager(sql, values, from,length);
		String lastAver = "";
		//from1 = list2.size()+1;
		for (EvalCont xt : list2) {
			
			lastAver = this.getLevelsIndLastAver(xt.getEvalContId());
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("EvalContId", xt.getEvalContId());
			
			//map.put("EvalMethNum", xt.getEvalMethNum());
			if (xt.getEvalSystInd() == null){
				map.put("EvalIndNum", null);
			} else {
				map.put("EvalIndNum", xt.getEvalSystInd().getEvalIndNum());
			}
			if (xt.getEvalContNum() == null) {
				map.put("EvalMethNum", null);
			} else {
				map.put("EvalMethNum", xt.getEvalContNum());
			}
			if (xt.getEvalContDes()==null) {
				map.put("EvalContDes", null);
			} else {
				map.put("EvalContDes", xt.getEvalContDes());
			}
			
				map.put("EvalContScore",lastAver);
			
			if (xt.getBulReq() == null) {
				map.put("BulReq",null);
			} else {
				map.put("BulReq",xt.getBulReq());
			}
			if (xt.getEvalContScorMeth() == null) {
				map.put("EvalContScorMeth",null);
			} else {
				map.put("EvalContScorMeth",xt.getEvalContScorMeth());
			}
			
			if (xt.getEvalContNote() == null) {
				map.put("EvalContNote",null);
			} else {
				map.put("EvalContNote",xt.getEvalContNote());
			}
			
			if (xt.getSubjObjecValu()==null) {
				map.put("IsSubjGra",null);
			} else {
				map.put("IsSubjGra",xt.getSubjObjecValu());
			}
			if (xt.getExamMeth() == null) {
				map.put("ExamMethID", null);
			} else {
				map.put("ExamMethID", xt.getExamMeth().getExamMethName());
			}
			if (xt.getEvalContSeqNum() == null) {
				map.put("EvalContSeqNum", null);
			} else {
				map.put("EvalContSeqNum", xt.getEvalContSeqNum());
			}
			result.add(map);
		}
		
		
		return result;
	}
	private String getEvalContNums(String EvalIndNum){
		String ssEvalContID = "";
		List<EvalSystInd> fflist = this.evalSystIndDAO.findByProperty("evalSystInd.evalIndNum", EvalIndNum.trim());//根据点击的父节点ID查询Up为ID的List
		if (fflist.size() > 0) {//
			for (EvalSystInd evalSystInd : fflist) {
				ssEvalContID =ssEvalContID+ getEvalContNums(evalSystInd.getEvalIndNum());
			}
		} else {
			ssEvalContID =ssEvalContID+ "'"+EvalIndNum+"',";
		}
		
		return ssEvalContID;
	}
	
	
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		
		String sql = null;
		int rows ;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
	String Fss = TownAverageAction.getEvalFSysIDs().trim();
	String ss =  TownAverageAction.getEvalSysIDs().trim();
	if(Fss.equals("hh")){
		sql = " EvalIndNum = '"+TownAverageAction.getEvalSysIDs()+"'";
		//getSingleList(sql,criteria,from,length,result);
	}else if(ss.equals("hh")){
		String sEvalContID = "";
		List<EvalSystInd> fflist = this.evalSystIndDAO.findByProperty("evalSystInd.evalIndNum", EvalMethAction.getEvalFSysIDs().trim());//根据点击的父节点ID查询Up为ID的List
	
		if (fflist.size() > 0) {
			for (EvalSystInd evalSystInd : fflist) {
				sEvalContID = sEvalContID +getEvalContNums(evalSystInd.getEvalIndNum());
			}
			System.out.println("--------->"+sEvalContID);
		} else {
			//直接查找
			sEvalContID = Fss;
		}
		sEvalContID= sEvalContID.substring(0, sEvalContID.lastIndexOf(","));
		sql = " EvalIndNum in ("+sEvalContID+")";
	
	}
	 rows = this.evalMethDAO.getEvalmethCounts(sql, values);
			return rows;
	}
	
	
	//评价内容平均分
	
	public String getLevelsIndLastAver(int  evalContId){
		
		int b = 0;
		int c = 0;
		int count = 0;
		double sum = 0;
		String aver ="";
		
		List<VilBasicInfo> vils = new ArrayList<VilBasicInfo>();
		List<EvalContSubSco> evalContSubSco = new ArrayList<EvalContSubSco>();
		DecimalFormat df = new DecimalFormat("0.00");
		String townNum = TownAverageAction.getTownNum();
		int year = Integer.parseInt(TownAverageAction.getYear());
		int townId = this.getTownID(townNum);
		vils = this.getVils(townId);
		
		for(VilBasicInfo vilBasicInfo :vils){
			
			b = this.getVilDataCollRecIds(year, vilBasicInfo.getVilBasicInfoId());
			if(b!=0){
				c = this.getVilEvalScoId(b);
				if(c!=0){
					evalContSubSco = evalContSubScoDAO.findEvalContSubSco(evalContId,c);
				if(evalContSubSco.size()>0){
					if(evalContSubSco.get(0).getVilEvalContTotGra()!=null ){
				sum += Double.parseDouble(evalContSubSco.get(0).getVilEvalContTotGra());
				count++;
					}
				  }
				}
			}
			
		}
		if(count!=0){
			df.setRoundingMode(RoundingMode.HALF_UP);
			aver = df.format(sum/vils.size());
			
			
		}
		
		
		
		
		
		
		return aver;
		
	}
	
	
	
	
	
	
	//各级指标平均值
	
	public String getLevelsIndAver(String townNum,int year,String evalIndNum){
		
		
		int b = 0;
		int c = 0;
		int count = 0;
		double sum = 0;
		String aver = "";
		DecimalFormat df = new DecimalFormat("0.00");
		List<LevelsIndSco> levelsIndSco = new ArrayList<LevelsIndSco>();
		List<VilBasicInfo> vils = new ArrayList<VilBasicInfo>();
		int townId = this.getTownID(townNum);
		vils = this.getVils(townId);
		
		for(VilBasicInfo vilBasicInfo :vils){
			
			b = this.getVilDataCollRecIds(year, vilBasicInfo.getVilBasicInfoId());
			if(b!=0){
				c = this.getVilEvalScoId(b);
				if(c!=0){
				levelsIndSco = levelsIndScoDAO.findLevelsIndSco(evalIndNum, c);
				if(levelsIndSco.size()>0){
					if(levelsIndSco.get(0).getLevelsIndSco()!=null){
						sum += Double.parseDouble(levelsIndSco.get(0).getLevelsIndSco());
						count++;
					}
				  }
				}
			}
			
		}
		if(count!=0){
			df.setRoundingMode(RoundingMode.HALF_UP);
			aver = df.format(sum/vils.size());
			
		}
		
		
		
		
		
		
		return aver;
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
	
	public List<VilBasicInfo> getVils(int townId) {
		// TODO Auto-generated method stub
		List<VilBasicInfo> list = new ArrayList<VilBasicInfo>();
		list = this.vilBasicInfoDAO.findByProperty11("townBasicInfo.townBasicInfoId", townId);
		return list;
	}
	
	public int getVilDataCollRecId(int year){
		int a = 0;
		List<VilDataCollRec> vr = new ArrayList<VilDataCollRec>();
		vr = vilDataCollRecDAO.findVilDataCollRec(year);
		if(vr.size()>0){
			a = vr.get(0).getVilDataCollRecId();
		}
		
		return a;
		
	}
	
	public int getVilDataCollRecIds(int year, int vilId){
		int a = 0;
		List<VilDataCollRec> vr = new ArrayList<VilDataCollRec>();
		vr = vilDataCollRecDAO.findVilDataCollRec(vilId,year);
		if(vr.size()>0){
			a = vr.get(0).getVilDataCollRecId();
			
		}
		
		return a;
		
	}
	
	public int getVilEvalScoId(int vilDataCollRecId){
		int a = 0;
		List<VilEvalSco> vilEvalSco = new ArrayList<VilEvalSco>();
		vilEvalSco = vilEvalScoDAO.findByProperty1("vilDataCollRec.vilDataCollRecId", vilDataCollRecId);
		if(vilEvalSco.size()>0){
		a = vilEvalSco.get(0).getVilEvalScoId();
		}
		return a;
	}
	
	public String getEvalIndNum(int vilEvalScoId){
		String num ="";
		List<LevelsIndSco> levelsIndSco = new ArrayList<LevelsIndSco>();
		levelsIndSco = levelsIndScoDAO.findByProperty("vilEvalSco.vilEvalScoId", vilEvalScoId);
		if(levelsIndSco.size()>0){
			num = levelsIndSco.get(0).getEvalSystInd().getEvalIndNum();
			
		}
		
		return num;
	}
	public int getEvalSystId(String evalIndNum){
		int a = 0;
		List<EvalSystInd> evalSystInd = new ArrayList<EvalSystInd>();
		evalSystInd = evalSystIndDAO.findByProperty("evalIndNum", evalIndNum);
		if(evalSystInd.size()>0){
			a = evalSystInd.get(0).getEvalSyst().getEvalSystId();
		}
		
		return a;
		
	}
	
	public int getEvalSystIndId(int year){
		int a = 0;
		int b = 0;
		String c ;
		int d = 0;
		a = this.getVilDataCollRecId(year);
		b = this.getVilEvalScoId(a);
		c=this.getEvalIndNum(b);
		d =this.getEvalSystId(c);
		return d;
		
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
