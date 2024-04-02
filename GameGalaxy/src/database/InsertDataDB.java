package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertDataDB {

    private static Connection connection;

    static {
        connection = DBConnector.getConnection();
    }

    public static void insertToSnakeTable(String player_name, int score) throws SQLException {
        String tablename = "snake_game";
        Date sqlDate = Date.valueOf(DBConnector.getDate()); // convert to java sql database

        // sql query
        String sql = "INSERT INTO " + tablename + " (player_name, score, date) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, player_name);
            stmt.setInt(2, score);
            stmt.setDate(3, sqlDate);

            // execute query
            stmt.executeUpdate();
            System.out.println("\n\n\t\t________data in snake game table inserted successfully_________");
            
        }
        
    }
    
    public static void insertToJavaQuizTable(String player_name, int score) throws SQLException {
        String tablename = "java_quiz_game";
        Date sqlDate = Date.valueOf(DBConnector.getDate()); // convert to java sql database

        // sql query
        String sql = "INSERT INTO " + tablename + " (player_name, score, date) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, player_name);
            stmt.setInt(2, score);
            stmt.setDate(3, sqlDate);

            // execute query
            stmt.executeUpdate();
            System.out.println("\n\n\t\t________data in java quiz table inserted successfully_________");
        }
    }
    
    public static void insertToPaddleTable(String player_red,String player_blue,ArrayList<Integer> data) throws SQLException {
        String tablename = "paddle_game";
        Date sqlDate = Date.valueOf(DBConnector.getDate()); // convert to java sql database

        // sql query
        String sql = "INSERT INTO " + tablename + " (player_red, player_blue, player_red_score, player_blue_score, winner, date) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, player_red);
            stmt.setString(2, player_blue);
            stmt.setInt(3, data.get(0));
            stmt.setInt(4, data.get(1));
            if(data.get(2) == 1) {
            	stmt.setString(5, player_red);
            }
            if(data.get(2) == 0) {
            	stmt.setString(5, player_blue);
            }
            stmt.setDate(6, sqlDate);

            // execute query
            stmt.executeUpdate();
            System.out.println("\n\n\t\t________data in paddle table inserted successfully_________");
        }
    }
    
    public static void insertToTicTacTable(String player_x,String player_o,int winner) throws SQLException {
        String tablename = "tic_tac_game";
        Date sqlDate = Date.valueOf(DBConnector.getDate()); // convert to java sql database

        // sql query
        String sql = "INSERT INTO " + tablename + " (player_x, player_o, winner, date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, player_x);
            stmt.setString(2, player_o);
            
            if(winner == 1) {
            	stmt.setString(3, player_x);
            }
            if(winner == 0) {
            	stmt.setString(3, player_o);
            }
            
            stmt.setDate(4, sqlDate);

            // execute query
            stmt.executeUpdate();
            System.out.println("\n\n\t\t________data in tic tac table inserted successfully_________");
        }
    }
}
