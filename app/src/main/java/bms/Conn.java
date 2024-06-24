package bms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection c;
    Statement s;
    
    Conn(){
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection("jdbc:mysql:///bms", "root", "Password"); 
           s = c.createStatement();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
