package com.cx.carl.test;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cx.carl.bean.User;
import com.cx.carl.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring的测试框架
@ContextConfiguration("/beans.xml") //加载spring配置文件
public class Test1 {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testAdd() {
		User user = new User(-1, "tom", new Date(), 1234);
		userMapper.insert(user);
		int id = user.getId();
		System.out.println(id);
	}
	
	@Test
	public void testSelectById() {
		User user = userMapper.selectById(1);
		System.out.println(user);
	}

}
