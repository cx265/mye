package cap.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.util.PageBean;

@Repository(value = "adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Resource(name = "jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addAdmin(Admin admin) {
		String sql = "insert into admin(username,password) values(?,?)";
		int res = jdbcTemplate.update(sql, new Object[] { admin.getUsername(),
				admin.getPassword() });
		// throw new UnsupportedOperationException();
		return res;
	}

	@Override
	public int delAdmin(int id) {
		String sql = "delete from admin where id=?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public Admin findById(int id) {
		String sql = "select * from admin where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				BeanPropertyRowMapper.newInstance(Admin.class));
	}

	@Override
	public int updateAdmin(Admin admin) {
		String sql = "update admin set username=?,password=? where id=?";
		return jdbcTemplate.update(sql, new Object[] { admin.getUsername(),
				admin.getPassword(), admin.getId() });
	}

	@Override
	public List<Admin> findAdmins() {
		String sql = "select * from admin order by id";
		return jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Admin.class));
	}

	@Override
	public PageBean queryByPage(int currentPage, int numPerPage) {
		String sql = "select * from admin";
		return PageBean.queryByPage(sql, currentPage, numPerPage, jdbcTemplate);
	}

}
