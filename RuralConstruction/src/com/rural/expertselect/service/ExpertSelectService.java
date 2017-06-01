package com.rural.expertselect.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



import org.apache.struts2.ServletActionContext;


import com.rural.bean.EvalExpertDist;
import com.rural.bean.Expert;
import com.rural.bean.RoleFuncPerm;
import com.rural.bean.SysRoleUser;
import com.rural.bean.SysUser;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalExpertDistDAO;
import com.rural.dao.ExpertDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;

import com.rural.tool.Criterion;
import com.rural.tool.EncoderHandler;
import com.rural.expertselect.action.ExpertSelectAction;


public class ExpertSelectService implements IExpertSelectService{

	
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	private ExpertDAO expertDAO = new ExpertDAO(); 
	private EvalExpertDistDAO evalExpertDistDAO = new EvalExpertDistDAO(); 
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	 
	
	
	
	public String delexpertsel(String EvalExpertDistID){
		String message = "";
		EvalExpertDist ed = evalExpertDistDAO.findById(Integer.parseInt(EvalExpertDistID));
		//根据分配id找到该专家
		//Expert ep = expertDAO.findById(ed.getExpert().getExpertId());
		boolean IsSub = ed.getIsSub();
		if(IsSub){
	    	message = "该专家已经进行评价打分，不可删除！\n";
	    }else{
	    	evalExpertDistDAO.delete(ed);
	    	message = "专家姓名为"+ed.getExpert().getExpertName()+"的对象，删除成功！\n";
	    }
		
		return message;
	}
	
	public String modify(Integer dfid,String allid){
		String message="";
		IsItem();
		Integer vv = ExpertSelectAction.getDfid();
		//根据得分id得到分配表中的记录
		if(vv!=null){//如果有采集记录
			VilEvalSco vis = new VilEvalSco();
			vis.setVilEvalScoId(new Integer(ExpertSelectAction.getDfid()));
			
			Expert expt = new Expert();
			expt = expertDAO.findById(Integer.parseInt(allid));
			boolean IsSub = false;
			
			List <EvalExpertDist> evalExpertDistList = this.evalExpertDistDAO.findByProperty("vilEvalSco.vilEvalScoId",vis.getVilEvalScoId());
			int yy =evalExpertDistList.size() ;
			if(evalExpertDistList.size()>0){
				for (EvalExpertDist evalExpertDist : evalExpertDistList) {
					if((evalExpertDist.getExpert().getExpertNum()).equals(expt.getExpertNum())){
						message = "专家姓名为："+expt.getExpertName()+"的专家已经分配到该村，不用进行重复分配\n";
						break;
					}else{
						yy--;

					}
					
					
				}
				if(yy == 0){
					EvalExpertDist evalExpertDist2 = new EvalExpertDist();
					evalExpertDist2.setExpert(expt);
					evalExpertDist2.setVilEvalSco(vis);
					evalExpertDist2.setIsSub(IsSub);
					this.evalExpertDistDAO.save(evalExpertDist2);
					message="专家姓名为："+expt.getExpertName()+"的专家分配成功\n";
				}
				
				
			}else{
				EvalExpertDist evalExpertDist3 = new EvalExpertDist();
				evalExpertDist3.setExpert(expt);
				evalExpertDist3.setVilEvalSco(vis);
				evalExpertDist3.setIsSub(IsSub);
				this.evalExpertDistDAO.save(evalExpertDist3);
				message="专家姓名为："+expt.getExpertName()+"的专家分配成功\n";
			}
			
		}else{
			message="该村没有采集记录，不能分配专家";
		}
		
		return message;
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		int rows = this.evalExpertDistDAO.getCounts(sql, values);
		// int rows = this.departmentadmindao.getCounts(sql, values);
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
		// List<DepartmentAdmin> list = new ArrayList<DepartmentAdmin>();
	
		List<EvalExpertDist> list2 = new ArrayList<EvalExpertDist>();
		  IsItem();
		 
		
		 
			list2 = this.evalExpertDistDAO.findByConditionAndPager2(sql, values, from,length);
			List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
			for (EvalExpertDist b : list2) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("EvalExpertDistID", b.getEvalExpertDistId());
				if (b.getExpert() == null) {
					map.put("ExpertID",null);
				} else {
					map.put("ExpertID", b.getExpert().getExpertId());
				}
				
				if (b.getExpert() == null) {
					map.put("ExpertNum",null);
				} else {
					map.put("ExpertNum", b.getExpert().getExpertNum());
				}
				
				if (b.getExpert() == null) {
					map.put("ExpertName",null);
				} else {
					map.put("ExpertName", b.getExpert().getExpertName());
				}
				
				if (b.getExpert() == null) {
					map.put("ExpertMobTel",null);
				} else {
					map.put("ExpertMobTel", b.getExpert().getExpertMobTel());
				}
			
				result.add(map);
				
			}

			return result;
	
	}

	public void IsItem() {
		Integer cc = getVilId(ExpertSelectAction.JQS);
		Integer newid=0;//记录某一村庄的最新采集记录的id
		
		
		 String data1 =  BigeDate().toString().substring(0, 4);//获得村庄-数据-采集-记录最大的时间
		 List<VilDataCollRec> vilD = vilDataCollRecDAO.findByProperty("vilBasicInfo.vilBasicInfoId",cc );//根据村庄ID获取村庄-数据-采集-记录
		for (VilDataCollRec vilDataCollRec : vilD) {
		
			String  data2 =  vilDataCollRec.getCollTim().toString().substring(0, 4);//某一村庄的采集时间的年份
			if(data1.equals(data2)){//有最新采集记录
				
				//获得最新采集记录的id
				newid = vilDataCollRec.getVilDataCollRecId();			
				break;
			}
			
		}
		
		//根据最新采集记录的id找到村庄评价得分id
		if(newid!=0){
			 List<VilEvalSco> vieD = vilEvalScoDAO.findByProperty("vilDataCollRec.vilDataCollRecId",newid );
			for (VilEvalSco vilEvalSco : vieD) {
				ExpertSelectAction.setDfid(vilEvalSco.getVilEvalScoId());
			}
			 
		}else{//没有采集信息
			ExpertSelectAction.setDfid(null);
		}
	}

	public Date BigeDate() {
		List<VilDataCollRec> vi = vilDataCollRecDAO.findAll();
		Date a = new Date();
		Date b = new Date();
		for (VilDataCollRec vilDataCollRec : vi) {
			 b = a;
			 a = vilDataCollRec.getCollTim();			
			if(a.before(b)){
				b=a;
			}
		}
		return b;
	}

	public Integer getVilId(String num) {
		Integer id=0 ;
		List<VilBasicInfo> vb= vilBasicInfoDAO.findByVilNum(num);
		for (VilBasicInfo vilBasicInfo : vb) {
			id = vilBasicInfo.getVilBasicInfoId();
		}
		return id;
	}

	public VilEvalScoDAO getVilEvalScoDAO() {
		return vilEvalScoDAO;
	}

	public void setVilEvalScoDAO(VilEvalScoDAO vilEvalScoDAO) {
		this.vilEvalScoDAO = vilEvalScoDAO;
	}

	public ExpertDAO getExpertDAO() {
		return expertDAO;
	}

	public void setExpertDAO(ExpertDAO expertDAO) {
		this.expertDAO = expertDAO;
	}

	public EvalExpertDistDAO getEvalExpertDistDAO() {
		return evalExpertDistDAO;
	}

	public void setEvalExpertDistDAO(EvalExpertDistDAO evalExpertDistDAO) {
		this.evalExpertDistDAO = evalExpertDistDAO;
	}

	public VilDataCollRecDAO getVilDataCollRecDAO() {
		return vilDataCollRecDAO;
	}

	public void setVilDataCollRecDAO(VilDataCollRecDAO vilDataCollRecDAO) {
		this.vilDataCollRecDAO = vilDataCollRecDAO;
	}

	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}

	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}
	
	
}
