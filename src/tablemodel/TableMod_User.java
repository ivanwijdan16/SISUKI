package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_User;

public class TableMod_User extends AbstractTableModel {
    
    private List<Model_User> list = new ArrayList<>();
    
    public void tambahData(Model_User mod_user){
        list.add(mod_user);
        fireTableRowsInserted(list.size() - 1, list.size() -1);
        JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_User mod_user){
        list.add(row, mod_user);
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

    public void setData(List<Model_User> list){
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void setData(int index, Model_User mod_user){
        list.set(index, mod_user);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_User getData(int index){
        return list.get(index);
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columnNames = {"No", "ID", "Nama", "Username", "Jabatan"};
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
                return "    " + (rowIndex + 1);
            } else {
                switch (columnIndex - 1) {
                    case 0: return list.get(rowIndex).getId_user();
                    case 1: return list.get(rowIndex).getNama_user();
                    case 2: return list.get(rowIndex).getUsername();
                    case 3: return list.get(rowIndex).getJabatan();
                    default: return null;
                }
            }
        }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "    " + columnNames[column];
        } else {
            return columnNames[column];
        }
    }
}
