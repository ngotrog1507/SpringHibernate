/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.consumerws;

import com.viettel.erp.dto.ActIdUserDTO;
import com.viettel.service.base.dto.DataListDTO;
import com.viettel.ws.consumer.base.CxfRsClientFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author HungLQ9
 */
public class DemoRestClient {

    private static String urlBase = "http://10.58.71.227:8787/erp-service/userServiceRest";

    public static void main(String[] args) {
        // 
        testPOSTRequest();
        testGETRequest();
        //

    }

    private static void testPOSTRequest() {
        try {
            WebClient client = CxfRsClientFactory.createRsClient(urlBase);
            client.path("user");
            // create object to post
            ActIdUserDTO dto = new ActIdUserDTO();
            dto.setId(1245l);
            dto.setEmail("hunglq");
            dto.setFirst("Osama");
            dto.setLast("Binladin");
            dto.setPwd("123s");
            dto.setRev(1l);
            // 
            Response response = client.post(dto);
            int status = response.getStatus();
            System.out.println("response status : " + status);
            String output = response.readEntity(String.class);
            System.out.println("");
            System.out.println("response json out: " + output);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void testGETRequest() {
        try {
            WebClient client = CxfRsClientFactory.createRsClient(urlBase);
            client.path("user");
            // 
            System.out.println("get info from : " + urlBase + "user");
            Response response = client.get();
            int status = response.getStatus();
            System.out.println("response status : " + status);
            String output = response.readEntity(String.class);
            System.out.println("response json out: " + output);
            //JSON string to Object
            ObjectMapper mapper = new ObjectMapper();
            DataListDTO obj = mapper.readValue(output, DataListDTO.class);
            List<ActIdUserDTO> list = new ArrayList<ActIdUserDTO>(obj.getData());
            List<ActIdUserDTO> myObjects = Arrays.asList(mapper.readValue(mapper.readTree(output).path("data"), ActIdUserDTO[].class));
            System.out.println(myObjects.get(0).getFirst());
            System.out.println(output);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
