package com.example.employee_attendance_leave_system.model;

import java.util.Date;

public class Attendance {
    private int id;
    private int employeeId;
    private Date checkinTime;
    private Date checkoutTime;
    private Date workDate; // 新增欄位

    public Attendance() {}

    public Attendance(int id, int employeeId, Date checkinTime, Date checkoutTime, Date workDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", checkinTime=" + checkinTime +
                ", checkoutTime=" + checkoutTime +
                '}';
    }
}
