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
import model.Model_DetPembelian;
import model.Model_SemPembelian;
import service.Service_SemPembelian;

public class DAO_SemPembelian implements Service_SemPembelian{

    private Connection conn;
    
    public DAO_SemPembelian() {
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void tambahData(Model_SemPembelian mod_beli) {
        PreparedStatement st = null;
        String sql = "INSERT INTO sementara_pembelian (id_barang, nama_barang, harga, jml_pembelian, subtotal_pembelian) VALUES (?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_beli.getMod_barang().getId_barang());
            st.setString(2, mod_beli.getMod_barang().getNama_barang());
            st.setLong  (3, mod_beli.getMod_barang().getHarga());
            st.setLong  (4, mod_beli.getMod_detbeli().getJml_pembelian());
            st.setLong  (5, mod_beli.getMod_detbeli().getSubtotal_pembelian());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_SemPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_SemPembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void perbaruiData(Model_SemPembelian mod_beli) {
        PreparedStatement st = null;
        String sql = "UPDATE sementara_pembelian SET nama_barang=?, harga=?, jml_pembelian=?, subtotal_pembelian=? WHERE id_barang='"+mod_beli.getMod_barang().getId_barang()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_beli.getMod_barang().getNama_barang());
            st.setLong  (2, mod_beli.getMod_barang().getHarga());
            st.setLong  (3, mod_beli.getMod_detbeli().getJml_pembelian());
            st.setLong  (4, mod_beli.getMod_detbeli().getSubtotal_pembelian());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(DAO_SemPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_SemPembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusData(Model_SemPembelian mod_beli) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_pembelian WHERE id_barang=? AND nama_barang=? AND harga=? AND jml_pembelian=? AND subtotal_pembelian=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_beli.getMod_barang().getId_barang());
            st.setString(2, mod_beli.getMod_barang().getNama_barang());
            st.setLong(3, mod_beli.getMod_barang().getHarga());
            st.setLong  (4, mod_beli.getMod_detbeli().getJml_pembelian());
            st.setLong  (5, mod_beli.getMod_detbeli().getSubtotal_pembelian());
            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_SemPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemPembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Model_SemPembelian getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_SemPembelian> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM sementara_pembelian";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_SemPembelian smt = new Model_SemPembelian();
                Model_Barang brg = new Model_Barang();
                Model_DetPembelian det_beli = new Model_DetPembelian();
                
                brg.setId_barang          (rs.getString ("id_barang"));
                brg.setNama_barang          (rs.getString ("nama_barang"));
                brg.setHarga                (rs.getLong ("harga"));
                
                det_beli.setJml_pembelian     (rs.getInt    ("jml_pembelian"));
                det_beli.setSubtotal_pembelian (rs.getLong   ("subtotal_pembelian"));
                
                smt.setMod_barang(brg);
                smt.setMod_detbeli(det_beli);
                
                list.add(smt);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_SemPembelian.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemPembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemPembelian.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
}
