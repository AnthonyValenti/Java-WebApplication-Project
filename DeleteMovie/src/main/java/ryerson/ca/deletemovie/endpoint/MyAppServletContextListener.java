/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.deletemovie.endpoint;

/**
 *
 * @author student
 */
import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ryerson.ca.deletemovie.business.Messaging;


public class MyAppServletContextListener 
               implements ServletContextListener{
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    /**
     *
     * @param arg0
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
    Runnable r = new Runnable() {
        @Override
        public void run() {
            
            try {
                Messaging.Receiving_Events_Store("added_movie_channel");
            } catch (SSLException | ServerAddressNotSuppliedException ex) {
                Logger.getLogger(MyAppServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    };
     
    new Thread(r).start();
    }
}