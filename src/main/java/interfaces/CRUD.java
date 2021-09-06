/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;

/**
 *
 * @author nroda
 */
public interface CRUD {
    
    public String create();
    public ResultSet read();
    public String update();
    public String delete();
}
