/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author hunglq9
 */
@org.apache.cxf.feature.Features(features = "org.apache.cxf.feature.LoggingFeature")
@WebService(targetNamespace = "http://webservice.erp.viettel.com/")
public interface HelloWorld {

    @WebMethod(operationName = "sayHi")
    String sayHi(@WebParam(name = "text") String text);
}
