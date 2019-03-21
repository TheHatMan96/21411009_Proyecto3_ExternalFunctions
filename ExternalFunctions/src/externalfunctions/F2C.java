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
public class F2C extends Function {
    
      protected void xFunc() throws SQLException {
        if (args() != 1) {
            throw new SQLException(" " + args());
        }
        try{
            double tempf= value_double(0);
            double resultado= ((tempf-32)*5)/9;
            result(resultado);
        }catch(Exception e){
            result(0);
        }
            
      }
}
