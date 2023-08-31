package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.LoginDAO;
import com.example.casestudymd3.model.Users;
import com.example.casestudymd3.service.impl.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    LoginDAO loginDAO = LoginDAO.getInstance();
    LoginService loginService = LoginService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                response.sendRedirect("/login/login.jsp");
                break;
            case "signup":
                response.sendRedirect("/login/sign-up.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login(request,response);
                break;
            case "signup":
                singUp(request,response);
                break;

        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if ( loginService.login(userName, password) == null) {
            response.sendRedirect("404.jsp");
        }else {
            response.sendRedirect("homepage.jsp");
        }

    }

    public void singUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rePass = request.getParameter("re-pass");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        if (!password.equals(rePass)) {
            response.sendRedirect("/login/sign-up.jsp");
        }else {
            if (loginDAO.checkSignUp(userName) == null) {
                loginDAO.singUp(userName, password, phoneNumber, email, address);
                response.sendRedirect("/login/login.jsp");
            } else {
                response.sendRedirect("404.jsp");
            }


        }

    }
}