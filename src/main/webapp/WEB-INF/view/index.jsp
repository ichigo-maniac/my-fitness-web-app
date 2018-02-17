<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title><spring:message code="login.page.header"/></title>
    <jsp:include page="/WEB-INF/view/common/style_libs_fragment.jsp"/>
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header" style="text-align: center">
            <spring:message code="login.form.header"/>
        </div>
        <div class="card-body" style="text-align: center">
            <a href="<c:url value="/oauth/facebook"/>" style="margin-right: 5px;">
                <img src="/resources/images/app/social_networks/facebook_big.png" class="icon-button" style="border: none"/>
            </a>
            <a href="<c:url value="/oauth/vkcom"/>" style="margin-right: 5px;">
                <img src="/resources/images/app/social_networks/vkontakte_big.png" class="icon-button" style="border: none"/>
            </a>
            <a href="<c:url value="/oauth/twitter"/>" style="margin-right: 5px;">
                <img src="/resources/images/app/social_networks/twitter_big.png" class="icon-button" style="border: none"/>
            </a>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/view/common/js_libs_fragment.jsp"/>
</body>

</html>