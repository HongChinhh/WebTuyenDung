package com.nguyenthihongtrinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.nguyenthihongtrinh.dao.ParentCategoryDAO;
import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.ParentCategory;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class ParentCategoryService {

	@Autowired
	private ParentCategoryDAO parentCategoryDAO;
	
	/**
	 *
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param accountParam
	 * @return int
	 */
	
	
	public List<ParentCategory> getParentCat() {
		return parentCategoryDAO.getParentCat();
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
	public ParentCategory getByNameParentCat(String nameParentCat) {
		return parentCategoryDAO.getByNameParentCat(nameParentCat);
	}
	public ParentCategory getByIdParentCat(Integer idParentCat) {
		return parentCategoryDAO.getByIdParentCat(idParentCat);
	}
	public ParentCategory getParentCategory(String parentCategory) {
		return parentCategoryDAO.getParentCategory(parentCategory);
	}
	
	/**
	 * Add an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account a new account
	 */
	public void add(ParentCategory parentCategory) {
		parentCategoryDAO.add(parentCategory);
	}
	
	/**
	 * Update an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need updating
	 */
	public void update(ParentCategory parentCategory) {
		parentCategoryDAO.update(parentCategory);
	}

	/**
	 * Delete an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need deleting
	 */
	public void delete( Integer idParentCat) {
		parentCategoryDAO.delete(idParentCat);
	}
	
}