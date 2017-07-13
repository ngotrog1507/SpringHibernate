/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.service.base.service.filter;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author hunglq9
 */
public class AuthenticationService {

    public boolean authenticate(String authCredentials) {

        if (null == authCredentials) {
            return false;
        }
        // header value format will be "Basic encodedstring" for Basic
        // authentication. Example "Basic YWRtaW46YWRtaW4="
        final String encodedUserPassword = authCredentials.replaceFirst("Basic"
                + " ", "");
        String usernameAndPassword = null;
        try {
            byte[] decodedBytes = Base64.decodeBase64(encodedUserPassword);
            usernameAndPassword = new String(decodedBytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final String[] arrUsPs = usernameAndPassword.split(":");
        final String username = arrUsPs[0];
        final String password = arrUsPs[1];

        // implement authentication or authorize here
        boolean authenticationStatus = "admin".equals(username)
                && "admin".equals(password);
        return authenticationStatus;
    }

}
