package com.atguigu.day01_ws.ws2;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.atguigu.day01_ws.bean.Student;

@WebService
public interface DataTypeWS {

	@WebMethod
	public boolean addStudent(Student s);

	@WebMethod
	public Student getStudentById(int id);

	@WebMethod
	public List<Student> getStudentsByPrice(float price);

	@WebMethod
	public Map<Integer, Student> getAllStudentsMap();
}
