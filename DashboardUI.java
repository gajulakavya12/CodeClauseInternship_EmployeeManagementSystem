package com.CodeClause.EMS.ui;

import com.CodeClause.EMS.dao.EmployeeDAO;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DashboardUI extends JFrame {
    private JLabel totalLabel, presentLabel;

    public DashboardUI() {
        setTitle("Employee Management Dashboard");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon("src/images/icon.png").getImage());
        setContentPane(new JLabel(new ImageIcon("src/images/background.png")));
        setLayout(null);

        totalLabel = new JLabel("Total Employees: ");
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        totalLabel.setBounds(30, 30, 300, 30);
        add(totalLabel);

        presentLabel = new JLabel("Present Today: ");
        presentLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        presentLabel.setBounds(30, 70, 300, 30);
        add(presentLabel);

        JButton addBtn = new JButton("Add Employee");
        addBtn.setBounds(30, 130, 150, 30);
        add(addBtn);

        JButton viewBtn = new JButton("View All Employees");
        viewBtn.setBounds(200, 130, 180, 30);
        add(viewBtn);

        JButton searchBtn = new JButton("Search Employee");
        searchBtn.setBounds(400, 130, 180, 30);
        add(searchBtn);

        JButton attendanceBtn = new JButton("Manage Attendance");
        attendanceBtn.setBounds(30, 180, 180, 30);
        add(attendanceBtn);

        JButton viewAttendanceBtn = new JButton("View Attendance");
        viewAttendanceBtn.setBounds(230, 180, 180, 30);
        add(viewAttendanceBtn);

        JButton payrollBtn = new JButton("Manage Payroll");
        payrollBtn.setBounds(430, 180, 180, 30);
        add(payrollBtn);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(560, 20, 100, 25);
        add(logoutBtn);

        // Actions
        addBtn.addActionListener(e -> new EmployeeManagementUI().setVisible(true));
        viewBtn.addActionListener(e -> new ViewAllEmployeesFrame().setVisible(true));
        searchBtn.addActionListener(e -> new SearchEmployeeFrame().setVisible(true));
        logoutBtn.addActionListener(e -> {
            dispose();
            new AdminLoginUI().setVisible(true);
        });

        attendanceBtn.addActionListener(e -> new AttendanceUI().setVisible(true));
        viewAttendanceBtn.addActionListener(e -> new ViewAttendanceUI().setVisible(true));
        payrollBtn.addActionListener(e -> new PayrollUI().setVisible(true));

        loadStats();
    }

    private void loadStats() {
        try {
            int total = EmployeeDAO.getTotalEmployeeCount();
            totalLabel.setText("Total Employees: " + total);

            int present = new Random().nextInt((total - (int) (total * 0.8)) + 1) + (int) (total * 0.8);
            presentLabel.setText("Present Today: " + present);
        } catch (Exception e) {
            totalLabel.setText("Total Employees: Error");
            presentLabel.setText("Present Today: Error");
        }
    }
}





