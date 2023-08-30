package com.example.casestudymd3.DAO;

import com.example.casestudymd3.service.impl.AlbumService;

public class SongDAO {
    private static SongDAO songDAO;
    public static SongDAO getInstance(){
        if (songDAO == null) {
            songDAO = new SongDAO();
        } return songDAO;
    }
}
