package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.connection.MyConnection;
import com.example.casestudymd3.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    Connection connection = MyConnection.getInstance();
    private final String CHECK_USER = "select * from users where userName = ? and password = ?;";
    public Users login(String userName, String password) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Users(
                        resultSet.getString(2),
                        resultSet.getString(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
