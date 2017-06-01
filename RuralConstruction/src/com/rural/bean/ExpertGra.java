package com.rural.bean;

import java.util.Date;

/**
 * ExpertGra entity. @author MyEclipse Persistence Tools
 */

public class ExpertGra implements java.io.Serializable {

	// Fields

	private Integer expertGraId;
	private EvalExpertDist evalExpertDist;
	private Integer evalContId;
	private Date graTim;
	private String sco;
	private String graDev;
	private String graRea;
	private String belState;
	private String expertGraNote;

	// Constructors

	/** default constructor */
	public ExpertGra() {
	}

	/** full constructor */
	public ExpertGra(EvalExpertDist evalExpertDist, Integer evalContId,
			Date graTim, String sco, String graDev, String graRea,
			String belState, String expertGraNote) {
		this.evalExpertDist = evalExpertDist;
		this.evalContId = evalContId;
		this.graTim = graTim;
		this.sco = sco;
		this.graDev = graDev;
		this.graRea = graRea;
		this.belState = belState;
		this.expertGraNote = expertGraNote;
	}

	// Property accessors

	public Integer getExpertGraId() {
		return this.expertGraId;
	}

	public void setExpertGraId(Integer expertGraId) {
		this.expertGraId = expertGraId;
	}

	public EvalExpertDist getEvalExpertDist() {
		return this.evalExpertDist;
	}

	public void setEvalExpertDist(EvalExpertDist evalExpertDist) {
		this.evalExpertDist = evalExpertDist;
	}

	public Integer getEvalContId() {
		return this.evalContId;
	}

	public void setEvalContId(Integer evalContId) {
		this.evalContId = evalContId;
	}

	public Date getGraTim() {
		return this.graTim;
	}

	public void setGraTim(Date graTim) {
		this.graTim = graTim;
	}

	public String getSco() {
		return this.sco;
	}

	public void setSco(String sco) {
		this.sco = sco;
	}

	public String getGraDev() {
		return this.graDev;
	}

	public void setGraDev(String graDev) {
		this.graDev = graDev;
	}

	public String getGraRea() {
		return this.graRea;
	}

	public void setGraRea(String graRea) {
		this.graRea = graRea;
	}

	public String getBelState() {
		return this.belState;
	}

	public void setBelState(String belState) {
		this.belState = belState;
	}

	public String getExpertGraNote() {
		return this.expertGraNote;
	}

	public void setExpertGraNote(String expertGraNote) {
		this.expertGraNote = expertGraNote;
	}

}