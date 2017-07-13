<%-- 
    Document   : contact
    Created on : May 5, 2016, 3:22:45 PM
    Author     : HungLQ9
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div class="panel panel-default">
    <div class="panel-heading">
        <span class="lead">Add a Contact </span>
    </div>
    <div class="formcontainer">
        <div class="form-group">
            <form:form commandName="personSearch"  id="personFormSearch" cssClass="form-horizontal">                
                <div class="row">
                    <form:label path="name" cssClass="col-md-2 control-label">
                        <spring:message text="Name"/>
                    </form:label>
                    <div class="col-md-4">
                        <form:input  path="name" cssClass="form-control input-sm" />
                    </div> 

                    <form:label path="country" cssClass="col-md-2 control-label">
                        <spring:message text="Country"/>
                    </form:label>
                    <div class="col-md-4">
                        <form:input path="country" cssClass="form-control input-sm"  />
                    </div>
                </div>
            </form:form>
        </div>
        <div class="form-group"> 
            <div class="row">
                <div class="col-sm-offset-2 col-sm-10" style="text-align: center;">
                    <input type="button"  id="btnCreate"
                           value="<spring:message text="Add Person"/>" />
                    <input type="button"  id="btnSearch" 
                           value="<spring:message text="Search"/>" />
                    <input type="button"  id="btnMultiDelete" 
                           value="<spring:message text="Delete"/>" />
                </div>  
            </div>
        </div>
    </div>    
</div>


<div class="panel panel-default">
    <div class="panel-heading">
        <span class="lead">List of Persons</span>
    </div>

</div>


<div id="grid_array" style="width: 100%;min-height: 400px;">
</div>


<div id="dialog-message" title="">
    <p id="info_message"></p>
</div>
<div id="dialog-confirm" >
    <p id="confirm_message" ></p>
</div>

<div id="dialog-form" title="Add a Contact">
    <div class="panel panel-default">
        <div class="form-horizontal">
            <form:form  commandName="person" id="personFormEdit">                
                <div class="form-group">
                    <form:hidden path="id" id="idEdit"/>
                    <form:label path="name" cssClass="col-md-2 control-label" >
                        <spring:message text="Name"/>
                    </form:label>
                    <div class="col-md-4">
                        <form:input  path="name" cssClass="form-control input-sm" id="nameEdit"/>
                    </div> 

                    <form:label path="country" cssClass="col-md-2 control-label">
                        <spring:message text="Country"/>
                    </form:label>
                    <div class="col-md-4">
                        <form:input path="country" cssClass="form-control input-sm" id="countryEdit" />
                    </div>
                </div>
            </form:form>
        </div>
    </div>  

</div>            
<script>
    var request;
    function createTableView() {
        //Tao ra cac render dac biet cho grid - them but edit + delete        
        var datafields = [
            {name: 'id', type: 'number'},
            {name: 'name', type: 'string'},
            {name: 'country', type: 'string'}
        ];
        var url = "person";
        var cellsrenderer = function (row, columnfield, value, defaulthtml, columnproperties) {
            return '<a href="#" onclick="onEdit(\'' + row + '\')">\n\
                           <img src="${contextPath}/share/core/images/edit.png"/>\n\
                         </a>\n\
                         <a href="#" onclick="onDelete(\'' + row + '\')">\n\
                            <img src="${contextPath}/share/core/images/delete.png"/>\n\
                        </a>';
        };
        var columns = [
            {
                text: '#', sortable: false, filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false,
                columntype: 'number', width: 50,
                cellsrenderer: function (row, column, value) {
                    return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                }
            },
            {text: 'Person ID', datafield: 'id', width: 250},
            {text: 'Person Name', datafield: 'name', width: 230},
            {text: 'Person Country', datafield: 'country', width: 230},
            {text: 'Action', cellsrenderer: cellsrenderer, width: 230}
        ];

        //tao grid       
        vt_datagrid.buildGridCheckBox("#grid_array", url, datafields, columns);
    }

    var dialogAdd = $("#dialog-form").dialog({
        autoOpen: false,
        height: 300,
        width: 700,
        modal: true,
        buttons: {
            "Save": function () {
                $("#personFormEdit").submit();
            },
            Cancel: function () {
                dialogAdd.dialog("close");
            }
        },
        close: function () {
        }
    });
    $("#btnMultiDelete").button().on("click", function () {
        onMultiDelete();
    });
    $("#btnCreate").button().on("click", function () {
        // 1. clear dialog
        $("#idEdit").val(0);
        $('#personFormEdit').each(function () {
            this.reset();
        });
        // 2. show dialog
        dialogAdd.dialog("open");
    });
    $("#btnSearch").button().on("click", function () {
        // 1. reload datagrid
        event.preventDefault();
        var param = {};
        param.name = $("#name").val();
        param.country = $("#country").val();
        vt_datagrid.reload("#grid_array", null, param);
    });
    function onEdit(rowIndx) {
        // 1. clear form 
        $('#personFormEdit').each(function () {
            this.reset();
        });
        // 2. get select row
        if (rowIndx != null) {
            // 2.1 local load
            var obj = vt_datagrid.getRowByIndx("#grid_array", rowIndx);
            console.log(obj);
            var id = parseInt(obj.id);
            // 2.2  or remote load
            var onDone = function (result) {
                // 3. set value to form
                $("#idEdit").val(result.id);
                $("#countryEdit").val(result.country);
                $("#nameEdit").val(result.name);
                // 4. show form
                dialogAdd.dialog("open");
            };
            var onFail = function (jqXHR, textStatus, errorThrown) {
                // show error message
                vt_alert.showAlert(textStatus);
            };
            vt_form.ajax("GET", "${contextPath}/person/" + id, null, null, null, onDone, onFail);
        }
    }

    function onDelete(rowIndx) {
        $("#dialog-confirm").html("Bạn có muốn xóa bản ghi");
        $("#dialog-confirm").dialog({
            resizable: false,
            height: 140,
            modal: true,
            title: 'Thông báo',
            buttons: {
                "Đồng ý": function () {
                    $("#dialog-confirm").dialog("close");
                    // 1. get select row
                    if (rowIndx != null) {
                        var obj = vt_datagrid.getRowByIndx("#grid_array", rowIndx);
                        console.log(obj)
                        // 2. get id of object to delete
                        var id = parseInt(obj.id);
                        // call action to delete
                        var onDone = function (result) {
                            vt_alert.showAlert(result.message);
                            $("#btnSearch").click();
                            //
                        };
                        vt_form.ajax("DELETE", "${contextPath}/person/" + id, null, null, null, onDone);
                    }
                },
                Hủy: function () {
                    $(this).dialog("close");
                }
            }
        });
    }



    function onMultiDelete() {
        // check checkbox is selected
        if (vt_datagrid.getTotalRowSelected("#grid_array") === 0) {
            vt_alert.showAlert("Bạn cần chọn bản ghi");
            return;
        }
        // get selected id
        $("#dialog-confirm").dialog({
            resizable: false,
            height: 140,
            modal: true,
            title: 'Bạn có muốn xóa bản ghi',
            buttons: {
                "Đồng ý": function () {
                    $("#dialog-confirm").dialog("close");
                    // 1. get select row
                    var objs = vt_datagrid.getRowsSelection("#grid_array");
                    var ids = [];
                    objs.forEach(function (obj) {
                        var id = parseInt(obj.id);
                        ids.push(id);
                    });
                    var onDone = function (result) {
                        vt_alert.showAlert(result.message)
                        $("#btnSearch").click();
                    }
                    vt_form.ajax("POST", "${contextPath}/person/delete", {ids: ids}, null, null, onDone);
                },
                Hủy: function () {
                    $(this).dialog("close");
                }
            }
        });
    }

    $("#personFormEdit").submit(function (event) {
        var validateRule = {
            rules: {
                name: {
                    required: "required",
                    minlength: 3
                },
                country: "required"
            },
            messages: {
                name: {
                    required: "Bạn Phải nhập tên",
                    minlength: "Tên phải tối thiểu 3 ký tự"
                },
                country: "Bạn phải nhập tên nước"
            }
        };
        if (vt_form.validate("#personFormEdit", validateRule)) {
            // Callback handler that will be called on success
            var onDone = function (response) {
                // inform success message
                vt_alert.showAlert(response.message);
                // clear form 
                $('#personFormEdit').each(function () {
                    this.reset();
                });
                //
                dialogAdd.dialog("close");
                // 
                $("#btnSearch").click();
            };
            // Prevent default posting of form
            vt_form.ajax("POST", "${contextPath}/person/add", null, "#personFormEdit", null, onDone);
            // 
            event.preventDefault();
        } else {
            return false;
        }
    });
    createTableView();
</script>
