package com.CodeClause.EMS.dao;

import com.CodeClause.EMS.DBConnection;
import com.CodeClause.EMS.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements EmployeeDAOI {

    @Override
    public void createEmployee(Employee emp) {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO employee (name, email, phone, department, salary, join_date) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, emp.getName());
            pstm.setString(2, emp.getEmail());
            pstm.setString(3, emp.getPhone());
            pstm.setString(4, emp.getDepartment());
            pstm.setDouble(5, emp.getSalary());
            pstm.setDate(6, new java.sql.Date(emp.getJoinDate().getTime()));

            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("Employee Inserted Successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM employee";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                emp.setPhone(rs.getString("phone"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setJoinDate(rs.getDate("join_date"));
                list.add(emp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee emp = null;
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM employee WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                emp.setPhone(rs.getString("phone"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setJoinDate(rs.getDate("join_date"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return emp;
    }

    @Override
    public void updateEmployee(Employee emp) {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE employee SET name=?, email=?, phone=?, department=?, salary=?, join_date=? WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, emp.getName());
            pstm.setString(2, emp.getEmail());
            pstm.setString(3, emp.getPhone());
            pstm.setString(4, emp.getDepartment());
            pstm.setDouble(5, emp.getSalary());
            pstm.setDate(6, new java.sql.Date(emp.getJoinDate().getTime()));
            pstm.setInt(7, emp.getId());

            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("Employee Updated Successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Connection con = DBConnection.getConnection();
        String query = "DELETE FROM employee WHERE id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("Employee Deleted Successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int getTotalEmployeeCount() throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT COUNT(*) FROM employee";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        conn.close();
        return count;
    }
}
