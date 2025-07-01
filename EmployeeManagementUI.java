package com.CodeClause.EMS.ui;

import com.CodeClause.EMS.dao.EmployeeDAO;
import com.CodeClause.EMS.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeManagementUI extends JFrame {

    private JTextField nameField, emailField, phoneField, deptField, salaryField, dateField, idField;
    private final EmployeeDAO dao = new EmployeeDAO();

    public EmployeeManagementUI() {
        setTitle("Employee Management");
        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon("images/icon.png").getImage());
        setContentPane(new JLabel(new ImageIcon("images/background.png")));
        setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(50, 30, 100, 25);
        add(lblId);
        idField = new JTextField();
        idField.setBounds(160, 30, 150, 25);
        add(idField);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 70, 100, 25);
        add(lblName);
        nameField = new JTextField();
        nameField.setBounds(160, 70, 150, 25);
        add(nameField);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 110, 100, 25);
        add(lblEmail);
        emailField = new JTextField();
        emailField.setBounds(160, 110, 150, 25);
        add(emailField);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(50, 150, 100, 25);
        add(lblPhone);
        phoneField = new JTextField();
        phoneField.setBounds(160, 150, 150, 25);
        add(phoneField);

        JLabel lblDept = new JLabel("Department:");
        lblDept.setBounds(50, 190, 100, 25);
        add(lblDept);
        deptField = new JTextField();
        deptField.setBounds(160, 190, 150, 25);
        add(deptField);

        JLabel lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(50, 230, 100, 25);
        add(lblSalary);
        salaryField = new JTextField();
        salaryField.setBounds(160, 230, 150, 25);
        add(salaryField);

        JLabel lblDate = new JLabel("Join Date (yyyy-mm-dd):");
        lblDate.setBounds(50, 270, 150, 25);
        add(lblDate);
        dateField = new JTextField();
        dateField.setBounds(210, 270, 100, 25);
        add(dateField);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(50, 320, 80, 30);
        add(addBtn);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(140, 320, 100, 30);
        add(updateBtn);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(250, 320, 100, 30);
        add(deleteBtn);

        JButton viewBtn = new JButton("View All");
        viewBtn.setBounds(360, 320, 100, 30);
        add(viewBtn);

        // Button Actions
        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String dept = deptField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                Date joinDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateField.getText());

                Employee emp = new Employee(0, name, email, phone, dept, salary, joinDate);
                dao.createEmployee(emp);
                JOptionPane.showMessageDialog(this, "Employee Added!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

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
                JOptionPane.showMessageDialog(this, "Employee Updated!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                dao.deleteEmployee(id);
                JOptionPane.showMessageDialog(this, "Employee Deleted!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        viewBtn.addActionListener(e -> {
            new ViewAllEmployeesFrame().setVisible(true); // You can create this class or I can send it next
        });
    }
}



