/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.rest.services;

import com.socialsoccer.jpa.entities.DocumentTypes;
import com.socialsoccer.jpa.sessions.DocumentTypesFacade;
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
@Path("document_types")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentTypesREST {
    @EJB
    private DocumentTypesFacade documentTypeEJB;

    /**
     * Obtiene los tipos documentos de la BD
     * @return Lista de tipoDocumento
     */
    @GET
    public List<DocumentTypes> findAll(){
        return documentTypeEJB.findAll();
    }
    
    /**
     * Busca tipoDocumento por su id
     * @param id
     * @return tipoDocumento
     */
    @GET
    @Path("{idDocumentTypes}")
    public DocumentTypes findById(
            @PathParam("idDocumentTypes") Integer id){
        return documentTypeEJB.find(id);
    }
    
    @POST
    public void create(DocumentTypes documentType){
        documentTypeEJB.create(documentType);
    }
}
