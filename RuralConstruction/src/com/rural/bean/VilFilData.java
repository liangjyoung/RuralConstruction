package com.rural.bean;

/**
 * VilFilData entity. @author MyEclipse Persistence Tools
 */

public class VilFilData implements java.io.Serializable {

	// Fields

	private Integer vilFilDataId;
	private VilDataCollRec vilDataCollRec;
	private InvesObj invesObj;
	private String vilFilIdef;
	private String vilFilExpl;

	// Constructors

	/** default constructor */
	public VilFilData() {
	}

	/** full constructor */
	public VilFilData(VilDataCollRec vilDataCollRec, InvesObj invesObj,
			String vilFilIdef, String vilFilExpl) {
		this.vilDataCollRec = vilDataCollRec;
		this.invesObj = invesObj;
		this.vilFilIdef = vilFilIdef;
		this.vilFilExpl = vilFilExpl;
	}

	// Property accessors

	public Integer getVilFilDataId() {
		return this.vilFilDataId;
	}

	public void setVilFilDataId(Integer vilFilDataId) {
		this.vilFilDataId = vilFilDataId;
	}

	public VilDataCollRec getVilDataCollRec() {
		return this.vilDataCollRec;
	}

	public void setVilDataCollRec(VilDataCollRec vilDataCollRec) {
		this.vilDataCollRec = vilDataCollRec;
	}

	public InvesObj getInvesObj() {
		return this.invesObj;
	}

	public void setInvesObj(InvesObj invesObj) {
		this.invesObj = invesObj;
	}

	public String getVilFilIdef() {
		return this.vilFilIdef;
	}

	public void setVilFilIdef(String vilFilIdef) {
		this.vilFilIdef = vilFilIdef;
	}

	public String getVilFilExpl() {
		return this.vilFilExpl;
	}

	public void setVilFilExpl(String vilFilExpl) {
		this.vilFilExpl = vilFilExpl;
	}

}