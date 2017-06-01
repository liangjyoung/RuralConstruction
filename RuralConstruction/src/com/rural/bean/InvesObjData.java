package com.rural.bean;

/**
 * InvesObjData entity. @author MyEclipse Persistence Tools
 */

public class InvesObjData implements java.io.Serializable {

	// Fields

	private Integer invesObjDataId;
	private VilDataCollRec vilDataCollRec;
	private InvesObj invesObj;
	private DataCollDicEntry dataCollDicEntry;
	private String invesObjDataValu;
	private String invesObjNote;

	// Constructors

	/** default constructor */
	public InvesObjData() {
	}

	/** full constructor */
	public InvesObjData(VilDataCollRec vilDataCollRec, InvesObj invesObj,
			DataCollDicEntry dataCollDicEntry, String invesObjDataValu,
			String invesObjNote) {
		this.vilDataCollRec = vilDataCollRec;
		this.invesObj = invesObj;
		this.dataCollDicEntry = dataCollDicEntry;
		this.invesObjDataValu = invesObjDataValu;
		this.invesObjNote = invesObjNote;
	}

	// Property accessors

	public Integer getInvesObjDataId() {
		return this.invesObjDataId;
	}

	public void setInvesObjDataId(Integer invesObjDataId) {
		this.invesObjDataId = invesObjDataId;
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

	public DataCollDicEntry getDataCollDicEntry() {
		return this.dataCollDicEntry;
	}

	public void setDataCollDicEntry(DataCollDicEntry dataCollDicEntry) {
		this.dataCollDicEntry = dataCollDicEntry;
	}

	public String getInvesObjDataValu() {
		return this.invesObjDataValu;
	}

	public void setInvesObjDataValu(String invesObjDataValu) {
		this.invesObjDataValu = invesObjDataValu;
	}

	public String getInvesObjNote() {
		return this.invesObjNote;
	}

	public void setInvesObjNote(String invesObjNote) {
		this.invesObjNote = invesObjNote;
	}

}