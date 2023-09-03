<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Album</title>
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
                <li><a href="songServlet"  style="color: chocolate;text-decoration: none;">Tất cả bài hát</a></li>
                <li><a href="" style="color: chocolate;text-decoration: none;">Tạo album yêu thích</a></li>
                <li><a href="albumServlet" style="color: chocolate;text-decoration: none;">Nghe theo album nhạc</a></li>
                <li><a href="singerServlet" style="color: chocolate;text-decoration: none;">Nghe theo ca sĩ</a></li>
            </ul>
        <div id="content">
            <div class="container">

                <h5 style="color: blue">List Album</h5>
                <a class="btn btn-primary" href="albumServlet?action=createAlbum">Create album</a>
                <a class="btn btn-info" href="songServlet">Back to home</a>

                <table class="table table-hover">
                    <tr>
                        <th>STT</th>
                        <th>Name</th>
                        <th colspan="2" style="text-align: left">Action</th>
                    </tr>
                    <c:forEach items="${listA}" var="c" varStatus="in">
                        <tr>
                            <td><c:out value="${in.count}"/></td>
                            <td><a href="songServlet?action=albumDetail&&id=${c.getAlbumId()}"><c:out value="${c.getAlbumName()}"/></a></td>
                            <td>
                                <a class="btn btn-warning" href="albumServlet?action=updateAlbum&&id=${c.getAlbumId()}">Update</a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>


</div>

</body>
</html>
