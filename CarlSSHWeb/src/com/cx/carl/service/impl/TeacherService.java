package com.cx.carl.service.impl;

import com.cx.carl.dao.ITeacherDAO;
import com.cx.carl.model.Teacher;
import com.cx.carl.service.ITeacherService;

public class TeacherService implements ITeacherService {
	private ITeacherDAO teacherDAO;

	public Teacher searchTeacher(String teachername, String password) {
		return teacherDAO.searchTeacher(teachername, password);
	}

	public ITeacherDAO getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

}
