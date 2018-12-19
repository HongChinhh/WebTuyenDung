package com.nguyenthihongtrinh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.nguyenthihongtrinh.entity.Account;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
@Component
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
		String query = "select * from ParentCategory where userName = ? and password = ?";
		return this.getJdbcTemplate().queryForObject(query, Integer.class);
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
		String query = "select * from account";
		return (List<Account>) this.getJdbcTemplate().queryForObject(query, new AccountMapper());
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
		String query = "select * from account where userName = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { userName },
				new AccountMapper());
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
		String query = "insert account values (?,?)";
		this.getJdbcTemplate().update(query, new Object[] {
				account.getUserName(), account.getPassword()
		});
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
		String query = "update account set password = ? where userName = ?";
		this.getJdbcTemplate().update(query, new Object[] {
				account.getPassword(), account.getUserName()
		});
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
		String query = "delete from account where userName = ?";
		this.getJdbcTemplate().update(query, new Object[] { userName });
	}
	
	private static final class AccountMapper implements RowMapper<Account> {
		
		public Account mapRow(ResultSet resultSet, int param) throws SQLException {
			return new Account(resultSet.getString("userName"), resultSet.getString("password"));
		}
		
	}

}