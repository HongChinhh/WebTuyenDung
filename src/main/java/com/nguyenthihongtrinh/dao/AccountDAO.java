package com.nguyenthihongtrinh.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nguyenthihongtrinh.entity.Account;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class AccountDAO extends JdbcDaoSupport {

	/**
	 * Login
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param accountParam
	 * @return int
	 */
	public int login(Account account) {
		return 0;
	}

	/**
	 * Get a list of accounts
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @return list of accounts
	 */
	public List<Account> getAll() {
		return null;
	}

	/**
	 * Get an account by user name
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param id check if user name is exists
	 * @return account
	 */
	public Account getByUserName(String userName) {
		return null;
	}

	/**
	 * Add an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account a new account
	 */
	public void add(Account account) {
		
	}

	/**
	 * Update an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need updating
	 */
	public void update(Account account) {
		
	}

	/**
	 * Delete an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account account need deleting
	 */
	public void delete(String userName) {
		
	}

}