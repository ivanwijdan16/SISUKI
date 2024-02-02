package dao;

import config.Koneksi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Model_Barang;
import model.Model_JenisBarang;
import service.Service_Barang;

public class DAO_Barang implements Service_Barang{

    private Connection conn;
    
    public DAO_Barang() {
        conn = Koneksi.getConnection();   
    }
    
    @Override
    public void tambahData(Model_Barang mod_bar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang (id_barang, kode_jenis, nama_barang, harga, stok) VALUES (?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_bar.getId_barang());
            st.setString(2, mod_bar.getJns_barang().getKode_jenis());
            st.setString(3, mod_bar.getNama_barang());
            st.setLong  (4, mod_bar.getHarga());
            st.setInt   (5, mod_bar.getStok());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void perbaruiData(Model_Barang mod_bar) {
        PreparedStatement st = null;
        String sql = "UPDATE barang SET  kode_jenis=?, nama_barang=?, harga=?, stok=? WHERE id_barang='"+mod_bar.getId_barang()+"'";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_bar.getJns_barang().getKode_jenis());
            st.setString(2, mod_bar.getNama_barang());
            st.setLong  (3, mod_bar.getHarga());
            st.setInt   (4, mod_bar.getStok());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Perbarui Data Gagal");
            Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusData(Model_Barang mod_bar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            
            st.setString(1, mod_bar.getId_barang());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Model_Barang getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_Barang> getDataByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_Barang> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT bg.id_barang,bg.kode_jenis,jb.nama_jenis,bg.nama_barang,bg.harga,bg.stok FROM barang bg INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Barang mobar = new Model_Barang();
                Model_JenisBarang jbr = new Model_JenisBarang();

                mobar.setId_barang    (rs.getString ("id_barang"));
                jbr.setKode_jenis       (rs.getString ("kode_jenis"));
                jbr.setNama_jenis       (rs.getString ("nama_jenis"));
                mobar.setNama_barang    (rs.getString ("nama_barang"));
                mobar.setHarga          (rs.getLong   ("harga"));
                mobar.setStok           (rs.getInt    ("stok"));
                
                mobar.setJns_barang(jbr);
                
                list.add(mobar);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Model_Barang> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT bg.id_barang,bg.kode_jenis,jb.nama_jenis, "
                + "bg.nama_barang,bg.harga,bg.stok FROM barang bg "
                + "INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis WHERE id_barang LIKE '%"+id+"%' OR nama_barang LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Barang mobar = new Model_Barang();
                Model_JenisBarang jb = new Model_JenisBarang();
                mobar.setId_barang    (rs.getString ("id_barang"));
                jb.setKode_jenis        (rs.getString ("kode_jenis"));
                jb.setNama_jenis        (rs.getString ("nama_jenis"));
                mobar.setNama_barang    (rs.getString ("nama_barang"));
                mobar.setHarga          (rs.getLong   ("harga"));
                mobar.setStok           (rs.getInt    ("stok"));
                                
                mobar.setJns_barang(jb);
                list.add(mobar);
            }
          return list;
        } catch (SQLException ex) {
            
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
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
        SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
        String tgl = tanggal.format(now);
        String no = noformat.format(now);

        String sql = "SELECT RIGHT(id_barang, 3) AS Nomor " +
                     "FROM barang " +
                     "WHERE id_barang LIKE 'B" + no + "%' " +
                     "ORDER BY id_barang DESC " +
                     "LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "B" + no + String.format("%03d", nomor);
            } else {
                urutan = "B" + no + "001";
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return urutan;

    }
}