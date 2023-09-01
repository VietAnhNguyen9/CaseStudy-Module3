package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.connection.MyConnection;
import com.example.casestudymd3.model.Role;
import com.example.casestudymd3.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    Connection connection = MyConnection.getInstance();
    private static LoginDAO loginDAO;
    public static LoginDAO getInstance() {
        if (loginDAO == null) {
            loginDAO = new LoginDAO();
        }
        return loginDAO;
    }
    private final String CHECK_SIGN_IN = "select * from users where userName = ? and password = ?;";

    private final String CHECK_SIGN_UP = "select * from users where userName = ?;";

    private final String INSERT_INTO_SIGN_UP = "insert into users(userName, password, phoneNumber, email, address) value(?,?,?,?,?);";
    public Users login(String userName, String password) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(CHECK_SIGN_IN)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Users(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        Role.valueOf(resultSet.getString(3)),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Users checkSignUp(String userName) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(CHECK_SIGN_UP)) {
            preparedStatement.setString(1, userName);
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

    public void singUp(String userName, String password, String phoneNumber, String email, String address) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SIGN_UP)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
