package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_Supplier;

public class TableMod_Supplier extends AbstractTableModel{
    
    private List<Model_Supplier> list = new ArrayList<>();
    
    public void tambahData(Model_Supplier mod_sup){
        list.add(mod_sup);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_Supplier mod_sup){
        list.add(row, mod_sup);
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

    public void setData(List<Model_Supplier> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_Supplier mod_sup){
        list.set(index, mod_sup);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_Supplier getData(int index){
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
            case 0: return list.get(rowIndex).getId_supplier();
            case 1: return list.get(rowIndex).getNama_supplier();
            case 2: return list.get(rowIndex).getTelp_supplier();
            case 3: return list.get(rowIndex).getAlamat_supplier();
            
            default: return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "ID Supplier";
            case 1: return "Nama Supplier";
            case 2: return "Telepon Supplier";
            case 3: return "Alamat Supplier";
                      
            default: return null;
        }
    }
}
