package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.LoginDAO;
import com.example.casestudymd3.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    LoginDAO loginDAO = new LoginDAO();
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
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Users user = loginDAO.login(userName, password);
        if (user == null) {
            request.getRequestDispatcher("404.jsp").forward(request,response);
        }else {
            response.sendRedirect("home.jsp");
        }

    }
}