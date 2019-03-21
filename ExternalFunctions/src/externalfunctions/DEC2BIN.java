/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalfunctions;
import org.sqlite.Function;
import java.sql.SQLException;
/**
 *
 * @author ultim
 */
public class DEC2BIN extends Function {
    
    
      protected void xFunc() throws SQLException {
        if (args() != 1) {
            throw new SQLException(" " + args());
        }
      try{
           result(Integer.toString( value_int(0),2));
       }catch(Exception e){
           result(0);
       }
     }
    
}

