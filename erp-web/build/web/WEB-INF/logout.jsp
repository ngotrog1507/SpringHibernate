<%-- 
    Document   : index
    Created on : Apr 8, 2016, Apr 8, 2016 4:16:17 PM
    Author     : thuannht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<%-- 
    Document   : indexProxy
    Created on : Apr 1, 2011, 2:41:35 PM
    Author     : cn_longh
--%>
<%
            response.sendRedirect(request.getAttribute("logoutUrl").toString());
%>
