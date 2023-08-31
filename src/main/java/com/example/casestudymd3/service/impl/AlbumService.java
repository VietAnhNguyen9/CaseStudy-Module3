package com.example.casestudymd3.service.impl;

import com.example.casestudymd3.DAO.impl.AlbumDAO;
import com.example.casestudymd3.DAO.impl.UserDAO;
import com.example.casestudymd3.model.Albums;
import com.example.casestudymd3.model.Users;
import com.example.casestudymd3.service.IAlbum;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class AlbumService implements IAlbum {
    private static AlbumService albumService;
    public static AlbumService getInstance(){
        if (albumService == null) {
            albumService = new AlbumService();
        } return albumService;
    }
    @Override
    public List<Albums> findAll() {
        return AlbumDAO.getInstance().findAll();
    }

    @Override
    public Albums findOne(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        return AlbumDAO.getInstance().findOne(id);
    }

    @Override
    public void add(HttpServletRequest request) {
        String name = request.getParameter("name");
        int idC = Integer.parseInt(request.getParameter("userid"));
        Albums albums = new Albums(name, UserDAO.getInstance().findOne(idC));
        AlbumDAO.getInstance().create(albums);
    }

    @Override
    public void update(HttpServletRequest request) {
        int idProduct = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Albums albums = new Albums(idProduct,name);
        AlbumDAO.getInstance().update(albums);
    }

    @Override
    public void delete(HttpServletRequest request) {
        int idAlbum = Integer.parseInt(request.getParameter("id"));
        AlbumDAO.getInstance().delete(idAlbum);
    }
}
