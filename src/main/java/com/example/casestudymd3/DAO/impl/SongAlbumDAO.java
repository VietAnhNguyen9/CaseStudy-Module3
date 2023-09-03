package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.connection.MyConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SongAlbumDAO {
    private static SongAlbumDAO songAlbumDAO;

    public static SongAlbumDAO getInstance() {
        if (songAlbumDAO == null) {
            songAlbumDAO = new SongAlbumDAO();
        }
        return songAlbumDAO;
    }

    private String SELECT_ID = "SELECT * FROM songsalbum WHERE songId = ? AND albumId = ?";
    private String INSERT_INTO = "INSERT INTO songsalbum (songId, albumId) VALUES (?, ?)";
    public boolean isSongInAlbum(int songId, int albumId) {
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_ID)) {
            preparedStatement.setInt(1, songId);
            preparedStatement.setInt(2, albumId);

            return preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        } return false;
    }
    public boolean addSongToAlbum(int songId, int albumId) {
        if (isSongInAlbum(songId, albumId)) {
            return false;
        }

        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1, songId);
            preparedStatement.setInt(2, albumId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
