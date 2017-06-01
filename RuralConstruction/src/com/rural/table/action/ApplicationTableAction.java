package com.rural.table.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import com.rural.table.service.ApplicationTableIService;
import com.rural.table.service.CheckFile;
import com.rural.table.service.FileConfig;

public class ApplicationTableAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationTableIService applicationtableservie;
	private Map<String ,Object> dataMap=new HashMap<String ,Object>();
	private String VilNum;
	//private String EvalScoID = "1";
	
	
	private String VilEvalscoID ;	
	private String EvalContScoreID;
	
	
	public String getVilEvalscoID() {
		return VilEvalscoID;
	}

	public void setVilEvalscoID(String vilEvalscoID) {
		VilEvalscoID = vilEvalscoID;
	}

	public void setApplicationtableservie(ApplicationTableIService applicationtableservie) {
		this.applicationtableservie = applicationtableservie;
	}

	public String createApplicationTable() throws Exception {
    	if(!CheckFile.applicationtableExists()){
    		//dataMap.put("success", "error");
			//dataMap.put("msg", CheckFile.fileNotExistsTips());
    		dataMap.put("success", "模板文件"+FileConfig.template_applicationtable+"不存在。");
    	}else{
    	List<String> stuloginnamelist=new ArrayList<String >();
    	// projectid=String.valueOf(projectinfo.getLatestProjectIDFromDb());
    	stuloginnamelist=this.getLoingnameList();
    	try {
			if(this.applicationtableservie.createTableFromDb(VilEvalscoID.trim(),stuloginnamelist,VilNum.trim())){
				dataMap.put("success", true);
			}else{
				dataMap.put("success", false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			dataMap.put("success", "创建文件失败");
			e.printStackTrace();
		}
    	}
    	return SUCCESS;
    }
	
	 public List<String> getLoingnameList(){
	    	List<String> cache=new ArrayList<String>();
	    	String cachelist[]=EvalContScoreID.split(",");
	    	for(int i=0;i<cachelist.length;i++){
	    		cache.add(cachelist[i]);
	    	}
	    	return cache;
	    }
	
	public ApplicationTableIService getApplicationtableservie() {
		return applicationtableservie;
	}

	public void setDataMap(Map<String ,Object> dataMap) {
		this.dataMap = dataMap;
	}

	public Map<String ,Object> getDataMap() {
		return dataMap;
	}

	public void setVilNum(String vilNum) {
		VilNum = vilNum;
	}

	public String getVilNum() {
		return VilNum;
	}


	public void setEvalContScoreID(String evalContScoreID) {
		EvalContScoreID = evalContScoreID;
	}

	public String getEvalContScoreID() {
		return EvalContScoreID;
	}
	
}
