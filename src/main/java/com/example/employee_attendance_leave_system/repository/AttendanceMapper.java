package com.example.employee_attendance_leave_system.repository;

import com.example.employee_attendance_leave_system.model.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttendanceMapper {

    // 插入新的打卡紀錄
    @Insert("INSERT INTO attendance (employee_id, checkin_time, checkout_time) " +
            "VALUES (#{employeeId}, #{checkinTime}, #{checkoutTime})")
    void insertAttendance(Attendance attendance);

    // 更新打卡紀錄（更新下班時間）
    @Update("UPDATE attendance SET checkout_time = #{checkoutTime} WHERE id = #{id}")
    void updateAttendance(Attendance attendance);

    @Select("SELECT * FROM attendance WHERE employee_id = #{employeeId} AND (DATE(checkin_time) = DATE(#{date}) OR DATE(checkout_time) = DATE(#{date}))")
    List<Attendance> searchAttendanceByEmployeeAndDate(@Param("employeeId") int employeeId, @Param("date") Date date);

    @Select("SELECT * FROM attendance WHERE employee_id = #{employeeId}")
    List<Attendance> getAttendanceByEmployeeId(@Param("employeeId") int employeeId);

    @Select("SELECT * FROM attendance WHERE DATE(checkin_time) = DATE(#{date})")
    List<Attendance> getAttendanceByDate(@Param("date") Date date);

    // 查詢所有員工的出勤紀錄
    @Select("SELECT * FROM attendance")
    List<Attendance> getAllAttendance();

    // 查詢當天是否有打卡紀錄
    @Select("SELECT * FROM attendance WHERE employee_id = #{employeeId} AND DATE(checkin_time) = CURDATE()")
    Attendance getAttendanceByEmployeeAndDate(int employeeId);
}
