package priv.cx.carl.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.cx.carl.ssm.dao.UserDao;
import priv.cx.carl.ssm.pojo.User;
import priv.cx.carl.ssm.service.UserService;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年8月31日 下午9:37:42
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean login(String username, String password) {
		return userDao.login(username, password);
	}

	@Override
	public boolean login(User user) {
		return userDao.login(user);
	}

}
