package cap.dao;
import java.util.List;
import cap.bean.Admin;

public interface AdminDAO {
	public List<Admin> getAdmins();
	public int addAdmin(Admin admin);
	public int delAdmin(int id);
}
