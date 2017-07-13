<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


   <script>
$(function () {
    formatColumnNewDelete = function(row, column, value){
        var content = "<div style='margin:4px;text-align:center'>";
        content = content + "<img width=\"20\" height=\"20\" onclick=\"deleteCotNewColumn(" + row + ")\" src= \"share/core/images/delete.png\" ></img>";

        content += "</div>";
        return content;
    };
      formatColumnOldDelete = function(row, column, value){
        var content = "<div style='margin:4px;text-align:center'>";
        content = content + "<img width=\"20\" height=\"20\" onclick=\"deleteCotOldCoumn(" + row + ")\" src= \"share/core/images/delete.png\" ></img>";

        content += "</div>";
        return content;
    };
    
    deleteCotNewColumn=function(rowId){          
        $(gridnew).jqxGrid('deleterow',  $(gridnew).jqxGrid('getrowid',rowId));
    };
    deleteCotOldCoumn=function(rowid){
        $(gridold).jqxGrid('deleterow',  $(gridold).jqxGrid('getrowid',rowid));
    };
    formatDonViTinh=function(row,column,value){
        var content="<div style='margin:4px;text-align:center'>";
        content+='<fmt:message key="constrConsult.label.cot"/>';
        content+="</div>";
        return content;
    };
    var loaiCotSource=[
        {value:2, label:'<fmt:message key="constrConsult.label.cot7m"/>' },
        {value:3, label:'<fmt:message key="constrConsult.label.cot8m"/>' },
        {value:4, label:'<fmt:message key="constrConsult.label.cotHon8m"/>' }
    ];
    var loaiCotAdapter=new $.jqx.dataAdapter(loaiCotSource, {
             autoBind: true
         }); 

    var datafields = [            
         {name: 'loaiCot',type:'int'},
         {name: 'loaiCotDisplay',value: 'loaiCot',values:{source: loaiCotAdapter.records,value: 'value', name: 'label'}},
         {name: 'soLuong', type: 'number'},
         {name: 'donViTinh', type: 'string'}         
     ];
       
    var columnsNew = [
        {
            text: '#', sortable: false, filterable: false, editable: false,
            groupable: false, draggable: false, resizable: false,
            datafield: '', columntype: 'number', width: "3%",
            cellsrenderer: function (row, column, value) {
              return "<div style='margin:4px;'>" + (value + 1) + "</div>";
            }
        },
        {
            text: '<fmt:message key="constrConsult.label.loaiCot"/>', columntype: 'combobox',displayfield:'loaiCotDisplay', datafield: 'loaiCot', align:'center', cellsalign: 'center', width: "30%",   
            createeditor: function (row, value, editor) {
                 editor.jqxComboBox({ source: loaiCotAdapter, displayMember: 'label', valueMember: 'value' });
             }
        },
        {text: '<fmt:message key="constrConsult.label.soLuong"/>', 
            columntype: 'numberinput', 
            datafield: 'soLuong', 
            align:'center', cellsalign: 'center', width: "30%", filtertype: 'input',
            createeditor: function (row, cellvalue, editor) {
                    editor.jqxNumberInput({ decimalDigits: 0, digits: 3 });
            }, validation: function (cell, value) {
                if (value < 0) {
                    return { result: false, message: "Giá trị phải lớn hơn 0" };
                }
                return true;
            }},
        {text: '<fmt:message key="constrConsult.label.donViTinh"/>',            
            align:'center', cellsalign: 'center', width: "25%",
       
            editable: false,cellsrenderer: formatDonViTinh
            },
        {
            text: '<fmt:message key="constrConsult.label.delete"/>', 
            align:'center', sortable: false, 
            filterable: false, editable: false,
            groupable: false, draggable: false, resizable: false,cellsrenderer: formatColumnNewDelete,
            columntype: 'text', width: "9%"                       
        }
    ];
    var columnsOld = [
        {
            text: '#', sortable: false, filterable: false, editable: false,
            groupable: false, draggable: false, resizable: false,
                  datafield: '', columntype: 'number', width: "3%",
                  cellsrenderer: function (row, column, value) {
                    return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                  }
        },
        {
            text: '<fmt:message key="constrConsult.label.loaiCot"/>', 
            columntype: 'combobox',displayfield:'loaiCotDisplay', 
            datafield: 'loaiCot', align:'center', cellsalign: 'center', width: "30%",   
            createeditor: function (row, value, editor) {
                 editor.jqxComboBox({ source: loaiCotAdapter, displayMember: 'label', valueMember: 'value' });
             }
        },
               
        {text: '<fmt:message key="constrConsult.label.soLuong"/>', 
            datafield: 'soLuong', align:'center', 
            cellsalign: 'center', width: "30%", columnType:'numberinput',
            createeditor: function (row, cellvalue, editor) {
                    editor.jqxNumberInput({ decimalDigits: 0, digits: 3 });
            }, validation: function (cell, value) {
                if (value < 0) {
                    return { result: false, message: "Giá trị phải lớn hơn 0" };
                }
                return true;
            }
        },
        {text: '<fmt:message key="constrConsult.label.donViTinh"/>',
            align:'center', 
            width: "25%",cellsrenderer:formatDonViTinh, 
             editable: false,columntype: 'text'
           
        },
        {
            text: '<fmt:message key="constrConsult.label.delete"/>', 
            align:'center',
            sortable: false, filterable: false, editable: false,
                groupable: false, draggable: false, resizable: false,cellsrenderer: formatColumnOldDelete,
                columntype: 'text', width: "9%"                       
        }
    ];
    var setting = {
        pageable:false,
        editable:true,
        virtualmode:false,
        width:'100%',
        height:'120px'
    };
    var url = "selectPro.json";
    var gridnew="#hangingTranmissionCotNewGrid";
    var gridold="#hangingTranmissionCotOldGrid";
    ktts_control.buildGrid(gridnew, url, datafields, columnsNew, setting);
    
    ktts_control.buildGrid(gridold, url, datafields, columnsOld, setting);
       
    addCotNew = function(){
       $(gridnew).jqxGrid('addrow', null, {});
   };
   addCotOld = function(){
       $(gridold).jqxGrid('addrow', null, {});
   };

});

</script>