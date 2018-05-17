package com.cx.carl.test9;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.cx.carl.bean.CUser;
import com.cx.carl.util.MybatisUtils;

/*
 * 测试缓存
 1. 一级缓存 : session级的缓存 
 	1. 执行了session.clearCache();
 	2. 执行CUD操作
 	3. 不是同一个Session对象
 2. 二级缓存: 是一个映射文件级的缓存
 */
public class Test9 {

	@Test
	public void testCacheOne() throws IOException {
		
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		String statement = "com.cx.carl.test9.userMapper.getUser";
		CUser user = session.selectOne(statement, 1);
		System.out.println(user);
		user = session.selectOne(statement, 1);
		System.out.println(user);
		System.out.println("----------------");
		
		/*
		 //1. 执行了session.clearCache();
		session.clearCache();
		*/
		/*
		//2. 执行CUD操作
		session.update("com.cx.carl.test9.userMapper.updateUser", new CUser(1, "Tom", 13));
		session.commit();
		*/
		//3. 不是同一个Session对象
		session.close();
		session = sessionFactory.openSession();
		user = session.selectOne(statement, 1);
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void testCacheTwo() throws IOException {
		
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session1 = sessionFactory.openSession();
		SqlSession session2 = sessionFactory.openSession();
		String statement = "com.cx.carl.test9.userMapper.getUser";
		CUser user = session1.selectOne(statement, 1);
		session1.commit();
		System.out.println(user);
		user = session2.selectOne(statement, 1);
		session2.commit();
		System.out.println(user);
	}
}
