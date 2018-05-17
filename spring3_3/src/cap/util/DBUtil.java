package cap.util;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBUtil {
	static DriverManagerDataSource dataSource = null;

	public static DriverManagerDataSource getDS() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

}
