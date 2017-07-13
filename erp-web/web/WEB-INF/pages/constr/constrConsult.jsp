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
<script type="text/javascript" src="${pageContext.request.contextPath}/share/jquery/jqwidgets-ver4.1.2/jqwidgets/jqxinput.js"></script>
  
<script>
    var controlHeight='34px';
//    -- script here
    $(function () {
        //grid go here
        var datafields = [
            {name: 'catConstrDesignItemId', type: 'number'},
            {name: 'catConstrDesignItemCode', type: 'string'},
            {name: 'catConstrDesignItemName', type: 'string'},
            {name: 'description', type: 'string'},
            {name: 'constructType', type: 'number'}
        ];
        var columnEdit = '<fmt:message key="label.edit" />';
        var columnName = '<fmt:message key="label.constructionDesignItemName" />';
        var columnCode = '<fmt:message key='label.constructionDesignItemCode' />';
        var columnDescription = '<fmt:message key="label.note" />';
        var columnConstrType = '<fmt:message key="label.constructionType"  />';

        
        //format hiển thi cột construction
        var formatconstructionType = function (row, column, value) {
            var content = "";
            if (value === 1) {
                content = constructionType.BTS.text;
            } else if (value === 2) {
                content = constructionType.GPON.text;
            }
            else if (value === 3) {
                content = constructionType.truyenDanNgam.text;
            }
            else if (value === 4) {
                content = constructionType.truyenDanTreo.text;
            }
            return "<div style='margin:4px;text-align:center'>" + content + "</div>";
        };

        var formatColumnAction = function (row, column, value) {
            var content = "<div style='margin:4px;text-align:center'>";
            content = content + "<img width=\"20\" height=\"20\" onclick=\"preEdit(" + row + ")\" src= \"share/core/images/edit.png\" ></img>";
            content = content + "<img width=\"20\" height=\"20\" onclick=\"onDelete(" + row + ")\" src= \"share/core/images/delete.png\" ></img>";
            content += "</div>";
            return content;
        };

        var columns = [
            {
                text: '#', sortable: false, filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false,
                datafield: '', columntype: 'number', width: "3%",
                cellsrenderer: function (row, column, value) {
                    return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                }
            },
            {
                text: columnEdit, align:'center', sortable: false, filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false,
                columntype: 'text', width: "8%",
                cellsrenderer: formatColumnAction
            },
            {text: columnCode, datafield: 'catConstrDesignItemCode', align:'center', cellsalign: 'center', width: "25%", filtertype: 'input'},            
            {text: columnName, datafield: 'catConstrDesignItemName', align:'center', cellsalign: 'center', width: "20%", filtertype: 'input'},
            {text: columnConstrType, datafield: 'constructType',align:'center', cellsRenderer: formatconstructionType, width: "15%"},
            {text: columnDescription, datafield: 'description',align:'center',cellsalign: 'center', width: "29%"}

        ];
        var url = "searchConstrConsult.json";
          source_func= function (query, response) {
                dataAdapter = new $.jqx.dataAdapter
                        (
                            {
                                datatype: "json",
                                datafields:
                                [
                                    { name: 'value' },
                                    { name: 'label'},
                                    { name: 'desc' }
                                ],
                                url: "searchAutoComplete.json",			// ,
                                 data:
                                 {                                    
                                     maxRow: 12
                                    
                                 }
                            },
                            {
                                autoBind: true,
                                formatData: function (data) {
                                     data.keysearch = query;
                                    return data;
                                },
                                loadComplete: function (data) {
                                       if (data.length > 0) {
                                         
                                        response($.map(data, function (item) {
                                            return {
                                                label: item.label,
                                                value: item.value
                                            }
                                        }));
                                    }
                                }
                            }
                        );
            };
            
        $("#frm_contractConsult").jqxInput({ 
            placeHolder: "Nhập mã hợp đồng", 
            displayMember:'label',
            valueMember:'value',
            height:controlHeight, 
            width: '100%',       
           source: source_func
                   });           
       ktts_control.buildDateTimePicker("#frm_createdDateFrom");
       ktts_control.buildDateTimePicker("#frm_createdDateTo");
       ktts_control.buildDateTimePicker("#frm_approvedDateFrom");
       ktts_control.buildDateTimePicker("#frm_approvedDateTo");
//       $("#frm_createdDateTo").jqxDateTimeInput({ width: '100%', height:controlHeight});
//       $("#frm_approvedDateFrom").jqxDateTimeInput({ width: '100%', height:controlHeight});
//       $("#frm_approvedDateTo").jqxDateTimeInput({ width: '100%', height:controlHeight});
        ktts_control.buildComboBox("#frm_provinceGroup","selectProvinceGroup.json");
//        vt_control.buildAutoComplete("#frm_contractConsult", "searchAutoComplete.json", {remoteAutoComplete: true}, {"xxx": "yyyy"}, function (item) {
//        });
        
        //Fileupload
        var listAttachIds=[];        
//        $('#jqxFileUpload').jqxFileUpload({ width: '100%', uploadUrl: 'upload?'+ '${_csrf.parameterName}=${_csrf.token}', fileInputName: 'file' });
//        $('#jqxFileUpload').on('uploadStart',function(event){
//            console.log(event);
//        });
//        $('#jqxFileUpload').on('uploadEnd', function (event) {
//               var args = event.args;
//               var fileName = args.file;
//               var serverResponse = args.response;
//               // Your code here.
////   	            console.log(args);
////   	            console.log(fileName);
////   	            console.log(serverResponse);                    
//               if(serverResponse!==null && serverResponse !== ''){
//                   var responseData=JSON.parse(serverResponse.substr(5,serverResponse.length-11))
//                   if(responseData.attachId!==0){
//                       $("#uploadResultDiv").prepend("<div>"+fileName+"        <a href='#' onclick='removeAttachId(event,"+responseData.attachId+")' >Xóa</a></div>");
//                     $("#jqxFileUpload-attachId").val(listAttachIds);
//                   }
//               }
//
//           });
//
//           removeAttachId=function(event,id){
//               listAttachIds.pop(id);
//                $("#jqxFileUpload-attachId").val(listAttachIds);
//               $(event.target).parent().empty();                  
//           };

        //form tìm kiếm
        $("#btnSearch").click(function (event) {
            event.preventDefault();
            var param = vt_datagrid.getFormAsObj("#frmConstrConsult");
            console.log(param);
            vt_datagrid.reload("#jqxgrid", null, param);
        });

    

       

        onAddOrSaveSuccess = function (result) {
            vt_alert.showAlert(result.message);
            closeDialog();
            vt_datagrid.reload("#jqxgrid");
        };
        onAddOrEditFail = function (jqXHR, textStatus, errorThrown) {
            vt_alert.showAlert(result.textStatus);
        };      
   
    });


</script>

<!--html go here-->
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="lead"><fmt:message key="title.searchLabel"/></span>        
    </div>

    <div class="form-horizontal" style="padding: 5px">
        <form id="frmConstrConsult" style="padding:5px;">
            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.stationCode"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="frm_StationCode"  name="stationCode" />
                </div>
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.constrCode"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="frm_constrCode"  name="constrCode"/>
                </div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.provinceCode"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="frm_provinceCode"  name="provinceCode" />
                </div>
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.provinceGroup"/>
                </label>
                <div class="col-md-4">
                    <div class="form-control" id="frm_provinceGroup" name="proviceGroup" />
                </div>
            </div>
                
             <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.projectCode"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="frm_projectCode"  name="projectCode" />
                </div>             
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.construtionDesignCode"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="frm_construtionDesignCode"  name="construtionDesignCode" />
                </div>
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.constructionEstimateCode"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" id="frm_constructionEstimateCode" name="constructionEstimateCode" />                    
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.donViTuVan"/>
                </label>
                <div class="col-md-4" >
                    <input class="form-control" type="text" id="frm_partnerId" name="partnerId" />                    
                </div>
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.contractConsult"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="frm_contractConsult" name="contractId" />                    
                </div>
            </div>
<!--            <div class="form-group">
                <label class="control-label col-md-2">
                    <%--<fmt:message key="constrConsult.label.constructorName"/>--%>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="frm_constructorName"  name="constructorName" />
                </div>
                <label class="control-label col-md-2">
                    <%--<fmt:message key="constrConsult.label.supervisorName"/>--%>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" id="frm_supervisorName" name="supervisorName" />                    
                </div>
            </div>-->
            <div class="form-group">
                 <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.constructionType"/>
                </label>
                 <div class="col-md-4 ">
                    <select class="form-control" id="frm_constructionType" name="constructionType">
                        <option value="-1"><fmt:message key="label.selectAll"/></option>
                        <option value="1"><fmt:message key="label.BTS"/> </option>
                        <option value="2"><fmt:message key="label.GPON" /> </option>
                        <option value="3"><fmt:message key="label.TruyenDanNgam"/> </option>
                        <option value="4"><fmt:message key="label.TruyenDanTreo"/> </option>
                        <option value="5"><fmt:message key="label.other"/> </option>
                    </select>
                </div>            
<!--                <label class="control-label col-md-2">
                    <%--<fmt:message key="constrConsult.label.designStatus"/>--%>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="frm_designStatus"  name="designStatus" />
                </div>-->
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.designStatus"/>
                </label>
                <div class="col-md-4 ">
                    <select class="form-control" id="frm_constructionType" name="constructionType">
                         <option value="-1"><fmt:message key="label.selectAll"/></option>
                        <option value="1"><fmt:message key="constrConsult.label.status.chuaTaoThietKe"/> </option>
                        <option value="2"><fmt:message key="constrConsult.label.status.chuaTaoDuToan" /> </option>
                        <option value="3"><fmt:message key="constrConsult.label.status.chuaTrinhDuyet"/> </option>
                        <option value="4"><fmt:message key="constrConsult.label.status.tuChoiDuyet"/> </option>
                        <option value="5"><fmt:message key="constrConsult.label.status.daPheDuyet"/> </option>
                    </select>
                    
                </div>
            </div>
            <div class="form-group">
                
                <label class="control-label col-md-2">
                    <fmt:message key="constrConsult.label.ngayTao"/>
                    <fmt:message key="constrConsult.label.tuNgay"/>                         
                </label>
                <div class="form-group col-md-4" style="margin-right: 15px">
                    <div class="col-md-5" style="padding-right:15px" >
                        <div class="form-control" id="frm_createdDateFrom"  />        
                    </div>
                   
                        <label class="control-label col-md-1" style="text-align: center">
                       <fmt:message key="constrConsult.label.denNgay"/>
                    </label>
                    
                    <div class="col-md-5" >
                        <div class="form-control"  id="frm_createdDateTo" />    
                    </div>
                         <div class="col-md-1"/>
                    
                </div>
              
        
                 <label class=" col-md-2">
                    <fmt:message key="constrConsult.label.ngayPheDuyet"/>
                    <fmt:message key="constrConsult.label.tuNgay"/>                         
                 </label>
                <div class="form-group col-md-4">
                    <div class="col-md-5">
                        <div  class="form-control" id="frm_approvedDateFrom"/>  
                    </div>
                       
                   <label class="control-label col-md-1"><fmt:message key="constrConsult.label.denNgay"/></label>

                   <div class="col-md-5">
                        <div class="form-control"  id="frm_approvedDateTo"/>    
                    </div>
                        <div class="col-md-1"/>
                </div>
                    
            </div>
        </form>
<!--
                <div class="form-group">
                     <label class="control-label col-md-2">
                    <%--<fmt:message key="File đính kèm"/>--%>
                </label>
                    <div class="col-md-4 ">
                        <div id="jqxFileUpload"/>
                        <div id="uploadResultDiv"/>
                        <input type="hidden" id="jqxFileUpload-attachId" name="attachIds"/>
                    </div>
                
                </div>-->
                
            <div class="form-group">
                <div class="col-md-12" style="text-align: center">
                    <input type="submit" class="btn btn-primary" id="btnSearch" value='<fmt:message key="label.search"/>' />                    
                </div>
            </div>
                   
    </div>

</div>
<!--Grid go here-->
<div class="panel panel-default" >
    <div class="panel-heading" style="height: 35px">
        <span class="lead"><fmt:message key="title.searchResult"/></span>   
        <div class="btn-group" style="float: right">
            <span class="lead" ><input type="button" class="btn btn-default" onclick="ktts_util.gotoMenu('constr/designBTS.html')" value="<fmt:message key='constrConsult.label.taoThietKe'/>" /> </span>
            <span class="lead" ><input type="button" class="btn btn-default" onclick="ktts_util.gotoMenu('constr/designHangingTranmission.html')" value="<fmt:message key='constrConsult.label.taoThietKe'/>" /> </span>
            <span class="lead" ><input type="button" class="btn btn-default" onclick="goToCreateConstrDesignItem()" value="<fmt:message key='constrConsult.label.taoDuToan'/>" /></span>
        </div>
        
    </div>
</div>

<div id="jqxgrid" style="width: 100%;min-height: 400px;">
</div>

<div id="dialog-confirm" style="z-index: 1000">
    <p id="confirm_message" ></p>
</div>
<!--popup dialog-->
<div id="dialog-form" class="dialog-form"> 
    <div><fmt:message key="label.add"/> </div>
    <div>    
        <div class="form-horizontal" style="padding: 5px" >
            <form:form id="frmSaveOrEdit" style="padding:5px;" commandName="constructionDesignItem">
                <input class="form-control" type="hidden"  id="constructionDesignItemIdForm" name="catConstrDesignItemId"/>
                <div class="form-group">
                    <div class="col-md-2 label">
                        <fmt:message key="label.constructionType" />
                    </div>
               
                    <div class="col-md-4 ">
                        <select class="form-control" id="constructionTypeIdForm" name="constructType">
                            <option value="-1"><fmt:message key="label.selectAll"/> </option>
                            <option value="1"><fmt:message key="label.BTS"/> </option>
                            <option value="2"><fmt:message key="label.GPON"/> </option>
                            <option value="3"><fmt:message key="label.TruyenDanNgam"/> </option>
                            <option value="4"><fmt:message key="label.TruyenDanTreo"/></option>
                            <option value="5"><fmt:message key="label.other"/></option>
                        </select>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-md-2 label">
                        <fmt:message key="label.constructionDesignItemCode"/>
                    </div>
                    <div class="col-md-4 ">
                        <input class="form-control" type="text" id="constructionDesignItemCodeForm"  name="catConstrDesignItemCode"/>
                    </div>
                    <div class="col-md-2 label">
                        <fmt:message key="label.constructionDesignItemName"/>
                    </div>
                    <div class="col-md-4 ">
                        <input class="form-control" type="text" id="constructionDesignItemNameForm"  name="catConstrDesignItemName" />
                    </div>                   
                </div>
                <div class="form-group">
                    <div class="col-md-2 label">
                        <fmt:message key="label.note"/>
                    </div>
                    <div class="col-md-10 ">
                        <textarea class="form-control" type="textarea" id="descriptionForm"  name="description" />
                    </div>
                </div>
                <div class="form-group">

                    <div class="col-md-12" style="text-align: center">
                        <input type="button" class="btn btn-primary" id="btnAddOrSave" value="<fmt:message key="label.AddOrUpdate" />" />
                        <input type="button" class="btn btn-primary" id="btnCreate" onclick="closeDialog()" value="<fmt:message key="label.close" />" ></input>
                    </div>
                </div>


            </form:form>
        </div>
    </div>
</div>



<style>
    #message{
        z-index: 9999;
    }
</style>