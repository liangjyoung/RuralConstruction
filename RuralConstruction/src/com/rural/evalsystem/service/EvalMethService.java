package com.rural.evalsystem.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import com.rural.bean.EvalCont;
import com.rural.bean.EvalContInvesObj;
import com.rural.bean.EvalContSubSco;
import com.rural.bean.EvalSystInd;
import com.rural.bean.ExamMeth;
import com.rural.bean.ExpertGra;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.EvalSystIndDAO;
import com.rural.dao.ExamMethDAO;
import com.rural.dao.ExpertGraDAO;
import com.rural.evalsystem.action.EvalMethAction;
import com.rural.tool.Criterion;

public class EvalMethService implements IEvalMethService{
 
	private EvalContDAO evalMethDAO = new EvalContDAO();
	private EvalSystIndDAO evalSystIndDAO = new EvalSystIndDAO();
	private ExamMethDAO examMethDAO = new ExamMethDAO();
	private EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
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

	public EvalSystIndDAO getEvalSystIndDAO() {
		return evalSystIndDAO;
	}

	public void setEvalSystIndDAO(EvalSystIndDAO evalSystIndDAO) {
		this.evalSystIndDAO = evalSystIndDAO;
	}



	public EvalContDAO getEvalMethDAO() {
		return evalMethDAO;
	}

	public void setEvalMethDAO(EvalContDAO evalMethDAO) {
		this.evalMethDAO = evalMethDAO;
	}

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		String Fss = EvalMethAction.getEvalFSysIDs().trim();
		String ss =  EvalMethAction.getEvalSysIDs().trim();
		if(Fss.equals("hh")){
			sql = " EvalIndNum = '"+EvalMethAction.getEvalSysIDs()+"'";
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
		//from1 = list2.size()+1;
		for (EvalCont xt : list2) {
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
			if (xt.getEvalContScore() == null) {
				map.put("EvalContScore",null);
			} else {
				map.put("EvalContScore",xt.getEvalContScore());
			}
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
	String Fss = EvalMethAction.getEvalFSysIDs().trim();
	String ss =  EvalMethAction.getEvalSysIDs().trim();
	if(Fss.equals("hh")){
		sql = " EvalIndNum = '"+EvalMethAction.getEvalSysIDs()+"'";
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

	public String addEvalCont(String EvaSID, String EvalContSeqNum,
			String EvalContDes, String EvalContScore, String IsSubjGra,
			String ExamMethID, String EvalContNote) {
		// TODO Auto-generated method stub
		String message = "";
		EvalSystInd evalSystInd = new EvalSystInd();
		evalSystInd = evalSystIndDAO.findById(EvaSID);
		
		if (evalSystInd == null) {
			message = "请先选择评价指标！";
		} else {
			
			List<EvalCont> evalConts = evalMethDAO.findByEvalContSeqNum(EvalContSeqNum);
			if (evalConts.size()>0) {
				message = "分序号已存在";
			}else{
				EvalCont evalCont = new EvalCont();
				evalCont.setEvalContSeqNum(EvalContSeqNum);//1
				evalCont.setEvalSystInd(evalSystInd);//2
				evalCont.setEvalContDes(EvalContDes);//3
				evalCont.setEvalContNote(EvalContNote);//4
				evalCont.setEvalContScore(EvalContScore);//5
				ExamMeth examMeth = new ExamMeth();
				examMeth = examMethDAO.findById(Integer.parseInt(ExamMethID));
				evalCont.setExamMeth(examMeth);//6
				evalCont.setSubjObjecValu(IsSubjGra);//7
				EvalCont evalCont2 = new EvalCont();
				List<EvalCont> contlist = evalMethDAO.findByProperty("evalSystInd.evalIndNum", EvaSID);
				if (contlist.size()>0) {
					int m = 0;
					String aa = EvaSID.substring(0, 12);
					for (EvalCont evalCont3 : contlist) {
						String evaString = evalCont3.getEvalContNum();
						String ss[]=evaString.split("\\.");
						int ma = Integer.parseInt(ss[ss.length-1]);
						if (ma>m) {
							m = ma;
						} 
					}
					m = m + 1;
					if (m<10) {
						aa = aa +"0"+m;
						evalCont.setEvalContNum(aa);
						evalMethDAO.save(evalCont);
					} else {
						aa = aa + m;
						evalCont.setEvalContNum(aa);
						evalMethDAO.save(evalCont);
					}
			} else {
				String aa = EvaSID.substring(0, 12);
				aa = aa +"01";
				evalCont.setEvalContNum(aa);
				evalMethDAO.save(evalCont);
			}
				message = "successful";
		}
			}
		
		return message;
	}

	public void setExamMethDAO(ExamMethDAO examMethDAO) {
		this.examMethDAO = examMethDAO;
	}

	public ExamMethDAO getExamMethDAO() {
		return examMethDAO;
	}

	public String editEvalCont(String EvalContId, 
			String EvalContSeqNum, String EvalContDes, String EvalContScore,
			String IsSubjGra, String ExamMethID, String EvalContNote) {
		// TODO Auto-generated method stub
		String message = "";
		int EvalContIds = Integer.parseInt(EvalContId);
		EvalCont evalCont = new EvalCont();
		List<EvalCont> evalConts = evalMethDAO.findByEvalContSeqNum(EvalContSeqNum);
		if (evalConts.size()>0) {
			for (EvalCont evalC : evalConts) {
				
				if (evalC.getEvalContId()==EvalContIds) {
					evalCont = evalMethDAO.findById(EvalContIds);
					evalCont.setEvalContSeqNum(EvalContSeqNum);//1
					evalCont.setEvalContDes(EvalContDes);//3
					evalCont.setEvalContNote(EvalContNote);//4
					evalCont.setEvalContScore(EvalContScore);//5
					evalCont.setSubjObjecValu(IsSubjGra);//7
					
					ExamMeth examMeth = new ExamMeth();
					examMeth = examMethDAO.findById(Integer.parseInt(ExamMethID));
					evalCont.setExamMeth(examMeth);
					evalMethDAO.merge(evalCont);
					message = "successful";
				} else {
					message = "分序号已存在";
				}
			}
			
		} else {
			evalCont = evalMethDAO.findById(EvalContIds);
			evalCont.setEvalContSeqNum(EvalContSeqNum);//1
			evalCont.setEvalContDes(EvalContDes);//3
			evalCont.setEvalContNote(EvalContNote);//4
			evalCont.setEvalContScore(EvalContScore);//5
			evalCont.setSubjObjecValu(IsSubjGra);//7
			
			ExamMeth examMeth = new ExamMeth();
			examMeth = examMethDAO.findById(Integer.parseInt(ExamMethID));
			evalCont.setExamMeth(examMeth);
			evalMethDAO.merge(evalCont);
			message = "successful";
			
		}
		return message;
	}

	public String delEvalCont(String EvalContId) {
		// TODO Auto-generated method stub
		String message = "";
		int EvalID = Integer.parseInt(EvalContId);
		EvalCont evalCont = new EvalCont();
		evalCont = evalMethDAO.findById(EvalID);
		List<EvalContInvesObj> contInvesObjs = evalContInvesObjDAO.findByProperty("evalCont.evalContId", EvalID);
		List<ExpertGra> expertGras =  expertGraDAO.findByEvalContId(EvalID);
		List<EvalContSubSco> contSubScos = evalContSubScoDAO.findByProperty("evalCont.evalContId", EvalID);
		if (contInvesObjs.size()>0) {
			message = "A";
		} else if (expertGras.size()>0) {
			message = "B";
		} else if (contSubScos.size()>0) {
			message = "C";
		} else {
			evalMethDAO.delete(evalCont);
			message = "删除成功";
		}
		
		return message;
	}

	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}
	
}
