package com.rural.evalsystem.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


import com.rural.bean.EvalCont;
import com.rural.bean.EvalSyst;
import com.rural.bean.EvalSystInd;
import com.rural.bean.EvalSystState;
import com.rural.bean.ExpertMajorCatg;
import com.rural.bean.InvesPro;
import com.rural.tool.Criterion;

public interface IEvalSysService {
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length);
	public abstract List<EvalSystInd> getChildPermissions( String parentId ); 
	public String addEval(String evalNum,String evalName,String evalSco,String sv,String sc,String evalSystid);
	public List<EvalSystInd> findAllEval();
	public List<EvalSystInd> findSystIndByID(Integer EvalSystID2);
	public List<EvalCont> findEvalContByNum(String EvalIndNum);
	public List<EvalSyst> findAllEvalSys();
	public List<EvalSystState> findAllState(Integer EvalSysID);
	public List<ExpertMajorCatg> findAllEvmc();
	public String delEval(String EvalIndNum);
	public String delEvalsys(Integer EvalSystID);
	//public String copeSystInd(EvalSystInd evalSystInd, String newevalSysNum,EvalSyst newevalSyst) {//参数：评价指标，新的评价体系ID
	public String getUpNum(EvalSystInd evalSystInd);
	public String copeEvalCont(EvalCont evalCont,String EvalIndNum, Integer EvalSystID);
	public String addEvalsys(String EvalSystName,String Startime, String Endtime,String EvalSystNote);
	public String updateEvalsys(Integer EvalSystID,String EvalSystName,String Startime, String Endtime,String EvalSystNote);
	public abstract String copyEvalSys(String newEvalSysID, String oldEvalSysNum);
	public abstract String editState(String evalSystStateID, String editEvalSystID);
}
