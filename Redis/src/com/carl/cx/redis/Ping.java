package com.carl.cx.redis;

import redis.clients.jedis.Jedis;

/**
 * @author chenxuan
 * @Email chenx265@163.com
 * @time 2017年2月21日 下午9:11:14
 */

public class Ping {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.1.102",6379);
		System.out.println(jedis.ping());
	}
}
