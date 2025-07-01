package com.CodeClause.EMS.ui;

import javax.swing.*;
import com.CodeClause.EMS.dao.PayrollDAO;
import com.CodeClause.EMS.model.Payroll;
import java.time.LocalDate;

public class PayrollUI extends JFrame {
    JTextField idField, salaryField, bonusField, deductionField;
    JButton addButton, updateButton, deleteButton;

    public PayrollUI() {
        setTitle("Payroll Management");
        setSize(500, 450);
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

        JLabel salaryLabel = new JLabel("Base Salary:");
        salaryLabel.setBounds(50, 90, 100, 25);
        add(salaryLabel);
        salaryField = new JTextField();
        salaryField.setBounds(170, 90, 200, 25);
        add(salaryField);

        JLabel bonusLabel = new JLabel("Bonus:");
        bonusLabel.setBounds(50, 130, 100, 25);
        add(bonusLabel);
        bonusField = new JTextField();
        bonusField.setBounds(170, 130, 200, 25);
        add(bonusField);

        JLabel deductionLabel = new JLabel("Deductions:");
        deductionLabel.setBounds(50, 170, 100, 25);
        add(deductionLabel);
        deductionField = new JTextField();
        deductionField.setBounds(170, 170, 200, 25);
        add(deductionField);

        addButton = new JButton("Add");
        addButton.setBounds(50, 230, 100, 30);
        add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(170, 230, 100, 30);
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(290, 230, 100, 30);
        add(deleteButton);

        PayrollDAO dao = new PayrollDAO();

        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                double base = Double.parseDouble(salaryField.getText().trim());
                double bonus = Double.parseDouble(bonusField.getText().trim());
                double deduction = Double.parseDouble(deductionField.getText().trim());

                LocalDate now = LocalDate.now();

                Payroll p = new Payroll();
                p.setEmployeeId(id);
                p.setBaseSalary(base);
                p.setBonus(bonus);
                p.setDeductions(deduction);
                p.setMonth(now.getMonth().toString());
                p.setYear(now.getYear());
                p.setNetSalary(base + bonus - deduction);

                dao.createPayroll(p);
                JOptionPane.showMessageDialog(this, "Payroll Added Successfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        updateButton.addActionListener(e -> {
            // Similar logic can be added if required
        });

        deleteButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                dao.deletePayroll(id);
                JOptionPane.showMessageDialog(this, "Payroll Deleted Successfully");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }
}



