/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import com.sun.net.httpserver.Authenticator.Success;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view_massage.*;

/**
 *
 * @author Vista Soft IT
 */
public class DBconnection {
    
    private final static String BasedUrl="jdbc:mysql://";
    private final static String host="localhost";
    private final static String port="3306";
    private static String dbName="PAYROLL";   
    private final static String url=BasedUrl+host+":"+port+"/"+dbName;
    private static Connection connection=null;

    public static void setDbName(String dbName) {
        DBconnection.dbName = dbName;
    }
    
    
    public static Connection getConnection(){   
        
        System.out.println(dbName);
        
        if(dbName.length() > 0){
            try {
               // Class.forName("com.mysql.jdbc.Connection");
               connection=DriverManager.getConnection(url, "root", "");
               if(connection != null){
                   System.out.println("::Connected::");
                   //new SuccessMessage("Connect.", "Successfull connection with database");
               }
//               System.out.println("::Connected::");
//               new SuccessMessage("Connect","Database connected!");
               return connection;
            } catch (SQLException /*| ClassNotFoundException */ e) {
               new ErrorMessage("Database Not Connect", "Please check User Name, Password, Database Name");
               //Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    
}
