package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.DAO.IAlbumDAO;
import com.example.casestudymd3.connection.MyConnection;
import com.example.casestudymd3.model.Albums;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO implements IAlbumDAO {
    private static AlbumDAO albumDAO;

    public static AlbumDAO getInstance() {
        if (albumDAO == null) {
            albumDAO = new AlbumDAO();
        }
        return albumDAO;
    }

    private final String SELECT_ALL = "select * from albums;";
    private final String SELECT_BY_ID = "select * from albums where albumId = ?;";
    private final String INSERT_INTO = "insert into albums(albumName,userId) value (?,?);";
    private final String UPDATE_BY_ID = "update albums set albumName = ? where albumId = ?;";
    private final String DELETE_BY_ID = "delete from albums where albumId = ?;";


    @Override
    public List<Albums> findAll() {
        List<Albums> albums = new ArrayList<>();
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("albumId");
                String name = resultSet.getString("albumName");
                int user = resultSet.getInt("userId");
                albums.add(new Albums(id, name, UserDAO.getInstance().findOne(user)));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return albums;
    }

    @Override
    public Albums findOne(int id) {
        Albums albums = null;
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("albumId");
                String name = resultSet.getString("albumName");
                int iduser = resultSet.getInt("userId");
                albums = new Albums(idDB, name, UserDAO.getInstance().findOne(iduser));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albums;
    }

    @Override
    public void create(Albums albums) {
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(INSERT_INTO)) {
            preparedStatement.setString(1, albums.getAlbumName());
            preparedStatement.setInt(2, albums.getUser().getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Albums albums) {
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, albums.getAlbumName());
            preparedStatement.setInt(2, albums.getAlbumId());
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
