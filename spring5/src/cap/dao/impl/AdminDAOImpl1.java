package cap.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.db.DBUtil;

public class AdminDAOImpl1 implements AdminDAO{
	JdbcTemplate jdbcTemplate=new JdbcTemplate(DBUtil.getDS());

	@Override
	public List<Admin> getAdmins() {
		return null;
	}

	@Override
	public int addAdmin(Admin admin) {
		String sql = "insert into admin(username,password) values(?,?)";
		return jdbcTemplate.update(sql, new Object[] { admin.getUsername(),
				admin.getPassword() });
	}

	@Override
	public int delAdmin(int id) {
		return 0;
	}

}
