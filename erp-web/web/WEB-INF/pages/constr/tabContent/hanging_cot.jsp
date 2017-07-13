

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
                <label ><fmt:message key="constrConsult.label.cotTrongMoi"/></label>
            </div>
            <div class="form-group" style="margin:5px">
                <div id="hangingTranmissionCotNewGrid"/>
            </div>
                <div class="form-group">
            <input type="button" onclick="addCotNew()" value="Thêm dòng"  class="btn btn-default"/>
            </div>
        </div>
    </div>    
       <div class="col-md-6 " >
        <div class="form">
            <div class="form-group">
                <label ><fmt:message key="constrConsult.label.cotCoSan"/></label>
            </div>
            <div class="form-group" style="margin:5px">
                <div id="hangingTranmissionCotOldGrid"/>
            </div>
                <div class="form-group">
            <input type="button" onclick="addCotOld()" value="Thêm dòng"  class="btn btn-default"/>
            </div>
        </div>
    </div>
    

</div>