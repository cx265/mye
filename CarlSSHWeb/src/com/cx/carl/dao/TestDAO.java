package com.cx.carl.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cx.carl.service.ITeacherService;

public class TestDAO {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test1(){
		ApplicationContext ctxt = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
//		ITeacherDAO dao = (ITeacherDAO) ctxt.getBean("teacherDAO");
//		Teacher user = dao.searchTeacher("qwe", "234");
//		user.getTName();
//		user.getTPassword();
//		System.out.println(user);

		 ITeacherService service=(ITeacherService)
		 ctxt.getBean("teacherService");
		 System.out.println(service.searchTeacher("qwe","234"));
	}

}
