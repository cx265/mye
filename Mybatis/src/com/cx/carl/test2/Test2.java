package com.cx.carl.test2;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.cx.carl.bean.User;
import com.cx.carl.util.MybatisUtils;

public class Test2 {
	
	@Test
	public void testAdd() throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession();
		String statement = "com.cx.carl.test2.userMapper.addUser";
		int insert = session.insert(statement , new User(-1, "KK1", 2));
		//提交
		session.commit();
		session.close();
		System.out.println(insert);
	}
	
	@Test
	public void testUpdate() throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.cx.carl.test2.userMapper.updateUser";
		int update = session.update(statement, new User(3, "K444", 25));
		session.close();
		System.out.println(update);
	}
	
	@Test
	public void testDelete() throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.cx.carl.test2.userMapper.deleteUser";
		int delete = session.delete(statement, 4);
		session.close();
		System.out.println(delete);
	}
	
	@Test
	public void testGetUser() throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.cx.carl.test2.userMapper.getUser";
		User user = session.selectOne(statement, 1);
		session.close();
		System.out.println(user);
	}
	
	@Test
	public void testGetAll() throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession(true);
		String statement = "com.cx.carl.test2.userMapper.getAllUsers";
		List<User> list = session.selectList(statement);
		session.close();
		System.out.println(list);
	}
	
}
