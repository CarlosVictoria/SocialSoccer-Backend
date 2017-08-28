/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.rest.services;

import com.socialsoccer.jpa.entities.Cities;
import com.socialsoccer.jpa.sessions.CitiesFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ADMIN
 */
@Path ("cities")
@Consumes (MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CitiesREST {
    @EJB
    private CitiesFacade cityEJB;
    
    @GET
    public List<Cities> findAll(){
        return cityEJB.findAll();
    }
    @GET
    @Path("{idCities}")
    public Cities findBye(
    @PathParam("name")String name){
        return cityEJB.find(name);
    }
    
    @GET
    @Path("find")
    public List<Cities> findByNombre(
        @QueryParam("name") String nameCity,
        @QueryParam("idDepartment") Integer idDepartment){
        return cityEJB.findCityByName(nameCity, idDepartment);
    }
    
    @POST
    public void create(Cities city){
        cityEJB.create(city);
    }
}
