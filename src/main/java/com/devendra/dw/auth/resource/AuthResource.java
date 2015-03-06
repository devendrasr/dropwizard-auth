package com.devendra.dw.auth.resource;

import io.dropwizard.auth.Auth;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.validator.constraints.NotBlank;

import com.devendra.dw.auth.AuthConfiguration;
import com.devendra.dw.auth.model.User;
import com.sun.jersey.core.util.Base64;

/**
 * This class acts as a <b>Resource</b> to define some sample end points like login and greeting
 * 
 * @author d3v3ndrasr@gmail.com
 * @Since 06-Mar-2015
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    private AuthConfiguration configuration;

    public AuthResource(AuthConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * This Method gets invoked everytime the user hits a login api.
     * 
     * @param credentials
     * @return A BASE64 encoded token to be used in <b>Authorization</b> header as string : <b>Basic <token
     *         here></b> in every request other than login where AUTH is required.
     */
    @POST
    @Path("/login")
    public Response signIn(Credentials credentials) {
        if (credentials.getUsername().equalsIgnoreCase(configuration.getUsername())
                && credentials.getPassword().equalsIgnoreCase(configuration.getPassword())) {
            return Response.ok(
                    new String(Base64.encode(credentials.getUsername() + ":" + credentials.getPassword())))
                    .build();
        }
        return Response.status(Status.UNAUTHORIZED).build();
    }

    /**
     * This Method works as a secure end point. The method uses <b>@Auth</b> annotation hence this API will be
     * treated as a secure api and JERSEY will check for the AUTHORIZATION Header in this request, if not
     * found the request will be rejected and in case it is found the Authenticator will get invoked with the
     * decode username and password from the header.
     */
    @Path("/greeting/{name}")
    @GET
    public Response getGreeting(@PathParam("name") String name, @Auth User user) {
        return Response.ok(configuration.getGreeting() + " " + name).build();
    }

    /**
     * A sample DTO for mapping the username, password json payload.
     * 
     * @author Devendra
     * @Since 06-Mar-2015
     */
    public static final class Credentials {
        @NotBlank
        private String username;
        @NotBlank
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }
}
