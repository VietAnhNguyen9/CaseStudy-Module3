package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.DAO.ISongDAO;
import com.example.casestudymd3.connection.MyConnection;
import com.example.casestudymd3.model.Songs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDAO implements ISongDAO {
    private static SongDAO songDAO;

    public static SongDAO getInstance() {
        if (songDAO == null) {
            songDAO = new SongDAO();
        }
        return songDAO;
    }

    private final String SELECT_ALL = "select * from songs;";
    private final String SELECT_BY_ID = "select * from songs where songId = ?;";
    private final String INSERT_INTO = "insert into albums(songName,fileName,avatarLink,description,albumId,price,userId) value (?,?,?,?,?,?,?);";
    private final String UPDATE_BY_ID = "update albums set songName = ? fileLink =? avatarLink=? description=? albumId=? price=? where songId = ?;";
    private final String DELETE_BY_ID = "delete from albums where songId = ?;";

    @Override
    public List<Songs> findAll() {
        List<Songs> songs = new ArrayList<>();
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("songId");
                String name = resultSet.getString("songName");
                String mp3 = resultSet.getString("fileLink");
                String img = resultSet.getString("avatarLink");
                String des = resultSet.getString("description");
                int idAlbum = resultSet.getInt("albumId");
                double price = resultSet.getDouble("price");
                int idUser = resultSet.getInt("userId");
                songs.add(new Songs(id, name, mp3, img, des, AlbumDAO.getInstance().findOne(idAlbum), price, UserDAO.getInstance().findOne(idUser)));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return songs;
    }

    @Override
    public Songs findOne(int id) {
        Songs song = null;
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("songId");
                String name = resultSet.getString("songName");
                String mp3 = resultSet.getString("fileLink");
                String img = resultSet.getString("avatarLink");
                String des = resultSet.getString("description");
                int idAlbum = resultSet.getInt("albumId");
                double price = resultSet.getDouble("price");
                int idUser = resultSet.getInt("userId");
                song = new Songs(idDB, name, mp3, img, des, AlbumDAO.getInstance().findOne(idAlbum), price, UserDAO.getInstance().findOne(idUser));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return song;
    }

    @Override
    public void create(Songs songs) {
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, songs.getSongName());
            preparedStatement.setString(2, songs.getFileLink());
            preparedStatement.setString(3, songs.getAvatarLink());
            preparedStatement.setString(4, songs.getDescription());
            preparedStatement.setInt(5, songs.getAlbum().getAlbumId());
            preparedStatement.setDouble(6, songs.getPrice());
            preparedStatement.setInt(7, songs.getUser().getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Songs songs) {
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, songs.getSongName());
            preparedStatement.setString(2, songs.getFileLink());
            preparedStatement.setString(3, songs.getAvatarLink());
            preparedStatement.setString(4, songs.getDescription());
            preparedStatement.setInt(5, songs.getAlbum().getAlbumId());
            preparedStatement.setDouble(6, songs.getPrice());
            preparedStatement.setInt(6, songs.getAlbum().getAlbumId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
