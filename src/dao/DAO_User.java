package dao;

import config.Koneksi;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Model_JenisBarang;
import model.Model_User;
import service.Service_User;

public class DAO_User implements Service_User{
    
    private Connection conn;

    public DAO_User() {
        conn = Koneksi.getConnection();
    }
    
    
    @Override
    public void tambahData(Model_User mod_user) {
        PreparedStatement st = null;
        String sql = "INSERT INTO user(id_user,nama_user,username,password,jabatan,gambar) VALUES (?,?,?,?,?,?)";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_user.getId_user());
            st.setString(2, mod_user.getNama_user());
            st.setString(3, mod_user.getUsername());
            st.setString(4, Encrypt.getmd5java(mod_user.getPassword()));
            st.setString(5, mod_user.getJabatan());
            
            // Mengubah gambar menjadi byte array
            String imagePath = mod_user.getImagePath();
            if (imagePath != null) {
                File imageFile = new File(imagePath);
                FileInputStream fis = new FileInputStream(imageFile);
                byte[] imageData = new byte[(int) imageFile.length()];
                fis.read(imageData);
                fis.close();
                st.setBytes(8, imageData);
            } else {
                st.setNull(8, java.sql.Types.BLOB);
            }
            
            st.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
            }
        }
    }

    @Override
    public void perbaruiData(Model_User mod_user) {
        PreparedStatement st = null;
        String sql = "UPDATE user SET nama_user=?,username=?,jabatan=?";
                    if (mod_user.getImagePath() != null && !mod_user.getImagePath().isEmpty()) 
                    {
                        sql += ",gambar=?";
                    }
                        sql += " WHERE id_user=?";
            try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_user.getNama_user());
            st.setString(2, mod_user.getUsername());
            //st.setString(4, Encrypt.getmd5java(mod_user.getPassword()));
            st.setString(3, mod_user.getJabatan());
            
            // Mengubah gambar menjadi byte array
            if (mod_user.getImagePath() != null && !mod_user.getImagePath().isEmpty()) {
                File imageFile = new File(mod_user.getImagePath());
                FileInputStream fis = new FileInputStream(imageFile);
                st.setBinaryStream(6, fis, (int) imageFile.length());
                st.setString(7, mod_user.getId_user());
            } else {
                st.setString(6, mod_user.getId_user());
            }
              
            
            st.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public void hapusData(Model_User mod_user) {
        PreparedStatement st = null;
        String sql = "DELETE FROM user WHERE id_user=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mod_user.getId_user());
           
            st.executeUpdate();
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    @Override
    public Model_User getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_User> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM user";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_User model = new Model_User();
                model.setId_user(rs.getString ("id_user"));
                model.setNama_user(rs.getString ("nama_user"));
                model.setUsername(rs.getString ("username"));
                model.setJabatan(rs.getString ("jabatan"));
                
                list.add(model);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }

    @Override
    public List<Model_User> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql ="SELECT * FROM user WHERE id_user LIKE '%"+id+"%' OR nama_user LIKE '%"+id+"%' OR username LIKE '%"+id+"%'";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_User model = new Model_User();
                model.setId_user(rs.getString ("id_user"));
                model.setNama_user(rs.getString ("nama_user"));
                model.setUsername(rs.getString ("username"));
                model.setJabatan(rs.getString ("jabatan"));
                                
                list.add(model);
            }
          return list;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if (st!=null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
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

        String sql = "SELECT RIGHT(id_user, 3) AS Nomor FROM user WHERE id_user LIKE 'USR" + no + "%' ORDER BY id_user DESC LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "USR" + no + String.format("%03d", nomor);
            } else {
                urutan = "USR" + no + "001";
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
    public boolean validateOldPassword(String username, String oldPassword) {
        
        String encryptedOldPassword = Encrypt.getmd5java(oldPassword);
        //return userDao.validateOldPassword(Koneksi.getConnection(), username, encryptedOldPassword);
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, encryptedOldPassword);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        
        String encryptedOldPassword = Encrypt.getmd5java(oldPassword);
        String encryptedNewPassword = Encrypt.getmd5java(newPassword);
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, encryptedOldPassword);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String sqlUpdate = "UPDATE user SET password = ? WHERE username = ?";
                PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate);
                pstmtUpdate.setString(1, encryptedNewPassword);
                pstmtUpdate.setString(2, username);
                int result = pstmtUpdate.executeUpdate();
                return result > 0;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    
    }

    @Override
    public void tampilGambar(JLabel lb_gambar, String id) {
        try {
            String sql = "SELECT * FROM user WHERE id_user = '" + id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                byte[] img = rs.getBytes("gambar");
                if (img != null) {
                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lb_gambar.getWidth(), lb_gambar.getHeight(), Image.SCALE_SMOOTH));
                    lb_gambar.setIcon(imageIcon);
                } else {
                    ImageIcon defaultIcon = new ImageIcon(getClass().getResource("/img/icons8_worker_100px.png"));
                    lb_gambar.setIcon(defaultIcon);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    
}
