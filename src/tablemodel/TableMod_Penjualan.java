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
import model.Model_Penjualan;

/**
 *
 * @author Uhnuy Kozuki
 */
public class TableMod_Penjualan extends AbstractTableModel {

    private List<Model_Penjualan> list = new ArrayList<>();
    
    public void tambahData(Model_Penjualan mod_keluar){
        list.add(mod_keluar);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_Penjualan mod_keluar){
        list.add(row, mod_keluar);
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

    public void setData(List<Model_Penjualan> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_Penjualan mod_keluar){
        list.set(index, mod_keluar);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Penjualan getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getId_penjualan();
            case 1: return list.get(rowIndex).getTgl_penjualan();
            case 2: return list.get(rowIndex).getTotal_penjualan();
            case 3: return list.get(rowIndex).getMod_user().getId_user();
                      
            default: return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "ID Penjualan";
            case 1: return "Tanggal Penjualan";
            case 2: return "Total Keluar";
            case 3: return "ID User";
                      
            default: return null;
        }
    }
    
}
