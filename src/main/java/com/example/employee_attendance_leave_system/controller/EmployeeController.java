package com.example.employee_attendance_leave_system.controller;

import com.example.employee_attendance_leave_system.model.Employee;
import com.example.employee_attendance_leave_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 查詢單一員工
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Employee not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.ok(employee);
    }

    // 查詢所有員工
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    // 新增員工
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee created successfully");
        response.put("employee", employee);

        return ResponseEntity.created(URI.create("/api/employees/" + employee.getId())).body(response);
    }

    // 更新員工資料
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee existing = employeeService.getEmployeeById(id);
        if (existing == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Employee not found");
            return ResponseEntity.status(404).body(response);
        }

        employee.setId(id);
        employeeService.updateEmployee(employee);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee updated successfully");
        response.put("employee", employee);
        return ResponseEntity.ok(response);
    }
}
