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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="sign-up.css">
</head>
<body>
<%--<form action="/login?action=signup" method="post">--%>
<%--  <h1>Sign Up</h1>--%>
<%--  <input type="text" name="userName" placeholder="Enter User Name">--%>
<%--  <input type="text" name="password" placeholder="Enter Password">--%>
<%--  <input type="text" name="re-pass" placeholder="Enter Re-Password">--%>
<%--  <input type="text" name="phoneNumber" placeholder="Enter Phone Number">--%>
<%--  <input type="text" name="email" placeholder="Enter Email">--%>
<%--  <input type="text" name="address" placeholder="Enter Address">--%>
<%--  <button type="submit">Sign Up</button>--%>
<%--</form>--%>


<section class="vh-100 bg-image"
         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5" style="color: cornflowerblue">Create an
                                account</h2>

                            <form action="/login?action=signup" method="post">

                                <div class="form-outline mb-4">
                                    <input type="text" id="form3Example1cg" class="form-control form-control-lg"
                                           placeholder="User Name" name="userName"/>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" id="form3Example4cg" class="form-control form-control-lg"
                                           placeholder="Password (6-8 characters)" name="password"/>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" id="form3Example4cdg" class="form-control form-control-lg"
                                           placeholder="Repeat Your Password" name="re-pass"/>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="email" class="form-control form-control-lg" placeholder="Your Email"
                                           name="email"/>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="number" class="form-control form-control-lg" placeholder="Phone Number (10 numbers)"
                                           name="phoneNumber"/>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="text" class="form-control form-control-lg" placeholder="Address"
                                           name="address"/>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <button type="submit"
                                            class="btn btn-primary btn-block mb-4">Register
                                    </button>
                                </div>
                            </form>

                            <p class="text-danger">${messenger}</p>

                            <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="/login"
                                                                                                    class="fw-bold text-body"
                                                                                                    style="color: cornflowerblue"><u>Login
                                here</u></a></p>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
