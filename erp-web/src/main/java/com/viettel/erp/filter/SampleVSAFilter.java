/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import viettel.passport.client.UserToken;

/**
 *
 * @author hanhls1-local
 */
public class SampleVSAFilter implements Filter{
    private static Logger logger = Logger.getLogger(SampleVSAFilter.class);
    @Override
    public void init(FilterConfig fc) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        
                HttpServletRequest req = null;
         if ((request instanceof HttpServletRequest)) {
            req = (HttpServletRequest) request;
        }
         String url=req.getRequestURI();
         HttpSession session=req.getSession();
         if(url.contains("login.html")){
             logger.info("Thực hiện login chuyển user");
             String userToken=req.getParameter("info");
               UserToken utoToken=new UserToken();
             String[] userTokenProperties=userToken.split("_");
             if (userTokenProperties.length > 0) {
                 utoToken.setUserID(Long.parseLong(userTokenProperties[0]));//Users_id
             }
             if (userTokenProperties.length > 1) {
                 utoToken.setUserID(Long.parseLong(userTokenProperties[1]));//groups_id
             }
             if (userTokenProperties.length > 2) {
                 utoToken.setEmail(userTokenProperties[2]);//employee_id
             }
              
              session.setAttribute("vsaUserToken", userToken);
             
         }
         fc.doFilter(request, sr1);

//        
//        UserToken us=new UserToken();
//        us.setUserID(1000);
//        us.setPa
//                
//         session.setAttribute("vsaUserToken", stValidator.getUserToken());
//      session.setAttribute("netID", stValidator.getUser());
//      session.setAttribute("VTS-IP", ip);
//      session.setAttribute("VTS-MAC", mac);
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
