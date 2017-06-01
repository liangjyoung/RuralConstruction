package com.rural.upload.action;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class UploadProgressTownAction  extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	
	public String execute() throws Exception {
		int totalRows = UploadTownAction.totalRows;
		int handleRows =  UploadTownAction.handleRows;
		double doubleHandeRows = (double)handleRows;
		double progress = (doubleHandeRows/totalRows)*100.0;
		if (totalRows != handleRows) {
			dataMap.put("success", true);
			dataMap.put("progress", progress);
		}else{
			dataMap.put("success", false);
			dataMap.put("progress", 1);
		}
		
		return SUCCESS;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	

}
