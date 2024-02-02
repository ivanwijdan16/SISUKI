
package view;

import dao.DAO_Laporan;
import service.Service_Laporan;




public class Laporan_Barang extends javax.swing.JPanel {

    
    
    private Service_Laporan servis_lap = new DAO_Laporan();
    
    
    //private final int noColumnIndex = 0;
    //private final int noColumnWidth = 50;
    
    
    public Laporan_Barang(String Id) {
        initComponents();
        lb_id.setText(Id);
        
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tampilData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pn_pilihLaporan = new javax.swing.JPanel();
        cbx_laporan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_batal = new rojerusan.RSMaterialButtonRectangle();
        pn_main = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pn_dataBarang = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_printDataBarang = new rojerusan.RSMaterialButtonRectangle();
        pn_transaksiBarang = new javax.swing.JPanel();
        btn_printTransaksiBarang = new rojerusan.RSMaterialButtonRectangle();
        jLabel6 = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        pn_tampilLaporan = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tampilData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel1.setText("Laporan Barang");

        pn_pilihLaporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbx_laporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Jenis Laporan --", "Laporan Data Barang", "Laporan Transaksi Barang" }));
        cbx_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_laporanActionPerformed(evt);
            }
        });
        pn_pilihLaporan.add(cbx_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 51, 274, 40));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("Pilih Jenis Laporan");
        pn_pilihLaporan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 14, -1, -1));

        btn_batal.setBackground(java.awt.Color.orange);
        btn_batal.setText("KEMBALI");
        btn_batal.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        pn_pilihLaporan.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 274, 40));

        pn_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MAIN");

        javax.swing.GroupLayout pn_mainLayout = new javax.swing.GroupLayout(pn_main);
        pn_main.setLayout(pn_mainLayout);
        pn_mainLayout.setHorizontalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_mainLayout.setVerticalGroup(
            pn_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_mainLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pn_pilihLaporan.add(pn_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 109, 274, 160));

        pn_dataBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Laporan Data Barang");

        btn_printDataBarang.setBackground(new java.awt.Color(0, 153, 153));
        btn_printDataBarang.setText("PRINT");
        btn_printDataBarang.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_printDataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printDataBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_dataBarangLayout = new javax.swing.GroupLayout(pn_dataBarang);
        pn_dataBarang.setLayout(pn_dataBarangLayout);
        pn_dataBarangLayout.setHorizontalGroup(
            pn_dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dataBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_dataBarangLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btn_printDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_dataBarangLayout.setVerticalGroup(
            pn_dataBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_dataBarangLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(btn_printDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pn_pilihLaporan.add(pn_dataBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 109, 274, 160));

        pn_transaksiBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_printTransaksiBarang.setBackground(new java.awt.Color(0, 153, 153));
        btn_printTransaksiBarang.setText("PRINT");
        btn_printTransaksiBarang.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btn_printTransaksiBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printTransaksiBarangActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Laporan Transaksi Barang");

        javax.swing.GroupLayout pn_transaksiBarangLayout = new javax.swing.GroupLayout(pn_transaksiBarang);
        pn_transaksiBarang.setLayout(pn_transaksiBarangLayout);
        pn_transaksiBarangLayout.setHorizontalGroup(
            pn_transaksiBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_transaksiBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_transaksiBarangLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btn_printTransaksiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_transaksiBarangLayout.setVerticalGroup(
            pn_transaksiBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_transaksiBarangLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(btn_printTransaksiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pn_pilihLaporan.add(pn_transaksiBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 109, 274, 160));

        lb_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_id.setText("ID");

        javax.swing.GroupLayout pn_tampilLaporanLayout = new javax.swing.GroupLayout(pn_tampilLaporan);
        pn_tampilLaporan.setLayout(pn_tampilLaporanLayout);
        pn_tampilLaporanLayout.setHorizontalGroup(
            pn_tampilLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        pn_tampilLaporanLayout.setVerticalGroup(
            pn_tampilLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout tampilDataLayout = new javax.swing.GroupLayout(tampilData);
        tampilData.setLayout(tampilDataLayout);
        tampilDataLayout.setHorizontalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addComponent(pn_pilihLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pn_tampilLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tampilDataLayout.setVerticalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_tampilLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_pilihLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPanel.add(tampilData, "card3");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        mainPanel.removeAll();
        String Id = lb_id.getText();
        mainPanel.add(new Laporan_Barang(Id));
        mainPanel.repaint();
        mainPanel.revalidate();
        
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_printDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printDataBarangActionPerformed
        pn_tampilLaporan.removeAll();
        servis_lap.lapDataBarang(pn_tampilLaporan);
    }//GEN-LAST:event_btn_printDataBarangActionPerformed

    private void cbx_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_laporanActionPerformed
        if(cbx_laporan.getSelectedItem()=="-- Pilih Jenis Laporan --"){
            pn_main.setVisible(true);
            pn_dataBarang.setVisible(false);
            pn_transaksiBarang.setVisible(false);
        }else if(cbx_laporan.getSelectedItem()=="Laporan Data Barang"){
            pn_main.setVisible(false);
            pn_dataBarang.setVisible(true);
            pn_transaksiBarang.setVisible(false);
        }else if(cbx_laporan.getSelectedItem()=="Laporan Transaksi Barang"){
            pn_main.setVisible(false);
            pn_dataBarang.setVisible(false);
            pn_transaksiBarang.setVisible(true);
        }
    }//GEN-LAST:event_cbx_laporanActionPerformed

    private void btn_printTransaksiBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printTransaksiBarangActionPerformed
        pn_tampilLaporan.removeAll();
        servis_lap.lapTransaksiBarang(pn_tampilLaporan);
    }//GEN-LAST:event_btn_printTransaksiBarangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_batal;
    private rojerusan.RSMaterialButtonRectangle btn_printDataBarang;
    private rojerusan.RSMaterialButtonRectangle btn_printTransaksiBarang;
    private javax.swing.JComboBox<String> cbx_laporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lb_id;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pn_dataBarang;
    private javax.swing.JPanel pn_main;
    private javax.swing.JPanel pn_pilihLaporan;
    private javax.swing.JPanel pn_tampilLaporan;
    private javax.swing.JPanel pn_transaksiBarang;
    private javax.swing.JPanel tampilData;
    // End of variables declaration//GEN-END:variables

    
    
}
