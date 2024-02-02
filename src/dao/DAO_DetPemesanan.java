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
import model.Model_DetPemesanan;
import model.Model_Pemesanan;
import service.Service_DetPemesanan;

public class DAO_DetPemesanan implements Service_DetPemesanan{

    private Connection conn;

    public DAO_DetPemesanan() {
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void tambahData(Model_DetPemesanan mod_detpesan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_pemesanan (id_pesan, id_barang, jml_pesan, subtotal_pesan, status)SELECT '"+mod_detpesan.getMod_pesan().getId_pesan()+"', id_barang, jml_pesan, subtotal_pesan, status FROM sementara_pesan";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_DetPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_DetPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void sumTotal(Model_DetPemesanan mod_detpesan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT SUM(subtotal_pesan) FROM sementara_pesan";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                mod_detpesan.setSubtotal(rs.getLong(1));
            }
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_DetPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusSementara(Model_DetPemesanan mod_detpesan) {
        PreparedStatement st = null;
        String sql = "DELETE FROM sementara_pesan";
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_SemPemesanan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_SemPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Model_DetPemesanan getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_DetPemesanan> getData(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT det_psn.id_pesan, det_psn.id_barang, brg.nama_barang, "
                + "brg.harga, det_psn.jml_pesan, det_psn.subtotal_pesan, det_psn.status "
                + "FROM detail_pemesanan det_psn "
                + "INNER JOIN pemesanan psn ON psn.id_pesan=det_psn.id_pesan "
                + "INNER JOIN barang brg ON brg.id_barang=det_psn.id_barang "
                + "WHERE det_psn.id_pesan='"+id+"' ORDER BY id_pesan ASC";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Pemesanan psn = new Model_Pemesanan();
                Model_DetPemesanan det_psn = new Model_DetPemesanan();
                Model_Barang brg = new Model_Barang();
                
                psn.setId_pesan(String.valueOf(rs.getString("det_psn.id_pesan")));
                det_psn.setMod_pesan(psn);
                
                brg.setId_barang      (rs.getString ("id_barang"));
                brg.setNama_barang      (rs.getString ("nama_barang"));
                brg.setHarga            (rs.getLong   ("harga"));
                det_psn.setJml_pesan    (rs.getLong   ("jml_pesan"));
                det_psn.setSubtotal     (rs.getLong   ("subtotal_pesan"));
                det_psn.setStatus       (rs.getString ("status"));
                                
                det_psn.setMod_barang(brg);
                
                list.add(det_psn);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_DetPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_DetPemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Model_DetPemesanan> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
