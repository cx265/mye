package cap.service.impl;

import cap.bean.Admin;
import cap.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private Admin admin;
	public AdminServiceImpl() {
	}
	public AdminServiceImpl(Admin admin) {
		this.admin = admin;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String sayHello(){
		return "你好" +admin.getUsername();
	}


}
