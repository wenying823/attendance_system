package com.example.employee_attendance_leave_system.controller;

import com.example.employee_attendance_leave_system.model.Attendance;
import com.example.employee_attendance_leave_system.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // 上班打卡
    @PostMapping("/checkin")
    public ResponseEntity<Map<String, Object>> checkIn(@RequestParam int employeeId) {
        attendanceService.checkIn(employeeId);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Check-in successful");
        response.put("employeeId", employeeId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 下班打卡
    @PostMapping("/checkout")
    public ResponseEntity<Map<String, Object>> checkOut(@RequestParam int employeeId) {
        attendanceService.checkOut(employeeId);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Check-out successful");
        response.put("employeeId", employeeId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 查詢單一員工的出勤紀錄
    @GetMapping
    public ResponseEntity<List<Attendance>> getAttendance(
            @RequestParam(required = false) Integer employeeId,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Attendance> result = attendanceService.searchAttendance(employeeId, date);
        return ResponseEntity.ok(result);
    }

    // 查詢所有員工出勤紀錄
    @GetMapping("/all")
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        List<Attendance> result = attendanceService.getAllAttendance();
        return ResponseEntity.ok(result);
    }
}
