package com.rural.averanalysis.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.TownBasicInfo;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.TownBasicInfoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.tool.Criterion;

public class TownAverAnalysisService implements ITownAverAnalysisService{
	
	private TownBasicInfoDAO townBasicInfoDAO = new TownBasicInfoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	
	public List<HashMap<String, Object>> townAverAnalysis(String townNum) {
		// TODO Auto-generated method stub
		List<VilBasicInfo> vils = new ArrayList<VilBasicInfo>();
		List<VilDataCollRec> fullColl = new ArrayList<VilDataCollRec>();
		List<VilDataCollRec> vilColl = new ArrayList<VilDataCollRec>();
		List<HashMap<String, Object>> averList = new ArrayList<HashMap<String, Object>>();
		Date collTime;
		int realTime;
		int vilEvalTotGra = 0;
		double vilEvaAver = 0.0;
		int townId = this.getTownID(townNum);
		vils = this.getVils(townId);
		fullColl = this.getFullVilDataCollRec();
		VilDataCollRec coll = fullColl.get(0);
		collTime = coll.getCollTim();
		realTime = this.getYear(collTime);
		for(int i = realTime;;i++){
			
			List<VilDataCollRec> vilColls = new ArrayList<VilDataCollRec>();
			vilColls = this.getVilDataCollRecs(i);
			if(vilColls.size()>0){
				
				vilEvaAver = this.townAver(vils, i);
				HashMap<String, Object> dsMap = new HashMap<String, Object>();
				dsMap.put("collTime", String.valueOf(i));
				dsMap.put("vilEvaAver",vilEvaAver );
				averList.add(dsMap);
				//
			}else{
				
				break;
			}
						
		}
		
		
		
		return averList;
	}
	
	public List<HashMap<String, Object>> townAver(String townNum ,int year) {
		// TODO Auto-generated method stub
		List<VilBasicInfo> vils = new ArrayList<VilBasicInfo>();
		List<VilDataCollRec> fullColl = new ArrayList<VilDataCollRec>();
		List<VilDataCollRec> vilColl = new ArrayList<VilDataCollRec>();
		List<HashMap<String, Object>> averList = new ArrayList<HashMap<String, Object>>();
		Date collTime;
		int realTime;
		int vilEvalTotGra = 0;
		double vilEvaAver = 0.0;
		int townId = this.getTownID(townNum);
		vils = this.getVils(townId);
		
	
				vilEvaAver = this.townAver(vils, year);
				HashMap<String, Object> dsMap = new HashMap<String, Object>();
				dsMap.put("collTime", String.valueOf(year));
				dsMap.put("vilEvaAver",vilEvaAver );
				averList.add(dsMap);
			
		
		return averList;
	}
	
	public double townAver(List<VilBasicInfo> vilBasicInfo, int collYear){
		//List<VilBasicInfo> vilBasicInfo = new ArrayList<VilBasicInfo>();
		List<VilDataCollRec> allColl = new ArrayList<VilDataCollRec>();
		List<VilDataCollRec> vilColl = new ArrayList<VilDataCollRec>();
		List<VilEvalSco> vilEvalSco = new ArrayList<VilEvalSco>();
		int num = 0;
		double vilEvalTotGra = 0;
		double vilEvaAver = 0.0;

		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");    
		
		for(VilBasicInfo vil :vilBasicInfo){
			vilColl = this.getVilDataCollRec(vil.getVilBasicInfoId(), collYear);
			if(vilColl.size()>0){
			for(VilDataCollRec vr  :vilColl)
			{
				
				vilEvalSco = this.getVilEvalSco(vr.getVilDataCollRecId());
				
				for(VilEvalSco ve: vilEvalSco){
					
					vilEvalTotGra += Double.parseDouble(ve.getVilEvalTotGra());
					num++;
				}
				
			}

			}
			
		}
		if(num!=0){
			BigDecimal bg = new BigDecimal(vilEvalTotGra/num);
			vilEvaAver = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
          

			
		}
		
		
		
		return vilEvaAver;
	}
	
	
	Comparator c = new Comparator<VilDataCollRec>() {  
	    public int compare(VilDataCollRec v1, VilDataCollRec v2) {  
	        // TODO Auto-generated method stub  
	    	 int flag = v1.getCollTim().compareTo(v2.getCollTim());  
	    	 return flag;  
	    }  
	}; 
	
	
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
	public List<VilDataCollRec> getVilDataCollRec(int vilId){
		
		List<VilDataCollRec> coll = new ArrayList<VilDataCollRec>();
		coll  = vilDataCollRecDAO.findByProperty1("vilBasicInfo.vilBasicInfoId", vilId);
		return coll;
		
	}
	
	
 
	public List<VilEvalSco> getVilEvalSco(int vilDataCollRecId){
		
		List<VilEvalSco> vilEvalSco = new ArrayList<VilEvalSco>();
		vilEvalSco = vilEvalScoDAO.findByProperty1("vilDataCollRec.vilDataCollRecId", vilDataCollRecId);
		return vilEvalSco;
		
	}
	
	public List<VilDataCollRec> getFullVilDataCollRec(){
			
			List<VilDataCollRec> coll = new ArrayList<VilDataCollRec>();
			coll  = vilDataCollRecDAO.findAll();
			Collections.sort(coll,c); 
			return coll;
			
		}
		public List<VilDataCollRec> getVilDataCollRec(String collTime){
			List<VilDataCollRec> coll = new ArrayList<VilDataCollRec>();
				try{
				
				 java.sql.Date sdate = null; 
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
				 java.util.Date udate = formatter.parse(collTime);  
				   sdate = new java.sql.Date(udate.getTime()); //2013-01-14//初始化  
				 
				  // Date strtodate = formatter.parse(a.toString());
				 Calendar a1 = Calendar.getInstance();
				 a1.setTime(sdate);
				 int year = a1.get(Calendar.YEAR);  
				
				coll  = vilDataCollRecDAO.findVilDataCollRec(year);
				
				}catch(Exception e){
					e.printStackTrace();
					
				}
				return coll;
				
			}
		
		
		public List<VilDataCollRec> getVilDataCollRecs(int collYear){
			List<VilDataCollRec> coll = new ArrayList<VilDataCollRec>();
				try{
			
				
				coll  = vilDataCollRecDAO.findVilDataCollRec(collYear);
				
				}catch(Exception e){
					e.printStackTrace();
					
				}
				return coll;
				
			}
		
		public List<VilDataCollRec> getVilDataCollRec(int vilId,int collTime){
			List<VilDataCollRec> coll = new ArrayList<VilDataCollRec>();
				coll = vilDataCollRecDAO.findVilDataCollRec(vilId, collTime);
				return coll;
				
			}
		
		public int getYear(Date collTime){
			int year = 0;
			try{
				
				 java.sql.Date sdate = null; 
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
				// java.util.Date udate = formatter.parse(collTime);  
				   sdate = new java.sql.Date(collTime.getTime()); //2013-01-14//初始化  
				 
				  // Date strtodate = formatter.parse(a.toString());
				 Calendar a1 = Calendar.getInstance();
				 a1.setTime(sdate);
				year = a1.get(Calendar.YEAR);  
				
				}catch(Exception e){
					e.printStackTrace();
					
				}
			
			return year;
		}
	
	

	public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return 0;
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
	
	

	

}
