<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script>
    $(function () {
        formatDonViTinh = function (row, column, value) {
            var content = "<div style='margin:4px;text-align:center'>";
            content += '<fmt:message key="constrConsult.label.met"/>';
            content += "</div>";
            return content;
        };
        var setting = {
            pageable: false,
            editable: true,
            virtualmode: false,
            width: '100%',
            height: '120px'
        };

        var url = "selectPro.json";
        var hangingTranmissionCapSeletor = "#hangingTranmissionCapGrid";
        formatColumnDeleteHangingTranmissionCap = function (row, column, value) {
            var content = "<div style='margin:4px;text-align:center'>";
            content = content + "<img width=\"20\" height=\"20\" onclick=\"deleteHangingTranmissionCap(" + row + ")\" src= \"share/core/images/delete.png\" ></img>";

            content += "</div>";
            return content;
        };
        deleteHangingTranmissionCap = function (rowId) {
            $(hangingTranmissionCapSeletor).jqxGrid('deleterow', $(hangingTranmissionCapSeletor).jqxGrid('getrowid', rowId));
        };
        addHangingTranmissionCapRow = function () {
            $(hangingTranmissionCapSeletor).jqxGrid('addrow', null, {});
        };
        var loaiCapSource = [
            {value: 2, label: '<fmt:message key="constrConsult.label.cap12Fo"/>'},
            {value: 3, label: '<fmt:message key="constrConsult.label.cap24Fo"/>'},
            {value: 4, label: '<fmt:message key="constrConsult.label.cap12ADSS-K100"/>'},
            {value: 4, label: '<fmt:message key="constrConsult.label.cap12ADSS-K200"/>'},
            {value: 4, label: '<fmt:message key="constrConsult.label.cap24ADSS-K100"/>'},
            {value: 4, label: '<fmt:message key="constrConsult.label.cap24ADSS-K200"/>'}
        ];
        var loaiCapAdapter = new $.jqx.dataAdapter(loaiCapSource, {
            autoBind: true
        });
        var datafieldsCap = [
            {name: 'loaiCap', type: 'int'},
            {name: 'loaiCapDisplay', value: 'loaiCap', values: {source: loaiCapAdapter.records, value: 'value', name: 'label'}},
            {name: 'chieuDai', type: 'number'},
            {name: 'donViTinh', type: 'string'}
        ];
        var columnCaps = [
            {
                text: '#', sortable: false, filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false,
                datafield: '', columntype: 'number', width: "3%",
                cellsrenderer: function (row, column, value) {
                    return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                }
            },
            {
                text: '<fmt:message key="constrConsult.label.loaiCap"/>', columntype: 'combobox', displayfield: 'loaiCapDisplay', datafield: 'loaiCap', align: 'center', cellsalign: 'center', width: "30%",
                createeditor: function (row, value, editor) {
                    editor.jqxComboBox({source: loaiCapAdapter, displayMember: 'label', valueMember: 'value'});
                }
            },
            {text: '<fmt:message key="constrConsult.label.chieuDai"/>',
                columntype: 'numberinput',
                datafield: 'chieuDai',
                align: 'center', cellsalign: 'center', width: "30%", filtertype: 'input',
                createeditor: function (row, cellvalue, editor) {
                    editor.jqxNumberInput({decimalDigits: 2, digits: 3});
                }, validation: function (cell, value) {
                    if (value < 0) {
                        return {result: false, message: "Giá trị phải lớn hơn 0"};
                    }
                    return true;
                }},
            {text: '<fmt:message key="constrConsult.label.donViTinh"/>',
                align: 'center', cellsalign: 'center', width: "25%",
                editable: false, cellsrenderer: formatDonViTinh
            },
            {
                text: '<fmt:message key="constrConsult.label.delete"/>',
                align: 'center', sortable: false,
                filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false, cellsrenderer: formatColumnDeleteHangingTranmissionCap,
                columntype: 'text', width: "9%"
            }
        ];
        ktts_control.buildGrid(hangingTranmissionCapSeletor, url, datafieldsCap, columnCaps, setting);


        //hangingTranmissionODFGrid
        var hangingTranmissionODFSeletor = "#hangingTranmissionODFGrid";
        formatColumnDeleteHangingTranmissionODF = function (row, column, value) {
            var content = "<div style='margin:4px;text-align:center'>";
            content = content + "<img width=\"20\" height=\"20\" onclick=\"deleteHangingTranmissionODF(" + row + ")\" src= \"share/core/images/delete.png\" ></img>";

            content += "</div>";
            return content;
        };
        deleteHangingTranmissionODF = function (rowId) {
            $(hangingTranmissionODFSeletor).jqxGrid('deleterow', $(hangingTranmissionODFSeletor).jqxGrid('getrowid', rowId));
        };
        addHangingTranmissionODFRow = function () {
            $(hangingTranmissionODFSeletor).jqxGrid('addrow', null, {});
        };
        var loaiODFSource = [
            {value: 2, label: '<fmt:message key="constrConsult.label.odfLoai24"/>'},
            {value: 3, label: '<fmt:message key="constrConsult.label.odfLoai48"/>'},
            {value: 4, label: '<fmt:message key="constrConsult.label.odfLoai96"/>'},
            {value: 1, label: '<fmt:message key="label.khac"/>'}

        ];
        var loaiODFAdapter = new $.jqx.dataAdapter(loaiODFSource, {
            autoBind: true
        });
        var datafieldODF = [
            {name: 'loaiODF', type: 'int'},
            {name: 'loaiODFDisplay', value: 'loaiODF', values: {source: loaiODFAdapter.records, value: 'value', name: 'label'}},
            {name: 'chieuDai', type: 'number'},
            {name: 'donViTinh', type: 'string'}
        ];
        var columnODF = [
            {
                text: '#', sortable: false, filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false,
                datafield: '', columntype: 'number', width: "3%",
                cellsrenderer: function (row, column, value) {
                    return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                }
            },
            {
                text: '<fmt:message key="constrConsult.label.loaiODF"/>', columntype: 'combobox', displayfield: 'loaiODFDisplay', datafield: 'loaiODF', align: 'center', cellsalign: 'center', width: "30%",
                createeditor: function (row, value, editor) {
                    editor.jqxComboBox({source: loaiODFAdapter, displayMember: 'label', valueMember: 'value'});
                }
            },
            {text: '<fmt:message key="constrConsult.label.chieuDai"/>',
                columntype: 'numberinput',
                datafield: 'chieuDai',
                align: 'center', cellsalign: 'center', width: "30%", filtertype: 'input',
                createeditor: function (row, cellvalue, editor) {
                    editor.jqxNumberInput({decimalDigits: 2, digits: 3});
                }, validation: function (cell, value) {
                    if (value < 0) {
                        return {result: false, message: "Giá trị phải lớn hơn 0"};
                    }
                    return true;
                }},
            {text: '<fmt:message key="constrConsult.label.donViTinh"/>',
                align: 'center', cellsalign: 'center', width: "25%",
                editable: false, cellsrenderer: formatDonViTinh
            },
            {
                text: '<fmt:message key="constrConsult.label.delete"/>',
                align: 'center', sortable: false,
                filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false, cellsrenderer: formatColumnDeleteHangingTranmissionODF,
                columntype: 'text', width: "9%"
            }
        ];
        ktts_control.buildGrid(hangingTranmissionODFSeletor, url, datafieldODF, columnODF, setting);

        //hangTranmissionMãngXong
        var hangingTranmissionMangXongSeletor = "#hangingTranmissionMangXongGrid";
        formatColumnDeleteHangingTranmissionMangXong = function (row, column, value) {
            var content = "<div style='margin:4px;text-align:center'>";
            content = content + "<img width=\"20\" height=\"20\" onclick=\"deleteHangingTranmissionMangXong(" + row + ")\" src= \"share/core/images/delete.png\" ></img>";

            content += "</div>";
            return content;
        };
        deleteHangingTranmissionMangXong = function (rowId) {
            $(hangingTranmissionMangXongSeletor).jqxGrid('deleterow', $(hangingTranmissionMangXongSeletor).jqxGrid('getrowid', rowId));
        };
        addHangingTranmissionMangXongRow = function () {
            $(hangingTranmissionMangXongSeletor).jqxGrid('addrow', null, {});
        };
        var loaiMangXongSource = [
            {value: 2, label: '<fmt:message key="constrConsult.label.mangXongLoai24"/>'},
            {value: 3, label: '<fmt:message key="constrConsult.label.mangXongLoai48"/>'},
            {value: 4, label: '<fmt:message key="constrConsult.label.mangXongLoai96"/>'},
            {value: 1, label: '<fmt:message key="label.khac"/>'}

        ];
        var loaiMangXongAdapter = new $.jqx.dataAdapter(loaiMangXongSource, {
            autoBind: true
        });
        var datafieldMangXong = [
            {name: 'loaiMangXong', type: 'int'},
            {name: 'loaiMangXongDisplay', value: 'loaiMangXong', values: {source: loaiMangXongAdapter.records, value: 'value', name: 'label'}},
            {name: 'soLuong', type: 'number'},
            {name: 'donViTinh', type: 'string'}
        ];
        var columnMangXong = [
            {
                text: '#', sortable: false, filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false,
                datafield: '', columntype: 'number', width: "3%",
                cellsrenderer: function (row, column, value) {
                    return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                }
            },
            {
                text: '<fmt:message key="constrConsult.label.loaiMangXong"/>', columntype: 'combobox', displayfield: 'loaiMangXongDisplay', datafield: 'loaiMangXong', align: 'center', cellsalign: 'center', width: "30%",
                createeditor: function (row, value, editor) {
                    editor.jqxComboBox({source: loaiMangXongAdapter, displayMember: 'label', valueMember: 'value'});
                }
            },
            {text: '<fmt:message key="constrConsult.label.soLuong"/>',
                columntype: 'numberinput',
                datafield: 'soLuong',
                align: 'center', cellsalign: 'center', width: "30%", filtertype: 'input',
                createeditor: function (row, cellvalue, editor) {
                    editor.jqxNumberInput({decimalDigits: 0, digits: 3});
                }, validation: function (cell, value) {
                    if (value < 0) {
                        return {result: false, message: "Giá trị phải lớn hơn 0"};
                    }
                    return true;
                }},
            {text: '<fmt:message key="constrConsult.label.donViTinh"/>',
                align: 'center', cellsalign: 'center', width: "25%",
                editable: false, cellsrenderer: formatDonViTinh
            },
            {
                text: '<fmt:message key="constrConsult.label.delete"/>',
                align: 'center', sortable: false,
                filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false, cellsrenderer: formatColumnDeleteHangingTranmissionMangXong,
                columntype: 'text', width: "9%"
            }
        ];
        ktts_control.buildGrid(hangingTranmissionMangXongSeletor, url, datafieldMangXong, columnMangXong, setting);

        //thietBiQuang
        var hangingTranmissionThietBiQuangSeletor = "#hangingTranmissionThietBiQuangGrid";
        formatColumnDeleteHangingTranmissionThietBiQuang = function (row, column, value) {
            var content = "<div style='margin:4px;text-align:center'>";
            content = content + "<img width=\"20\" height=\"20\" onclick=\"deleteHangingTranmissionThietBiQuang(" + row + ")\" src= \"share/core/images/delete.png\" ></img>";

            content += "</div>";
            return content;
        };
        deleteHangingTranmissionThietBiQuang = function (rowId) {
            $(hangingTranmissionThietBiQuangSeletor).jqxGrid('deleterow', $(hangingTranmissionThietBiQuangSeletor).jqxGrid('getrowid', rowId));
        };
        addHangingTranmissionThietBiQuangRow = function () {
            $(hangingTranmissionThietBiQuangSeletor).jqxGrid('addrow', null, {});
        };
        var loaiThietBiQuangSource = [
            {value: 2, label: '<fmt:message key="constrConsult.label.odfLoai24"/>'},
            {value: 3, label: '<fmt:message key="constrConsult.label.odfLoai48"/>'},
            {value: 4, label: '<fmt:message key="constrConsult.label.odfLoai96"/>'},
            {value: 1, label: '<fmt:message key="label.khac"/>'}

        ];
        var loaiThietBiQuangAdapter = new $.jqx.dataAdapter(loaiThietBiQuangSource, {
            autoBind: true
        });
        var datafieldThietBiQuang = [
            {name: 'loaiThietBiQuang', type: 'int'},
            {name: 'loaiThietBiQuangDisplay', value: 'loaiThietBiQuang', values: {source: loaiThietBiQuangAdapter.records, value: 'value', name: 'label'}},
            {name: 'chieuDai', type: 'number'},
            {name: 'donViTinh', type: 'string'}
        ];
        var columnThietBiQuang = [
            {
                text: '#', sortable: false, filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false,
                datafield: '', columntype: 'number', width: "3%",
                cellsrenderer: function (row, column, value) {
                    return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                }
            },
            {
                text: '<fmt:message key="constrConsult.label.loaiThietBiQuang"/>', columntype: 'combobox', displayfield: 'loaiThietBiQuangDisplay', datafield: 'loaiThietBiQuang', align: 'center', cellsalign: 'center', width: "30%",
                createeditor: function (row, value, editor) {
                    editor.jqxComboBox({source: loaiThietBiQuangAdapter, displayMember: 'label', valueMember: 'value'});
                }
            },
            {text: '<fmt:message key="constrConsult.label.chieuDai"/>',
                columntype: 'numberinput',
                datafield: 'chieuDai',
                align: 'center', cellsalign: 'center', width: "30%", filtertype: 'input',
                createeditor: function (row, cellvalue, editor) {
                    editor.jqxNumberInput({decimalDigits: 2, digits: 3});
                }, validation: function (cell, value) {
                    if (value < 0) {
                        return {result: false, message: "Giá trị phải lớn hơn 0"};
                    }
                    return true;
                }},
            {text: '<fmt:message key="constrConsult.label.donViTinh"/>',
                align: 'center', cellsalign: 'center', width: "25%",
                editable: false, cellsrenderer: formatDonViTinh
            },
            {
                text: '<fmt:message key="constrConsult.label.delete"/>',
                align: 'center', sortable: false,
                filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false, cellsrenderer: formatColumnDeleteHangingTranmissionThietBiQuang,
                columntype: 'text', width: "9%"
            }
        ];
        ktts_control.buildGrid(hangingTranmissionThietBiQuangSeletor, url, datafieldThietBiQuang, columnThietBiQuang, setting);
    });

</script>