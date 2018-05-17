package cap.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cap.bean.Admin;
import cap.dao.AdminDAO;

public class AdminDAOImpl extends JdbcDaoSupport implements AdminDAO{

	@Override
	public int addAdmin(Admin admin) {
		String sql = "insert into admin(username,password) value(?,?)";
		return this.getJdbcTemplate().update(sql,new Object[]{admin.getUsername(),admin.getPassword()});
	}

}
