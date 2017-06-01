package com.rural.basicdata.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rural.basicdata.service.IExpertMajorCatgService;
import com.rural.tool.Criterion;
import com.rural.tool.JqGridBaseAction;

public class ExpertMajorCatgAction extends JqGridBaseAction{

	private static final long serialVersionUID = 1L;
	private IExpertMajorCatgService iExpertMajorCatgService;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private String oper;
	private String expertMajorNum;
	private String expertMajorCatg;
	private String id;
	
	
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	public String getExpertMajorNum() {
		return expertMajorNum;
	}
	public void setExpertMajorNum(String expertMajorNum) {
		this.expertMajorNum = expertMajorNum;
	}
	public String getExpertMajorCatg() {
		return expertMajorCatg;
	}
	public void setExpertMajorCatg(String expertMajorCatg) {
		this.expertMajorCatg = expertMajorCatg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String manageExpertMajorCatg(){
		if(!search){
			if ("add".equals(oper)) {//����
				addExpertMajorCatg();
			} else if ("search".equals(oper)) {//����ҳ��ʱ��ѯ
				refreshGridModel();
				responseData();
			} else if ("del".equals(oper)) {//ɾ��
				delExpertMajorCatg();
			}else if("edit".equals(oper)){//�޸�
				updateExpertMajorCatg();
			}
		}else{//��ѯ
			refreshGridModel();
			responseData();
		}
		return SUCCESS;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String updateExpertMajorCatg() {
		// TODO Auto-generated method stub
		iExpertMajorCatgService.updateExpertMajorCatg(Integer.parseInt(id), expertMajorNum,expertMajorCatg);
		this.dataMap.put("success", true);
		return SUCCESS;
	}

	public String delExpertMajorCatg() {
		// TODO Auto-generated method stub
		/*for(String expertMajorCatg: id.split(",")){
			iExpertMajorCatgService.delExpertMajorCatg(Integer.parseInt(expertMajorCatg));
		}
		this.dataMap.put("success", true);
		return SUCCESS;*/
		String message="";
		for(String expertMajorCatg: id.split(",")){
			
			message= message+ iExpertMajorCatgService.delExpertMajorCatg(Integer.parseInt(expertMajorCatg));
		}
		dataMap.put("success", message);
	    return SUCCESS;
	}

	public String addExpertMajorCatg() {
		// TODO Auto-generated method stub
		iExpertMajorCatgService.addExpertMajorCatg(expertMajorNum, expertMajorCatg);
		this.dataMap.put("success", true);
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

	public IExpertMajorCatgService getiExpertMajorCatgService() {
		return iExpertMajorCatgService;
	}

	public void setiExpertMajorCatgService(IExpertMajorCatgService iExpertMajorCatgService) {
		this.iExpertMajorCatgService = iExpertMajorCatgService;
	}
	
	@Override
	public int getResultSize() {
		// TODO Auto-generated method stub
		return this.iExpertMajorCatgService.queryResultsCount(null);
	}

	@Override
	public int getResultSize(List<Criterion> criteria) {
		// TODO Auto-generated method stub
		return this.iExpertMajorCatgService.queryResultsCount(criteria);
	}

	@Override
	public List<HashMap<String, Object>> listResults(int from, int length) {
		// TODO Auto-generated method stub
		return this.iExpertMajorCatgService.queryByPage(null, from, length);
	}

	@Override
	public List<HashMap<String, Object>> listResults(List<Criterion> criteria,
			int from, int length) {
		// TODO Auto-generated method stub
		results=this.iExpertMajorCatgService.queryByPage(criteria, from, length);
		return results;
	}
	
	//判断专业类别编码是否重复
	public String checkExpertMajorNum(){
		try {
			
			//flag==true表示提示错误，flag==false表示没有重复，不提示错误
			if(id.equals("undefined"))id=null;//若id未定义则给其赋值为null
				boolean flag = iExpertMajorCatgService.checkExpertMajorNum(expertMajorNum,id);
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
	
}
