package cap.service;

import java.util.List;

import cap.bean.Admin;
import cap.util.PageBean;

public interface AdminService {

	public int addAdmin(Admin admin);

	public int delAdmin(int id);

	public Admin findById(int id);

	public int updateAdmin(Admin admin);

	public List<Admin> findAdmins();

	public PageBean queryByPage(int currentPage, int numPerPage);
}
