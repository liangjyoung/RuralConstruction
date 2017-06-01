package com.rural.bean;

import java.util.Date;

/**
 * CountryFil entity. @author MyEclipse Persistence Tools
 */

public class CountryFil implements java.io.Serializable {

	// Fields

	private Integer countryFilId;
	private CountryBasicInfo countryBasicInfo;
	private GoveFilClfy goveFilClfy;
	private String countryFilNum;
	private String countryFilName;
	private String countryFilIdef;
	private Date countryFilMadTim;
	private String countryFilPubComp;
	private String countryFilExpl;

	// Constructors

	/** default constructor */
	public CountryFil() {
	}

	/** full constructor */
	public CountryFil(CountryBasicInfo countryBasicInfo,
			GoveFilClfy goveFilClfy, String countryFilNum,
			String countryFilName, String countryFilIdef,
			Date countryFilMadTim, String countryFilPubComp,
			String countryFilExpl) {
		this.countryBasicInfo = countryBasicInfo;
		this.goveFilClfy = goveFilClfy;
		this.countryFilNum = countryFilNum;
		this.countryFilName = countryFilName;
		this.countryFilIdef = countryFilIdef;
		this.countryFilMadTim = countryFilMadTim;
		this.countryFilPubComp = countryFilPubComp;
		this.countryFilExpl = countryFilExpl;
	}

	// Property accessors

	public Integer getCountryFilId() {
		return this.countryFilId;
	}

	public void setCountryFilId(Integer countryFilId) {
		this.countryFilId = countryFilId;
	}

	public CountryBasicInfo getCountryBasicInfo() {
		return this.countryBasicInfo;
	}

	public void setCountryBasicInfo(CountryBasicInfo countryBasicInfo) {
		this.countryBasicInfo = countryBasicInfo;
	}

	public GoveFilClfy getGoveFilClfy() {
		return this.goveFilClfy;
	}

	public void setGoveFilClfy(GoveFilClfy goveFilClfy) {
		this.goveFilClfy = goveFilClfy;
	}

	public String getCountryFilNum() {
		return this.countryFilNum;
	}

	public void setCountryFilNum(String countryFilNum) {
		this.countryFilNum = countryFilNum;
	}

	public String getCountryFilName() {
		return this.countryFilName;
	}

	public void setCountryFilName(String countryFilName) {
		this.countryFilName = countryFilName;
	}

	public String getCountryFilIdef() {
		return this.countryFilIdef;
	}

	public void setCountryFilIdef(String countryFilIdef) {
		this.countryFilIdef = countryFilIdef;
	}

	public Date getCountryFilMadTim() {
		return this.countryFilMadTim;
	}

	public void setCountryFilMadTim(Date countryFilMadTim) {
		this.countryFilMadTim = countryFilMadTim;
	}

	public String getCountryFilPubComp() {
		return this.countryFilPubComp;
	}

	public void setCountryFilPubComp(String countryFilPubComp) {
		this.countryFilPubComp = countryFilPubComp;
	}

	public String getCountryFilExpl() {
		return this.countryFilExpl;
	}

	public void setCountryFilExpl(String countryFilExpl) {
		this.countryFilExpl = countryFilExpl;
	}

}