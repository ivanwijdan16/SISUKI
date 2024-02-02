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
import javax.swing.JOptionPane;
import model.Model_Pembelian;
import model.Model_Supplier;
import model.Model_Pemesanan;
import model.Model_User;
import service.Service_Pembelian;


public class DAO_Pembelian implements Service_Pembelian{

    private Connection conn;
    
    public DAO_Pembelian() {
        conn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_Pembelian mod_masuk) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pembelian (id_pembelian, tgl_pembelian, total_pembelian, id_supplier, id_user) VALUES (?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_masuk.getId_pembelian());
            st.setString(2, mod_masuk.getTgl_pembelian());
            st.setLong  (3, mod_masuk.getTotal_pembelian());
            st.setString(4, mod_masuk.getMod_supplier().getId_supplier());
            st.setString(5, mod_masuk.getMod_user().getId_user());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }
    
    @Override
    public void hapusData(Model_Pembelian mod_masuk) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pembelian WHERE id_pembelian=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_masuk.getId_pembelian());
            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void perbaruiStatus(String id_barang) {
        PreparedStatement st = null;
        String sql = "UPDATE detail_pemesanan SET status='Barang Telah Datang' WHERE id_barang='"+id_barang+"'";
    
        try{
            st = conn.prepareStatement(sql);
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Perbarui Status Barang");
            java.util.logging.Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public Model_Pembelian getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_Pembelian> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM pembelian";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Pembelian masuk = new Model_Pembelian();
                Model_Supplier dst = new Model_Supplier();
                Model_User pgn = new Model_User();
                
                masuk.setId_pembelian       (rs.getString ("id_pembelian"));
                masuk.setTgl_pembelian      (rs.getString ("tgl_pembelian"));
                masuk.setTotal_pembelian    (rs.getLong("total_pembelian"));
                dst.setId_supplier   (rs.getString("id_supplier"));
                pgn.setId_user      (rs.getString("id_user"));
                                
                masuk.setMod_supplier(dst);
                masuk.setMod_user(pgn);
                list.add(masuk);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Model_Pembelian> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM pembelian WHERE id_pembelian LIKE '%"+id+"%' OR tgl_pembelian LIKE '%"+id+"%' OR total_pembelian LIKE '%"+id+"%' OR id_supplier LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Pemesanan psn = new Model_Pemesanan();
                Model_Supplier dst = new Model_Supplier();
                Model_User pgn = new Model_User();

                psn.setId_pesan         (rs.getString ("id_pembelian"));
                psn.setTgl_pesan        (rs.getString ("tgl_pembelian"));
                psn.setTotal_pesan      (rs.getLong   ("total_pembelian"));
                dst.setId_supplier  (rs.getString ("id_supplier"));
                pgn.setId_user      (rs.getString ("id_user"));
                
                psn.setMod_supplier(dst);
                psn.setMod_user(pgn);
                                
                list.add(psn);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Pembelian.class.getName()).log(Level.SEVERE, null, ex);
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

        String sql = "SELECT RIGHT(id_pembelian, 3) AS Nomor " +
                     "FROM pembelian " +
                     "WHERE id_pembelian LIKE 'BM" + no + "%' " +
                     "ORDER BY id_pembelian DESC " +
                     "LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "BM" + no + String.format("%03d", nomor);
            } else {
                urutan = "BM" + no + "001";
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