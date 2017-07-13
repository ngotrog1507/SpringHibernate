/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.service.base.security;

import java.io.IOException;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

/**
 *
 * @author HungLQ9
 */
public class ServerPasswordCallback implements CallbackHandler {

    public void handle(javax.security.auth.callback.Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        if (pc.getIdentifier().equals("admin")) {
            // set the password on the callback. This will be compared to the
            // password which was sent from the client.
            pc.setPassword("admin");
        }
    }
}
