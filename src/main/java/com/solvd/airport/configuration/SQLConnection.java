package com.solvd.airport.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnection {

    public static Connection getConnection() {
        Connection conn = null;

        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/db.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            conn = DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
