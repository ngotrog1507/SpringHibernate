/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.controller;

import com.viettel.erp.base.BaseController;

import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import viettel.passport.client.UserToken;

@Controller
public class HomeController extends BaseController {

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        try {
//            UserToken vsaUserToken = (UserToken) getHttpSession().getAttribute("vsaUserToken");
//            StringBuilder logouttUrl = new StringBuilder();
//            if (vsaUserToken != null) {
//                logouttUrl.append(getCasByKey("logoutUrl"))
//                        .append("?service=" + URLEncoder.encode(getCasByKey("service"), "UTF-8"))
//                        .append("&userName=").append(vsaUserToken.getUserName())
//                        .append("&appCode=").append(getCasByKey("domainCode"));
//                getRequest().setAttribute("logouttUrl", logouttUrl);
//            }
//test webservice
//            PassportWS passportWS = createWsClient(PassportWS.class);
//            System.out.println(passportWS.getAppFunctions("LOGISTICS") + "---------");
            ModelAndView model = new ModelAndView();
            model.setViewName("index");
            return model;
        } catch (Exception ex) {
            logger.error(ex);
            return errorModel;
        }
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logOut(HttpServletResponse httpServletResponse) {
        try {
            UserToken vsaUserToken = (UserToken) getHttpSession().getAttribute("vsaUserToken");
            StringBuilder logoutUrl = new StringBuilder();
            if (vsaUserToken != null) {
                logoutUrl.append(getCasByKey("logoutUrl"))
                        .append("?service=" + URLEncoder.encode(getCasByKey("service"), "UTF-8"))
                        .append("&userName=").append(vsaUserToken.getUserName())
                        .append("&appCode=").append(getCasByKey("domainCode"));
                getRequest().setAttribute("logouttUrl", logoutUrl);
            }
            getHttpSession().invalidate();
//            httpServletResponse.sendRedirect(logouttUrl.toString());
//            ModelAndView model = new ModelAndView();
//            model.setViewName("logout");
//            model.addObject("logoutUrl", logoutUrl);
            return "redirect:" + logoutUrl.toString();
        } catch (Exception ex) {
            logger.error(ex);
            return ERROR_PAGE;
        }
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String firstPage() {
        return "redirect:/index.html";
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }

    //Spring Security see this :
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

}
