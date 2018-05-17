package cx.carl.dao;

import cx.carl.entity.Admin;

public interface AdminDAO {
	public void addAdmin(Admin admin);
	public void modifyAdmin(Admin admin);
	public void deleteAdmin(Admin admin);
}
