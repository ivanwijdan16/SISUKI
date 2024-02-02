package Main;

import dao.DAO_Login;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Model_Login;
import service.Service_Login;
import view.Form_Login;
import view.Master_Barang;
import view.Laporan_Barang;
import view.Master_Supplier;
import view.Master_JenisBarang;
import view.Master_User;
import view.Menu_Settings;
import view.Transaksi_Penjualan;
import view.Transaksi_Pembelian;
import view.Transaksi_Pemesanan;


public class Menu_Utama extends javax.swing.JFrame {

    private Timer timer;
    private Model_Login modelLogin;
    
    
    public Menu_Utama(Model_Login modelLogin) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        lb_nama.setText(modelLogin.getNama_user());
        lb_level.setText(modelLogin.getJabatan());
        lb_id.setText(modelLogin.getId_user());
        lb_id.setVisible(false);
        
        try {
            // Konversi blob gambar ke ImageIcon
            byte[] img = modelLogin.getGambar().getBytes(1, (int) modelLogin.getGambar().length());
            ImageIcon imageIcon = new ImageIcon(img);

            // Ukuran JLabel
            int labelWidth = 100;
            int labelHeight = 300;

            // Ukuran gambar asli
            int imageWidth = imageIcon.getIconWidth();
            int imageHeight = imageIcon.getIconHeight();

            // Hitung skala untuk ukuran gambar yang baru
            double scaleX = (double) labelWidth / (double) imageWidth;
            double scaleY = (double) labelHeight / (double) imageHeight;
            double scale = Math.min(scaleX, scaleY);

            // Ubah ukuran gambar dengan skala yang sudah dihitung
            Image scaledImage = imageIcon.getImage().getScaledInstance((int) (scale * imageWidth), (int) (scale * imageHeight), Image.SCALE_SMOOTH);

            // Tampilkan ImageIcon pada JLabel
            lb_gambar.setIcon(new ImageIcon(scaledImage));
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Utama.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        execute(modelLogin);
            
        //Membuat timer dengan delay 1000 ms (1 detik) dan ActionListener yang mempengaruhi label
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDayDateTime();
            }
        });
        
        //memulai timer
        timer.start();
        
       
    }

    private void showDayDateTime() {
        Calendar calendar = Calendar.getInstance();
        Date now = new Date();
        SimpleDateFormat formatHari = new SimpleDateFormat("EEEE", new Locale("in","ID"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String hari = formatHari.format(calendar.getTime());
        String dateTime = dateFormat.format(now);
        lb_tanggal.setText(hari+", "+dateTime);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_navbar = new javax.swing.JPanel();
        lb_tanggal = new javax.swing.JLabel();
        lb_username = new javax.swing.JLabel();
        btn_settings = new javax.swing.JButton();
        lb_id = new javax.swing.JLabel();
        pn_sidebar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pn_menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lb_gambar = new javax.swing.JLabel();
        lb_level = new javax.swing.JLabel();
        lb_nama = new javax.swing.JLabel();
        pn_content = new javax.swing.JPanel();
        panelCustom1 = new custom.PanelRounded();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project Tugas Akhir Kuliah");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_depot_512px.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pn_navbar.setBackground(new java.awt.Color(51, 0, 102));
        pn_navbar.setPreferredSize(new java.awt.Dimension(872, 70));

        lb_tanggal.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lb_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lb_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tanggal.setText("Hari, Tanggal Waktu");

        lb_username.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lb_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_username.setPreferredSize(new java.awt.Dimension(56, 30));

        btn_settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_settings_20px.png"))); // NOI18N
        btn_settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_settingsActionPerformed(evt);
            }
        });

        lb_id.setForeground(new java.awt.Color(255, 255, 255));
        lb_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_id.setText("ID");

        javax.swing.GroupLayout pn_navbarLayout = new javax.swing.GroupLayout(pn_navbar);
        pn_navbar.setLayout(pn_navbarLayout);
        pn_navbarLayout.setHorizontalGroup(
            pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_navbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(lb_tanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_settings)
                .addContainerGap())
        );
        pn_navbarLayout.setVerticalGroup(
            pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_navbarLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_settings)))
                .addContainerGap())
        );

        getContentPane().add(pn_navbar, java.awt.BorderLayout.PAGE_START);

        pn_sidebar.setBackground(new java.awt.Color(255, 255, 255));
        pn_sidebar.setPreferredSize(new java.awt.Dimension(280, 495));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        pn_menu.setBackground(new java.awt.Color(255, 255, 255));
        pn_menu.setLayout(new javax.swing.BoxLayout(pn_menu, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pn_menu);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lb_gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lb_level.setFont(new java.awt.Font("Poppins", 2, 14)); // NOI18N
        lb_level.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_level.setText("Level");
        lb_level.setPreferredSize(new java.awt.Dimension(56, 30));

        lb_nama.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lb_nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_nama.setText("Nama");
        lb_nama.setPreferredSize(new java.awt.Dimension(56, 30));

        javax.swing.GroupLayout pn_sidebarLayout = new javax.swing.GroupLayout(pn_sidebar);
        pn_sidebar.setLayout(pn_sidebarLayout);
        pn_sidebarLayout.setHorizontalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_sidebarLayout.createSequentialGroup()
                .addGroup(pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addGroup(pn_sidebarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lb_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_level, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pn_sidebarLayout.setVerticalGroup(
            pn_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_sidebarLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_level, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
        );

        getContentPane().add(pn_sidebar, java.awt.BorderLayout.LINE_START);

        pn_content.setBackground(new java.awt.Color(204, 204, 204));

        panelCustom1.setBackground(new java.awt.Color(255, 255, 255));
        panelCustom1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pn_contentLayout = new javax.swing.GroupLayout(pn_content);
        pn_content.setLayout(pn_contentLayout);
        pn_contentLayout.setHorizontalGroup(
            pn_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_contentLayout.setVerticalGroup(
            pn_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_contentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pn_content, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(859, 604));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        panelCustom1.add(new content_bg());
        panelCustom1.repaint();
        panelCustom1.revalidate();

    }//GEN-LAST:event_formWindowOpened

    private void btn_settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_settingsActionPerformed
        //Membuat instance JDialog
        Menu_Settings menu = new Menu_Settings(this, true, this);
        
        //Menampilkan JDialog dibawah button settings
        Point p = btn_settings.getLocationOnScreen();
        int x = p.x + btn_settings.getWidth() - menu.getWidth();
        int y = p.y + btn_settings.getHeight();
        menu.setLocation(x,y);
        menu.setVisible(true);
    }//GEN-LAST:event_btn_settingsActionPerformed
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Model_Login modelLogin = null;
                new Menu_Utama(modelLogin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_settings;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_gambar;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_level;
    private javax.swing.JLabel lb_nama;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JLabel lb_username;
    private custom.PanelRounded panelCustom1;
    private javax.swing.JPanel pn_content;
    private javax.swing.JPanel pn_menu;
    private javax.swing.JPanel pn_navbar;
    private javax.swing.JPanel pn_sidebar;
    // End of variables declaration//GEN-END:variables

    private void execute(Model_Login modelLogin) {
        //Source Icon Menu Home
        ImageIcon iconHome        = new ImageIcon(getClass().getResource("/img/icons8_hangar_20px.png"));
        
        //Source Icon Menu Master
        ImageIcon iconMaster        = new ImageIcon(getClass().getResource("/img/icons8_new_product_20px.png"));
        ImageIcon iconBarang        = new ImageIcon(getClass().getResource("/img/icons8_used_product_20px.png"));
//        ImageIcon iconJenisBarang   = new ImageIcon(getClass().getResource("/img/icons8_survey_20px.png"));
        ImageIcon iconSupplier   = new ImageIcon(getClass().getResource("/img/icons8_supplier_20px.png"));
        ImageIcon iconUser      = new ImageIcon(getClass().getResource("/img/icons8_user_20px.png"));
        
        //Source Icon Menu Transaksi
        ImageIcon iconTransaksi     = new ImageIcon(getClass().getResource("/img/icons8_create_order_20px.png"));
        ImageIcon iconPemesanan     = new ImageIcon(getClass().getResource("/img/icons8_delivered_20px.png"));
        ImageIcon iconPembelian     = new ImageIcon(getClass().getResource("/img/icons8_deliver_food_20px.png"));
        ImageIcon iconPenjualan     = new ImageIcon(getClass().getResource("/img/icons8_move_stock_20px.png"));
        
        //Source Icon Menu Report
        ImageIcon iconReport     = new ImageIcon(getClass().getResource("/img/icons8_presentation_20px.png"));
        
        MenuItem menuHome      = new MenuItem(iconHome, false, null, "Home", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCustom1.removeAll();
                panelCustom1.add(new content_bg());
                panelCustom1.repaint();
                panelCustom1.revalidate();
            }
        });
        
        MenuItem menuBarang = new MenuItem(null, true, iconBarang, "Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCustom1.removeAll();
                panelCustom1.add(new Master_Barang());
                panelCustom1.repaint();
                panelCustom1.revalidate();
            }
        });
        
        MenuItem menuSupplier = new MenuItem(null, true, iconSupplier, "Supplier", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCustom1.removeAll();
                panelCustom1.add(new Master_Supplier());
                panelCustom1.repaint();
                panelCustom1.revalidate();
            }
            
        });
        MenuItem menuUser = new MenuItem(null, true, iconUser, "User", new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCustom1.removeAll();
                panelCustom1.add(new Master_User());
                panelCustom1.repaint();
                panelCustom1.revalidate();
            }
            
        });
        
        MenuItem transaksiPemesanan = new MenuItem(null, true, iconBarang, "Pemesanan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCustom1.removeAll();
                String Id = lb_id.getText();
                panelCustom1.add(new Transaksi_Pemesanan(Id));
                panelCustom1.repaint();
                panelCustom1.revalidate();
            }
        });
        
        MenuItem transaksiPembelian = new MenuItem(null, true, iconPembelian, "Pembelian", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCustom1.removeAll();
                String Id = lb_id.getText();
                panelCustom1.add(new Transaksi_Pembelian(Id));
                panelCustom1.repaint();
                panelCustom1.revalidate();
            }
        });
        
        MenuItem transaksiPenjualan = new MenuItem(null, true, iconPenjualan, "Penjualan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCustom1.removeAll();
                String Id = lb_id.getText();
                panelCustom1.add(new Transaksi_Penjualan(Id));
                panelCustom1.repaint();
                panelCustom1.revalidate();
            }
        });
        
        MenuItem laporanBarang = new MenuItem(null, true, iconReport, "Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCustom1.removeAll();
                String Id = lb_id.getText();
                panelCustom1.add(new Laporan_Barang(Id));
                panelCustom1.repaint();
                panelCustom1.revalidate();
            }
        });        
        
        MenuItem menuMaster      = new MenuItem(iconMaster, false, null, "Master", null, menuBarang, menuSupplier, menuUser);
        MenuItem menuTransaksi   = new MenuItem(iconTransaksi, false, null, "Transaksi", null,transaksiPemesanan, transaksiPembelian,transaksiPenjualan);
        MenuItem menuReport      = new MenuItem(iconReport, false, null, "Laporan", null,laporanBarang);
        
        
        
        if(modelLogin.getJabatan().equals("Owner")){
            addMenu(menuHome, menuMaster,menuTransaksi,menuReport);
        }else{
            addMenu(menuHome,menuMaster,menuReport);
        }
        
    }
    
    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            pn_menu.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        pn_menu.revalidate();
    }
    
    public JPanel getPanelCustom1() {
        return panelCustom1;
    } 
}