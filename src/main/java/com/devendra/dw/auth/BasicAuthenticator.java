package com.devendra.dw.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devendra.dw.auth.model.User;
import com.google.common.base.Optional;

/**
 * This class works as the authenticator for this application. <br>
 * Everytime a user sendd the AUTHORIZATION header (Basic <Base64 encode username:password>) in the request,
 * the USERNAME and PASSWORD get decoded and get JERSEY calls the authenticate method below after setting the
 * USERNAME & PASSWORD in the BasicCredentials object.
 * 
 * @author d3v3ndrasr@gmail.com
 * @Since 06-Mar-2015
 */
public class BasicAuthenticator implements Authenticator<BasicCredentials, User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicAuthenticator.class);

    private AuthConfiguration configuration;

    public BasicAuthenticator(AuthConfiguration configuration) {
        this.configuration = configuration;
    }

    /**
     * Jersey calls this method after decoding and setting the username, password from the AUTHORIZATION
     * header.<br>
     * Note- The method will be invoked only if the called endpoint or api is having @Auth annotation used in
     * the parameters.
     */
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        LOGGER.debug("got credentials: {}", credentials);
        if (credentials.getPassword().equals(configuration.getPassword())
                && credentials.getUsername().equals(configuration.getUsername())) {
            User user = new User();
            user.setUsername(credentials.getUsername());
            return Optional.of(user);
        }
        return Optional.absent();
    }
}
