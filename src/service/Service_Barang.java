package service;

import java.util.List;
import javax.swing.JTable;
import model.Model_Barang;

public interface Service_Barang {
    void tambahData (Model_Barang mod_bar);
    void perbaruiData (Model_Barang mod_bar);
    void hapusData (Model_Barang mod_bar);
    
    Model_Barang getByid (String id);
    
    List<Model_Barang> getDataByID();
    List<Model_Barang> getData();
    
    List<Model_Barang> pencarian(String id);
    
    String nomor();
    
    
}
