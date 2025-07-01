package com.CodeClause.EMS.ui;

import com.CodeClause.EMS.dao.AttendanceDAO;
import com.CodeClause.EMS.model.Attendance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class ViewAttendanceUI extends JFrame {

    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    JTextField txtSearch;
    JButton btnSearch, btnRefresh;

    public ViewAttendanceUI() {
        setTitle("View Attendance Records");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel lblSearch = new JLabel("Search by Emp ID:");
        lblSearch.setBounds(30, 20, 150, 25);
        txtSearch = new JTextField();
        txtSearch.setBounds(160, 20, 150, 25);
        btnSearch = new JButton("Search");
        btnSearch.setBounds(330, 20, 90, 25);
        btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(430, 20, 100, 25);

        String[] columns = {"Emp ID", "Date", "Status"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 60, 520, 280);

        add(lblSearch); add(txtSearch);
        add(btnSearch); add(btnRefresh);
        add(scrollPane);

        loadAttendanceData(null); // Load all initially

        btnSearch.addActionListener(e -> {
            String empIdStr = txtSearch.getText().trim();
            if (!empIdStr.isEmpty()) {
                try {
                    int empId = Integer.parseInt(empIdStr);
                    loadAttendanceData(empId);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Enter a valid employee ID.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter an employee ID.");
            }
        });

        btnRefresh.addActionListener(e -> {
            txtSearch.setText("");
            loadAttendanceData(null); // Reload all data
        });

        setVisible(true);
    }

    private void loadAttendanceData(Integer empId) {
        model.setRowCount(0); // Clear table
        AttendanceDAO dao = new AttendanceDAO();
        List<Attendance> list = dao.getAllAttendance();

        for (Attendance a : list) {
            if (empId == null || a.getEmployeeId() == empId) {
                model.addRow(new Object[]{
                    a.getEmployeeId(),
                    a.getDate(),
                    a.getStatus()
                });
            }
        }
    }
}


