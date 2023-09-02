package com.example.casestudymd3.controller;

import com.example.casestudymd3.DAO.impl.BuySongDAO;
import com.example.casestudymd3.DAO.impl.PurchasedSongDAO;
import com.example.casestudymd3.DAO.impl.SongDAO;
import com.example.casestudymd3.model.Songs;
import com.example.casestudymd3.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BuySongServlet", value = "/BuySongServlet")
public class BuySongServlet extends HttpServlet {

    BuySongDAO buySongDAO = new BuySongDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Songs> songs = BuySongDAO.getInstance().findAllSong();

        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");

        List<Songs> purchasedSongs = PurchasedSongDAO.getInstance().getPurchasedSongs(users.getUserId());

        List<Songs> unpurchasedSongs = new ArrayList<>();

        for (Songs song : songs) {
            boolean isPurchased = false;
            for (Songs purchasedSong : purchasedSongs) {
                if (song.getSongId() == purchasedSong.getSongId()) {
                    isPurchased = true;
                    break;
                }
            }
            if (!isPurchased) {
                unpurchasedSongs.add(song);
            }
        }

        request.setAttribute("allSongs", songs);
        request.setAttribute("purchasedSongs", purchasedSongs);
        request.setAttribute("unpurchasedSongs", unpurchasedSongs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage/purchasedSongs.jsp");
        dispatcher.forward(request, response);


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        int userId = user.getUserId();

        String songIdStr = request.getParameter("songId");
        if (songIdStr != null && !songIdStr.isEmpty()) {
            int songId = Integer.parseInt(songIdStr);

            buySongDAO.buySong(userId, songId);
        }

        response.sendRedirect("BuySongServlet");
    }
}