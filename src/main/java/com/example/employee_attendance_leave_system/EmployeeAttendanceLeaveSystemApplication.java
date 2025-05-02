package com.example.employee_attendance_leave_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class EmployeeAttendanceLeaveSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAttendanceLeaveSystemApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EmployeeAttendanceLeaveSystemApplication.class);
	}

}
