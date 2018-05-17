package com.atguigu.day01_ws.ws2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.atguigu.day01_ws.bean.Student;

@WebService
public class DataTypeWSImpl implements DataTypeWS {

	@Override
	public boolean addStudent(Student s) {
		System.out.println("server addStudent() "+s);
		return true;
	}

	@Override
	public Student getStudentById(int id) {
		System.out.println("server getStudentById() "+id);
		return new Student(id, "CAT", 1000);
	}

	@Override
	public List<Student> getStudentsByPrice(float price) {
		System.out.println("server getStudentsByPrice() "+price);
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "TOM1", price+1));
		list.add(new Student(2, "TOM2", price+2));
		list.add(new Student(3, "TOM3", price+3));
		return list;
	}

	@Override
	public Map<Integer, Student> getAllStudentsMap() {
		System.out.println("server getAllStudentsMap() ");
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student(1, "JACK1", 2345));
		map.put(3, new Student(3, "JACK3", 2375));
		map.put(2, new Student(2, "JACK2", 12345));
		return map;
	}
}
