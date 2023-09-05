<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link href="song-delete.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div>
    <jsp:include page="../homepage/menu.jsp"/>
    <a href="/songServlet?action=create"><button type="button" class="btn btn-info">Create new song</button></a>
    <p>${mess}</p>
    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Album</th>
            <th>Mô tả</th>
            <th>Âm thanh</th>
            <th>Giá</th>
            <th>Ca sĩ</th>
            <th colspan="2" style="text-align: left">Hành động</th>
        </tr>
        <c:forEach items="${list}" var="p" varStatus="in">
            <tr>
                <td><c:out value="${in.count}"/></td>
                <td><a href="songServlet?action=" style="text-decoration: none;"><c:out value="${p.getSongName()}"/></a></td>
                <td><a href="songServlet?action=" style="text-decoration: none;"><c:out value="${p.getAlbum().getAlbumName()}"/></a></td>
                <td><c:out value="${p.getDescription()}"/></td>
                <td>
                    <audio controls>
                        <source src="${p.getFileLink()}" type="audio/webm">
                    </audio></td>
                <td><c:out value="${p.getPrice()}"/></td>
                <td><c:out value="${p.getUser().getUserName()}"/></td>
                <td>
                    <button onclick="myFunction(${p.getSongId()})" class="btn btn-danger">Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>
    function myFunction(c) {
        if (confirm("Bạn có muốn xóa bài hát không???")) {
            window.location.href = "songServlet?action=delete&&id=" + c
            alert("Xóa thành công!")
        } else {
            alert("Xóa không thành công!")
        }
    }
</script>
</html>

