package com.rural.bean;

/**
 * InvgatDwork entity. @author MyEclipse Persistence Tools
 */

public class InvgatDwork implements java.io.Serializable {

	// Fields

	private Integer invgatDworkId;
	private Invgat invgat;
	private VilBasicInfo vilBasicInfo;
	private String invgatDworkNote;

	// Constructors

	/** default constructor */
	public InvgatDwork() {
	}

	/** full constructor */
	public InvgatDwork(Invgat invgat, VilBasicInfo vilBasicInfo,
			String invgatDworkNote) {
		this.invgat = invgat;
		this.vilBasicInfo = vilBasicInfo;
		this.invgatDworkNote = invgatDworkNote;
	}

	// Property accessors

	public Integer getInvgatDworkId() {
		return this.invgatDworkId;
	}

	public void setInvgatDworkId(Integer invgatDworkId) {
		this.invgatDworkId = invgatDworkId;
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

	public String getInvgatDworkNote() {
		return this.invgatDworkNote;
	}

	public void setInvgatDworkNote(String invgatDworkNote) {
		this.invgatDworkNote = invgatDworkNote;
	}

}