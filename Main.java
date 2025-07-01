package com.CodeClause.EMS;

import javax.swing.SwingUtilities;
import com.CodeClause.EMS.ui.AdminLoginUI;

public class Main {
    public static void main(String[] args) {
        // Run UI on Event Dispatch Thread (recommended for Swing apps)
        SwingUtilities.invokeLater(() -> {
            new AdminLoginUI();
        });
    }
}



