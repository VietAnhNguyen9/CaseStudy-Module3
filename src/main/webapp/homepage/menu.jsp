<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/31/2023
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.casestudymd3.model.Role" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div id="header">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <img src="/fileimg/logo.jpg" width="80px" height="80px" style="background: aliceblue">

            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/songServlet">Home</a>
                    </li>
                    <c:if test="${sessionScope.user.role == Role.ADMIN}">
                        <li class="nav-item">
                            <a class="nav-link" href="">Account Manager</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Revenue Website</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user.role == Role.SINGER}">
                    <li class="nav-item">
                        <a class="nav-link" href="/songServlet?action=songManager">Song Manager</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Revenue</a>
                    </li>
                    </c:if>
                    <c:if test="${sessionScope.user == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Login</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/login?action=logout">Logout</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" style="color: chocolate">Hello ${sessionScope.user.userName} !</a>
                        </li>
                    </c:if>

                </ul>
                <form action="songServlet?action=searchByName" class="d-flex" role="search" method="post">
                    <input class="form-control me-2" name="nameSearch" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>

