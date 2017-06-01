package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Pol entity. @author MyEclipse Persistence Tools
 */

public class Pol implements java.io.Serializable {

	// Fields

	private Integer polId;
	private String polCode;
	private String polName;
	private Set invgats = new HashSet(0);
	private Set experts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Pol() {
	}

	/** minimal constructor */
	public Pol(String polCode) {
		this.polCode = polCode;
	}

	/** full constructor */
	public Pol(String polCode, String polName, Set invgats, Set experts) {
		this.polCode = polCode;
		this.polName = polName;
		this.invgats = invgats;
		this.experts = experts;
	}

	// Property accessors

	public Integer getPolId() {
		return this.polId;
	}

	public void setPolId(Integer polId) {
		this.polId = polId;
	}

	public String getPolCode() {
		return this.polCode;
	}

	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}

	public String getPolName() {
		return this.polName;
	}

	public void setPolName(String polName) {
		this.polName = polName;
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