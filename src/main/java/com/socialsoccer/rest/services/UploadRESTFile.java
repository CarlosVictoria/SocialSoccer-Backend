
package com.socialsoccer.rest.services;

import com.socialsoccer.jpa.entities.Users;
import com.socialsoccer.jpa.sessions.UsersFacade;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("upload")
@Produces(MediaType.APPLICATION_JSON)
public class UploadRESTFile {
        //Se debe cambiar por la URL donde se quiera guardar la imagen
    private static final String UPLOAD_FOLDER = "/home/adsi1261718/Documentos/JULIAN/SocialSoccer-Fronted/client/assets/images/Photos/";
    private static final String UPLOAD_FOLDER_USUARIOS = "/home/adsi1261718/Documentos/JULIAN/Proyecto Startup/SocialSoccer-Fronted/client/assets/images/Photos/";

    @EJB
    private UsersFacade usersEJB;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream in,
            @FormDataParam("file") FormDataContentDisposition info,
            @FormDataParam("idUser") Integer idUser) throws IOException {
        
        System.out.println("ID "+idUser);
        File upload = new File(UPLOAD_FOLDER.concat(info.getFileName()));

        try {
            if (upload.exists()) {
                String message = "file: " + upload.getName() + " already exists";
                return Response.status(Response.Status.CONFLICT).entity(message).build();
            } else {
                
                Files.copy(in, upload.toPath());
                Users user = usersEJB.find(idUser);
                user.setPhotoUser(upload.getName());
                usersEJB.edit(user); 
                return Response.status(Response.Status.OK).build();
            }
        } catch (IOException e) {
            return Response.status(Response.Status.CONFLICT).entity(e).build();
        }

    }

    @POST
    @Path("user")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFileUsuario(@FormDataParam("idUser") Integer idUser,
            @FormDataParam("file") InputStream in,
            @FormDataParam("file") FormDataContentDisposition info) throws IOException {

        File upload = new File(UPLOAD_FOLDER_USUARIOS.concat(info.getFileName()));

        try {
            while (upload.exists()) {
               int rand = (int) (Math.random()*1000000);
               upload = new File(UPLOAD_FOLDER_USUARIOS.concat(String.valueOf(rand)).concat(info.getFileName()));
            } 
                Files.copy(in, upload.toPath());
                Users user = usersEJB.find(idUser);
                user.setPhotoUser(upload.getName());
                usersEJB.edit(user);
                return Response.status(Response.Status.OK).build();
            
        } catch (IOException e) {
            return Response.status(Response.Status.CONFLICT).entity(e).build();
        }

    }
}
