package com.nguyenthihongtrinh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.SubCategory;
import com.nguyenthihongtrinh.entity.User;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
@Component
public class UserDAO extends JdbcDaoSupport {

	
	

	/**
	 * 
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @return list of accounts
	 */
	public List<User> getUser() {
		String query = "select * from User";
		return (List<User>) this.getJdbcTemplate().queryForObject(query, new UserMapper());
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
	public User getByIdUser(Integer idUser) {
		String query = "select * from User where IdUser = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { idUser },
				new UserMapper());
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
		String query = "insert User values (?,?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(query, new Object[] {
				user.getIdUser(), user.getUserName(),user.getPassWord()
				,user.getFullName(),user.getEmail(),user.getAddress(),user.getStatus(),
				user.getPrivilege_IdPrivilege()
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
	public void update(User user) {
		String query = "update User set userName = ?,passWord=?,fullName=?,email=?,address=?,status=?,privilege_IdPrivilege=?"
				+ "where idUser = ?";
		this.getJdbcTemplate().update(query, new Object[] {
				user.getUserName(), user.getPassWord(),user.getFullName(),user.getEmail(),user.getAddress()
				,user.getStatus(),user.getPrivilege_IdPrivilege(),user.getIdUser()
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
	public void delete(Integer idUser ) {
		String query = "delete from User where IdUser = ?";
		this.getJdbcTemplate().update(query, new Object[] { idUser });
	}
	
	private static final class UserMapper implements RowMapper<User> {
		
		public User mapRow(ResultSet resultSet, int param) throws SQLException {
			return new User(resultSet.getInt("idUser"), resultSet.getString("userName")
					,resultSet.getString("passWord"),resultSet.getString("fullName")
					,resultSet.getString("email"),resultSet.getString("address")
					,resultSet.getBoolean("status")
					, resultSet.getInt("privilege_IdPrivilege"));
		}
		
	}

}