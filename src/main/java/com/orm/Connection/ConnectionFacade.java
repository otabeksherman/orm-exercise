package com.orm.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ConnectionFacade {
    private static Logger logger = LogManager.getLogger(ConnectionFacade.class);

    private static final String DATA_BASE = "user_data";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    public static java.sql.Connection getConnection() {
        try {
            logger.info("Connection Started");
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + DATA_BASE, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDataBase() {
        return DATA_BASE;
    }
}
