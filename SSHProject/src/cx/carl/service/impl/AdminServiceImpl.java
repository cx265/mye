package cx.carl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cx.carl.dao.AdminDAO;
import cx.carl.entity.Admin;
import cx.carl.service.AdminService;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminDAO adminDAO;

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public void addAdmin(Admin admin) {
		System.out.println("------AdminServiceImpl.adddAdmin--------"
				+ admin.getName());
		adminDAO.addAdmin(admin);
	}

	@Override
	public void modifyAdmin(Admin admin) {
		System.out.println("------AdminServiceImpl.modifyAdmin--------"
				+ admin.getName());
		adminDAO.modifyAdmin(admin);
	}

	@Override
	public void deleteAdmin(Admin admin) {
		System.out.println("------AdminServiceImpl.deleteAdmin--------"
				+ admin.getName());
		adminDAO.deleteAdmin(admin);
	}

}
