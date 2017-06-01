package com.rural.bean;

import java.util.Date;

/**
 * CitysFil entity. @author MyEclipse Persistence Tools
 */

public class CitysFil implements java.io.Serializable {

	// Fields

	private Integer citysFilId;
	private CityBasicInfo cityBasicInfo;
	private GoveFilClfy goveFilClfy;
	private String citysFilNum;
	private String citysFilName;
	private String citysFilIdef;
	private Date citysFilMadTim;
	private String citysFilPubComp;
	private String citysFilExpl;

	// Constructors

	/** default constructor */
	public CitysFil() {
	}

	/** full constructor */
	public CitysFil(CityBasicInfo cityBasicInfo, GoveFilClfy goveFilClfy,
			String citysFilNum, String citysFilName, String citysFilIdef,
			Date citysFilMadTim, String citysFilPubComp, String citysFilExpl) {
		this.cityBasicInfo = cityBasicInfo;
		this.goveFilClfy = goveFilClfy;
		this.citysFilNum = citysFilNum;
		this.citysFilName = citysFilName;
		this.citysFilIdef = citysFilIdef;
		this.citysFilMadTim = citysFilMadTim;
		this.citysFilPubComp = citysFilPubComp;
		this.citysFilExpl = citysFilExpl;
	}

	// Property accessors

	public Integer getCitysFilId() {
		return this.citysFilId;
	}

	public void setCitysFilId(Integer citysFilId) {
		this.citysFilId = citysFilId;
	}

	public CityBasicInfo getCityBasicInfo() {
		return this.cityBasicInfo;
	}

	public void setCityBasicInfo(CityBasicInfo cityBasicInfo) {
		this.cityBasicInfo = cityBasicInfo;
	}

	public GoveFilClfy getGoveFilClfy() {
		return this.goveFilClfy;
	}

	public void setGoveFilClfy(GoveFilClfy goveFilClfy) {
		this.goveFilClfy = goveFilClfy;
	}

	public String getCitysFilNum() {
		return this.citysFilNum;
	}

	public void setCitysFilNum(String citysFilNum) {
		this.citysFilNum = citysFilNum;
	}

	public String getCitysFilName() {
		return this.citysFilName;
	}

	public void setCitysFilName(String citysFilName) {
		this.citysFilName = citysFilName;
	}

	public String getCitysFilIdef() {
		return this.citysFilIdef;
	}

	public void setCitysFilIdef(String citysFilIdef) {
		this.citysFilIdef = citysFilIdef;
	}

	public Date getCitysFilMadTim() {
		return this.citysFilMadTim;
	}

	public void setCitysFilMadTim(Date citysFilMadTim) {
		this.citysFilMadTim = citysFilMadTim;
	}

	public String getCitysFilPubComp() {
		return this.citysFilPubComp;
	}

	public void setCitysFilPubComp(String citysFilPubComp) {
		this.citysFilPubComp = citysFilPubComp;
	}

	public String getCitysFilExpl() {
		return this.citysFilExpl;
	}

	public void setCitysFilExpl(String citysFilExpl) {
		this.citysFilExpl = citysFilExpl;
	}

}