<%-- 
    Document   : vacancy
    Created on : Dec 30, 2019, 7:04:12 PM
    Author     : HP
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

    <html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
            <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
            <script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        </head>
        <body>
            <div data-role="page">
                <div data-role="header">
                    <h1>HR Recuitment</h1>
                </div>

                <div data-role="main" class="ui-content">
                    <form method="post" action="/vacancy/save">
                        <!--<fieldset data-role="collapsible">-->
                        <fieldset>
                            <h2>Vacancy Insert</h2>
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
                        </fieldset>
                    </form>
                </div>
            </div>
        </body>
    </html>