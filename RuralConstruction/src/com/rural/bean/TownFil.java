package com.rural.bean;

import java.util.Date;

/**
 * TownFil entity. @author MyEclipse Persistence Tools
 */

public class TownFil implements java.io.Serializable {

	// Fields

	private Integer townFilId;
	private GoveFilClfy goveFilClfy;
	private TownBasicInfo townBasicInfo;
	private String townFilNum;
	private String townFilName;
	private String townFilIdef;
	private Date townFilMadTim;
	private String townFilPubComp;
	private String townFilExpl;

	// Constructors

	/** default constructor */
	public TownFil() {
	}

	/** full constructor */
	public TownFil(GoveFilClfy goveFilClfy, TownBasicInfo townBasicInfo,
			String townFilNum, String townFilName, String townFilIdef,
			Date townFilMadTim, String townFilPubComp, String townFilExpl) {
		this.goveFilClfy = goveFilClfy;
		this.townBasicInfo = townBasicInfo;
		this.townFilNum = townFilNum;
		this.townFilName = townFilName;
		this.townFilIdef = townFilIdef;
		this.townFilMadTim = townFilMadTim;
		this.townFilPubComp = townFilPubComp;
		this.townFilExpl = townFilExpl;
	}

	// Property accessors

	public Integer getTownFilId() {
		return this.townFilId;
	}

	public void setTownFilId(Integer townFilId) {
		this.townFilId = townFilId;
	}

	public GoveFilClfy getGoveFilClfy() {
		return this.goveFilClfy;
	}

	public void setGoveFilClfy(GoveFilClfy goveFilClfy) {
		this.goveFilClfy = goveFilClfy;
	}

	public TownBasicInfo getTownBasicInfo() {
		return this.townBasicInfo;
	}

	public void setTownBasicInfo(TownBasicInfo townBasicInfo) {
		this.townBasicInfo = townBasicInfo;
	}

	public String getTownFilNum() {
		return this.townFilNum;
	}

	public void setTownFilNum(String townFilNum) {
		this.townFilNum = townFilNum;
	}

	public String getTownFilName() {
		return this.townFilName;
	}

	public void setTownFilName(String townFilName) {
		this.townFilName = townFilName;
	}

	public String getTownFilIdef() {
		return this.townFilIdef;
	}

	public void setTownFilIdef(String townFilIdef) {
		this.townFilIdef = townFilIdef;
	}

	public Date getTownFilMadTim() {
		return this.townFilMadTim;
	}

	public void setTownFilMadTim(Date townFilMadTim) {
		this.townFilMadTim = townFilMadTim;
	}

	public String getTownFilPubComp() {
		return this.townFilPubComp;
	}

	public void setTownFilPubComp(String townFilPubComp) {
		this.townFilPubComp = townFilPubComp;
	}

	public String getTownFilExpl() {
		return this.townFilExpl;
	}

	public void setTownFilExpl(String townFilExpl) {
		this.townFilExpl = townFilExpl;
	}

}