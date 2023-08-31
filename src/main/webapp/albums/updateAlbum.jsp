
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div class="container">
        <h1 style="text-align: center">Update Album</h1>
    <form style="width: 300px; margin: auto"
          action="albumServlet?action=updateAlbum&&id=${update.getAlbumId()}" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" value="${update.getAlbumName()}"
                   id="name" name="name" required>
        </div>
        <button class="btn btn-success" type="submit">Update</button>
        <button class="btn btn-secondary" type="reset">Reset</button>
        <a class="btn btn-info" href="albumServlet">Back to list</a>
    </form>
</div>
</body>
</html>
