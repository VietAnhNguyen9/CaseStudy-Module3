package com.example.casestudymd3.service.impl;

import com.example.casestudymd3.DAO.impl.AlbumDAO;
import com.example.casestudymd3.DAO.impl.SongDAO;
import com.example.casestudymd3.DAO.impl.UserDAO;
import com.example.casestudymd3.model.Albums;
import com.example.casestudymd3.model.Songs;
import com.example.casestudymd3.service.ISongs;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class SongService implements ISongs {
    private static SongService songService;
    public static SongService getInstance(){
        if (songService == null) {
            songService = new SongService();
        } return songService;
    }
    @Override
    public List<Songs> findAll() {
        return SongDAO.getInstance().findAll();
    }

    @Override
    public Songs findOne(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return SongDAO.getInstance().findOne(id);

    }

    @Override
    public void add(HttpServletRequest request) {
        String name = request.getParameter("name");
        String linkFile = request.getParameter("linkFile");
        String avatarFile = request.getParameter("avatarFile");
        String description = request.getParameter("description");
        int albumId = Integer.parseInt(request.getParameter("albumId"));
        double price = Double.parseDouble(request.getParameter("price"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        Songs songs = new Songs(name,linkFile,avatarFile,description,AlbumDAO.getInstance().findOne(albumId),price, UserDAO.getInstance().findOne(userId));
        SongDAO.getInstance().create(songs);
    }

    @Override
    public void update(HttpServletRequest request) {
        int songId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String linkFile = request.getParameter("linkFile");
        String avatarFile = request.getParameter("avatarFile");
        String description = request.getParameter("description");
        int albumId = Integer.parseInt(request.getParameter("albumId"));
        double price = Double.parseDouble(request.getParameter("price"));
        Songs songs = new Songs(songId,name,linkFile,avatarFile,description,AlbumDAO.getInstance().findOne(albumId),price);
        SongDAO.getInstance().update(songs);
    }

    @Override
    public void delete(HttpServletRequest request) {
        int songId = Integer.parseInt(request.getParameter("id"));
        SongDAO.getInstance().delete(songId);
    }
    public List<Songs> searchSongByName(HttpServletRequest request){
        String name = request.getParameter("nameSearch");
        return SongDAO.getInstance().searchByName(name);

    }
    public  List<Songs> displayByAlbum(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return SongDAO.getInstance().displayByAlbum(id);
    }
}
