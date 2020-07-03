package com.learnspringboot.controller;

import com.learnspringboot.bean.Employee;
import com.learnspringboot.dao.EmployeeDao;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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

	@GetMapping("/emp")
	public String addEmployeePage() {
		//TODO: create employeepage html.
		return "emp/add";
	}

	@PostMapping("/emp")
	public String addEmployee(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}

	@GetMapping("/emp/{id}")
	public String toEditPage(
		@PathVariable("id") Integer id,
		Model model
	)
	{
		Employee employee = employeeDao.get(id);
		model.addAttribute("emp", employee);
		//TODO: create html
		return "emp/add";
	}

	@PutMapping("/emp")
	public String updateEmployee(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}

	@DeleteMapping("/emp/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
