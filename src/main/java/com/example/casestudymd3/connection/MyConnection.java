package com.example.casestudymd3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static Connection connection;
    public static Connection getInstance() {
        if (connection == null) {
            connection = getConnection();
        }
        return connection;
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/music?useSSL=false";
            String username = "root";
            String password = "1234";
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
