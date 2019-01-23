package com.epam.webapp.connection;

import com.epam.webapp.exception.DataBaseConnectionCreationException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

public class ConnectionFactory {
    private static final String PATH_TO_PROPERTIES = "/config.properties";

    private String name ;
    private  String password ;
    private String url;

   public ConnectionFactory() {
        try {
            Properties prop = new Properties();
            InputStream fileInputStream = getClass().getResourceAsStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            name = prop.getProperty("login");
            password = prop.getProperty("password");
            url = prop.getProperty("baseUrl");
            String driver = prop.getProperty("driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            throw new DataBaseConnectionCreationException(e.getMessage(), e);
        }
    }

    public Connection createConnection() {
        try {
            return DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            throw new DataBaseConnectionCreationException(e.getMessage(), e);
        }
    }
}
