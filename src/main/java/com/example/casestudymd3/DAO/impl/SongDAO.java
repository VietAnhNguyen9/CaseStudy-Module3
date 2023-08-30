package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.DAO.ISongDAO;
import com.example.casestudymd3.model.Songs;

import java.util.List;

public class SongDAO implements ISongDAO {
    private static SongDAO songDAO;
    public static SongDAO getInstance(){
        if (songDAO == null) {
            songDAO = new SongDAO();
        } return songDAO;
    }

    @Override
    public List<Songs> findAll() {
        return null;
    }

    @Override
    public Songs findOne(int id) {
        return null;
    }

    @Override
    public void create(Songs songs) {

    }

    @Override
    public void update(Songs songs) {

    }

    @Override
    public void delete(int id) {

    }
}
