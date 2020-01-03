<%-- 
    Document   : listPsychotest
    Created on : Jan 2, 2020, 2:51:37 AM
    Author     : Rizky
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
<jsp:include page="../templates/topbar.jsp"></jsp:include>
<jsp:include page="../templates/sidebar.jsp"></jsp:include>

    <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Bread crumb and right sidebar toggle -->
        <!-- ============================================================== -->
        <div class="page-breadcrumb">
            <div class="row">
                <div class="col-12 d-flex no-block align-items-center">
                    <div class="page-title">
                        <h4>${title}</h4>
                    <h6>This page contains a psychotest schedule for candidate</h6>
                </div>
                <div class="ml-auto text-right">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Library</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <table id="listItem" class="table table-hover table-responsive table-striped listItem">
                            <tr>
                                <th>No</th>
                                <th>Id</th>
                                <th>Job</th>
                                <th>Company</th>
                                <th>Description</th>
                                <th>Status</th>
                                <th>Expired</th>
                                <th>Action</th>
                            </tr>
                              <c:forEach var = "list" items = "${listVacancy}" varStatus="loop">
                        <tr>
                            <td><c:out value="${loop.count}"/></td>
                            <td>${list.id}</td>
                            <td>${list.jobs.jobTitle}</td>
                            <td>${list.company.name}</td>
                            <td>${list.description}</td>
                            <td>${list.status}</td>
                            <td>${list.expired}</td>
                            <td>
                                <a href="/updateVacancy/${list.id}&idproccess=${list.id}">Edit</a>
                                <a href="/deleteVacancy/${list.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#listItem').DataTable();
//                    {
//                        "columnDefs": [
//                            {"orderable": false, "targets": 3}
//                        ]
//                    }
//            );
        });
    </script>



    <jsp:include page="../templates/footer.jsp"></jsp:include>
