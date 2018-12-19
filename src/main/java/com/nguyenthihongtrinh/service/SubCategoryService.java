package com.nguyenthihongtrinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nguyenthihongtrinh.dao.AccountDAO;
import com.nguyenthihongtrinh.dao.ParentCategoryDAO;
import com.nguyenthihongtrinh.dao.subcategoryDAO;
import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.ParentCategory;
import com.nguyenthihongtrinh.entity.SubCategory;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class SubCategoryService {

	@Autowired
	private subcategoryDAO subcategoryDAO;
	
	/**
	 * Login
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param accountParam
	 * @return int
	 */
	
	
	public List<SubCategory> getSubCategory() {
		return subcategoryDAO.getSubCategory();
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
	
	public SubCategory getByIdSub(Integer idSubCategory) {
		return subcategoryDAO.getByIdSub(idSubCategory);
	}
	
	/**
	 * Add an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account a new account
	 */
	public void add(SubCategory subCategory) {
		subcategoryDAO.add(subCategory);
	}
	
	/**
	 * Update an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need updating
	 */
	public void update(SubCategory subCategory) {
		subcategoryDAO.update(subCategory);
	}

	/**
	 * Delete an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need deleting
	 */
	public void delete( Integer idSubCategory) {
		subcategoryDAO.delete(idSubCategory);
	}
	
}