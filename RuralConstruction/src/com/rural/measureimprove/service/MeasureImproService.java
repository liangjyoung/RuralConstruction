package com.rural.measureimprove.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalContSubSco;

import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.InvesObjDAO;
import com.rural.dao.PrmtMeasDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.measureimprove.action.MeasureImproAction;
import com.rural.tool.Criterion;

public class MeasureImproService implements IMeasureImproService{
	
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	private EvalContSubScoDAO evalContSubScoDAO = new EvalContSubScoDAO();
	private PrmtMeasDAO prmtMeasDAO = new PrmtMeasDAO();
	private InvesObjDAO invesObjDAO = new InvesObjDAO();
	private EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
	
	//vilDataCollRecDAO.f
	//（1）通过村庄ID得到采集记录中最新的该村庄的采集ID
	public int getVilRecID(){
		int villID = 0;
		int vilCollRecID = 0;
		List<VilBasicInfo> vilBasicInfoslist = vilBasicInfoDAO.findByVilNum(MeasureImproAction.getVilIDs());
		if (vilBasicInfoslist.size()>0) {
			for (VilBasicInfo vilBasicInfo : vilBasicInfoslist) {
				villID = vilBasicInfo.getVilBasicInfoId();
				break;
			}
		} else {
			vilCollRecID = 0;
		}
		
	
		List<VilDataCollRec> vilDataCollReclist = vilDataCollRecDAO.findVillRecByVillID(villID);
		if (vilDataCollReclist.size() > 0) {
			for (VilDataCollRec vilDataCollRec : vilDataCollReclist) {
				vilCollRecID = vilDataCollRec.getVilDataCollRecId();
				break;
			}
			//(2)根据采集记录ID得到所有的村庄评价得分
			List<VilEvalSco> vilEvalScoslist = vilEvalScoDAO.findByProperty("vilDataCollRec.vilDataCollRecId", vilCollRecID);
			if (vilEvalScoslist.size() > 0) {
				for (VilEvalSco vilEvalSco : vilEvalScoslist) {
					vilCollRecID = vilEvalSco.getVilEvalScoId();
					break;
				}
			} else {
				vilCollRecID = 0;
			}
		} else {
			vilCollRecID= 0;
		}
		return vilCollRecID;
	}
	
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		String sql = null;
		//sql = " model.vilEvalSco.vilEvalScoId = "+getVilRecID();evalContScore
		//sql="  modela.vilEvalSco.vilEvalScoId = "+getVilRecID();
		sql = " eval.evalCont.evalContId=cont.evalContId and eval.vilEvalSco.vilEvalScoId = "+getVilRecID()+"and CAST(cont.evalContScore as integer)>CAST(eval.autoEvalSco as integer)";
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<EvalContSubSco> list2 = new ArrayList<EvalContSubSco>();
		
		list2 = this.evalContSubScoDAO.findBytwopageandcon(sql, values, from, length);//(sql, values, from,length);
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for (EvalContSubSco b : list2) {
			HashMap<String, Object> map = new HashMap<String, Object>();
		//	map.put("oldCode", b.getInvesObjId());
			map.put("EvalScoID", b.getEvalScoId());
			map.put("VilEvalscoID", b.getVilEvalSco().getVilEvalScoId());
			if(b.getEvalCont()== null){
				map.put("evalContSeqNum", null);
				map.put("evalContDes", null);
				map.put("evalContScore", null);
			}else{
				map.put("evalContSeqNum",b.getEvalCont().getEvalContSeqNum());
				map.put("evalContDes",b.getEvalCont().getEvalContDes());
				map.put("evalContScore", b.getEvalCont().getEvalContScore());
			}
				map.put("autoEvalSco", b.getAutoEvalSco());
			/*
			if (b.getEvalCont()== null) {
				map.put("evalContScore", null);
				if (b.getAutoEvalSco() == null) {
					map.put("autoEvalSco",null);
				} else {
					map.put("autoEvalSco", b.getAutoEvalSco());
				}
				
			} else {
				if (b.getEvalCont().getEvalContScore() == null) {
					map.put("evalContScore", null);
					if (b.getAutoEvalSco() == null) {
						map.put("autoEvalSco",null);
					} else {
						map.put("autoEvalSco", b.getAutoEvalSco());
					}
				} else {
					map.put("evalContScore", b.getEvalCont().getEvalContScore());
					if (b.getAutoEvalSco() == null) {
						map.put("autoEvalSco",null);
					} else {
						evalcontscore = Integer.parseInt(b.getEvalCont().getEvalContScore());
						evalscored = Integer.parseInt(b.getAutoEvalSco());
						if (evalcontscore > evalscored) {
							map.put("autoEvalSco", b.getAutoEvalSco());
						} else {
							
							
							continue;
							
						}
					}
				}
			}
		*/
			
			result.add(map);
		}
		return result;
	}

	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		String sql = null;
		sql = " eval.evalCont.evalContId=cont.evalContId and eval.vilEvalSco.vilEvalScoId = "+getVilRecID()+"and CAST(cont.evalContScore as integer)>CAST(eval.autoEvalSco as integer) order by eval.evalCont.evalContId";
		int rows ;
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		rows = this.evalContSubScoDAO.getCountssss(sql, values);
		return rows;
	}

	public void setVilDataCollRecDAO(VilDataCollRecDAO vilDataCollRecDAO) {
		this.vilDataCollRecDAO = vilDataCollRecDAO;
	}

	public VilDataCollRecDAO getVilDataCollRecDAO() {
		return vilDataCollRecDAO;
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

	public PrmtMeasDAO getPrmtMeasDAO() {
		return prmtMeasDAO;
	}

	public void setPrmtMeasDAO(PrmtMeasDAO prmtMeasDAO) {
		this.prmtMeasDAO = prmtMeasDAO;
	}

	public InvesObjDAO getInvesObjDAO() {
		return invesObjDAO;
	}

	public void setInvesObjDAO(InvesObjDAO invesObjDAO) {
		this.invesObjDAO = invesObjDAO;
	}

	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}

	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

	public void setVilBasicInfoDAO(VilBasicInfoDAO vilBasicInfoDAO) {
		this.vilBasicInfoDAO = vilBasicInfoDAO;
	}

	public VilBasicInfoDAO getVilBasicInfoDAO() {
		return vilBasicInfoDAO;
	}

	

}
