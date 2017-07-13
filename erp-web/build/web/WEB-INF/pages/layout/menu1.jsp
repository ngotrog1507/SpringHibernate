<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="title"><tiles:getAsString name="title" ignore="true" /></c:set>


    <div id='cssmenu'>
        <ul>
            <li><a href='index.html'><span><img src="${pageContext.request.contextPath}/share/core/images/home_icon.png"></span></a></li>
            <li>
            <li class='has-sub'><a href='#'><span> Thêm mới menu tại menu1.jsp</span></a>
                <ul>
                     <li><a href='#'><span>Hello</span></a></li>
                </ul>
            </li>
        <c:if test="${vsaUserToken.parentMenu.size() > 0}">
            <c:forEach items="${vsaUserToken.parentMenu}" var="parentMenu">  
                <c:if test="${parentMenu.childObjects.size() == 0 && parentMenu.objectType == 'M'}">
                    <li><a href='#${parentMenu.objectUrl}'><span> <fmt:message key="${parentMenu.objectCode}" /></span></a></li>
                    </c:if>
                    <c:if test="${parentMenu.childObjects.size() > 0 && parentMenu.objectType == 'M'}">
                    <li class='has-sub'><a href='#'><span> <fmt:message key="${parentMenu.objectCode}" /></span></a>
                        <ul>
                            <c:forEach items="${parentMenu.childObjects}" var="childObject"> 
                                <c:if test="${childObject.childObjects.size() == 0 && childObject.objectType == 'M'}">
                                    <li><a href='#${childObject.objectUrl}'><span> <fmt:message key="${childObject.objectCode}" /></span></a></li>
                                    </c:if>
                                    <c:if test="${childObject.childObjects.size() > 0 && childObject.objectType == 'M'}">
                                    <li class='has-sub'><a href='#'><span> <fmt:message key="${childObject.objectCode}" /></span></a>
                                        <ul>
                                            <c:forEach items="${childObject.childObjects}" var="childObject1"> 
                                                <c:if test="${childObject1.childObjects.size() == 0 && childObject1.objectType == 'M'}">
                                                    <li><a href='#${childObject1.objectUrl}'><span> <fmt:message key="${childObject1.objectCode}" /></span></a></li>
                                                    </c:if>                                   
                                                </c:forEach>
                                        </ul>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </li>
                </c:if>
            </c:forEach>   
        </c:if>
    </ul>

</div> 
<div class="headerUser1" >        
    <a href="#" id="hrefAccount">
        <fmt:message key="welcome.user" />:${vsaUserToken.fullName}
    </a>
    |    
    <a href="logout.html"><fmt:message key="header.logout" /></a>
</div>
<div id="popover">
    <div>
        <table>
            <tr>
                <td class="label"><fmt:message key="welcome.identityCard" /></td>
                <td>${vsaUserToken.identityCard}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="welcome.fullName" /></td>
                <td>${vsaUserToken.fullName}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="welcome.deptName" /></td>
                <td>${vsaUserToken.deptName}</td>
            </tr>
        </table>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#cssmenu").jqxMenu({width: '100%', height: '35px'});
        $('#cssmenu').on('itemclick', function (event) {
            var args = event.args;
            var href = $(args).children("a").attr("href");
            if (href !== "" && href !== "#") {
                if ($('#jqxTabs').jqxTabs('length') == 2) {
                    $('#jqxTabs').jqxTabs('removeLast');
                }
                $('#jqxTabs').jqxTabs('addLast', '', ''); 
                vt_util.load2LastTab("#jqxTabs", href.substr(1));
            }
            $(".dialog-form").remove();
        });
        $("#popover").jqxPopover({offset: {left: -50, top: 0}, arrowOffsetValue: 50
            , title: "<fmt:message key="welcome.info" />", showCloseButton: true, selector: $("#hrefAccount")});
    });

</script>
