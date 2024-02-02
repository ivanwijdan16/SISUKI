/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_DetPenjualan;

/**
 *
 * @author Uhnuy Kozuki
 */
public class TableMod_DetPenjualan extends AbstractTableModel{

    private List<Model_DetPenjualan> list = new ArrayList<>();
    
    public void tambahData(Model_DetPenjualan mod_detkeluar){
        list.add(mod_detkeluar);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_DetPenjualan mod_detkeluar){
        list.add(row, mod_detkeluar);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data Berhasil di perbarui");
    }
    
    public void hapusData(int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<Model_DetPenjualan> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_DetPenjualan mod_detkeluar){
        list.set(index, mod_detkeluar);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_DetPenjualan getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getMod_jual().getId_penjualan();
            case 1: return list.get(rowIndex).getMod_barang().getId_barang();
            case 2: return list.get(rowIndex).getMod_barang().getNama_barang();
            case 3: return list.get(rowIndex).getMod_barang().getHarga();
            case 4: return list.get(rowIndex).getJml_penjualan();
            case 5: return list.get(rowIndex).getSubtotal_penjualan();
                      
            default: return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "ID Penjualan";
            case 1: return "ID Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga";
            case 4: return "Jumlah Penjualan";
            case 5: return "Subtotal";
                      
            default: return null;
        }
    }
    
}
