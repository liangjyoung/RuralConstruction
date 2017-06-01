package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * DataCollDicEntry entity. @author MyEclipse Persistence Tools
 */

public class DataCollDicEntry implements java.io.Serializable {

	// Fields

	private Integer dataCollDicEntryId;
	private DataCollDataDic dataCollDataDic;
	private String dicEntryCode;
	private String dicEntryName;
	private Set invesObjDatas = new HashSet(0);

	// Constructors

	/** default constructor */
	public DataCollDicEntry() {
	}

	/** minimal constructor */
	public DataCollDicEntry(String dicEntryCode) {
		this.dicEntryCode = dicEntryCode;
	}

	/** full constructor */
	public DataCollDicEntry(DataCollDataDic dataCollDataDic,
			String dicEntryCode, String dicEntryName, Set invesObjDatas) {
		this.dataCollDataDic = dataCollDataDic;
		this.dicEntryCode = dicEntryCode;
		this.dicEntryName = dicEntryName;
		this.invesObjDatas = invesObjDatas;
	}

	// Property accessors

	public Integer getDataCollDicEntryId() {
		return this.dataCollDicEntryId;
	}

	public void setDataCollDicEntryId(Integer dataCollDicEntryId) {
		this.dataCollDicEntryId = dataCollDicEntryId;
	}

	public DataCollDataDic getDataCollDataDic() {
		return this.dataCollDataDic;
	}

	public void setDataCollDataDic(DataCollDataDic dataCollDataDic) {
		this.dataCollDataDic = dataCollDataDic;
	}

	public String getDicEntryCode() {
		return this.dicEntryCode;
	}

	public void setDicEntryCode(String dicEntryCode) {
		this.dicEntryCode = dicEntryCode;
	}

	public String getDicEntryName() {
		return this.dicEntryName;
	}

	public void setDicEntryName(String dicEntryName) {
		this.dicEntryName = dicEntryName;
	}

	public Set getInvesObjDatas() {
		return this.invesObjDatas;
	}

	public void setInvesObjDatas(Set invesObjDatas) {
		this.invesObjDatas = invesObjDatas;
	}

}