package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBConnector {

    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/gamegalaxy";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    static {
        try {
            // loading the jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establishing connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize the database connection.");
        }
    }

    // return connection
    public static Connection getConnection() {
        return connection;
    }

    // return date
    public static LocalDate getDate() {
        return LocalDate.now();
    }
}
