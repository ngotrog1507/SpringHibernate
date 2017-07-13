

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="form-horizontal" style="padding: 5px">
    <div class="form-group">
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.coSan"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="1"><fmt:message key="constrConsult.label.co"/></option>
                <option value="0"><fmt:message key="constrConsult.label.khong"/></option>
            </select>
        </div>
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.loaiPhongMay"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="2"><fmt:message key="constrConsult.label.pinMatTroi"/></option>
                <option value="3"><fmt:message key="constrConsult.label.nhaCaiTao"/></option>
                <option value="4"><fmt:message key="constrConsult.label.nhaLapGhep"/></option>
                <option value="5"><fmt:message key="constrConsult.label.nhaXayMoi"/></option>
                <option value="6"><fmt:message key="constrConsult.label.nhaXayMoiVuotLu"/></option>
                <option value="1"><fmt:message key="label.khac"/></option>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.tenLoaiPhongMayLapGhep"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="2">C03</option>
                <option value="3">C04</option>
                <option value="4">C05</option>
                <option value="5">C06</option>
                <option value="6">C408</option>
                <option value="1"><fmt:message key="label.khac"/></option>
            </select>
        </div>
       
    </div>
     <div class="form-group">
        <label class="control-label col-md-2">
            <fmt:message key="label.khac"/>
        </label>
        <div class="col-md-10 ">
            <textarea class="form-control"/>
        </div>
      
     </div>
</div>