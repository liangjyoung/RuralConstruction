package com.rural.evalsystem.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.rural.bean.EvalCont;
import com.rural.dao.EvalContDAO;
import com.rural.dao.EvalSystIndDAO;
import com.rural.evalsystem.service.IEvalMethService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;


public class EvalMethAction extends JqGridBaseAction{
	
	private static final long serialVersionUID = 1L;
	private IEvalMethService evalMethService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String EvaSID;
	private String EvaFSID;
	private static String EvalSysIDs;
	private static String EvalFSysIDs;
	private String EvalContSeqNum ;
	private String EvalContDes;
	private String EvalContScore;
	private String IsSubjGra;
	private String ExamMethID;
	private String EvalContNote;
	private String EvalContId;
	private EvalContDAO evalContDAO = new EvalContDAO();
	
	
	
	public String getEvaFSID() {
		return EvaFSID;
	}
	public void setEvaFSID(String evaFSID) {
		EvaFSID = evaFSID;
	}

	public String getExamMethID() {
		return ExamMethID;
	}
	public void setExamMethID(String examMethID) {
		ExamMethID = examMethID;
	}
	
	public String getEvalContSeqNum() {
		return EvalContSeqNum;
	}
	public void setEvalContSeqNum(String evalContSeqNum) {
		EvalContSeqNum = evalContSeqNum;
	}
	public String getEvalContDes() {
		return EvalContDes;
	}
	public void setEvalContDes(String evalContDes) {
		EvalContDes = evalContDes;
	}
	public String getEvalContScore() {
		return EvalContScore;
	}
	public void setEvalContScore(String evalContScore) {
		EvalContScore = evalContScore;
	}
	public String getIsSubjGra() {
		return IsSubjGra;
	}
	public void setIsSubjGra(String isSubjGra) {
		IsSubjGra = isSubjGra;
	}

	public String getEvalContNote() {
		return EvalContNote;
	}
	public void setEvalContNote(String evalContNote) {
		EvalContNote = evalContNote;
	}
	
	public String aa(){
	dataMap.put("ss", "ss");
		return SUCCESS;
	}
	public String manageEvalMeth(){

		EvalMethAction.setEvalFSysIDs(EvaFSID);
		
		EvalMethAction.setEvalSysIDs(EvaSID);
	
		if(!search){
			if ("add".equals(oper)) {//增加
				addEvalCont();
			} else if ("search".equals(oper)) {//载入页面时查询
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//删除
				//delCountryBasicInfo();
				delEvalCont();
			}else if("edit".equals(oper)){//修改
				editEvalCont();
			}
		}else{//查询
			refreshGridModel();
			responseData();
		}
		
		return SUCCESS;
	}
	
	/**
	 * 打包服务器响应数据
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}
	
	
	
	
	public String addEvalCont(){
		String message = "";
		message = evalMethService.addEvalCont(EvaSID.trim(),EvalContSeqNum.trim(),EvalContDes.trim(),EvalContScore.trim(),IsSubjGra.trim(),ExamMethID.trim(),EvalContNote.trim());
		dataMap.put("success", message);
		return SUCCESS;
	}

	
	public String editEvalCont(){
		String message = "";
	
		message = evalMethService.editEvalCont(EvalContId.trim(),EvalContSeqNum.trim(),EvalContDes.trim(),EvalContScore.trim(),IsSubjGra.trim(),ExamMethID.trim(),EvalContNote.trim());
		
		//System.out.println("EvalContId:"+EvalContId+"-->EvalContSeqNum:"+EvalContSeqNum+"---->EvalContDes:"+EvalContDes+"---->EvalContScore:"+EvalContScore+"----->IsSubjGra:"+IsSubjGra+"-->ExamMethID:"+ExamMethID+"---->EvalContNote:"+EvalContNote+"---->EvalContId:"+EvalContId);
		
		dataMap.put("success", message);
		return SUCCESS;
	}
	public String delEvalCont(){
		String message = "";
		String message1 = "";
		String message2 = "";
		String message3 = "";
		String message4 ="";
		
		for (String a:EvalContId.split(",")) {
			EvalCont evalCont = new EvalCont();
			evalCont = evalContDAO.findById(Integer.parseInt(a));
			String aa ="";
			String me = evalCont.getEvalContSeqNum();
			
			aa = evalMethService.delEvalCont(a);
			if (aa.equals("删除成功")) {
				message1 = message1 +me+",";
			} else if (aa.equals("A")) {
				message2 = message2 +me+",";
			} else if (aa.equals("B")) {
				message3 = message3  +me+",";
			}else if(aa.equals("C")){
				message4 = message4+me+",";
			}
		}
		
		if (message2!="") {
			message2 = message2.substring(0, message2.lastIndexOf(","));
			message = message + "分序号为:"+message2+"的评价内容被调查对象分配结果表引用无法删除;";
		} 
		if(message3!=""){
			message3 = message3.substring(0, message3.lastIndexOf(","));
			message = message + "分序号为:"+message3+"的评价内容被专家打分表引用无法删除;";
		}
		if(message4!=""){
			message4 = message4.substring(0, message4.lastIndexOf(","));
			message = message + "分序号为:"+message4+"的评价内容被评价打分总表引用无法删除;";
		}
		if(message1!=""){
			message1 = message1.substring(0, message1.lastIndexOf(","));
			message = message + "分序号为:"+message1+"的评价内容删除成功;";
		}
		
		
		dataMap.put("success", message);
		return SUCCESS;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}


	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public void setEvalMethService(IEvalMethService evalMethService) {
		this.evalMethService = evalMethService;
	}

	public IEvalMethService getEvalMethService() {
		return evalMethService;
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.evalMethService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.evalMethService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.evalMethService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.evalMethService.queryByPage(criteria, from, length);
		return results;
	}

	public static String getEvalSysIDs() {
		return EvalSysIDs;
	}
	public static void setEvalSysIDs(String evalSysIDs) {
		EvalSysIDs = evalSysIDs;
	}
	public void setEvaSID(String evaSID) {
		EvaSID = evaSID;
	}
	public String getEvaSID() {
		return EvaSID;
	}
	public static void setEvalFSysIDs(String evalFSysIDs) {
		EvalFSysIDs = evalFSysIDs;
	}
	public static String getEvalFSysIDs() {
		return EvalFSysIDs;
	}

	public String getEvalContId() {
		return EvalContId;
	}
	public void setEvalContId(String evalContId) {
		EvalContId = evalContId;
	}
	public void setEvalContDAO(EvalContDAO evalContDAO) {
		this.evalContDAO = evalContDAO;
	}
	public EvalContDAO getEvalContDAO() {
		return evalContDAO;
	}
	

	
}
