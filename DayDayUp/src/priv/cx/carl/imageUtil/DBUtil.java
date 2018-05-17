package priv.cx.carl.imageUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年4月11日 下午5:01:59
 */
public class DBUtil {

	// 定义数据库连接参数
	public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "root";

	// 注册数据库驱动
	static {
		try {
			Class.forName(DRIVER_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("注册失败！");
			e.printStackTrace();
		}
	}

	// 获取连接
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	// 关闭连接
	public static void closeConn(Connection conn) {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("关闭连接失败！");
				e.printStackTrace();
			}
		}
	}

	// 测试
	public static void main(String[] args) throws SQLException {
		System.out.println(DBUtil.getConn());
	}

}
