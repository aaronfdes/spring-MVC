package com.training.spring.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.training.spring.mvc.common.filters.LoggingFilter;

public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringConfig.class);
		servletContext.addListener(new ContextLoaderListener(context));
		
		servletContext.addFilter("LoggingFilter", LoggingFilter.class).addMappingForUrlPatterns(null, false, "/*");
		servletContext.addFilter("SpringFilter", DelegatingFilterProxy.class).addMappingForUrlPatterns(null, false, "/*");
		
		servletContext.setInitParameter("id", "P0001");
		
		Dynamic servlet = servletContext.addServlet("DispatcherServlet",new DispatcherServlet(context));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
	}

}
