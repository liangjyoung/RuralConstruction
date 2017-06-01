package com.rural.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Integer sysRoleId;
	private String roleName;
	private String roleNote;
	private Set sysRoleUsers = new HashSet(0);
	private Set roleFuncPerms = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** full constructor */
	public SysRole(String roleName, String roleNote, Set sysRoleUsers,
			Set roleFuncPerms) {
		this.roleName = roleName;
		this.roleNote = roleNote;
		this.sysRoleUsers = sysRoleUsers;
		this.roleFuncPerms = roleFuncPerms;
	}

	// Property accessors

	public Integer getSysRoleId() {
		return this.sysRoleId;
	}

	public void setSysRoleId(Integer sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleNote() {
		return this.roleNote;
	}

	public void setRoleNote(String roleNote) {
		this.roleNote = roleNote;
	}

	public Set getSysRoleUsers() {
		return this.sysRoleUsers;
	}

	public void setSysRoleUsers(Set sysRoleUsers) {
		this.sysRoleUsers = sysRoleUsers;
	}

	public Set getRoleFuncPerms() {
		return this.roleFuncPerms;
	}

	public void setRoleFuncPerms(Set roleFuncPerms) {
		this.roleFuncPerms = roleFuncPerms;
	}

}