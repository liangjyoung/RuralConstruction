package com.rural.bean;

/**
 * SysRoleUser entity. @author MyEclipse Persistence Tools
 */

public class SysRoleUser implements java.io.Serializable {

	// Fields

	private Integer sysRoleUserId;
	private SysUser sysUser;
	private SysRole sysRole;
	private String sysRoleUserNote;

	// Constructors

	/** default constructor */
	public SysRoleUser() {
	}

	/** full constructor */
	public SysRoleUser(SysUser sysUser, SysRole sysRole, String sysRoleUserNote) {
		this.sysUser = sysUser;
		this.sysRole = sysRole;
		this.sysRoleUserNote = sysRoleUserNote;
	}

	// Property accessors

	public Integer getSysRoleUserId() {
		return this.sysRoleUserId;
	}

	public void setSysRoleUserId(Integer sysRoleUserId) {
		this.sysRoleUserId = sysRoleUserId;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public String getSysRoleUserNote() {
		return this.sysRoleUserNote;
	}

	public void setSysRoleUserNote(String sysRoleUserNote) {
		this.sysRoleUserNote = sysRoleUserNote;
	}

}