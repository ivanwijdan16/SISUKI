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
import model.Model_Supplier;
import model.Model_JenisBarang;
import service.Service_Supplier;

public class DAO_Supplier implements Service_Supplier{

    private Connection connection;
    
    public DAO_Supplier() {
        connection = Koneksi.getConnection();
    }

    
    @Override
    public void tambahData(Model_Supplier mod_sup) {
        PreparedStatement st = null;
        String sql = "INSERT INTO supplier(id_supplier,nama_supplier,telp_supplier,alamat_supplier) VALUES (?,?,?,?)";
        try{
            st = connection.prepareStatement(sql);
            st.setString(1, mod_sup.getId_supplier());
            st.setString(2, mod_sup.getNama_supplier());
            st.setString(3, mod_sup.getTelp_supplier());
            st.setString(4, mod_sup.getAlamat_supplier());
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void perbaruiData(Model_Supplier mod_sup) {
        PreparedStatement st = null;
        String sql = "UPDATE supplier SET nama_supplier=?, telp_supplier=?, alamat_supplier=? WHERE id_supplier=?";
        try{
            st = connection.prepareStatement(sql);
            
            st.setString(1, mod_sup.getNama_supplier());
            st.setString(2, mod_sup.getTelp_supplier());
            st.setString(3, mod_sup.getAlamat_supplier());
            st.setString(4, mod_sup.getId_supplier());
            
            st.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusData(Model_Supplier mod_sup) {
        PreparedStatement st = null;
        String sql = "DELETE FROM supplier WHERE id_supplier=?";
        try{
            st = connection.prepareStatement(sql);
            st.setString(1, mod_sup.getId_supplier());
            
            
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Model_Supplier getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_Supplier> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM supplier";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Supplier model = new Model_Supplier();
                model.setId_supplier(rs.getString ("id_supplier"));
                model.setNama_supplier(rs.getString ("nama_supplier"));
                model.setTelp_supplier(rs.getString ("telp_supplier"));
                model.setAlamat_supplier(rs.getString ("alamat_supplier"));
                                
                list.add(model);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Model_Supplier> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM supplier WHERE id_supplier LIKE '%"+id+"%' OR nama_supplier LIKE '%"+id+"%' OR telp_supplier LIKE '%"+id+"%' OR alamat_supplier LIKE '%"+id+"%'";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_Supplier model = new Model_Supplier();
                model.setId_supplier(rs.getString ("id_supplier"));
                model.setNama_supplier(rs.getString ("nama_supplier"));
                model.setTelp_supplier(rs.getString ("telp_supplier"));
                model.setAlamat_supplier(rs.getString ("alamat_supplier"));
                                
                list.add(model);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
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

        String sql = "SELECT RIGHT(id_supplier, 3) AS Nomor FROM supplier WHERE id_supplier LIKE 'DST" + no + "%' ORDER BY id_supplier DESC LIMIT 1";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "DST" + no + String.format("%03d", nomor);
            } else {
                urutan = "DST" + no + "001";
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

    @Override
    public List<Model_Supplier> getData(int startIndex, int entriesPerPage) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM supplier LIMIT ?, ?";
        List<Model_Supplier> list = new ArrayList<>();

        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, startIndex);
            st.setInt(2, entriesPerPage);
            rs = st.executeQuery();

            while (rs.next()) {
                Model_Supplier model = new Model_Supplier();
                model.setId_supplier(rs.getString("id_supplier"));
                model.setNama_supplier(rs.getString("nama_supplier"));
                model.setTelp_supplier(rs.getString("telp_supplier"));
                model.setAlamat_supplier(rs.getString("alamat_supplier"));
                list.add(model);
            }

            return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public int getTotalEntries() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) AS total FROM supplier";

        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                return rs.getInt("total");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_Supplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    
    
}
