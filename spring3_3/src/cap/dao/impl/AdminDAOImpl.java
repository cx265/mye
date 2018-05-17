package cap.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cap.bean.Admin;
import cap.dao.AdminDAO;

public class AdminDAOImpl extends JdbcDaoSupport implements AdminDAO {

	@Override
	public List<Admin> findAdmins() {
		String sql = "select * from admin order by id";
		return this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));
	}

	@Override
	public int updateAdmin(Admin admin) {
		String sql = "update admin set username=?,password=? where id=?";
		return this.getJdbcTemplate().update(
				sql,
				new Object[] { admin.getUsername(), admin.getPassword(),
						admin.getId() });

	}

	@Override
	public int deleteAdmin(Integer id) {
		String sql = "delete from admin where id=?";
		return this.getJdbcTemplate().update(sql, new Object[] { id });

	}

	@Override
	public Admin findById(Integer id) {
		String sql = "select * from admin where id=?";
		return getJdbcTemplate().queryForObject(sql, new Object[] { id },
				ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));

	}

	@Override
	public int addAdmin(Admin admin) {
		String sql = "insert into admin(username,password) values(?,?)";
		return this.getJdbcTemplate().update(sql,
				new Object[] { admin.getUsername(), admin.getPassword() });

	}

}
