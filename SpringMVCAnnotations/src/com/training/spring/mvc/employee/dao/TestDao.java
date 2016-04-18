package com.training.spring.mvc.employee.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

	public void sayHello(){
		System.out.println("Hello from the repository");
	}
}
