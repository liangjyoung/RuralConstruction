package com.rural.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * VilDataCollRec entity. @author MyEclipse Persistence Tools
 */

public class VilDataCollRec implements java.io.Serializable {

	// Fields

	private Integer vilDataCollRecId;
	private Invgat invgat;
	private VilBasicInfo vilBasicInfo;
	private Date collTim;
	private String vilDataCollRecNote;
	private String collEqptCode;
	private Set vilFilDatas = new HashSet(0);
	private Set vilEvalScos = new HashSet(0);
	private Set invesObjDatas = new HashSet(0);

	// Constructors

	/** default constructor */
	public VilDataCollRec() {
	}

	/** full constructor */
	public VilDataCollRec(Invgat invgat, VilBasicInfo vilBasicInfo,
			Date collTim, String vilDataCollRecNote,String collEqptCode, Set vilFilDatas,
			Set vilEvalScos, Set invesObjDatas) {
		this.invgat = invgat;
		this.vilBasicInfo = vilBasicInfo;
		this.collTim = collTim;
		this.vilDataCollRecNote = vilDataCollRecNote;
		this.vilFilDatas = vilFilDatas;
		this.vilEvalScos = vilEvalScos;
		this.invesObjDatas = invesObjDatas;
		this.collEqptCode=collEqptCode;
	}

	// Property accessors

	public Integer getVilDataCollRecId() {
		return this.vilDataCollRecId;
	}

	public void setVilDataCollRecId(Integer vilDataCollRecId) {
		this.vilDataCollRecId = vilDataCollRecId;
	}

	public Invgat getInvgat() {
		return this.invgat;
	}

	public void setInvgat(Invgat invgat) {
		this.invgat = invgat;
	}

	public VilBasicInfo getVilBasicInfo() {
		return this.vilBasicInfo;
	}

	public void setVilBasicInfo(VilBasicInfo vilBasicInfo) {
		this.vilBasicInfo = vilBasicInfo;
	}

	public Date getCollTim() {
		return this.collTim;
	}

	public void setCollTim(Date collTim) {
		this.collTim = collTim;
	}

	public String getVilDataCollRecNote() {
		return this.vilDataCollRecNote;
	}

	public void setVilDataCollRecNote(String vilDataCollRecNote) {
		this.vilDataCollRecNote = vilDataCollRecNote;
	}

    public String getCollEqptCode() {
        return this.collEqptCode;
    }
    
    public void setCollEqptCode(String collEqptCode) {
        this.collEqptCode = collEqptCode;
    }

	public Set getVilFilDatas() {
		return this.vilFilDatas;
	}

	public void setVilFilDatas(Set vilFilDatas) {
		this.vilFilDatas = vilFilDatas;
	}

	public Set getVilEvalScos() {
		return this.vilEvalScos;
	}

	public void setVilEvalScos(Set vilEvalScos) {
		this.vilEvalScos = vilEvalScos;
	}

	public Set getInvesObjDatas() {
		return this.invesObjDatas;
	}

	public void setInvesObjDatas(Set invesObjDatas) {
		this.invesObjDatas = invesObjDatas;
	}

}