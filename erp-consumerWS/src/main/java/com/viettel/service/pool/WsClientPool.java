/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.service.pool;

import com.viettel.ws.consumer.base.CxfWsClientFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.pool2.impl.GenericObjectPool;

/**
 *
 * @author thuannht
 */
public class WsClientPool {

    public static <T> T getWsClient(Class<T> interfaceClass) throws Exception {
        try {
            String serviceName = interfaceClass.getTypeName();
            return (T) CxfWsClientFactory.mapPool.get(serviceName).borrowObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    public static <T> void closeWsClient(T wsClient) throws Exception {
        try {
            String serviceName = wsClient.getClass().getTypeName();
            CxfWsClientFactory.mapPool.get(serviceName).returnObject(wsClient);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
