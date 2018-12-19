package com.nguyenthihongtrinh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.FeedBack;
import com.nguyenthihongtrinh.entity.SubCategory;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
@Component
public class FeedBackDAO extends JdbcDaoSupport {

	
	

	/**
	 * Get a list of feedback
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @return list of feedback
	 */
	public List<FeedBack> getFeedBack() {
		String query = "select * from FeedBack";
		return (List<FeedBack>) this.getJdbcTemplate().queryForObject(query, new FeedBackMapper());
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
	public FeedBack getByIdFeedBack(Integer idFeedBack) {
		String query = "select * from FeedBack where FeedBack = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { idFeedBack },
				new FeedBackMapper());
	}

	/**
	 * Add an feedback
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account a new feedback
	 */
	public void add(FeedBack feedBack) {
		String query = "insert FeedBack values (?,?,?)";
		this.getJdbcTemplate().update(query, new Object[] {
				feedBack.getIdFeedBack(), feedBack.getContent()
				,feedBack.getUser_IdUser()
		});
	}

	/**
	 * Update an feedback
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account feedback need updating
	 */
	public void update(FeedBack feedBack) {
		String query = "update FeedBack set Content = ?, User_IdUser=? where IdFeedBack = ?";
		this.getJdbcTemplate().update(query, new Object[] {
				feedBack.getContent(), feedBack.getUser_IdUser(),feedBack.getIdFeedBack()
		});
	}

	/**
	 * Delete an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account feedback need deleting
	 */
	public void delete(Integer idFeedBack ) {
		String query = "delete from FeedBack where IdFeedBack = ?";
		this.getJdbcTemplate().update(query, new Object[] { idFeedBack });
	}
	
	private static final class FeedBackMapper implements RowMapper<FeedBack> {
		
		public FeedBack mapRow(ResultSet resultSet, int param) throws SQLException {
			return new FeedBack(resultSet.getInt("idSubCategory"), resultSet.getString("content")
					, resultSet.getInt("user_IdUser"));
		}
		
	}

}