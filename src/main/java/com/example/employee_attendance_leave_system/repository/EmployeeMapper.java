package com.example.employee_attendance_leave_system.repository;

import com.example.employee_attendance_leave_system.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    // 查詢所有員工
    @Select("SELECT * FROM employee")
    List<Employee> getAllEmployee();

    // 根據員工ID查詢員工
    @Select("SELECT * FROM employee WHERE id = #{id}")
    Employee getEmployeeById(int id);

    // 新增員工
    @Insert("INSERT INTO employee (name, email, hire_date) VALUES (#{name}, #{email}, #{hireDate})")
    void insertEmployee(Employee employee);

    // 更新員工資料
    @Update("UPDATE employee SET name = #{name}, email = #{email}, hire_date = #{hireDate} WHERE id = #{id}")
    void updateEmployee(Employee employee);

    // 刪除員工資料
    @Delete("DELETE FROM employee WHERE id = #{id}")
    void deleteEmployee(int id);
}
