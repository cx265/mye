package priv.cx.carl.roledao.dao.impl;

import priv.cx.carl.roledao.dao.UserDao;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月14日 下午3:18:59
 */
public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("UserDaoImpl.save()");
	}

	@Override
	public void delete() {
		System.out.println("UserDaoImpl.delete()");
	}

	@Override
	public void query() {
		System.out.println("UserDaoImpl.query()");
	}

}
