package com.cx.carl.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cx.carl.jpa.spring.entities.Person;

/**
 * @author chenxuan
 * @Email chenx265@163.com
 * @time 2016年12月3日 下午7:26:58
 */

@Repository
public class PersonDao {

	//如何获取到和当前事务关联的 EntityManager 对象呢 ?
	//通过 @PersistenceContext 注解来标记成员变量!
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Person person){
		entityManager.persist(person);
	}
	
}
