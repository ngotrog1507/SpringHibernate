

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<div class="form-horizontal" style="padding: 5px">
    <div class="form-group">
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.hangSanXuat"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="2">Alcatel</option>
                <option value="3">Ericsson</option>
                <option value="4">Huawei</option>
                <option value="5">Nokia</option>
                <option value="6">ZTE</option>
                <option value="1"><fmt:message key="label.khac"/></option>
            </select>
        </div>
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.loaiTu"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="1"><fmt:message key="constrConsult.label.tapTrung"/></option>
               <option value="0"><fmt:message key="constrConsult.label.phanTan"/></option>
            </select>
        </div>
    </div>   
</div>