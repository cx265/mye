package cap.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import cap.bean.Admin;
import cap.dao.AdminDAO;

public class AdminDAOImpl3 implements AdminDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addAdmin(Admin admin) {
		String sql = "insert into admin(username,password) values(:u,:p)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("u", admin.getUsername());
		paramMap.put("p", admin.getPassword());
		return namedParameterJdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int delAdmin(int id) {
		String sql = "delete from admin where id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		return namedParameterJdbcTemplate.update(sql, paramMap);
	}

}
