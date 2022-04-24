/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ryerson.ca.helper.*;
        
/**
 * Manager_CRUD provides methods for CRUD operations for manager's view.
 *
 * @author Kevin Tran
 */
public class Manager_CRUD {
    /**
     * Private method to connect to the database before enacting SQL operations
     * 
     * @return Connection object to the database
     */
    private static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts_MMS?serverTimezone=UTC", "root", "student");
            String con = System.getenv("accountsDB");
            //String con = "35.203.0.93:3306";
            connection = DriverManager.getConnection("jdbc:mysql://"+con+
                    "/accounts_MMS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
            System.out.println("Connection to DBMS successful");
            // Handle any errors that may have occurred.
        } catch (Exception e) {
            System.out.println("Connection to DBMS unsuccessful");
            System.out.println(e);
        }
        return connection;
    }
    
   
    
    /**
     * Returns Manager object in the database based on the parameters, 
     * otherwise null if not found.
     * 
     * @param managername - the selected username for managers
     * @param pass - the selected password
     * @return Manager object.
     */
    public static Manager readManager(String managername, String pass) {
        Connection connection = connect();
        String read = "SELECT * FROM Manager WHERE managername = \"" + managername
                + "\" AND password = \"" + pass + "\"";
        Manager manager = null;
        try {
            PreparedStatement ps = connection.prepareStatement(read);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                manager = new Manager(rs.getString("managername"),
                        rs.getString("password"),
                        rs.getString("full_name"));
            }
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return manager;
    }
    
   
}
