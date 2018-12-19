package com.nguyenthihongtrinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nguyenthihongtrinh.dao.UserDAO;
import com.nguyenthihongtrinh.entity.User;



/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	/**
	 * Login
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param accountParam
	 * @return int
	 */
	
	
	public List<User> getUser() {
		return userDAO.getUser();
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
	
	public User getByIdSub(Integer idUser) {
		return userDAO.getByIdUser(idUser);
	}
	
	/**
	 * Add an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account a new account
	 */
	public void add(User user) {
		userDAO.add(user);
	}
	
	/**
	 * Update an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need updating
	 */
	public void update(User user) {
		userDAO.update(user);
	}

	/**
	 * Delete an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need deleting
	 */
	public void delete( Integer idUser) {
		userDAO.delete(idUser);
	}
	
}