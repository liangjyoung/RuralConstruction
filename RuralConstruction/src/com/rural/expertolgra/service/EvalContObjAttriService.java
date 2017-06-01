package com.rural.expertolgra.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.rural.bean.EvalContInvesObj;
import com.rural.bean.InvesObjData;
import com.rural.dao.EvalExpertDistDAO;
import com.rural.dao.EvalContInvesObjDAO;
import com.rural.dao.InvesObjDataDAO;
import com.rural.dao.VilDataCollRecDAO;
import com.rural.expertolgra.action.EvalContObjAttriAction;
import com.rural.tool.Criterion;

public class EvalContObjAttriService implements IEvalContObjAttriService {
	
	private EvalContInvesObjDAO evalContInvesObjDAO = new EvalContInvesObjDAO();
	private EvalExpertDistDAO evalExpertDistDAO = new EvalExpertDistDAO();
	private InvesObjDataDAO invesObjDataDAO = new InvesObjDataDAO();
	private VilDataCollRecDAO vilDataCollRecDAO = new VilDataCollRecDAO();

	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from, int length) {
		// TODO Auto-generated method stub
		//获得EvalContID对应的所有“调查对象”
		String sql = "EvalContID = " + EvalContObjAttriAction.getEvalContID();
		List<Object> values = null;
		if (criteria != null) {
			sql = Criterion.convertToSql(criteria);
			values = Criterion.getCriteriaValues(criteria);
		}
		List<EvalContInvesObj> methObjs = new ArrayList<EvalContInvesObj>();
		methObjs = this.evalContInvesObjDAO.findByConditionAndPager(sql, values, from, length);
		
		//根据expertDistID得到所有的“村庄数据采集记录”
		Integer vilDataCollRecID = this.evalExpertDistDAO.findById(EvalContObjAttriAction.getExpertDistID()).getVilEvalSco().getVilDataCollRec().getVilDataCollRecId();
		String sql_1 = "VilDataCollRecID = " + vilDataCollRecID;
		//根据调查对象ID（InvesObjId）和村庄数据采集记录ID（VilDataCollRecID）查询到调查对象数据
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		for(EvalContInvesObj methObj: methObjs){
			List<InvesObjData> objDatas = new ArrayList<InvesObjData>(); 
			String sql_2 = sql_1 + " and InvesObjId = '" + methObj.getInvesObj().getInvesObjId() + "'";
			objDatas = this.invesObjDataDAO.findByConditionAndPager(sql_2, values, from, length);
			//findByProperty("invesObj.invesObjId", methObj.getInvesObj().getInvesObjId());
			for(InvesObjData objData: objDatas){
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("InvesObjDataId", objData.getInvesObjDataId());
				map.put("InvesObjName", methObj.getInvesObj().getInvesObjName());
				map.put("InvesObjAttri", methObj.getInvesObj().getInvesObjAttri().getInvesObjAttriName());
				map.put("InvesObjDataValu", objData.getInvesObjDataValu());
				map.put("InvesObjNote", objData.getInvesObjNote());
				result.add(map);
			}
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public int queryResultsCount(Object object) {
		// TODO Auto-generated method stub
		//获得EvalContID对应的所有“调查对象”
		String sql = "InvesObjID in (";
		List<EvalContInvesObj> methObjs = new ArrayList<EvalContInvesObj>();
		methObjs = this.evalContInvesObjDAO.findByProperty("evalCont.evalContId", EvalContObjAttriAction.getEvalContID());
		for(EvalContInvesObj methObj : methObjs){
			sql += ("'" + methObj.getInvesObj().getInvesObjId() + "',"); 
		}
		sql += "'')";
		//根据expertDistID得到所有的“村庄数据采集记录”
		Integer vilDataCollRecID = this.evalExpertDistDAO.findById(EvalContObjAttriAction.getExpertDistID()).getVilEvalSco().getVilDataCollRec().getVilDataCollRecId();
		sql += " and VilDataCollRecID = " + vilDataCollRecID;
		//根据调查对象ID（InvesObjId）和村庄数据采集记录ID（VilDataCollRecID）查询到调查对象数据
		return invesObjDataDAO.getCounts(sql);
	}

	public EvalContInvesObjDAO getEvalContInvesObjDAO() {
		return evalContInvesObjDAO;
	}

	public void setEvalContInvesObjDAO(EvalContInvesObjDAO evalContInvesObjDAO) {
		this.evalContInvesObjDAO = evalContInvesObjDAO;
	}

	public EvalExpertDistDAO getEvalExpertDistDAO() {
		return evalExpertDistDAO;
	}

	public void setEvalExpertDistDAO(EvalExpertDistDAO evalExpertDistDAO) {
		this.evalExpertDistDAO = evalExpertDistDAO;
	}

	public InvesObjDataDAO getInvesObjDataDAO() {
		return invesObjDataDAO;
	}

	public void setInvesObjDataDAO(InvesObjDataDAO invesObjDataDAO) {
		this.invesObjDataDAO = invesObjDataDAO;
	}

	public VilDataCollRecDAO getVilDataCollRecDAO() {
		return vilDataCollRecDAO;
	}

	public void setVilDataCollRecDAO(VilDataCollRecDAO vilDataCollRecDAO) {
		this.vilDataCollRecDAO = vilDataCollRecDAO;
	}

}
