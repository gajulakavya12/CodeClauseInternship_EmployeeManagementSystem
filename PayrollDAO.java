package com.CodeClause.EMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.CodeClause.EMS.DBConnection;
import com.CodeClause.EMS.model.Payroll;

public class PayrollDAO {

    // Create Payroll
    public void createPayroll(Payroll p) {
        String query = "INSERT INTO payroll (employee_id, month, year, base_salary, bonus, deductions, net_salary) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, p.getEmployeeId());
            pst.setString(2, p.getMonth());
            pst.setInt(3, p.getYear());
            pst.setDouble(4, p.getBaseSalary());
            pst.setDouble(5, p.getBonus());
            pst.setDouble(6, p.getDeductions());
            pst.setDouble(7, p.getNetSalary());
            pst.executeUpdate();

            System.out.println("Payroll Saved Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Payroll
    public void updatePayroll(Payroll p) {
        String query = "UPDATE payroll SET base_salary = ?, bonus = ?, deductions = ?, net_salary = ? WHERE employee_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setDouble(1, p.getBaseSalary());
            pst.setDouble(2, p.getBonus());
            pst.setDouble(3, p.getDeductions());
            pst.setDouble(4, p.getNetSalary());
            pst.setInt(5, p.getEmployeeId());
            pst.executeUpdate();

            System.out.println("Payroll Updated Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Payroll
    public void deletePayroll(int empId) {
        String query = "DELETE FROM payroll WHERE employee_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, empId);
            pst.executeUpdate();

            System.out.println("Payroll Deleted Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


