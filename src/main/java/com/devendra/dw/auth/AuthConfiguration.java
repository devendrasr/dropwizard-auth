package com.devendra.dw.auth;

import io.dropwizard.Configuration;

/**
 * This class contains the initial configuratoin for dropwizard like username and password configured in the
 * yaml file.
 * 
 * @author d3v3ndrasr@gmail.com
 * @Since 06-Mar-2015
 */
public class AuthConfiguration extends Configuration {
    private String greeting;
    private String username;
    private String password;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

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
