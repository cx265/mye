package com.cx.carl.test3;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cx.carl.bean.User;

public interface UserMapper {

	@Insert(value = "insert into user(name, age) values(#{name}, #{age})")
	public int add(User user);
	
	@Delete(value = "delete from user where id=#{id}")
	public int deleteById(int id);
	
	@Update(value = "update user set name=#{name},age=#{age} where id=#{id}")
	public int update(User user);
	
	@Select(value = "select * from user where id=#{id}")
	public User getById(int id);
	
	@Select(value = "select * from user")
	public List<User> getAll();
}
