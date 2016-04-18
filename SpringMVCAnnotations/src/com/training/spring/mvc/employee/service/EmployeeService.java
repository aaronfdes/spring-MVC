package com.training.spring.mvc.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.mvc.employee.Employee;
import com.training.spring.mvc.employee.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	
	public Employee getEmployee(String id){
		return employeeDao.getEmployee(Integer.parseInt(id));
	}
	
	public void addEmployee(Employee employee){
		employeeDao.addEmployee(employee);		
	}
	
	public void removeEmployee(String id){
		employeeDao.removeEmployee(Integer.parseInt(id));
	}
	
}
