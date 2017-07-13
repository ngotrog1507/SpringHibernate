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
            <fmt:message key="project.title" />
        </title>  
        <c:set var="title"><tiles:getAsString name="title" ignore="true" /></c:set>
        
        <script src="${pageContext.request.contextPath}/share/jquery/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/share/jquery/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
<!--        <link href="${pageContext.request.contextPath}/share/jquery/jquery-ui-themes-1.11.4/themes/redmond/jquery-ui.min.css" rel="stylesheet" >      -->
        <!--        Menu-->
        <!--Bootstrap dependencies-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/bootstrap/css/bootstrap.min.css" />

        <script src="${pageContext.request.contextPath}/share/core/js/erp.js"></script>  
        <script src="${pageContext.request.contextPath}/share/core/js/ktts.js"></script>  
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/core/css/erp.css">     
        <script src="${pageContext.request.contextPath}/share/jquery/jquery-validation-1.15.0/jquery.validate.min.js"></script>


        <!--Bootstrap dependencies-->
        <!--jqwidgets dependencies-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/jquery/jqwidgets-ver4.1.2/jqwidgets/styles/jqx.base.css" type="text/css" />        
        <script type="text/javascript" src="${pageContext.request.contextPath}/share/jquery/jqwidgets-ver4.1.2/jqwidgets/jqx-all.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/jquery/jqwidgets-ver4.1.2/jqwidgets/styles/jqx.ui-redmond.css" type="text/css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/share/jquery/jqwidgets-ver4.1.2/jqwidgets/styles/jqx.light.css" type="text/css" />
        
<!--<link rel="stylesheet" href="${pageContext.request.contextPath}/share/jquery/jqwidgets-ver4.1.2/jqwidgets/styles/jqx.bootstrap.css" type="text/css" />-->

        <script type="text/javascript">
            $.jqx.theme = 'ui-redmond';
//            $.jqx.theme = 'light.css';
            
            var VT_GLOBAL_VAR = {};
            VT_GLOBAL_VAR.infoTitle = "<fmt:message key="layout.alert" />";
            VT_GLOBAL_VAR.successContent = "<fmt:message key="message.success" />";
            VT_GLOBAL_VAR.selectTitle = "<fmt:message key="select.title" />";

            $(document).ready(function () {

                $('#mainSplitter').jqxSplitter({
                    width: '99.8%',
                    height: '99.8%',
                    orientation: 'horizontal',
                    panels: [
                        {size: "35px", min: "0%", collapsible: true},
                        {size: '90%'}
                    ]
                });

                $('#centerPanel').jqxSplitter({
                    width: '99.8%',
                    height: '99.8%',
                    orientation: 'vertical',
                    panels: [
                        {size: "20%", min: "0%", collapsible: true},
                        {size: '80%'}
                    ]
                });

                vt_control.buildTab("#jqxTabs",{showCloseButtons: true});
                $("#jqxTabs").jqxTabs("hideCloseButtonAt", 0);
//                $("#leftPanel").jqxMenu({ width: '100%', height: '32px', autoSizeMainItems: true});
//                 $("#leftPanel").jqxMenu('minimize');
            });
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

        <div id="mainSplitter">
            <div class="splitter-panel" id="northPanel">
                <div class="menu"><tiles:insertAttribute name="menu" /></div>  
            </div>
            <div>
                <div class="splitter-panel"  id="centerPanel">
                    <div class="splitter-panel"  id="leftPanel">
                    </div>
                    <div class="splitter-panel"  id="rightPanel">
                        <div class="body" id="divMainContent"  >  
                            <div id='jqxTabs'>
                                <ul>
                                    <li style="margin-left: 30px;"><fmt:message key='${title}'/></li>
                                </ul>
                                <div class="content-container">
                                    <jsp:include page="../index.jsp"/>
                                    <%--<tiles:insertAttribute name="body" />--%>
                                </div>
                            </div>                            
                        </div>     
                    </div>
                </div>
            </div>
        </div>


 <input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
    </body>  
</html> 
<style>
.ui-dialog { z-index: 1000 !important ;}
</style>