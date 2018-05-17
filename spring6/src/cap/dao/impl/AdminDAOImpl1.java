package cap.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cap.bean.Admin;
import cap.dao.AdminDAO;

@Repository(value = "adminDAO1")
@Transactional
public class AdminDAOImpl1 implements AdminDAO {

	private JdbcTemplate jdbcTemplate;

	@Resource(name = "jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Admin> findAdmins() {
		String sql = "select * from admin order by id";
		return jdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));
	}

	@Override
	public int updateAdmin(Admin admin) {
		String sql = "update admin set username=?,password=? where id=?";
		return jdbcTemplate.update(sql, new Object[] { admin.getUsername(),
				admin.getPassword(), admin.getId() });

	}

	@Override
	public int deleteAdmin(Integer id) {
		String sql = "delete from admin where id=?";
		return jdbcTemplate.update(sql, new Object[] { id });

	}

	@Override
	public Admin findById(Integer id) {
		String sql = "select * from admin where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));

	}

	@Override
	public int addAdmin(Admin admin) {
		String sql = "insert into admin(username,password) values(?,?)";
		int res = jdbcTemplate.update(sql, new Object[] { admin.getUsername(),
				admin.getPassword() });
		throw new UnsupportedOperationException();
	}

}
