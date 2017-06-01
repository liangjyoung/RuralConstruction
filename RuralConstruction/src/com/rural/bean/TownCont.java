package com.rural.bean;

/**
 * TownCont entity. @author MyEclipse Persistence Tools
 */

public class TownCont implements java.io.Serializable {

	// Fields

	private Integer townContId;
	private TownBasicInfo townBasicInfo;
	private String townContNum;
	private String townContName;
	private String townContWorkTel;
	private String townContMobTel;
	private String townContComp;
	private String townContPost;
	private String townContNote;

	// Constructors

	/** default constructor */
	public TownCont() {
	}

	/** full constructor */
	public TownCont(TownBasicInfo townBasicInfo, String townContNum,
			String townContName, String townContWorkTel, String townContMobTel,
			String townContComp, String townContPost, String townContNote) {
		this.townBasicInfo = townBasicInfo;
		this.townContNum = townContNum;
		this.townContName = townContName;
		this.townContWorkTel = townContWorkTel;
		this.townContMobTel = townContMobTel;
		this.townContComp = townContComp;
		this.townContPost = townContPost;
		this.townContNote = townContNote;
	}

	// Property accessors

	public Integer getTownContId() {
		return this.townContId;
	}

	public void setTownContId(Integer townContId) {
		this.townContId = townContId;
	}

	public TownBasicInfo getTownBasicInfo() {
		return this.townBasicInfo;
	}

	public void setTownBasicInfo(TownBasicInfo townBasicInfo) {
		this.townBasicInfo = townBasicInfo;
	}

	public String getTownContNum() {
		return this.townContNum;
	}

	public void setTownContNum(String townContNum) {
		this.townContNum = townContNum;
	}

	public String getTownContName() {
		return this.townContName;
	}

	public void setTownContName(String townContName) {
		this.townContName = townContName;
	}

	public String getTownContWorkTel() {
		return this.townContWorkTel;
	}

	public void setTownContWorkTel(String townContWorkTel) {
		this.townContWorkTel = townContWorkTel;
	}

	public String getTownContMobTel() {
		return this.townContMobTel;
	}

	public void setTownContMobTel(String townContMobTel) {
		this.townContMobTel = townContMobTel;
	}

	public String getTownContComp() {
		return this.townContComp;
	}

	public void setTownContComp(String townContComp) {
		this.townContComp = townContComp;
	}

	public String getTownContPost() {
		return this.townContPost;
	}

	public void setTownContPost(String townContPost) {
		this.townContPost = townContPost;
	}

	public String getTownContNote() {
		return this.townContNote;
	}

	public void setTownContNote(String townContNote) {
		this.townContNote = townContNote;
	}

}