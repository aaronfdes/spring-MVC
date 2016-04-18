package com.training.spring.mvc.common.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter(filterName="TestFilter",urlPatterns="/*")
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
System.out.println("Test Filter constructor");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Test Filter Destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("Test Filter req start");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println("Test Filter req finished");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Test Filter init");
	}

}
