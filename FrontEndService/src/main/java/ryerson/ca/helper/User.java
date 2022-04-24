/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.helper;

/**
 *
 * @author student
 */
public class User {
    private String username, password;
    private int points;
    
    public User(String username, String password, int points) {
        this.username = username;
        this.points = points;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public int getPoints() {
        return points;
    }
    
    public String getPassword() {
        return password;
    }
}
