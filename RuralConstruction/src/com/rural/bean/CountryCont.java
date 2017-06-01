package com.rural.bean;

/**
 * CountryCont entity. @author MyEclipse Persistence Tools
 */

public class CountryCont implements java.io.Serializable {

	// Fields

	private Integer countryContId;
	private CountryBasicInfo countryBasicInfo;
	private String countryContNum;
	private String countryContName;
	private String countryContWorkTel;
	private String countryContMobTel;
	private String countryContComp;
	private String countryContPost;
	private String countryContNote;

	// Constructors

	/** default constructor */
	public CountryCont() {
	}

	/** full constructor */
	public CountryCont(CountryBasicInfo countryBasicInfo,
			String countryContNum, String countryContName,
			String countryContWorkTel, String countryContMobTel,
			String countryContComp, String countryContPost,
			String countryContNote) {
		this.countryBasicInfo = countryBasicInfo;
		this.countryContNum = countryContNum;
		this.countryContName = countryContName;
		this.countryContWorkTel = countryContWorkTel;
		this.countryContMobTel = countryContMobTel;
		this.countryContComp = countryContComp;
		this.countryContPost = countryContPost;
		this.countryContNote = countryContNote;
	}

	// Property accessors

	public Integer getCountryContId() {
		return this.countryContId;
	}

	public void setCountryContId(Integer countryContId) {
		this.countryContId = countryContId;
	}

	public CountryBasicInfo getCountryBasicInfo() {
		return this.countryBasicInfo;
	}

	public void setCountryBasicInfo(CountryBasicInfo countryBasicInfo) {
		this.countryBasicInfo = countryBasicInfo;
	}

	public String getCountryContNum() {
		return this.countryContNum;
	}

	public void setCountryContNum(String countryContNum) {
		this.countryContNum = countryContNum;
	}

	public String getCountryContName() {
		return this.countryContName;
	}

	public void setCountryContName(String countryContName) {
		this.countryContName = countryContName;
	}

	public String getCountryContWorkTel() {
		return this.countryContWorkTel;
	}

	public void setCountryContWorkTel(String countryContWorkTel) {
		this.countryContWorkTel = countryContWorkTel;
	}

	public String getCountryContMobTel() {
		return this.countryContMobTel;
	}

	public void setCountryContMobTel(String countryContMobTel) {
		this.countryContMobTel = countryContMobTel;
	}

	public String getCountryContComp() {
		return this.countryContComp;
	}

	public void setCountryContComp(String countryContComp) {
		this.countryContComp = countryContComp;
	}

	public String getCountryContPost() {
		return this.countryContPost;
	}

	public void setCountryContPost(String countryContPost) {
		this.countryContPost = countryContPost;
	}

	public String getCountryContNote() {
		return this.countryContNote;
	}

	public void setCountryContNote(String countryContNote) {
		this.countryContNote = countryContNote;
	}

}