/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.snooker4j;

import com.healthmarketscience.jackcess.Row;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Player {
    
    private String _name;
    
    private Object _birth_date;
    
    public Player(Row row) {
        _name = (String) row.get("name"); 
        _birth_date = row.get("birth_date");
    }
    
    public String getName() {
        return _name;
    }
    
    public Object getBirthDate() {
        return _birth_date;
    }
    
}
