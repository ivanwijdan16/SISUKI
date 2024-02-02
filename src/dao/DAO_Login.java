
package dao;

import Main.Menu_Utama;
import config.Koneksi;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Model_Login;
import service.Service_Login;
import view.Form_Login;

public class DAO_Login implements Service_Login{

    private Connection conn;
    
    public DAO_Login() {
        conn = Koneksi.getConnection();
    }

    @Override
    public void prosesLogin(Model_Login mod_login) {
        PreparedStatement st = null;
        ResultSet rs        = null;
        String Id           = null;
        String Nama         = null;
        String Jabatan2       = null;
        String Username     = null;
        String sql = "SELECT * FROM user WHERE(id_user='"+mod_login.getId_user()+"'OR username='"+mod_login.getUsername()+"') AND password='"+Encrypt.getmd5java(mod_login.getPass_user())+"'";
         
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                Id   = rs.getString("id_user");
                Nama = rs.getString("nama_user");
                Jabatan2 = rs.getString("jabatan");
                Username = rs.getString("username");
                Blob gambarBlob = rs.getBlob("gambar");
                
                Model_Login mod = new Model_Login();
                mod.setId_user(Id);
                mod.setNama_user(Nama);
                mod.setUsername(Username);
                mod.setJabatan(Jabatan2);
                mod.setGambar(gambarBlob);
                
                Menu_Utama menu = new Menu_Utama(mod);
                menu.setVisible(true);
                menu.revalidate();
                
                Form_Login lg = new Form_Login();
                lg.tutup = true;
            }else{
                JOptionPane.showMessageDialog(null, "Username dan Password salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                Form_Login lg = new Form_Login();
                lg.tutup = false;
            }
        }catch(SQLException ex) {
            Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException ex){
                    Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } 

}
