package com.epam.webapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionFactory {
    public  Connection createConnection() {
        String name = "root";
        String password = "MySQL";
        String url = "jdbc:mysql://localhost:3306/buber";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, name, password);

        } catch (ClassNotFoundException | SQLException e) {
           throw new IllegalStateException(e);
        }

    }
}
