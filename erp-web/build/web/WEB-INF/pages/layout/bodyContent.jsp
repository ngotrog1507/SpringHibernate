<%-- 
    Document   : bodyLayout
    Created on : May 18, 2016, May 18, 2016 2:13:21 PM
    Author     : thuannht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%
    request.setAttribute("contextPath", request.getContextPath());
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="body" id="divBodyContent"  >  
            <tiles:insertAttribute name="body" />
        </div>  
    </body>
</html>
