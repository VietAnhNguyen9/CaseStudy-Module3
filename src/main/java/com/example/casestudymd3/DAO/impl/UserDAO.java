package com.example.casestudymd3.DAO.impl;

import com.example.casestudymd3.DAO.IUserDAO;
import com.example.casestudymd3.connection.MyConnection;
import com.example.casestudymd3.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static UserDAO userDAO;
    public static UserDAO getInstance(){
        if (userDAO == null) {
            userDAO = new UserDAO();
        } return userDAO;
    }
    private final String SELECT_ALL = "select * from users;";
    private final String SELECT_BY_ID = "select * from users where userId = ?;";
    private final String INSERT_INTO = "insert into users(userName) value (?);";
    private final String UPDATE_BY_ID = "update users set userName = ? where userId = ?;";
    private final String DELETE_BY_ID = "delete from users where userId = ?;";
    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users findOne(int id) {
        Users users = null;
        try (PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idDB = resultSet.getInt("userId");
                String name = resultSet.getString("userName");
                users = new Users(idDB, name);
            }
        } catch (SQLException e) {
            e.getStackTrace();

        }
        return users;
    }

    @Override
    public void create(Users users) {

    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void delete(int id) {

    }
}
