package com.training.spring.mvc.common.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.training.spring.mvc.employee.service.EmployeeService;

public class SpringFilter extends GenericFilterBean{

	@Value("${id}")
	private String id;
	
	private String name;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Spring Filter called");
	
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		System.out.println(context.getBean(EmployeeService.class).getAllEmployees());
		System.out.println("SPRING FILTER INIT VALUES :::::::> ID: "+getId()+" Name: "+getName()+"  INIT PARAM: "+req.getServletContext().getInitParameter("id"));
		chain.doFilter(req, res);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
