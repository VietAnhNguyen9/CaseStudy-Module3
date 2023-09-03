package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.AlbumUserDAO;
import com.example.casestudymd3.DAO.impl.PurchasedSongDAO;
import com.example.casestudymd3.DAO.impl.SongAlbumDAO;
import com.example.casestudymd3.model.Albums;
import com.example.casestudymd3.model.Songs;
import com.example.casestudymd3.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PurchasedSongsServlet", value = "/PurchasedSongsServlet")
public class PurchasedSongsServlet extends HttpServlet {
    private PurchasedSongDAO purchasedSongDAO = new PurchasedSongDAO();
    private SongAlbumDAO songAlbumDAO = new SongAlbumDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int userId = user.getUserId();

        List<Songs> purchasedSongs = purchasedSongDAO.getPurchasedSongs(userId);
        request.setAttribute("purchasedSongs", purchasedSongs);

        List<Albums> albums = AlbumUserDAO.getInstance().findAll(userId);
        request.setAttribute("userAlbums", albums);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage/displayListSongsPurchased.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int songId = Integer.parseInt(request.getParameter("idSong"));
        int albumId = Integer.parseInt(request.getParameter("userAlbumId"));


        songAlbumDAO.addSongToAlbum(songId, albumId);
        response.sendRedirect("PurchasedSongsServlet");
    }
}