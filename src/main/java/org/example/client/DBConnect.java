package org.example.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Narayan
 */

public class DBConnect {

    private static Connection conn;
    private static String url = "jdbc:mysql://127.0.0.1:3306/rootdatabase?serverTimezone=UTC";
    private static String user = "root";
    private static String pass = "Muhammad@2020";

    public static Connection connect() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }catch(ClassNotFoundException cnfe){
            System.err.println("Error: "+cnfe.getMessage());
        }catch(InstantiationException ie){
            System.err.println("Error: "+ie.getMessage());
        }catch(IllegalAccessException iae){
            System.err.println("Error: "+iae.getMessage());
        }

        conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn !=null && !conn.isClosed())
            return conn;
        connect();
        return conn;

    }
}