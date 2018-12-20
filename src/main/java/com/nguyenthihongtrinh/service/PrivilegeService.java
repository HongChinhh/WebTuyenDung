package com.nguyenthihongtrinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.nguyenthihongtrinh.dao.ParentCategoryDAO;
import com.nguyenthihongtrinh.dao.PrivilegeDAO;
import com.nguyenthihongtrinh.dao.subcategoryDAO;
import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.ParentCategory;
import com.nguyenthihongtrinh.entity.Privilege;
import com.nguyenthihongtrinh.entity.SubCategory;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class PrivilegeService {

	@Autowired
	private PrivilegeDAO privilegeDAO;
	
	/**
	 * 
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param accountParam
	 * @return int
	 */
	
	
	public List<Privilege> getPrivilege() {
		return privilegeDAO.getPrivilege();
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
	
	public Privilege getByIdPri(Integer idPrivilege) {
		return privilegeDAO.getByIdPri(idPrivilege);
	}
	
	/**
	 * Add an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account a new account
	 */
	public void add(Privilege privilege) {
		privilegeDAO.add(privilege);
	}
	
	/**
	 * Update an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need updating
	 */
	public void update(Privilege privilege) {
		privilegeDAO.update(privilege);
	}

	/**
	 * Delete an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need deleting
	 */
	public void delete( Integer idPrivilege) {
		privilegeDAO.delete(idPrivilege);
	}
	
}