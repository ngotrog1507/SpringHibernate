/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.webservice;

import com.viettel.erp.dto.ActIdUserDTO;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author hunglq9
 */
@org.apache.cxf.feature.Features(features = "org.apache.cxf.feature.LoggingFeature")
@WebService(targetNamespace = "http://webservice.erp.viettel.com/")
public interface UserWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    
    public long getUserCount(@WebParam(name = "txt") String txt);

    //
    @WebMethod(operationName = "getAllUsers")
    public List<ActIdUserDTO> getAllUsers();
    
    //
    @WebMethod(operationName = "countWord")
    public Integer countWord(@WebParam(name = "txt") String txt);

}
