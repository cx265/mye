package priv.cx.carl.ssm.service;

import priv.cx.carl.ssm.pojo.User;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年8月31日 下午9:32:51
 */
public interface UserService {

	public boolean login(String username, String password);
	
	public boolean login(User user);
}
