package com.atguigu.day01_ws.ws.server;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String encode = URLEncoder.encode("中", "utf-8");
		System.out.println(encode);//%E4%B8%AD  %D6%D0
		//byte 字节 bit位 
		// 中--->11111111 11111111  F
		//       %D6           %D0
	}
}
