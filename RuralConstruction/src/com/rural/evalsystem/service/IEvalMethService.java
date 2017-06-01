package com.rural.evalsystem.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.rural.tool.Criterion;



public interface IEvalMethService {
	public int queryResultsCount(List<Criterion> criteria);
	public List<HashMap<String, Object>> queryByPage(List<Criterion> criteria, int from,int length) ;
	public abstract String addEvalCont(String EvaSID, String EvalContSeqNum,String EvalContDes,String EvalContScore,String IsSubjGra,String ExamMethID,String EvalContNote);
	public abstract String editEvalCont(String EvalContId, String EvalContSeqNum,String EvalContDes,String EvalContScore,String IsSubjGra,String ExamMethID,String EvalContNote);
	public abstract String delEvalCont(String EvalContId);
}
