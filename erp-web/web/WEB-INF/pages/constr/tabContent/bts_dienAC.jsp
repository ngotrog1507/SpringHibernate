<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="bts_dienAC_js.jsp"/>
   
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
            <fmt:message key="constrConsult.label.loaiPhuongAn"/>
        </label>
        <div class="col-md-4 ">
            <select class="form-control">
                <option value="2"><fmt:message key="constrConsult.label.keoDien1Pha"/></option>
                <option value="3"><fmt:message key="constrConsult.label.keoDien3Pha"/></option>
                <option value="4"><fmt:message key="constrConsult.label.haBinh"/></option>
                <option value="5"><fmt:message key="constrConsult.label.mayNo"/></option>
                <option value="6"><fmt:message key="constrConsult.label.pinMatTroi"/></option>
                <option value="1"><fmt:message key="label.khac"/></option>
            </select>
        </div>
        
    </div>

    <div class="form-group">
        <label class="control-label col-md-2">
           <fmt:message key="constrConsult.label.soCotCoSan"/>
        </label>
        <div class="col-md-4 ">
            <input class="form-control" type="text"></input>
        </div>
        <label class="control-label col-md-2">
            <fmt:message key="constrConsult.label.soCotTrongMoi"/>
        </label>
        <div class="col-md-4">
            <input class="form-control" type="text"></input>
        </div>
    </div>
     <div class="form-group">
        <label class="control-label col-md-2">
              <fmt:message key="constrConsult.label.tongChieuDaiCapDien"/>
        </label>
        <div class="col-md-4 ">
            <input placeholder="100 (tự động tính từ chiều dài các loại cáp bên dưới" class="form-control" type="text"></input>
        </div>
        <label class="control-label col-md-2">
            <fmt:message key="label.khac"/>
        </label>
        <div class="col-md-4">
           <input class="form-control" type="text"></input>
        </div>
    </div>
      
    <div class="form-group">
        <div class="col-md-2"/>
        <div class="col-md-8" >
            <div id="btsGrid" name="btsGrid1">
            </div>
        </div>
        <div class="col-md-2"/>
        
    </div>
     <div class="form-group">
          <div class="col-md-2"/>
          <div class="col-md-1">
              <input type="button" onclick="addNewDienAc()" value="Thêm dòng"  class="btn btn-default"/>
          </div>
     </div>
</div>