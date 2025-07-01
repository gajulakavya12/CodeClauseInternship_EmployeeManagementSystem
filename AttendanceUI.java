package com.CodeClause.EMS.ui;

import javax.swing.*;
import java.awt.event.*;
import com.CodeClause.EMS.dao.AttendanceDAO;
import com.CodeClause.EMS.model.Attendance;
import java.sql.Date;

public class AttendanceUI extends JFrame {
    JTextField idField, dateField, statusField;
    JButton addButton, deleteButton, viewButton;

    public AttendanceUI() {
        setTitle("Attendance Management");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setIconImage(new ImageIcon("src/images/icon.png").getImage());
        setContentPane(new JLabel(new ImageIcon("src/images/bg.png")));

        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(50, 50, 100, 25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(170, 50, 200, 25);
        add(idField);

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setBounds(50, 90, 150, 25);
        add(dateLabel);
        dateField = new JTextField();
        dateField.setBounds(210, 90, 160, 25);
        add(dateField);

        JLabel statusLabel = new JLabel("Status (Present/Absent):");
        statusLabel.setBounds(50, 130, 180, 25);
        add(statusLabel);
        statusField = new JTextField();
        statusField.setBounds(230, 130, 140, 25);
        add(statusField);

        addButton = new JButton("Add");
        addButton.setBounds(50, 190, 100, 30);
        add(addButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(180, 190, 100, 30);
        add(deleteButton);

        viewButton = new JButton("View All");
        viewButton.setBounds(310, 190, 100, 30);
        add(viewButton);

        AttendanceDAO dao = new AttendanceDAO();

        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                Date date = Date.valueOf(dateField.getText().trim());
                String status = statusField.getText().trim();

                Attendance a = new Attendance();
                a.setEmployeeId(id);
                a.setDate(date);
                a.setStatus(status);

                dao.addAttendance(a);
                JOptionPane.showMessageDialog(this, "Attendance Added Successfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String date = dateField.getText().trim();
                dao.deleteAttendance(id, date);
                JOptionPane.showMessageDialog(this, "Attendance Deleted Successfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        viewButton.addActionListener(e -> new ViewAttendanceUI());
    }
}

