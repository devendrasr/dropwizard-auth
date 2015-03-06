package com.devendra.dw.auth.model;

/**
 * This class works as a model to be used as a Principal for Basic Authenticator.
 * 
 * @author d3v3ndrasr@gmail.com
 * @Since 06-Mar-2015
 */
public class User {
    private String username;
    private String fName;
    private String lName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

}
