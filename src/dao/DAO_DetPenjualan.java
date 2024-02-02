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
import model.Model_Penjualan;
import model.Model_DetPenjualan;
import service.Service_DetPenjualan;

public class DAO_DetPenjualan implements Service_DetPenjualan{

    private Connection conn;

    public DAO_DetPenjualan() {
        conn = Koneksi.getConnection();
    }
    
    
    
    @Override
    public void tambahData(Model_DetPenjualan mod_detkeluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_penjualan (id_penjualan, id_barang, jml_penjualan, subtotal_penjualan)SELECT '"+mod_detkeluar.getMod_jual().getId_penjualan()+"', id_barang, jml_penjualan, subtotal_penjualan FROM sementara_penjualan";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void sumTotal(Model_DetPenjualan mod_detkeluar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_penjualan) FROM sementara_penjualan";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mod_detkeluar.setSubtotal_penjualan(rs.getLong(1));
            }
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusSementara(Model_DetPenjualan mod_detkeluar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_penjualan";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }  
    }

    @Override
    public Model_DetPenjualan getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_DetPenjualan> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT det_jual.id_penjualan, det_jual.id_barang, "
                + "brg.nama_barang, brg.harga, det_jual.jml_penjualan, "
                + "det_jual.subtotal_penjualan "
                + "FROM detail_penjualan det_jual "
                + "INNER JOIN penjualan jual ON jual.id_penjualan=det_jual.id_penjualan "
                + "INNER JOIN barang brg ON brg.id_barang=det_jual.id_barang "
                + "WHERE det_jual.id_penjualan='"+id+"' ORDER BY id_penjualan ASC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Penjualan keluar = new Model_Penjualan();
                Model_DetPenjualan det = new Model_DetPenjualan();
                Model_Barang brg = new Model_Barang();
                
                keluar.setId_penjualan(String.valueOf(rs.getString("det_jual.id_penjualan")));
                det.setMod_jual(keluar);
                
                brg.setId_barang      (rs.getString ("id_barang"));
                brg.setNama_barang      (rs.getString ("nama_barang"));
                brg.setHarga            (rs.getLong   ("harga"));
                det.setJml_penjualan       (rs.getInt("jml_penjualan"));
                det.setSubtotal_penjualan  (rs.getLong   ("subtotal_penjualan"));
                                
                det.setMod_barang(brg);
                
                list.add(det);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Model_DetPenjualan> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validasiStok(Model_DetPenjualan mod_detkeluar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT stok FROM barang WHERE id_barang='"+mod_detkeluar.getMod_barang().getId_barang()+"' AND (stok<'"+mod_detkeluar.getJml_penjualan()+"')";
        try{
            st = conn.prepareStatement(sql);
            rs= st.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Stok Barang "+mod_detkeluar.getMod_barang().getNama_barang()+" tidak tersedia !!!","Peringatan",JOptionPane.WARNING_MESSAGE);
            }else {
                valid=true;
            }
        }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (st!=null) {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_DetPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
        return valid;
    }
    
}
