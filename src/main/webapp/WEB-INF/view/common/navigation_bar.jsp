<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<ul class="navbar-nav navbar-sidenav" id="navBar">
    <%-- Charts --%>
    <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
        <a class="nav-link nav-link-collapse" data-toggle="collapse" href="#collapseComponents"
           data-parent="#navBar">
            <i class="fa fa-fw fa-area-chart"></i>
            <span class="nav-link-text">
                <spring:message code="navbar.charts.label"/>
            </span>
        </a>
        <ul class="sidenav-second-level show" id="collapseComponents">
            <li>
                <a>
                    <spring:message code="navbar.charts.weight.label"/>
                </a>
            </li>
            <li>
                <a>
                    <spring:message code="navbar.chart.food.energy.label"/>
                </a>
            </li>
        </ul>
    </li>
</ul>
<ul class="navbar-nav sidenav-toggler">
    <li class="nav-item">
        <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
        </a>
    </li>
</ul>