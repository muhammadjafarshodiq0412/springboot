<%-- 
    Document   : listPsychotest
    Created on : Jan 2, 2020, 2:51:37 AM
    Author     : Jafar
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./templates/header.jsp"></jsp:include>
<jsp:include page="./templates/topbar.jsp"></jsp:include>
<jsp:include page="./templates/sidebar.jsp"></jsp:include>

    <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Bread crumb and right sidebar toggle -->
        <!-- ============================================================== -->
        <div class="page-breadcrumb">
            <div class="row">
                <div class="col-12 d-flex no-block align-items-center">
                    <div class="page-title">
                        <h4>Vacancy</h4>
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
        <!-- Flash data Start -->
        <!-- ============================================================== -->
        <c:forEach var = "splash" items = "${flash}">
        <!--<div class="flash-data" data-flashdata="${splash}">--> 
        <script>
            const flashdata = $('.flash-data').data('flashdata');
            if (flashdata) {
                swal({
                    title: 'Information',
                    text: 'Success ' + flashdata,
                    type: 'success'
                });
            }
        </script>
    </div>
    <!-- ============================================================== -->
    <!-- Flash data End -->

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-md-10">
                                <h3>Vacancy Data</h3>
                            </div>
                            <div class="col-md-2">
                                <button data-toggle="modal" data-target="#additem" class="btn btn-primary btn-block">
                                    Create
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <table id="listItem" class="table table-borderless table-striped table-earning">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Id</th>
                                    <th>Job</th>
                                    <th>Company</th>
                                    <th>Description</th>
                                    <th>Status</th>
                                    <th>Expired</th>
                                    <th class="text-right">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var = "list" items = "${listVacancy}" varStatus="loop">
                                    <tr>
                                        <td><c:out value="${loop.count}"/></td>
                                        <td>${list.id}</td>
                                        <td>${list.jobs.jobTitle}</td>
                                        <td>${list.company.name}</td>
                                        <td>${list.description}</td>
                                        <td> <c:if test = "${list.status==1}">
                                                <font style="background-color: chartreuse "> <c:out value = "active"/> </font>
                                            </c:if>
                                            <c:if test = "${list.status==0}">
                                                <font style="background-color: yellow "> <c:out value = "non-active"/> </font>
                                            </c:if>
                                        <td>${list.expired}</td>
                                        <td>
                                            <a href="${list.id}" class="view_data" 
                                               data-toggle="modal" id="${list.id}" data-target="#editModal">
                                                <i class="fas fa-edit fa-lg" style="color:#26a65b;"></i>
                                            </a>

                                            <a href="/deleteVacancy/${list.id} " 
                                               class="tombol-hapus" data-toogle="tooltip" title="Delete">
                                                <i class="fas fa-trash"style="color:#f03434;"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>  
                </div>
            </div>
        </div>
    </div>
</div>

<!-- modal country large -->
<div class="modal fade" id="additem" tabindex="-1" role="dialog" aria-labelledby="largeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="largeModalLabel">Add New Vacancy</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="/vacancy/save" method="post" class="form-horizontal">
                    <div class="form-group">
                        <input type="hidden" name="id" value=""/>
                        <label>Job</label>
                        <select class="form-control" name="job">
                            <option value="job">Choose Job</option>
                            <c:forEach items="${listJob}" var="listJob" >
                                <option value="${listJob.id}">${listJob.jobTitle}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Company</label>
                        <select class="form-control" name="company">
                            <option value="company">Choose Company</option>
                            <c:forEach items="${listCompany}" var="listCompany" >
                                <option value="${listCompany.id}">${listCompany.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea rows="3" placeholder="Job Description" id="descrip" name="descrip" class="form-control"></textarea>
                    </div>
                    <!--<div class="form-group">-->
                    <!--<label>Status</label>-->
                    <fieldset class="form-group">
                        <div class="row">
                            <label class="col-form-label col-sm-1 pt-0">Status</label>
                            <div class="col-sm-10">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="status" value="1" >
                                    <label class="form-check-label" for="gridRadios1">
                                        Aktif
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="status" value="0">
                                    <label class="form-check-label" for="gridRadios2">
                                        Tidak Aktif
                                    </label>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <!--                        <input type="radio" name="status" value="1" class="form-control"/><label>Aktif</label>
                                            <input type="radio" name="status" value="0" class="form-control"/>-->

                    <div class="form-group">
                        <label>Expired</label>
                        <input type="date" name="expired" class="form-control"/>
                    </div>
            </div>
            <div class="modal-footer">
                <input type="submit" name="submit" value="Save" class="btn btn-primary "/>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end modal large -->


<!-- memulai modal nya. pada id="$myModal" harus sama dengan data-target="#myModal" pada tombol di atas -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="myModalLabel">Edit Vacancy</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!-- memulai untuk konten dinamis -->
            <!-- lihat id="data_siswa", ini yang di pangging pada ajax di bawah -->
            <div class="modal-body" id="data">

            </div>
            <!-- selesai konten dinamis -->
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
<script type="text/javascript">
    function success() {
        swal({
            title: "Success Saved!",
            text: "You Success Saved New Data!",
            icon: "success",
            timer: 2500
        });
    }
</script>


<script type="text/javascript">
    $(document).ready(function () {
        $("body").on('click', '.view_data', function () {
            var id = $(this).attr("id");
            $.ajax({
                url: "/updateVacancy?id=" + id,
                type: "GET",
                data: {id: id},
                success: function (data) {
                    $("#data").html(data);
                    $("#editModal").modal('show', {backdrop: 'true'});
                }
            });
        });
    });
//   
</script>

<script>
    $('.tombol-hapus').on('click', function () {
        event.preventDefault();
        const href = $(this).attr("href");
        swal({
            title: 'Are you sure?',
            text: "Delete Data",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes'
        }).then((result) => {
            if (result.value) {
                window.location.href = href;
            }
        });
    });
</script>



<jsp:include page="./templates/footer.jsp"></jsp:include>
