/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.consumerws;

/**
 *
 * @author thuannht
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.viettel.passport.PassportWS;
import com.viettel.ws.consumer.base.CxfWsClientFactory;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import vp.client.ws.VpClientWs;

public class DemoClient {

    static String serviceUrl = "http://10.58.71.227:8181/wsdlEx/MathSrv?wsdl";
    static String serviceUrl2 = "http://10.58.71.64:8001/passportv3/passportWS?wsdl";

    public static void main(String[] args) {
        try {
            call2();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void call2() throws Exception {
        PassportWS passportWS = CxfWsClientFactory.createWsClient(PassportWS.class);
        System.out.println(passportWS.getAppFunctions("LOGISTICS") + "---------");
    }

    public static void call1() throws Exception {

        URL url = new URL(serviceUrl2);

        // Qualified name of the service:
        //   1st arg is the service URI
        //   2nd is the service name published in the WSDL
        QName qname = new QName("http://passport.viettel.com/", "passportWSService");

        // Create, in effect, a factory for the service.
        Service service = Service.create(url, qname);

        // Extract the endpoint interface, the service "port".
        PassportWS eif = service.getPort(PassportWS.class);
        System.out.println(eif.getAppFunctions("LOGISTICS") + "---------");

    }
}
