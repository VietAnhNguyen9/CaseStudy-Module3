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
        <div id="sidebar">
            <h3>Danh mục</h3>
            <ul>
                <li><a href="songServlet">Tất cả bài hát</a></li>
                <li><a href="">Tạo album yêu thích</a></li>
                <li><a href="albumServlet">Nghe theo album nhạc</a></li>
                <li><a href="singerServlet">Nghe theo ca sĩ</a></li>
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
<%--                         <th>Time create</th>--%>
                        <th>Action</th>--%>
                        </c:if>
                    </tr>
                    <c:forEach items="${listS}" var="c" varStatus="in">
                        <tr>
                            <td><c:out value="${in.count}"/></td>
                            <td><a href="songServlet?action=singerSong&&id=${c.getUserId()}"><c:out value="${c.getUserName()}"/></a></td>
                            <c:if test="${sessionScope.user.role == Role.ADMIN}">
                                <td><c:out value="${c.getPhoneNumber()}" /> </td>
                                <td><c:out value="${c.getEmail()}" /> </td>
                                <td><c:out value="${c.getAddress()}" /> </td>
                                <td>
                                    <a class="btn btn-warning"
                                       onclick="myFunction()"
                                       href="singerServlet?action=deleteSinger&&id=${c.getUserId()}">Delete</a>

                                </td>
                            </c:if>

                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>

</div>
<script>
    function myFunction() {
        if (confirm("If delete singer, you will delete songs of that singer!")){

        }
    }
</script>
</body>
</html>
