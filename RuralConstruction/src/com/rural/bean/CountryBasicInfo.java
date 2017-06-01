package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * CountryBasicInfo entity. @author MyEclipse Persistence Tools
 */

public class CountryBasicInfo implements java.io.Serializable {

	// Fields

	private Integer countryBasicInfoId;
	private CityBasicInfo cityBasicInfo;
	private String countryNum;
	private String countryName;
	private String countryLongi;
	private String countryLati;
	private String countryMeas;
	private String countryPop;
	private String countryHholds;
	private byte[] countryIntro;
	private Set countryConts = new HashSet(0);
	private Set countryFils = new HashSet(0);
	private Set townBasicInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public CountryBasicInfo() {
	}

	/** minimal constructor */
	public CountryBasicInfo(CityBasicInfo cityBasicInfo, String countryNum) {
		this.cityBasicInfo = cityBasicInfo;
		this.countryNum = countryNum;
	}

	/** full constructor */
	public CountryBasicInfo(CityBasicInfo cityBasicInfo, String countryNum,
			String countryName, String countryLongi, String countryLati,
			String countryMeas, String countryPop, String countryHholds,
			byte[] countryIntro, Set countryConts, Set countryFils,
			Set townBasicInfos) {
		this.cityBasicInfo = cityBasicInfo;
		this.countryNum = countryNum;
		this.countryName = countryName;
		this.countryLongi = countryLongi;
		this.countryLati = countryLati;
		this.countryMeas = countryMeas;
		this.countryPop = countryPop;
		this.countryHholds = countryHholds;
		this.countryIntro = countryIntro;
		this.countryConts = countryConts;
		this.countryFils = countryFils;
		this.townBasicInfos = townBasicInfos;
	}

	// Property accessors

	public Integer getCountryBasicInfoId() {
		return this.countryBasicInfoId;
	}

	public void setCountryBasicInfoId(Integer countryBasicInfoId) {
		this.countryBasicInfoId = countryBasicInfoId;
	}

	public CityBasicInfo getCityBasicInfo() {
		return this.cityBasicInfo;
	}

	public void setCityBasicInfo(CityBasicInfo cityBasicInfo) {
		this.cityBasicInfo = cityBasicInfo;
	}

	public String getCountryNum() {
		return this.countryNum;
	}

	public void setCountryNum(String countryNum) {
		this.countryNum = countryNum;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryLongi() {
		return this.countryLongi;
	}

	public void setCountryLongi(String countryLongi) {
		this.countryLongi = countryLongi;
	}

	public String getCountryLati() {
		return this.countryLati;
	}

	public void setCountryLati(String countryLati) {
		this.countryLati = countryLati;
	}

	public String getCountryMeas() {
		return this.countryMeas;
	}

	public void setCountryMeas(String countryMeas) {
		this.countryMeas = countryMeas;
	}

	public String getCountryPop() {
		return this.countryPop;
	}

	public void setCountryPop(String countryPop) {
		this.countryPop = countryPop;
	}

	public String getCountryHholds() {
		return this.countryHholds;
	}

	public void setCountryHholds(String countryHholds) {
		this.countryHholds = countryHholds;
	}

	public byte[] getCountryIntro() {
		return this.countryIntro;
	}

	public void setCountryIntro(byte[] countryIntro) {
		this.countryIntro = countryIntro;
	}

	public Set getCountryConts() {
		return this.countryConts;
	}

	public void setCountryConts(Set countryConts) {
		this.countryConts = countryConts;
	}

	public Set getCountryFils() {
		return this.countryFils;
	}

	public void setCountryFils(Set countryFils) {
		this.countryFils = countryFils;
	}

	public Set getTownBasicInfos() {
		return this.townBasicInfos;
	}

	public void setTownBasicInfos(Set townBasicInfos) {
		this.townBasicInfos = townBasicInfos;
	}

}