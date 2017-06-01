package com.rural.bean;

/**
 * CitysCont entity. @author MyEclipse Persistence Tools
 */

public class CitysCont implements java.io.Serializable {

	// Fields

	private Integer citysContId;
	private CityBasicInfo cityBasicInfo;
	private String citysContNum;
	private String citysContName;
	private String citysContWorkTel;
	private String citysContMobTel;
	private String citysContComp;
	private String citysContPost;
	private String citysContNote;

	// Constructors

	/** default constructor */
	public CitysCont() {
	}

	/** full constructor */
	public CitysCont(CityBasicInfo cityBasicInfo, String citysContNum,
			String citysContName, String citysContWorkTel,
			String citysContMobTel, String citysContComp, String citysContPost,
			String citysContNote) {
		this.cityBasicInfo = cityBasicInfo;
		this.citysContNum = citysContNum;
		this.citysContName = citysContName;
		this.citysContWorkTel = citysContWorkTel;
		this.citysContMobTel = citysContMobTel;
		this.citysContComp = citysContComp;
		this.citysContPost = citysContPost;
		this.citysContNote = citysContNote;
	}

	// Property accessors

	public Integer getCitysContId() {
		return this.citysContId;
	}

	public void setCitysContId(Integer citysContId) {
		this.citysContId = citysContId;
	}

	public CityBasicInfo getCityBasicInfo() {
		return this.cityBasicInfo;
	}

	public void setCityBasicInfo(CityBasicInfo cityBasicInfo) {
		this.cityBasicInfo = cityBasicInfo;
	}

	public String getCitysContNum() {
		return this.citysContNum;
	}

	public void setCitysContNum(String citysContNum) {
		this.citysContNum = citysContNum;
	}

	public String getCitysContName() {
		return this.citysContName;
	}

	public void setCitysContName(String citysContName) {
		this.citysContName = citysContName;
	}

	public String getCitysContWorkTel() {
		return this.citysContWorkTel;
	}

	public void setCitysContWorkTel(String citysContWorkTel) {
		this.citysContWorkTel = citysContWorkTel;
	}

	public String getCitysContMobTel() {
		return this.citysContMobTel;
	}

	public void setCitysContMobTel(String citysContMobTel) {
		this.citysContMobTel = citysContMobTel;
	}

	public String getCitysContComp() {
		return this.citysContComp;
	}

	public void setCitysContComp(String citysContComp) {
		this.citysContComp = citysContComp;
	}

	public String getCitysContPost() {
		return this.citysContPost;
	}

	public void setCitysContPost(String citysContPost) {
		this.citysContPost = citysContPost;
	}

	public String getCitysContNote() {
		return this.citysContNote;
	}

	public void setCitysContNote(String citysContNote) {
		this.citysContNote = citysContNote;
	}

}