package cap.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import cap.bean.Admin;
import cap.dao.AdminDAO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Admin login(Admin admin) {
		String sql = "select * from admin where username=? and password=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{admin.getUsername(),admin.getPassword()},ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));
	}

}
