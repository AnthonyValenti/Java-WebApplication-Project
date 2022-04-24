/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.addmovie.business;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.sql.SQLException;
import ryerson.addmovie.persistence.Manager_CRUD;

/**
 *
 * @author student
 */
public class AddMovie {
    
    public boolean addMovie(String name, String date, int seats, String address, String time) {
        return Manager_CRUD.createMovie(name, date, seats, address, time);
    }
    public void sendMessageToDeleteService(String name, String date, int seats, String address, String time) throws ClassNotFoundException, SQLException, ServerAddressNotSuppliedException, IOException, InterruptedException {
    
        Messaging.sendmessage("ADDMOVIE:" + name + ":" + date + ":" + seats + ":"+ address + ":"+ time);
        
    }
}