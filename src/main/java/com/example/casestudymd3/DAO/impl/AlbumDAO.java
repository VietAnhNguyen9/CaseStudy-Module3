package com.example.casestudymd3.DAO;

import com.example.casestudymd3.service.impl.AlbumService;

public class AlbumDAO {
    private static AlbumDAO albumDAO;
    public static AlbumDAO getInstance(){
        if (albumDAO == null) {
            albumDAO = new AlbumDAO();
        } return albumDAO;
    }
}
