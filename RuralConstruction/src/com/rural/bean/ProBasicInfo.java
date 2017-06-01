package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * ProBasicInfo entity. @author MyEclipse Persistence Tools
 */

public class ProBasicInfo implements java.io.Serializable {

	// Fields

	private Integer proBasicInfoId;
	private String proNum;
	private String proName;
	private String proMeas;
	private String proPop;
	private String proHholds;
	private byte[] proIntro;
	private Set proFils = new HashSet(0);
	private Set cityBasicInfos = new HashSet(0);
	private Set proConts = new HashSet(0);

	// Constructors

	/** default constructor */
	public ProBasicInfo() {
	}

	/** minimal constructor */
	public ProBasicInfo(String proNum) {
		this.proNum = proNum;
	}

	/** full constructor */
	public ProBasicInfo(String proNum, String proName, String proMeas,
			String proPop, String proHholds, byte[] proIntro, Set proFils,
			Set cityBasicInfos, Set proConts) {
		this.proNum = proNum;
		this.proName = proName;
		this.proMeas = proMeas;
		this.proPop = proPop;
		this.proHholds = proHholds;
		this.proIntro = proIntro;
		this.proFils = proFils;
		this.cityBasicInfos = cityBasicInfos;
		this.proConts = proConts;
	}

	// Property accessors

	public Integer getProBasicInfoId() {
		return this.proBasicInfoId;
	}

	public void setProBasicInfoId(Integer proBasicInfoId) {
		this.proBasicInfoId = proBasicInfoId;
	}

	public String getProNum() {
		return this.proNum;
	}

	public void setProNum(String proNum) {
		this.proNum = proNum;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProMeas() {
		return this.proMeas;
	}

	public void setProMeas(String proMeas) {
		this.proMeas = proMeas;
	}

	public String getProPop() {
		return this.proPop;
	}

	public void setProPop(String proPop) {
		this.proPop = proPop;
	}

	public String getProHholds() {
		return this.proHholds;
	}

	public void setProHholds(String proHholds) {
		this.proHholds = proHholds;
	}

	public byte[] getProIntro() {
		return this.proIntro;
	}

	public void setProIntro(byte[] proIntro) {
		this.proIntro = proIntro;
	}

	public Set getProFils() {
		return this.proFils;
	}

	public void setProFils(Set proFils) {
		this.proFils = proFils;
	}

	public Set getCityBasicInfos() {
		return this.cityBasicInfos;
	}

	public void setCityBasicInfos(Set cityBasicInfos) {
		this.cityBasicInfos = cityBasicInfos;
	}

	public Set getProConts() {
		return this.proConts;
	}

	public void setProConts(Set proConts) {
		this.proConts = proConts;
	}

}