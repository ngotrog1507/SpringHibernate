<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd"> 
<%
    request.setAttribute("contextPath", request.getContextPath());
%>
<html lang="en" >
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>
            <c:set var="title"><tiles:getAsString name="title" ignore="true" /></c:set>
            <fmt:message key="${title}" />
        </title>  


<!--        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/angular-material/angular-material.css">
<script src="${pageContext.request.contextPath}/share/angular/angular.js"></script>
<script src="${pageContext.request.contextPath}/share/angular-aria/angular-aria.js"></script>
<script src="${pageContext.request.contextPath}/share/angular-animate/angular-animate.js"></script>
<script src="${pageContext.request.contextPath}/share/angular-material/angular-material.js"></script>
<script src="${pageContext.request.contextPath}/share/angular-messages/angular-messages.js"></script>
<script src="${pageContext.request.contextPath}/share/angular-messages/angular-messages.js"></script>
        -->        
        <!--Common lib of project-->
        <script src="${pageContext.request.contextPath}/share/jquery/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/share/jquery/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
        <link href="${pageContext.request.contextPath}/share/jquery/jquery-ui-themes-1.11.4/themes/redmond/jquery-ui.min.css" rel="stylesheet" >      
        <!--        Menu-->
        <!--Bootstrap dependencies-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/bootstrap/css/bootstrap.min.css" />

        <script src="${pageContext.request.contextPath}/share/core/js/erp.js"></script>  
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/core/css/erp.css">     
        <script src="${pageContext.request.contextPath}/share/jquery/jquery-validation-1.15.0/jquery.validate.min.js"></script>


        <!--Bootstrap dependencies-->
        <!--multiselect dependencies-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/jquery/select-master/pqselect.dev.css" />    
        <script src = "${pageContext.request.contextPath}/share/jquery/select-master/pqselect.dev.js"></script>

        <!--jqwidgets dependencies-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/jquery/jqwidgets-ver4.1.2/jqwidgets/styles/jqx.base.css" type="text/css" />        
        <script type="text/javascript" src="${pageContext.request.contextPath}/share/jquery/jqwidgets-ver4.1.2/jqwidgets/jqx-all.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/jquery/jqwidgets-ver4.1.2/jqwidgets/styles/jqx.ui-redmond.css" type="text/css" />


        <script type="text/javascript">
            $.jqx.theme = 'ui-redmond';
            var VT_GLOBAL_VAR = {};
            VT_GLOBAL_VAR.infoTitle = "<fmt:message key="layout.alert" />";
            VT_GLOBAL_VAR.successContent = "<fmt:message key="message.success" />";
            VT_GLOBAL_VAR.selectTitle = "<fmt:message key="select.title" />";
        </script>
    </head>  
    <body class="main-body">

        <div id="message" class="ui-widget-content ui-corner-all">
            <h3 class="ui-widget-header ui-corner-all"><fmt:message key="layout.alert"  /></h3>
            <p id="contentMsg">

            </p>
        </div>
        <div id="jqxNotification">
        </div>
        <div><tiles:insertAttribute name="header" /></div>  
        <div class="menu"><tiles:insertAttribute name="menu" /></div>  


        <div class="body" id="divMainContent"  >  
            <tiles:insertAttribute name="body" />
        </div>  

        <div class="footer-container"  ><tiles:insertAttribute name="footer" /></div>  

    </body>  
</html>  
