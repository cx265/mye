package cap.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8&amp;autoReconnect=true";
	private String user = "root";
	private String password = "root";
	private Connection conn = null;
	public DBCon() {
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int doUpdate(String sql) throws SQLException{
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);
	}
	
	public void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
		
	}
}
