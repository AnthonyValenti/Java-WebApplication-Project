/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.deletemovie.business;

import ryerson.ca.deletemovie.persistence.Manager_CRUD;

/**
 *
 * @author student
 */
public class DeleteMovie {
    
    public boolean deleteMovie(int id) {
        return Manager_CRUD.deleteMovie(id);
    }
    
    public boolean updateAddMovieDb(int id){
        return Manager_CRUD.deleteMovieFromAddDb(id);
    }
}