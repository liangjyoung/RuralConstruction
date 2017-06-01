package com.rural.villageColldData.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.Invgat;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.InvgatDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.tool.Criterion;

public class ColldDataJILUService implements IColldDataJILUService{

	
	private VilDataCollRecDAO vilDataCollRecDAO=new VilDataCollRecDAO();
	private VilBasicInfoDAO vilBasicInfoDAO=new VilBasicInfoDAO();
	private InvgatDAO invgatDAO=new InvgatDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();

	
	
	
	public VilEvalScoDAO getVilEvalScoDAO() {
		return vilEvalScoDAO;
	}



	public void setVilEvalScoDAO(VilEvalScoDAO vilEvalScoDAO) {
		this.vilEvalScoDAO = vilEvalScoDAO;
	}



	public List<VilDataCollRec> getChildPrivance() {
		// TODO Auto-generated method stub
		List<VilDataCollRec> list = new ArrayList<VilDataCollRec>();
		list = this.vilDataCollRecDAO.findFather();
		return list;
	}
	
	
	public void addColldDataJILU( int VilBasicInfoID,int InvgatID,String CollEqptCode,Date CollTim,String CilDataCollRecNote) 
	{
		// TODO Auto-generated method stub
		VilDataCollRec vilDataCollRec=new VilDataCollRec();
		//��У�ڵ�ʦ��������ѧԺID
		VilBasicInfo vilBasicInfo=new VilBasicInfo();
		Invgat invgat=new Invgat();
		
		vilBasicInfo=vilBasicInfoDAO.findById(VilBasicInfoID);
		invgat=invgatDAO.findById(InvgatID);
		vilDataCollRec.setVilBasicInfo(vilBasicInfo);
		vilDataCollRec.setInvgat(invgat);
		vilDataCollRec.setCollTim(CollTim);
		vilDataCollRec.setVilDataCollRecNote(CilDataCollRecNote);
		vilDataCollRec.setCollEqptCode(CollEqptCode);
		vilDataCollRecDAO.save(vilDataCollRec);
	

		/**
		 * 添加记录同是添加得分
		 * */
		/*VilDataCollRec vilDataCollRecs =(VilDataCollRec) vilDataCollRecDAO.findNewRec(VilBasicInfoID, InvgatID, CollTim);
		VilEvalSco evalSco = new VilEvalSco();
		evalSco.setVilDataCollRec(vilDataCollRecs);
		evalSco.setAutoEvalTotGra("0");
		evalSco.setVilEvalScoNote(null);
		evalSco.setExpertEvalTotGra("0");
		evalSco.setVilEvalTotGra("0");
		vilEvalScoDAO.save(evalSco);*/

		
		
	}
	public void delColldDataJILU(int VilDataCollRecId) {
		// TODO Auto-generated method stub
		VilDataCollRec vilDataCollRec=new VilDataCollRec();
		vilDataCollRec = vilDataCollRecDAO.findById(VilDataCollRecId);
		vilDataCollRecDAO.delete(vilDataCollRec);
	}
	
	public void ediColldDataJILU(int VilDataCollRecId,int VilBasicInfoID,int InvgatID,String CollEqptCode,Date CollTim,String CilDataCollRecNote) {
		// TODO Auto-generated method stub
		VilDataCollRec vilDataCollRec=new VilDataCollRec();
		//��У�ڵ�ʦ��������ѧԺID
		VilBasicInfo vilBasicInfo=new VilBasicInfo();
		Invgat invgat=new Invgat();
		vilDataCollRec=vilDataCollRecDAO.findById(VilDataCollRecId);
		vilBasicInfo=vilBasicInfoDAO.findById(VilBasicInfoID);
		invgat=invgatDAO.findById(InvgatID);
		vilDataCollRec.setVilBasicInfo(vilBasicInfo);
		vilDataCollRec.setInvgat(invgat);
		vilDataCollRec.setCollTim(CollTim);
		vilDataCollRec.setVilDataCollRecNote(CilDataCollRecNote);
		vilDataCollRec.setCollEqptCode(CollEqptCode);
		
		vilDataCollRecDAO.attachDirty(vilDataCollRec);
	}
	
	/*public ArrayList<HashMap<String, Object>> findAll() {
		// TODO Auto-generated method stub
		List<InvesObjColldData> list = new ArrayList<InvesObjColldData>();
		list = this.invesObjColldDataDAO.findAll();
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(InvesObjColldData s : list){
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("InvesObjCollDataID",s.getInvesObjCollDataId());
			map.put("VilNum",s.getVilBasicInfo());
			map.put("InvesObjNum",s.getInvesObj());
			map.put("CollTim", s.getCollTim());
			map.put("StatDes", s.getStatDes());
			map.put("InvgatGra", s.getInvgatGra());
			result.add(map);
		}
		
		return result;
	}*/

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.vilDataCollRecDAO.getCounts(sql, values);
		//int rows = this.invesObjColldDataDAO.getCounts(sql, values);
		return rows;
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
		List<VilDataCollRec> list = new ArrayList<VilDataCollRec>();
		list = this.vilDataCollRecDAO.findByConditionAndPager(sql, values,from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (VilDataCollRec a : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("VilDataCollRecId", a.getVilDataCollRecId());
			if(a.getVilBasicInfo()==null){
				map.put("VilBasicInfoID", null);
			}else{
			map.put("VilBasicInfoID", a.getVilBasicInfo().getVilName());
			}
			if(a.getInvgat()==null){
				map.put("InvgatID",null);
			}else{
			map.put("InvgatID", a.getInvgat().getInvgatName());
			}
			if(a.getCollEqptCode()==null){
				map.put("CollEqptCode",null);
			}else{
				map.put("CollEqptCode", a.getCollEqptCode());
			}
			/*map.put("SexID", a.getSex().getSexName());
			map.put("TeacherTitle", a.getDepartmentContactTitle());
			map.put("Nation", a.getNation().getNationName());*/
			
			if(a.getCollTim()==null){
				map.put("CollTim", null);
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				map.put("CollTim", sdf.format(a.getCollTim()));
			}
			if(a.getVilDataCollRecNote()==null){
				map.put("CilDataCollRecNote",null);
			}else{
			map.put("CilDataCollRecNote", a.getVilDataCollRecNote());
			}
			
			
			
			
			result.add(map);
		}
		return result;
	}
	
	
	
	

	public VilDataCollRecDAO getVilDataCollRecDAO() {
		return vilDataCollRecDAO;
	}






	public void setVilDataCollRecDAO(VilDataCollRecDAO vilDataCollRecDAO) {
		this.vilDataCollRecDAO = vilDataCollRecDAO;
	}






	public InvgatDAO getInvgatDAO() {
		return invgatDAO;
	}






	public void setInvgatDAO(InvgatDAO invgatDAO) {
		this.invgatDAO = invgatDAO;
	}






	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}
	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
		
	}


	/*public void addColldDataJILU(String VilDataCollRecId, String VilNum,
			String InvgatNum, Date CollTim, String CilDataCollRecNote) {
		// TODO Auto-generated method stub
		
	}


	public void delColldDataJILU(int VilDataCollRecId) {
		// TODO Auto-generated method stub
		
	}


	public void ediColldDataJILU(String VilDataCollRecId, String VilNum,
			String InvgatNum, Date CollTim, String CilDataCollRecNote) {
		// TODO Auto-generated method stub
		
	}*/







	


	

}