package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * DataCollDataDic entity. @author MyEclipse Persistence Tools
 */

public class DataCollDataDic implements java.io.Serializable {

	// Fields

	private Integer dataCollDataDicId;
	private String dataDicCode;
	private String dataDicName;
	private boolean isdChoDic;
	private Set dataCollDicEntries = new HashSet(0);
	private Set invesObjs = new HashSet(0);

	// Constructors

	/** default constructor */
	public DataCollDataDic() {
	}

	/** minimal constructor */
	public DataCollDataDic(String dataDicCode) {
		this.dataDicCode = dataDicCode;
	}

	/** full constructor */
	public DataCollDataDic(String dataDicCode, String dataDicName,
			boolean isdChoDic, Set dataCollDicEntries, Set invesObjs) {
		this.dataDicCode = dataDicCode;
		this.dataDicName = dataDicName;
		this.isdChoDic = isdChoDic;
		this.dataCollDicEntries = dataCollDicEntries;
		this.invesObjs = invesObjs;
	}

	// Property accessors

	public Integer getDataCollDataDicId() {
		return this.dataCollDataDicId;
	}

	public void setDataCollDataDicId(Integer dataCollDataDicId) {
		this.dataCollDataDicId = dataCollDataDicId;
	}

	public String getDataDicCode() {
		return this.dataDicCode;
	}

	public void setDataDicCode(String dataDicCode) {
		this.dataDicCode = dataDicCode;
	}

	public String getDataDicName() {
		return this.dataDicName;
	}

	public void setDataDicName(String dataDicName) {
		this.dataDicName = dataDicName;
	}

	public boolean getIsdChoDic() {
		return this.isdChoDic;
	}

	public void setIsdChoDic(boolean isdChoDic) {
		this.isdChoDic = isdChoDic;
	}

	public Set getDataCollDicEntries() {
		return this.dataCollDicEntries;
	}

	public void setDataCollDicEntries(Set dataCollDicEntries) {
		this.dataCollDicEntries = dataCollDicEntries;
	}

	public Set getInvesObjs() {
		return this.invesObjs;
	}

	public void setInvesObjs(Set invesObjs) {
		this.invesObjs = invesObjs;
	}

}