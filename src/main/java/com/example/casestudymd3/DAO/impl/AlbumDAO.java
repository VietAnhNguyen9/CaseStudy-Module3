package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.DAO.ISongDAO;
import com.example.casestudymd3.model.Songs;

import java.util.List;

public class AlbumDAO implements ISongDAO {
    private static AlbumDAO albumDAO;
    public static AlbumDAO getInstance(){
        if (albumDAO == null) {
            albumDAO = new AlbumDAO();
        } return albumDAO;
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
