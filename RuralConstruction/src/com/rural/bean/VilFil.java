package com.rural.bean;

import java.util.Date;

/**
 * VilFil entity. @author MyEclipse Persistence Tools
 */

public class VilFil implements java.io.Serializable {

	// Fields

	private Integer vilFilId;
	private GoveFilClfy goveFilClfy;
	private VilBasicInfo vilBasicInfo;
	private String vilFilNum;
	private String vilFilName;
	private String vilFilIdef;
	private Date vilFilMadTim;
	private String vilFilPubComp;
	private String vilFilExpl;

	// Constructors

	/** default constructor */
	public VilFil() {
	}

	/** full constructor */
	public VilFil(GoveFilClfy goveFilClfy, VilBasicInfo vilBasicInfo,
			String vilFilNum, String vilFilName, String vilFilIdef,
			Date vilFilMadTim, String vilFilPubComp, String vilFilExpl) {
		this.goveFilClfy = goveFilClfy;
		this.vilBasicInfo = vilBasicInfo;
		this.vilFilNum = vilFilNum;
		this.vilFilName = vilFilName;
		this.vilFilIdef = vilFilIdef;
		this.vilFilMadTim = vilFilMadTim;
		this.vilFilPubComp = vilFilPubComp;
		this.vilFilExpl = vilFilExpl;
	}

	// Property accessors

	public Integer getVilFilId() {
		return this.vilFilId;
	}

	public void setVilFilId(Integer vilFilId) {
		this.vilFilId = vilFilId;
	}

	public GoveFilClfy getGoveFilClfy() {
		return this.goveFilClfy;
	}

	public void setGoveFilClfy(GoveFilClfy goveFilClfy) {
		this.goveFilClfy = goveFilClfy;
	}

	public VilBasicInfo getVilBasicInfo() {
		return this.vilBasicInfo;
	}

	public void setVilBasicInfo(VilBasicInfo vilBasicInfo) {
		this.vilBasicInfo = vilBasicInfo;
	}

	public String getVilFilNum() {
		return this.vilFilNum;
	}

	public void setVilFilNum(String vilFilNum) {
		this.vilFilNum = vilFilNum;
	}

	public String getVilFilName() {
		return this.vilFilName;
	}

	public void setVilFilName(String vilFilName) {
		this.vilFilName = vilFilName;
	}

	public String getVilFilIdef() {
		return this.vilFilIdef;
	}

	public void setVilFilIdef(String vilFilIdef) {
		this.vilFilIdef = vilFilIdef;
	}

	public Date getVilFilMadTim() {
		return this.vilFilMadTim;
	}

	public void setVilFilMadTim(Date vilFilMadTim) {
		this.vilFilMadTim = vilFilMadTim;
	}

	public String getVilFilPubComp() {
		return this.vilFilPubComp;
	}

	public void setVilFilPubComp(String vilFilPubComp) {
		this.vilFilPubComp = vilFilPubComp;
	}

	public String getVilFilExpl() {
		return this.vilFilExpl;
	}

	public void setVilFilExpl(String vilFilExpl) {
		this.vilFilExpl = vilFilExpl;
	}

}