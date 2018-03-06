<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<ul class="navbar-nav ml-auto">

    <%-- Profile settings --%>
    <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle mr-lg-2" id="settingsDropdown" href="#" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
            <c:out value="${sessionScope.currentUser.name}"/>
        </a>

        <div class="dropdown-menu" aria-labelledby="settingsDropdown">
            <a class="dropdown-item" href="#">
                <strong>
                    <spring:message code="toolbar.setting.label"/>
                </strong>
            </a>

            <div class="dropdown-divider"></div>

            <a class="dropdown-item" href="#">
                <strong>
                    <spring:message code="toolbar.settings.social.networks.label"/>
                </strong>
            </a>
        </div>
    </li>

    <%-- Logout --%>
    <li class="nav-item">
        <a class="nav-link" data-toggle="modal" data-target="#logoutModal">
            <i class="fa fa-fw fa-sign-out"></i>
            <spring:message code="toolbar.logout.button"/>
        </a>
    </li>
</ul>