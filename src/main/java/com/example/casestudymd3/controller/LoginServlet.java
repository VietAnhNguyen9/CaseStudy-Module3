package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.LoginDAO;
import com.example.casestudymd3.model.Users;
import com.example.casestudymd3.service.impl.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Pattern;

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
            case "logout":
                logout(request,response);
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
        Users user = loginDAO.login(userName, password);
        if ( user == null) {
            request.setAttribute("mess","Wrong username or password !!!");
            request.getRequestDispatcher("/login/login.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("/homepage/homepage.jsp");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("/homepage/homepage.jsp");
    }

    public void singUp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Pattern pass = Pattern.compile("^[a-zA-Z0-9]{6,8}$");
        String rePass = request.getParameter("re-pass");
        String phoneNumber = request.getParameter("phoneNumber");
        Pattern phone = Pattern.compile("^[0]{1}[0-9]{9}$");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        if (!password.equals(rePass)) {
            request.setAttribute("messenger","Re-enter the password does not match !!!");
            request.getRequestDispatcher("/login/sign-up.jsp").forward(request,response);
        }else {
            if (!pass.matcher(password).find()) {
                request.setAttribute("messenger","password 6-8 characters !!!");
                request.getRequestDispatcher("/login/sign-up.jsp").forward(request,response);
            }else {
                if (!phone.matcher(phoneNumber).find()) {
                    request.setAttribute("messenger","Phone number 10 characters and start with number 0 !!!");
                    request.getRequestDispatcher("/login/sign-up.jsp").forward(request,response);
                }else {
                    if (loginDAO.checkSignUp(userName) == null) {
                        loginDAO.singUp(userName, password, phoneNumber, email, address);
                        request.setAttribute("mess","Sign Up Success");
                        request.getRequestDispatcher("/login/login.jsp").forward(request,response);
                    } else {
                        request.setAttribute("messenger","This account has already existed !!!");
                        request.getRequestDispatcher("/login/sign-up.jsp").forward(request,response);
                    }
                }

            }

        }
    }
}