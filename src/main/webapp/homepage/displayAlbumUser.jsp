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
        <div id="sidebar">
            <h3>Danh mục</h3>
            <ul>
                <li><a href="PurchasedSongsServlet">Thêm Bài Hát Vào Album</a></li>
                <li><a href="BuySongServlet">Mua Bài Hát</a></li>
                <li><a href="BillSongPurchasedServlet">Hóa Đơn Mua Nhạc</a></li>
            </ul>
        </div>
        <div id="content">
            <div class="container">

                <h5 style="color: blue">List Album</h5>

                <a class="btn btn-primary" href="createAlbumUser">Create Album</a>
                <a class="btn btn-info" href="songServlet">Back to home</a>

                <table class="table table-hover">

                    <tr>
                        <th>STT</th>
                        <th>Name</th>
                    </tr>
                    <c:forEach items="${AlbumUser}" var="c" varStatus="in">
                        <tr>
                            <td><c:out value="${in.count}"/></td>
                            <td><a href="AlbumUserDetail?id=${c.getAlbumId()}"><c:out
                                    value="${c.getAlbumName()}"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>

</div>

</body>
</html>