package service;

import java.util.List;
import javax.swing.JTable;
import model.Model_Supplier;

public interface Service_Supplier {
    void tambahData     (Model_Supplier mod_sup);
    void perbaruiData   (Model_Supplier mod_sup);
    void hapusData      (Model_Supplier mod_sup);
    
    Model_Supplier getByid (String id);
    
    List<Model_Supplier> getData();
    List<Model_Supplier> getData(int startIndex, int entriesPerPage);
    List<Model_Supplier> pencarian(String id);
    
    String nomor();
    int getTotalEntries();   
}