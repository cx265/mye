package com.carl.cx.redis;

import redis.clients.jedis.Jedis;

/**
 * @author chenxuan
 * @Email chenx265@163.com
 * @time 2017年2月21日 下午11:17:45
 */

public class MasterSlaver {

	public static void main(String[] args) {
		Jedis jedis_Master = new Jedis("192.168.1.102",6379);
		Jedis jedis_Slaver = new Jedis("192.168.1.102",6380);
		
		jedis_Slaver.slaveof("192.168.1.102",6379);
		
		jedis_Master.set("class","1122V2");
		
		String result = jedis_Slaver.get("class");
		System.out.println(result);
	}
}
