package com.nguyenthihongtrinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nguyenthihongtrinh.dao.AccountDAO;
import com.nguyenthihongtrinh.dao.FeedBackDAO;
import com.nguyenthihongtrinh.dao.ParentCategoryDAO;
import com.nguyenthihongtrinh.dao.subcategoryDAO;
import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.FeedBack;
import com.nguyenthihongtrinh.entity.ParentCategory;
import com.nguyenthihongtrinh.entity.SubCategory;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class FeedBackService {

	@Autowired
	private FeedBackDAO feedBackDAO;
	
	/**
	 * 
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param accountParam
	 * @return int
	 */
	
	
	public List<FeedBack> getFeedBack() {
		return feedBackDAO.getFeedBack();
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
	
	public FeedBack getByIdFeedBack(Integer idFeedBack) {
		return feedBackDAO.getByIdFeedBack(idFeedBack);
	}
	
	/**
	 * Add an feedback
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account a new feedback
	 */
	public void add(FeedBack feedBack) {
		feedBackDAO.add(feedBack);
	}
	
	/**
	 * Update an feedback
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param  feedback need updating
	 */
	public void update(FeedBack feedBack) {
		feedBackDAO.update(feedBack);
	}

	/**
	 * Delete an feedback
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param feedback account need deleting
	 */
	public void delete( Integer idFeedBack) {
		feedBackDAO.delete(idFeedBack);
	}
	
}