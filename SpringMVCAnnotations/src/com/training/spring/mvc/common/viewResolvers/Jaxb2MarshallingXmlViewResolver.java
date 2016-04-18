package com.training.spring.mvc.common.viewResolvers;

import java.util.Locale;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.training.spring.mvc.employee.Employee;

public class Jaxb2MarshallingXmlViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String viewName, Locale locale)
			throws Exception {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound(Employee.class);
		MarshallingView view = new MarshallingView();
		view.setMarshaller(jaxb2Marshaller);
		return view;
	}

}
