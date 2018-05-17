package priv.cx.carl.roledao.context;

import priv.cx.carl.roledao.util.Role;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月14日 下午3:14:24
 */
public enum RoleContext {

	INSTANCE;

	private ThreadLocal<Role> role = new ThreadLocal<Role>();

	public Role getCurrentRole() {
		return role.get();
	}

	public void setCurrentRole(Role role) {
		this.role.set(role);
	}
}
