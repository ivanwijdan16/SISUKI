/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Uhnuy Kozuki
 */
public class Model_SemPembelian {

    public Model_Barang getMod_barang() {
        return mod_barang;
    }

    public void setMod_barang(Model_Barang mod_barang) {
        this.mod_barang = mod_barang;
    }

    public Model_DetPembelian getMod_detbeli() {
        return mod_detbeli;
    }

    public void setMod_detbeli(Model_DetPembelian mod_detbeli) {
        this.mod_detbeli = mod_detbeli;
    }
    private Model_Barang mod_barang;
    private Model_DetPembelian mod_detbeli;

    

        
        
}
