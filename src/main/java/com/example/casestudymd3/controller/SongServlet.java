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

            case "delete":
                deleteSong(request, response);
                break;
            case "albumDetail":
                displayByAlbum(request,response);
                break;
            case "singerSong":
                displayBySinger(request,response);
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
            case "searchByName":
                searchByName(request, response);
                break;
        }
    }


    // file jsp testCRUD nay can sua.
    private void listSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Songs> songs = songService.findAll();
        request.setAttribute("list", songs);
        RequestDispatcher req = request.getRequestDispatcher("homepage/homepage.jsp");
        req.forward(request, response);
    }


    private void updatePostSong(HttpServletRequest request, HttpServletResponse response) {
    }
    private void createGetSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher req = request.getRequestDispatcher("/songs/createSong.jsp");
        req.forward(request,response);
    }
    private void createPostSong(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        songService.add(request);
        request.setAttribute("mess","Song has been uploaded");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/songs/song.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deleteSong(HttpServletRequest request, HttpServletResponse response) {
    }

    private void sortByAlbum(HttpServletRequest request, HttpServletResponse response) {

    }

    private void updateGetSong(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Songs> songs = songService.searchSongByName(request);
        request.setAttribute("list", songs);
        RequestDispatcher requ = request.getRequestDispatcher("/homepage/homepage.jsp");
        requ.forward(request,response);
    }
    private void displayByAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Songs> songs = songService.displayByAlbum(request);
        request.setAttribute("list", songs);
        RequestDispatcher requ = request.getRequestDispatcher("/homepage/homepage.jsp");
        requ.forward(request,response);
    }
    private void displayBySinger(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Songs> songs = songService.displayBySinger(request);
        request.setAttribute("list", songs);
        RequestDispatcher req = request.getRequestDispatcher("/homepage/homepage.jsp");
        req.forward(request,response);
    }
}