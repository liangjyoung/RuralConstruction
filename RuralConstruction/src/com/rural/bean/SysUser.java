package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private Integer sysUserId;
	private String userName;
	private String userPas;
	private String userNote;
	private String userBeloDiviCode;
	private Set experts = new HashSet(0);
	private Set sysRoleUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** full constructor */
	public SysUser(String userName, String userPas, String userNote,
			String userBeloDiviCode, Set experts, Set sysRoleUsers) {
		this.userName = userName;
		this.userPas = userPas;
		this.userNote = userNote;
		this.userBeloDiviCode = userBeloDiviCode;
		this.experts = experts;
		this.sysRoleUsers = sysRoleUsers;
	}

	// Property accessors

	public Integer getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPas() {
		return this.userPas;
	}

	public void setUserPas(String userPas) {
		this.userPas = userPas;
	}

	public String getUserNote() {
		return this.userNote;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

	public String getUserBeloDiviCode() {
		return this.userBeloDiviCode;
	}

	public void setUserBeloDiviCode(String userBeloDiviCode) {
		this.userBeloDiviCode = userBeloDiviCode;
	}

	public Set getExperts() {
		return this.experts;
	}

	public void setExperts(Set experts) {
		this.experts = experts;
	}

	public Set getSysRoleUsers() {
		return this.sysRoleUsers;
	}

	public void setSysRoleUsers(Set sysRoleUsers) {
		this.sysRoleUsers = sysRoleUsers;
	}

}