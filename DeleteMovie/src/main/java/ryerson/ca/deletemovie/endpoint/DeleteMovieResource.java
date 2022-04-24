/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.deletemovie.endpoint;

import ryerson.ca.deletemovie.business.DeleteMovie;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author student
 */
@Path("deletemovie")
public class DeleteMovieResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DeleteMovieResource
     */
    public DeleteMovieResource() {
    }

    /**
     * Retrieves representation of an instance of ryerson.deletemovie.endpoint.DeleteMovieResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * DELETE method for deleting an instance of DeleteMovieResource
     * @param id
     * @param content representation for the resource
     * @return 
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("update")
    public String deleteMovie(@FormParam("id") int id) 
    {
          DeleteMovie movie = new DeleteMovie();
          boolean deletedMovie = movie.deleteMovie(id);
          boolean updatedAddDb = movie.updateAddMovieDb(id);
          if(deletedMovie && updatedAddDb)
              return("Deleted");
          else
              return("Not Deleted");
          
    }

}
