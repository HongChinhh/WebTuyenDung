package com.nguyenthihongtrinh.entity;

/**
 * @author Nguyen Thi Hong Trinh
 * @since 13/12/2018
 */
public class FeedBack {

	private Integer IdFeedBack;
	private String 	content;	
	private Integer user_IdUser;
	private Integer post_IdPost;
	public FeedBack() {}
	
	public FeedBack(Integer idFeedBack, String content, Integer user_IdUser, Integer post_IdPost) {
		super();
		IdFeedBack = idFeedBack;
		this.content = content;
		this.user_IdUser = user_IdUser;
		this.post_IdPost = post_IdPost;
	}

	public Integer getIdFeedBack() {
		return IdFeedBack;
	}
	public void setIdFeedBack(Integer idFeedBack) {
		IdFeedBack = idFeedBack;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUser_IdUser() {
		return user_IdUser;
	}
	public void setUser_IdUser(Integer user_IdUser) {
		this.user_IdUser = user_IdUser;
	}
	public Integer getPost_IdPost() {
		return post_IdPost;
	}
	public void setPost_IdPost(Integer post_IdPost) {
		this.post_IdPost = post_IdPost;
	}
	
	
}