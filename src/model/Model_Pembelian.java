package model;

public class Model_Pembelian {
    private String id_pembelian;
    private String tgl_pembelian;
    private Long total_pembelian;
    private Model_Supplier mod_supplier;
    private Model_User mod_user;

    public String getId_pembelian() {
        return id_pembelian;
    }

    public void setId_pembelian(String id_pembelian) {
        this.id_pembelian = id_pembelian;
    }

    public String getTgl_pembelian() {
        return tgl_pembelian;
    }

    public void setTgl_pembelian(String tgl_pembelian) {
        this.tgl_pembelian = tgl_pembelian;
    }

    public Long getTotal_pembelian() {
        return total_pembelian;
    }

    public void setTotal_pembelian(Long total_pembelian) {
        this.total_pembelian = total_pembelian;
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