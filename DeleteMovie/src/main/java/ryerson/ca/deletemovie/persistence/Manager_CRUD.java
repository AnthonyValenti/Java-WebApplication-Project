/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.deletemovie.persistence;

import ryerson.ca.deletemovie.helper.Manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
        
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
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/deletemovie_MMS?serverTimezone=UTC", "root", "student");
            String con = System.getenv("DB_URL");
            connection = DriverManager.getConnection("jdbc:mysql://"+con+
                    "/deletemovie_MMS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
            System.out.println("Connection to DBMS successful");
            // Handle any errors that may have occurred.
        } catch (Exception e) {
            System.out.println("Connection to DBMS unsuccessful");
            System.out.println(e);
        }
        return connection;
    }
    private static Connection connectAddDb() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addmovie_MMS?serverTimezone=UTC", "root", "student");
            String con = System.getenv("addmovieDB");
            connection = DriverManager.getConnection("jdbc:mysql://"+con+
                    "/addmovie_MMS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");
            System.out.println("Connection to DBMS successful");
            // Handle any errors that may have occurred.
        } catch (Exception e) {
            System.out.println("Connection to DBMS unsuccessful");
            System.out.println(e);
        }
        return connection;
    }
    
    /**
     * Creates a new row for the Manager table in the database based on the 
     * parameters below and returns true if creation is successful, otherwise
     * false.
     * 
     * @param managername - the username for managers
     * @param pass - the password
     * @param fullName - the full name of the manager
     * @return true if creation of user row is successful;
     */
    public static boolean createManager(String managername, String pass, String fullName) {
        Connection connection = connect();
        String create = "INSERT INTO Manager VALUES (\"" + managername + "\", \"" 
                + pass + "\", \"" + fullName + "\")";
        try {
            PreparedStatement ps = connection.prepareStatement(create);
            ps.executeUpdate();
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
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
    
    /**
     * Creates a new row for the Location table in the database based on the 
     * parameters below and returns true if creation is successful, otherwise
     * false. Note that the manager's username needs to match the one in the
     * database.
     * 
     * @param address - the address of the location
     * @param manager - the manager's username
     * @return - true if creation of Location row is successful;
     */
    public static boolean createLocation(String address, String manager) {
        Connection connection = connect();
        //INSERT INTO Location Values(address, manager)
        String create = "INSERT INTO Location VALUES (\"" + address + "\", \"" 
                + manager + "\"";
        try {
            PreparedStatement ps = connection.prepareStatement(create);
            ps.executeUpdate();
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    /**
     * Creates a new row for the Movie table in the database based on the 
     * parameters below and returns true if creation is successful, otherwise
     * false. Note that the address needs to match the one in the database.
     * 
     * @param name - name of the movie
     * @param date - date of the movie screening
     * @param seats - seats available for the screening
     * @param address - address location of the screening
     * @param time - time slot of the screening, specific format is 00:00-23:59 (exactly 11 characters)
     * @return 
     */
    public static boolean createMovie(String name, String date, int seats, String address, String time) {
        Connection connection = connect();
        String create = "INSERT INTO Movie VALUES (null, \"" + name + "\", '" + date
                + "', \"" + seats + "\", \"" + address + "\", \"" + time + "\")";
        try {
            PreparedStatement ps = connection.prepareStatement(create);
            ps.executeUpdate();
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    /**
     * Returns true if the the selected movie is deleted, otherwise false;
     * 
     * @param id - the id of the movie that is to be deleted
     * @return true if the movie is deleted, otherwise false
     */
    public static boolean deleteMovie(int id) {
        Connection connection = connect();
        String delete = "DELETE FROM Movie WHERE movie_id = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.executeUpdate();
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
     public static boolean deleteMovieFromAddDb(int id) {
        Connection connection = connectAddDb();
        String delete = "DELETE FROM Movie WHERE movie_id = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.executeUpdate();
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
