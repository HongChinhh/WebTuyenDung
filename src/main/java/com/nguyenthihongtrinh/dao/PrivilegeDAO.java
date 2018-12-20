package com.nguyenthihongtrinh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.nguyenthihongtrinh.entity.Account;
import com.nguyenthihongtrinh.entity.Privilege;
import com.nguyenthihongtrinh.entity.SubCategory;

/**
 * @author Nguyen Thi Hong Trinh
 * @since  13/12/2018
 */
@Component
public class PrivilegeDAO extends BaseDAO {

	
	

	/**
	 * Get a list of accounts
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @return list of accounts
	 */
	public List<Privilege> getPrivilege() {
		String query = "select * from Privilege";
		return (List<Privilege>) this.getJdbcTemplate().queryForObject(query, new PrivilegeMapper());
	}

	/**
	 * Get an privilege  by user name
	 *
	 * @author Nguyen Thi Hong Trinh
	 * @since  13/12/2018
	 *
	 * @param id check if user name is exists
	 * @return account
	 */
	public Privilege getByIdPri(Integer idPrivilege) {
		String query = "select * from Privilege where IdPrivilege = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { idPrivilege },
				new PrivilegeMapper());
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
		String query = "insert Privilege values (?,?,?)";
		this.getJdbcTemplate().update(query, new Object[] {
				privilege.getIdPrivilege(), privilege.getName()
				,privilege.getDescription()
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
	public void update(Privilege privilege) {
		String query = "update Privilege set Name = ?, Description=? where IdPrivilege = ?";
		this.getJdbcTemplate().update(query, new Object[] {
				privilege.getName(), privilege.getDescription(),privilege.getIdPrivilege()
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
	public void delete(Integer idPrivilege ) {
		String query = "delete from Privilege where idPrivilege = ?";
		this.getJdbcTemplate().update(query, new Object[] { idPrivilege });
	}
	
	private static final class PrivilegeMapper implements RowMapper<Privilege> {
		
		public Privilege mapRow(ResultSet resultSet, int param) throws SQLException {
			return new Privilege(resultSet.getInt("idPrivilege"), resultSet.getString("name")
					, resultSet.getString("description"));
		}
		
	}

}