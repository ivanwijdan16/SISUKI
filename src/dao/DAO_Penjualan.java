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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_Penjualan;
import model.Model_Supplier;
import model.Model_User;
import service.Service_Penjualan;


public class DAO_Penjualan implements Service_Penjualan{
    
    private Connection conn;
    
    public DAO_Penjualan() {
        conn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_Penjualan mod_keluar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO penjualan (id_penjualan, tgl_penjualan, total_penjualan, id_user) VALUES (?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_keluar.getId_penjualan());
            st.setString(2, mod_keluar.getTgl_penjualan());
            st.setLong  (3, mod_keluar.getTotal_penjualan());
            st.setString(4, mod_keluar.getMod_user().getId_user());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void hapusData(Model_Penjualan mod_keluar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM penjualan WHERE id_penjualan=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_keluar.getId_penjualan());
            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    @Override
    public Model_Penjualan getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_Penjualan> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM penjualan";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Penjualan keluar = new Model_Penjualan();
                Model_User pgn = new Model_User();
                
                keluar.setId_penjualan       (rs.getString ("id_penjualan"));
                keluar.setTgl_penjualan      (rs.getString ("tgl_penjualan"));
                keluar.setTotal_penjualan    (rs.getLong("total_penjualan"));
                pgn.setId_user      (rs.getString("id_user"));
                                
                keluar.setMod_user(pgn);
                list.add(keluar);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Model_Penjualan> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM penjualan WHERE id_penjualan LIKE '%"+id+"%' OR tgl_penjualan LIKE '%"+id+"%' OR total_penjualan LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Penjualan keluar = new Model_Penjualan();
                Model_User pgn = new Model_User();
                
                keluar.setId_penjualan       (rs.getString ("id_penjualan"));
                keluar.setTgl_penjualan      (rs.getString ("tgl_penjualan"));
                keluar.setTotal_penjualan   (rs.getLong("total_penjualan"));
                pgn.setId_user      (rs.getString("id_user"));
                                
                keluar.setMod_user(pgn);
                list.add(keluar);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Penjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;

        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat noformat = new SimpleDateFormat("yyMMdd");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);

        String sql = "SELECT RIGHT(id_penjualan, 3) AS Nomor " +
                     "FROM penjualan " +
                     "WHERE id_penjualan LIKE 'BK" + no + "%' " +
                     "ORDER BY id_penjualan DESC " +
                     "LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "BK" + no + String.format("%03d", nomor);
            } else {
                urutan = "BK" + no + "001";
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return urutan;
    
    }

    
    
}
