/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.service.base.service.filter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

/**
 *
 * @author thuannht
 */

public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext ctx = servletContextEvent.getServletContext();
            String igniteConfigurationFilePath = ctx.getInitParameter("IgniteConfigurationFilePath");
            URL url = ctx.getResource(igniteConfigurationFilePath);
            Ignite ignite = Ignition.start(url);//ignite.cache("cacheErp");
            System.out.println(ignite);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();            
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        ServletContext ctx = servletContextEvent.getServletContext();

    }

}
