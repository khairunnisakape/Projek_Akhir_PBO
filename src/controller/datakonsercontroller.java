/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOkonser.datakonserDAO;
import DAOImplement.datakonserimplement;
import model.*;
import view.EditTiket;

/**
 *
 * @author asus
 */
public class datakonsercontroller {
    EditTiket frame;
    datakonserimplement impldatakonser;
    List<datakonser> dk;
    
    public datakonsercontroller (EditTiket frame){
        this.frame = frame;
        impldatakonser = new datakonserDAO();
        dk = impldatakonser.getAll();    
    }
    public void isitabel(){
        dk = impldatakonser.getAll();
        modeltabelkonser mk = new modeltabelkonser(dk);
        frame.getTabelEditTiket().setModel(mk);
        
    }
    
    public void insert(){
        datakonser dk = new datakonser();
        dk.setSeat(frame.getSeat().getText());
        dk.setHarga(frame.getHarga().getText());
        dk.setStok(frame.getStok().getText());
        impldatakonser.insert(dk);
    }
    
    public void update(){
        datakonser dk = new datakonser();
        dk.setSeat(frame.getSeat().getText());
        dk.setHarga(frame.getHarga().getText());
        dk.setStok(frame.getStok().getText());
        dk.setId(Integer.parseInt(frame.getId_tiket().getText()));
        impldatakonser.update(dk);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getId_tiket().getText());
        impldatakonser.delete(id);
        
    }
}
