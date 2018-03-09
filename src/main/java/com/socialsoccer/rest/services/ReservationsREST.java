/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialsoccer.jpa.entities.Reservations;
import com.socialsoccer.jpa.sessions.ReservationsFacade;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author ADMIN
 */
@Path ("reservations")
@Consumes (MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservationsREST {
    @EJB
    private ReservationsFacade reservationsEJB;
    
    /*@GET
    public List<Reservations> findAll(){
        return reservationsEJB.findAll();
    }*/
    
    @GET
    @Path("{idReservations}")
    public Reservations findById(
            @PathParam("idReservations") Integer id_reservations){
        return reservationsEJB.find(id_reservations);
    }
    
    @GET
    public List<Reservations> findByIdUser(
            @QueryParam("idUser") Integer idUser){
        return reservationsEJB.findReservationByIdUser(idUser);
    }
    
    @POST
    public Response create(Reservations reservations) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            if (reservationsEJB.checarDisponibilidad(reservations.getIdSoccerFields().getIdSoccerFields(),
                    reservations.getDate(), reservations.getInitialHour(),
                    reservations.getFinalHour()) == true) {
                reservationsEJB.create(reservations);
                return Response.status(Response.Status.OK)
                        .entity(gson.toJson("Creada exitosamente"))
                        .build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(gson.toJson("La cancha ya ha sido reservada a esa hora"))
                        .build();
            }

        } catch (Exception e) {
            System.out.println("Err: " + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar la reserva."))
                    .build();
        }
    }
   
}
   
