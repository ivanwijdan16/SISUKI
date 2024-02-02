package model;

public class Model_DetPenjualan {
    private Model_Penjualan mod_jual;
    private Model_Barang mod_barang;
    private int jml_penjualan;
    private Long subtotal_penjualan;

    public Model_Penjualan getMod_jual() {
        return mod_jual;
    }

    public void setMod_jual(Model_Penjualan mod_jual) {
        this.mod_jual = mod_jual;
    }

    public Model_Barang getMod_barang() {
        return mod_barang;
    }

    public void setMod_barang(Model_Barang mod_barang) {
        this.mod_barang = mod_barang;
    }

    public int getJml_penjualan() {
        return jml_penjualan;
    }

    public void setJml_penjualan(int jml_penjualan) {
        this.jml_penjualan = jml_penjualan;
    }

    public Long getSubtotal_penjualan() {
        return subtotal_penjualan;
    }

    public void setSubtotal_penjualan(Long subtotal_penjualan) {
        this.subtotal_penjualan = subtotal_penjualan;
    }
    
}
