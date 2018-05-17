package com.cx.carl.test3;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.cx.carl.bean.User;
import com.cx.carl.util.MybatisUtils;

public class Test3 {
	
	//使用接口实现
	@Test
	public void testAdd() throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtils.getSessionFactory();
		//默认是手动提交的
		SqlSession session = sessionFactory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1, "SS", 45));
		System.out.println(add);
		session.close();
	}
	
}
