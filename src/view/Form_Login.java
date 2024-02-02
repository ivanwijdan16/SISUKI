package view;

import Main.Menu_Utama;
import Main.Menu_Utama;
import dao.DAO_Login;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Model_Login;
import org.jdesktop.swingx.border.DropShadowBorder;
import service.Service_Login;

public class Form_Login extends javax.swing.JFrame {
    int xx, xy;
        
    private Service_Login servis = new DAO_Login();
    
    public static boolean tutup = false;
    
    public Form_Login() {
        initComponents();
        
        setBackground(new Color(0, 0, 0, 0));
        setShadowPanel();
        
        bt_login.requestFocus();
        lb_hidePassword.setVisible(false);
    }

    
    void bersih(){
        t_username.setText("username");
        t_password.setText("password");
        //t_level.setText("");
    }
    
    void setShadowPanel(){
        int shadowSize = 5; // ukuran bayangan dalam piksel
        Color shadowColor = Color.BLACK; // warna bayangan
        DropShadowBorder border = new DropShadowBorder(shadowColor, shadowSize, 0.5f, shadowSize, true, true, true, true);
        this.getRootPane().setBorder(border);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_showPassword = new javax.swing.JLabel();
        lb_hidePassword = new javax.swing.JLabel();
        bt_exit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t_username = new javax.swing.JTextField();
        t_password = new javax.swing.JPasswordField();
        bt_login = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        panelRounded1 = new custom.PanelRounded();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_depot_512px.png")).getImage());
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_showPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_showPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_eye_20px.png"))); // NOI18N
        lb_showPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_showPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(lb_showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 40, 40));

        lb_hidePassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_hidePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_invisible_20px.png"))); // NOI18N
        lb_hidePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_hidePasswordMouseClicked(evt);
            }
        });
        getContentPane().add(lb_hidePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 40, 40));

        bt_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        bt_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_exitMouseClicked(evt);
            }
        });
        getContentPane().add(bt_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LoginImage.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Password.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Username.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 40));

        t_username.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        t_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_username.setText("username");
        t_username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));
        t_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_usernameFocusLost(evt);
            }
        });
        getContentPane().add(t_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 220, 40));

        t_password.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        t_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_password.setText("password");
        t_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));
        t_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_passwordFocusLost(evt);
            }
        });
        t_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_passwordKeyPressed(evt);
            }
        });
        getContentPane().add(t_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 220, 40));

        bt_login.setBackground(new java.awt.Color(51, 0, 204));
        bt_login.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        bt_login.setForeground(new java.awt.Color(255, 255, 255));
        bt_login.setText("LOGIN");
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        getContentPane().add(bt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 220, 40));

        background.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Login.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 420, 360));

        panelRounded1.setBackground(new java.awt.Color(255, 255, 255));
        panelRounded1.setRoundBottomLeft(50);
        panelRounded1.setRoundBottomRight(50);
        panelRounded1.setRoundTopLeft(50);
        panelRounded1.setRoundTopRight(50);

        javax.swing.GroupLayout panelRounded1Layout = new javax.swing.GroupLayout(panelRounded1);
        panelRounded1.setLayout(panelRounded1Layout);
        panelRounded1Layout.setHorizontalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        panelRounded1Layout.setVerticalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(panelRounded1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void bt_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_exitMouseClicked
        // Menutup Form_Login
        dispose(); 
        
        // Menghentikan aplikasi
        System.exit(0); 
    }//GEN-LAST:event_bt_exitMouseClicked

    private void t_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameFocusGained
        String user=t_username.getText();
        if(user.equals("username")){
            t_username.setText("");
        }
    }//GEN-LAST:event_t_usernameFocusGained

    private void t_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_usernameFocusLost
        String user=t_username.getText();
        if(user.equals("")||user.equals("username")){
            t_username.setText("username");

        }
    }//GEN-LAST:event_t_usernameFocusLost

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        prosesLogin();
    }//GEN-LAST:event_bt_loginActionPerformed

    private void t_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordFocusGained
        String pass=t_password.getText();
        if(pass.equals("password")){
            t_password.setText("");

        }
    }//GEN-LAST:event_t_passwordFocusGained

    private void t_passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_passwordFocusLost
        String pass=t_password.getText();
        if(pass.equals("")||pass.equals("password")){
            t_password.setText("password");

        }
    }//GEN-LAST:event_t_passwordFocusLost

    private void lb_showPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_showPasswordMouseClicked
        lb_showPassword.setVisible(false);
        lb_hidePassword.setVisible(true);
        t_password.setEchoChar((char)0);
    }//GEN-LAST:event_lb_showPasswordMouseClicked

    private void lb_hidePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_hidePasswordMouseClicked
        lb_showPassword.setVisible(true);
        lb_hidePassword.setVisible(false);
        t_password.setEchoChar('*');
    }//GEN-LAST:event_lb_hidePasswordMouseClicked

    private void t_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_passwordKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            bt_login.doClick();
        }
    }//GEN-LAST:event_t_passwordKeyPressed

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
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel bt_exit;
    private javax.swing.JButton bt_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb_hidePassword;
    private javax.swing.JLabel lb_showPassword;
    private custom.PanelRounded panelRounded1;
    private javax.swing.JPasswordField t_password;
    private javax.swing.JTextField t_username;
    // End of variables declaration//GEN-END:variables

    private void prosesLogin(){
        if(validasiInput()==true){
            String id = t_username.getText();
            String user = t_username.getText();
            String pass = t_password.getText();
            
            Model_Login mod_log = new Model_Login();
            
            mod_log.setId_user(id);
            mod_log.setUsername(user);
            mod_log.setPass_user(pass);
            
            servis.prosesLogin(mod_log);
            if(tutup){
                dispose();
            }
        }
    }

    private boolean validasiInput() {
        boolean valid = false;
        if(t_username.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
        }else if(t_password.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Password tidak boleh kosong");
        }else{
            valid = true;
        }
        return valid;
    }


}
