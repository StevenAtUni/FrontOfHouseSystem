/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lancastersguiv2;


import FOHClasses.DatabaseDAO.WaiterDAO;

/**
 *
 * @author josep
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        password = new javax.swing.JPasswordField();
        bLogin = new javax.swing.JButton();
        lBackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(575, 470));

        jLayeredPane1.setLayer(password, 2);
        jLayeredPane1.add(password);
        password.setBounds(228, 294, 110, 40);

        bLogin.setText("Login");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });
        jLayeredPane1.setLayer(bLogin, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(bLogin);
        bLogin.setBounds(244, 355, 80, 28);

        lBackgroundImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLancasters/LancastersLogin1.jpg"))); // NOI18N
        jLayeredPane1.setLayer(lBackgroundImage, 1);
        jLayeredPane1.add(lBackgroundImage);
        lBackgroundImage.setBounds(0, 0, 580, 468);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String pWord = password.getText();
        int userId = WaiterDAO.checkPassword(pWord);

        if (pWord == "1234")
        {
            TabbedGUI gui = new TabbedGUI();
            gui.setVisible(true);
            this.setVisible(false);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton bLogin;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lBackgroundImage;
    private javax.swing.JPasswordField password;
    // End of variables declaration
}