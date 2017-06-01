package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * InvesObjAttri entity. @author MyEclipse Persistence Tools
 */

public class InvesObjAttri implements java.io.Serializable {

	// Fields

	private Integer invesObjAttriId;
	private String invesObjAttriNum;
	private String invesObjAttriName;
	private Set invesObjs = new HashSet(0);

	// Constructors

	/** default constructor */
	public InvesObjAttri() {
	}

	/** minimal constructor */
	public InvesObjAttri(String invesObjAttriNum) {
		this.invesObjAttriNum = invesObjAttriNum;
	}

	/** full constructor */
	public InvesObjAttri(String invesObjAttriNum, String invesObjAttriName,
			Set invesObjs) {
		this.invesObjAttriNum = invesObjAttriNum;
		this.invesObjAttriName = invesObjAttriName;
		this.invesObjs = invesObjs;
	}

	// Property accessors

	public Integer getInvesObjAttriId() {
		return this.invesObjAttriId;
	}

	public void setInvesObjAttriId(Integer invesObjAttriId) {
		this.invesObjAttriId = invesObjAttriId;
	}

	public String getInvesObjAttriNum() {
		return this.invesObjAttriNum;
	}

	public void setInvesObjAttriNum(String invesObjAttriNum) {
		this.invesObjAttriNum = invesObjAttriNum;
	}

	public String getInvesObjAttriName() {
		return this.invesObjAttriName;
	}

	public void setInvesObjAttriName(String invesObjAttriName) {
		this.invesObjAttriName = invesObjAttriName;
	}

	public Set getInvesObjs() {
		return this.invesObjs;
	}

	public void setInvesObjs(Set invesObjs) {
		this.invesObjs = invesObjs;
	}

}