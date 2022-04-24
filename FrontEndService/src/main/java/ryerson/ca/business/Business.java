/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.business;

/**
 *
 * @author student
 */


import java.util.ArrayList;
import ryerson.ca.helper.*;
import ryerson.ca.persistence.*;

/**
 *
 * @author student
 */
public class Business {

    public static boolean isAuthenticated(String username, String password) {
        User currentUser = User_CRUD.readUser(username, password);
        if(currentUser == null){
            return false;
        }
        else{
            return true;
        }

    }
    public static boolean isAuthenticatedManager(String username, String password) {
        Manager currentManager = Manager_CRUD.readManager(username, password);
        if(currentManager == null){
            return false;
        }
        else{
            return true;
        }
               

    }
    
    public static ArrayList<Movie> getMovies(){
        return User_CRUD.readMovieList();
   
    }


  
    
  
    




}