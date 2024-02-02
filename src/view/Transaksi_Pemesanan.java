
package view;

import config.Koneksi;
import static config.Koneksi.getConnection;
import dao.DAO_DetPemesanan;
import dao.DAO_Laporan;
import dao.DAO_Pemesanan;
import dao.DAO_SemPemesanan;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import model.Model_Barang;
import model.Model_DetPemesanan;
import model.Model_Supplier;
import model.Model_Pemesanan;
import model.Model_User;
import model.Model_SemPemesanan;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import service.Service_DetPemesanan;
import service.Service_Laporan;
import service.Service_Pemesanan;
import service.Service_SemPemesanan;
import tablemodel.TableMod_DetPemesanan;
import tablemodel.TableMod_Pemesanan;
import tablemodel.TableMod_SemPemesanan;


public class Transaksi_Pemesanan extends javax.swing.JPanel {

    private Service_Pemesanan servis_psn = new DAO_Pemesanan();
    private Service_DetPemesanan servis_det = new DAO_DetPemesanan();
    private Service_SemPemesanan servis_sem = new DAO_SemPemesanan();
    
    private TableMod_Pemesanan tblModel_psn = new TableMod_Pemesanan();
    private TableMod_DetPemesanan tblModel_det = new TableMod_DetPemesanan();
    private TableMod_SemPemesanan tblModel_sem = new TableMod_SemPemesanan();
    
    private Service_Laporan servis_lap = new DAO_Laporan();
    
    //private final int noColumnIndex = 0;
    //private final int noColumnWidth = 50;
  
    public Transaksi_Pemesanan(String Id) {
        initComponents();
        lb_id.setText(Id);
        tbl_barang.setModel(tblModel_psn);       
        tbl_detail.setModel(tblModel_det);
        tbl_sementara.setModel(tblModel_sem);
        //setColumnWidth();
        loadData();
        loadDataSementara();
        pn_detail.setVisible(false);
        lb_id.setVisible(false);
        
    }
    
//    private void setColumnWidth() {
//        TableColumnModel columnModel = tbl_barang.getColumnModel();
//        columnModel.getColumn(noColumnIndex).setPreferredWidth(noColumnWidth);
//        columnModel.getColumn(noColumnIndex).setMaxWidth(noColumnWidth);
//        columnModel.getColumn(noColumnIndex).setMinWidth(noColumnWidth);
//    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tampilData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_tambah = new rojerusan.RSMaterialButtonRectangle();
        btn_hapus = new rojerusan.RSMaterialButtonRectangle();
        btn_batal = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_barang = new custom.TableRowColorClick();
        t_cari = new javax.swing.JTextField();
        btn_search = new javax.swing.JLabel();
        pn_detail = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_detail = new custom.TableRowColorClick();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        btn_print = new rojerusan.RSMaterialButtonRectangle();
        tambahData = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_tambah1 = new rojerusan.RSMaterialButtonRectangle();
        btn_batal1 = new rojerusan.RSMaterialButtonRectangle();
        jPanel1 = new javax.swing.JPanel();
        pn_pemesanan = new javax.swing.JPanel();
        t_noPesan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        t_tanggalPesan = new javax.swing.JTextField();
        pn_distributor = new javax.swing.JPanel();
        t_idDistributor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        t_namaDistributor = new javax.swing.JTextField();
        btn_distributor = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pn_barang = new javax.swing.JPanel();
        t_kodeBarang = new javax.swing.JTextField();
        btn_barang = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        t_namaBarang = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        t_harga = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        t_jumlah = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        t_subtotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btn_tambahSementara = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sementara = new custom.TableRowColorClick();
        btn_hapusSementara = new custom.ButtonRounded();
        buttonRounded2 = new custom.ButtonRounded();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tampilData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel1.setText("Data Pemesanan Barang");

        btn_tambah.setText("TAMBAH");
        btn_tambah.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(java.awt.Color.red);
        btn_hapus.setText("HAPUS");
        btn_hapus.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_batal.setBackground(java.awt.Color.orange);
        btn_batal.setText("BATAL");
        btn_batal.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        tbl_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_barang.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_barang);

        t_cari.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        t_cari.setText("     Pencarian");
        t_cari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        t_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cariMouseClicked(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cariKeyTyped(evt);
            }
        });

        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_folder_50px_1.png"))); // NOI18N

        tbl_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_detail.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tbl_detail);

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel10.setText("Data Pemesanan Barang");

        jLabel11.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("X");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_detailLayout = new javax.swing.GroupLayout(pn_detail);
        pn_detail.setLayout(pn_detailLayout);
        pn_detailLayout.setHorizontalGroup(
            pn_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_detailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(pn_detailLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pn_detailLayout.setVerticalGroup(
            pn_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_detailLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_detailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lb_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_id.setText("ID");

        btn_print.setBackground(new java.awt.Color(0, 153, 153));
        btn_print.setText("PRINT");
        btn_print.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tampilDataLayout = new javax.swing.GroupLayout(tampilData);
        tampilData.setLayout(tampilDataLayout);
        tampilDataLayout.setHorizontalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilDataLayout.createSequentialGroup()
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tampilDataLayout.createSequentialGroup()
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_search))
                            .addGroup(tampilDataLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(pn_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        tampilDataLayout.setVerticalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btn_search))
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pn_detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(tampilData, "card3");

        tambahData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel2.setText("Tambah Pemesanan Barang");

        btn_tambah1.setText("TAMBAH");
        btn_tambah1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah1ActionPerformed(evt);
            }
        });

        btn_batal1.setBackground(java.awt.Color.orange);
        btn_batal1.setText("BATAL");
        btn_batal1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_batal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pn_pemesanan.setBackground(new java.awt.Color(51, 0, 102));

        t_noPesan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Pemesanan");

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tanggal");

        t_tanggalPesan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout pn_pemesananLayout = new javax.swing.GroupLayout(pn_pemesanan);
        pn_pemesanan.setLayout(pn_pemesananLayout);
        pn_pemesananLayout.setHorizontalGroup(
            pn_pemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_pemesananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_pemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_pemesananLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addComponent(t_noPesan))
                .addGap(18, 18, 18)
                .addGroup(pn_pemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(t_tanggalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pn_pemesananLayout.setVerticalGroup(
            pn_pemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_pemesananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_pemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_pemesananLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_tanggalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_pemesananLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_noPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_distributor.setBackground(new java.awt.Color(255, 255, 255));
        pn_distributor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 102)));

        t_idDistributor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel13.setText("Nama Supplier");

        t_namaDistributor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_distributor.setText("...");
        btn_distributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_distributorActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(51, 0, 102));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Supplier");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel5.setText("ID Supplier");

        javax.swing.GroupLayout pn_distributorLayout = new javax.swing.GroupLayout(pn_distributor);
        pn_distributor.setLayout(pn_distributorLayout);
        pn_distributorLayout.setHorizontalGroup(
            pn_distributorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_distributorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_distributorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_distributorLayout.createSequentialGroup()
                        .addComponent(t_idDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_distributor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(pn_distributorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_distributorLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(t_namaDistributor))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_distributorLayout.setVerticalGroup(
            pn_distributorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_distributorLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pn_distributorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_distributorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_namaDistributor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_distributorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_distributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(t_idDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pn_barang.setBackground(new java.awt.Color(255, 255, 255));
        pn_barang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 102)));

        t_kodeBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_barang.setText("...");
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(51, 0, 102));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Barang");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel8.setText("ID Barang");

        t_namaBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel16.setText("Nama Barang");

        t_harga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel18.setText("Harga");

        t_jumlah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        t_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_jumlahKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel19.setText("Jumlah");

        t_subtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel20.setText("Subtotal");

        btn_tambahSementara.setText("Tambah Barang");
        btn_tambahSementara.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_tambahSementara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahSementaraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_barangLayout = new javax.swing.GroupLayout(pn_barang);
        pn_barang.setLayout(pn_barangLayout);
        pn_barangLayout.setHorizontalGroup(
            pn_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_barangLayout.createSequentialGroup()
                .addGroup(pn_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_barangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_barangLayout.createSequentialGroup()
                                .addComponent(t_kodeBarang)
                                .addGap(18, 18, 18)
                                .addComponent(btn_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(t_namaBarang)
                            .addGroup(pn_barangLayout.createSequentialGroup()
                                .addGroup(pn_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel16))
                                .addGap(0, 265, Short.MAX_VALUE))))
                    .addGroup(pn_barangLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btn_tambahSementara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_barangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_harga)
                            .addComponent(t_jumlah)
                            .addComponent(t_subtotal)
                            .addGroup(pn_barangLayout.createSequentialGroup()
                                .addGroup(pn_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addGap(0, 309, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pn_barangLayout.setVerticalGroup(
            pn_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_barangLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btn_tambahSementara, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_sementara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_sementara.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_sementara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sementaraMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_sementara);

        btn_hapusSementara.setText("HAPUS");
        btn_hapusSementara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusSementaraActionPerformed(evt);
            }
        });

        buttonRounded2.setText("PERBARUI");
        buttonRounded2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRounded2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pn_pemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_distributor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_barang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonRounded2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(140, 140, 140)
                        .addComponent(btn_hapusSementara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapusSementara, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pn_pemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_distributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel15.setText("Total Pemesanan");

        lb_total.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lb_total.setText("Total Pemesanan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                .addComponent(lb_total)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lb_total))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tambahDataLayout = new javax.swing.GroupLayout(tambahData);
        tambahData.setLayout(tambahDataLayout);
        tambahDataLayout.setHorizontalGroup(
            tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tambahDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tambahDataLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tambahDataLayout.createSequentialGroup()
                        .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        tambahDataLayout.setVerticalGroup(
            tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tambahDataLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tambahDataLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(tambahData, "card3");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(tambahData);
        mainPanel.repaint();
        mainPanel.revalidate();

        btn_tambah1.setText("SIMPAN");
        t_noPesan.setEnabled(false);
        t_tanggalPesan.setEnabled(false);
        
        t_noPesan.setText(servis_psn.nomor());
        
        Model_DetPemesanan det_psn = new Model_DetPemesanan();
        servis_det.sumTotal(det_psn);
        lb_total.setText(det_psn.getSubtotal().toString());
        setTanggal();
        
        
        if(btn_tambah.getText().equals("UBAH"))
        {
            dataTabel();
            //lb_nb.setVisible(false);

        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        hapusData();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tbl_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_barangMouseClicked
        int row = tbl_barang.getSelectedRow();
        String id = tbl_barang.getValueAt(row, 0).toString();
        btn_hapus.setVisible(true);
        btn_batal.setVisible(true);
        btn_print.setVisible(true);
        
        pn_detail.setVisible(true);
        List<Model_DetPemesanan> list = servis_det.getData(id);
        tblModel_det.setData(list);
    }//GEN-LAST:event_tbl_barangMouseClicked

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        tampilPanel();
        loadData();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah1ActionPerformed
        if(btn_tambah1.getText().equals("TAMBAH"))
        {
            btn_tambah1.setText("SIMPAN");
            //t_kodeBarang.setText(servis.nomor());
            
        }
        else if(btn_tambah1.getText().equals("SIMPAN"))
        {
            simpanData();
            String no = t_noPesan.getText();
            //servis_lap.suratJalanPemesanan(no);
        }
    }//GEN-LAST:event_btn_tambah1ActionPerformed

    private void btn_batal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal1ActionPerformed
        tampilPanel();
        loadData();
        resetForm();
    }//GEN-LAST:event_btn_batal1ActionPerformed

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
        pencarian();
    }//GEN-LAST:event_t_cariKeyTyped

    private void t_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cariMouseClicked
        t_cari.setText("");
    }//GEN-LAST:event_t_cariMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        tampilPanel();
        pn_detail.setVisible(false);
        loadData();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void tbl_sementaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sementaraMouseClicked
        int row = tbl_sementara.getSelectedRow();
        
        t_kodeBarang.setEnabled(false);
        t_namaBarang.setEnabled(false);
        t_harga.setEnabled(false);
        t_subtotal.setEnabled(false);
        
        t_kodeBarang.setText(tbl_sementara.getModel().getValueAt(row, 0).toString());
        t_namaBarang.setText(tbl_sementara.getModel().getValueAt(row, 1).toString());
        //t_satuan.setText(tbl_sementara.getModel().getValueAt(row, 2).toString());
        t_harga.setText(tbl_sementara.getModel().getValueAt(row, 2).toString());
        t_jumlah.setText(tbl_sementara.getModel().getValueAt(row, 3).toString());
        t_subtotal.setText(tbl_sementara.getModel().getValueAt(row, 4).toString());
        
        t_jumlah.setEnabled(true);
        btn_tambahSementara.setVisible(false);
        btn_hapusSementara.setVisible(true);
        
    }//GEN-LAST:event_tbl_sementaraMouseClicked

    private void btn_distributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_distributorActionPerformed
        boolean closable = true;
        Data_Supplier model_dis = new Data_Supplier(null, closable);
        model_dis.setVisible(true);

        t_idDistributor.setText     (model_dis.model.getId_supplier());
        t_namaDistributor.setText   (model_dis.model.getNama_supplier());

        btn_barang.requestFocus();
        t_idDistributor.setEnabled(false);
        t_namaDistributor.setEnabled(false);
    }//GEN-LAST:event_btn_distributorActionPerformed

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        boolean closable = true;
        Data_Barang model_bar = new Data_Barang(null, closable);
        model_bar.setVisible(true);

        t_kodeBarang.setText    (model_bar.model.getId_barang());
        t_namaBarang.setText    (model_bar.model.getNama_barang());
        t_harga.setText         (model_bar.model.getHarga().toString());

        t_jumlah.requestFocus();
        t_kodeBarang.setEnabled(false);
        t_namaBarang.setEnabled(false);
        t_harga.setEnabled(false);
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_tambahSementaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahSementaraActionPerformed
        String kode = t_kodeBarang.getText();
        String nama = t_namaBarang.getText();
        Long harga   = Long.parseLong(t_harga.getText());
        Long jumlah  = Long.parseLong(t_jumlah.getText());
        Long subtotal = Long.parseLong(t_subtotal.getText());
        String status = "Sedang di pesan";
        
        Model_Barang brg = new Model_Barang();
        Model_DetPemesanan det_psn = new Model_DetPemesanan();
        Model_Pemesanan psn = new Model_Pemesanan();
        Model_SemPemesanan smt = new Model_SemPemesanan();
        
        brg.setNama_barang(nama);
        brg.setHarga(harga);
        
        det_psn.setJml_pesan(jumlah);
        det_psn.setSubtotal(subtotal);
        det_psn.setStatus(status);
        //psn.setTotal_pesan(tobar);
        
        smt.setMod_barang(brg);
        smt.setMod_detpesan(det_psn);
        
        
        servis_sem.tambahData(smt);
        servis_det.sumTotal(det_psn);
        lb_total.setText(det_psn.getSubtotal().toString());
        
        loadDataSementara();
        
        if(JOptionPane.showConfirmDialog(this, "Mau Tambah Barang?",
                "Konfirmasi",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            aktifBarang();
            bersihBarang();
            btn_barang.requestFocus();
            
        }else{
            aktifBarang();
            bersihBarang();
        }
    }//GEN-LAST:event_btn_tambahSementaraActionPerformed

    private void buttonRounded2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRounded2ActionPerformed
        perbaruiDataSementara();
    }//GEN-LAST:event_buttonRounded2ActionPerformed

    private void t_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_jumlahKeyReleased
        Long harga, subtotal;
        int jumlah;
        
        harga   = Long.parseLong(t_harga.getText());
        String inputJumlah = t_jumlah.getText();
        if (inputJumlah.isEmpty()) {
            jumlah = 0;
        } else {
            jumlah = Integer.parseInt(inputJumlah);
        }
        
        
        subtotal = harga * jumlah;
        t_subtotal.setText(Long.toString(subtotal));
        btn_tambahSementara.requestFocus();
        t_subtotal.setEnabled(false);
    }//GEN-LAST:event_t_jumlahKeyReleased

    private void btn_hapusSementaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusSementaraActionPerformed
        int index = tbl_sementara.getSelectedRow();
        if (index!=-1) {
            Model_SemPemesanan model = tblModel_sem.getData(tbl_sementara.convertRowIndexToModel(index));
            if (JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION) {
                servis_sem.hapusData(model);
                tblModel_sem.hapusData(index);
                loadDataSementara();
                resetForm();
                bersihBarang();
                btn_tambahSementara.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Pilih dahulu record yang akan diupdate");
            
        }
        loadDataSementara();
        resetForm();
        bersihBarang();
        btn_tambahSementara.setVisible(true);
    }//GEN-LAST:event_btn_hapusSementaraActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        int row = tbl_barang.getSelectedRow();
        String no = tbl_barang.getModel().getValueAt(row, 0).toString();
//        servis_lap.suratJalanPemesanan(no);

        
    }//GEN-LAST:event_btn_printActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_barang;
    private rojerusan.RSMaterialButtonRectangle btn_batal;
    private rojerusan.RSMaterialButtonRectangle btn_batal1;
    private javax.swing.JButton btn_distributor;
    private rojerusan.RSMaterialButtonRectangle btn_hapus;
    private custom.ButtonRounded btn_hapusSementara;
    private rojerusan.RSMaterialButtonRectangle btn_print;
    private javax.swing.JLabel btn_search;
    private rojerusan.RSMaterialButtonRectangle btn_tambah;
    private rojerusan.RSMaterialButtonRectangle btn_tambah1;
    private rojerusan.RSMaterialButtonRectangle btn_tambahSementara;
    private custom.ButtonRounded buttonRounded2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_total;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pn_barang;
    private javax.swing.JPanel pn_detail;
    private javax.swing.JPanel pn_distributor;
    private javax.swing.JPanel pn_pemesanan;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_harga;
    private javax.swing.JTextField t_idDistributor;
    private javax.swing.JTextField t_jumlah;
    private javax.swing.JTextField t_kodeBarang;
    private javax.swing.JTextField t_namaBarang;
    private javax.swing.JTextField t_namaDistributor;
    private javax.swing.JTextField t_noPesan;
    private javax.swing.JTextField t_subtotal;
    private javax.swing.JTextField t_tanggalPesan;
    private javax.swing.JPanel tambahData;
    private javax.swing.JPanel tampilData;
    private custom.TableRowColorClick tbl_barang;
    private custom.TableRowColorClick tbl_detail;
    private custom.TableRowColorClick tbl_sementara;
    // End of variables declaration//GEN-END:variables

    private void dataTabel(){
            tampilData.setVisible(false);
            tambahData.setVisible(true);

            int row = tbl_barang.getSelectedRow();
            jLabel2.setText("Perbarui Data Barang");

            t_noPesan.setEnabled(false);
            t_tanggalPesan.setEnabled(false);

//            t_noPesan.setText        (tbl_barang.getModel().getValueAt(row, 1).toString());
//            t_kodeJenisBarang.setText       (tbl_barang.getModel().getValueAt(row, 2).toString());
//            t_namaJenisBarang.setText   (tbl_barang.getModel().getValueAt(row, 3).toString());
//            t_namaBarang.setText        (tbl_barang.getModel().getValueAt(row, 4).toString());
//            cbx_satuan.setSelectedItem  (tbl_barang.getModel().getValueAt(row, 5).toString());
//            t_harga.setText             (tbl_barang.getModel().getValueAt(row, 6).toString());
//            t_stok.setText              (tbl_barang.getModel().getValueAt(row, 7).toString());

            //aktif();
            btn_tambah1.setText("PERBARUI");
            btn_batal.setVisible(true);
        }
    
    
    private void loadData() {
        btn_hapus.setVisible(false);
        btn_batal.setVisible(false);
        btn_print.setVisible(false);
        List<Model_Pemesanan> list = servis_psn.getData();
        tblModel_psn.setData(list);
    }

    private void loadDataSementara() {
        List<Model_SemPemesanan> list = servis_sem.getData();
        tblModel_sem.setData(list);
    }
    
    private void hapusData() {
        int index = tbl_barang.getSelectedRow();
        if (index!=-1) {
            Model_Pemesanan brg = tblModel_psn.getData(tbl_barang.convertRowIndexToModel(index));
            if (JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION) {
                servis_psn.hapusData(brg);
                tblModel_psn.hapusData(index);
                loadData();
                resetForm();
                pn_detail.setVisible(false);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Pilih dahulu record yang akan diupdate");
        
        }
    }

    private void resetForm() {
        t_kodeBarang.setEnabled(true);
        t_namaBarang.setEnabled(true);
        t_harga.setEnabled(true);
        t_jumlah.setEnabled(true);
        t_subtotal.setEnabled(true);
    }
    
    private void aktifBarang() {
        t_kodeBarang.setEnabled(true);
        t_namaBarang.setEnabled(true);
        t_harga.setEnabled(true);
        t_jumlah.setEnabled(true);
        t_subtotal.setEnabled(true);
    }
    
    private void bersihBarang() {
        t_kodeBarang.setText("");
        t_namaBarang.setText("");
        t_harga.setText("");
        t_jumlah.setText("");
        t_subtotal.setText("");
    }
    
    private void setTanggal() {
        java.util.Date sekarang = new java.util.Date();
        java.text.SimpleDateFormat kal = new java.text.SimpleDateFormat("yyyy-MM-dd");
        t_tanggalPesan.setText(kal.format(sekarang));
    }

    

    private void tampilPanel() {
        mainPanel.removeAll();
        String Id = lb_id.getText();
        mainPanel.add(new Transaksi_Pemesanan(Id));
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void simpanData() {
        
            String no_pesan   = t_noPesan.getText();
            String tgl_pesan   = t_tanggalPesan.getText();
            String kode = t_kodeBarang.getText();
            String nama = t_namaBarang.getText();
            String id_dis   = t_idDistributor.getText();
            String id_peng   = lb_id.getText();
            String status = "Sedang di pesan";
            Long total = Long.parseLong(lb_total.getText());
            
            Model_User pgn =  new Model_User();
            Model_Supplier dis = new Model_Supplier();
            Model_Barang brg = new Model_Barang();
            Model_Pemesanan psn = new Model_Pemesanan();
            Model_DetPemesanan det = new Model_DetPemesanan();

            //Simpan Tabel Pemesanan
            psn.setId_pesan(no_pesan);
            psn.setTgl_pesan(tgl_pesan);
            psn.setTotal_pesan(total);
            dis.setId_supplier(id_dis);
            pgn.setId_user(id_peng);
            
            psn.setMod_supplier(dis);
            psn.setMod_user(pgn);
            
            //Simpan Tabel Detail Pemesanan
            det.setMod_pesan(psn);
            det.setMod_barang(brg);
            det.setStatus(status);

            servis_psn.tambahData(psn);
            servis_det.tambahData(det);
            servis_det.hapusSementara(det);
            tblModel_psn.tambahData(psn);
            tampilPanel();
            loadData();
            resetForm();
            
        
    }

    private void perbaruiDataSementara() {
        int index = tbl_sementara.getSelectedRow();
        if (index!=-1) {
            Model_SemPemesanan model = tblModel_sem.getData(tbl_sementara.convertRowIndexToModel(index));
             
            
                String kode = t_kodeBarang.getText();
                String nama = t_namaBarang.getText();
                Long harga   = Long.parseLong(t_harga.getText());
                Long jumlah  = Long.parseLong(t_jumlah.getText());
                Long subtotal = Long.parseLong(t_subtotal.getText());
                
                Model_Barang brg = new Model_Barang();
                Model_DetPemesanan det = new Model_DetPemesanan();
                Model_SemPemesanan sem = new Model_SemPemesanan();

                brg.setId_barang(kode);
                brg.setNama_barang(nama);
                brg.setHarga(harga);
                det.setJml_pesan(jumlah);
                det.setSubtotal(subtotal);

                sem.setMod_barang(brg);
                sem.setMod_detpesan(det);

                servis_sem.perbaruiData(sem);
                tblModel_sem.perbaruiData(index, sem);
                servis_det.sumTotal(det);
                lb_total.setText(det.getSubtotal().toString());
                loadDataSementara();
                bersihBarang();
                resetForm();
                
        }
    }


    private void pencarian() {
        List<Model_Pemesanan> list = servis_psn.pencarian(t_cari.getText());
        tblModel_psn.setData(list);
    }
    
}
