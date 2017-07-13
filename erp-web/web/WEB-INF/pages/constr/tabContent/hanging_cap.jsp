

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="form-horizontal" style="padding: 5px">

    <!--<div class="form-group">-->
    <div class="col-md-6 ">
        <div class="form">
            <div class="form-group">
                <label ><fmt:message key="constrConsult.label.cap"/></label>
            </div>
            <div class="form-group" style="margin:5px">
                <div id="hangingTranmissionCapGrid"/>
            </div>
                <div class="form-group">
                    <input type="button" onclick="addHangingTranmissionCapRow()" value="<fmt:message key='constrConsult.label.themLoaiCap'/>"  class="btn btn-default"/>
            </div>
             <div class="form-group">
                <label ><fmt:message key="constrConsult.label.odf"/></label>
            </div>
            <div class="form-group" style="margin:5px">
                <div id="hangingTranmissionODFGrid"/>
            </div>
                <div class="form-group">
                    <input type="button" onclick="addHangingTranmissionODFRow()" value="<fmt:message key='constrConsult.label.themLoaiODF'/>"  class="btn btn-default"/>
            </div>
        </div>
    </div>    
       <div class="col-md-6 " >
        <div class="form">
            <div class="form-group">
                <label ><fmt:message key="constrConsult.label.mangXong"/></label>
            </div>
            <div class="form-group" style="margin:5px">
                <div id="hangingTranmissionMangXongGrid"/>
            </div>
                <div class="form-group">
            <input type="button" onclick="addHangingTranmissionMangXongRow()" value="<fmt:message key='constrConsult.label.themLoaiMangXong'/>"  class="btn btn-default"/>
            </div>
             <div class="form-group">
                <label ><fmt:message key="constrConsult.label.thietBiQuang"/></label>
            </div>
            <div class="form-group" style="margin:5px">
                <div id="hangingTranmissionThietBiQuangGrid"/>
            </div>
                <div class="form-group">
            <input type="button" onclick="addHangingTranmissionThietBiQuangRow()" value="<fmt:message key='constrConsult.label.themLoaiTBQuang'/>"  class="btn btn-default"/>
            </div>
        </div>
    </div>

</div>