<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    $(function(){
        console.log("homepage");
    })
</script>

<table align="center" width="80%" >
    <tr>
        <td align="center" >
            <font color="#267ED5">
            <h1>
                <fmt:message key="welcome.erp" />
            </h1>
            </font>
        </td>
    </tr>
</table>

