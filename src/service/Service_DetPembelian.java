package service;

import java.util.List;
import model.Model_DetPembelian;

public interface Service_DetPembelian {
    void tambahData (Model_DetPembelian mod_detmasuk);
    void sumTotal (Model_DetPembelian mod_detmasuk);
    void hapusSementara (Model_DetPembelian mod_detmasuk);

    Model_DetPembelian getByid (String id);
    List<Model_DetPembelian> getData(String id);
}
