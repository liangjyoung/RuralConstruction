package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * InvesPro entity. @author MyEclipse Persistence Tools
 */

public class InvesPro implements java.io.Serializable {

	// Fields

	private String invesProNum;
	private InvesPro invesPro;
	private String invesProName;
	private String invesProNote;
	private Set invesPros = new HashSet(0);
	private Set invesObjs = new HashSet(0);

	// Constructors

	/** default constructor */
	public InvesPro() {
	}

	/** full constructor */
	public InvesPro(InvesPro invesPro, String invesProName,
			String invesProNote, Set invesPros, Set invesObjs) {
		this.invesPro = invesPro;
		this.invesProName = invesProName;
		this.invesProNote = invesProNote;
		this.invesPros = invesPros;
		this.invesObjs = invesObjs;
	}

	// Property accessors

	public String getInvesProNum() {
		return this.invesProNum;
	}

	public void setInvesProNum(String invesProNum) {
		this.invesProNum = invesProNum;
	}

	public InvesPro getInvesPro() {
		return this.invesPro;
	}

	public void setInvesPro(InvesPro invesPro) {
		this.invesPro = invesPro;
	}

	public String getInvesProName() {
		return this.invesProName;
	}

	public void setInvesProName(String invesProName) {
		this.invesProName = invesProName;
	}

	public String getInvesProNote() {
		return this.invesProNote;
	}

	public void setInvesProNote(String invesProNote) {
		this.invesProNote = invesProNote;
	}

	public Set getInvesPros() {
		return this.invesPros;
	}

	public void setInvesPros(Set invesPros) {
		this.invesPros = invesPros;
	}

	public Set getInvesObjs() {
		return this.invesObjs;
	}

	public void setInvesObjs(Set invesObjs) {
		this.invesObjs = invesObjs;
	}

}