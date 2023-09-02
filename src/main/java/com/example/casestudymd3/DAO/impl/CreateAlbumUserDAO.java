package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.connection.MyConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAlbumUserDAO {
    private static CreateAlbumUserDAO createAlbumuserDAO;

    public static CreateAlbumUserDAO getInstance() {
        if (createAlbumuserDAO == null) {
            createAlbumuserDAO = new CreateAlbumUserDAO();
        }
        return createAlbumuserDAO;
    }

    private final String INSERT_INTO = "INSERT INTO albums(albumName, userId) VALUES (?,?);";

    public void create(String name, int userId) {
        try {
            PreparedStatement statement = MyConnection.getInstance().prepareStatement(INSERT_INTO);
            statement.setString(1, name);
            statement.setInt(2, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
