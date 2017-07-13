/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.service.pool;

import com.viettel.ws.consumer.base.CxfWsClientFactory;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 *
 * @author thuannht
 */
public class WsClientPoolFactory<T> extends BasePooledObjectFactory<T> {

    private String serviceName;

    public WsClientPoolFactory(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public T create() throws Exception {
        try {
            return (T) CxfWsClientFactory.createWsClient(this.serviceName);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    /**
     * Use the default PooledObject implementation.
     */
    @Override
    public PooledObject<T> wrap(T wsClient) {
        return new DefaultPooledObject<T>(wsClient);
    }

    /**
     * When an object is returned to the pool, clear the wsClient.
     */
    @Override
    public void passivateObject(PooledObject<T> pooledObject) {
    }

    // for all other methods, the no-op implementation
    // in BasePooledObjectFactory will suffice
}
