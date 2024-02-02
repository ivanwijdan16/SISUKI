package model;

public class Model_Penjualan {

    public String getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(String id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public String getTgl_penjualan() {
        return tgl_penjualan;
    }

    public void setTgl_penjualan(String tgl_penjualan) {
        this.tgl_penjualan = tgl_penjualan;
    }

    public Long getTotal_penjualan() {
        return total_penjualan;
    }

    public void setTotal_penjualan(Long total_penjualan) {
        this.total_penjualan = total_penjualan;
    }

    public Model_User getMod_user() {
        return mod_user;
    }

    public void setMod_user(Model_User mod_user) {
        this.mod_user = mod_user;
    }
    private String id_penjualan;
    private String tgl_penjualan;
    private Long total_penjualan;
    private Model_User mod_user;

    
}
