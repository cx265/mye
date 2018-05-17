package com.cx.carl.test7;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.cx.carl.bean.ConditionUser;
import com.cx.carl.bean.User;
import com.cx.carl.util.MybatisUtils;

/*
 * 测试: 动态SQL与模糊查询
 */
public class Test7 {
	
	@Test
	public void testSelect() throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		String statement = "com.cx.carl.test7.userMapper.getUser";
		String name = "o";
		//name = null;
		ConditionUser parameter = new ConditionUser("%" + name + "%", 13, 18);
		List<User> list = session.selectList(statement, parameter);
		System.out.println(list);
		session.close();
	}
	
	@Test
	public void testUpdate() throws IOException{
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		String statement = "com.cx.carl.test7.userMapper.getUpdate";
		int update = session.update(statement, new User(2, "Kobe", 39));
		session.commit();
		session.close();
		System.out.println(update);
	}
}
