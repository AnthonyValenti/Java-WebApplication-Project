/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.addmovie.endpoint;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import ryerson.addmovie.business.*;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ryerson.addmovie.helper.Movie;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("addmovie")
public class AddMovieResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AddMovieResource
     */
    public AddMovieResource() {
    }

    /**
     * Retrieves representation of an instance of ryerson.addmovie.endpoint.AddMovieResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of AddMovieResource
     * @param name
     * @param date
     * @param seats
     * @param address
     * @param time
     * @param content representation for the resource
     * @return 
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws io.kubemq.sdk.basic.ServerAddressNotSuppliedException
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("update")
    public String  addMovie(@FormParam("name") String name, 
                            @FormParam("date") String date,
                            @FormParam("seats") int seats,
                            @FormParam("address") String address,
                            @FormParam("time") String time) throws ClassNotFoundException, SQLException, ServerAddressNotSuppliedException, IOException, InterruptedException 
    {
          AddMovie movie = new AddMovie();
          boolean addedMovie = movie.addMovie(name, date, seats, address, time);

          if(addedMovie){
                //movie.sendMessageToDeleteService(name, date, seats, address, time);
                return("Added");
          }
          else
              return("Not Added");
          
    }
    
  
   
    
  
}
