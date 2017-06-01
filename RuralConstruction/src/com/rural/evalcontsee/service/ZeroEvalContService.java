package com.rural.evalcontsee.service;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.IllegalFormatConversionException;
import java.util.List;

import jxl.write.DateTime;


import com.rural.bean.CityBasicInfo;
import com.rural.bean.EvalCont;
import com.rural.bean.EvalContSubSco;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.evalcontsee.action.FullEvalContAction;
import com.rural.evalcontsee.action.ZeroEvalContAction;
import com.rural.prmtmeas.action.PrmtMeasAction;
import com.rural.tool.Criterion;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ZeroEvalContService implements IZeroEvalContService{
	
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	private EvalContSubScoDAO evalContSubScoDAO = new EvalContSubScoDAO();
	private EvalContDAO  evalContDAO  = new EvalContDAO();
	
	
	
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



	public EvalContSubScoDAO getEvalContSubScoDAO() {
		return evalContSubScoDAO;
	}



	public void setEvalContSubScoDAO(EvalContSubScoDAO evalContSubScoDAO) {
		this.evalContSubScoDAO = evalContSubScoDAO;
	}



	public EvalContDAO getEvalContDAO() {
		return evalContDAO;
	}



	public void setEvalContDAO(EvalContDAO evalContDAO) {
		this.evalContDAO = evalContDAO;
	}



	@SuppressWarnings("unchecked")
	
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
		//VilDataCollRec vilDataCollRec = new  VilDataCollRec();
		//vilDataCollRec = vilDataCollRecDAO
		List<VilDataCollRec> vi = new  ArrayList<VilDataCollRec>();
		//String a=ZeroEvalContAction.getJSTime1();
		try{
			String a = ZeroEvalContAction.getJSTime1();
			a = URLDecoder.decode(a, "UTF-8");
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		   //ParsePosition pos = new ParsePosition(0);
		 java.sql.Date sdate = null; 
		 java.util.Date udate = formatter.parse(a.toString().substring(0, 4));  
		    sdate = new java.sql.Date(udate.getTime()); //2013-01-14//初始化  
		  // Date strtodate = formatter.parse(a.toString());
		  // vi = vilDataCollRecDAO.findVilDataCollRec(vilId, sdate);
		    Calendar a1 = Calendar.getInstance();
			 a1.setTime(sdate);
			 int year = a1.get(Calendar.YEAR);  
			   vi = vilDataCollRecDAO.findVilDataCollRec(vilId, year);
		}catch(Exception e){
			e.printStackTrace();
		}
	   // DateTime dateTime ;
		//vi = vilDataCollRecDAO.findVilDataCollRec(vilId, strtodate);
		EvalCont evalCont = new EvalCont();
		int vilEvalScoId = 0;
		//HashMap<String, Object> map = new HashMap<String, Object>();
		for(VilDataCollRec v:vi){
			
			 vilEvalScoId = this.getVilEvalScoID( v.getVilDataCollRecId());
			 list2 = this.evalContSubScoDAO.findByConditionAndPager(vilEvalScoId,sql, values, from,length);
				for(EvalContSubSco ev:list2){
					HashMap<String, Object> map = new HashMap<String, Object>();
					evalCont = 	evalContDAO.findById(ev.getEvalCont().getEvalContId());
					if(Integer.parseInt(ev.getAutoEvalSco())==0){
						
						map.put("evalCont", evalCont.getEvalContDes());
						map.put("evalContScore",evalCont.getEvalContScore());
						
						map.put("autoEvalSco",ev.getAutoEvalSco());
						result.add(map);
						
					}
					
			
				}
	
		   }
	
		return  result;
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
	
public int getVilEvalScoID(int vilDataCollRecId){
		
		int  a = 0;
		List<VilEvalSco> v = new ArrayList<VilEvalSco>();
		v = vilEvalScoDAO.findByProperty1("vilDataCollRec.vilDataCollRecId", vilDataCollRecId);
		for(VilEvalSco i:v){
			a = i.getVilEvalScoId();
			
		}
		return a;
	}


public ArrayList<HashMap<String, Object>> findAll() {
	// TODO Auto-generated method stub
	return null;
}



public int queryResultsCount(List<Criterion> criteria) {
	// TODO Auto-generated method stub
	return 0;
}

}
