package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.AlbumUserDAO;
import com.example.casestudymd3.model.Albums;
import com.example.casestudymd3.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlbumUserServlet", value = "/AlbumUser")
public class AlbumUserServlet extends HttpServlet {
    AlbumUserDAO albumUserDAO = new AlbumUserDAO();

    @Override
    public void init() throws ServletException {
        albumUserDAO = new AlbumUserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int userId = user.getUserId();

        List<Albums> userAlbums = albumUserDAO.findAll(userId);
        request.setAttribute("AlbumUser", userAlbums);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage/displayAlbumUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
