package com.socialsoccer.rest.utils;

import com.socialsoccer.jpa.entities.Users;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendEmail {
    
   private static final String HOSTNAME = "smtp.gmail.com";
   private static final String EMAIL = "pruebas.software.rrv@gmail.com";
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
         sb.append("Bienvenido");
         sb.append("Plataforma SocialSoccer");
         sb.append("EJEMPLO");
         sb.append("<div>Esto es un div</div>");
         sb.append("Su nombre es : ");
         sb.append(user.getNames());
         
         email.setHtmlMsg(sb.toString());
         //End Contenido Email
         email.addTo(user.getEmail());
         email.send();
         
       } catch (EmailException e){
           System.out.println("ERROR" + e);
           
       }
   }
   
}
