/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalfunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.Function;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ultim
 */
public class ExternalFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileDb = "C:/Users/ultim/OneDrive/Documents/NetBeansProjects/ExternalFunctions/test2.db";
        Connection connection = Connection(fileDb);
        
        try {
            
        Function.create(connection,TRIM.class.getSimpleName(), new TRIM());
        Function.create(connection, Ping.class.getSimpleName(), new Ping());
        Function.create(connection, Factorial.class.getSimpleName(), new Factorial());
        Function.create(connection, C2F.class .getSimpleName(), new C2F());
        Function.create(connection, F2C.class .getSimpleName(), new F2C());
        Function.create(connection, BIN2DEC.class.getSimpleName(), new BIN2DEC());
        Function.create(connection, DEC2BIN.class.getSimpleName(), new DEC2BIN());
        Function.create(connection, DEC2HEX.class.getSimpleName(), new DEC2HEX());
        Function.create(connection, HEX2DEC.class.getSimpleName(), new HEX2DEC());
        Function.create(connection, REPEAT.class.getSimpleName(), new REPEAT());
        Function.create(connection, PMT.class.getSimpleName(), new PMT());
        Function.create(connection, COMPARESTRING.class.getSimpleName(), new COMPARESTRING());
        
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  
        
          //TRIM
          ResultSet rs = statement.executeQuery("select Trim('/Axel/','/') as b");
           while(rs.next())
           {
              System.out.println("TRIM= " + rs.getString("b"));
           }
           
          //PING
          ResultSet rst = statement.executeQuery("select Ping('github.com') as PING");
          System.out.println("Ping= "+rst.getString("PING"));
            
          //FACTORIAL
          ResultSet rsat = statement.executeQuery("select Factorial(5) as b");
              while (rsat.next()){
                System.out.println("Factorial= "+ rsat.getInt(1));
           }
           
          //C2F
          ResultSet rsc2= statement.executeQuery("select C2F(25) as b");
          System.out.println("Farenheit= "+ rsc2.getDouble(1)+ " °F");
           
          //F2C
          ResultSet rsf2= statement.executeQuery("select F2C (45) as b");
          System.out.println("Temperatura en Celsius= "+ rsf2.getDouble(1)+ " °C");
           
          //BIN2DEC
          ResultSet rsbin= statement.executeQuery("select BIN2DEC (101010) as b");
          System.out.println("Decimal= "+ rsbin.getInt(1));
           
          //DEC2BIN
          ResultSet rsdbin= statement.executeQuery("select DEC2BIN (25) as b");
          System.out.println("Binary= "+ rsdbin.getString("b"));
          
          //DEC2HEX
          ResultSet rshex= statement.executeQuery("select DEC2HEX (21) as b");
          System.out.println("Hexadecimal= "+ rshex.getInt(1));
          
          //HEX2DEC
          ResultSet rsdec= statement.executeQuery("select HEX2DEC ('A') as b");
          System.out.println("Decimal=  "+ rsdec.getInt(1));
          
          //REPEAT
          ResultSet rsrep = statement.executeQuery("select REPEAT('/Milos/',5) as b");
           while(rs.next())
           {
               System.out.println("Repeated chain= " + rsrep.getString("b"));
           }
          //PMT
          ResultSet rspmt = statement.executeQuery("select PMT(0.08,10,10000) as b");
          System.out.println("Value= "+ rspmt.getDouble(1));
          
          //COMPARESTRING
          ResultSet rscomp= statement.executeQuery("select COMPARESTRING('hannah', 'hanah') as b");
          System.out.println("String 1 > 2, return -1. If both are equal return 0. if the second string < 1 return 1");          
          System.out.println("Value= "+ rscomp.getInt(1));
            
            
        }catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                
                System.err.println(e);
            }
        }
    }

    public static Connection Connection(String fileDb)
    {
        File file = new File(fileDb);
        if (file.exists())
        {
            Connection conn = null;
            try {
                Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:" + fileDb;
                conn = DriverManager.getConnection(url);
                System.out.println("Conexión establecida con éxito");
                return conn;
            }catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        else
        {
            System.out.println("No se encontro la base de datos");
            return null;
        }
    }
    
}
