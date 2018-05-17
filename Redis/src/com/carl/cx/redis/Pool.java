package com.carl.cx.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author chenxuan
 * @Email chenx265@163.com
 * @time 2017年2月21日 下午11:19:49
 */

public class Pool {

	public static void main(String[] args) {
		JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
		JedisPool jedisPool2 = JedisPoolUtil.getJedisPoolInstance();

		System.out.println(jedisPool == jedisPool2);// true

		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set("aa", "11");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JedisPoolUtil.release(jedisPool, jedis);
		}
	}
}
