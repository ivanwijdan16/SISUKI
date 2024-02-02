package service;

import java.util.List;
import model.Model_SemPenjualan;

public interface Service_SemPenjualan {
    void tambahData     (Model_SemPenjualan mod_jual);
    void perbaruiData   (Model_SemPenjualan mod_jual);
    void hapusData      (Model_SemPenjualan mod_jual);
    
    Model_SemPenjualan getByid (String id);
    List<Model_SemPenjualan> getData();
}