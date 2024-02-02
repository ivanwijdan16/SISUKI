package service;

import java.util.List;
import model.Model_DetPenjualan;

public interface Service_DetPenjualan {
    void tambahData (Model_DetPenjualan mod_detjual);
    void sumTotal (Model_DetPenjualan mod_detjual);
    void hapusSementara (Model_DetPenjualan mod_detjual);

    Model_DetPenjualan getByid (String id);
    List<Model_DetPenjualan> getData(String id);
    List<Model_DetPenjualan> pencarian(String id);
    
    boolean validasiStok (Model_DetPenjualan mod_detjual);
    
}