package com.example.casestudymd3.controller;

import com.example.casestudymd3.model.Songs;
import com.example.casestudymd3.service.impl.AlbumService;
import com.example.casestudymd3.service.impl.SongService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SongServlet", value = "/songServlet")
public class SongServlet extends HttpServlet {
    private SongService songService;

    @Override
    public void init() throws ServletException {
        songService = new SongService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                listSong(request, response);
                break;
            case "create":
                createGetSong(request, response);
                break;
            case "update":
                updateGetSong(request, response);
                break;
            case "sortByAlbum":
                sortByAlbum(request, response);
                break;
            case "delete":
                deleteSong(request, response);
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
            case "create":
                createPostSong(request, response);
                break;
            case "update":
                updatePostSong(request, response);
                break;
            case "sortByAlbum":
                sortByAlbum(request, response);
                break;

        }
    }


    // file jsp testCRUD nay can sua.
    private void listSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Songs> songs = songService.findAll();
        request.setAttribute("list", songs);
        RequestDispatcher req = request.getRequestDispatcher("testCRUD.jsp");
        req.forward(request, response);
    }


    private void updatePostSong(HttpServletRequest request, HttpServletResponse response) {
    }
    private void createGetSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher req = request.getRequestDispatcher("/albums/createAlbum.jsp");
        req.forward(request,response);
    }
    private void createPostSong(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AlbumService.getInstance().add(request);
        response.sendRedirect("albumServlet");
    }

    private void deleteSong(HttpServletRequest request, HttpServletResponse response) {
    }

    private void sortByAlbum(HttpServletRequest request, HttpServletResponse response) {

    }

    private void updateGetSong(HttpServletRequest request, HttpServletResponse response) {
    }




}