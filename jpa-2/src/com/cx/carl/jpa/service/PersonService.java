package com.cx.carl.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cx.carl.jpa.dao.PersonDao;
import com.cx.carl.jpa.spring.entities.Person;

/**
 * @author chenxuan
 * @Email chenx265@163.com
 * @time 2016年12月3日 下午7:30:43
 */

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Transactional
	public void savePersons(Person p1,Person p2){
		personDao.save(p1);
		personDao.save(p2);
	}
}
