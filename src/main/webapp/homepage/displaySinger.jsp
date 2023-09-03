<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.casestudymd3.model.Role" %>
<html>
<head>
    <title>Singer</title>
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
                <li><a href="" style="color: chocolate;text-decoration: none;">Tạo album yêu thích</a></li>
                <li><a href="albumServlet" style="color: chocolate;text-decoration: none;">Nghe theo album nhạc</a></li>
                <li><a href="singerSevlet" style="color: chocolate;text-decoration: none;">Nghe theo ca sĩ</a></li>

            </ul>
        </div>
        <div id="content">
            <div class="container">
                <h5 style="color: blue">List Singer</h5>
                <table class="table table-hover">
                    <tr>
                        <th>STT</th>
                        <th>Singer</th>
                        <c:if test="${sessionScope.user.role == Role.ADMIN}">
                            <th>Phone number</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>Action</th>
                        </c:if>
                    </tr>
                    <c:forEach items="${listS}" var="c" varStatus="in">
                        <tr>
                            <td><c:out value="${in.count}"/></td>
                            <td><a href="songServlet?action=singerSong&&id=${c.getUserId()}"><c:out
                                    value="${c.getUserName()}"/></a></td>
                            <c:if test="${sessionScope.user.role == Role.ADMIN}">
                                <td><c:out value="${c.getPhoneNumber()}"/></td>
                                <td><c:out value="${c.getEmail()}"/></td>
                                <td><c:out value="${c.getAddress()}"/></td>
                                <td>
                                    <button class="btn btn-danger" onclick="myFunction(${c.getUserId()})">Delete</button>

                                </td>
                            </c:if>

                        </tr>
                    </c:forEach>

                </table>
            </div>
            <p id="xoa"></p>
        </div>
    </div>

</div>
<script>
    function myFunction(c) {
        if (confirm("Bạn muốn xo bài hát? ")) {
            window.location.href = "singerServlet?action=deleteSinger&&id=" + c
            alert("Xóa thành công!")
        } else {
            alert("Xóa không thành công!")
        }
    }
</script>
</body>
</html>
