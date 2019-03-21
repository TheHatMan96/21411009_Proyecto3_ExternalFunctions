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
public class Factorial extends Function {
    
   @Override
    protected void xFunc() throws SQLException {
     if (args() != 1) {
            throw new SQLException(" " + args());
     }
     try{ 
       int numero = value_int(0);
       int resultado = 1;
          for (int i = 1; i <= numero; i++)
           {
              resultado *= i;
           }
          result(resultado);
        
    }catch(Exception e){
        result(0);
    }
     
    }
    
}