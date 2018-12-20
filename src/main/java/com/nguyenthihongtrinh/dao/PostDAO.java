package com.nguyenthihongtrinh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.Post;
import com.nguyenthihongtrinh.entity.SubCategory;

import javafx.geometry.Pos;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
@Component
public class PostDAO extends BaseDAO {

	
	

	/**
	 * Get a list of accounts
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @return list of accounts
	 */
	public List<Post> getPost() {
		String query = "select * from Post";
		return (List<Post>) this.getJdbcTemplate().queryForObject(query, new PostMapper());
	}

	/**
	 * 
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param id check if user name is exists
	 * @return account
	 */
	public Post getByIdPost(Integer idPost) {
		String query = "select * from Post where IdPost = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { idPost },
				new PostMapper());
	}

	/**
	 * Add an account
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param account a new account
	 */
	public void add(Post post) {
		String query = "insert Post values (?,?,?,?,?,?,?,?,?,?,?)";
		this.getJdbcTemplate().update(query, 
				post.getIdPost(), post.getBody()
				,post.getTitle(),post.getUrl(),post.getNoteImage(), post.getAuthor(),
				post.getCreationTime(), post.getPublishedTime(),post.getStatus(),post.getUser_IdUser(),
				post.getSubCategory_IdSubCategory()
		);
	}

	/**
	 * Update an post
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param post account need updating
	 */
	public void update(Post post) {
		String query = "update Post set Body = ?, Title=?,Url=?, NoteImage=?, Author=?,CreationTime=?, PublishedTime=?,Status=?, User_IdUser=?, SubCategory_IdSubCategory=?"
			+ " where IdPost = ?";
		this.getJdbcTemplate().update(query,post.getBody(), post.getTitle(),post.getUrl(),post.getNoteImage(), post.getAuthor(),post.getCreationTime(),post.getPublishedTime(),post.getStatus(),post.getUser_IdUser(),post.getSubCategory_IdSubCategory()
		);
	}

	/**
	 * Delete an post
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param post account need deleting
	 */
	public void delete(Integer idPost ) {
		String query = "delete from Post where IdPost = ?";
		this.getJdbcTemplate().update(query, idPost );
	}
	
	private static final class PostMapper implements RowMapper<Post> {
		
		public Post mapRow(ResultSet resultSet, int param) throws SQLException {
			return new Post(resultSet.getInt("idPost"), resultSet.getString("body")
					,resultSet.getString("title"), resultSet.getString("url"),
					resultSet.getString("noteImage"), resultSet.getString("author"),resultSet.getDate("creationTime"),
					resultSet.getDate("publishedTime"), resultSet.getBoolean("status"), resultSet.getInt("user_IdUser"),
					resultSet.getInt("subCategory_IdSubCategory"));
		}
		
	}

}