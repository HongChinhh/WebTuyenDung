package com.nguyenthihongtrinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nguyenthihongtrinh.dao.AccountDAO;
import com.nguyenthihongtrinh.entity.Account;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
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
		return accountDAO.login(account);
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
		return accountDAO.getAll();
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
		return accountDAO.getByUserName(userName);
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
		accountDAO.add(account);
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
		accountDAO.update(account);
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
		accountDAO.delete(userName);
	}
	
}