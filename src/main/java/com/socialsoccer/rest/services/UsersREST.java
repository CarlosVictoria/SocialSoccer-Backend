/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialsoccer.jpa.entities.Users;
import com.socialsoccer.jpa.sessions.UsersFacade;
import com.socialsoccer.rest.auth.DigestUtil;
import com.socialsoccer.rest.utils.SendEmail;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersREST {
    @EJB
    private UsersFacade userEJB;
    
    
    /*metodo para listar todos los usuarios*/
    @GET
    @RolesAllowed({"ADMIN"})
    public List<Users> findAll() {
        return userEJB.findAll();
    }
    
    
    /*metodo para obtener el usuario por medio del id*/
    @GET
    @Path("{idUsers}")
    public Users findById(
            @PathParam("idUsers") Integer idUsers){
        return userEJB.find(idUsers);
    }
    
    
    /*metodo para crear un usuario*/
@POST
public Response create (Users user){
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
    
    
    try{   
        if(userEJB.findUserByEmail(user.getEmail())== null){
             if (userEJB.findUserByNumDocument(user.getNumDocument()) == null){
                user.setPassword(DigestUtil.cifrarPassword(user.getPassword()));
                user.setPhotoUser("default.jpg");
                userEJB.create(user);
                
            SendEmail enviarEmail = new SendEmail();
            enviarEmail.sendEmailRegistroUsuario(
                        user, "password");
           
                    return Response.status(Response.Status.CREATED)
                            .entity(gson.toJson("El usuario se registro correctamente"))
                            .build();  
             }else {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(gson.toJson("El numero de documento ya existe."))
                            .build();
                }
        }else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(gson.toJson("El email ya existe."))
                        .build();
            }
    }catch (Exception e) {
            System.out.println("Err" + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el usuario"))
                    .build();
        }
}

/*metodo para actualizar los datos de un usuario*/

    @PUT
    @Path("{idUsers}")
    public Response edit(@PathParam("idUsers") Integer idUsers, Users user){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try{
        userEJB.edit(user);
        return Response.status(Response.Status.CREATED)
               .entity(gson.toJson("El usuario se actualizo correctamente"))
                .build();
       }catch (Exception e){
            System.out.println("err" + e);
               return Response.status(Response.Status.BAD_REQUEST)
                       .entity(gson.toJson("El usuario no se púdo actualizar"))
                       .build();
               }
            }

}
