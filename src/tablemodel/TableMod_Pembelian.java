package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_Pembelian;

public class TableMod_Pembelian extends AbstractTableModel {

    private List<Model_Pembelian> list = new ArrayList<>();
    
    public void tambahData(Model_Pembelian mod_beli){
        list.add(mod_beli);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_Pembelian mod_beli){
        list.add(row, mod_beli);
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

    public void setData(List<Model_Pembelian> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_Pembelian mod_beli){
        list.set(index, mod_beli);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Pembelian getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return list.get(rowIndex).getId_pembelian();
            case 1: return list.get(rowIndex).getTgl_pembelian();
            case 2: return list.get(rowIndex).getTotal_pembelian();
            case 3: return list.get(rowIndex).getMod_supplier().getId_supplier();
            case 4: return list.get(rowIndex).getMod_user().getId_user();
                      
            default: return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "ID Pembelian";
            case 1: return "Tanggal Pembelian";
            case 2: return "Total Pembelian";
            case 3: return "ID Supplier";
            case 4: return "ID User";
                      
            default: return null;
        }
    }   
}