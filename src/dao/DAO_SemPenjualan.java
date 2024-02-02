/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Model_Barang;
import model.Model_DetPenjualan;
import model.Model_SemPenjualan;
import service.Service_SemPenjualan;

/**
 *
 * @author Uhnuy Kozuki
 */
public class DAO_SemPenjualan implements Service_SemPenjualan{

    private Connection conn;
    
    public DAO_SemPenjualan() {
        conn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_SemPenjualan mod_keluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO sementara_penjualan (id_barang, nama_barang, harga, jml_penjualan, subtotal_penjualan) VALUES (?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_keluar.getMod_barang().getId_barang());
            st.setString(2, mod_keluar.getMod_barang().getNama_barang());
            st.setLong  (3, mod_keluar.getMod_barang().getHarga());
            st.setLong  (4, mod_keluar.getMod_detjual().getJml_penjualan());
            st.setLong  (5, mod_keluar.getMod_detjual().getSubtotal_penjualan());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_SemPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_SemPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void perbaruiData(Model_SemPenjualan mod_keluar) {
        PreparedStatement st = null;
        String sql = "UPDATE sementara_penjualan SET nama_barang=?, harga=?, jml_penjualan=?, subtotal_penjualan=? WHERE id_barang='"+mod_keluar.getMod_barang().getId_barang()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_keluar.getMod_barang().getNama_barang());
            st.setLong  (2, mod_keluar.getMod_barang().getHarga());
            st.setLong  (3, mod_keluar.getMod_detjual().getJml_penjualan());
            st.setLong  (4, mod_keluar.getMod_detjual().getSubtotal_penjualan());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(DAO_SemPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_SemPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusData(Model_SemPenjualan mod_keluar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_penjualan WHERE id_barang=? AND nama_barang=? AND harga=? AND jml_penjualan=? AND subtotal_penjualan=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_keluar.getMod_barang().getId_barang());
            st.setString(2, mod_keluar.getMod_barang().getNama_barang());
            st.setLong  (3, mod_keluar.getMod_barang().getHarga());
            st.setLong  (4, mod_keluar.getMod_detjual().getJml_penjualan());
            st.setLong  (5, mod_keluar.getMod_detjual().getSubtotal_penjualan());            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_SemPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Model_SemPenjualan getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_SemPenjualan> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM sementara_penjualan";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_SemPenjualan smt = new Model_SemPenjualan();
                Model_Barang brg = new Model_Barang();
                Model_DetPenjualan det = new Model_DetPenjualan();
                
                brg.setId_barang          (rs.getString ("id_barang"));
                brg.setNama_barang          (rs.getString ("nama_barang"));
                brg.setHarga                (rs.getLong ("harga"));
                
                det.setJml_penjualan           (rs.getInt    ("jml_penjualan"));
                det.setSubtotal_penjualan      (rs.getLong   ("subtotal_penjualan"));
                
                smt.setMod_barang(brg);
                smt.setMod_detjual(det);
                
                list.add(smt);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_SemPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
}
