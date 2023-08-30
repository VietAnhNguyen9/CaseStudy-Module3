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
    private final String SELECT_ALL = "select * from songs;";
    private final String SELECT_BY_ID = "select * from songs where songId = ?;";
    private final String INSERT_INTO = "insert into albums(songName,userId) value (?,?);";
    private final String UPDATE_BY_ID = "update albums set songName = ? where songId = ?;";
    private final String DELETE_BY_ID = "delete from albums where songId = ?;";

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
