
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 style="text-align: center">Create Album</h1>
    <form style="width: 500px; margin: auto"
          action="albumServlet?action=createAlbum" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control"
                   id="name" name="name" required>
        </div>
        <br>
        <button class="btn btn-success" type="submit">Create</button>
        <button class="btn btn-secondary" type="reset">Reset</button>
        <a class="btn btn-info" href="albumServlet">Back to album list</a>
        <a class="btn btn-info" href="songServlet">Back to home</a>

    </form>

</div>
</body>
</html>
