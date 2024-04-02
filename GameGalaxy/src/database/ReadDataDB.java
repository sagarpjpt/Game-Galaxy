package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDataDB {
	
	private static Connection connection;
	
	static {
		connection = DBConnector.getConnection();
	}
	
	public static void readFromSnakeTable() throws SQLException {
		
		String tablename = "snake_game";
		
		//sql querry
		String sql = "SELECT * FROM " + tablename;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			ResultSet rslt = stmt.executeQuery();
			
			while(rslt.next()) {
				int id = rslt.getInt("idsnake_game");
				String player_name = rslt.getString("player_name");
				int score = rslt.getInt("score");
				Date date = rslt.getDate("date");
				
				System.out.println("id: " + id + ", Player: " + player_name + ", Score: " + score + ", Date: " + date);
			}
		}
	}
	
	public static void readFromJavaQuizTable() throws SQLException {
		
		String tablename = "java_quiz_game";
		
		//sql querry
		String sql = "SELECT * FROM " + tablename;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			ResultSet rslt = stmt.executeQuery();
			
			while(rslt.next()) {
				int id = rslt.getInt("idjava_quiz_game");
				String player_name = rslt.getString("player_name");
				int score = rslt.getInt("score");
				Date date = rslt.getDate("date");
				
				System.out.println("id: " + id + ", Player: " + player_name + ", Score: " + score + ", Date: " + date);
			}
		}
	}
	
	public static void readFromPaddleTable() throws SQLException {
		
		String tablename = "paddle_game";
		
		//sql querry
		String sql = "SELECT * FROM " + tablename;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			ResultSet rslt = stmt.executeQuery();
			
			while(rslt.next()) {
				int id = rslt.getInt("idpaddle_game");
				String playerRed = rslt.getString("player_red");
                String playerBlue = rslt.getString("player_blue");
                int playerRedScore = rslt.getInt("player_red_score");
                int playerBlueScore = rslt.getInt("player_blue_score");
                String winner = rslt.getString("winner");
                Date date = rslt.getDate("date");
				
				System.out.println("id: " + id + ", Player Red: " + playerRed +
                        ", Player Blue: " + playerBlue +
                        ", Red Score: " + playerRedScore +
                        ", Blue Score: " + playerBlueScore +
                        ", Winner: " + winner +
                        ", Date: " + date);
			}
		}
	}
	
	public static void readFromTicTacTable() throws SQLException {
		
		String tablename = "tic_tac_game";
		
		//sql querry
		String sql = "SELECT * FROM " + tablename;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			ResultSet rslt = stmt.executeQuery();
			
			while(rslt.next()) {
				int id = rslt.getInt("idtic_tac");
				String playerX = rslt.getString("player_x");
                String playerO = rslt.getString("player_o");
                String winner = rslt.getString("winner");
                Date date = rslt.getDate("date");

                // Process the retrieved data as needed
                System.out.println("id: " + id + ", Player X: " + playerX +
                                   ", Player O: " + playerO +
                                   ", Winner: " + winner +
                                   ", Date: " + date);
			}
		}
	}
}
