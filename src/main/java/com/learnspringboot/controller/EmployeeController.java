package com.learnspringboot.controller;

import com.learnspringboot.bean.Employee;
import com.learnspringboot.dao.EmployeeDao;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@GetMapping("/emps")
	public String list(Model model) {
		Collection<Employee> employees = employeeDao.getAll();
		model.addAttribute("emps", employees);
		return "employees";
	}

}
