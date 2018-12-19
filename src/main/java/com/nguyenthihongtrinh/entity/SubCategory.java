package com.nguyenthihongtrinh.entity;

/**
 * @author Nguyen Thi Hong Trinh
 * @since 13/12/2018
 */
public class SubCategory {

	private Integer idSubCategory;
	private String 	name;
	private String url;
	private Integer parentCategory_IdParentCategory;
	public SubCategory() {}
	
	

	public SubCategory(Integer idSubCategory, String name, String url, Integer parentCategory_IdParentCategory) {
		super();
		this.idSubCategory = idSubCategory;
		this.name = name;
		this.url = url;
		this.parentCategory_IdParentCategory = parentCategory_IdParentCategory;
	}



	public Integer getIdSubCategory() {
		return idSubCategory;
	}



	public void setIdSubCategory(Integer idSubCategory) {
		this.idSubCategory = idSubCategory;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Integer getParentCategory_IdParentCategory() {
		return parentCategory_IdParentCategory;
	}



	public void setParentCategory_IdParentCategory(Integer parentCategory_IdParentCategory) {
		this.parentCategory_IdParentCategory = parentCategory_IdParentCategory;
	}


	
}