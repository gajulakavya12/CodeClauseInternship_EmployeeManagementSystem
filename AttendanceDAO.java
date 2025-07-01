package com.CodeClause.EMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.CodeClause.EMS.DBConnection;
import com.CodeClause.EMS.model.Attendance;

public class AttendanceDAO {

    // Add Attendance
    public void addAttendance(Attendance a) {
        String query = "INSERT INTO attendance (employee_id, date, status) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, a.getEmployeeId());
            pst.setDate(2, a.getDate());
            pst.setString(3, a.getStatus());
            pst.executeUpdate();

            System.out.println("Attendance Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Attendance
    public void deleteAttendance(int empId, String date) {
        String query = "DELETE FROM attendance WHERE employee_id = ? AND date = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, empId);
            pst.setDate(2, Date.valueOf(date));
            pst.executeUpdate();

            System.out.println("Attendance Deleted Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Attendance
    public List<Attendance> getAllAttendance() {
        List<Attendance> list = new ArrayList<>();
        String query = "SELECT * FROM attendance";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Attendance a = new Attendance();
                a.setEmployeeId(rs.getInt("employee_id"));
                a.setDate(rs.getDate("date"));
                a.setStatus(rs.getString("status"));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Count Present Today
    public static int getTodayAttendanceCount() {
        String query = "SELECT COUNT(*) FROM attendance WHERE date = CURDATE() AND status = 'Present'";
        int count = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
}


