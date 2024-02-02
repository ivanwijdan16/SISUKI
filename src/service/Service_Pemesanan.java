package service;

import java.util.List;
import model.Model_Pemesanan;

public interface Service_Pemesanan {
    void tambahData     (Model_Pemesanan mod_pesan);
    void perbaruiData   (Model_Pemesanan mod_pesan);
    void hapusData      (Model_Pemesanan mod_pesan);
    
    Model_Pemesanan getByid (String id);
    List<Model_Pemesanan> getData();
    List<Model_Pemesanan> pencarian(String id);
    String nomor();
}
