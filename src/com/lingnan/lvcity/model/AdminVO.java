package com.lingnan.lvcity.model;

/**
 * 管理员信息类
 * @author Sunset
 *
 */
public class AdminVO {
	private int adminid;
	private String adminname;
	private String passwd;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
