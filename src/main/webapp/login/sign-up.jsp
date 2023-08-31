<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/31/2023
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="/login?action=signup" method="post">
  <h1>Sign Up</h1>
  <input type="text" name="userName" placeholder="Enter User Name">
  <input type="text" name="password" placeholder="Enter Password">
  <input type="text" name="re-pass" placeholder="Enter Re-Password">
  <input type="text" name="phoneNumber" placeholder="Enter Phone Number">
  <input type="text" name="email" placeholder="Enter Email">
  <input type="text" name="address" placeholder="Enter Address">
  <button type="submit">Sign Up</button>
</form>
</body>
</html>
