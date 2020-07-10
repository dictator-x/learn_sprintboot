package com.learnspringboot.mapper;

import com.learnspringboot.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepartmentById(Integer id);

    @Delete("delete from department where id=#{id")
    public int deleteDepartmentById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) value(#{departmentName})")
    public int insertDepartment(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDepartment(Department department);

    @Select("select * from department where departmentName=#{departmentName}")
    public Department getDepartmentByName(String departmentName);
}
