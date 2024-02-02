package service;

import java.util.List;
import javax.swing.JLabel;
import model.Model_User;

public interface Service_User {
    void tambahData     (Model_User mod_user);
    void perbaruiData   (Model_User mod_user);
    void hapusData      (Model_User mod_user);
    
    Model_User getByid (String id);
    
    List<Model_User> getData();
    List<Model_User> pencarian(String id);
    
    String nomor();
    boolean validateOldPassword(String username, String oldPassword);
    boolean changePassword(String username, String oldPassword, String newPassword);
    void tampilGambar(JLabel lb_gambar, String id);
}