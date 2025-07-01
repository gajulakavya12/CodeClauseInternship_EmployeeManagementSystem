package com.CodeClause.EMS.ui;

import javax.swing.*;
import java.awt.*;

public class AdminLoginUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public AdminLoginUI() {
        setTitle("Admin Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set icon image (safe check)
        try {
            setIconImage(new ImageIcon("src/images/icon.png").getImage());
        } catch (Exception e) {
            System.out.println("Icon image not found.");
        }

        // Set background image (safe check)
        try {
            setContentPane(new JLabel(new ImageIcon("src/images/background.png")));
        } catch (Exception e) {
            System.out.println("Background image not found.");
        }

        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 70, 100, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 70, 150, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 110, 100, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 150, 25);
        add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(80, 160, 100, 30);
        add(loginBtn);

        JButton forgotBtn = new JButton("Forgot Password");
        forgotBtn.setBounds(190, 160, 150, 30);
        add(forgotBtn);

        loginBtn.addActionListener(e -> {
            String user = usernameField.getText().trim();
            String pass = new String(passwordField.getPassword()).trim();

            if (user.equals("admin") && pass.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new DashboardUI().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        });

        forgotBtn.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Default Username: admin\nDefault Password: admin123",
                "Forgot Password", JOptionPane.INFORMATION_MESSAGE));

        setVisible(true); // Make sure it's visible
    }
}





