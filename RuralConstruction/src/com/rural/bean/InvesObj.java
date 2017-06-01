package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * InvesObj entity. @author MyEclipse Persistence Tools
 */

public class InvesObj implements java.io.Serializable {

	// Fields

	private Integer invesObjId;
	private DataCollDataDic dataCollDataDic;
	private InvesObjAttri invesObjAttri;
	private InvesPro invesPro;
	private String invesObjCode;
	private String invesObjName;
	private String invesObjComp;
	private String invesObjLengt;
	private boolean isMustCollData;
	private String invesObjNote;
	private Set invesObjDatas = new HashSet(0);
	private Set evalContInvesObjs = new HashSet(0);
	private Set vilFilDatas = new HashSet(0);

	// Constructors

	/** default constructor */
	public InvesObj() {
	}

	/** minimal constructor */
	public InvesObj(String invesObjCode) {
		this.invesObjCode = invesObjCode;
	}

	/** full constructor */
	public InvesObj(DataCollDataDic dataCollDataDic,
			InvesObjAttri invesObjAttri, InvesPro invesPro,
			String invesObjCode, String invesObjName, String invesObjComp,
			String invesObjLengt, boolean isMustCollData, String invesObjNote,
			Set invesObjDatas, Set evalContInvesObjs, Set vilFilDatas) {
		this.dataCollDataDic = dataCollDataDic;
		this.invesObjAttri = invesObjAttri;
		this.invesPro = invesPro;
		this.invesObjCode = invesObjCode;
		this.invesObjName = invesObjName;
		this.invesObjComp = invesObjComp;
		this.invesObjLengt = invesObjLengt;
		this.isMustCollData = isMustCollData;
		this.invesObjNote = invesObjNote;
		this.invesObjDatas = invesObjDatas;
		this.evalContInvesObjs = evalContInvesObjs;
		this.vilFilDatas = vilFilDatas;
	}

	// Property accessors

	public Integer getInvesObjId() {
		return this.invesObjId;
	}

	public void setInvesObjId(Integer invesObjId) {
		this.invesObjId = invesObjId;
	}

	public DataCollDataDic getDataCollDataDic() {
		return this.dataCollDataDic;
	}

	public void setDataCollDataDic(DataCollDataDic dataCollDataDic) {
		this.dataCollDataDic = dataCollDataDic;
	}

	public InvesObjAttri getInvesObjAttri() {
		return this.invesObjAttri;
	}

	public void setInvesObjAttri(InvesObjAttri invesObjAttri) {
		this.invesObjAttri = invesObjAttri;
	}

	public InvesPro getInvesPro() {
		return this.invesPro;
	}

	public void setInvesPro(InvesPro invesPro) {
		this.invesPro = invesPro;
	}

	public String getInvesObjCode() {
		return this.invesObjCode;
	}

	public void setInvesObjCode(String invesObjCode) {
		this.invesObjCode = invesObjCode;
	}

	public String getInvesObjName() {
		return this.invesObjName;
	}

	public void setInvesObjName(String invesObjName) {
		this.invesObjName = invesObjName;
	}

	public String getInvesObjComp() {
		return this.invesObjComp;
	}

	public void setInvesObjComp(String invesObjComp) {
		this.invesObjComp = invesObjComp;
	}

	public String getInvesObjLengt() {
		return this.invesObjLengt;
	}

	public void setInvesObjLengt(String invesObjLengt) {
		this.invesObjLengt = invesObjLengt;
	}

	public boolean getIsMustCollData() {
		return this.isMustCollData;
	}

	public void setIsMustCollData(boolean isMustCollData) {
		this.isMustCollData = isMustCollData;
	}

	public String getInvesObjNote() {
		return this.invesObjNote;
	}

	public void setInvesObjNote(String invesObjNote) {
		this.invesObjNote = invesObjNote;
	}

	public Set getInvesObjDatas() {
		return this.invesObjDatas;
	}

	public void setInvesObjDatas(Set invesObjDatas) {
		this.invesObjDatas = invesObjDatas;
	}

	public Set getEvalContInvesObjs() {
		return this.evalContInvesObjs;
	}

	public void setEvalContInvesObjs(Set evalContInvesObjs) {
		this.evalContInvesObjs = evalContInvesObjs;
	}

	public Set getVilFilDatas() {
		return this.vilFilDatas;
	}

	public void setVilFilDatas(Set vilFilDatas) {
		this.vilFilDatas = vilFilDatas;
	}

}