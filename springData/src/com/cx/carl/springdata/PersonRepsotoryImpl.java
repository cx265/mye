package com.cx.carl.springdata;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author chenxuan
 * @Email chenx265@163.com
 * @time 2016年12月8日 下午9:16:20
 */

public class PersonRepsotoryImpl implements PersonDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void test() {
		Person person = entityManager.find(Person.class, 2);
		System.out.println("person="+person);
	}

}
