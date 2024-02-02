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
import model.Model_Barang;
import model.Model_Pembelian;
import model.Model_DetPembelian;
import service.Service_Pembelian;
import service.Service_DetPembelian;

public class DAO_DetPembelian implements Service_DetPembelian{

    private Connection conn;

    public DAO_DetPembelian() {
        conn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_DetPembelian mod_detmasuk) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_pembelian (id_pembelian, id_barang, jml_pembelian, subtotal_pembelian)SELECT '"+mod_detmasuk.getMod_beli().getId_pembelian()+"', id_barang, jml_pembelian, subtotal_pembelian FROM sementara_pembelian";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_DetPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_DetPembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void sumTotal(Model_DetPembelian mod_detmasuk) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_pembelian) FROM sementara_pembelian";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mod_detmasuk.setSubtotal_pembelian(rs.getLong(1));
            }
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_DetPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusSementara(Model_DetPembelian mod_detmasuk) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_pembelian";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_DetPembelian.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Model_DetPembelian getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_DetPembelian> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT det_beli.id_pembelian, det_masuk.id_barang, "
                + "brg.nama_barang, brg.harga, det_beli.jml_pembelian, "
                + "det_beli.subtotal_pembelian "
                + "FROM detail_pembelian det_beli "
                + "INNER JOIN pembelian beli ON beli.id_pembelian=det_beli.id_pembelian "
                + "INNER JOIN barang brg ON brg.id_barang=det_beli.id_barang "
                + "WHERE det_beli.id_pembelian='"+id+"' ORDER BY id_pembelian ASC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Pembelian masuk = new Model_Pembelian();
                Model_DetPembelian det_masuk = new Model_DetPembelian();
                Model_Barang brg = new Model_Barang();
                
                masuk.setId_pembelian(String.valueOf(rs.getString("det_beli.id_pembelian")));
                det_masuk.setMod_beli(masuk);
                
                brg.setId_barang      (rs.getString ("id_barang"));
                brg.setNama_barang      (rs.getString ("nama_barang"));
                brg.setHarga            (rs.getLong   ("harga"));
                det_masuk.setJml_pembelian  (rs.getInt("jml_pembelian"));
                det_masuk.setSubtotal_pembelian(rs.getLong   ("subtotal_pembelian"));
                                
                det_masuk.setMod_barang(brg);
                
                list.add(det_masuk);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_DetPembelian.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPembelian.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
}
