/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.socialsoccer.rest.services;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author ADMIN
 */
@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig{
    public ApplicationConfig() {
        packages("com.socialsoccer.rest.services;com.socialsoccer.rest.auth");
        register(RolesAllowedDynamicFeature.class);
    }
}
