package view;

import dao.DAO_Supplier;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Window;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import model.Model_Supplier;
import tablemodel.TableMod_Supplier;
import javax.swing.border.Border;
import jnafilechooser.api.JnaFileChooser;
import service.Service_Supplier;


public class Master_Supplier extends javax.swing.JPanel {

    private Service_Supplier servis = new DAO_Supplier();
    private TableMod_Supplier tblModel = new TableMod_Supplier();
    
    public Master_Supplier() {
        initComponents();
        
        tbl_data.setModel(tblModel);    
        
        loadData();
        
    }
    
    
    
    
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
        tbl_data = new custom.TableRowColorClick();
        t_cari = new javax.swing.JTextField();
        btn_search = new javax.swing.JLabel();
        tambahData = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_tambah1 = new rojerusan.RSMaterialButtonRectangle();
        btn_batal1 = new rojerusan.RSMaterialButtonRectangle();
        jPanel1 = new javax.swing.JPanel();
        t_IdSupplier = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        t_NamaSupplier = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        t_AlamatSupplier = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_TelpSupplier = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tampilData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel1.setText("Data Supplier");

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

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_data.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

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

        javax.swing.GroupLayout tampilDataLayout = new javax.swing.GroupLayout(tampilData);
        tampilData.setLayout(tampilDataLayout);
        tampilDataLayout.setHorizontalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilDataLayout.createSequentialGroup()
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(tampilDataLayout.createSequentialGroup()
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search))
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        tampilDataLayout.setVerticalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btn_search))
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(tampilData, "card3");

        tambahData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel2.setText("Tambah Data Supplier");

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

        t_IdSupplier.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        t_IdSupplier.setMargin(new java.awt.Insets(2, 10, 2, 6));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel3.setText("ID Supplier");

        t_NamaSupplier.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel4.setText("Nama Supplier");

        t_AlamatSupplier.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel5.setText("Alamat");

        t_TelpSupplier.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        t_TelpSupplier.setMargin(new java.awt.Insets(2, 10, 2, 6));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel6.setText("Telepon");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_IdSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addComponent(t_NamaSupplier)
                    .addComponent(t_TelpSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addComponent(t_AlamatSupplier)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_IdSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_NamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_TelpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_AlamatSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
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
                        .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(tambahDataLayout.createSequentialGroup()
                                .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 625, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tambahDataLayout.setVerticalGroup(
            tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tambahDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tambahDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
        t_IdSupplier.setText(servis.nomor());
        t_IdSupplier.setEnabled(false);

        if(btn_tambah.getText().equals("UBAH"))
        {
            dataTabel();
            //lb_nb.setVisible(false);

        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        hapusData();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        if(btn_tambah.getText().equals("TAMBAH"))
        {
            btn_tambah.setText("UBAH");

        }
        btn_hapus.setVisible(true);
        btn_batal.setVisible(true);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        tampilPanel();
        loadData();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah1ActionPerformed
        if(btn_tambah1.getText().equals("TAMBAH"))
        {
            btn_tambah1.setText("SIMPAN");
            t_IdSupplier.setText(servis.nomor());
            
        }
        else if(btn_tambah1.getText().equals("SIMPAN"))
        {
            simpanData();
            
        }
        else if(btn_tambah1.getText().equals("PERBARUI"))
        {
            perbaruiData();
            
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_batal;
    private rojerusan.RSMaterialButtonRectangle btn_batal1;
    private rojerusan.RSMaterialButtonRectangle btn_hapus;
    private javax.swing.JLabel btn_search;
    private rojerusan.RSMaterialButtonRectangle btn_tambah;
    private rojerusan.RSMaterialButtonRectangle btn_tambah1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField t_AlamatSupplier;
    private javax.swing.JTextField t_IdSupplier;
    private javax.swing.JTextField t_NamaSupplier;
    private javax.swing.JTextField t_TelpSupplier;
    private javax.swing.JTextField t_cari;
    private javax.swing.JPanel tambahData;
    private javax.swing.JPanel tampilData;
    private custom.TableRowColorClick tbl_data;
    // End of variables declaration//GEN-END:variables

    private void dataTabel(){
            tampilData.setVisible(false);
            tambahData.setVisible(true);

            int row = tbl_data.getSelectedRow();
            jLabel2.setText("Perbarui Data Supplier");

            t_IdSupplier.setEnabled(false);
            t_NamaSupplier.setEnabled(true);

            t_IdSupplier.setText   (tbl_data.getModel().getValueAt(row, 0).toString());
            t_NamaSupplier.setText   (tbl_data.getModel().getValueAt(row, 1).toString());
            t_TelpSupplier.setText   (tbl_data.getModel().getValueAt(row, 2).toString());
            t_AlamatSupplier.setText   (tbl_data.getModel().getValueAt(row, 3).toString());

            btn_tambah1.setText("PERBARUI");
            btn_batal.setVisible(true);
        }
    
    private void aktif(){
        t_IdSupplier.setEnabled(true);
        t_NamaSupplier.setEnabled(true);
    }

    private void loadData() {
        btn_hapus.setVisible(false);
        btn_batal.setVisible(false);
        List<Model_Supplier> list = servis.getData();
        tblModel.setData(list);
    }

    private void hapusData() {
        int index = tbl_data.getSelectedRow();
        if (index!=-1) {
            Model_Supplier model = tblModel.getData(tbl_data.convertRowIndexToModel(index));
            if (JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION) {
                servis.hapusData(model);
                tblModel.hapusData(index);
                loadData();
                resetForm();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Pilih dahulu record yang akan diupdate");
        
        }
    }

    private void resetForm() {
        btn_tambah.requestFocus();
        btn_tambah.setText("TAMBAH");
        t_IdSupplier.setText("");
        t_NamaSupplier.setText("");
    }

    private void tampilPanel() {
        mainPanel.removeAll();
        mainPanel.add(new Master_Supplier());
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void simpanData() {
        if(validasiInput()==true){
            String ID = t_IdSupplier.getText();
            String nama_sup = t_NamaSupplier.getText();
            String telp_sup = t_TelpSupplier.getText();
            String alamat_sup = t_AlamatSupplier.getText();


            Model_Supplier model = new Model_Supplier();
            model.setId_supplier(ID);
            model.setNama_supplier(nama_sup);
            model.setTelp_supplier(telp_sup);
            model.setAlamat_supplier(alamat_sup);

            servis.tambahData(model);
            tblModel.tambahData(model);
            tampilPanel();
            loadData();
            resetForm();
            btn_tambah.setText("TAMBAH");
        }    
    }

    private void perbaruiData() {
        int index = tbl_data.getSelectedRow();
        if (index!=-1) {
            Model_Supplier mod_sup = tblModel.getData(tbl_data.convertRowIndexToModel(index));
            
            if(validasiInput()==true){
                String ID = t_IdSupplier.getText();
                String nama_sup = t_NamaSupplier.getText();
                String telp_sup = t_TelpSupplier.getText();
                String alamat_sup = t_AlamatSupplier.getText();

                Model_Supplier model = new Model_Supplier();
                model.setId_supplier(ID);
                model.setNama_supplier(nama_sup);
                model.setTelp_supplier(telp_sup);
                model.setAlamat_supplier(alamat_sup);

                servis.perbaruiData(model);
                tblModel.perbaruiData(index, model);
                loadData();
                resetForm();
                tampilPanel();
            }
        }
    }

    private boolean validasiInput() {
        boolean valid = false;
        if (t_IdSupplier.getText().trim().isEmpty() ){
            JOptionPane.showMessageDialog(null, "ID tidak boleh kosong");
        }else if (t_NamaSupplier.getText().trim().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
        }else if (t_NamaSupplier.getText().trim().isEmpty() ){
            JOptionPane.showMessageDialog(null, "No Telepon tidak boleh kosong");
        }else if (t_NamaSupplier.getText().trim().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Alamat tidak boleh kosong");
        }else{
            valid = true;
        }
        return valid;
    }

    private void pencarian() {
        List<Model_Supplier> list = servis.pencarian(t_cari.getText());
        tblModel.setData(list);
    }
}
