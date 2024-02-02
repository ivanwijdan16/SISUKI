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
public class Model_Pemesanan {

    private String id_pesan;
    private String tgl_pesan;
    private Long total_pesan;
    private Model_Supplier mod_supplier;
    private Model_User mod_user;

    public String getId_pesan() {
        return id_pesan;
    }

    public void setId_pesan(String id_pesan) {
        this.id_pesan = id_pesan;
    }

    public String getTgl_pesan() {
        return tgl_pesan;
    }

    public void setTgl_pesan(String tgl_pesan) {
        this.tgl_pesan = tgl_pesan;
    }

    public Long getTotal_pesan() {
        return total_pesan;
    }

    public void setTotal_pesan(Long total_pesan) {
        this.total_pesan = total_pesan;
    }

    public Model_Supplier getMod_supplier() {
        return mod_supplier;
    }

    public void setMod_supplier(Model_Supplier mod_supplier) {
        this.mod_supplier = mod_supplier;
    }

    public Model_User getMod_user() {
        return mod_user;
    }

    public void setMod_user(Model_User mod_user) {
        this.mod_user = mod_user;
    }

    
    

    
}
