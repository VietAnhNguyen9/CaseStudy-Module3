<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/31/2023
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.casestudymd3.model.Role" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="/homepage/homepage.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>

<div id="wrapper">
    <jsp:include page="menu.jsp"/>

    <div id="main-content">

        <div id="sidebar" style="background: lightgray;">
            <h3 style="color: chocolate">Danh mục</h3>
            <ul style="list-style-type: none">
                <li><a href="songServlet" style="color: chocolate;text-decoration: none;">Tất cả bài hát</a></li>
                <%--                <li><a href="" style="color: chocolate;text-decoration: none;">Tạo album yêu thích</a></li>--%>
                <li><a href="albumServlet" style="color: chocolate;text-decoration: none;">Nghe theo album nhạc</a></li>
                <li><a href="singerServlet" style="color: chocolate;text-decoration: none;">Nghe theo ca sĩ</a></li>
                <c:if test="${sessionScope.user.role == Role.MEMBER}">
                    <li><a href="AlbumUser" style="color: chocolate;text-decoration: none;">Album của tôi</a></li>
                </c:if>
            </ul>
        </div>
        <div id="content" style="height: 600px; overflow-y: scroll">
            <p></p>
            <jsp:include page="testCRUD.jsp"/>

        </div>
    </div>

</div>
</body>
</html>
