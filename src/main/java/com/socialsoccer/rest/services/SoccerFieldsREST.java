/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.rest.services;

import com.socialsoccer.jpa.entities.SoccerFields;
import com.socialsoccer.jpa.sessions.SoccerFieldsFacade;
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
@Path("soccer_fields")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SoccerFieldsREST {
    @EJB
    private SoccerFieldsFacade soccerFieldEJB;
    
    @GET
    public List<SoccerFields> findAll(@QueryParam("establecimiento") Integer establecimiento){
        return soccerFieldEJB.findByEstablecimiento(establecimiento);
    }
   @GET
    @Path("{idSoccerFields}")
    public SoccerFields findById(
            @PathParam("idSoccerFields") Integer id_soccer_fields){
        return soccerFieldEJB.find(id_soccer_fields);
    }
    
    @POST
    public void create(SoccerFields soccerField){
        soccerFieldEJB.create(soccerField);
    }
}
