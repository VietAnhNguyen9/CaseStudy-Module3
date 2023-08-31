<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/30/2023
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
</head>
<body>
<form action="/login?action=login" method="post">
  <h1>Sign in</h1>
  <input type="text" name="userName">
  <input type="text" name="password">
  <button type="submit">Sign in</button>
</form>
<a href="/login?action=signup"><button type="submit">Sign Up</button></a>


</body>
</html>
