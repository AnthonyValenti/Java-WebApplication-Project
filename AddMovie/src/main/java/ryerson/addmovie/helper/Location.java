/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.addmovie.helper;

/**
 *
 * @author student
 */
public class Location {
    private String address, managername;
    
    public Location(String address, String managername) {
        this.address = address;
        this.managername = managername;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getManagername() {
        return managername;
    }
}