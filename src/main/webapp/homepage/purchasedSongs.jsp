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
                <li><a href="">Tất cả bài hát</a></li>
                <li><a href="">Tạo album yêu thích</a></li>
                <li><a href="albumServlet">Nghe theo album nhạc</a></li>
                <li><a href="singerServlet">Nghe theo ca sĩ</a></li>
            </ul>
        </div>
        <div id="content">
            <div class="container">

                <h5 style="color: blue">List Purchased Songs</h5>
                <table class="table table-hover">
                    <tr>
                        <th>STT</th>
                        <th>Name</th>
                        <th>Audio</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${purchasedSongs}" var="p" varStatus="in">
                        <tr>
                            <td><c:out value="${in.count}"/></td>
                            <td><a href="songServlet?action="><c:out value="${p.getSongName()}"/></a></td>

                            <td>
                                <audio controls>
                                    <source src="${p.getFileLink()}" type="audio/webm">
                                </audio>
                            </td>
                            <td><c:out value="${p.getDescription()}"/></td>
                        </tr>
                    </c:forEach>
                </table>

                <h5 style="color: blue">List Unpurchased Songs</h5>
                <table class="table table-hover">
                    <tr>
                        <th>STT</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${unpurchasedSongs}" var="song" varStatus="in">
                        <tr>
                            <td><c:out value="${in.count}"/></td>
                            <td><c:out value="${song.getSongName()}"/></td>
                            <td><c:out value="${song.getDescription()}"/></td>
                            <td><c:out value="${song.getPrice()}"/></td>
                            <td>
                                <!-- Form để gửi POST request -->
                                <form action="BuySongServlet" method="post">
                                    <input type="hidden" name="songId" value="${song.getSongId()}"/>
                                    <input type="hidden" name="action" value="buySong"/> <!-- Thêm action -->
                                    <input type="hidden" name="method" value="POST"/> <!-- Thêm method -->
                                    <input type="submit" value="Mua bài hát"/>
                                </form>
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