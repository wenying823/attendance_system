package com.example.employee_attendance_leave_system.service;

import com.example.employee_attendance_leave_system.model.Attendance;
import com.example.employee_attendance_leave_system.repository.EmployeeMapper;
import com.example.employee_attendance_leave_system.repository.AttendanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    // 上班打卡
    public void checkIn(int employeeId) {
        // 檢查是否已經打過卡，若是，則不再打卡
        Attendance existingAttendance = attendanceMapper.getAttendanceByEmployeeAndDate(employeeId);
        if (existingAttendance != null) {
            throw new IllegalStateException("Already checked in for today.");
        }

        // 創建新的打卡紀錄
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employeeId);
        attendance.setCheckinTime(new java.util.Date());

        attendanceMapper.insertAttendance(attendance);
    }

    // 下班打卡
    public void checkOut(int employeeId) {
        // 查詢該員工的當日打卡紀錄
        Attendance attendance = attendanceMapper.getAttendanceByEmployeeAndDate(employeeId);

        if (attendance == null) {
            attendance = new Attendance();
            attendance.setEmployeeId(employeeId);
            attendance.setCheckoutTime(new java.util.Date());
            attendanceMapper.insertAttendance(attendance);
            System.out.println("✅ 下班補打卡成功：" + attendance);
        } else {
            attendance.setCheckoutTime(new java.util.Date());
            attendanceMapper.updateAttendance(attendance);
            System.out.println("✅ 下班打卡成功（更新）： " + attendance);
        }
    }

    // 查詢特定員工或特定日期出勤紀錄
    public List<Attendance> searchAttendance(Integer employeeId, Date date) {
        if (employeeId != null && date != null) {
            return attendanceMapper.searchAttendanceByEmployeeAndDate(employeeId, date);
        } else if (employeeId != null) {
            return attendanceMapper.getAttendanceByEmployeeId(employeeId);
        } else if (date != null) {
            return attendanceMapper.getAttendanceByDate(date);
        } else {
            return attendanceMapper.getAllAttendance();
        }
    }


    // 查詢所有員工的出勤紀錄
    public List<Attendance> getAllAttendance() {
        return attendanceMapper.getAllAttendance();
    }
}
