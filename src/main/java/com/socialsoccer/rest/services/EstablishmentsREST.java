/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialsoccer.jpa.entities.Establishments;
import com.socialsoccer.jpa.sessions.EstablishmentsFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ADMIN
 */
@Path ("establishments")
@Consumes (MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstablishmentsREST {
    @EJB
    private EstablishmentsFacade establishmentsEJB;
    
    @GET
    public List<Establishments> findAll(){
        return establishmentsEJB.findAll();
    }
    
    
    @POST
    public Response create(Establishments establishments){
        establishmentsEJB.create(establishments);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        
        try{
          establishmentsEJB.create(establishments); 
           return Response.status(Response.Status.OK)
                   .entity(gson.toJson("El establecimiento se registro correctamente"))
                   .build();
        } catch (Exception e){
            System.out.println("Err: " + e);
             return Response.status(Response.Status.BAD_REQUEST)
                   .entity(gson.toJson("Error al registrar el establecimiento"))
                   .build();
        }
    }
   
}
