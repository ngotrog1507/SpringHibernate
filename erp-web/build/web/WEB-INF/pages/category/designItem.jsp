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

        var constructionType = {
            truyenDanNgam: {
                value: 3,
                text: '<fmt:message key="label.TruyenDanNgam"/>'
            },
            truyenDanTreo: {
                value: 4,
                text: '<fmt:message key="label.TruyenDanTreo"/>'
            },
            BTS: {
                value: 1,
                text: "<fmt:message key='label.BTS'/>"
            },
            GPON: {
                value: 2,
                text: "<fmt:message key='label.GPON'/>"
            }
        };
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
        var url = "searchConstructionDesignItem.json";
        var customSetting={
            width: '99%'
        };
        ktts_control.buildGrid("#jqxgrid", url, datafields, columns,customSetting);
        vt_dialog.buildDialog("#dialog-form", {});

        //form tìm kiếm
        $("#btnSearch").click(function (event) {
            event.preventDefault();
            var param = vt_datagrid.getFormAsObj("#frmSearch");
            console.log(param);
            vt_datagrid.reload("#jqxgrid", null, param);
        });

        $("#btnCreate").click(function () {
            formatDialog();
            vt_dialog.open("#dialog-form");
        });

        $("#btnAddOrSave").click(function (event) {
            event.preventDefault();
            //validate
            if ($("#constructionTypeIdForm").val() < 1) {
                $("#constructionTypeIdForm").focus();
                vt_alert.showAlert('<fmt:message key="error.invalid.LoaiCongTrinh"/>');
                return false;
            }
            if ($("#constructionDesignItemNameForm").val() == '') {
                $("#constructionDesignItemNameForm").focus();
                vt_alert.showAlert('<fmt:message key="error.invalid.TenHangMuc"/>');
                return false;
            }
            if ($("#constructionDesignItemCodeForm").val() == '') {
                $("#constructionDesignItemCodeForm").focus();
                vt_alert.showAlert('<fmt:message key="error.invalid.MahangMuc"/>');
                return false;
            }
            $("#btnAddOrSave").attr('disabled', 'disabled');        
            var url = "constructionDesignItem/add";
            vt_form.ajax("post", url, null, "#frmSaveOrEdit", null, onAddOrSaveSuccess, onAddOrEditFail);
            $("#btnAddOrSave").attr('disabled', 'disabled');
        });

        onAddOrSaveSuccess = function (result) {
            vt_alert.showAlert(result.message);
            closeDialog();
            vt_datagrid.reload("#jqxgrid");
        };
        onAddOrEditFail = function (jqXHR, textStatus, errorThrown) {
            vt_alert.showAlert(result.textStatus);
        };

        onDelete = function (rowIndex) {
            $("#dialog-confirm").dialog({
                resizable: false,
                height: 140,
                modal: true,
                title: 'Bạn có muốn xóa bản ghi',
                buttons: {
                    "Đồng ý": function () {
                        $("#dialog-confirm").dialog("close");
                        // 1. get select row
                        var row = $("#jqxgrid").jqxGrid("getrowdata", rowIndex);
                        var url = "${contextPath}/constructionDesignItem/delete/" + row.catConstrDesignItemId;
                        vt_form.ajax("DELETE", url, {}, null, null, onAddOrSaveSuccess, onAddOrEditFail);
                    },
                    Hủy: function () {
                        $(this).dialog("close");
                    }
                }
            });
        };

        preEdit = function (rowIndex) {
            var row = $("#jqxgrid").jqxGrid("getrowdata", rowIndex);
            formatDialog();
            $("#constructionDesignItemCodeForm").attr('disabled', 'disabled');
            $("#constructionTypeIdForm").val(row.constructType);
            $("#constructionDesignItemNameForm").val(row.catConstrDesignItemName);
            $("#constructionDesignItemCodeForm").val(row.catConstrDesignItemCode);
            $("#descriptionForm").val(row.description);
            $("#constructionDesignItemIdForm").val(row.catConstrDesignItemId);
            vt_dialog.open("#dialog-form");
        };

        formatDialog = function () {
            $("#frmSaveOrEdit .form-control").val('');
            $("#constructionTypeIdForm").val(-1);
//            $("#constructionDesignItemIdForm").val('');
            $("#constructionDesignItemCodeForm").removeAttr('disabled');
        };
        closeDialog = function () {
            vt_dialog.close("#dialog-form");
        };
    });


</script>

<!--html go here-->
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="lead"><fmt:message key="title.searchLabel"/></span>        
    </div>

    <div class="form-horizontal" style="padding: 5px">
        <form id="frmSearch" style="padding:5px;">

            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="label.constructionType"/>
                </label>
                <div class="col-md-4 ">
                    <select class="form-control" id="constructionTypeId" name="constructType">
                        <option value="-1"><fmt:message key="label.selectAll"/></option>
                        <option value="1"><fmt:message key="label.BTS"/> </option>
                        <option value="2"><fmt:message key="label.GPON" /> </option>
                        <option value="3"><fmt:message key="label.TruyenDanNgam"/> </option>
                        <option value="4"><fmt:message key="label.TruyenDanTreo"/> </option>
                        <option value="5"><fmt:message key="label.other"/> </option>
                    </select>
                </div>

            </div>
            <div class="form-group">
                <label class="control-label col-md-2">
                    <fmt:message key="label.constructionDesignItemName"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="constructionTypeName"  name="catConstrDesignItemName" />
                </div>
                <label class="control-label col-md-2">
                    <fmt:message key="label.constructionDesignItemCode"/>
                </label>
                <div class="col-md-4 ">
                    <input class="form-control" type="text" id="constructTypeCode"  name="catConstrDesignItemCode"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-12" style="text-align: center">
                    <input type="submit" class="btn btn-primary" id="btnSearch" value='<fmt:message key="label.search"/>' />
                    <input type="button" class="btn btn-primary" id="btnCreate" value='<fmt:message key="label.create"/>' ></input>
                </div>
            </div>
        </form>
    </div>

</div>
<!--Grid go here-->
<div class="panel panel-default">
    <div class="panel-heading">
        <span class="lead"><fmt:message key="title.searchResult"/></span>        
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