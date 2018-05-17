package cap.db;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBUtil {
	private static DriverManagerDataSource dataSource = null;

	public static DriverManagerDataSource getDS() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8&amp;autoReconnect=true");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

}
