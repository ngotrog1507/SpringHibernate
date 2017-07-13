</* global vt_datagrid */

/* global vt_datagrid */

%-- 
Document   : designCategory
Created on : Jun 15, 2016, 8:59:50 AM
Author     : hanhls1-local
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
//    -- script here
    $(function () {
        vt_control.buildTab("#tabContent",{showCloseButtons: false,height:'500px'});
    });

 </script>
 <jsp:include page="tabContent/hanging_cot_js.jsp"/>
 <jsp:include page="tabContent/hanging_cap_js.jsp"/>

<!--html go here-->
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="lead"><fmt:message key="title.searchLabel"/></span>        
    </div>

    <div class="form-horizontal" style="padding: 5px">
        <form id="frmConstrConsult" style="padding:5px;">
            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.maThietKe"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text"  />
                </div>
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.tenThietKe"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text"  />
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.soHopDongTuVan"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text"  />
                </div>
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.maCongTrinh"/>
                </label>
                <div class="col-md-4">
                    <input class="form-control" type="text"  />
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.maTram"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text"/>
                </div>    
                 <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.donViTao"/>
                </label>
                <div class="col-md-4">
                    <input class="form-control" type="text" placeholder="Đối tác tư vấn" />
                </div>
            </div>
                <div class="form-group">
                    <label class="control-label col-md-2">
                        <fmt:message key="constrConsult.label.tongChieuDaiTuyen"/>
                    </label>
                    <div class="col-md-4 ">
                        <input class="form-control" type="text" placeholder="1000"/>
                    </div>   
                </div>
            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="label.fileDinhKem"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="file"/>
                </div>    
               
            </div> 
            
        </form>
  

        <div class="form-group">
            <div class="col-md-2"  style="text-align: left">
                <input type="button" class="btn btn-primary" id="btnImport" value="<fmt:message key='constrConsult.label.importThongTinThietke'/>" />
            </div>
            <div class="col-md-8" style="text-align: center">
                <input type="submit" class="btn btn-primary" id="btnSearch" value='<fmt:message key="label.ghiLai"/>' />                    
                <input type="submit" class="btn btn-primary" id="btnSearch" value='<fmt:message key="label.close"/>' />                    
            </div>
        </div>

    </div>

</div>
<!--Grid go here-->
<div class="panel panel-default" >
    <div class="panel-body" >
        <div  id="tabContent">
            <ul>
                <li><fmt:message key="constrConsult.label.cot"/>                        
                </li>
                <li><fmt:message key="constrConsult.label.cap"/>                        
                </li>               
            </ul>
            <div>
                <jsp:include page="tabContent/hanging_cot.jsp"/>
            </div>
                <div><jsp:include page="tabContent/hanging_cap.jsp"/></div>
               
        </div>
    </div>
</div>




<style>
    #message{
        z-index: 9999;
    }
</style>