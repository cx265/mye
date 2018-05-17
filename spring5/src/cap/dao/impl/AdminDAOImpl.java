package cap.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.db.DBCon;

public class AdminDAOImpl implements AdminDAO {
	
	private DBCon dbc = new DBCon();

	@Override
	public List<Admin> getAdmins() {
		return null;
	}

	@Override
	public int addAdmin(Admin admin) {
		String sql = "insert into admin(username,password) values('"+admin.getUsername()+"','"+admin.getPassword()+"')";
		int res = 0;
		try {
			res = dbc.doUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delAdmin(int id) {
		return 0;
	}
	
}
