package cap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.service.AdminService;
import cap.util.PageBean;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public int addAdmin(Admin admin) {
		return adminDAO.addAdmin(admin);
	}

	@Override
	public int delAdmin(int id) {
		return adminDAO.delAdmin(id);
	}

	@Override
	public Admin findById(int id) {
		return adminDAO.findById(id);
	}

	@Override
	public int updateAdmin(Admin admin) {
		return adminDAO.updateAdmin(admin);
	}

	@Override
	public List<Admin> findAdmins() {
		return adminDAO.findAdmins();
	}

	@Override
	public PageBean queryByPage(int currentPage, int numPerPage) {
		return adminDAO.queryByPage(currentPage, numPerPage);
	}

}
