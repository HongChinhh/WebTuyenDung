package com.nguyenthihongtrinh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.SubCategory;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
@Component
public class subcategoryDAO extends JdbcDaoSupport {

	
	

	/**
	 * Get a list of accounts
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @return list of accounts
	 */
	public List<SubCategory> getSubCategory() {
		String query = "select * from SubCategory";
		return (List<SubCategory>) this.getJdbcTemplate().queryForObject(query, new SubCategoryMapper());
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
	public SubCategory getByIdSub(Integer idSubCategory) {
		String query = "select * from SubCategory where IdSubCategory = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { idSubCategory },
				new SubCategoryMapper());
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
		String query = "insert SubCategory values (?,?,?,?)";
		this.getJdbcTemplate().update(query, new Object[] {
				subCategory.getIdSubCategory(), subCategory.getName()
				,subCategory.getUrl(),subCategory.getParentCategory_IdParentCategory()
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
	public void update(SubCategory subCategory) {
		String query = "update SubCategory set Name = ?, Url=?,ParentCategory_IdParentCategory=? where IdSubCategory = ?";
		this.getJdbcTemplate().update(query, new Object[] {
				subCategory.getName(), subCategory.getUrl(),subCategory.getParentCategory_IdParentCategory()
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
	public void delete(Integer idSubCategory ) {
		String query = "delete from SubCategory where IdSubCategory = ?";
		this.getJdbcTemplate().update(query, new Object[] { idSubCategory });
	}
	
	private static final class SubCategoryMapper implements RowMapper<SubCategory> {
		
		public SubCategory mapRow(ResultSet resultSet, int param) throws SQLException {
			return new SubCategory(resultSet.getInt("idSubCategory"), resultSet.getString("name")
					,resultSet.getString("url"), resultSet.getInt("ParentCategory_IdParentCategory"));
		}
		
	}

}