package com.cx.carl.test1;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cx.carl.bean.User;

public class Test1 {

	public static void main(String[] args) throws IOException {
		String resource = "conf.xml";
		//加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//加载Mybaits的配置文件
		//InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
		//构建SqlSessionFactory的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件的sql的SqlSession
		SqlSession session = sessionFactory.openSession();
		//映射sql的标识字符串
		String statement = "com.cx.carl.test1.userMapper.getUser";
		//执行查询返回一个唯一user对象的sql
		User user = session.selectOne(statement, 1);
		System.out.println(user);
	}
}
