
package com.nguyenthihongtrinh.entity;

/**
 * @author Nguyen Thi Hong Trinh
 * @since 13/12/2018
 */
public class User {

	private Integer idUser;
	private String 	userName;
	private String passWord;
	private String fullName;
	private String email;
	private String address;
	private Boolean status;
	private Integer privilege_IdPrivilege;
	public User() {}
	
	public User(Integer idUser, String userName, String passWord, String fullName, String email, String address,
			Boolean status, Integer privilege_IdPrivilege) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.status = status;
		this.privilege_IdPrivilege = privilege_IdPrivilege;
	}

	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getPrivilege_IdPrivilege() {
		return privilege_IdPrivilege;
	}
	public void setPrivilege_IdPrivilege(Integer privilege_IdPrivilege) {
		this.privilege_IdPrivilege = privilege_IdPrivilege;
	}
	
	
}