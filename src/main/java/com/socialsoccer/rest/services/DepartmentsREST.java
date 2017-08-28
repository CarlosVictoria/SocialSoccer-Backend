/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.rest.services;

import com.socialsoccer.jpa.entities.Departments;
import com.socialsoccer.jpa.sessions.DepartmentsFacade;
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
@Path("departments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentsREST {
    
    @EJB
    private DepartmentsFacade departmentEJB;
    
    @GET
    public List<Departments> findAll(){
        return departmentEJB.findAll();
    }
    @GET
    @Path("{idDepartment}")
    public Departments findBye(
    @PathParam("name")String name){
        return departmentEJB.find(name);
    }
    @POST
    public void create(Departments department){
        departmentEJB.create(department);
    }
}
