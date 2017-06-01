package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * TownBasicInfo entity. @author MyEclipse Persistence Tools
 */

public class TownBasicInfo implements java.io.Serializable {

	// Fields

	private Integer townBasicInfoId;
	private CountryBasicInfo countryBasicInfo;
	private String townNum;
	private String townName;
	private String townLongi;
	private String townLati;
	private String townMeas;
	private String townPop;
	private String townHholds;
	private byte[] townIntro;
	private Set townConts = new HashSet(0);
	private Set vilBasicInfos = new HashSet(0);
	private Set townFils = new HashSet(0);

	// Constructors

	/** default constructor */
	public TownBasicInfo() {
	}

	/** minimal constructor */
	public TownBasicInfo(CountryBasicInfo countryBasicInfo, String townNum) {
		this.countryBasicInfo = countryBasicInfo;
		this.townNum = townNum;
	}

	/** full constructor */
	public TownBasicInfo(CountryBasicInfo countryBasicInfo, String townNum,
			String townName, String townLongi, String townLati,
			String townMeas, String townPop, String townHholds,
			byte[] townIntro, Set townConts, Set vilBasicInfos, Set townFils) {
		this.countryBasicInfo = countryBasicInfo;
		this.townNum = townNum;
		this.townName = townName;
		this.townLongi = townLongi;
		this.townLati = townLati;
		this.townMeas = townMeas;
		this.townPop = townPop;
		this.townHholds = townHholds;
		this.townIntro = townIntro;
		this.townConts = townConts;
		this.vilBasicInfos = vilBasicInfos;
		this.townFils = townFils;
	}

	// Property accessors

	public Integer getTownBasicInfoId() {
		return this.townBasicInfoId;
	}

	public void setTownBasicInfoId(Integer townBasicInfoId) {
		this.townBasicInfoId = townBasicInfoId;
	}

	public CountryBasicInfo getCountryBasicInfo() {
		return this.countryBasicInfo;
	}

	public void setCountryBasicInfo(CountryBasicInfo countryBasicInfo) {
		this.countryBasicInfo = countryBasicInfo;
	}

	public String getTownNum() {
		return this.townNum;
	}

	public void setTownNum(String townNum) {
		this.townNum = townNum;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getTownLongi() {
		return this.townLongi;
	}

	public void setTownLongi(String townLongi) {
		this.townLongi = townLongi;
	}

	public String getTownLati() {
		return this.townLati;
	}

	public void setTownLati(String townLati) {
		this.townLati = townLati;
	}

	public String getTownMeas() {
		return this.townMeas;
	}

	public void setTownMeas(String townMeas) {
		this.townMeas = townMeas;
	}

	public String getTownPop() {
		return this.townPop;
	}

	public void setTownPop(String townPop) {
		this.townPop = townPop;
	}

	public String getTownHholds() {
		return this.townHholds;
	}

	public void setTownHholds(String townHholds) {
		this.townHholds = townHholds;
	}

	public byte[] getTownIntro() {
		return this.townIntro;
	}

	public void setTownIntro(byte[] townIntro) {
		this.townIntro = townIntro;
	}

	public Set getTownConts() {
		return this.townConts;
	}

	public void setTownConts(Set townConts) {
		this.townConts = townConts;
	}

	public Set getVilBasicInfos() {
		return this.vilBasicInfos;
	}

	public void setVilBasicInfos(Set vilBasicInfos) {
		this.vilBasicInfos = vilBasicInfos;
	}

	public Set getTownFils() {
		return this.townFils;
	}

	public void setTownFils(Set townFils) {
		this.townFils = townFils;
	}

}