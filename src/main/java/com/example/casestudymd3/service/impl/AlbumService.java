package com.example.casestudymd3.service.impl;

import com.example.casestudymd3.model.Albums;
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
        List<Albums> albums = new ArrayList<>();
        return albums;
    }

    @Override
    public Albums findOne(HttpServletRequest request) {
        return null;
    }

    @Override
    public void add(HttpServletRequest request) {

    }

    @Override
    public void update(HttpServletRequest request) {

    }

    @Override
    public void delete(HttpServletRequest request) {

    }
}
