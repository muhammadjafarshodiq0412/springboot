<%-- 
    Document   : listCandidate
    Created on : Dec 28, 2019, 10:44:16 AM
    Author     : Rizky
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
                    <h6>This page contains a candidate that passed the CV selection</h6>
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
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Job Role</th>
                                <th>Company</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach var = "list" items = "${list}" varStatus="loop">
                                <tr>
                                    <td><c:out value="${loop.count}"/></td>
                                    <td>${list.id}</td>
                                    <td>${list.candidate.firstName}</td>
                                    <td>${list.candidate.lastName}</td>
                                    <td>${list.vacancy.jobs.jobTitle}</td>
                                    <td>${list.vacancy.company}</td>
                                    <td>
                                        <a href="/addschedule?idcand=${list.candidate.id}&idprocess=${list.id}">Make Schedule</a>
                                    </td>apply?param1=${sadf}&param2=${sdfsf}
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
