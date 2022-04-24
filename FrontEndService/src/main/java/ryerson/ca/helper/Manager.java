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
public class Manager {
    private String managername, password, fullName;
    
    public Manager(String managername, String password, String fullName) {
        this.managername = managername;
        this.password = password;
        this.fullName = fullName;
    }
    
    public String getManagername() {
        return managername;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getFullName() {
        return fullName;
    }
}
