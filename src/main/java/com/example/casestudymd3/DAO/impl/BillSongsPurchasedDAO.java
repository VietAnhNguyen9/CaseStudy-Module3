package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.connection.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillSongsPurchasedDAO {
    private static BillSongsPurchasedDAO billSongsPurchasedDAO;

    public static BillSongsPurchasedDAO getInstance() {
        if (billSongsPurchasedDAO == null) {
            billSongsPurchasedDAO = new BillSongsPurchasedDAO();
        }
        return billSongsPurchasedDAO;
    }

    private final String SELECT_ID = "SELECT s.songName AS TenBaiHat, s.price AS GiaTien FROM purchased_songs ps JOIN songs s ON ps.songId = s.songId WHERE ps.userId = ?;";
    private final String SELECT_TOTALBILL = "SELECT SUM(s.price) AS TongTienDaMua FROM purchased_songs ps JOIN songs s ON ps.songId = s.songId WHERE ps.userId = ?;";

    public List<Map<String, Object>> getBillSongPurchasedByUserId(int userId) throws SQLException {
        List<Map<String, Object>> billSongs = new ArrayList<>();

        PreparedStatement statement = MyConnection.getInstance().prepareStatement(SELECT_ID);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Map<String, Object> billSong = new HashMap<>();
            billSong.put("TenBaiHat", resultSet.getString("TenBaiHat"));
            billSong.put("GiaTien", resultSet.getDouble("GiaTien"));
            billSongs.add(billSong);
        }
        return billSongs;
    }

    public double getTotalAmountPurchasedByUserId(int userId) throws SQLException {
        double totalAmount = 0.0;

        PreparedStatement statement = MyConnection.getInstance().prepareStatement(SELECT_TOTALBILL);
        statement.setInt(1,userId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            totalAmount = resultSet.getDouble("TongTienDaMua");
        }

        return totalAmount;
    }
}