package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.connection.MyConnection;
import com.example.casestudymd3.model.Albums;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumUserDAO {
    private static AlbumUserDAO albumUserDAO;

    public static AlbumUserDAO getInstance() {
        if (albumUserDAO == null) {
            albumUserDAO = new AlbumUserDAO();
        }
        return albumUserDAO;
    }

    private final String SELECT_BY_ID = "select * from albums where userId=?;";

    public List<Albums> findAll(int id) {
        List<Albums> albums = new ArrayList<>();
        try {
            PreparedStatement statement = MyConnection.getInstance().prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("albumId");
                String nameAlbum = resultSet.getString("albumName");
                int user = resultSet.getInt("userId");
                albums.add(new Albums(idDB, nameAlbum, UserDAO.getInstance().findOne(user)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }
}
