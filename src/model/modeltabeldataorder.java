/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author asus
 */
public class modeltabeldataorder extends AbstractTableModel{

    List<dataOrder> dor;
    public modeltabeldataorder(List<dataOrder>dor){
        this.dor = dor;
    }
    
    @Override
    public int getRowCount() {
        return dor.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName (int column){
        switch (column){
            case 0:
                return "Seat";
            case 1:
                return "Harga";
            case 2:
                return "Stok";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return dor.get(row).getSeat();
            case 1:
                return dor.get(row).getHarga();
            case 2:
                return dor.get(row).getStok();
            default:
                return null;
        }
    }
    
}
