package com.rural.scolevstatistics.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.rural.averanalysis.service.ITownAverAnalysisService;
import com.rural.scolevstatistics.service.IScoLevStatisticsService;

public class ScoLevStatisticsAction extends ActionSupport{
	
	String collTime;//采集时间
	String sysUserBeloDiviCode;//行政区划
	String JQID;
	
	private HashMap<String, Object> dataMap = new HashMap<String, Object>();
	private IScoLevStatisticsService iScoLevStatisticsService ;
	
	public String scoLevStatistics()
		{
		sysUserBeloDiviCode= JQID;
			Integer [] count = iScoLevStatisticsService.ScoLStatistic(collTime,sysUserBeloDiviCode);
			dataMap.put("count", count);
			return SUCCESS;
		}

	
	public String getJQID() {
		return JQID;
	}


	public void setJQID(String jQID) {
		JQID = jQID;
	}


	public String getCollTime() {
		return collTime;
	}

	public void setCollTime(String collTime) {
		this.collTime = collTime;
	}

	public String getSysUserBeloDiviCode() {
		return sysUserBeloDiviCode;
	}

	public void setSysUserBeloDiviCode(String sysUserBeloDiviCode) {
		this.sysUserBeloDiviCode = sysUserBeloDiviCode;
	}

	public HashMap<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(HashMap<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public IScoLevStatisticsService getiScoLevStatisticsService() {
		return iScoLevStatisticsService;
	}

	public void setiScoLevStatisticsService(
			IScoLevStatisticsService iScoLevStatisticsService) {
		this.iScoLevStatisticsService = iScoLevStatisticsService;
	}
	
	
}
