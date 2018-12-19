package com.nguyenthihongtrinh.entity;

/**
 * @author Nguyen Thi Hong Trinh
 * @since 13/12/2018
 */
public class ParentCategory {

	private Integer idParentCategory;
	private String 	nameParentCat;
	private Boolean status;
	public ParentCategory() {}
	
	public ParentCategory(Integer idParentCategory, String nameParentCat, Boolean status) {		
		this.idParentCategory = idParentCategory;
		this.nameParentCat = nameParentCat;
		this.status = status;
	}

	public Integer getIdParentCategory() {
		return idParentCategory;
	}
	public void setIdParentCategory(Integer idParentCategory) {
		this.idParentCategory = idParentCategory;
	}
	public String getNameParentCat() {
		return nameParentCat;
	}
	public void setNameParentCat(String nameParentCat) {
		this.nameParentCat = nameParentCat;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}