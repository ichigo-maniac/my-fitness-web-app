<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title><spring:message code="dashboard.page.header"/></title>
    <jsp:include page="/WEB-INF/view/common/style_libs_fragment.jsp"/>
</head>


<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<jsp:include page="/WEB-INF/view/common/navigation_fragment.jsp"/>

<div class="content-wrapper">
    <div class="container-fluid">
        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <a href="index.html">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Blank Page</li>
        </ol>

        <!-- Area Chart Example-->
        <div class="card mb-3">
            <div class="card-header">
                <i class="fa fa-area-chart"></i> Area Chart Example</div>
            <div class="card-body">
                <canvas id="myAreaChart" width="100%" height="30"></canvas>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
        <%--<div class="row">--%>
            <%--<div class="col-12">--%>
                <%--<h1>Blank</h1>--%>

                <%--<p>This is an example of a blank page that you can use as a starting point for creating new ones.</p>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © Your Website 2018</small>
            </div>
        </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fa fa-angle-up"></i>
    </a>

    <jsp:include page="/WEB-INF/view/common/logout_modal_fragment.jsp"/>
    <jsp:include page="/WEB-INF/view/common/js_libs_fragment.jsp"/>
    <script src="/resources/js/lib/Chart.min.js"></script>
    <script src="/resources/js/lib/sb-admin.js"></script>
    <script src="/resources/js/lib/sb-admin-charts.js"></script>
</div>
</body>


</html>