package com.socialsoccer.rest.utils;

import com.socialsoccer.jpa.entities.Users;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendEmail {
    
   private static final String HOSTNAME = "smtp.gmail.com";
   private static final String EMAIL = "SocialSoccer@gmail.com";
   private static final String PASSWORD = "prueba2016";
   private static final int PUERTO = 465;
   private static final boolean ISSSL = true;
   private static final boolean ISAUTHENTICATION = true;
   
   public void sendEmailRegistroUsuario(Users user, 
           String pass){
                 
       try{
           HtmlEmail email = new HtmlEmail();
           email.setHostName(HOSTNAME);
           email.setSmtpPort(PUERTO);
           email.setAuthenticator(
               new DefaultAuthenticator(EMAIL, PASSWORD));
         if(ISAUTHENTICATION){
          email.setAuthentication(EMAIL, PASSWORD);
       }
       
         email.setSSLOnConnect(ISSSL);
         email.setFrom(EMAIL);
         email.setCharset("UTF-8");
         email.setSubject("Registro OK");
         
         //Start Contenido Email
         StringBuilder sb = new StringBuilder ();
         sb.append("<div><strong><h1 style='text-align:center; color: black;'>Social Soccer</h1></strong></div>");
         sb.append("<div><img data-imagetype='External' class:'img-responsive' src='https://2.bp.blogspot.com/-nVEO32c4j9o/V8Da1d6MmhI/AAAAAAAAAWM/beB6Fi_VQKQwdXsI0-Nlnp5wxydJ-5u3gCLcB/s1600/bienvenido.png' style='text-align:center;'></div>");
         sb.append("<p style='display:inline-block; text-align: center; color: black;'>Hola, </p>");
         sb.append(" ");
         sb.append(user.getNames());
         sb.append(" ");
         sb.append(user.getLastNames());  
         sb.append("<p style='text-align: center; font-size 20px; color black;'>Ahora que estas registrado, podras hacer tus reservas de forma facil y efectiva<p>");
         sb.append("<p style='display:block' style='text-align:center;'>Gracias por elegirnos</p>");
         
         email.setHtmlMsg(sb.toString());
         //End Contenido Email
         email.addTo(user.getEmail());
         email.send();
         
       } catch (EmailException e){
           System.out.println("ERROR" + e);
           
       }
   }
   
}
