package com.cx.carl.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cx.carl.dao.ITeacherDAO;
import com.cx.carl.model.Teacher;

public class TeacherDAO extends BaseDAO implements ITeacherDAO {

	public Teacher searchTeacher(String teachername, String password) {
		Session session = getSession();
		List list = null;
		Teacher teacher = null;
		try {
			Transaction tx = session.beginTransaction();
			Query query = session
					.createQuery("from Teacher teacher where teacher.TName = '"
							+ teachername + "' and teacher.TPassword = '"
							+ password + "'");
			list = query.list();
			teacher = (Teacher) list.get(0);
			query.executeUpdate();
			tx.commit();
		} catch (RuntimeException e) {
		}
		session.close();
		return teacher;
	}
}
