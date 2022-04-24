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
public class Movie {
    private int id, openSeats;
    private String date, time, address, name;
    
    public Movie(int id, String name, int openSeats, String date, String time, String address) {
        this.id = id;
        this.name = name;
        this.openSeats = openSeats;
        this.date = date;
        this.time = time;
        this.address = address;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getOpenSeats() {
        return openSeats;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getTime() {
        return time;
    }
    
    public String getAddress() {
        return address;
    }
}
