package com.rural.colldatatemplet.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.rural.bean.EvalContInvesObj;
import com.rural.bean.InvesObj;
import com.rural.bean.InvesPro;
import com.rural.colldatatemplet.action.InvesObjAction;
import com.rural.dao.DataCollDataDicDAO;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.InvesObjDAO;
import com.rural.dao.InvesObjDataDAO;
import com.rural.dao.InvesProDAO;
import com.rural.dao.VilFilDataDAO;
import com.rural.tool.Criterion;
import com.rural.dao.InvesObjAttriDAO;
import com.rural.file.CreateFileUtil;

public class InvesObjService implements IInvesObjService{
	
	private InvesObjDAO invesObjDAO =  new InvesObjDAO();
	private DataCollDataDicDAO dataCollDataDicDAO = new DataCollDataDicDAO();
	private InvesObjAttriDAO invesObjAttriDAO = new InvesObjAttriDAO();
	private InvesProDAO invesProDAO = new InvesProDAO();
	
	private EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
	private InvesObjDataDAO invesObjDataDAO = new InvesObjDataDAO();
	private VilFilDataDAO vilFilDataDAO = new VilFilDataDAO();



	
	public VilFilDataDAO getVilFilDataDAO() {
		return vilFilDataDAO;
	}

	public void setVilFilDataDAO(VilFilDataDAO vilFilDataDAO) {
		this.vilFilDataDAO = vilFilDataDAO;
	}






	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}

	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

	public InvesObjDataDAO getInvesObjDataDAO() {
		return invesObjDataDAO;
	}

	public void setInvesObjDataDAO(InvesObjDataDAO invesObjDataDAO) {
		this.invesObjDataDAO = invesObjDataDAO;
	}

	public InvesProDAO getInvesProDAO() {
		return invesProDAO;
	}

	public void setInvesProDAO(InvesProDAO invesProDAO) {
		this.invesProDAO = invesProDAO;
	}

	
	
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String fss = InvesObjAction.getObjlFSysIDs().trim();
		String ss = InvesObjAction.getObjlSysIDs().trim();
		
		
		
		if(fss.equals("hh")){
			sql = " InvesProNum = '"+ss+"'";
			//getSingleList(sql,criteria,from,length,result);
		}else if(ss.equals("hh")){
			String sInvesProID = "";
			List<InvesPro> fflist = this.invesProDAO.findByProperty("invesPro.invesProNum",InvesObjAction.getObjlFSysIDs().trim());
			
			if (fflist.size() > 0) {
				for (InvesPro object : fflist) {
					sInvesProID = sInvesProID +getEvalContNums(object.getInvesProNum());
				}
				System.out.println("--------->"+sInvesProID);
			} else {
				//直接查找
				sInvesProID = fss;
			}
			sInvesProID= sInvesProID.substring(0, sInvesProID.lastIndexOf(","));
			sql = " InvesProNum in ("+sInvesProID+")";
		
		}
		
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<InvesObj> list2 = new ArrayList<InvesObj>();
		list2 = this.invesObjDAO.findByConditionAndPager(sql, values, from,length);
	
		for (InvesObj b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
		//	map.put("oldCode", b.getInvesObjId());
			map.put("invesObjID", b.getInvesObjId());
			
			if(b.getInvesObjAttri()== null){
				map.put("invesObjAttriId", null);
			}else{
				map.put("invesObjAttriId", b.getInvesObjAttri().getInvesObjAttriName());
			}
			
			if(b.getInvesObjName()==null){
				map.put("invesObjName", null);
				
			}else{
				map.put("invesObjName", b.getInvesObjName());
			//	String dirName = "D:/InvesObjFile1/";
		     //   CreateFileUtil.createDir(dirName+b.getInvesObjName()+b.getInvesObjCode());
			}
			
			if(b.getInvesObjCode()==null){
				map.put("invesObjCode", null);	
			}else{
				map.put("invesObjCode", b.getInvesObjCode());	
			}
			
			if( b.getInvesPro().getInvesProNum()== null){
				map.put("invesProNum", null);
			}else{
				map.put("invesProNum", b.getInvesPro().getInvesProNum());
			}
		
			if (b.getDataCollDataDic()==null) {
				map.put("dataCollDataDicId", null);	
			} else {
				map.put("dataCollDataDicId", b.getDataCollDataDic().getDataDicName());	
			}
			//map.put("dataCollDataDicId", b.getDataCollDataDic().getDataDicName());		
			
			if( b.getInvesObjComp()==null){
				map.put("invesObjComp",null);
			}else{
				map.put("invesObjComp", b.getInvesObjComp());	
			}
			
			if(b.getInvesObjLengt()==null){
				map.put("invesObjLengt",null);	
			}else{
				map.put("invesObjLengt", b.getInvesObjLengt());	
			}
			
				map.put("mus", b.getIsMustCollData());	
				
			
		
			if(b.getInvesObjNote()==null){
				map.put("invesObjNote", null);	
			}else{
				map.put("invesObjNote", b.getInvesObjNote());	
			}
			
			result.add(map);
		}
		return result;
	}

	private String getEvalContNums(String EvalIndNum){
		String ssEvalContID = "";
		List<InvesPro> fflist = this.invesProDAO.findByProperty("invesPro.invesProNum",EvalIndNum.trim());
		if (fflist.size() > 0) {//
			for (InvesPro object : fflist) {
				ssEvalContID =ssEvalContID+ getEvalContNums(object.getInvesProNum());
			}
		} else {
			ssEvalContID =ssEvalContID+ "'"+EvalIndNum+"',";
		}
		
		return ssEvalContID;
	}
	
	
	
	
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = "";
		int rows ;
		String fss = InvesObjAction.getObjlFSysIDs().trim();//父节点标记
		String ss = InvesObjAction.getObjlSysIDs().trim();//子节点标记
	
		if(fss.equals("hh")){
			sql = " InvesProNum = '"+ss+"'";
			//getSingleList(sql,criteria,from,length,result);
		}else if(ss.equals("hh")){
			String sInvesProID = "";
			List<InvesPro> fflist = this.invesProDAO.findByProperty("invesPro.invesProNum",InvesObjAction.getObjlFSysIDs().trim());
			
			if (fflist.size() > 0) {
				for (InvesPro object : fflist) {
					sInvesProID = sInvesProID +getEvalContNums(object.getInvesProNum());
				}
				System.out.println("--------->"+sInvesProID);
			} else {
				//直接查找
				sInvesProID = fss;
			}
			sInvesProID= sInvesProID.substring(0, sInvesProID.lastIndexOf(","));
			sql = " InvesProNum in ("+sInvesProID+")";
		
		}
		
		
		List<Object> values = null;
	
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		rows = this.invesObjDAO.getObjCounts(sql, values);
			//return rows;
		
		
		return rows;
		
	}
	


	//检查编码是否重复
	public boolean objCodeCheck(String invesObjCode,String id) {
		// TODO Auto-generated method stub
		
		//id=-1表示为增加一条记录,否则表示编辑
		//flag==true表示提示错误，flag==false表示没有重复，不提示错误
		if(id==null){
			if(invesObjDAO.findByInvesObjCode(invesObjCode).isEmpty()){
				return false;
			}else{
				return true;
			}
		}else{
			if(invesObjDAO.findById(Integer.parseInt(id)).getInvesObjCode().equals(invesObjCode)){
				return false;
			}else{
				if(invesObjDAO.findByInvesObjCode(invesObjCode).isEmpty()){
					return false;
				}else{
					return true;
				}
			}
		}
	}
	
	
	
	
	
	
//更新

	public void updateInvesObj(Integer invesObjID,Integer dataCollDataDicId, Integer invesObjAttriId, String invesProNum, String invesObjCode,String invesObjName, 
			String invesObjComp,String  invesObjLengt,boolean isMus,String invesObjNote) {
		
		// TODO Auto-generated method stub
		
		InvesObj invesObj = new InvesObj();
		invesObj = invesObjDAO.findById(invesObjID);
		
		invesObj.setDataCollDataDic(dataCollDataDicDAO.findById(dataCollDataDicId));
		invesObj.setInvesObjAttri(invesObjAttriDAO.findById(invesObjAttriId));
		invesObj.setInvesObjCode(invesObjCode);
		invesObj.setInvesObjName(invesObjName);
		invesObj.setInvesObjComp(invesObjComp);
		invesObj.setInvesObjLengt(invesObjLengt);
		invesObj.setIsMustCollData(isMus);
		invesObj.setInvesObjNote(invesObjNote);
	
		
		invesObjDAO.merge(invesObj);
	}
	

	
//添加
	
	public boolean addInvesObj( Integer dataCollDataDicId, Integer invesObjAttriId, String invesProNum, String invesObjCode,String invesObjName, 
			String invesObjComp,String  invesObjLengt,boolean isMus,String invesObjNote){
		// TODO Auto-generated method stub
		String fss = InvesObjAction.getObjlFSysIDs().trim();//标记是否是子节点
		
		
		if(fss.equals("hh")){
		InvesObj invesObj = new InvesObj();		
	
		
		invesObj.setDataCollDataDic(dataCollDataDicDAO.findById(dataCollDataDicId));
		invesObj.setInvesObjAttri(invesObjAttriDAO.findById(invesObjAttriId));
		invesObj.setInvesPro(invesProDAO.findById(invesProNum));
		invesObj.setInvesObjCode(invesObjCode);
		if(invesObjName.equals("")){
			invesObj.setInvesObjName(null);
		}else{
			invesObj.setInvesObjName(invesObjName);
		}
		if(invesObjComp.equals("")){
			invesObj.setInvesObjComp(null);
		}else{
			invesObj.setInvesObjComp(invesObjComp);
		}
		if(invesObjLengt.equals("")){
			invesObj.setInvesObjLengt(null);
		}else{
			invesObj.setInvesObjLengt(invesObjLengt);
		}
		invesObj.setIsMustCollData(isMus);
		if(invesObjNote.equals("")){
			invesObj.setInvesObjNote(null);
		}else{
			invesObj.setInvesObjNote(invesObjNote);
		}
		
		
	//	String dirName = "D:/InvesObjFile1/";
   //     CreateFileUtil.createDir(dirName+invesObjName+invesObjCode);
		invesObjDAO.save(invesObj);
		return true;
		}else{
			return false;
		}
	
								
	}
	//删除
	public String delInvesObj(Integer invesObjID){
		// TODO Auto-generated method stub
		InvesObj invesObj = new InvesObj();
		invesObj = invesObjDAO.findById(invesObjID);
	
		
		String message = "";
		
		
		//int num = invgatdao.findById(id);
		List<EvalContInvesObj> em= evalContInvesObjDAO.findByProperty("invesObj.invesObjId", invesObjID);
		List iod = invesObjDataDAO.findByProperty("invesObj.invesObjId", invesObjID);
		List vfd = vilFilDataDAO.findByProperty("invesObj.invesObjId", invesObjID);

		if (em.size()>0) {
			message = "评价方法属性值已引用调查对象编号为"+invesObj.getInvesObjCode()+"的对象，无法删除！\n";
		} else if(iod.size()>0){
			message = "调查员分工已引用调查对象编号为"+invesObj.getInvesObjCode()+"的对象，无法删除！\n";
		}else if(vfd.size()>0){
			message = "村庄文件数据已引用调查对象编号为"+invesObj.getInvesObjCode()+"的对象，无法删除！\n";
		}
		else{
			invesObjDAO.delete(invesObj);
			message = "调查对象编号为"+invesObj.getInvesObjCode()+"的对象，删除成功！\n";
		}
			
		return message;
	}

	public InvesObjDAO getInvesObjDAO() {
		return invesObjDAO;
	}

	public void setInvesObjDAO(InvesObjDAO invesObjDAO) {
		this.invesObjDAO = invesObjDAO;
	}

	public DataCollDataDicDAO getDataCollDataDicDAO() {
		return dataCollDataDicDAO;
	}

	public void setDataCollDataDicDAO(DataCollDataDicDAO dataCollDataDicDAO) {
		this.dataCollDataDicDAO = dataCollDataDicDAO;
	}

	public InvesObjAttriDAO getInvesObjAttriDAO() {
		return invesObjAttriDAO;
	}

	public void setInvesObjAttriDAO(InvesObjAttriDAO invesObjAttriDAO) {
		this.invesObjAttriDAO = invesObjAttriDAO;
	}
	
		
	
	
	
		
	}

	

