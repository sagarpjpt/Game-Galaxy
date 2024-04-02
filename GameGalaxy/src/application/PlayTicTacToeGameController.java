package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.InsertDataDB;
import gametictactoe.TicTacToeFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayTicTacToeGameController {

	@FXML
	Label TicTacToeGameWarningLabel;
	
	@FXML
	TextField TicTacToeGamePlayer1TextField;

	@FXML
	TextField TicTacToeGamePlayer2TextField;
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void tictactoePlayButton(ActionEvent event) throws IOException {
		
		String playerX = TicTacToeGamePlayer1TextField.getText();
		String player0 = TicTacToeGamePlayer2TextField.getText();
		int winner ;	//1 means playerX won 0 means player0 won
		
		if(isValidName(playerX) && isValidName(player0)) {
			
			TicTacToeFrame tictactoeframe = new TicTacToeFrame(playerX,player0);
			winner = tictactoeframe.getWinner();
			System.out.println(winner);
			
			try {
				InsertDataDB.insertToTicTacTable(playerX, player0, winner);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			root = FXMLLoader.load(getClass().getResource("TicTacToePage.fxml"));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		
		}
		else {
			TicTacToeGameWarningLabel.setText("Please Enter Valid Name!");
		}
		
	}
	
	private static boolean isValidName(String name) {
        // Regular expression to match only alphabetic characters and spaces
        String regex = "^[a-zA-Z ]+$";
        
        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(name);

        // Check if the string matches the pattern
        return matcher.matches();
    }
	
}
