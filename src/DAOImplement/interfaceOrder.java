/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;

/**
 *
 * @author asus
 */
public interface interfaceOrder {
    public void insert(dataOrder o);
    public List<dataOrder> getAll();
}
