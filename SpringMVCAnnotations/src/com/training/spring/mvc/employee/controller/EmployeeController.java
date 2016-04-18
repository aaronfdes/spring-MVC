package com.training.spring.mvc.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.spring.mvc.common.editors.EmployeeRankEditor;
import com.training.spring.mvc.employee.Employee;
import com.training.spring.mvc.employee.service.EmployeeService;
import com.training.spring.mvc.employee.service.TestService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView doGetAllEmployees(TestService testService) {
		System.out.println("CONTROLLER ::: GETTING ALL EMPLOYEES");
		ModelAndView mv = new ModelAndView("employeeList");
		System.out.println(testService.sayHello());
		mv.addObject("employeeList", employeeService.getAllEmployees());
		return mv;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	protected ModelAndView doViewEmployee(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("employeeDetails");
		mv.addObject("employee", employeeService.getEmployee(id));
		return mv;
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	protected ModelAndView doAddNavigateEmployee() {
		ModelAndView mv = new ModelAndView("employeeDetails");
		mv.addObject("employee", new Employee());
		return mv;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	protected ModelAndView doAddEmployee(
			@Valid @ModelAttribute("employee") Employee emp,
			BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("employeeList");

		if (bindingResult.hasErrors()) {
			mv.setViewName("employeeDetails");
		} else {
			employeeService.addEmployee(emp);
			mv.addObject("employeeList", employeeService.getAllEmployees());
			mv.addObject("message", "Added Successfully");
		}
		return mv;
	}

	@RequestMapping(path = "remove/{id}", method = RequestMethod.GET)
	protected ModelAndView doDeleteEmployee(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("employeeList");
		employeeService.removeEmployee(id);
		mv.addObject("employeeList", employeeService.getAllEmployees());
		mv.addObject("message", "Removed Successfully");
		return mv;
	}

	@ModelAttribute
	public void addModelAttributes(Model model) {
		model.addAttribute("headerMessage", "EMPLOYEE LIST");
		List<String> languageList = new ArrayList<String>();
		languageList.add("English");
		languageList.add("Hindi");
		languageList.add("Marathi");
		languageList.add("German");
		model.addAttribute("languageList", languageList);
	}

	@InitBinder
	public void dataBinder(WebDataBinder binder) {
		binder.setDisallowedFields("dateOfJoining");
		binder.registerCustomEditor(String.class, "monthsOfExperience",
				new EmployeeRankEditor());
	}

}
