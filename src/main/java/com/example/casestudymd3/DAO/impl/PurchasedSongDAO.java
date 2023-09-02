package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.connection.MyConnection;
import com.example.casestudymd3.model.Songs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchasedSongDAO {
    private static PurchasedSongDAO purchasedSongDAO;

    public static PurchasedSongDAO getInstance() {
        if (purchasedSongDAO == null) {
            purchasedSongDAO = new PurchasedSongDAO();
        }
        return purchasedSongDAO;
    }

    private final String SELECT_ID = "SELECT * FROM purchased_songs WHERE userId = ?;";

    public List<Songs> getPurchasedSongs(int userId) {
        List<Songs> purchasedSongs = new ArrayList<>();
        try {
            PreparedStatement statement = MyConnection.getInstance().prepareStatement(SELECT_ID);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int songId = resultSet.getInt("songId");
                Songs songs = SongDAO.getInstance().findOne(songId);
                purchasedSongs.add(songs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchasedSongs;
    }
}
