package service;

import java.util.List;
import model.Model_Penjualan;

public interface Service_Penjualan {
    void tambahData     (Model_Penjualan mod_jual);
    void hapusData      (Model_Penjualan mod_jual);
    
    Model_Penjualan getByid (String id);
    List<Model_Penjualan> getData();
    List<Model_Penjualan> pencarian(String id);
    String nomor();
}
