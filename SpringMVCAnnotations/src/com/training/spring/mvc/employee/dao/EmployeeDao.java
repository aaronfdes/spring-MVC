package com.training.spring.mvc.employee.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.training.spring.mvc.employee.Employee;

@Repository
public class EmployeeDao {

	Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

	private EmployeeDao() {
		employeeMap.put(1, new Employee("1", "John",new Date(),Arrays.asList("English","Hindi","Marathi"),new Date()));
		employeeMap.put(2, new Employee("2", "Jane",new Date(),Arrays.asList("English"),new Date()));
	}

	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(employeeMap.values());
	}

	public Employee getEmployee(int id) {
		return employeeMap.get(id);
	}

	public void addEmployee(Employee employee) {
		employeeMap.put(Integer.parseInt(employee.getEmpID()), employee);
	}

	public void removeEmployee(int id) {
		employeeMap.remove(id);
	}
}
