package cap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public Admin login(Admin admin) {
		return adminDAO.login(admin);
	}

}
