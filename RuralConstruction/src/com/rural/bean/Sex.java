package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Sex entity. @author MyEclipse Persistence Tools
 */

public class Sex implements java.io.Serializable {

	// Fields

	private Integer sexId;
	private String sexCode;
	private String sexName;
	private Set invgats = new HashSet(0);
	private Set experts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sex() {
	}

	/** minimal constructor */
	public Sex(String sexCode) {
		this.sexCode = sexCode;
	}

	/** full constructor */
	public Sex(String sexCode, String sexName, Set invgats, Set experts) {
		this.sexCode = sexCode;
		this.sexName = sexName;
		this.invgats = invgats;
		this.experts = experts;
	}

	// Property accessors

	public Integer getSexId() {
		return this.sexId;
	}

	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}

	public String getSexCode() {
		return this.sexCode;
	}

	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}

	public String getSexName() {
		return this.sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
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