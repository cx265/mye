package priv.cx.carl.ssm.dao;

import org.springframework.stereotype.Repository;

import priv.cx.carl.ssm.pojo.User;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年8月31日 下午9:38:10
 */
@Repository("userMapper")
public interface UserDao {

	public boolean login(String username, String password);
	public boolean login(User user);
}
