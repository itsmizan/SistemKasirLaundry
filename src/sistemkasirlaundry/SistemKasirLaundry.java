package sistemkasirlaundry;

import javax.swing.UIManager;
import sistemkasirlaundry.view.FormLogin;

/**
 * Titik awal aplikasi Sistem Kasir Laundry.
 */
public class SistemKasirLaundry {

    public static void main(String[] args) {
        // Memakai tampilan bawaan sistem operasi (Windows) agar terlihat rapi
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Look and feel tidak tersedia: " + e.getMessage());
        }
        java.awt.EventQueue.invokeLater(() -> new FormLogin().setVisible(true));
    }
}
