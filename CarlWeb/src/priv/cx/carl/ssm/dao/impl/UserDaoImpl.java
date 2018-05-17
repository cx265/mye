package priv.cx.carl.ssm.dao.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import priv.cx.carl.ssm.dao.UserDao;
import priv.cx.carl.ssm.pojo.User;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年8月31日 下午9:39:30
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Resource(name = "jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean login(String username, String password) {
		boolean ret = false;
		String sql = "select * from tbl_user where username = ? and password = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper ,new Object[] {username , password});
		if (user != null) {
			ret = true;
		}
		return ret;
	}

	@Override
	public boolean login(User user) {
		return false;
	}

}
