package service;

import java.util.List;
import model.Model_SemPemesanan;

public interface Service_SemPemesanan {
    void tambahData     (Model_SemPemesanan mod_pesan);
    void perbaruiData   (Model_SemPemesanan mod_pesan);
    void hapusData      (Model_SemPemesanan mod_pesan);
    
    Model_SemPemesanan getByid (String id);
    List<Model_SemPemesanan> getData();
}
