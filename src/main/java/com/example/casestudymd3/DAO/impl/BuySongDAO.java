package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.connection.MyConnection;
import com.example.casestudymd3.model.Songs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuySongDAO {
    private static BuySongDAO buySongDAO;

    public static BuySongDAO getInstance() {
        if (buySongDAO == null) {
            buySongDAO = new BuySongDAO();
        }
        return buySongDAO;
    }

    private final String SELECT_All = "SELECT * FROM songs;";
    private final String CHECK_SONG = "SELECT * FROM purchased_songs WHERE userId = ? AND songId = ?;";
    private final String INSERT_PURCHASED_SONG = "INSERT INTO purchased_songs (userId, songId) VALUES (?, ?);";

    public List<Songs> findAllSong() {
        List<Songs> songs = new ArrayList<>();
        try {
            PreparedStatement statement = MyConnection.getInstance().prepareStatement(SELECT_All);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int songId = resultSet.getInt("songId");
                String name = resultSet.getString("songName");
                String link = resultSet.getString("fileLink");
                String avt = resultSet.getString("avatarLink");
                String description = resultSet.getString("description");
                int abId = resultSet.getInt("albumId");
                double price = resultSet.getDouble("price");
                int uId = resultSet.getInt("userId");
                songs.add(new Songs(songId, name, link, avt, description, AlbumDAO.getInstance().findOne(abId), price, UserDAO.getInstance().findOne(uId)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songs;
    }

    public boolean checkSongIsPurchased(int userId, int songId) {
        boolean isPurchased = false;
        try {
            PreparedStatement statement = MyConnection.getInstance().prepareStatement(CHECK_SONG);
            statement.setInt(1, userId);
            statement.setInt(2, songId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isPurchased = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isPurchased;
    }

    public void buySong(int userId, int songId) {
        try {
            if (!checkSongIsPurchased(userId, songId)) {
                PreparedStatement insertStatement = MyConnection.getInstance().prepareStatement(INSERT_PURCHASED_SONG);
                insertStatement.setInt(1, userId);
                insertStatement.setInt(2, songId);
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
