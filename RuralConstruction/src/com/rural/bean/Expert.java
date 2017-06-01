package com.rural.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Expert entity. @author MyEclipse Persistence Tools
 */

public class Expert implements java.io.Serializable {

	// Fields

	private Integer expertId;
	private Edu edu;
	private Pol pol;
	private Sex sex;
	private Nation nation;
	private SysUser sysUser;
	private ExpertMajorCatg expertMajorCatg;
	private String expertNum;
	private String expertName;
	private Date expertBirth;
	private String expertTitle;
	private String expertPost;
	private String expertWorkTel;
	private String expertMobTel;
	private String expertComp;
	private String expertGraReli;
	private String expertEmail;
	private String expertWx;
	private String expertAddress;
	private String expertBank;
	private String expertAccount;
	private Set evalExpertDists = new HashSet(0);

	// Constructors

	/** default constructor */
	public Expert() {
	}

	/** full constructor */
	public Expert(Edu edu, Pol pol, Sex sex, Nation nation, SysUser sysUser,
			ExpertMajorCatg expertMajorCatg, String expertNum,
			String expertName, Date expertBirth, String expertTitle,
			String expertPost, String expertWorkTel, String expertMobTel,
			String expertComp, String expertGraReli, String expertEmail,
			String expertWx, String expertAddress, String expertBank,
			String expertAccount, Set evalExpertDists) {
		this.edu = edu;
		this.pol = pol;
		this.sex = sex;
		this.nation = nation;
		this.sysUser = sysUser;
		this.expertMajorCatg = expertMajorCatg;
		this.expertNum = expertNum;
		this.expertName = expertName;
		this.expertBirth = expertBirth;
		this.expertTitle = expertTitle;
		this.expertPost = expertPost;
		this.expertWorkTel = expertWorkTel;
		this.expertMobTel = expertMobTel;
		this.expertComp = expertComp;
		this.expertGraReli = expertGraReli;
		this.expertEmail = expertEmail;
		this.expertWx = expertWx;
		this.expertAddress = expertAddress;
		this.expertBank = expertBank;
		this.expertAccount = expertAccount;
		this.evalExpertDists = evalExpertDists;
	}

	// Property accessors

	public Integer getExpertId() {
		return this.expertId;
	}

	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
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

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public ExpertMajorCatg getExpertMajorCatg() {
		return this.expertMajorCatg;
	}

	public void setExpertMajorCatg(ExpertMajorCatg expertMajorCatg) {
		this.expertMajorCatg = expertMajorCatg;
	}

	public String getExpertNum() {
		return this.expertNum;
	}

	public void setExpertNum(String expertNum) {
		this.expertNum = expertNum;
	}

	public String getExpertName() {
		return this.expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public Date getExpertBirth() {
		return this.expertBirth;
	}

	public void setExpertBirth(Date expertBirth) {
		this.expertBirth = expertBirth;
	}

	public String getExpertTitle() {
		return this.expertTitle;
	}

	public void setExpertTitle(String expertTitle) {
		this.expertTitle = expertTitle;
	}

	public String getExpertPost() {
		return this.expertPost;
	}

	public void setExpertPost(String expertPost) {
		this.expertPost = expertPost;
	}

	public String getExpertWorkTel() {
		return this.expertWorkTel;
	}

	public void setExpertWorkTel(String expertWorkTel) {
		this.expertWorkTel = expertWorkTel;
	}

	public String getExpertMobTel() {
		return this.expertMobTel;
	}

	public void setExpertMobTel(String expertMobTel) {
		this.expertMobTel = expertMobTel;
	}

	public String getExpertComp() {
		return this.expertComp;
	}

	public void setExpertComp(String expertComp) {
		this.expertComp = expertComp;
	}

	public String getExpertGraReli() {
		return this.expertGraReli;
	}

	public void setExpertGraReli(String expertGraReli) {
		this.expertGraReli = expertGraReli;
	}

	public String getExpertEmail() {
		return this.expertEmail;
	}

	public void setExpertEmail(String expertEmail) {
		this.expertEmail = expertEmail;
	}

	public String getExpertWx() {
		return this.expertWx;
	}

	public void setExpertWx(String expertWx) {
		this.expertWx = expertWx;
	}

	public String getExpertAddress() {
		return this.expertAddress;
	}

	public void setExpertAddress(String expertAddress) {
		this.expertAddress = expertAddress;
	}

	public String getExpertBank() {
		return this.expertBank;
	}

	public void setExpertBank(String expertBank) {
		this.expertBank = expertBank;
	}

	public String getExpertAccount() {
		return this.expertAccount;
	}

	public void setExpertAccount(String expertAccount) {
		this.expertAccount = expertAccount;
	}

	public Set getEvalExpertDists() {
		return this.evalExpertDists;
	}

	public void setEvalExpertDists(Set evalExpertDists) {
		this.evalExpertDists = evalExpertDists;
	}

}