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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<div class="container" style="width: 400px; border:solid cornflowerblue; margin-top: 200px; border-radius: 15px">
    <h1 style="text-align: center; color:cornflowerblue">Login</h1>
    <form action="/login?action=login" method="post">
        <!-- User input -->
        <div class="form-outline mb-4">
            <input type="text" id="form2Example1" class="form-control" name="userName" placeholder="Enter User Name"/>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <input type="password" id="form2Example2" class="form-control" name="password"
                   placeholder="Enter Password"/>
        </div>

        <!-- 2 column grid layout for inline styling -->
        <div class="row mb-4">
            <div class="col d-flex justify-content-center">
                <!-- Checkbox -->
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked/>
                    <label class="form-check-label" for="form2Example31"> Remember me </label>
                </div>
            </div>

            <div class="col">
                <!-- Simple link -->
                <a href="#!">Forgot password?</a>
            </div>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4" style="width: 372px; margin: auto">Sign in</button>
    </form>
    <p class="text-danger">${mess}</p>
    <!-- Register buttons -->
    <div class="text-center">
        <p>Not a member? <a href="/login/sign-up.jsp">Register</a></p>
    </div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
