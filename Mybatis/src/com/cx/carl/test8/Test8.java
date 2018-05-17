package com.cx.carl.test8;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cx.carl.util.MybatisUtils;

/**
 * 测试调用存储过程 
 *
 */
public class Test8 {

	public static void main(String[] args) throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		String statement = "com.cx.carl.test8.userMapper.getUserCount";
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sex_id", 0); //0 女；1男
		parameterMap.put("user_count", -1);
		session.selectOne(statement, parameterMap);
		Integer result = parameterMap.get("user_count");
		System.out.println(result);
		session.close();
	}
}
