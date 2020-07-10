package com.learnspringboot.service;

import com.learnspringboot.bean.Department;
import com.learnspringboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames="emp")
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    // unless = "#result == null"
    // condition = "#id>0"
    //@Cacheable(cacheNames = {"emp"}, key = "#root.methodName+'['+#id+']'")
    @Cacheable(cacheNames = "emp", key="#id")
    //@Cacheable(cacheNames = "emp", key="myKeyGenerator", condition = "#id>1", unless="#a0==2")
    public Department getDepartment(Integer id) {
        System.out.println("search...");
        return departmentMapper.getDepartmentById(id);
    }


    //@CachePut(value = "emp", key = "#department.id")
    @CachePut(value = "emp", key = "#result.id")
    public Department updateDepartment(Department department) {
        System.out.println("updateDept");
        departmentMapper.updateDepartment(department);
        return department;
    }

    @CacheEvict(value = "emp", key = "#id")
    public void deleteDepartment(Integer id) {
        System.out.println("deleteDepartment: "+id);
        //departmentMapper.deleteDepartmentById(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="dept", key="#departmentName")
            },
            put = {
                    @CachePut(value="dept", key="#result.id"),
                    @CachePut(value="dept", key="#result.departmentName")
            }
    )
    public Department getDepartmentByName(String departmentName) {
        return departmentMapper.getDepartmentByName(departmentName);
    }
}
