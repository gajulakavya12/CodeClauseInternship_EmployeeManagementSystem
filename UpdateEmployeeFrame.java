package com.CodeClause.EMS.ui;

import com.CodeClause.EMS.dao.EmployeeDAO;
import com.CodeClause.EMS.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateEmployeeFrame extends JFrame {
    private JTextField idField, nameField, emailField, phoneField, deptField, salaryField, dateField;
    private final EmployeeDAO dao = new EmployeeDAO();

    public UpdateEmployeeFrame() {
        setTitle("Update Employee");
        setSize(600, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setIconImage(new ImageIcon("images/icon.png").getImage());
        setContentPane(new JLabel(new ImageIcon("images/background.png")));
        setLayout(null);

        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(50, 30, 100, 25);
        add(idLabel);
        idField = new JTextField();
        idField.setBounds(160, 30, 150, 25);
        add(idField);

        JButton loadBtn = new JButton("Load");
        loadBtn.setBounds(330, 30, 80, 25);
        add(loadBtn);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 25);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(160, 70, 200, 25);
        add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 110, 100, 25);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(160, 110, 200, 25);
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 150, 100, 25);
        add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setBounds(160, 150, 200, 25);
        add(phoneField);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(50, 190, 100, 25);
        add(deptLabel);
        deptField = new JTextField();
        deptField.setBounds(160, 190, 200, 25);
        add(deptField);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(50, 230, 100, 25);
        add(salaryLabel);
        salaryField = new JTextField();
        salaryField.setBounds(160, 230, 200, 25);
        add(salaryField);

        JLabel dateLabel = new JLabel("Join Date (yyyy-MM-dd):");
        dateLabel.setBounds(50, 270, 150, 25);
        add(dateLabel);
        dateField = new JTextField();
        dateField.setBounds(210, 270, 150, 25);
        add(dateField);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(180, 330, 150, 30);
        add(updateBtn);

        // Load Employee data by ID
        loadBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                Employee emp = dao.getEmployeeById(id);
                if (emp != null) {
                    nameField.setText(emp.getName());
                    emailField.setText(emp.getEmail());
                    phoneField.setText(emp.getPhone());
                    deptField.setText(emp.getDepartment());
                    salaryField.setText(String.valueOf(emp.getSalary()));
                    dateField.setText(new SimpleDateFormat("yyyy-MM-dd").format(emp.getJoinDate()));
                } else {
                    JOptionPane.showMessageDialog(this, "Employee not found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Update employee record
        updateBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String dept = deptField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                Date joinDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateField.getText());

                Employee emp = new Employee(id, name, email, phone, dept, salary, joinDate);
                dao.updateEmployee(emp);
                JOptionPane.showMessageDialog(this, "Employee updated successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}



