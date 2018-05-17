package cx.carl.service;

import cx.carl.entity.Admin;

public interface AdminService {
	public void addAdmin(Admin admin);
	public void modifyAdmin(Admin admin);
	public void deleteAdmin(Admin admin);
}
