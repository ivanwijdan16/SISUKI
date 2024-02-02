package service;

import java.util.List;
import model.Model_DetPemesanan;

public interface Service_DetPemesanan {
    void tambahData (Model_DetPemesanan mod_detpesan);
    void sumTotal (Model_DetPemesanan mod_detpesan);
    void hapusSementara (Model_DetPemesanan mod_detpesan);

    Model_DetPemesanan getByid (String id);
    List<Model_DetPemesanan> getData(String id);
    List<Model_DetPemesanan> pencarian(String id);
}
