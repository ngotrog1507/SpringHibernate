<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


   <script>
$(function () {
       
      
        formatColumnDelete = function(row, column, value){
            var content = "<div style='margin:4px;text-align:center'>";
//            console.log(row);
//            console.log(column);
//            console.log(value);
            content = content + "<img width=\"20\" height=\"20\" onclick=\"deleteBtsCotRow(" + row + ")\" src= \"share/core/images/delete.png\" ></img>";
            
            content += "</div>";
            return content;
       };
       deleteBtsCotRow=function(rowId){          
           $(gridSelector).jqxGrid('deleterow',  $(gridSelector).jqxGrid('getrowid',rowId));
       };
       formatColumnLoaiCap=function(row,column,value){
           
       };
       var loaiCapDienSource=[
           {value:2, label:'Cáp quang F8-96Fo'},
            {value:3, label:' Cáp quang F8-48Fo'},
             {value:4, label:'Cáp quang F8-24Fo'},
              {value:5, label:'Cáp quang ADSS100-96Fo'},
               {value:6, label:'Cáp quang ADSS100-48Fo'},
                {value:7, label:'Cáp quang ADSS100-24Fo'},
                 {value:8, label:'Cáp quang ADSS100-96Fo'},
                  {value:9, label:'Cáp quang ADSS100-48Fo'},
                  {value:10, label:'Cáp quang ADSS100-24Fo'},
                  {value:1, label: 'Khác'}
               ];
             var loaiCapDienAdapter = new $.jqx.dataAdapter(loaiCapDienSource, {
                autoBind: true
            });
              var datafields = [            
               {name: 'loaiCapDien',values:{source: loaiCapDienAdapter.records,value: 'value', name: 'label'}},
               {name: 'loaiCapDienDisplay',value: 'loaiCapDien',values:{source: loaiCapDienAdapter.records,value: 'value', name: 'label'}},
               {name: 'chieuDaiCapDien', type: 'string'},
               {name: 'donViTinh', type: 'string'}
           ];
       
       var columns = [
             {
                 text: '#', sortable: false, filterable: false, editable: false,
                 groupable: false, draggable: false, resizable: false,
                       datafield: '', columntype: 'number', width: "3%",
                       cellsrenderer: function (row, column, value) {
                         return "<div style='margin:4px;'>" + (value + 1) + "</div>";
                       }
               },
               {text: "Loại cáp điện", columntype: 'combobox',displayfield:'loaiCapDienDisplay', datafield: 'loaiCapDien', align:'center', cellsalign: 'center', width: "30%",   
                   createeditor: function (row, value, editor) {
                        editor.jqxComboBox({ source: loaiCapDienSource, displayMember: 'label', valueMember: 'value' });
                    }},
               
               {text: "Chiều dài cáp điện", datafield: 'chieuDaiCapDien', align:'center', cellsalign: 'center', width: "30%", filtertype: 'input'},
               {text: "Đơn vị tính", datafield: 'donViTinh', align:'center', cellsalign: 'center', width: "25%"},
               {
               text: "Xóa", align:'center', sortable: false, filterable: false, editable: false,
                       groupable: false, draggable: false, resizable: false,cellsrenderer: formatColumnDelete,
                       columntype: 'text', width: "11%"
                       
               }

           ];
          
     
       var setting = {
           pageable:false,
           editable:true,
           virtualmode:false,
           width:'100%',
           height:'100px'
       };
       var url = "selectPro.json";
       var gridSelector="[name=btsGrid1]";
       ktts_control.buildGrid(gridSelector, url, datafields, columns, setting);
       $(gridSelector).on('cellendedit', function (event) {
            var args = event.args;
            console.log(event);
            console.log('end');
            console.log(args);
        });
       addNewDienAc = function(){
           var value = $(gridSelector).jqxGrid('addrow', null, {});
       };

    });

</script>