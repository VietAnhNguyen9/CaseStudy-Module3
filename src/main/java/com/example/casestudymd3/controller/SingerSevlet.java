package com.example.casestudymd3.controller;

import com.example.casestudymd3.model.Songs;
import com.example.casestudymd3.model.Users;
import com.example.casestudymd3.service.impl.SingerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SingerSevlet", value = "/singerSevlet")
public class SingerSevlet extends HttpServlet {
    private SingerService service;

    @Override
    public void init() throws ServletException {
        service = new SingerService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                listSinger(request, response);
                break;

        }
    }

    private void listSinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> users = service.findSinger();
        request.setAttribute("listS", users);
        RequestDispatcher req = request.getRequestDispatcher("homepage/displaySinger.jsp");
        req.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}