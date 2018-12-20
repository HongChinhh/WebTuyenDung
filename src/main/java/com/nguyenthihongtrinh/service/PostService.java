package com.nguyenthihongtrinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.nguyenthihongtrinh.dao.ParentCategoryDAO;
import com.nguyenthihongtrinh.dao.PostDAO;
import com.nguyenthihongtrinh.dao.subcategoryDAO;
import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.ParentCategory;
import com.nguyenthihongtrinh.entity.Post;
import com.nguyenthihongtrinh.entity.SubCategory;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class PostService {

	@Autowired
	private PostDAO postDAO;
	
	/**
	 * 
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param accountParam
	 * @return int
	 */
	
	
	public List<Post> getPost() {
		return postDAO.getPost();
	}
	
	/**
	 * Get an account by name parentcategory
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param id check if user name is exists
	 * @return account
	 */
	
	public Post getByIdPost(Integer idPost) {
		return postDAO.getByIdPost(idPost);
	}
	
	/**
	 * Add an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account a new account
	 */
	public void add(Post post) {
		postDAO.add(post);
	}
	
	/**
	 * Update an post
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param post account need updating
	 */
	public void update(Post post) {
		postDAO.update(post);
	}

	/**
	 * Delete an post
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param post account need deleting
	 */
	public void delete( Integer idPost) {
		postDAO.delete(idPost);
	}
	
}