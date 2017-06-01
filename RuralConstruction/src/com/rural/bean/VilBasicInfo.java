package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * VilBasicInfo entity. @author MyEclipse Persistence Tools
 */

public class VilBasicInfo implements java.io.Serializable {

	// Fields

	private Integer vilBasicInfoId;
	private TownBasicInfo townBasicInfo;
	private String vilNum;
	private String vilName;
	private String vilLongi;
	private String vilLati;
	private String vilMeas;
	private String vilPop;
	private String vilHholds;
	private String vilNatural;
	private byte[] vilIntro;
	private Set invgatDworks = new HashSet(0);
	private Set vilFils = new HashSet(0);
	private Set vilDataCollRecs = new HashSet(0);
	private Set vilConts = new HashSet(0);

	// Constructors

	/** default constructor */
	public VilBasicInfo() {
	}

	/** minimal constructor */
	public VilBasicInfo(TownBasicInfo townBasicInfo, String vilNum) {
		this.townBasicInfo = townBasicInfo;
		this.vilNum = vilNum;
	}

	/** full constructor */
	public VilBasicInfo(TownBasicInfo townBasicInfo, String vilNum,
			String vilName, String vilLongi, String vilLati, String vilMeas,
			String vilPop, String vilHholds, String vilNatural,
			byte[] vilIntro, Set invgatDworks, Set vilFils,
			Set vilDataCollRecs, Set vilConts) {
		this.townBasicInfo = townBasicInfo;
		this.vilNum = vilNum;
		this.vilName = vilName;
		this.vilLongi = vilLongi;
		this.vilLati = vilLati;
		this.vilMeas = vilMeas;
		this.vilPop = vilPop;
		this.vilHholds = vilHholds;
		this.vilNatural = vilNatural;
		this.vilIntro = vilIntro;
		this.invgatDworks = invgatDworks;
		this.vilFils = vilFils;
		this.vilDataCollRecs = vilDataCollRecs;
		this.vilConts = vilConts;
	}

	// Property accessors

	public Integer getVilBasicInfoId() {
		return this.vilBasicInfoId;
	}

	public void setVilBasicInfoId(Integer vilBasicInfoId) {
		this.vilBasicInfoId = vilBasicInfoId;
	}

	public TownBasicInfo getTownBasicInfo() {
		return this.townBasicInfo;
	}

	public void setTownBasicInfo(TownBasicInfo townBasicInfo) {
		this.townBasicInfo = townBasicInfo;
	}

	public String getVilNum() {
		return this.vilNum;
	}

	public void setVilNum(String vilNum) {
		this.vilNum = vilNum;
	}

	public String getVilName() {
		return this.vilName;
	}

	public void setVilName(String vilName) {
		this.vilName = vilName;
	}

	public String getVilLongi() {
		return this.vilLongi;
	}

	public void setVilLongi(String vilLongi) {
		this.vilLongi = vilLongi;
	}

	public String getVilLati() {
		return this.vilLati;
	}

	public void setVilLati(String vilLati) {
		this.vilLati = vilLati;
	}

	public String getVilMeas() {
		return this.vilMeas;
	}

	public void setVilMeas(String vilMeas) {
		this.vilMeas = vilMeas;
	}

	public String getVilPop() {
		return this.vilPop;
	}

	public void setVilPop(String vilPop) {
		this.vilPop = vilPop;
	}

	public String getVilHholds() {
		return this.vilHholds;
	}

	public void setVilHholds(String vilHholds) {
		this.vilHholds = vilHholds;
	}

	public String getVilNatural() {
		return this.vilNatural;
	}

	public void setVilNatural(String vilNatural) {
		this.vilNatural = vilNatural;
	}

	public byte[] getVilIntro() {
		return this.vilIntro;
	}

	public void setVilIntro(byte[] vilIntro) {
		this.vilIntro = vilIntro;
	}

	public Set getInvgatDworks() {
		return this.invgatDworks;
	}

	public void setInvgatDworks(Set invgatDworks) {
		this.invgatDworks = invgatDworks;
	}

	public Set getVilFils() {
		return this.vilFils;
	}

	public void setVilFils(Set vilFils) {
		this.vilFils = vilFils;
	}

	public Set getVilDataCollRecs() {
		return this.vilDataCollRecs;
	}

	public void setVilDataCollRecs(Set vilDataCollRecs) {
		this.vilDataCollRecs = vilDataCollRecs;
	}

	public Set getVilConts() {
		return this.vilConts;
	}

	public void setVilConts(Set vilConts) {
		this.vilConts = vilConts;
	}

}