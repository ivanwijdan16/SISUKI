package dao;

import config.Koneksi;
import static config.Koneksi.getConnection;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import service.Service_Laporan;


public class DAO_Laporan implements Service_Laporan{

    private Connection conn;
    
    public DAO_Laporan(){
        conn = Koneksi.getConnection();
    }

//    @Override
//    public void suratJalanPemesanan(String no) {
//        try {
//                String reportPath = "src/report/SuratJalanPemesanan.jasper";
//                
//                HashMap<String, Object> parameters = new HashMap<>();
//                parameters.put("no", no); // Menyimpan nomor pemesanan sebagai parameter
//
//                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
//                JasperViewer viewer = new JasperViewer(print, false);
//                viewer.setVisible(true);
//            } catch (Exception e) {
//                JOptionPane.showConfirmDialog(null, e.getMessage());
//        }
//    }

    @Override
    public void transaksiPembelian(String no) {
        try {
                String reportPath = "src/report/TransaksiBarangMasuk.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("no", no); // Menyimpan nomor pembelian sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void transaksiPenjualan(String no) {
        try {
                String reportPath = "src/report/TransaksiBarangKeluar.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("no", no); // Menyimpan nomor penjualan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapDataBarang(JPanel jp) {
        try {
                String reportPath = "src/report/LapDataBarang.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
               
                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapTransaksiBarang(JPanel jp) {
        try {
                String reportPath = "src/report/LapStokBarang.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
               
                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapPemesananPerTransaksi(JPanel jp, String no) {
        try {
                String reportPath = "src/report/LapPesanPerTransaksi.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("no", no); // Menyimpan nomor pemesanan sebagai parameter

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapPemesananPerPeriode(JPanel jp, String tgl1, String tgl2) {
        try {
                String reportPath = "src/report/LapPesanPerPeriode.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("tgl1", tgl1);
                parameters.put("tgl2", tgl2);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapPemesananPerBulan(JPanel jp, String dt1, int dt2) {
        try {
                String reportPath = "src/report/LapPesanPerPerbulan.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("dt1", dt1);
                parameters.put("dt2", dt2);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    @Override
    public void lapPemesananPerSupplier(JPanel jp, String id) {
        try {
                String reportPath = "src/report/LapPesanPerDistributor.jasper";
                
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("id", id);

                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                //tampil panel
                jp.setLayout(new BorderLayout());
                jp.repaint();
                jp.add(new JRViewer(print));
                jp.revalidate();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }

    
    
    
    
}
