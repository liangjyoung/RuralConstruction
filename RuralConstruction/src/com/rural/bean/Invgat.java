package com.rural.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Invgat entity. @author MyEclipse Persistence Tools
 */

public class Invgat implements java.io.Serializable {

	// Fields

	private Integer invgatId;
	private Edu edu;
	private Pol pol;
	private Sex sex;
	private Nation nation;
	private String invgatNum;
	private String invgatMajor;
	private String invgatName;
	private Date invgatBirth;
	private String invgatComp;
	private String invgatTel;
	private String invgatNote;
	private Set vilDataCollRecs = new HashSet(0);
	private Set invgatDworks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Invgat() {
	}

	/** minimal constructor */
	public Invgat(String invgatNum) {
		this.invgatNum = invgatNum;
	}

	/** full constructor */
	public Invgat(Edu edu, Pol pol, Sex sex, Nation nation, String invgatNum,
			String invgatMajor, String invgatName, Date invgatBirth,
			String invgatComp, String invgatTel, String invgatNote,
			Set vilDataCollRecs, Set invgatDworks) {
		this.edu = edu;
		this.pol = pol;
		this.sex = sex;
		this.nation = nation;
		this.invgatNum = invgatNum;
		this.invgatMajor = invgatMajor;
		this.invgatName = invgatName;
		this.invgatBirth = invgatBirth;
		this.invgatComp = invgatComp;
		this.invgatTel = invgatTel;
		this.invgatNote = invgatNote;
		this.vilDataCollRecs = vilDataCollRecs;
		this.invgatDworks = invgatDworks;
	}

	// Property accessors

	public Integer getInvgatId() {
		return this.invgatId;
	}

	public void setInvgatId(Integer invgatId) {
		this.invgatId = invgatId;
	}

	public Edu getEdu() {
		return this.edu;
	}

	public void setEdu(Edu edu) {
		this.edu = edu;
	}

	public Pol getPol() {
		return this.pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public Sex getSex() {
		return this.sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Nation getNation() {
		return this.nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public String getInvgatNum() {
		return this.invgatNum;
	}

	public void setInvgatNum(String invgatNum) {
		this.invgatNum = invgatNum;
	}

	public String getInvgatMajor() {
		return this.invgatMajor;
	}

	public void setInvgatMajor(String invgatMajor) {
		this.invgatMajor = invgatMajor;
	}

	public String getInvgatName() {
		return this.invgatName;
	}

	public void setInvgatName(String invgatName) {
		this.invgatName = invgatName;
	}

	public Date getInvgatBirth() {
		return this.invgatBirth;
	}

	public void setInvgatBirth(Date invgatBirth) {
		this.invgatBirth = invgatBirth;
	}

	public String getInvgatComp() {
		return this.invgatComp;
	}

	public void setInvgatComp(String invgatComp) {
		this.invgatComp = invgatComp;
	}

	public String getInvgatTel() {
		return this.invgatTel;
	}

	public void setInvgatTel(String invgatTel) {
		this.invgatTel = invgatTel;
	}

	public String getInvgatNote() {
		return this.invgatNote;
	}

	public void setInvgatNote(String invgatNote) {
		this.invgatNote = invgatNote;
	}

	public Set getVilDataCollRecs() {
		return this.vilDataCollRecs;
	}

	public void setVilDataCollRecs(Set vilDataCollRecs) {
		this.vilDataCollRecs = vilDataCollRecs;
	}

	public Set getInvgatDworks() {
		return this.invgatDworks;
	}

	public void setInvgatDworks(Set invgatDworks) {
		this.invgatDworks = invgatDworks;
	}

}