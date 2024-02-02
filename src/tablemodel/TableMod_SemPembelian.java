package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_SemPembelian;

public class TableMod_SemPembelian extends AbstractTableModel{
    
    private List<Model_SemPembelian> list = new ArrayList<>();
    
    public void tambahData(Model_SemPembelian mod_beli){
        list.add(mod_beli);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_SemPembelian mod_beli){
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

    public void setData(List<Model_SemPembelian> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_SemPembelian mod_beli){
        list.set(index, mod_beli);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_SemPembelian getData(int index){
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
            case 0: return list.get(rowIndex).getMod_barang().getId_barang();
            case 1: return list.get(rowIndex).getMod_barang().getNama_barang();
            case 2: return list.get(rowIndex).getMod_barang().getHarga();
            case 3: return list.get(rowIndex).getMod_detbeli().getJml_pembelian();
            case 4: return list.get(rowIndex).getMod_detbeli().getSubtotal_pembelian();
                        
            default: return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "Id Barang";
            case 1: return "Nama Barang";
            case 2: return "Harga";
            case 3: return "Jumlah";
            case 4: return "Subtotal";
                      
            default: return null;
        }
    }
}
