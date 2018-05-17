package com.carl.cx.redis;

import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * @author chenxuan
 * @Email chenx265@163.com
 * @time 2017年2月21日 下午10:34:04
 */

public class API {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.1.102",6379);
		jedis.set("k1","v1");
		jedis.set("k2","v2");
		jedis.set("k3","v3");
		System.out.println(jedis.get("k3"));
		Set<String> sets = jedis.keys("*");
		System.out.println(sets.size());
		
	}

}
