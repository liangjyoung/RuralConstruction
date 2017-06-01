package com.rural.basicdata.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.basicdata.service.IEvalSystStateService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class EvalSystStateAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private IEvalSystStateService iEvalSystStateService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String evalSystStateNum;
	private String evalSystStateDes;
	private String id;
	public IEvalSystStateService getiEvalSystStateService() {
		return iEvalSystStateService;
	}
	public void setiEvalSystStateService(IEvalSystStateService iEvalSystStateService) {
		this.iEvalSystStateService = iEvalSystStateService;
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
	public String getEvalSystStateNum() {
		return evalSystStateNum;
	}
	public void setEvalSystStateNum(String evalSystStateNum) {
		this.evalSystStateNum = evalSystStateNum;
	}
	public String getEvalSystStateDes() {
		return evalSystStateDes;
	}
	public void setEvalSystStateDes(String evalSystStateDes) {
		this.evalSystStateDes = evalSystStateDes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String manageEvalSystState(){
		if(!search){
			if ("add".equals(oper)) {//����
				addEvalSystState();
			} else if ("search".equals(oper)) {//����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//ɾ��
				delEvalSystState();
			}else if("edit".equals(oper)){//�޸�
				updateEvalSystState();
			}
		}else{//��ѯ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	public String updateEvalSystState() {
		// TODO Auto-generated method stub
		iEvalSystStateService.updateEvalSystState(Integer.parseInt(id), evalSystStateNum,evalSystStateDes);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delEvalSystState() {
		// TODO Auto-generated method stub
		String message="";
		for(String evalSystState: id.split(",")){
			
			message= message+ iEvalSystStateService.delEvalSystState(Integer.parseInt(evalSystState));
		}
		
		dataMap.put("success", message);
	    return SUCCESS;
	}

	public String addEvalSystState() {
		// TODO Auto-generated method stub
		iEvalSystStateService.addEvalSystState(evalSystStateNum, evalSystStateDes);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	
	//判断评价体系状态编码是否重复
	public String checkEvalSystStateNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(id.equals("undefined"))id=null;//若id未定义则给其赋值为null
				boolean flag = iEvalSystStateService.checkEvalSystStateNum(evalSystStateNum,id);
				if(flag){
					dataMap.put("success", true);
				}else{
					dataMap.put("success", false);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * ����������Ӧ���
	 */
	public void responseData(){
		dataMap.put("page", page);
		dataMap.put("total", total);
		dataMap.put("records", records);
		dataMap.put("data", results);
	}

	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iEvalSystStateService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iEvalSystStateService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iEvalSystStateService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iEvalSystStateService.queryByPage(criteria, from, length);
		return results;
	}
}
