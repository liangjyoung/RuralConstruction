package com.rural.app.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.app.service.DownBaseDataService;


public class DownProgressAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	
	public String execute() throws Exception {
		int totalRows = 156800;
		//int handleRows =  UploadDicAction.handleRows;
		int handleRows= DownBaseDataService.handleRows;
		//double doubleHandeRows = (double)handleRows;
		//double progress = (doubleHandeRows/totalRows)*100.0;
		//if (totalRows != handleRows) {
			dataMap.put("success", true);
			dataMap.put("progress", handleRows);
		//}else{
			//dataMap.put("success", false);
			//dataMap.put("progress", 1);
	//	}
		
		return SUCCESS;
	}

	
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	
}
