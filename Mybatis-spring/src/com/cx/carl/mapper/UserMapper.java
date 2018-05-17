package com.cx.carl.mapper;

import java.util.List;

import com.cx.carl.bean.User;

public interface UserMapper {
	
	void insert(User user);
	void update(User user);
	void delete(int id);
	User selectById(int id);
	List<User> selectAll();
	
}
