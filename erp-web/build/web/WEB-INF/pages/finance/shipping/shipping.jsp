<%-- 
    Document   : account
    Created on : May 17, 2016, 5:23:15 PM
    Author     : HungLQ9
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<script type="text/javascript">
    $(document).ready(function () {
        // prepare the data
        var source =
                {
                    datatype: "json",
                    datafields: [
                        {name: 'shippingCountry', type: 'string'},
                        {name: 'contactName', type: 'string'},
                        {name: 'orderId', type: 'int'},
                        {name: 'orderDate', type: 'date'},
                        {name: 'requiredDate', type: 'date'},
                        {name: 'shippingDate', type: 'date'},
                        {name: 'shipVia', type: 'string'},
                        {name: 'freight', type: 'float'},
                        {name: 'shipName', type: 'string'},
                        {name: 'shipAddress', type: 'string'},
                        {name: 'shipCity', type: 'string'},
                        {name: 'shipRegion', type: 'string'},
                        {name: 'shipPostalCode', type: 'string'}
                    ],
                    cache: false,
                    url: '${contextPath}/shipping/list',
                    beforeprocessing: function (data) {
                        source.totalrecords = data.totalRecords;
                    },
                    filter: function () {
                        // update the grid and send a request to the server.
                        $("#jqxgrid").jqxGrid('updatebounddata', 'filter');
                    },
                    sort: function () {
                        // update the grid and send a request to the server.
                        $("#jqxgrid").jqxGrid('updatebounddata', 'sort');
                    }
                };
        //

        var dataAdapter = new $.jqx.dataAdapter(source, {
            /*
             // remove the comment to debug
             formatData: function(data) {
             alert(JSON.stringify(data));
             return data;
             },*/
            downloadComplete: function (data, status, xhr) {
                if (!source.totalRecords) {
                    source.totalrecords = data.totalRecords;
                }
            },
            loadError: function (xhr, status, error) {
                throw new Error(error);
            }
        });
        // initialize jqxGrid
        $("#jqxgrid").jqxGrid(
                {
                    width: '100%',
                    height: '100%',
                    source: dataAdapter,
                    autoheight: true,
                    pageable: true,
                    virtualmode: true,
                    sortable: true,
                    showfilterrow: true,
                    filterable: true,
                    showtoolbar: true,
                    selectionmode: 'singlerow', // singlerow,multiplerows,multiplerowsextended, multiplerowsadvanced, checkbox
                    columnsreorder: true,
                    rendergridrows: function () {
                        return dataAdapter.records;
                    },
                    rendertoolbar: function (toolbar) {
                        var container = $("<div style='margin: 5px;'></div>");
                        toolbar.append(container);
                        container.append('<input id="remvFilter" type="button" value="Remove Filter" />');
                        $("#remvFilter").jqxButton();
                        $("#remvFilter").on('click', function () {
                            $("#jqxgrid").jqxGrid('clearfilters');
                        });
                        // export to excel
                        container.append('<input id="expToExcel" type="button" value="Reload"  />');
                        $("#expToExcel").jqxButton();
                        $("#expToExcel").on('click', function () {
                            $("#jqxgrid").jqxGrid({source: dataAdapter});
                        });
                        // export to pdf
                        container.append('<input id="expToPdf" type="button" value="Export to Excel" />');
                        $("#expToPdf").jqxButton();
                        $("#expToPdf").on('click', function () {
                            var filterInfo = $('#jqxgrid').jqxGrid('getfilterinformation');
                            var k = 0;
                            var parm = {};
                            for (i = 0; i < filterInfo.length; i++) {
                                var filer = filterInfo[i];
                                var filerLS = filer.filter.getfilters();
                                for (j = 0; j < filerLS.length; j++) {
                                    var obj = filerLS[j];
                                    var datafieldOperator = filer.datafield + 'operator';
                                    var filtervalue = 'filtervalue' + k;
                                    var filtercondition = 'filtercondition' + k;
                                    var filteroperator = 'filteroperator' + k;
                                    var filterdatafield = 'filterdatafield' + k;
                                    //
                                    parm[datafieldOperator] = filer.filter.operator;
                                    parm[filtervalue] = obj.value;
                                    parm[filtercondition] = obj.condition;
                                    parm[ filteroperator] = obj.operator;
                                    parm[filterdatafield] = filer.datafield;
                                    k++;
                                }
                            }
                            var url = '${contextPath}/export/shipping?' + $.param(parm);
                            window.open(url);

                        });
                    },
                    columns: [
                        {
                            text: '#', sortable: false, filterable: false, editable: false,
                            groupable: false, draggable: false, resizable: false,
                            datafield: '', columntype: 'number', width: 50,
                            cellsrenderer: function (row, column, value) {
                                return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                            }
                        },
                        {text: 'shippingCountry', datafield: 'shippingCountry', filtertype: 'input'},
                        {text: 'contactName', datafield: 'contactName', filtertype: 'checkedlist'},
                        {text: 'orderId', datafield: 'orderId', filtertype: 'number'},
                        {text: 'orderDate', datafield: 'orderDate', filtertype: 'range', cellsformat: 'd', width: 210},
                        {text: 'requiredDate', datafield: 'requiredDate', filtertype: 'range'},
                        {text: 'shippingDate', datafield: 'shippingDate', filtertype: 'range'},
                        {text: 'shipVia', datafield: 'shipVia', filtertype: 'checkedlist'},
                        {text: 'freight', datafield: 'freight', filtertype: 'number'},
                        {text: 'shipName', datafield: 'shipName', filtertype: 'input'},
                        {text: 'shipAddress', datafield: 'shipAddress'},
                        {text: 'shipCity', datafield: 'shipCity'},
                        {text: 'shipRegion', datafield: 'shipRegion'},
                        {text: 'shipPostalCode', datafield: 'shipPostalCode'}
                    ]
                });
        $('#popupWindow').jqxWindow({
            width: 'auto',
            height: 'auto',
            resizable: true,
            autoOpen: false,
            cancelButton: $("#Cancel"),
            modalOpacity: 0.01
        });
        $("#jqxgrid").on("celldoubleclick", function (event) {
            var dataRecord = $("#jqxgrid").jqxGrid('getrowdata', event.args.rowindex);
            console.log(dataRecord);
            $("#shippingCountry").val(dataRecord.shippingCountry);
            $("#contactName").val(dataRecord.contactName);
            $("#orderId").val(dataRecord.orderId);
            $("#orderDate").jqxDateTimeInput();
            $("#orderDate").val(dataRecord.orderDate);
            $("#requiredDate").jqxDateTimeInput();
            $("#requiredDate").val(dataRecord.requiredDate);
            $("#shippingDate").jqxDateTimeInput();
            $("#shippingDate").val(dataRecord.shippingDate);
            $("#shipVia").val(dataRecord.shipVia);
            $("#freight").val(dataRecord.freight);
            $("#shipName").val(dataRecord.shipName);
            $("#shipAddress").val(dataRecord.shipAddress);
            $('#popupWindow').jqxWindow('open');
        });

    });
    //




</script>



<!--<div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: left;">-->
<div id="jqxgrid">
</div>
<!--</div>-->



<div id="popupWindow" >
    <div>Edit</div>
    <div style="overflow: hidden;" >
        <form   id="shippingForm" >
            <table style="height: 100%;width: 100%">
                <tr>

                    <td align="right">ShippingCountry:</td>
                    </td>
                    <td align="left">
                        <input type="text" id="shippingCountry"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Contact Name: </td>
                    <td align="left">
                        <input type="text" id="contactName"/>
                    </td>
                </tr>
                <tr> 

                    <td align="right">OrderId: </td>
                    <td align="left">
                        <input type="text" id="orderId" readonly="true"/>
                    </td>
                </tr>
                <tr> 
                    <td align="right">OrderDate: </td>
                    <td align="left">
                        <input type="datetime" id='orderDate' />

                    </td>
                </tr>
                <tr> 
                    <td align="right">RequiredDate: </td>
                    <td align="left">
                        <input type="datetime" id='requiredDate' />

                    </td>
                </tr>
                <tr> 
                    <td align="right">ShippingDate: </td>
                    <td align="left">
                        <input type="datetime" id='shippingDate' />

                    </td>
                </tr>
                <tr> 
                    <td align="right">ShipVia: </td>
                    <td align="left">
                        <select id="shipVia">
                            <option value="-1">-- Select --</option>
                            <option value="Federal Shipping">Federal Shipping</option>
                            <option  value="United Package">United Package</option>
                            <option value="Speedy Express">Speedy Express</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td align="right">Freight: </td>
                    <td align="left">
                        <input type="text" id='freight' />

                    </td>
                </tr>
                <tr> 
                    <td align="right">ShipName: </td>
                    <td align="left">
                        <input type="text" id='shipName' />

                    </td>
                </tr>
                <tr> 
                    <td align="right">ShipAddress: </td>
                    <td align="left">
                        <textarea id="shipAddress"></textarea>
                    </td>
                </tr>

                <tr>
                    <td align="right" />
                    <td style="padding-top: 10px;" align="right">
                        <input id="Save" type="button" value="Save" />
                        <input id="Cancel" type="button" value="Cancel"/>    
                    </td>
                </tr>
            </table>
        </form>  
    </div>
</div>




