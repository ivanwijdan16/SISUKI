package model;

public class Model_DetPembelian {
    private Model_Pembelian mod_beli;
    private Model_Barang mod_barang;
    private int jml_pembelian;
    private Long subtotal_pembelian;

    public Model_Pembelian getMod_beli() {
        return mod_beli;
    }

    public void setMod_beli(Model_Pembelian mod_beli) {
        this.mod_beli = mod_beli;
    }

    public Model_Barang getMod_barang() {
        return mod_barang;
    }

    public void setMod_barang(Model_Barang mod_barang) {
        this.mod_barang = mod_barang;
    }

    public int getJml_pembelian() {
        return jml_pembelian;
    }

    public void setJml_pembelian(int jml_pembelian) {
        this.jml_pembelian = jml_pembelian;
    }

    public Long getSubtotal_pembelian() {
        return subtotal_pembelian;
    }

    public void setSubtotal_pembelian(Long subtotal_pembelian) {
        this.subtotal_pembelian = subtotal_pembelian;
    }

}