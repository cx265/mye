package cx.carl.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class BaseDao {

	private static final QueryRunner runner = new QueryRunner();
	
	public <T> List<T> getForList(String sql,Class<T> clazz, Object ... args){
		List<T> list = null;
		Connection conn = null;
		try {
			conn = DBManager.getInstance().getConnection();
			list = runner.query(conn,sql, new BeanListHandler<T>(clazz),args);
		} catch (Exception e) {
			throw new RuntimeException();
		} finally{
			DbUtils.closeQuietly(conn);
		}
		return list;
	}
	
	public <T> T get(String sql ,Class<T> clazz, Object ... args){
		T result = null;
		Connection conn = null;
		try {
			conn = DBManager.getInstance().getConnection();
			result = runner.query(conn,sql, new BeanHandler<T>(clazz),args);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return result;
	}
	
}
