/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.rest.services;

import com.socialsoccer.jpa.entities.SoccerFieldTypes;
import com.socialsoccer.jpa.sessions.SoccerFieldTypesFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ADMIN
 */
@Path("soccer_field_types")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SoccerFieldTypesREST {
    @EJB
    private SoccerFieldTypesFacade soccerFieldTypeEJB;

    /**
     * Obtiene los tipos documentos de la BD
     * @return Lista de tipoDocumento
     */
    
    @GET
    public List<SoccerFieldTypes> findAll(){
        return soccerFieldTypeEJB.findAll();
    }
    
    /**
     * Busca tipoDocumento por su id
     * @param id
     * @return tipoDocumento
     */
    @GET
    @Path("{idSoccerFieldType}")
    public SoccerFieldTypes findById(
            @PathParam("idSoccerFieldType") Integer id){
        return soccerFieldTypeEJB.find(id);
    }
    
    
    /*metodo para crear un tipo de cancha*/
    @POST
    public void create(SoccerFieldTypes soccerFieldType){
        soccerFieldTypeEJB.create(soccerFieldType);
    }
}
