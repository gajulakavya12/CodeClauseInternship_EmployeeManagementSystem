package com.CodeClause.EMS.ui;

import com.CodeClause.EMS.dao.EmployeeDAO;
import com.CodeClause.EMS.model.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewAllEmployeesFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private final EmployeeDAO dao = new EmployeeDAO();

    public ViewAllEmployeesFrame() {
        setTitle("All Employees");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon("images/icon.png").getImage());
        setContentPane(new JLabel(new ImageIcon("images/background.png")));
        setLayout(new BorderLayout());

        // Define table columns
        String[] columns = {"ID", "Name", "Email", "Phone", "Department", "Salary", "Join Date"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(new Font("SansSerif", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        loadEmployeeData();

        setVisible(true);
    }

    private void loadEmployeeData() {
        try {
            List<Employee> employees = dao.getAllEmployees();
            for (Employee emp : employees) {
                model.addRow(new Object[]{
                    emp.getId(),
                    emp.getName(),
                    emp.getEmail(),
                    emp.getPhone(),
                    emp.getDepartment(),
                    emp.getSalary(),
                    emp.getJoinDate()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }
}


