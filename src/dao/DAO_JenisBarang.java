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
import model.Model_JenisBarang;
import service.Service_JenisBarang;

/**
 *
 * @author Uhnuy Kozuki
 */
public class DAO_JenisBarang implements Service_JenisBarang{

    private Connection connection;
    
    public DAO_JenisBarang(){
        connection = Koneksi.getConnection();
    }
    
    

    @Override
    public void tambahData(Model_JenisBarang mod_jenbar) {
        PreparedStatement st = null;
        String sql = "INSERT INTO jenis_barang(kode_jenis,nama_jenis) VALUES (?,?)";
        try{
            st = connection.prepareStatement(sql);
            st.setString(1, mod_jenbar.getKode_jenis());
            st.setString(2, mod_jenbar.getNama_jenis());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void perbaruiData(Model_JenisBarang mod_jenbar) {
        PreparedStatement st = null;
        String sql = "UPDATE jenis_barang SET nama_jenis=? WHERE kode_jenis=?";
        try{
            st = connection.prepareStatement(sql);
            st.setString(1, mod_jenbar.getNama_jenis());
            st.setString(2, mod_jenbar.getKode_jenis());
            
            st.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusData(Model_JenisBarang mod_jenbar) {
        PreparedStatement st = null;
        String sql = "DELETE FROM jenis_barang WHERE kode_jenis=?";
        try{
            st = connection.prepareStatement(sql);
            st.setString(1, mod_jenbar.getKode_jenis());
            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Model_JenisBarang getByid(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_JenisBarang mokat = null;
        String sql = "SELECT * FROM jenis_barang WHERE kode_jenis=?";
        try{
            st = connection.prepareStatement(sql);
            Model_JenisBarang ang = new Model_JenisBarang();
            st.setString(1, ang.getKode_jenis());
            st.setString(2, ang.getNama_jenis());
            
            rs= st.executeQuery();
            while (rs.next()) {
                mokat = new Model_JenisBarang();
                mokat.setKode_jenis(rs.getString ("kode_jenis"));
                mokat.setNama_jenis(rs.getString ("nama_jenis"));
                
            }
            return mokat;
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Model_JenisBarang> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM jenis_barang";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_JenisBarang mokat = new Model_JenisBarang();
                mokat.setKode_jenis(rs.getString ("kode_jenis"));
                mokat.setNama_jenis(rs.getString ("nama_jenis"));
                
                
                list.add(mokat);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Model_JenisBarang> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM jenis_barang WHERE kode_jenis LIKE '%"+id+"%' OR nama_jenis LIKE '%"+id+"%'";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_JenisBarang mokat = new Model_JenisBarang();
                mokat.setKode_jenis(rs.getString ("kode_jenis"));
                mokat.setNama_jenis(rs.getString ("nama_jenis"));
                                
                list.add(mokat);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        String sql = "SELECT RIGHT(kode_jenis,3) AS Nomor FROM jenis_barang ORDER BY Nomor DESC LIMIT 1";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = String.format("JB%03d", nomor);
            } else {
                urutan = "JB001";
            }
            }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (st!=null) {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
        return urutan;
    }

    @Override
    public boolean validasiNamaJenisBarang(Model_JenisBarang mod_jenbar) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        String sql = "SELECT nama_jenis FROM jenis_barang WHERE kode_jenis!='"+mod_jenbar.getKode_jenis()+"' AND nama_jenis LIKE BINARY '"+mod_jenbar.getNama_jenis()+"';";
        try{
            st = connection.prepareStatement(sql);
            rs= st.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Nama Jenis Barang Telah Ada\nSilahkan nama jenis barang yang lain","Peringatan",JOptionPane.WARNING_MESSAGE);
            }else {
                valid=true;
            }
        }catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                if (st!=null) {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }
        return valid;
    }

    @Override
    public List<Model_JenisBarang> getData(int startIndex, int entriesPerPage) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM jenis_barang LIMIT ?, ?";
        List<Model_JenisBarang> list = new ArrayList<>();

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, startIndex);
            st.setInt(2, entriesPerPage);
            rs = st.executeQuery();

            while (rs.next()) {
                Model_JenisBarang mokat = new Model_JenisBarang();
                mokat.setKode_jenis(rs.getString ("kode_jenis"));
                mokat.setNama_jenis(rs.getString ("nama_jenis"));
                list.add(mokat);
            }

            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public int getTotalHalaman() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) AS total FROM jenis_barang";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                return rs.getInt("total");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
