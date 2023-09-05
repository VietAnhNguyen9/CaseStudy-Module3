<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.casestudymd3.model.Role" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div>

    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Ảnh</th>
            <th>Tên</th>
            <th>Album</th>
            <th>Mô tả</th>
            <th>Phát nhạc</th>
            <th>Giá</th>
            <th>Ca sĩ</th>
            <c:if test="${sessionScope.user.role == Role.ADMIN}">
                <th colspan="2" style="text-align: left">Hành động</th>
            </c:if>
        </tr>
        <c:forEach items="${list}" var="p" varStatus="in">
            <tr>
                <td><c:out value="${in.count}"/></td>
                <td>
                    <img style="width: 50%;height: 50%" src="${p.getAvatarLink()}" alt="ảnh">
                </td>
                <td><a href="songServlet?action=" style="text-decoration: none;"><c:out value="${p.getSongName()}"/></a>
                </td>
                <td><a href="songServlet?action=" style="text-decoration: none;"><c:out
                        value="${p.getAlbum().getAlbumName()}"/></a></td>
                <td><c:out value="${p.getDescription()}"/></td>
                <td>
                    <audio controls>
                        <source src="${p.getFileLink()}" type="audio/webm">
                    </audio>
                </td>
                <td><c:out value="${p.getPrice()}"/></td>
                <td><c:out value="${p.getUser().getUserName()}"/></td>
                <td>
                    <c:if test="${sessionScope.user.role == Role.ADMIN}">
                        <button class="btn btn-danger" onclick="myFunction(${p.getSongId()})">Xóa</button>
                        </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>
    function myFunction(c) {
        if (confirm("Bạn muốn xo bài hát? ")) {
            window.location.href = "songServlet?action=delete&&id=" + c
            alert("Xóa thành công!")
        } else {
            alert("Xóa không thành công!")
        }
    }
</script>
</html>

