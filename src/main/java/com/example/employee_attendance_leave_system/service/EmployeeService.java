package com.example.employee_attendance_leave_system.service;

import com.example.employee_attendance_leave_system.model.Employee;
import com.example.employee_attendance_leave_system.repository.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    // 查詢員工資料
    public Employee getEmployeeById(int id) {
        return employeeMapper.getEmployeeById(id);
    }

    // 查詢所有員工
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }
    // 新增員工
    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }

    // 更新員工資料
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

}
