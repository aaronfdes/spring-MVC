package com.training.spring.mvc.common.controllerAdvice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages="com.training.spring.mvc")
public class AllControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleExceptions(Exception e,HttpServletRequest req){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("details", e);		
		mv.addObject("pageRequest",req.getRequestURI());
		return mv;
	}
}
