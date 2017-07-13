package com.viettel.fw.vsa;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import viettel.passport.client.ObjectToken;
import viettel.passport.client.UserToken;
import viettel.passport.util.ModifyHeaderUtils;

public class FWVSAFilter
        implements Filter {

    private FilterConfig filterConfig;
    private static Logger logger = Logger.getLogger(FWVSAFilter.class);
    private static HashSet<String> casAllowedURL = new HashSet();
    private static HashSet<String> allMenuURL = new HashSet();
    private boolean timeoutToErrorPage = false;
    private boolean ignoreAjaxRequest = false;

    public void init(FilterConfig config)
            throws ServletException {
        try {
            logger.debug("Lay danh sach AllowUrl tu file config 'cas_en_US.properties'");
            if (Connector.getAllowedUrls() != null) {
                getCasAllowedURL().addAll(Arrays.asList(Connector.getAllowedUrls()));
            }
        } catch (Exception ex) {
            logger.error("Loi lay danh sach AllowUrl tu file config:'cas_en_US.properties'", ex);
            throw new ExceptionInInitializerError(ex);
        }
        try {
            setFilterConfig(config);
            logger.info("File Config :" + config);

            String sTimeoutToErrorPage = this.filterConfig.getInitParameter("timeoutToErrorPage");
            if ("true".equalsIgnoreCase(sTimeoutToErrorPage)) {
                this.timeoutToErrorPage = true;
            } else {
                this.timeoutToErrorPage = false;
            }
            String sIgnoreAjaxRequest = this.filterConfig.getInitParameter("ignoreAjaxRequest");
            if ("true".equalsIgnoreCase(sIgnoreAjaxRequest)) {
                this.ignoreAjaxRequest = true;
            } else {
                this.ignoreAjaxRequest = false;
            }
            VSAValidate vsa = new VSAValidate();
            ArrayList<ObjectToken> objs = vsa.getAllMenu();
            for (int i = 0; i < objs.size(); i++) {
                String temp = ((ObjectToken) objs.get(i)).getObjectUrl().split("\\?")[0];
                if (temp.startsWith("/")) {
                    allMenuURL.add(temp);
                } else {
                    allMenuURL.add("/" + temp);
                }
            }
            logger.info("All menu URL: " + allMenuURL);
            if (logger.isDebugEnabled()) {
                logger.debug("All menu URL: " + allMenuURL);
            }
        } catch (Exception ex) {
            logger.error("Loi khi lay danh sach tat ca module URL", ex);
            allMenuURL.clear();
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("VSAFilter process request");
        HttpServletRequest req = null;
        HttpServletResponse res = null;
        if ((request instanceof HttpServletRequest)) {
            req = (HttpServletRequest) request;
        }
        String returnURL = req.getParameter("return");
        if ((response instanceof HttpServletResponse)) {
            res = (HttpServletResponse) response;
        }
        Connector cnn = new Connector(req, res);
        if ((returnURL != null) && (returnURL.trim().length() > 0)) {
            cnn.returnUrl = returnURL;
        }
        req.setAttribute("VSA-IsPassedVSAFilter", "True");
        String linkFull = req.getRequestURI().contains(req.getServletPath()) ? req.getRequestURI() : req.getRequestURI() + req.getServletPath().substring(1);
        if ((alowURL(req.getRequestURI(), Connector.getAllowedUrls()).booleanValue()) || (alowURL(linkFull, Connector.getAllowedUrls()).booleanValue())) {
            logger.info("request in allow urls: " + linkFull);
            chain.doFilter(req, res);
        } else {
            logger.info("request not in allow urls. Check if session authen?");
            if (!cnn.isAuthenticate().booleanValue()) {
                logger.info("session is not authen. Check if have ticket in request?");
                if (cnn.hadTicket().booleanValue()) {
                    logger.info("have ticket from passport. Validate this ticket");
                    if (!cnn.getAuthenticate().booleanValue()) {
                        logger.warn("Redirect to error page by authenticate failure.");
                        String redirectUrl = Connector.getErrorUrl() + "?errorCode=" + "AuthenticateFailure";
                        req.setAttribute("VSA-IsPassedVSAFilter", "False");
                        res.setHeader("VSA-Flag", "InPageRedirect");
                        res.setHeader("VSA-Location", redirectUrl);
                        if ((this.ignoreAjaxRequest) && (req.getHeader("X-Requested-With") != null) && (req.getHeader("X-Requested-With").length() > 0)) {
                            logger.info("ajax request! Fw request to next filter");
                            chain.doFilter(request, response);
                        } else {
                            logger.info("redirect browser to error page: " + redirectUrl);
                            res.sendRedirect(redirectUrl);
                        }
                    } else {
                        logger.info("validat successfull. Fw request to next filter");
                        chain.doFilter(request, response);
                    }
                } else {
                    logger.info("Request have no ticket. Redirect to passport");
                    String serviceUrl = cnn.getServiceURL();
                    if ((returnURL != null) && (returnURL.trim().length() > 0)) {
                        serviceUrl = serviceUrl + "?return=" + returnURL;
                    }
                    String redirectUrl = cnn.getPassportLoginURL() + "?appCode=" + cnn.getDomainCode() + "&service=" + URLEncoder.encode(serviceUrl, "UTF-8");

                    req.setAttribute("VSA-IsPassedVSAFilter", "False");
                    res.setHeader("VSA-Flag", "InPageRedirect");
                    res.setHeader("VSA-Location", redirectUrl);
                    if ((this.ignoreAjaxRequest) && (req.getHeader("X-Requested-With") != null) && (req.getHeader("X-Requested-With").length() > 0)) {
                        logger.info("ajax request! Fw request to next filter");
                        chain.doFilter(request, response);
                    } else {
                        if (this.timeoutToErrorPage) {
                            redirectUrl = Connector.getErrorUrl() + "?errorCode=" + "SessionTimeout";
                        }
                        logger.info("redirect to passport login: " + redirectUrl);
                        res.sendRedirect(redirectUrl);
                    }
                }
            } else {
                logger.info("session already authen. Check session hijacking");
                HttpSession session = req.getSession();

                logger.info("get ip,mac stored in session");
                String macSavedInSession = (String) session.getAttribute("VTS-MAC");
                logger.info("mac store: " + macSavedInSession);
                String ipSavedInSession = (String) session.getAttribute("VTS-IP");
                logger.info("ip lan sotre: " + ipSavedInSession);
                String ipWanSavedInSession = (String) session.getAttribute("VTS-IPWAN");
                logger.info("ipwan stored: " + ipWanSavedInSession);

                logger.info("get ip,mac in request");
                String mac = req.getHeader("VTS-MAC");
                String ip = req.getHeader("VTS-IP");
                String ipWan = req.getRemoteAddr();
                try {
                    logger.info("decode ip");
                    if ((ip != null) && (ip.length() > 0)) {
                        ip = ModifyHeaderUtils.parseIP(ip);
                    } else {
                        ip = null;
                    }
                    logger.info("decode mac");
                    if ((mac != null) && (mac.length() > 0)) {
                        mac = ModifyHeaderUtils.parseMAC(mac);
                    } else {
                        mac = null;
                    }
                } catch (Exception e) {
                    ip = null;
                    mac = null;
                    logger.error("Giai ma modify header that bai " + e.getMessage(), e);
                }
                logger.info("ip in request: " + ip);
                logger.info("mac in request: " + mac);

                String fakeSessionRedirectUrl = cnn.getPassportLoginURL() + "?appCode=" + cnn.getDomainCode() + "&service=" + URLEncoder.encode(cnn.getServiceURL(), "UTF-8");

                boolean fakeSession = false;
                logger.info("compare ip wan");
                if (!ipWanSavedInSession.equalsIgnoreCase(ipWan)) {
                    logger.fatal(String.format("User: %s dang nhap tu 2 ipwan!!! ipwan dau tien %s, ipwan sau %s", new Object[]{(String) session.getAttribute("netID"), ipWanSavedInSession, ipWan}));

                    res.sendRedirect(fakeSessionRedirectUrl);
                    session.invalidate();
                    fakeSession = true;
                }
                logger.info("compate ip lan");
                if ((!fakeSession) && (ipSavedInSession != null) && (!ipSavedInSession.equalsIgnoreCase(ip))) {
                    logger.fatal(String.format("User: %s dang nhap tu 2 ip!!! ip dau tien %s, ip sau %s", new Object[]{(String) session.getAttribute("netID"), ipSavedInSession, ip}));

                    res.sendRedirect(fakeSessionRedirectUrl);
                    session.invalidate();
                    fakeSession = true;
                }
                logger.info("compare mac");
                if ((!fakeSession) && (macSavedInSession != null) && (!macSavedInSession.equalsIgnoreCase(mac))) {
                    logger.fatal(String.format("User: %s dang nhap tu 2 mac!!! mac dau tien %s, mac sau %s", new Object[]{(String) session.getAttribute("netID"), macSavedInSession, mac}));

                    res.sendRedirect(fakeSessionRedirectUrl);
                    session.invalidate();
                    fakeSession = true;
                }
                if (!fakeSession) {
                    if ((!allMenuURL.isEmpty()) && (allMenuURL.contains(req.getServletPath()))) {
                        logger.info("url already declare in VSA. Check rights excute url?");
                        if (getVsaAllowedServletPath(req).contains(req.getServletPath())) {
                            logger.info("url have rights to excute. Fw to next filter");
                            chain.doFilter(request, response);
                        } else {
                            logger.error("Khai bao chua phan quyen: " + req.getServletPath() + "\n");
                            String redirectUrl = Connector.getErrorUrl() + "?errorCode=" + "NotPermissionAction";
                            req.setAttribute("VSA-IsPassedVSAFilter", "False");
                            res.setHeader("VSA-Flag", "NewPageRedirect");
                            res.setHeader("VSA-Location", redirectUrl);
                            if ((this.ignoreAjaxRequest) && (req.getHeader("X-Requested-With") != null) && (req.getHeader("X-Requested-With").length() > 0)) {
                                logger.info("bypass ajax request. next to filter");
                                chain.doFilter(request, response);
                            } else {
                                logger.info("redirect to error page: " + redirectUrl);
                                res.sendRedirect(redirectUrl);
                            }
                        }
                    } else {
                        logger.error("Chua khai bao: " + req.getServletPath() + "\n");

                        logger.info("fw request to next filter");
                        chain.doFilter(request, response);
                    }
                }
            }
        }
    }

    public void destroy() {
    }

    private Boolean alowURL(String url, String[] listAlowUrl) {
        for (String str : listAlowUrl) {
            if (url.equalsIgnoreCase(str)) {
                return Boolean.valueOf(true);
            }
        }
        return Boolean.valueOf(false);
    }

    public static HashSet<String> getAllMenuURL() {
        return allMenuURL;
    }

    public static void setAllMenuURL(HashSet<String> allMenuURL) {
        allMenuURL = allMenuURL;
    }

    public static HashSet<String> getCasAllowedURL() {
        return casAllowedURL;
    }

    public static void setCasAllowedURL(HashSet<String> casAllowedURL) {
        casAllowedURL = casAllowedURL;
    }

    private HashSet<String> getVsaAllowedServletPath(HttpServletRequest request) {
        UserToken vsaUserToken = (UserToken) request.getSession().getAttribute("vsaUserToken");
        HashSet<String> vsaAllowedURL = new HashSet();
        for (ObjectToken ot : vsaUserToken.getObjectTokens()) {
            String servletPath = ot.getObjectUrl();
            if (!"#".equals(servletPath)) {
                if (servletPath.startsWith("/")) {
                    vsaAllowedURL.add(servletPath.split("\\?")[0]);
                } else {
                    vsaAllowedURL.add("/" + servletPath.split("\\?")[0]);
                }
            }
        }
        logger.info("getVsaAllowedServletPath: " + vsaAllowedURL);
        return vsaAllowedURL;
    }

    public FilterConfig getFilterConfig() {
        return this.filterConfig;
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}
