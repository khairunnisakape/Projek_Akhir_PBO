/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOkonser;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOImplement.interfaceOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author asus
 */
public class DAOOrder implements interfaceOrder{
    Connection connection;
    
    final String select = "SELECT * FROM tiket";
    final String insert = "INSERT INTO tiket (`seat`, `harga`, `stok`) VALUES (?,?,?)";
    
    public DAOOrder(){
        connection = connector.connection();
        
    }

    @Override
    public void insert(dataOrder o) {
        PreparedStatement statement = null;
       try{
           statement = connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, o.getSeat());
           statement.setString(2, o.getHarga());
           statement.setString(3, o.getStok());
           statement.executeUpdate();
       }catch(SQLException ex){
           ex.printStackTrace();
       }finally{
           try{
               statement.close();
           }catch(SQLException ex){
               ex.printStackTrace();
           }
       }
    }

    @Override
    public List<dataOrder> getAll() {
     List<dataOrder> dor = null;
        try{
            dor = new ArrayList<dataOrder>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
           while (rs.next()){
               dataOrder order = new dataOrder();
               order.setSeat(rs.getString("seat"));
               order.setHarga(rs.getString("harga"));
               order.setStok(rs.getString("stok"));
               dor.add(order);
           }
        }catch(SQLException ex){
            Logger.getLogger(datakonserDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dor;   
    }
}
