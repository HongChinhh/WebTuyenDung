package com.nguyenthihongtrinh.entity;

import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.print.attribute.standard.DateTimeAtCreation;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class Post {

	private Integer idPost;
	private String body;
	private String title;
	private String url;
	private String noteImage;
	private String author;
	private Date creationTime;
	private Date publishedTime;
	private Boolean status;
	private Integer user_IdUser;
	private Integer subCategory_IdSubCategory;
	
	public Post() {
	}	
	
	



	public Post(Integer idPost, String body, String title, String url, String noteImage, String author,
			Date creationTime, Date publishedTime, Boolean status, Integer user_IdUser,
			Integer subCategory_IdSubCategory) {
		super();
		this.idPost = idPost;
		this.body = body;
		this.title = title;
		this.url = url;
		this.noteImage = noteImage;
		this.author = author;
		this.creationTime = creationTime;
		this.publishedTime = publishedTime;
		this.status = status;
		this.user_IdUser = user_IdUser;
		this.subCategory_IdSubCategory = subCategory_IdSubCategory;
	}





	public Integer getIdPost() {
		return idPost;
	}





	public void setIdPost(Integer idPost) {
		this.idPost = idPost;
	}





	public String getBody() {
		return body;
	}





	public void setBody(String body) {
		this.body = body;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getUrl() {
		return url;
	}





	public void setUrl(String url) {
		this.url = url;
	}





	public String getNoteImage() {
		return noteImage;
	}





	public void setNoteImage(String noteImage) {
		this.noteImage = noteImage;
	}





	public String getAuthor() {
		return author;
	}





	public void setAuthor(String author) {
		this.author = author;
	}





	public Date getCreationTime() {
		return creationTime;
	}





	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}





	public Date getPublishedTime() {
		return publishedTime;
	}





	public void setPublishedTime(Date publishedTime) {
		this.publishedTime = publishedTime;
	}





	public Boolean getStatus() {
		return status;
	}





	public void setStatus(Boolean status) {
		this.status = status;
	}





	public Integer getUser_IdUser() {
		return user_IdUser;
	}





	public void setUser_IdUser(Integer user_IdUser) {
		this.user_IdUser = user_IdUser;
	}





	public Integer getSubCategory_IdSubCategory() {
		return subCategory_IdSubCategory;
	}





	public void setSubCategory_IdSubCategory(Integer subCategory_IdSubCategory) {
		this.subCategory_IdSubCategory = subCategory_IdSubCategory;
	}

	
}