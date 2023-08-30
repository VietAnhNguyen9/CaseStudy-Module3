package com.example.casestudymd3.service.impl;

import com.example.casestudymd3.model.Songs;
import com.example.casestudymd3.service.ISongs;

import javax.servlet.http.HttpServletRequest;
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
        return null;
    }

    @Override
    public Songs findOne(HttpServletRequest request) {
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
