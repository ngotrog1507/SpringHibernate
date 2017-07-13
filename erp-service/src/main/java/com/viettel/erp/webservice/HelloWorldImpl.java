/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.webservice;

/**
 *
 * @author hunglq9
 */
import javax.jws.WebService;

@WebService(endpointInterface = "com.viettel.erp.webservice.HelloWorld")

public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello " + text;
    }
}
