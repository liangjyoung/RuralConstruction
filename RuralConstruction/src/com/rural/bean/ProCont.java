package com.rural.bean;

/**
 * ProCont entity. @author MyEclipse Persistence Tools
 */

public class ProCont implements java.io.Serializable {

	// Fields

	private Integer proContId;
	private ProBasicInfo proBasicInfo;
	private String proContNum;
	private String proContName;
	private String proContWorkTel;
	private String proContMobTel;
	private String proContComp;
	private String proContPost;
	private String proNote;

	// Constructors

	/** default constructor */
	public ProCont() {
	}

	/** full constructor */
	public ProCont(ProBasicInfo proBasicInfo, String proContNum,
			String proContName, String proContWorkTel, String proContMobTel,
			String proContComp, String proContPost, String proNote) {
		this.proBasicInfo = proBasicInfo;
		this.proContNum = proContNum;
		this.proContName = proContName;
		this.proContWorkTel = proContWorkTel;
		this.proContMobTel = proContMobTel;
		this.proContComp = proContComp;
		this.proContPost = proContPost;
		this.proNote = proNote;
	}

	// Property accessors

	public Integer getProContId() {
		return this.proContId;
	}

	public void setProContId(Integer proContId) {
		this.proContId = proContId;
	}

	public ProBasicInfo getProBasicInfo() {
		return this.proBasicInfo;
	}

	public void setProBasicInfo(ProBasicInfo proBasicInfo) {
		this.proBasicInfo = proBasicInfo;
	}

	public String getProContNum() {
		return this.proContNum;
	}

	public void setProContNum(String proContNum) {
		this.proContNum = proContNum;
	}

	public String getProContName() {
		return this.proContName;
	}

	public void setProContName(String proContName) {
		this.proContName = proContName;
	}

	public String getProContWorkTel() {
		return this.proContWorkTel;
	}

	public void setProContWorkTel(String proContWorkTel) {
		this.proContWorkTel = proContWorkTel;
	}

	public String getProContMobTel() {
		return this.proContMobTel;
	}

	public void setProContMobTel(String proContMobTel) {
		this.proContMobTel = proContMobTel;
	}

	public String getProContComp() {
		return this.proContComp;
	}

	public void setProContComp(String proContComp) {
		this.proContComp = proContComp;
	}

	public String getProContPost() {
		return this.proContPost;
	}

	public void setProContPost(String proContPost) {
		this.proContPost = proContPost;
	}

	public String getProNote() {
		return this.proNote;
	}

	public void setProNote(String proNote) {
		this.proNote = proNote;
	}

}