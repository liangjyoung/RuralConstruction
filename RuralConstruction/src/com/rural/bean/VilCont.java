package com.rural.bean;

/**
 * VilCont entity. @author MyEclipse Persistence Tools
 */

public class VilCont implements java.io.Serializable {

	// Fields

	private Integer vilContId;
	private VilBasicInfo vilBasicInfo;
	private String vilContNum;
	private String vilContName;
	private String vilContWorkTel;
	private String vilContMobTel;
	private String vilContComp;
	private String vilContPost;
	private String vilContNote;

	// Constructors

	/** default constructor */
	public VilCont() {
	}

	/** full constructor */
	public VilCont(VilBasicInfo vilBasicInfo, String vilContNum,
			String vilContName, String vilContWorkTel, String vilContMobTel,
			String vilContComp, String vilContPost, String vilContNote) {
		this.vilBasicInfo = vilBasicInfo;
		this.vilContNum = vilContNum;
		this.vilContName = vilContName;
		this.vilContWorkTel = vilContWorkTel;
		this.vilContMobTel = vilContMobTel;
		this.vilContComp = vilContComp;
		this.vilContPost = vilContPost;
		this.vilContNote = vilContNote;
	}

	// Property accessors

	public Integer getVilContId() {
		return this.vilContId;
	}

	public void setVilContId(Integer vilContId) {
		this.vilContId = vilContId;
	}

	public VilBasicInfo getVilBasicInfo() {
		return this.vilBasicInfo;
	}

	public void setVilBasicInfo(VilBasicInfo vilBasicInfo) {
		this.vilBasicInfo = vilBasicInfo;
	}

	public String getVilContNum() {
		return this.vilContNum;
	}

	public void setVilContNum(String vilContNum) {
		this.vilContNum = vilContNum;
	}

	public String getVilContName() {
		return this.vilContName;
	}

	public void setVilContName(String vilContName) {
		this.vilContName = vilContName;
	}

	public String getVilContWorkTel() {
		return this.vilContWorkTel;
	}

	public void setVilContWorkTel(String vilContWorkTel) {
		this.vilContWorkTel = vilContWorkTel;
	}

	public String getVilContMobTel() {
		return this.vilContMobTel;
	}

	public void setVilContMobTel(String vilContMobTel) {
		this.vilContMobTel = vilContMobTel;
	}

	public String getVilContComp() {
		return this.vilContComp;
	}

	public void setVilContComp(String vilContComp) {
		this.vilContComp = vilContComp;
	}

	public String getVilContPost() {
		return this.vilContPost;
	}

	public void setVilContPost(String vilContPost) {
		this.vilContPost = vilContPost;
	}

	public String getVilContNote() {
		return this.vilContNote;
	}

	public void setVilContNote(String vilContNote) {
		this.vilContNote = vilContNote;
	}

}