package com.CodeClause.EMS.ui;

import javax.swing.*;

import com.CodeClause.EMS.dao.EmployeeDAO;

import java.awt.event.*;

public class DeleteEmployeeFrame extends JFrame {
    JTextField idField;

    public DeleteEmployeeFrame() {
        setTitle("Delete Employee");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel idLabel = new JLabel("Enter Employee ID:");
        idLabel.setBounds(30, 30, 150, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(150, 30, 150, 25);
        add(idField);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(100, 80, 120, 30);
        add(deleteBtn);

        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    new EmployeeDAO().deleteEmployee(id);
                    JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}

