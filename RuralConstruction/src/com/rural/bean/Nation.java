package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Nation entity. @author MyEclipse Persistence Tools
 */

public class Nation implements java.io.Serializable {

	// Fields

	private Integer nationId;
	private String nationCode;
	private String nationName;
	private Set invgats = new HashSet(0);
	private Set experts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Nation() {
	}

	/** minimal constructor */
	public Nation(String nationCode) {
		this.nationCode = nationCode;
	}

	/** full constructor */
	public Nation(String nationCode, String nationName, Set invgats, Set experts) {
		this.nationCode = nationCode;
		this.nationName = nationName;
		this.invgats = invgats;
		this.experts = experts;
	}

	// Property accessors

	public Integer getNationId() {
		return this.nationId;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	public String getNationCode() {
		return this.nationCode;
	}

	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}

	public String getNationName() {
		return this.nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public Set getInvgats() {
		return this.invgats;
	}

	public void setInvgats(Set invgats) {
		this.invgats = invgats;
	}

	public Set getExperts() {
		return this.experts;
	}

	public void setExperts(Set experts) {
		this.experts = experts;
	}

}