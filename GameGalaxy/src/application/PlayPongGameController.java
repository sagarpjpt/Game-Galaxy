package application;

import gamepong.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.InsertDataDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class PlayPongGameController {
	@FXML
	Label PongGameWarningLabel;
	
	@FXML
	TextField PongGamePlayerRedTextField;
	
	@FXML
	TextField PongGamePlayerBlueTextField;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void pongGamePlayButton(ActionEvent event) throws IOException {
		
		String playerRed = PongGamePlayerRedTextField.getText();
		String playerBlue = PongGamePlayerBlueTextField.getText();
		
		//at index 0 has playerRed Score at index 1 has playerBlue Score
		//at index 3 has winner 1 -- means red has won 0 -- means blue has won, 
		ArrayList<Integer> data = new ArrayList<Integer>(); 
		
		//int winner ;	// 1 means player red won 0 means player blue
	
		if(isValidName(playerRed) && isValidName(playerBlue)) {
			
			PongGameFrame ponggameframe = new PongGameFrame(playerRed,playerBlue);
			data = ponggameframe.getWinner();
			
			System.out.println(data);
			
			try {
				InsertDataDB.insertToPaddleTable(playerRed, playerBlue, data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			root = FXMLLoader.load(getClass().getResource("PongGamePage.fxml"));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		
		}
		else {
			PongGameWarningLabel.setText("Please Enter Valid Name!");
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
