<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/31/2023
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <jsp:include page="testCRUD.jsp"/>

        </div>
    </div>

</div>
</body>
</html>
