<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Navigation --%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <%-- Logo --%>
    <a class="navbar-brand" href="<c:url value="/dashboard"/>">MY FITNESS</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <%-- Navigation components --%>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <jsp:include page="/WEB-INF/view/common/navigation_bar.jsp"/>
        <jsp:include page="/WEB-INF/view/common/toolbar.jsp"/>
    </div>
</nav>