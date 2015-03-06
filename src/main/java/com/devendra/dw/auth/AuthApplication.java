package com.devendra.dw.auth;

import io.dropwizard.Application;
import io.dropwizard.auth.basic.BasicAuthProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.devendra.dw.auth.model.User;
import com.devendra.dw.auth.resource.AuthResource;

/**
 * This class contains the entry point of the application.
 * 
 * @author d3v3ndrasr@gmail.com
 * @Since 06-Mar-2015
 */
public class AuthApplication extends Application<AuthConfiguration> {

    public static void main(String[] args) throws Exception {
        new AuthApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<AuthConfiguration> bootstrap) {
        // Do some initialization stuff here like INITIALIZING the GUICE Modules, adding ASSET bundles etc.
    }

    @Override
    public void run(AuthConfiguration configuration, Environment environment) throws Exception {
        // Setting /api ast the default base url pattern here.
        environment.jersey().setUrlPattern("/api/*");
        // Registering authentication resource to JERSEY
        environment.jersey().register(new AuthResource(configuration));
        // Registering the authenticator here.
        environment.jersey().register(
                new BasicAuthProvider<User>(new BasicAuthenticator(configuration), "SUPER SECRET"));
    }
}
