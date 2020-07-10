package com.learnspringboot.controller;

import com.learnspringboot.bean.Department;
import com.learnspringboot.mapper.DepartmentMapper;
import com.learnspringboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    DepartmentService departmentService;

//    @GetMapping("/dept/{id}")
//    public Department getDepartment(@PathVariable("id") Integer id) {
//        return departmentMapper.getDepartmentById(id);
//    }
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping("/dept")
    public Department insertDepartment(Department department) {
        departmentMapper.insertDepartment(department);
        return department;
    }

    @GetMapping("/deptment")
    public Department updateDepartment(Department department) {
        return departmentService.updateDepartment(department);
    }

    @GetMapping("/deletedept")
    public String deleteDepartment(Integer id) {
        departmentService.deleteDepartment(id);
        return "success";
    }

    @GetMapping("/dept/name/{departmentName}")
    public Department getDepartmentByName(@PathVariable("departmentName") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }

}
