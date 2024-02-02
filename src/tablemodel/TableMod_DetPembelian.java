package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_DetPembelian;

public class TableMod_DetPembelian extends AbstractTableModel{
    private List<Model_DetPembelian> list = new ArrayList<>();
    
    public void tambahData(Model_DetPembelian mod_detpembelian){
        list.add(mod_detpembelian);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_DetPembelian mod_detpembelian){
        list.add(row, mod_detpembelian);
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

    public void setData(List<Model_DetPembelian> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_DetPembelian mod_detpembelian){
        list.set(index, mod_detpembelian);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_DetPembelian getData(int index){
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
            case 0: return list.get(rowIndex).getMod_beli().getId_pembelian();
            case 1: return list.get(rowIndex).getMod_barang().getId_barang();
            case 2: return list.get(rowIndex).getMod_barang().getNama_barang();
            case 3: return list.get(rowIndex).getMod_barang().getHarga();
            case 4: return list.get(rowIndex).getJml_pembelian();
            case 5: return list.get(rowIndex).getSubtotal_pembelian();
                      
            default: return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "ID Pembelian";
            case 1: return "ID Barang";
            case 2: return "Nama Barang";
            case 3: return "Harga";
            case 4: return "Jumlah Masuk";
            case 5: return "Subtotal";
                      
            default: return null;
        }
    }
}
