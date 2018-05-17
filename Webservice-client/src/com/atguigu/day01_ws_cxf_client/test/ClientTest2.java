package com.atguigu.day01_ws_cxf_client.test;

import java.util.List;

import com.atguigu.day01_ws.ws2.DataTypeWS;
import com.atguigu.day01_ws.ws2.DataTypeWSImplService;
import com.atguigu.day01_ws.ws2.GetAllStudentsMapResponse.Return;
import com.atguigu.day01_ws.ws2.GetAllStudentsMapResponse.Return.Entry;
import com.atguigu.day01_ws.ws2.Student;


public class ClientTest2 {

	public static void main(String[] args) {
		DataTypeWSImplService factorty = new DataTypeWSImplService();
		DataTypeWS dataTypeWS = factorty.getDataTypeWSImplPort();
		
		boolean success = dataTypeWS.addStudent(new Student(12, "GGG", 23));
		//System.out.println("client "+success);
		
		List<Student> list = dataTypeWS.getStudentsByPrice(34);
		System.out.println(list);
		
		Return r = dataTypeWS.getAllStudentsMap();
		List<Entry> entrys = r.getEntry();
		for(Entry entry : entrys) {
			Integer id = entry.getKey();
			Student student = entry.getValue();
			System.out.println(id+"_"+student);
		}
		
	}
}
