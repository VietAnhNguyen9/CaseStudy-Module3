<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/2/2023
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../homepage/menu.jsp"/>
<div class="container" style="width: 400px; border:solid cornflowerblue; margin-top: 100px; border-radius: 15px">
    <h1 style="text-align: center; color:cornflowerblue">Thêm bài hát mới</h1>
<form action="/songServlet?action=create" method="post">
    <div class="form-outline mb-4">
        <input class="form-control" name="name" placeholder="Nhập tên bài hát" required/>
    </div>
    <div class="form-outline mb-4">
        <input class="form-control" name="linkFile"
               placeholder="Nhập link File" required/>
    </div>
    <div class="form-outline mb-4">
        <input class="form-control" name="avatarFile"
               placeholder="Thêm Avatar"/>
    </div>
    <div class="form-outline mb-4">
        <input class="form-control" name="description"
               placeholder="Nhập mô tả" required/>
    </div>
    <!-- Submit button -->
    <button type="submit" class="btn btn-primary btn-block mb-4" style="width: 372px; margin: auto">Thêm</button>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
