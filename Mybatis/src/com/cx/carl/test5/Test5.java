package com.cx.carl.test5;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cx.carl.bean.Classes;
import com.cx.carl.util.MybatisUtils;

/*
 * 测试: 一对一关联表查询
 */
public class Test5 {

	public static void main(String[] args) throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		String statement = statement = "com.cx.carl.test5.ClassMapper.getClass";
		statement = "com.cx.carl.test5.ClassMapper.getClass2";
		Classes c = session.selectOne(statement , 2);
		System.out.println(c);
		session.close();
	}
}
