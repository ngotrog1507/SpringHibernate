<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
    $(document).ready(function () {
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
            {text: 'Tên', datafield: 'name', width: 250},
            {text: 'Mô tả', datafield: 'description', width: 230},
            {text: 'Ngày doanh thu', datafield: 'dateProfit', width: 250
                , filtertype: 'date', cellsalign: 'right', cellsformat: 'd'},
            {text: 'Lợi nhuận', datafield: 'profit', width: 230},
            {text: 'Tổng lợi nhuận', datafield: 'total', width: 250}
        ];
        vt_datagrid.buildGridCheckBox("#jqxgrid", url, datafields, columns);

        $("#jqxgrid").on("pagechanged", function (event) {
            console.log("pagechanged");
        });

        $("#jqxgrid").on("pagesizechanged", function (event) {
            console.log("pagesizechanged");
        });

    });
</script>

</head>
<body class='default'>
    <div id="jqxgrid" style="width: 100%;min-height: 400px;">
    </div>
</body>
</html>
