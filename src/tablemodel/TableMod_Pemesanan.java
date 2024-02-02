package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_Pemesanan;

public class TableMod_Pemesanan extends AbstractTableModel{
    
    private List<Model_Pemesanan> list = new ArrayList<>();
    
    public void tambahData(Model_Pemesanan mod_pesan){
        list.add(mod_pesan);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_Pemesanan mod_pesan){
        list.add(row, mod_pesan);
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

    public void setData(List<Model_Pemesanan> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_Pemesanan mod_pesan){
        list.set(index, mod_pesan);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Pemesanan getData(int index){
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
            case 0: return list.get(rowIndex).getId_pesan();
            case 1: return list.get(rowIndex).getTgl_pesan();
            case 2: return list.get(rowIndex).getTotal_pesan();
            case 3: return list.get(rowIndex).getMod_supplier().getId_supplier();
            case 4: return list.get(rowIndex).getMod_user().getId_user();
                        
            default: return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "ID Pemesanan";
            case 1: return "Tanggal";
            case 2: return "Total Pemesanan";
            case 3: return "ID Supplier";
            case 4: return "ID User";
                      
            default: return null;
        }
    }
}
