package com.nguyenthihongtrinh.entity;

/**
 * @author Nguyen Thi Hong Trinh
 * @since 13/12/2018
 */
public class Privilege {

	private Integer idPrivilege;
	private String 	name;
	private String description;
	public Privilege() {}
	public Privilege(Integer idPrivilege, String name, String description) {
		super();
		this.idPrivilege = idPrivilege;
		this.name = name;
		this.description = description;
	}
	public Integer getIdPrivilege() {
		return idPrivilege;
	}
	public void setIdPrivilege(Integer idPrivilege) {
		this.idPrivilege = idPrivilege;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}