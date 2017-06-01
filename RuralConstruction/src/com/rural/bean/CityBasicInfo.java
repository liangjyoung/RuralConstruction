package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * CityBasicInfo entity. @author MyEclipse Persistence Tools
 */

public class CityBasicInfo implements java.io.Serializable {

	// Fields

	private Integer cityBasicInfoId;
	private ProBasicInfo proBasicInfo;
	private String cityNum;
	private String cityName;
	private String cityLongi;
	private String cityLati;
	private String cityMeas;
	private String cityPop;
	private String cityHholds;
	private byte[] cityIntro;
	private Set citysFils = new HashSet(0);
	private Set countryBasicInfos = new HashSet(0);
	private Set citysConts = new HashSet(0);

	// Constructors

	/** default constructor */
	public CityBasicInfo() {
	}

	/** minimal constructor */
	public CityBasicInfo(ProBasicInfo proBasicInfo, String cityNum) {
		this.proBasicInfo = proBasicInfo;
		this.cityNum = cityNum;
	}

	/** full constructor */
	public CityBasicInfo(ProBasicInfo proBasicInfo, String cityNum,
			String cityName, String cityLongi, String cityLati,
			String cityMeas, String cityPop, String cityHholds,
			byte[] cityIntro, Set citysFils, Set countryBasicInfos,
			Set citysConts) {
		this.proBasicInfo = proBasicInfo;
		this.cityNum = cityNum;
		this.cityName = cityName;
		this.cityLongi = cityLongi;
		this.cityLati = cityLati;
		this.cityMeas = cityMeas;
		this.cityPop = cityPop;
		this.cityHholds = cityHholds;
		this.cityIntro = cityIntro;
		this.citysFils = citysFils;
		this.countryBasicInfos = countryBasicInfos;
		this.citysConts = citysConts;
	}

	// Property accessors

	public Integer getCityBasicInfoId() {
		return this.cityBasicInfoId;
	}

	public void setCityBasicInfoId(Integer cityBasicInfoId) {
		this.cityBasicInfoId = cityBasicInfoId;
	}

	public ProBasicInfo getProBasicInfo() {
		return this.proBasicInfo;
	}

	public void setProBasicInfo(ProBasicInfo proBasicInfo) {
		this.proBasicInfo = proBasicInfo;
	}

	public String getCityNum() {
		return this.cityNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityLongi() {
		return this.cityLongi;
	}

	public void setCityLongi(String cityLongi) {
		this.cityLongi = cityLongi;
	}

	public String getCityLati() {
		return this.cityLati;
	}

	public void setCityLati(String cityLati) {
		this.cityLati = cityLati;
	}

	public String getCityMeas() {
		return this.cityMeas;
	}

	public void setCityMeas(String cityMeas) {
		this.cityMeas = cityMeas;
	}

	public String getCityPop() {
		return this.cityPop;
	}

	public void setCityPop(String cityPop) {
		this.cityPop = cityPop;
	}

	public String getCityHholds() {
		return this.cityHholds;
	}

	public void setCityHholds(String cityHholds) {
		this.cityHholds = cityHholds;
	}

	public byte[] getCityIntro() {
		return this.cityIntro;
	}

	public void setCityIntro(byte[] cityIntro) {
		this.cityIntro = cityIntro;
	}

	public Set getCitysFils() {
		return this.citysFils;
	}

	public void setCitysFils(Set citysFils) {
		this.citysFils = citysFils;
	}

	public Set getCountryBasicInfos() {
		return this.countryBasicInfos;
	}

	public void setCountryBasicInfos(Set countryBasicInfos) {
		this.countryBasicInfos = countryBasicInfos;
	}

	public Set getCitysConts() {
		return this.citysConts;
	}

	public void setCitysConts(Set citysConts) {
		this.citysConts = citysConts;
	}

}