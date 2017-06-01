package com.rural.expertevalmanager.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rural.bean.EvalExpertDist;

import com.rural.bean.EvalCont;
import com.rural.bean.EvalContSubSco;
import com.rural.bean.EvalSystInd;
import com.rural.bean.ExpertGra;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalExpertDistDAO;

import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.ExpertGraDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.evalsystem.action.EvalMethObjAction;
import com.rural.expertevalmanager.action.ExpertEvalAction;
import com.rural.tool.Criterion;

public class ExpertEvalService implements IExpertEvalService{
	
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private EvalExpertDistDAO evalExpertDistDAO = new EvalExpertDistDAO();//
	//private EvalMethSubScoDAO evalMethSubScoDAO = new EvalMethSubScoDAO();
	private ExpertGraDAO expertGraDAO = new ExpertGraDAO();
	private EvalContSubScoDAO evalContSubScoDAO = new EvalContSubScoDAO();
	
	
	
	public EvalContSubScoDAO getEvalContSubScoDAO() {
		return evalContSubScoDAO;
	}

	public void setEvalContSubScoDAO(EvalContSubScoDAO evalContSubScoDAO) {
		this.evalContSubScoDAO = evalContSubScoDAO;
	}

	public ExpertGraDAO getExpertGraDAO() {
		return expertGraDAO;
	}

	public void setExpertGraDAO(ExpertGraDAO expertGraDAO) {
		this.expertGraDAO = expertGraDAO;
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

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		
		
		String vilrecid = "";
		String vilno = ExpertEvalAction.getTreeIDs();
		int vilnum = 0;
		List<VilBasicInfo> villist = this.vilBasicInfoDAO.findByVilNum(vilno);
		for (VilBasicInfo object : villist) {
			vilnum = object.getVilBasicInfoId();
		}
		
		//在采集记录表中查询一个村庄的记录（可能有多条）
		List <VilDataCollRec> vilreclist = this.vilDataCollRecDAO.findByProperty("vilBasicInfo.vilBasicInfoId", vilnum);
		if (vilreclist.size()>0) {
			for (VilDataCollRec vilDataCollRec : vilreclist) {
				vilrecid = vilrecid + vilDataCollRec.getVilDataCollRecId()+",";
			}
			vilrecid = vilrecid.substring(0, vilrecid.lastIndexOf(","));
			sql = " vilDataCollRec.vilDataCollRecId in ("+vilrecid+")";
			
		} else {
			sql = " vilDataCollRec.vilDataCollRecId is null";
		}
		
		List<VilEvalSco> list2 = new ArrayList<VilEvalSco>();
		list2 = this.vilEvalScoDAO.findByConditionAndPager(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (VilEvalSco b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("VilEvalScoID", b.getVilEvalScoId());
			if (b.getVilDataCollRec() == null) {
				map.put("VilEvalRecID", null);
			} else {
				map.put("VilEvalRecID", b.getVilDataCollRec().getVilDataCollRecId());
			}
			
			if (b.getVilDataCollRec() == null) {
				map.put("CollTim", null);
			} else if (b.getVilDataCollRec().getCollTim() ==null) {
				map.put("CollTim", null);
			} else {
				map.put("CollTim", b.getVilDataCollRec().getCollTim().toString().substring(0, 4)+"年度");
			}
			
		
			int a = b.getVilEvalScoId();
			List<EvalContSubSco> evallist =  evalContSubScoDAO.findByProperty("vilEvalSco.vilEvalScoId", a);
			if (evallist.size()>0) {
				int c = 0;
				for (EvalContSubSco evalContSubSco : evallist) {
					if (evalContSubSco.getExpertEvalContTotGra() == null) {
						c =  c + 0;
					} else {
						c =  c + Integer.parseInt(evalContSubSco.getExpertEvalContTotGra().trim());
						
					}
					
				}
				b.setExpertEvalTotGra(c+"");
				vilEvalScoDAO.merge(b);
		
				
				map.put("ExpertEvalTotGra", c);
			} else {
				map.put("ExpertEvalTotGra", 0);
			}
			
			
			/*
			int a = b.getVilEvalScoId();
			List<EvalExpertDist> lst = evalExpertDistDAO.findByProperty("vilEvalSco.vilEvalScoId", a);
			int c = 0;
			for (EvalExpertDist evalExpertDist : lst) {
				
				if(evalExpertDist.getIsSub()){
					c++;
					continue;
				}else {
					break;
				}
			}
			if(c==0){
				map.put("ExpertEvalTotGra", 0);
			}else if (c == lst.size()) {
				map.put("ExpertEvalTotGra", getTotal(a));
			} else {
				map.put("ExpertEvalTotGra", 0);
			}*/
			
			if (b.getAutoEvalTotGra() == null) {
				map.put("AutoEvalTotGra", 0);
			} else {
				map.put("AutoEvalTotGra", b.getAutoEvalTotGra());
			}
			if (b.getVilEvalTotGra() == null) {
				map.put("VilEvalTotGra", 0);
			} else {
				map.put("VilEvalTotGra", b.getVilEvalTotGra());
			}
			if (b.getVilDataCollRec() == null) {
				map.put("InvgatName", null);
			} else if (b.getVilDataCollRec().getInvgat() == null) {
				map.put("InvgatName", null);
			} else if (b.getVilDataCollRec().getInvgat().getInvgatName() == null) {
				map.put("InvgatName", null);
			} else {
				map.put("InvgatName", b.getVilDataCollRec().getInvgat().getInvgatName());
			}		
			
			result.add(map);
		}

		return result;
	}

	/*
	public int getTotal(int a){
		
		int subs = 0;
		List<EvalExpertDist> evaldis = evalExpertDistDAO.findByProperty("vilEvalSco.vilEvalScoId", a);
		
		List<EvalMethSubSco> elist = evalMethSubScoDAO.findByProperty("vilEvalSco.vilEvalScoId", a);
		for (EvalMethSubSco evalMethSubSco : elist) {
			int evaid = evalMethSubSco.getEvalMeth().getEvalMethId();
			
			List<ExpertGra> lst = expertGraDAO.findByEvalMethId(evaid);//得到所有的评价方法合计分中方法id与专家打分中方法id
			for (ExpertGra expertGra : lst) {
				
				for (EvalExpertDist expertDis : evaldis) {
					int expertdis = expertDis.getEvalExpertDistId();
					int expertgra = expertGra.getEvalExpertDist().getEvalExpertDistId();
					if ( expertdis == expertgra) {
						subs = subs + Integer.parseInt(expertGra.getSco());
					} 
				}
				
			
			}
			
		}
		return subs;
	}
	
	*/
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		List<Object> values = null;
		sql = " EvalMethID = "+EvalMethObjAction.getEvalMethObjIDS();
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		
		String vilrecid = "";
		String vilno = ExpertEvalAction.getTreeIDs();
		int vilnum = 0;
		List<VilBasicInfo> villist = this.vilBasicInfoDAO.findByVilNum(vilno);
		for (VilBasicInfo object : villist) {
			vilnum = object.getVilBasicInfoId();
		}
		
		//在采集记录表中查询一个村庄的记录（可能有多条）
		List <VilDataCollRec> vilreclist = this.vilDataCollRecDAO.findByProperty("vilBasicInfo.vilBasicInfoId", vilnum);
		if (vilreclist.size()>0) {
			for (VilDataCollRec vilDataCollRec : vilreclist) {
				vilrecid = vilrecid + vilDataCollRec.getVilDataCollRecId()+",";
			}
			vilrecid = vilrecid.substring(0, vilrecid.lastIndexOf(","));
			sql = " vilDataCollRec.vilDataCollRecId in ("+vilrecid+")";
			
		} else {
			sql = " vilDataCollRec.vilDataCollRecId is null";
		}
		
		int rows = this.vilEvalScoDAO.getCounts(sql, values);
		return rows;
	}

	
	
	public VilEvalScoDAO getVilEvalScoDAO() {
		return vilEvalScoDAO;
	}

	public void setVilEvalScoDAO(VilEvalScoDAO vilEvalScoDAO) {
		this.vilEvalScoDAO = vilEvalScoDAO;
	}

	public String autoEvalScore(String VilRecID,String VilRecIDs) {
		// TODO Auto-generated method stub
		String message="";
		
		int recid = Integer.parseInt(VilRecID);//记录ID
		int recids = Integer.parseInt(VilRecIDs);//评价得分ID
		int sub = 0;
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Connection conn=session.connection();
			CallableStatement proc = conn.prepareCall("{call proc_autoScore(?,?,?)}");
			
			
			List<EvalContSubSco> contSubScoslist = evalContSubScoDAO.findByProperty("vilEvalSco.vilEvalScoId",recids);
			if (contSubScoslist.size()>0) {
				for (EvalContSubSco evalContSubSco : contSubScoslist) {
					int evalid = evalContSubSco.getEvalCont().getEvalContId();
					proc.setInt(1,evalid); 
					proc.setInt(2,recid); 
					proc.registerOutParameter(3,java.sql.Types.NVARCHAR);
					proc.execute();
					String evalcontscore =proc.getString(3);
					List<EvalContSubSco> subSco = evalContSubScoDAO.findByContScore(recids, evalid);
					for (EvalContSubSco evalContSubSco2 : subSco) {
						
						evalContSubSco2 = evalContSubScoDAO.findById(evalContSubSco2.getEvalScoId());
						evalContSubSco2.setAutoEvalSco(evalcontscore);
						evalContSubScoDAO.merge(evalContSubSco2);
					}
					
					sub = sub + Integer.parseInt(evalcontscore);
				}
				proc.close();
				conn.close();
				session.close();
				sf.close();
				message = "自评成功";
			} else {
				message = "该记录未在自评体系中，无法自评";
			}
		} catch (Exception e) {
			// TODO: handle exception
			message = "无法与数据连接，自评失败";
			e.printStackTrace();
		}
		
		VilEvalSco vilEvalSco = new VilEvalSco();
		vilEvalSco = vilEvalScoDAO.findById(recids);
		vilEvalSco.setAutoEvalTotGra(sub+"");
		vilEvalScoDAO.merge(vilEvalSco);
		
		
		
		//dataCollRec = vilDataCollRecDAO.findById(id);
		return message;
	}

}
