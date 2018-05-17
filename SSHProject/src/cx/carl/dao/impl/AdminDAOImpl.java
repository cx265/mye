package cx.carl.dao.impl;

import org.springframework.stereotype.Repository;

import cx.carl.dao.AdminDAO;
import cx.carl.dao.BaseDAO;
import cx.carl.entity.Admin;

@Repository(value = "adminDAO")
public class AdminDAOImpl extends BaseDAO implements AdminDAO {

	@Override
	public void addAdmin(Admin admin) {
		System.out.println("-------AdminDaoImpl.addAdmin-----------"
				+ admin.getName());
		getSession().save(admin);
	}

	@Override
	public void modifyAdmin(Admin admin) {
		System.out.println("-------AdminDaoImpl.modifyAdmin-----------"
				+ admin.getName());
		getSession().update(admin);
	}

	@Override
	public void deleteAdmin(Admin admin) {
		System.out.println("-------AdminDaoImpl.deleteAdmin-----------"
				+ admin.getName());
		getSession().delete(admin);
	}

}
