<%-- 
    Document   : costCenter
    Created on : Apr 28, 2016, Apr 28, 2016 5:38:56 PM
    Author     : thuannht
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(function () {
        // prepare the data
        var datafields = [
            {name: 'name', type: 'string'},
            {name: 'description', type: 'string'},
            {name: 'dateProfit', type: 'date'},
            {name: 'profit', type: 'number'},
            {name: 'total', type: 'number'}
        ];
        var url = "searchProfitCenter.json";
        var columns = [
            {
                text: '#', sortable: false, filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false,
                datafield: '', columntype: 'number', width: 50,
                cellsrenderer: function (row, column, value) {
                    return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                }
            },
            {text: 'Tên', datafield: 'name', width: 250, filtertype: 'input'},
            {text: 'Mô tả', datafield: 'description', width: 230},
            {text: 'Ngày doanh thu', datafield: 'dateProfit', width: 250
                , filtertype: 'date', cellsalign: 'right', cellsformat: 'd'},
            {text: 'Lợi nhuận', datafield: 'profit', width: 230},
            {text: 'Tổng lợi nhuận', datafield: 'total', width: 250}
        ];
//Code mau tao datagrid        
        vt_datagrid.buildGridCheckBox("#jqxgrid", url, datafields, columns);
        $("#btnSearch").button().click(function (event) {
            event.preventDefault();
            var param = {};
            param = vt_datagrid.getFormAsObj("#frmProfitCenter");
            console.log(param);
            vt_datagrid.reload("#jqxgrid", $("#jqxgrid").jqxGrid("source"), param);
        });

//code mau ve dialog
        vt_dialog.buildDialog("#dialog-form", {}, function () {
            vt_control.buildTreeLazy('#jqxTreeLazy', "getDataForTree.json", {}, {height: '300px', width: '200px'}, function (item) {
                console.log(item);
            });
        }, function () {
            vt_alert.showAlert();
        });
//Mo dialog khi nhan button
        $("#btnCreate").button().on("click", function () {
            vt_dialog.open("#dialog-form");
        });
    });
    function onDelete() {
        var param = $("#frmProfitCenter").serializeArray();
//        param.olt = 1;
//        param.olt1 = 2;
//        console.log(param);
        vt_alert.showAlert();
        vt_form.updateArea("#divMainContent", "profitCenter.html", {});
    }


    $(function () {
        vt_control.buildAutoComplete("#typeCate", "searchAutoComplete.json", {remoteAutoComplete: true}, {"xxx": "yyyy"}, function (item) {
            console.log(item);
        });
        vt_control.buildAutoComplete("#select3", "searchAutoComplete.json", {remoteAutoComplete: false,multiSelect: false}, {"xxx": "yyyy"}, function (item) {
            console.log(item);
        });
         vt_control.buildListBox("#select4", "searchAutoComplete.json", {}, function (item) {
            console.log(item);
        });
    });

</script>
<div class="panel panel-default">
    <div class="panel-heading jqx-widget-header-ui-redmond ">
        <span class="lead"><fmt:message key="title.costcenter" /></span>
    </div>
    <div class="form-horizontal" style="padding:5px;">
        <form:form id="frmProfitCenter">   
            <div class="form-group">
                <div class="col-md-2 label">
                    Tên danh mục
                </div>
                <div class="col-md-4 ">
                    <input type="text" id="name" name="name" style="width: 100%" class="text ui-widget-content ui-corner-all"/>
                </div>
                <div class="col-md-2 label">
                    Mã danh mục
                </div>
                <div class="col-md-4 ">
                    <input type="text" id="description" name="description" style="width: 100%" class="text ui-widget-content ui-corner-all"/>
                </div>

                <div class="col-md-2 label">
                    Mô tả
                </div>
                <div class="col-md-4 ">
                    <div id="select3" name="select3" ></div>
                </div>
                <div class="col-md-2 label">
                    Chon muc cha
                </div>
                <div class="col-md-4">
                    <div id="select4" name="select4" ></div>
                </div>
                <div class="col-md-2 label">
                    Loai danh mục
                </div>
                <div class="col-md-4">
                    <div id='typeCate' name="typeCateName">
                    </div>
                </div>


                <div class="col-md-12" style="text-align: center">
                    <input type="submit" id="btnSearch" value="Tìm kiếm"></input> 
                    <button type="button" id="btnCreate">Thêm mới</button>
                </div>

            </div>
        </form:form>
    </div>
</div>
<div id="jqxgrid" style="width: 100%;min-height: 400px;">
</div>


<div id="dialog-form">
    <div >Thêm mới</div>
    <div >
        <form:form>
    <table style="width: 100%;">
                <tr>
                    <td>Tên danh mục</td>
                    <td><input type="text" id="name" name="name" class="text ui-widget-content ui-corner-all"/></td>
                    <td>Mã danh mục</td>
                    <td><input type="text" id="description" name="description" class="text ui-widget-content ui-corner-all"/></td>                
                </tr>
                <tr>
                    <td>Loai danh mục</td>
                    <td><input name="tags" class="text ui-widget-content ui-corner-all"></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>


            <div id='jqxTreeLazy'>
            </div>

        </form:form>
    </div>
</div>


