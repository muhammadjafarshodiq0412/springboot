<%-- 
    Document   : candidate_main
    Created on : Dec 30, 2019, 1:18:53 PM
    Author     : Elsa
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="./frontend_templates/header.jsp"/>
<jsp:include page="./frontend_templates/candidate_menu.jsp"/>

<section id="clients" class="section-bg">
    <main id="main">
        <section id="about">
            <div class="container">
                <div class="row">
                    <div class="col-4"><h4>Profil</h4>
                        <table class="table-sm active">
                            <c:forEach var = "list" items = "${candidate}">
                                <tr>
                                <img class="img-thumbnail" src="../resources/img/team-2.jpg" width="200px" height="200px"/>
                                </tr>
                                <tr>
                                    <td>Name</td>
                                    <td>${list.firstName} ${list.lastName}</td>
                                </tr>
                                <tr>
                                    <td>Gender</td>
                                    <td>${list.gender}</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td>${list.email}</td>
                                </tr>
                                <tr>
                                    <td>Phone</td>
                                    <td>${list.phone}</td>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>

                    <div data-role="page">
                        <div data-role="header">
                            <h1>Collapsible Forms</h1>
                        </div>

                        <div data-role="main" class="ui-content">
                            <form method="post" action="/action_page_post.php">
                                <fieldset data-role="collapsible">
                                    <legend>Personal Data</legend>
                                    <p><input type="hidden" name="id" value=""/></p>
                                    <p>First name:<input type="text" name="firstname" placeholder="First Name" /></p>
                                    <p>Last name:<input type="text" name="lastname" placeholder="Last Name" /></p>
                                    <p>Date of Birth:<input type="date" name="datebirth" placeholder="" /></p>
                                    <p>Place of Birth:<input type="text" name="placebirth" /></p>
                                    <p>Nationality:<input type="text" name="nationality" /></p>
                                    <p>Marital Status:
                                        <input type="radio" name="marit" value="single"/>Single
                                        <input type="radio" name="marit" value="marite"/>Marit</p>
                                    <p>Gender:
                                        <input type="radio" name="gender" value="male"/>Male
                                        <input type="radio" name="gender" value="female"/>Female</p>
                                    <p>Religion:
                                        <select name="religion">
                                            <option value="choose">Choose Religion</option>
                                            <option value="buddha">Buddha</option>
                                            <option value="hindu">Hindu</option>
                                            <option value="islam">Islam</option>
                                            <option value="catholic">Catholic</option>
                                            <option value="konghucu">Kong Hu Cu</option>
                                            <option value="protestant">Protestant</option>
                                        </select></p>

                                </fieldset>

                                <fieldset data-role="collapsible">
                                    <legend>Address Data</legend>
                                    <p>Address:
                                        <textarea rows="4" cols="50" placeholder="alamat lengkap">
                                        </textarea></p>
                                    <p>Current Address:<input type="text" name="addresscur" /></p>
                                    <p>Postal Code:<input type="text" name="poscode" /></p>
                                    <p>Province:
                                        <select name="province">
                                            <option value="province">Choose Province</option>
                                        </select></p>
                                    <p>District:
                                        <select name="district">
                                            <option value="district">Choose District</option>
                                        </select></p>
                                    <p>Sub-District:
                                        <select name="subdistrict">
                                            <option value="subdistrict">Choose Province</option>
                                        </select></p>
                                    <p>Village:
                                        <select name="vilage">
                                            <option value="vilage">Choose Village</option>
                                        </select></p>
                                    <p>Phone:<input type="text" name="phone" /></p>
                                    <p>Email:<input type="text" name="email" /></p>
                                </fieldset>

                                <fieldset data-role="collapsible">
                                    <legend>Other Data</legend>
                                    <p>Family Name:<input type="text" name="namefam" /></p>
                                    <p>Family Phone:<input type="text" name="phonefam" /></p>
                                    Curriculum Vitae: 
                                    <input type="file" name="files" multiple>
                                    <input type="submit" value="Upload Files">
                                    Pas Photo:
                                    <input type="file" name="files" multiple>
                                    <input type="submit" value="Upload Files">
                                    <p>KTP:<input type="text" name="ktp" /></p>
                                    <p>NPWP:<input type="text" name="npwp" /></p>
                                    <p>SIM:
                                        <input type="checkbox" name="sim" value="Bike">SIM A
                                        <input type="checkbox" name="vehicle2" value="Car">SIM C
                                        <input type="checkbox" name="vehicle2" value="Truck">SIM B</p>
                                    <p>Last Education:
                                        <select name="education">
                                            <option value="education">Choose Last Education</option>
                                            <option value="sma">SMA/SMK</option>
                                            <option value="d3">D3</option>
                                            <option value="s1">S1</option>
                                            <option value="s2">S2</option>
                                            <option value="s3">S3</option>
                                        </select></p>
                                    <p>Expected Salary:<input type="text" name="salaryexp" /></p>
                                    <input type="submit" data-inline="true" value="Submit">
                                </fieldset>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
            </div>
        </section>
    </main>
</section>
<jsp:include page="./frontend_templates/footer.jsp"/>
