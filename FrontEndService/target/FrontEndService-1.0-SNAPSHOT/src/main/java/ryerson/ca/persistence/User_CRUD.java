/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.persistence;

import ryerson.ca.helper.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * User_CRUD provides methods for CRUD operations for the user's view.
 * 
 * @author Kevin Tran, 
 */
public class User_CRUD {
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
    
    private static Connection connectAddDb() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addmovie_MMS?serverTimezone=UTC", "root", "student");
            String con = System.getenv("addmovieDB");
            //String con = "35.203.126.202:3306";
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
     * Returns User object in the database based on the parameters, 
     * otherwise null if not found.
     * 
     * @param user - the selected username
     * @param pass - the selected password
     * @return User object.
     */
    public static User readUser(String username, String pass) {
        Connection connection = connect();
        String update = "SELECT * FROM User WHERE username = \"" + username
                + "\" AND password = \"" + pass + "\"";
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement(update);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("points"));
            }
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return user;
    }
    
    /**
     * Based on the selected username, set their points to the new points.
     * 
     * @param user - the selected username
     * @param points - the new points to be assigned to the username
     */
    public static void updatePoints(String user, int points) {
        Connection connection = connect();
        String update = "UPDATE User SET points = " + points
                + " WHERE username = \"" +  user + "\"";
        try {
            PreparedStatement ps = connection.prepareStatement(update);
            ps.executeUpdate();
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * Returns an ArrayList containing all the movies in the form of 
     * Movie objects in the database.
     * 
     * @return ArrayList of every movie object;
     */
    public static ArrayList<Movie> readMovieList() {
        Connection connection = connectAddDb();
        String read = "SELECT * FROM Movie";
        ArrayList<Movie> movies = new ArrayList<Movie>();
        try {
            PreparedStatement ps = connection.prepareStatement(read);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Movie movie = new Movie(rs.getInt("movie_id"), 
                        rs.getString("movie_name"),
                        rs.getInt("available_seats"),
                        rs.getString("movie_date"),
                        rs.getString("movie_time"),
                        rs.getString("address"));
                movies.add(movie);
            }
            connection.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return movies;
    }
    

}