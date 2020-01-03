<%-- 
    Document   : vacancy_main
    Created on : Dec 31, 2019, 3:16:17 PM
    Author     : Elsa
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="frontend_templates/header.jsp"/>
<jsp:include page="frontend_templates/menu.jsp"/>

<style>
    /* Style the tab */
    .tab {
        overflow: hidden;
        border: 1px solid #ccc;
        background-color: #f1f1f1;
    }

    /* Style the buttons inside the tab */
    .tab button {
        background-color: inherit;
        float: left;
        border: none;
        outline: none;
        cursor: pointer;
        padding: 14px 16px;
        transition: 0.3s;
        font-size: 17px;
    }

    /* Change background color of buttons on hover */
    .tab button:hover {
        background-color: #ddd;
    }

    /* Create an active/current tablink class */
    .tab button.active {
        background-color: #ccc;
    }

    /* Style the tab content */
    .tabcontent {
        display: none;
        padding: 6px 12px;
        border: 1px solid #ccc;
        border-top: none;
    }
</style>

<section id="clients" class="section-bg">
    <main id="main">
        <section id="about">
            <div class="container">
                <center><h2>List of vacancy</h2></center><br>
                <div class="row">
                    <div class="col-12"> 
                        <div>

                            <table id="example" class="table table-striped table-bordered">
                                <tr>
                                    <th>Job</th>
                                    <th>Company</th>
                                    <th>Status</th>
                                    <th>Expired</th>
                                    <th></th>
                                </tr>
                                <c:forEach var = "list" items = "${vacancy}">
                                    <tr>
                                        <td>${list.jobs.jobTitle}</td>
                                        <td>${list.company.name}</td>
                                        <td> <c:set var = "status" scope = "session" value = "${list.status}"/>
                                            <c:if test = "${status==1}">
                                                <font style="background-color: chartreuse"> <c:out value = "active"/> </font>
                                            </c:if></td>
                                        <td>${list.expired}</td>
                                        <td><a href="/apply?user=${user.id}&vacancy=${list.id}"><i class="fa fa-check">Apply</i></a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>

                        <div id="Interview" class="tabcontent">
                            <h3>Scedule</h3>
                            <p>You will interview in </p>
                        </div>

                        <script>
                            function openCity(evt, cityName) {
                                var i, tabcontent, tablinks;
                                tabcontent = document.getElementsByClassName("tabcontent");
                                for (i = 0; i < tabcontent.length; i++) {
                                    tabcontent[i].style.display = "none";
                                }
                                tablinks = document.getElementsByClassName("tablinks");
                                for (i = 0; i < tablinks.length; i++) {
                                    tablinks[i].className = tablinks[i].className.replace(" active", "");
                                }
                                document.getElementById(cityName).style.display = "block";
                                evt.currentTarget.className += " active";
                            }
                        </script>
                    </div>
                </div>
            </div>
        </section>
    </main>
</section>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
<jsp:include page="frontend_templates/footer.jsp"/>
