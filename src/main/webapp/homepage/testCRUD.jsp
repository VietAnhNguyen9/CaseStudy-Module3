<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div class="container" style="width: 50%">
    <h1 style="color: red"><a href="songServlet">List Song</a></h1>
    <a class="btn btn-primary" href="songServlet?action=create">Create song</a>
    <a class="btn btn-primary" href="albumServlet?action=createAlbum">Create Album</a>
    <a class="btn btn-primary" href="albumServlet">List Album</a>
    <a class="btn btn-primary" href="songServlet?action=sort">Sort by price</a>
    <br>
    <form action="songServlet?action=searchByName" method="post">
        <input type="text" name="nameSearch"  placeholder="Search....">
        <input  class="btn btn-info" type="submit" value="Search">
    </form>
    <br><br>
    <div>
        <h4>Search by price</h4>
        <form action="songServlet?action=searchByPrice" method="post">
            <input type="number" name="minPrice"  placeholder="min price">
            <p> To </p>
            <input type="number" name="maxPrice"  placeholder="max price">
            <input  class="btn btn-primary" type="submit" value="Search">
        </form>
    </div>
    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Album</th>
            <th>Description</th>
            <th>Audio</th>
            <th>Price</th>
            <th>Singer</th>
            <th colspan="2" style="text-align: left">Action</th>
        </tr>
        <c:forEach items="${list}" var="p" varStatus="in">
            <tr>
                <td><c:out value="${in.count}"/></td>
                <td><a href="songServlet?action="><c:out value="${p.getSongName()}"/></a></td>
                <td><a href="songServlet?action="><c:out value="${p.getAlbum().getAlbumName()}"/></a></td>
                <td><c:out value="${p.getDescription()}"/></td>
                <td>
                    <audio controls>
                        <source src="${p.getFileLink()}" type="audio/webm">
                    </audio></td>
                <td><c:out value="${p.getPrice()}"/></td>
                <td><c:out value="${p.getUser().getUserName()}"/></td>
                <td>
                    <a class="btn btn-warning" href="songServlet?action=update&&id=${p.getSongId()}">Update</a>
                    <a class="btn btn-danger" href="songServlet?action=delete&&id=${p.getSongId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

