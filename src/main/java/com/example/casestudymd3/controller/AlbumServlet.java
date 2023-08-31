package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.AlbumDAO;
import com.example.casestudymd3.model.Albums;
import com.example.casestudymd3.model.Songs;
import com.example.casestudymd3.service.impl.AlbumService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlbumServlet", value = "/albumServlet")
public class AlbumServlet extends HttpServlet {
    private AlbumService albumService;

    @Override
    public void init() throws ServletException {
        albumService = new AlbumService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                listAlbum(request, response);
                break;
            case "createAlbum":
                createGetAlbum(request, response);
                break;
            case "updateAlbum":
                updateGetAlbum(request, response);
                break;
            case "delete":
                deleteAlbum(request, response);
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
            case "createAlbum":
                createPostAlbum(request, response);
                break;
            case "updateAlbum":
                updatePostAlbum(request, response);
                break;
        }
    }
    private void listAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Albums> albums = albumService.findAll();
        request.setAttribute("listA", albums);
        RequestDispatcher req = request.getRequestDispatcher("/albums/displayAlbum.jsp");
        req.forward(request, response);
    }
    private void updatePostAlbum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        albumService.update(request);
        response.sendRedirect("albumServlet");


    }

    private void createPostAlbum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AlbumService.getInstance().add(request);
        response.sendRedirect("albumServlet");
    }

    private void createGetAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher req = request.getRequestDispatcher("/albums/createAlbum.jsp");
        req.forward(request,response);
    }

    private void updateGetAlbum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Albums album = AlbumDAO.getInstance().findOne(id);
        request.setAttribute("update",album);
        List<Albums> albums =  AlbumService.getInstance().findAll();
        request.setAttribute("listA",albums);
        RequestDispatcher req = request.getRequestDispatcher("/albums/updateAlbum.jsp");
        req.forward(request,response);
    }

    private void deleteAlbum(HttpServletRequest request, HttpServletResponse response) {
    }
}