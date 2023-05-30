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
public interface datakonserimplement {
    public void insert(datakonser k);
    public void update(datakonser k);
    public void delete(int id);
    public List<datakonser> getAll();
}
