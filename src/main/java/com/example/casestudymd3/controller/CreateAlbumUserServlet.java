package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.CreateAlbumUserDAO;
import com.example.casestudymd3.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "createAlbumUserServlet", value = "/createAlbumUser")
public class CreateAlbumUserServlet extends HttpServlet {
    private AlbumUserServlet albumUserServlet;

    public void init() {
        albumUserServlet = new AlbumUserServlet();
    }

    private final String INSERT_INTO = "insert into albums(albumName,userId) value (?,?);";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/albums/createAlbumUser.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String albumName = request.getParameter("name");

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int userId = user.getUserId();


        CreateAlbumUserDAO createAlbumuserDAO = new CreateAlbumUserDAO();
        CreateAlbumUserDAO.getInstance().create(albumName, userId);

        response.sendRedirect("AlbumUser");
    }
}