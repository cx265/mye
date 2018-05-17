package cap.dao;
import java.util.List;

import cap.bean.Admin;

public interface AdminDAO {
	public List<Admin> findAdmins(); 
	public int updateAdmin(Admin admin);
	public int deleteAdmin(Integer id);
	public Admin findById(Integer id) ;
	public int addAdmin(Admin admin);
}
