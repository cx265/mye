package priv.cx.carl.shiro.redis.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import priv.cx.carl.shiro.redis.RedisDb;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年12月4日 上午9:30:06
 */
public class SessionRedisDao extends EnterpriseCacheSessionDAO {

	// 创建session，保存到数据库
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = super.doCreate(session);
		try {
			RedisDb.setObject(sessionId.toString().getBytes("UTF-8"), sessionToByte(session));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sessionId;
	}

	// 获取session
	@Override
	protected Session doReadSession(Serializable sessionId) {
		// 先从缓存中获取session，如果没有再去数据库中获取
		Session session = super.doReadSession(sessionId);
		if (session == null) {
			byte[] bytes;
			try {
				bytes = RedisDb.getObject(sessionId.toString().getBytes("UTF-8"));
				if (bytes != null && bytes.length > 0) {
					session = byteToSession(bytes);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return session;
	}

	// 更新session的最后一次访问时间
	@Override
	protected void doUpdate(Session session) {
		super.doUpdate(session);
		try {
			RedisDb.setObject(session.getId().toString().getBytes("UTF-8"), sessionToByte(session));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	// 删除session
	@Override
	protected void doDelete(Session session) {
		super.doDelete(session);
		RedisDb.delString(String.valueOf(session.getId()));
	}

	// 把session对象转化为byte保存到redis中
	public byte[] sessionToByte(Session session) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] bytes = null;
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(session);
			bytes = byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}

	// 把byte还原为session
	public Session byteToSession(byte[] bytes) {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		ObjectInputStream objectInputStream;
		SimpleSession session = null;
		try {
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			session = (SimpleSession) objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

}
