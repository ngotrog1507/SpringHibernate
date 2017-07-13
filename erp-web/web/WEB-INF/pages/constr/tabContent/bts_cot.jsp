

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="form-horizontal" style="padding: 5px">

    <div class="form-group">
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.doCaoCot"/>
        </label>
        <div class="col-md-4 ">
            <input class="form-control" type="text" id="frm_doCaoCot"  name="doCaoCot" />
        </div>
        <label class="control-label col-md-2">
             <fmt:message key="constrConsult.label.coSan"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="1"><fmt:message key="constrConsult.label.co"/></option>
                <option value="0"><fmt:message key="constrConsult.label.khong"/></option>
            </select>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.viTriCot"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="0"><fmt:message key="constrConsult.label.trenMai"/></option>
                <option value="1"><fmt:message key="constrConsult.label.duoiMai"/></option>
            </select>
        </div>
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.loaiCot"/>
        </label>
        <div class="col-md-4">
            <select class="form-control">
                <option value="0"><fmt:message key="constrConsult.label.trenMai"/></option>
                <option value="1"><fmt:message key="constrConsult.label.duoiMai"/></option>
            </select>
        </div>
    </div>
     <div class="form-group">
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.loaiDayCotCo"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="2">300x300</option>
                <option value="3">400x400</option>
                <option value="4">600x600</option>
                <option value="5">1000x1000</option>
                <option value="1">1000x1000</option>
            </select>
        </div>
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.cotKhac"/>
        </label>
        <div class="col-md-4">
            <select class="form-control">
                <option value="1"><fmt:message key="constrConsult.label.co"/> </option>
                <option value="0"><fmt:message key="constrConsult.label.khong"/></option>
            </select>
        </div>
    </div>
        <div class="form-group">
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.thanCotFi"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="1">50.8</option>
                <option value="2">63.5</option>
                <option value="3">76.3</option>                
            </select>
        </div>
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.soMongCo"/>
        </label>
        <div class="col-md-4">
            <select class="form-control">
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
        </div>            
    </div>
    <div class="form-group">
        <label class="control-label col-md-2">
            <fmt:message key="label.khac"/>
        </label>
        <div class="col-md-10 ">
            <input class="form-control" type="text" id="frm_other"  name="other" />
        </div>
    </div>

</div>