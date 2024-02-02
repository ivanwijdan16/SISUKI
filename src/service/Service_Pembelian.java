package service;

import java.util.List;
import model.Model_Pembelian;

public interface Service_Pembelian {
    void tambahData     (Model_Pembelian mod_beli);
    void perbaruiStatus (String id_barang);
    void hapusData      (Model_Pembelian mod_beli);
    
    Model_Pembelian getByid (String id);
    List<Model_Pembelian> getData();
    List<Model_Pembelian> pencarian(String id);
    String nomor();
}