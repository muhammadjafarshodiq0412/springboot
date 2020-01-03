<%-- 
    Document   : menu
    Created on : Dec 30, 2019, 9:18:21 AM
    Author     : Elsa
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<body>

    <!--==========================
    Header
    ============================-->
    <header id="header" class="fixed-top">
        <div class="container">
            <img src="../resources/img/icon.png" alt="" height="50px" width="50px"></a>

            <nav class="main-nav float-right d-none d-lg-block">
                <ul>
                    <li class="active"><a href="#intro">Home</a></li>
                    <li><a href="#about">About Us</a></li>
                    <li><a href="#career">Career</a></li>
                    <li><a href="#portfolio">Portfolio</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                        <c:if test = "${user != null}">
                        <li> <a href="">${user.username}</a></li>
                        </c:if> 
                        <c:if test = "${user == null}">
                        <li><a href="/">Login</a></li>
                        </c:if> 
                </ul>
            </nav><!-- .main-nav -->

        </div>
    </header><!-- #header -->