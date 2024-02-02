/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Model_JenisBarang;

/**
 *
 * @author Uhnuy Kozuki
 */
public interface Service_JenisBarang {
    void tambahData     (Model_JenisBarang mod_jenbar);
    void perbaruiData   (Model_JenisBarang mod_jenbar);
    void hapusData      (Model_JenisBarang mod_jenbar);
    
    Model_JenisBarang getByid (String id);
    
    List<Model_JenisBarang> getData();
    List<Model_JenisBarang> pencarian(String id);
    
    String nomor();
    
    boolean validasiNamaJenisBarang(Model_JenisBarang mod_jenbar);
    
    List<Model_JenisBarang> getData(int startIndex, int entriesPerPage);
    int getTotalHalaman();
}
