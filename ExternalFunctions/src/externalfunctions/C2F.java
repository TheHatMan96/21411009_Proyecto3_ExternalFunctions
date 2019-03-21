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
public class C2F extends Function {
     @Override
    protected void xFunc() throws SQLException {
        if (args() != 1) {
            throw new SQLException(" " + args());
        }
       try{
           double tempc= value_double(0);
           double resultado= (9*tempc/5)+32;
           result (resultado);
       }catch(Exception e){
          result(0);
       }
  
    }
   
}
