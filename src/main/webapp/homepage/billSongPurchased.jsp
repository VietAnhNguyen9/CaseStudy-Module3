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
                <li><a href="">Hóa Đơn Mua Nhạc</a></li>
            </ul>
        </div>
        <div id="content">
            <div class="container">
                <h3>List Album</h3>
                <a class="btn btn-primary" href="AlbumUser">Back To My Album</a>
                <a class="btn btn-info" href="songServlet">Back to home</a>

                <h3>List Purchased Songs</h3>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên Bài Hát</th>
                        <th>Giá Tiền</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="billSong" items="${billSongs}" varStatus="status">
                        <tr>
                            <td><c:out value="${status.index + 1}" /></td>
                            <td><c:out value="${billSong.TenBaiHat}" /></td>
                            <td><c:out value="${billSong.GiaTien}" /> VND</td>
                        </tr>
                    </c:forEach>
                    <tr class="table-info">
                        <td colspan="2" class="text-right"><strong>Tổng tiền:</strong></td>
                        <td><c:out value="${totalAmount}" /> VND</td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>