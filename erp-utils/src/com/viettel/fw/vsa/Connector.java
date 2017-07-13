/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.fw.vsa;


import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import viettel.passport.client.ServiceTicketValidator;
import viettel.passport.util.ModifyHeaderUtils;

public class Connector
{
  private HttpServletRequest request;
  private HttpServletResponse response;
  private String ticket;
  public static String passportLoginURL;
  public static String serviceURL;
  public static String domainCode;
  public static String passportValidateURL;
  public static String errorUrl;
  public static String[] allowedUrls;
  public static final String FILE_URL = "cas";
  public static ResourceBundle rb;
  public static boolean modifyHeader = false;
  public String returnUrl;
  private static Logger LOG = Logger.getLogger(Connector.class);
  
  static
  {
    try
    {
      rb = ResourceBundle.getBundle("cas");
      passportLoginURL = rb.getString("loginUrl");
      serviceURL = rb.getString("service");
      domainCode = rb.getString("domainCode");
      passportValidateURL = rb.getString("validateUrl");
      errorUrl = rb.getString("errorUrl");
      modifyHeader = rb.getString("useModifyHeader").equalsIgnoreCase("true");
      
      allowedUrls = rb.getString("AllowUrl").split(",");
    }
    catch (MissingResourceException e)
    {
      LOG.error(e.getMessage(), e);
    }
  }
  
  public Connector(HttpServletRequest req, HttpServletResponse res)
  {
    this.request = req;
    this.response = res;
  }
  
  public Boolean isAuthenticate()
  {
    return Boolean.valueOf((this.request != null) && (this.request.getSession() != null) && (this.request.getSession().getAttribute("vsaUserToken") != null));
  }
  
  public Boolean hadTicket()
  {
    String st = this.request.getParameter("ticket");
    return Boolean.valueOf((st != null) && (st.trim().length() > 0));
  }
  
  public Boolean getAuthenticate()
    throws IOException
  {
    try
    {
      String tmpTicket = this.request.getParameter("ticket");
      
      String ip = this.request.getHeader("VTS-IP");
      String ipwan = this.request.getRemoteAddr();
      String mac = this.request.getHeader("VTS-MAC");
      try
      {
        if ((ip != null) && (ip.length() > 0)) {
          ip = ModifyHeaderUtils.parseIP(ip);
        } else {
          ip = null;
        }
        if ((mac != null) && (mac.length() > 0)) {
          mac = ModifyHeaderUtils.parseMAC(mac);
        } else {
          mac = null;
        }
      }
      catch (Exception e)
      {
        ip = null;
        mac = null;
        LOG.error("Giai ma modify header that bai " + e.getMessage(), e);
      }
      if ((tmpTicket == null) || (tmpTicket.trim().length() == 0)) {
        return Boolean.valueOf(false);
      }
      ServiceTicketValidator stValidator = new ServiceTicketValidator();
      stValidator.setCasValidateUrl(passportValidateURL);
      stValidator.setServiceTicket(tmpTicket);
      if ((this.returnUrl != null) && (this.returnUrl.trim().length() > 0)) {
        stValidator.setService(serviceURL + "?return=" + this.returnUrl);
      } else {
        stValidator.setService(serviceURL);
      }
      stValidator.setDomainCode(domainCode);
      stValidator.validate();
      
      HttpSession session = this.request.getSession();
      session.invalidate();
      session = this.request.getSession(true);
      
      this.response.setHeader("SET-COOKIE", "JSESSIONID=" + session.getId() + ";Path=" + this.request.getContextPath() + ";HttpOnly");
      if (!stValidator.isAuthenticationSuccesful())
      {
        session.setAttribute("vsaUserToken", null);
        session.setAttribute("netID", null);
        return Boolean.valueOf(false);
      }
      session.setAttribute("vsaUserToken", stValidator.getUserToken());
      session.setAttribute("netID", stValidator.getUser());
      session.setAttribute("VTS-IP", ip);
      session.setAttribute("VTS-MAC", mac);
      if (ipwan == null)
      {
        LOG.error("IP WAN get from request is NULL!!!");
        System.out.println("IP WAN get from request is NULL!!!");
      }
      else
      {
        LOG.info("IP WAN is: " + ipwan);
        System.out.println("IP WAN is: " + ipwan);
      }
      session.setAttribute("VTS-IPWAN", ipwan);
      if ((this.returnUrl != null) && (this.returnUrl.trim().length() > 0)) {
        session.setAttribute("return_url", this.returnUrl);
      }
      if ((modifyHeader) || (ip != null) || (mac != null)) {
        LOG.info(String.format("User %s logined at ip %s and mac %s ipwan %s session %s - %s modifyHeader", new Object[] { stValidator.getUser(), ip, mac, ipwan, session.getId(), modifyHeader ? "with" : "without" }));
      } else {
        LOG.info(String.format("User %s logined at ipwan %s without modifyHeader", new Object[] { stValidator.getUser(), ipwan }));
      }
      return Boolean.valueOf(true);
    }
    catch (ParserConfigurationException e)
    {
      LOG.error(e.getMessage(), e);
    }
    return Boolean.valueOf(false);
  }
  
  public String getPassportLoginURL()
  {
    return passportLoginURL;
  }
  
  public static void setPassportLoginURL(String passportLoginURL)
  {
    passportLoginURL = passportLoginURL;
  }
  
  public String getServiceURL()
  {
    return serviceURL;
  }
  
  public static void setServiceURL(String serviceURL)
  {
    serviceURL = serviceURL;
  }
  
  public String getDomainCode()
  {
    return domainCode;
  }
  
  public static void setDomainCode(String domainCode)
  {
    domainCode = domainCode;
  }
  
  public String getPassportValidateURL()
  {
    return passportValidateURL;
  }
  
  public static void setPassportValidateURL(String passportValidateURL)
  {
    passportValidateURL = passportValidateURL;
  }
  
  public String getTicket()
  {
    return this.ticket;
  }
  
  public void setTicket(String ticket)
  {
    this.ticket = ticket;
  }
  
  public static String getErrorUrl()
  {
    return errorUrl;
  }
  
  public static void setErrorUrl(String errorUrl)
  {
    errorUrl = errorUrl;
  }
  
  public static boolean isModifyHeader()
  {
    return modifyHeader;
  }
  
  public static void setModifyHeader(boolean usemodifyHeader)
  {
    modifyHeader = usemodifyHeader;
  }
  
  public static void setAllowedUrls(String[] strs)
  {
    allowedUrls = new String[strs.length];
    System.arraycopy(strs, 0, allowedUrls, 0, strs.length);
  }
  
  public static String[] getAllowedUrls()
  {
    String[] tmps = new String[allowedUrls.length];
    System.arraycopy(allowedUrls, 0, tmps, 0, allowedUrls.length);
    return tmps;
  }
}

