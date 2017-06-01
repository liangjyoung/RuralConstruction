package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Edu entity. @author MyEclipse Persistence Tools
 */

public class Edu implements java.io.Serializable {

	// Fields

	private Integer eduId;
	private String eduCode;
	private String eduName;
	private Set invgats = new HashSet(0);
	private Set experts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Edu() {
	}

	/** minimal constructor */
	public Edu(String eduCode) {
		this.eduCode = eduCode;
	}

	/** full constructor */
	public Edu(String eduCode, String eduName, Set invgats, Set experts) {
		this.eduCode = eduCode;
		this.eduName = eduName;
		this.invgats = invgats;
		this.experts = experts;
	}

	// Property accessors

	public Integer getEduId() {
		return this.eduId;
	}

	public void setEduId(Integer eduId) {
		this.eduId = eduId;
	}

	public String getEduCode() {
		return this.eduCode;
	}

	public void setEduCode(String eduCode) {
		this.eduCode = eduCode;
	}

	public String getEduName() {
		return this.eduName;
	}

	public void setEduName(String eduName) {
		this.eduName = eduName;
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