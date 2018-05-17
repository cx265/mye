package com.carl.cx.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author chenxuan
 * @Email chenx265@163.com
 * @time 2017年2月21日 下午11:20:36
 */

public class JedisPoolUtil {

	private static volatile JedisPool jedisPool = null;

	public static JedisPool getJedisPoolInstance() {
		if (null == jedisPool) {
			synchronized (JedisPoolUtil.class) {
				if (null == jedisPool) {
					JedisPoolConfig poolConfig = new JedisPoolConfig();
					poolConfig.setMaxTotal(1000);
					poolConfig.setMaxIdle(32);
					poolConfig.setMaxWaitMillis(100 * 1000);
					poolConfig.setTestOnBorrow(true);

					jedisPool = new JedisPool(poolConfig, "192.168.1.102", 6379);
				}
			}
		}
		return jedisPool;
	}

	public static void release(JedisPool jedisPool, Jedis jedis) {
		if (null != jedis) {
			jedisPool.returnResourceObject(jedis);
		}
	}

}
