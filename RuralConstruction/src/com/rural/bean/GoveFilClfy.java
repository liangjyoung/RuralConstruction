package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * GoveFilClfy entity. @author MyEclipse Persistence Tools
 */

public class GoveFilClfy implements java.io.Serializable {

	// Fields

	private Integer goveFilClfyId;
	private String goveFilClfyNum;
	private String goveFilClfyName;
	private String goveFilClfyNote;
	private Set vilFils = new HashSet(0);
	private Set proFils = new HashSet(0);
	private Set townFils = new HashSet(0);
	private Set citysFils = new HashSet(0);
	private Set countryFils = new HashSet(0);

	// Constructors

	/** default constructor */
	public GoveFilClfy() {
	}

	/** minimal constructor */
	public GoveFilClfy(String goveFilClfyNum) {
		this.goveFilClfyNum = goveFilClfyNum;
	}

	/** full constructor */
	public GoveFilClfy(String goveFilClfyNum, String goveFilClfyName,
			String goveFilClfyNote, Set vilFils, Set proFils, Set townFils,
			Set citysFils, Set countryFils) {
		this.goveFilClfyNum = goveFilClfyNum;
		this.goveFilClfyName = goveFilClfyName;
		this.goveFilClfyNote = goveFilClfyNote;
		this.vilFils = vilFils;
		this.proFils = proFils;
		this.townFils = townFils;
		this.citysFils = citysFils;
		this.countryFils = countryFils;
	}

	// Property accessors

	public Integer getGoveFilClfyId() {
		return this.goveFilClfyId;
	}

	public void setGoveFilClfyId(Integer goveFilClfyId) {
		this.goveFilClfyId = goveFilClfyId;
	}

	public String getGoveFilClfyNum() {
		return this.goveFilClfyNum;
	}

	public void setGoveFilClfyNum(String goveFilClfyNum) {
		this.goveFilClfyNum = goveFilClfyNum;
	}

	public String getGoveFilClfyName() {
		return this.goveFilClfyName;
	}

	public void setGoveFilClfyName(String goveFilClfyName) {
		this.goveFilClfyName = goveFilClfyName;
	}

	public String getGoveFilClfyNote() {
		return this.goveFilClfyNote;
	}

	public void setGoveFilClfyNote(String goveFilClfyNote) {
		this.goveFilClfyNote = goveFilClfyNote;
	}

	public Set getVilFils() {
		return this.vilFils;
	}

	public void setVilFils(Set vilFils) {
		this.vilFils = vilFils;
	}

	public Set getProFils() {
		return this.proFils;
	}

	public void setProFils(Set proFils) {
		this.proFils = proFils;
	}

	public Set getTownFils() {
		return this.townFils;
	}

	public void setTownFils(Set townFils) {
		this.townFils = townFils;
	}

	public Set getCitysFils() {
		return this.citysFils;
	}

	public void setCitysFils(Set citysFils) {
		this.citysFils = citysFils;
	}

	public Set getCountryFils() {
		return this.countryFils;
	}

	public void setCountryFils(Set countryFils) {
		this.countryFils = countryFils;
	}

}