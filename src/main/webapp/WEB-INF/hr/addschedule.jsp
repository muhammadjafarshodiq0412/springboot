<%-- 
    Document   : newjsf
    Created on : Dec 31, 2019, 3:23:23 AM
    Author     : Rizky
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
<jsp:include page="../templates/topbar.jsp"></jsp:include>
<jsp:include page="../templates/sidebar.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                        <h1>Add Psychotest Schedule</h1><hr>
                        <form method="post" action="/addPsychotestSchedule/save">                            
                            <div class="form-group row">
                                <label for="idcandidate" class="col-sm-2 col-form-label">
                                    Id Candidate
                                </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" value="${scheduleList.candidate.id}" 
                                           name="idcand" readonly />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="idprocessstatus" class="col-sm-2 col-form-label">
                                    Id Process Status
                                </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" value="${scheduleList.id}" 
                                           name="idprocess" readonly />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="name" class="col-sm-2 col-form-label">
                                    Name
                                </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control"
                                           value="${scheduleList.candidate.firstName} ${scheduleList.candidate.lastName}" name="name" readonly />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="job" class="col-sm-2 col-form-label">
                                    Job
                                </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" value="${scheduleList.vacancy.jobs.jobTitle}" 
                                           name="jobTitle" readonly />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="company" class="col-sm-2 col-form-label">
                                    Company
                                </label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" value="${scheduleList.vacancy.company}" 
                                           name="company" readonly />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="" class="col-sm-12 col-form-label">
                                    <center /><b>Add Online Psychotest Schedule</b>
                                </label>
                            </div>
                            <div class="form-group row">
                                <label for="start" class="col-sm-2 col-form-label">
                                    Start Date
                                </label>
                                <div class="col-sm-4">
                                    <input type="date" class="form-control" name="start_date" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="start" class="col-sm-2 col-form-label">
                                    End Date
                                </label>
                                <div class="col-sm-4">
                                    <input type="date" class="form-control" name="end_date" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-12">
                                    <center>
                                        <input type="submit" class="btn btn-primary" value="Submit" />
                                        <a href="/candidate" class="btn btn-secondary">Cancel</a>
                                    </center>
                                </div>
                            </div>
                        </form>
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