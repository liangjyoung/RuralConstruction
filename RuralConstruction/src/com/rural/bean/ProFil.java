package com.rural.bean;

import java.util.Date;

/**
 * ProFil entity. @author MyEclipse Persistence Tools
 */

public class ProFil implements java.io.Serializable {

	// Fields

	private Integer proFilId;
	private GoveFilClfy goveFilClfy;
	private ProBasicInfo proBasicInfo;
	private String proFilNum;
	private String proFilName;
	private String proFilIdef;
	private Date proFilMadTim;
	private String proFilPubComp;
	private String proFilExpl;

	// Constructors

	/** default constructor */
	public ProFil() {
	}

	/** full constructor */
	public ProFil(GoveFilClfy goveFilClfy, ProBasicInfo proBasicInfo,
			String proFilNum, String proFilName, String proFilIdef,
			Date proFilMadTim, String proFilPubComp, String proFilExpl) {
		this.goveFilClfy = goveFilClfy;
		this.proBasicInfo = proBasicInfo;
		this.proFilNum = proFilNum;
		this.proFilName = proFilName;
		this.proFilIdef = proFilIdef;
		this.proFilMadTim = proFilMadTim;
		this.proFilPubComp = proFilPubComp;
		this.proFilExpl = proFilExpl;
	}

	// Property accessors

	public Integer getProFilId() {
		return this.proFilId;
	}

	public void setProFilId(Integer proFilId) {
		this.proFilId = proFilId;
	}

	public GoveFilClfy getGoveFilClfy() {
		return this.goveFilClfy;
	}

	public void setGoveFilClfy(GoveFilClfy goveFilClfy) {
		this.goveFilClfy = goveFilClfy;
	}

	public ProBasicInfo getProBasicInfo() {
		return this.proBasicInfo;
	}

	public void setProBasicInfo(ProBasicInfo proBasicInfo) {
		this.proBasicInfo = proBasicInfo;
	}

	public String getProFilNum() {
		return this.proFilNum;
	}

	public void setProFilNum(String proFilNum) {
		this.proFilNum = proFilNum;
	}

	public String getProFilName() {
		return this.proFilName;
	}

	public void setProFilName(String proFilName) {
		this.proFilName = proFilName;
	}

	public String getProFilIdef() {
		return this.proFilIdef;
	}

	public void setProFilIdef(String proFilIdef) {
		this.proFilIdef = proFilIdef;
	}

	public Date getProFilMadTim() {
		return this.proFilMadTim;
	}

	public void setProFilMadTim(Date proFilMadTim) {
		this.proFilMadTim = proFilMadTim;
	}

	public String getProFilPubComp() {
		return this.proFilPubComp;
	}

	public void setProFilPubComp(String proFilPubComp) {
		this.proFilPubComp = proFilPubComp;
	}

	public String getProFilExpl() {
		return this.proFilExpl;
	}

	public void setProFilExpl(String proFilExpl) {
		this.proFilExpl = proFilExpl;
	}

}