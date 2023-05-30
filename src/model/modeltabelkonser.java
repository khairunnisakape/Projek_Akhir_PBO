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
public class modeltabelkonser extends AbstractTableModel {

    List<datakonser> dk;
    public modeltabelkonser(List<datakonser>dk){
        this.dk = dk;
    }
    
    @Override
    public int getRowCount() {
        return dk.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Seat";
            case 2:
                return "Harga";
            case 3:
                return "Stok";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return dk.get(row).getId();
            case 1:
                return dk.get(row).getSeat();
            case 2:
                return dk.get(row).getHarga();
            case 3:
                return dk.get(row).getStok();
            default:
                return null;
        }
    }
    
}
