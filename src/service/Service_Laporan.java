package service;

import javax.swing.JPanel;

public interface Service_Laporan {
    void transaksiPembelian       (String no);
    void transaksiPenjualan      (String no);
    
    void lapDataBarang              (JPanel jp);
    void lapTransaksiBarang         (JPanel jp);
    
    void lapPemesananPerTransaksi   (JPanel jp, String no);
    void lapPemesananPerPeriode     (JPanel jp, String tgl1, String tgl2);
    void lapPemesananPerBulan       (JPanel jp, String dt1, int dt2);
    void lapPemesananPerSupplier (JPanel jp, String id);
}
