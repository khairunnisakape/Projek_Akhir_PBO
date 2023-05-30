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
import DAOImplement.datakonserimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author asus
 */
public class datakonserDAO implements datakonserimplement {
    Connection connection;
    
    final String select = "SELECT * FROM tiket";
    final String insert = "INSERT INTO tiket (`seat`, `harga`, `stok`) VALUES (?,?,?)";
    final String update = "UPDATE tiket set seat=?, harga=?, stok=? where id_tiket=?";
    final String delete = "DELETE from tiket where id_tiket=?";
    
    public datakonserDAO(){
        connection = connector.connection();
        
    }

    @Override
    public void insert(datakonser k) {
       PreparedStatement statement = null;
       try{
           statement = connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, k.getSeat());
           statement.setString(2, k.getHarga());
           statement.setString(3, k.getStok());
           statement.executeUpdate();
           ResultSet rs = statement.getGeneratedKeys();
           while(rs.next()){
               k.setId(rs.getInt(1));
           }
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
    public void update(datakonser k) {
        PreparedStatement statement = null;
       try{
           statement = connection.prepareStatement(update);
           statement.setString(1, k.getSeat());
           statement.setString(2, k.getHarga());
           statement.setString(3, k.getStok());
           statement.setInt(4, k.getId());
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
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
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
    public List<datakonser> getAll() {
        List<datakonser> dk = null;
        try{
            dk = new ArrayList<datakonser>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
           while (rs.next()){
               datakonser konser = new datakonser();
               konser.setId(rs.getInt("id_tiket"));
               konser.setSeat(rs.getString("seat"));
               konser.setHarga(rs.getString("harga"));
               konser.setStok(rs.getString("stok"));
               dk.add(konser);
           }
        }catch(SQLException ex){
            Logger.getLogger(datakonserDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dk;
    }
}
