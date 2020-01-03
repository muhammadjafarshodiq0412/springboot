<%-- 
    Document   : hr_vacancyedit
    Created on : Jan 2, 2020, 11:33:03 AM
    Author     : Jafar
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<form action="/vacancy/save" method="post" class="form-horizontal">
    <div class="form-group">
        <input type="hidden" name="id" value="${update.id}"/>
        <label>Job</label>
        <select class="form-control" name="job">
            <option value="${update.jobs.id}">${update.jobs.jobTitle}</option>
            <option>----------------------------</option>
            <option value="job">Choose Job</option>
            <c:forEach items="${listJob}" var="listJob" >
                <option value="${listJob.id}">${listJob.jobTitle}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Company</label>
        <select class="form-control" name="company">
            <option value="${update.company.id}">${update.company.name}</option>
            <option>----------------------------</option>
            <option value="company">Choose Company</option>
            <c:forEach items="${listCompany}" var="listCompany" >
                <option value="${listCompany.id}">${listCompany.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Description</label>
        <textarea row="4" placeholder="Job Description" id="descrip" name="descrip" class="form-control" >${update.description}
        </textarea>
    </div>
    <!--<div class="form-group">-->
    <!--<label>Status</label>-->
    <fieldset class="form-group">
        <div class="row">
            <label class="col-form-label col-sm-1 pt-0">Status</label>
            <div class="col-sm-10">
                <div class="form-check">
                    <input 
                        <c:if test = "${update.status == 1}">
                            <c:out value = "checked"/>
                        </c:if> 
                        class="form-check-input" type="radio" name="status" value="1" >
                    <label class="form-check-label" for="gridRadios1">
                        Aktif
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="status" 
                           <c:if test = "${update.status == 0}">
                               <c:out value = "checked"/>
                           </c:if>
                           value="0">
                    <label class="form-check-label" for="gridRadios2">
                        Tidak Aktif
                    </label>
                </div>
            </div>
        </div>
    </fieldset>
    <div class="form-group">
        <label>Expired</label>
        <input type="date" value="${update.expired}" name="expired" class="form-control"/>
    </div>
</div>
<div class="modal-footer">
    <input type="submit" name="submit" value="Save" class="btn btn-primary "/>
</form>