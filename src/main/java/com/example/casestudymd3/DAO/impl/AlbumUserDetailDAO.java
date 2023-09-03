package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.connection.MyConnection;
import com.example.casestudymd3.model.Songs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumUserDetailDAO {
    private static AlbumUserDetailDAO albumUserDetailDAO;

    public static AlbumUserDetailDAO getInstance() {
        if (albumUserDetailDAO == null) {
            albumUserDetailDAO = new AlbumUserDetailDAO();
        }
        return albumUserDetailDAO;
    }

    private final String SELECT_ID_ALBUM = "select songs.* from songs join songsalbum s on songs.songId = s.songId join albums a on a.albumId = s.albumId where a.albumId=?;";

    public List<Songs> getAlbumSongsById(int id) {
        List<Songs> songs = new ArrayList<>();
        try {
            PreparedStatement statement = MyConnection.getInstance().prepareStatement(SELECT_ID_ALBUM);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idS = resultSet.getInt("songId");
                String name = resultSet.getString("songName");
                String fl = resultSet.getString("fileLink");
                String al = resultSet.getString("avatarLink");
                String des = resultSet.getString("description");
                int idAB = resultSet.getInt("albumId");
                double price = resultSet.getDouble("price");
                int idU = resultSet.getInt("userId");
                songs.add(new Songs(id,name,fl,al,des,AlbumDAO.getInstance().findOne(idAB), price,UserDAO.getInstance().findOne(idU)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
