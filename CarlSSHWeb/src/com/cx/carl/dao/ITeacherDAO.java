package com.cx.carl.dao;

import com.cx.carl.model.Teacher;

public interface ITeacherDAO {
	public Teacher searchTeacher(String teachername, String password);
}
