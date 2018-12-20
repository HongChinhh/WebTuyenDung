package com.nguyenthihongtrinh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;


import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.ParentCategory;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
@Component
public class ParentCategoryDAO extends BaseDAO {

	/**
	 * Login
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param accountParam
	 * @return int
	 */

	public List<ParentCategory> getParentCat() {
		String query = "select * from ParentCategory";
		return (List<ParentCategory>) this.getJdbcTemplate().queryForObject(query, new ParentCategoryMapper());
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
	
	public ParentCategory getByNameParentCat(String nameParentCat) {
		String query = "select * from ParentCategory where NameParentCat = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { nameParentCat },
				new ParentCategoryMapper());
	}
	public ParentCategory getByIdParentCat(Integer idParentCat) {
		String query = "select * from ParentCategory where IdParentCat = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { idParentCat },
				new ParentCategoryMapper());
	}

	public ParentCategory getParentCategory(String parentCategory) {
		String query = "select * from ParentCategory where IdParentCat = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { parentCategory },
				new ParentCategoryMapper());
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
		String query = "insert ParentCategory values (?,?,?)";
		this.getJdbcTemplate().update(query, new Object[] {
				parentCategory.getIdParentCategory(), parentCategory.getNameParentCat(), parentCategory.getStatus()
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
	public void update(ParentCategory parentCategory ) {
		String query = "update ParentCategory set NameParentCat = ? , Status = ? where IdParentCat = ?";
		this.getJdbcTemplate().update(query, new Object[] {
				parentCategory.getNameParentCat(), parentCategory.getStatus()
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
	public void delete(Integer idParentCat) {
		String query = "delete from ParentCategry where IdParentCategory = ?";
		this.getJdbcTemplate().update(query, new Object[] { idParentCat });
	}
	
	private static final class ParentCategoryMapper implements RowMapper<ParentCategory> {
		
		public ParentCategory mapRow(ResultSet resultSet, int param) throws SQLException {
			return new ParentCategory(resultSet.getInt("idParentCat"), resultSet.getString("nameParentCat"), resultSet.getBoolean("status"));
		}
		
	}

	

}