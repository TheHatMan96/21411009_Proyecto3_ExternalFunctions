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
public class HEX2DEC extends Function{
    @Override
    protected void xFunc() throws SQLException {
        if (args() != 1) {
            throw new SQLException(" " + args());
        }
         result(Integer.parseInt(value_text(0),16));
    }
    
 
}

