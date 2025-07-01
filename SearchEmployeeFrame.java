package com.CodeClause.EMS.ui;

import com.CodeClause.EMS.dao.EmployeeDAO;
import com.CodeClause.EMS.model.Employee;

import javax.swing.*;
import java.awt.*;

public class SearchEmployeeFrame extends JFrame {
    private JTextField idField;
    private JTextArea resultArea;
    private final EmployeeDAO dao = new EmployeeDAO();

    public SearchEmployeeFrame() {
        setTitle("Search Employee");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon("images/icon.png").getImage());
        setContentPane(new JLabel(new ImageIcon("images/background.png")));
        setLayout(null);

        JLabel idLabel = new JLabel("Enter Employee ID:");
        idLabel.setBounds(40, 30, 150, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(200, 30, 150, 25);
        add(idField);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(170, 70, 120, 30);
        add(searchBtn);

        resultArea = new JTextArea();
        resultArea.setBounds(40, 120, 400, 200);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(resultArea);

        searchBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                Employee emp = dao.getEmployeeById(id);
                if (emp != null) {
                    resultArea.setText("ID: " + emp.getId() +
                                     "\nName: " + emp.getName() +
                                     "\nEmail: " + emp.getEmail() +
                                     "\nPhone: " + emp.getPhone() +
                                     "\nDepartment: " + emp.getDepartment() +
                                     "\nSalary: " + emp.getSalary() +
                                     "\nJoin Date: " + emp.getJoinDate());
                } else {
                    resultArea.setText("Employee not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid ID.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}


