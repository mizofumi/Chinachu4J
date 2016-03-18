package net.mizofumi.chinachu4j;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Created by mizofumi on 2016/03/18.
 */
public class BasicAuthenticator extends Authenticator {

    public String username;
    public String password;

    public BasicAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username,password.toCharArray());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
