package priv.cx.carl.roledao.dao;

import priv.cx.carl.roledao.annotation.Implement;
import priv.cx.carl.roledao.annotation.Permission;
import priv.cx.carl.roledao.dao.impl.UserDaoImpl;
import priv.cx.carl.roledao.util.Role;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月14日 上午10:23:43
 */
@Implement(UserDaoImpl.class)
public interface UserDao extends BaseDao {

	@Permission({ Role.ADMINISTRATOR, Role.SYSTEM })
	void save();

	@Permission(Role.SYSTEM)
	void delete();

	@Permission({ Role.USER, Role.ADMINISTRATOR, Role.SYSTEM })
	void query();
}
