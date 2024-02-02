package service;

import java.util.List;
import model.Model_SemPembelian;

public interface Service_SemPembelian {
    void tambahData     (Model_SemPembelian mod_masuk);
    void perbaruiData   (Model_SemPembelian mod_masuk);
    void hapusData      (Model_SemPembelian mod_masuk);
    
    Model_SemPembelian getByid (String id);
    List<Model_SemPembelian> getData();
}
