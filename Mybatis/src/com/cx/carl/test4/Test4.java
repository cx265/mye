package com.cx.carl.test4;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cx.carl.bean.Order;
import com.cx.carl.util.MybatisUtils;


/*
 * 测试:　解决字段名与实体类属性名不相同的冲突
 */
public class Test4 {

	public static void main(String[] args) throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		String statement = "com.cx.carl.test4.orderMapper.getOrder";
		statement = "com.cx.carl.test4.orderMapper.getOrder2";
		Order order = session.selectOne(statement , 2);
		System.out.println(order);
	}
}
