package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.AlbumUserDetailDAO;
import com.example.casestudymd3.model.Songs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlbumUserDetailServlet", value = "/AlbumUserDetail")
public class AlbumUserDetailServlet extends HttpServlet {
    AlbumUserDetailDAO albumUserDetailDAO = new AlbumUserDetailDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Songs> albumSongs = albumUserDetailDAO.getAlbumSongsById(id);
        request.setAttribute("albumSongs", albumSongs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage/albumUseDetail.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}