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

                <h5 style="color: blue">Danh sách bài hát</h5>
                <a class="btn btn-primary" href="PurchasedSongsServlet">Thêm nhạc</a>
                <a class="btn btn-info" href="AlbumUser">Trở lại Album</a>

                <table class="table table-hover">
                    <tr>
                        <th>STT</th>
                        <th>Tên</th>
                        <th>Âm thanh</th>
                        <th>Mô tả</th>
                        <th>Hành động</th>
                    </tr>
                    <c:forEach items="${albumSongs}" var="as" varStatus="in">
                        <tr>
                            <td><c:out value="${in.count}"/></td>
                            <td><a href=""><c:out value="${as.getSongName()}"/></a></td>
                            <td>
                                <audio controls>
                                    <source src="${as.getFileLink()}" type="audio/webm">
                                </audio>
                            </td>
                            <td><c:out value="${as.getDescription()}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>

</div>

</body>
</html>