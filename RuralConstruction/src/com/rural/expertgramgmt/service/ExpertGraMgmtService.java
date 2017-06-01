package com.rural.expertgramgmt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalContSubSco;
import com.rural.bean.VilBasicInfo;
import com.rural.bean.VilDataCollRec;
import com.rural.bean.VilEvalSco;
import com.rural.dao.EvalContSubScoDAO;
import com.rural.dao.VilBasicInfoDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.dao.VilEvalScoDAO;
import com.rural.expertgramgmt.action.ExpertGraMgmtAction;
import com.rural.tool.Criterion;

public class ExpertGraMgmtService implements IExpertGraMgmtService {
	private VilBasicInfoDAO vilBasicInfoDAO = new VilBasicInfoDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();
	private VilEvalScoDAO vilEvalScoDAO = new VilEvalScoDAO();
	private EvalContSubScoDAO evalContSubScoDAO = new EvalContSubScoDAO();

	public Integer getVilIdByVilNum(String vilNum) {
		// TODO Auto-generated method stub
		return ((VilBasicInfo)vilBasicInfoDAO.findByVilNum(vilNum).get(0)).getVilBasicInfoId();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from, int length) {
		List<VilDataCollRec> vilDataCollRecs = vilDataCollRecDAO.findByProperty("vilBasicInfo.vilBasicInfoId", ExpertGraMgmtAction.getVilId());
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		for(VilDataCollRec vilDataCollRec : vilDataCollRecs){
			List<VilEvalSco> vilEvalScos = vilEvalScoDAO.findByProperty("vilDataCollRec.vilDataCollRecId", vilDataCollRec.getVilDataCollRecId());
			for(VilEvalSco vilEvalSco : vilEvalScos){
				String sql = "VilEvalScoId = "+ vilEvalSco.getVilEvalScoId();
				List<Object> values = null;
				List<EvalContSubSco> evalContSubScos = evalContSubScoDAO.findByConditionAndPager(sql, values, from, length);
				for(EvalContSubSco evalContSubSco : evalContSubScos){
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("EvalScoId", evalContSubSco.getEvalScoId());//根据EvalScoId和EvalContId确定从表的显示内容
					map.put("EvalContId", evalContSubSco.getEvalCont().getEvalContId());
					map.put("EvalContDes", evalContSubSco.getEvalCont().getEvalContDes());
					map.put("ExpertEvalContTotGra", evalContSubSco.getExpertEvalContTotGra());
					map.put("Time", evalContSubSco.getVilEvalSco().getVilDataCollRec().getCollTim().getYear()+1900);
					result.add(map);
				}
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public int queryResultsCount(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		List<VilDataCollRec> vilDataCollRecs = vilDataCollRecDAO.findByProperty("vilBasicInfo.vilBasicInfoId", ExpertGraMgmtAction.getVilId());
		int sum = 0;
		for(VilDataCollRec vilDataCollRec : vilDataCollRecs){
			List<VilEvalSco> vilEvalScos = vilEvalScoDAO.findByProperty("vilDataCollRec.vilDataCollRecId", vilDataCollRec.getVilDataCollRecId());
			for(VilEvalSco vilEvalSco : vilEvalScos){
				sum += evalContSubScoDAO.findByProperty("vilEvalSco.vilEvalScoId", vilEvalSco.getVilEvalScoId()).size();
			}
		}
		return sum;
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

	public EvalContSubScoDAO getEvalContSubScoDAO() {
		return evalContSubScoDAO;
	}

	public void setEvalContSubScoDAO(EvalContSubScoDAO evalContSubScoDAO) {
		this.evalContSubScoDAO = evalContSubScoDAO;
	}

}
