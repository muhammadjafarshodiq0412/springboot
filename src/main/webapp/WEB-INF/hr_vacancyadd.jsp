<%-- 
    Document   : hr_vacancyadd
    Created on : Jan 2, 2020, 11:08:46 AM
    Author     : HP
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="./templates/header.jsp"></jsp:include>
<jsp:include page="./templates/topbar.jsp"></jsp:include>
<jsp:include page="./templates/sidebar.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- ============================================================== -->
<!-- Page wrapper  -->
<!-- ============================================================== -->
<div class="page-wrapper">
    <!-- ============================================================== -->
    <!-- Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-12 d-flex no-block align-items-center">
                <h4 class="page-title">Vacancy</h4>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Candidate</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- End Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Container fluid  -->
    <!-- ============================================================== -->
    <div class="container-fluid">
        <!-- ============================================================== -->
        <!-- Sales Cards  -->
        <!-- ============================================================== -->
        <div data-role="page">
            <div data-role="header">
                <h1>Vacancy Add</h1>
            </div>

            <div data-role="main" class="ui-content">
                    <form method="post" action="/vacancy/save">
                        <p><input type="hidden" name="id" value=""/></p>
                        <p>Job:
                            <select name="job">
                                <option value="job">Choose Job</option>
                                <c:forEach items="${listJob}" var="listJob" >
                                    <option value="${listJob.id}">${listJob.jobTitle}</option>
                                </c:forEach>
                            </select></p>
                        <p>Company:
                            <select name="company">
                                <option value="company">Choose Company</option>
                                <c:forEach items="${listCompany}" var="listCompany" >
                                    <option value="${listCompany.id}">${listCompany.name}</option>
                                </c:forEach>
                            </select></p>
                        Description:
                        <textarea name="descrip" rows="4" cols="50" placeholder="Job Description"></textarea>
                        <div class="form-row">
                            Status:
                            <input type="radio" name="status" value="1"/>Aktif
                            <input type="radio" name="status" value="0"/>Tidak Aktif
                        </div>
                        <p>Expired:<input type="date" name="expired" /></p>

                        <input type="submit" data-inline="true" value="Submit">
                    </form>
            </div>
        </div>

    </div>
    <!-- ============================================================== -->
    <!-- End Container fluid  -->
    <!-- ============================================================== -->
    <jsp:include page="./templates/footer.jsp"></jsp:include>