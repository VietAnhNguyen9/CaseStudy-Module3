<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/31/2023
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.casestudymd3.model.Role" %>
<html>
<head>
    <link rel="stylesheet" href="homepage.css">
</head>
<body>

<div id="wrapper">
    <jsp:include page="menu.jsp"/>
    <div id="main-content">
        <div id="sidebar">
            <h3>Danh mục</h3>
            <ul>
                <li><a href="">Tất cả bài hát</a></li>
                <li><a href="">Tạo album yêu thích</a></li>
                <li><a href="">Nghe theo album nhạc</a></li>
                <li><a href="">Nghe theo ca sĩ</a></li>
            </ul>
        </div>
        <div id="content">
            <p>Cho danh sách bài hát vào đây</p>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
