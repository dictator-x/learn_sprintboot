package com.learnspringboot.dao;

import com.learnspringboot.bean.Employee;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	private static Map<Integer, Employee> employees = null;

	static {
		employees = new HashMap<Integer, Employee>();
		employees.put(1001, new Employee(1001, "James", 30));
		employees.put(1002, new Employee(1002, "Jordan", 40));
	}

	private static Integer initId = 1003;

	public void save(Employee employee) {
		if ( employee.getId() == null )
			employee.setId(initId++);
		employees.put(employee.getId(), employee);
	}

	public Collection<Employee> getAll() { return employees.values(); }
	public Employee get(Integer id) { return employees.get(id); }
	public void delete(Integer id) { employees.remove(id); }
}
