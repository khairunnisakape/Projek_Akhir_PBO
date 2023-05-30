/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOkonser.DAOOrder;
import DAOImplement.interfaceOrder;
import javax.swing.JOptionPane;
import model.*;
import view.BeliTiket;
/**
 *
 * @author asus
 */
public class controllerOrder {
    BeliTiket frame;
    interfaceOrder impldataorder;
    List<dataOrder> dor;
    
    public controllerOrder (BeliTiket frame){
        this.frame = frame;
        impldataorder = new DAOOrder();
        dor = impldataorder.getAll();    
    }
    public void isitabel(){
        dor = impldataorder.getAll();
        modeltabeldataorder mo = new modeltabeldataorder(dor);
        frame.getTabelbeli().setModel(mo);
        
    }
    
    public void insert(){
        
    }
}
